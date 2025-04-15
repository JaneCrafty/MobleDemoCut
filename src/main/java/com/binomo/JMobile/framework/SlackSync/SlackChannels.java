package com.example.JMobile.framework.SlackSync;

public class SlackChannels {
    private static final String nativeTestsSlackChannel = "mobile-autotests";
    private static final String frontendTestsSlackChannel = "cashier-autotests";

    public static String getNativeTestsSlackChannel() {
        return nativeTestsSlackChannel;
    }

    public static String getFrontendTestsSlackChannel() {
        return frontendTestsSlackChannel;
    }
}
