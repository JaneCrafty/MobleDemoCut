package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.DataProviders.UserData;
import io.qameta.allure.Step;
import okhttp3.*;
import org.codehaus.jettison.json.JSONObject;

import java.util.Objects;

import static com.example.JMobile.framework.Helpers.Requests.Requests.*;
import static com.example.JMobile.framework.POM.MobileElementActions.logger;
import static org.assertj.core.api.Assertions.assertThat;

public class CrmHelper {

    private static final String BASE_URL = System.getProperty("appBranchName", "");
    private static final String BASE_CRM_URL = BASE_URL.substring(0, 8) + "crm." + BASE_URL.substring(8);
    private static final String BASE_BIN_ADMIN_URL = System.getProperty("appBranchName", "").replaceAll("example", "sbin-admin");
    private static final String BASE_BIN_ADMIN_API_URL = BASE_BIN_ADMIN_URL.substring(0, 8) + "api." + BASE_BIN_ADMIN_URL.substring(8);

    @Step("Начислить пользователю бонусный купон")
    public static int addUserCoupon(String email, String password, String couponName) {
        int responseCode = 0;
        int retry = 3;

        while (responseCode != 200 && retry > 0) {
            try {
                Response response = sendPostToCRM(BASE_CRM_URL + "/coupons/user_coupons" +
                                "?coupon[coupon_id]=" + getCouponID(couponName) +
                                "&coupon[count]=1" +
                                "&coupon[user_ids]=" + DataRetrievalHelper.getUserId(email, password) +
                                "&coupon[reasons_list]=Winback",
                        RequestBody.create(MediaType.parse("text/plain"), ""));
                responseCode = response.code();
                response.close();

            } catch (Exception ex) {
                logger.warn("Failed to add user coupon. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }

        return responseCode;
    }

    @Step("Получить id купона")
    public static String getCouponID(String couponName) {
        int responseCode = 0;
        int retry = 2;

        while (responseCode != 200 && retry > 0) {
            try {
                Response response = sendGetToCRM(BASE_CRM_URL + "/coupons/user_coupons/new");
                responseCode = response.code();

                if (responseCode == 200) {
                    String responseBody = Objects.requireNonNull(response.body()).string();
                    response.close();
                    responseBody = responseBody.substring(responseBody.indexOf("id=\"coupon_coupon_id\">"), responseBody.indexOf("\">" + couponName + "<"));

                    return responseBody.substring(responseBody.lastIndexOf("=\"") + 2);
                }

            } catch (Exception ex) {
                logger.warn("Failed to get coupon id. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }

        return null;
    }

    @Step("Верифицировать документы пользователя через crm")
    public static void verifyUserDocuments(String email, String password) throws Exception {
        String userId = DataRetrievalHelper.getUserId(email, password);

        sendManualRequestForDocumentVerification(userId);

        assertThat(SumSubHelper.setGreenStatusID(DataRetrievalHelper.getUserId(email, password),
                "firstName",
                "lastName",
                "2000-03-01"))
                .as("Green status ID didn't set").isEqualTo(200);

        sendRequestForManualVerificationOfDocsInStatusApproved(userId);
    }

    @Step("Запросить верификацию документов пользователя вручную через crm")
    private static int sendManualRequestForDocumentVerification(String userId) {
        int responseCode = 0;
        int retry = 2;

        while (responseCode != 200 && retry > 0) {
            try {
                Response response = sendPostToCRM(BASE_BIN_ADMIN_API_URL + "/user-verification/v1/traders/" + userId + "/documents",
                        RequestBody.create(MediaType.parse("text/plain"), ""));
                responseCode = response != null ? response.code() : 0;
                response.close();

            } catch (Exception ex) {
                logger.info("Failed to send verification request. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }

        return responseCode;
    }

    @Step("Подтвердить верификацию документов пользователя вручную через crm")
    private static int sendRequestForManualVerificationOfDocsInStatusApproved(String userId) {
        int responseCode = 0;
        int retry = 2;

        while (responseCode != 200 && retry > 0) {
            try {
                Response response = sendPatchToCrm(BASE_BIN_ADMIN_API_URL + "/user-verification/v1/traders/" + userId + "/documents",
                        RequestBody.create(MediaType.parse("text/plain"), ""));
                responseCode = response != null ? response.code() : 0;
                response.close();

            } catch (Exception ex) {
                logger.info("Failed to send request. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }

        return responseCode;
    }

    public static void deleteUserFromTournament(String email, String password) {
        logger.info("Delete user " + email + " from tournament");
        int responseCode = 0;
        int retry = 2;

        while (responseCode != 200 && retry > 0) {
            try {
                String userID = DataRetrievalHelper.getUserId(email, password);
                String tournamentID = getUserTournamentID(userID);

                RequestBody requestBody = new FormBody.Builder()
                        .add("_method", "delete")
                        .build();

                Response response = sendPostToCRM(BASE_CRM_URL + "/tournaments/" + tournamentID + "/tournament_users/" + getTournamentUserID(userID, tournamentID),
                        requestBody);
                responseCode = response.code();
                response.close();

            } catch (Exception ex) {
                logger.warn("Failed to delete user from tournament. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }
    }

    public static String getUserTournamentID(String userID) {
        logger.info("Get tournament ID user " + userID + " is participating in");
        int responseCode = 0;
        int retry = 2;

        while (responseCode != 200 && retry > 0) {
            try {
                Response response = sendGetToCRM(BASE_CRM_URL + "/users/" + userID + "/tournaments");
                responseCode = response.code();

                if (responseCode == 200) {
                    String responseBody = Objects.requireNonNull(response.body()).string();
                    response.close();

                    responseBody = responseBody.substring(responseBody.indexOf("a href=\"/tournaments/"), responseBody.indexOf("/edit"));

                    return responseBody.replaceAll("a href=\"/tournaments/", "");
                }

            } catch (Exception ex) {
                logger.info("Failed to get user tournament id. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }

        return null;
    }

    public static String getTournamentUserID(String userID, String tournamentID) {
        logger.info("Get tournament user ID");
        int responseCode = 0;
        int retry = 2;

        while (responseCode != 200 && retry > 0) {
            try {
                Response response = sendGetToCRM(BASE_CRM_URL + "/tournaments/" + tournamentID + "/tournament_users");
                responseCode = response.code();

                if (responseCode == 200) {
                    String responseBody = Objects.requireNonNull(response.body()).string();
                    response.close();

                    responseBody = responseBody.substring(responseBody.indexOf(userID));
                    responseBody = responseBody.substring(0, responseBody.indexOf("?refund=true\""));

                    return responseBody.substring(responseBody.lastIndexOf("/") + 1);
                }

            } catch (Exception ex) {
                logger.info("Failed to get user tournament id. The method crashed with the message: " + ex.getMessage());
            }

            retry--;
        }

        return null;
    }


    public static String getCRMAuthzToken() throws Exception {
        try {
            Thread.sleep(1000); //Sometimes the socket connection doesn't keep up with our speed

            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("email", UserData.crmAdminEmail)
                    .addFormDataPart("password", UserData.crmAdminPassword)
                    .build();
            Response response = sendPost(BASE_CRM_URL + "/api/v1/sign_in", body);

            String responseBody = Objects.requireNonNull(response.body()).string();
            response.close();
            JSONObject jsonResponse = new JSONObject(responseBody);

            return jsonResponse.getJSONObject("data").getString("crm_authz_token");

        } catch (Exception ex) {
            throw new Exception("Failed login to CRM. The method crashed with the message: " + ex.getMessage());
        }
    }
}
