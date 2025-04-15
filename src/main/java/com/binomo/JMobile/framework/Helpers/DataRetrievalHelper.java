package com.example.JMobile.framework.Helpers;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.codehaus.jettison.json.JSONObject;

import static com.example.JMobile.framework.Helpers.Requests.Requests.sendPostToPlatform;

public class DataRetrievalHelper {

    private static final String appBranchName = System.getProperty("appBranchName", "");
    private static final String BASE_API_URL = appBranchName.substring(0, 8) + "api." + appBranchName.substring(8);

    public static String getUserId(String email, String password) throws Exception {
        try {
            String json = new JSONObject()
                    .put("email", email)
                    .put("password", password)
                    .toString();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

            Response response = sendPostToPlatform(BASE_API_URL + "/passport/v2/sign_in?locale=en", requestBody);

            String responseBody = response.body().string();
            response.close();
            JSONObject jsonResponse = new JSONObject(responseBody);

            return jsonResponse.getJSONObject("data").getString("user_id");

        } catch (Exception ex) {
            throw new Exception("Failed to get user ID. The method crashed with the message: " + ex.getMessage());
        }
    }

    public static String getUserAuthz(String email, String password) throws Exception {
        try {
            String json = new JSONObject()
                    .put("email", email)
                    .put("password", password)
                    .toString();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

            Response response = sendPostToPlatform(BASE_API_URL + "/passport/v2/sign_in?locale=en", requestBody);

            String responseBody = response.body().string();
            response.close();
            JSONObject jsonResponse = new JSONObject(responseBody);

            return jsonResponse.getJSONObject("data").getString("authtoken");

        } catch (Exception ex) {
            throw new Exception("Failed to get authtoken. The method crashed with the message: " + ex.getMessage());
        }
    }
}

