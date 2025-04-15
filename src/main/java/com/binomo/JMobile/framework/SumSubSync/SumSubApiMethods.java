package com.example.JMobile.framework.SumSubSync;

import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.codec.binary.Hex;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.remote.http.HttpMethod;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static com.example.JMobile.framework.Helpers.Requests.Requests.sendGetToSumSub;
import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class SumSubApiMethods {

    private static final String SECRET_KEY = System.getProperty("sumsub_secret_key", "");

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static String createSignature(long ts, HttpMethod httpMethod, String path, byte[] body) {
        try {
            Mac hmacSha256 = Mac.getInstance("HmacSHA256");
            hmacSha256.init(new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            hmacSha256.update((ts + httpMethod.name() + path).getBytes(StandardCharsets.UTF_8));
            byte[] bytes = body == null ? hmacSha256.doFinal() : hmacSha256.doFinal(body);

            return Hex.encodeHexString(bytes);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static byte[] requestBodyToBytes(RequestBody requestBody) {
        try {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            return buffer.readByteArray();

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static String getApplicantID(String userID) {
        try {
            String branch = System.getProperty("platformUrl", "");
            branch = branch.replace("https://", "").replace(".example.com", "");
            String externalUserId = branch + userID;

            Response responseAllData = sendGetToSumSub("/resources/applicants/-/search?q=%2A" + externalUserId + "&limit=10&offset=0");
            logger.info(Objects.requireNonNull(responseAllData.body()).string());
            responseAllData.close();

            Response response = sendGetToSumSub("/resources/applicants/-/search?q=%2A" + externalUserId + "&limit=1&offset=0");

            String responseBody = Objects.requireNonNull(response.body()).string();
            response.close();
            JSONObject jsonResponse = new JSONObject(responseBody);

            return jsonResponse.getJSONObject("list").getJSONArray("items").getJSONObject(0).getString("id");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static String getActionID(String userID) {
        try {
            Response response = sendGetToSumSub("/resources/applicantActions/-;applicantId=" + getApplicantID(userID) + "?limit=1&offset=0");

            String responseBody = Objects.requireNonNull(response.body()).string();
            response.close();
            JSONObject jsonResponse = new JSONObject(responseBody);

            return jsonResponse.getJSONObject("list").getJSONArray("items").getJSONObject(0).getString("id");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static String getActionID2(String userID) {
        try {
            Response response = sendGetToSumSub("/resources/applicantActions/-;applicantId=" + getApplicantID(userID) + "?limit=1&offset=1");

            String responseBody = Objects.requireNonNull(response.body()).string();
            response.close();
            JSONObject jsonResponse = new JSONObject(responseBody);

            return jsonResponse.getJSONObject("list").getJSONArray("items").getJSONObject(0).getString("id");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public static File getSumSubImage() {
        File directory = null;

        try {
            String current = new File(".").getCanonicalPath();
            directory = new File(current + "/SumSubImage/PassportPhoto.jpeg");

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return directory;
    }
}
