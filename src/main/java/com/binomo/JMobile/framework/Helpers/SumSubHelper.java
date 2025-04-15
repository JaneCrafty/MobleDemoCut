package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.SumSubSync.model.DocType;
import com.example.JMobile.framework.SumSubSync.model.Metadata;
import okhttp3.*;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.io.File;

import static com.example.JMobile.framework.Helpers.Requests.Requests.sendGetToSumSub;
import static com.example.JMobile.framework.Helpers.Requests.Requests.sendPostToSumSub;
import static com.example.JMobile.framework.POM.MobileElementActions.logger;
import static com.example.JMobile.framework.SumSubSync.SumSubApiMethods.*;

public class SumSubHelper {

    private static int getResponseCode(String url, RequestBody requestBody) {
        int responseCode = 0;
        int retry = 10;

        while (responseCode != 200 && retry > 0) {
            try {
                try (Response response = sendPostToSumSub(url, requestBody)) {
                    responseCode = response == null ? 0 : response.code();
                }
            } catch (Exception ex) {
                logger.info(ex.getMessage());
            }
            retry--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return responseCode;
    }


    public static void addDocumentImage(String userID, String firstName, String lastName, String dateOfBirth) throws Exception {
        String applicantId = getApplicantID(userID);
        String url = "/resources/applicants/" + applicantId + "/info/idDoc";

        File doc = getSumSubImage();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("metadata", objectMapper.writeValueAsString(new Metadata(DocType.PASSPORT, "AFG", firstName, lastName, "123456789", dateOfBirth)))
                .addFormDataPart("content", doc.getName(), RequestBody.create(MediaType.parse("image/*"), doc))
                .build();
        int responseCode = getResponseCode(url, requestBody);
        if (responseCode != 200) {
            throw new Exception("Impossible to add id document");
        }
    }

    public static void addPurseImage(String userID) throws Exception {
        String actionId = getActionID(userID);
        String url = "/resources/applicantActions/" + actionId + "/images";

        File doc = getSumSubImage();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("metadata", objectMapper.writeValueAsString(new Metadata(DocType.PAYMENT_METHOD, "AFG")))
                .addFormDataPart("content", doc.getName(), RequestBody.create(MediaType.parse("image/*"), doc))
                .build();
        int responseCode = getResponseCode(url, requestBody);
        if (responseCode != 200) {
            throw new Exception("Impossible to add purse document");
        }
    }

    public static void setPendingStatusID(String userID) throws Exception {
        String applicantId = getApplicantID(userID);
        String url = "/resources/applicants/" + applicantId + "/status/pending";
        RequestBody requestBody = RequestBody.create(null, new byte[0]);

        int responseCode = getResponseCode(url, requestBody);
        if (responseCode != 200) {
            throw new Exception("Impossible to set pending status for id");
        }
    }

    public static int setPendingStatusPurse(String userID) throws Exception {
        String actionId = getActionID(userID);
        String url = "/resources/applicantActions/" + actionId + "/review/status/pending";
        RequestBody requestBody = RequestBody.create(null, new byte[0]);
        return getResponseCode(url, requestBody);
    }

    public static int setGreenStatusID(String userID, String firstName, String lastName, String dateOfBirth) throws Exception {
        addDocumentImage(userID, firstName, lastName, dateOfBirth);
        String applicantId = getApplicantID(userID);
        String url = "/resources/applicants/" + applicantId + "/status/testCompleted";

        String json = new JSONObject()
                .put("reviewAnswer", "GREEN")
                .put("rejectLabels", new JSONArray())
                .toString();
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), json);

        return getResponseCode(url, requestBody);
    }

    public static int setGreenStatusPurse(String userID) throws Exception {
        String actionId = getActionID(userID);
        return setGreenStatusPurseWithActionId(actionId);
    }

    public static int setGreenStatusSecondPurse(String userID) throws Exception {
        String actionId = getActionID2(userID);
        return setGreenStatusPurseWithActionId(actionId);
    }

    private static int setGreenStatusPurseWithActionId(String actionId) throws Exception {
        String url = "/resources/applicantActions/" + actionId + "/reviewResult";
        String json = new JSONObject()
                .put("reviewAnswer", "GREEN")
                .put("rejectLabels", new JSONArray())
                .toString();
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), json);
        return getResponseCode(url, requestBody);
    }


    public static int setRetryStatusID(String userID, String firstName, String lastName, String dateOfBirth) throws Exception {
        String applicantId = getApplicantID(userID);
        String url = "/resources/applicants/" + applicantId + "/status/testCompleted";
        String json = new JSONObject()
                .put("reviewAnswer", "RED")
                .put("moderationComment", "We do not accept screenshots. Please upload an original photo.")
                .put("reviewRejectType", "RETRY")
                .put("rejectLabels", new JSONArray()
                        .put("UNSATISFACTORY_PHOTOS")
                        .put("SCREENSHOTS"))
                .toString();
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), json);
        return getResponseCode(url, requestBody);
    }

    public static int setRetryStatusPurse(String userID) throws Exception {
        String actionId = getActionID(userID);
        String url = "/resources/applicantActions/" + actionId + "/reviewResult";
        String json = new JSONObject()
                .put("reviewAnswer", "RED")
                .put("moderationComment", "We do not accept screenshots. Please upload an original photo.")
                .put("reviewRejectType", "RETRY")
                .put("rejectLabels", new JSONArray()
                        .put("UNSATISFACTORY_PHOTOS")
                        .put("SCREENSHOTS"))
                .toString();

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), json);

        return getResponseCode(url, requestBody);
    }

    public static int setRejectStatusID(String userID, String firstName, String lastName, String dateOfBirth) throws Exception {
        String applicantId = getApplicantID(userID);
        String url = "/resources/applicants/" + applicantId + "/status/testCompleted";

        String json = new JSONObject()
                .put("reviewAnswer", "RED")
                .put("moderationComment", "We could not verify your profile. Please contact support: support@sumsub.com")
                .put("reviewRejectType", "FINAL")
                .put("rejectLabels", new JSONArray()
                        .put("UNSATISFACTORY_PHOTOS")
                        .put("GRAPHIC_EDITOR")
                        .put("FORGERY"))
                .toString();

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), json);

        return getResponseCode(url, requestBody);
    }

    public static int setRejectStatusPurse(String userID) throws Exception {
        String actionId = getActionID(userID);
        String url = "/resources/applicantActions/" + actionId + "/reviewResult";
        String json = new JSONObject()
                .put("reviewAnswer", "RED")
                .put("moderationComment", "We could not verify your profile. Please contact support: support@sumsub.com")
                .put("reviewRejectType", "FINAL")
                .put("rejectLabels", new JSONArray()
                        .put("UNSATISFACTORY_PHOTOS")
                        .put("GRAPHIC_EDITOR")
                        .put("FORGERY"))
                .toString();

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), json);
        return getResponseCode(url, requestBody);
    }

    public static String getApplicantStatus(String userID) {
        try {
            String applicantId = getApplicantID(userID);

            Response response = sendGetToSumSub("/resources/applicants/" + applicantId + "/requiredIdDocsStatus");

            ResponseBody responseBody = response.body();
            response.close();

            return responseBody != null ? responseBody.string() : null;

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static String getApplicantStatusPurse(String userID) {
        try {
            String actionId = getActionID(userID);

            Response response = sendGetToSumSub("/resources/applicantActions/" + actionId + "/one");

            ResponseBody responseBody = response.body();
            response.close();

            return responseBody != null ? responseBody.string() : null;

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }
}

