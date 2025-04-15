package com.example.JMobile.framework.Enums;

import com.example.JMobile.framework.environment.PropertyHolder;

public enum Activity {
    TRADING_PAGE("com.example.broker.modules.trading.TradingActivity"),
    TRADING_PAGE_VIP("com.example.broker.modules.trading.VipTradingActivity"),
    CASHIER_PAGE("com.example.broker.modules.cashier.CashierActivity"),
    NATIVE_CASHIER_PAGE("com.example.broker.modules.nativecashier.NativeCashierActivity"),
    BALANCE_PANEL("PopupWindow"),
    SPLASH_SCREEN("com.example.broker.modules.splash.SplashScreenActivity"),
    HELP_CENTER_PAGE("org.chromium.chrome.browser.customtabs.CustomTabActivity"),
    STATIC_PAGE("org.chromium.chrome.browser.customtabs.CustomTabActivity");

    private final String activityString;

    Activity(String activityString) {
        this.activityString = activityString;
    }

    public String get() {
        String pack = PropertyHolder.getPropertyValues().appPackage;
        switch (pack) {
            case "com.marketly.trading":
                return activityString.replace("com.example.broker", "");
            case "com.example.broker.beta":
            case "com.example.vipbroker.beta":
            default:
                return activityString;

        }
    }
}


