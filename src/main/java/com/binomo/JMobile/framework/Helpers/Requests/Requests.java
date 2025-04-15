package com.example.JMobile.framework.Helpers.Requests;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.openqa.selenium.remote.http.HttpMethod;

import java.time.Instant;

import static com.example.JMobile.framework.Helpers.CrmHelper.getCRMAuthzToken;
import static com.example.JMobile.framework.Helpers.DataRetrievalHelper.getUserAuthz;
import static com.example.JMobile.framework.POM.MobileElementActions.logger;
import static com.example.JMobile.framework.SumSubSync.SumSubApiMethods.createSignature;
import static com.example.JMobile.framework.SumSubSync.SumSubApiMethods.requestBodyToBytes;

public class Requests {

    private static final String SUM_SUB_BASE_URL = System.getProperty("sumsub_test_base_url", "");
    private static final String SUM_SUB_APP_TOKEN = System.getProperty("sumsub_app_token", "");

    public static Response sendGet(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        return sendRequest(request);
    }

    public static Response sendGetToPlatform(String url, String email, String password) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("authorization-token", getUserAuthz(email, password))
                .addHeader("Device-Id", "201681c9be95b8f66dc97e8e713a6338")
                .addHeader("Device-Type", "web")
                .build();
        return sendRequest(request);
    }

    public static Response sendGetToCRM(String url) throws Exception {
        String crmAuthzToken = getCRMAuthzToken();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("authorization-token", crmAuthzToken)
                .addHeader("Cookie", "crm_authz_token=" + crmAuthzToken + ";")
                .build();
        return sendRequest(request);
    }

    public static Response sendGetToSumSub(String url) throws Exception {
        long ts = Instant.now().getEpochSecond();

        Request request = new Request.Builder()
                .url(SUM_SUB_BASE_URL + url)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("X-App-Token", SUM_SUB_APP_TOKEN)
                .addHeader("X-App-Access-Sig", createSignature(ts, HttpMethod.GET, url, null))
                .addHeader("X-App-Access-Ts", String.valueOf(ts))
                .build();

        return sendRequest(request);
    }

    public static Response sendPost(String url, RequestBody requestBody) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        return sendRequest(request);
    }

    public static Response sendPostToPlatform(String url, RequestBody requestBody) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("Device-Id", "201681c9be95b8f66dc97e8e713a6338")
                .addHeader("Device-Type", "web")
                .build();
        return sendRequest(request);
    }

    public static Response sendPostToCRM(String url, RequestBody requestBody) throws Exception {
        String crmAuthzToken = getCRMAuthzToken();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("authorization-token", crmAuthzToken)
                .addHeader("Cookie", "crm_authz_token=" + crmAuthzToken + ";")
                .build();
        return sendRequest(request);
    }

    public static Response sendPostToSumSub(String url, RequestBody requestBody) throws Exception {
        long ts = Instant.now().getEpochSecond();

        Request request = new Request.Builder()
                .url(SUM_SUB_BASE_URL + url)
                .post(requestBody)
                .addHeader("X-App-Token", SUM_SUB_APP_TOKEN)
                .addHeader("X-App-Access-Sig", createSignature(ts, HttpMethod.POST, url, requestBodyToBytes(requestBody)))
                .addHeader("X-App-Access-Ts", String.valueOf(ts))
                .build();

        return sendRequest(request);
    }

    public static Response sendPutToPlatform(String url, RequestBody requestBody, String email, String password) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .addHeader("authorization-token", getUserAuthz(email, password))
                .addHeader("Device-Id", "201681c9be95b8f66dc97e8e713a6338")
                .addHeader("Device-Type", "web")
                .build();
        return sendRequest(request);
    }

    public static Response sendPutToCRM(String url, RequestBody requestBody) throws Exception {
        String crmAuthzToken = getCRMAuthzToken();

        Request request = new Request.Builder()
                .url(url)
                .put(requestBody)
                .addHeader("authorization-token", crmAuthzToken)
                .addHeader("Cookie", "crm_authz_token=" + crmAuthzToken + ";")
                .build();
        return sendRequest(request);
    }

    public static Response sendDeleteToCrm(String url, RequestBody requestBody) throws Exception {
        String crmAuthzToken = getCRMAuthzToken();

        Request request = new Request.Builder()
                .url(url)
                .delete(requestBody)
                .addHeader("authorization-token", crmAuthzToken)
                .addHeader("Cookie", "crm_authz_token=" + crmAuthzToken + ";")
                .build();
        return sendRequest(request);
    }

    public static Response sendPatchToCrm(String url, RequestBody requestBody) throws Exception {
        String crmAuthzToken = getCRMAuthzToken();

        Request request = new Request.Builder()
                .url(url)
                .patch(requestBody)
                .addHeader("authorization-token", crmAuthzToken)
                .addHeader("Cookie", "crm_authz_token=" + crmAuthzToken + ";")
                .build();
        return sendRequest(request);
    }

    public static Response sendRequest(Request request) throws Exception {
        try {
            Response response = new OkHttpClient().newCall(request).execute();

            if (response.code() != 200)
                logger.warn("Response body = " + response.body().string());

            return response;

        } catch (Exception ex) {
            throw new Exception("Failed to send request. The method crashed with the message: " + ex.getMessage());
        }
    }
}
