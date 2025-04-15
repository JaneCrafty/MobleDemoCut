package com.example.JMobile.framework.Enums;

import com.example.JMobile.framework.environment.PropertyValues;

public enum AccountTypes {
    DEMO("Demo account", "demo_ru_изменить"),
    REAL("Real account", "real_ru_изменить"),
    TOURNAMENT("[AUTOTEST] free tournament", "");

    private final String _en;
    private final String _ru;

    AccountTypes(String en, String ru) {
        _en = en;
        _ru = ru;
    }

    public static String getAccountType(AccountTypes acc) {
        String returnAccount;

        switch (PropertyValues.locale) {
            case EN:
                returnAccount = acc.getEN();
                break;

            case RU:
                returnAccount = acc.getRU();
                break;

            default:
                returnAccount = "err";
        }

        return returnAccount;
    }

    public String getEN() {
        return _en;
    }

    public String getRU() {
        return _ru;
    }
}