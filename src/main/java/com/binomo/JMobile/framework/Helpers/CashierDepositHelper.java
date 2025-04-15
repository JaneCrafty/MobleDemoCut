package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.DataProviders.CreditCardProvider;
import io.qameta.allure.Step;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class CashierDepositHelper {

    private static final String appBranchName = System.getProperty("appBranchName", "");

    @Step("Пополнить счет пользователя (эмуляция по api)")
    public static void successfulDepositEmulation(String email, String password, int amount) throws Exception {
        int responseCode = 0;
        int retry = 10;
        String userID = DataRetrievalHelper.getUserId(email, password);
        String cardNumber = CreditCardProvider.getEmulatedSuccessCard().getCardNumber();
        amount = amount * 100;

        while (responseCode != 200 && retry > 0) {
            try {
                try (Response response = sendPost("/api/payments/cashier/test_card" +
                                "?user_id=" + userID + "&card_number=" + cardNumber + "&amount=" + amount,
                        RequestBody.create(null, new byte[0]))) {

                    responseCode = response.code();
                    if (response.body() != null) {
                        logger.info("deposit emulation result: " + response.body().string());
                    }
                }

            } catch (Exception ex) {
                logger.warn(ex.getMessage());
            }
            retry--;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (responseCode != 200) {
            throw new RuntimeException("Impossible to emulate successful deposit. Response code = " + responseCode);
        }
        logger.info("Successful deposit emulation");
    }

    private static Response sendPost(String url, RequestBody requestBody) throws Exception {
        try {
            Request request = new Request.Builder()
                    .url(appBranchName + url)
                    .post(requestBody)
                    .build();

            Response response = new OkHttpClient().newCall(request).execute();

            if (response.code() != 200)
                logger.warn("Response body  = " + response.body().string());

            return response;

        } catch (Exception ex) {
            throw new Exception("Failed to post request. Method crashed with message: " + ex.getMessage());
        }
    }
}
