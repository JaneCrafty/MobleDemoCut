package com.example.JMobile.framework.DataProviders;

import com.example.JMobile.framework.Helpers.StringHelper;

public class TestData {
    private static String _randomInvestment = StringHelper.GetRandomInvestment();
    private static String _randomIndicatorPeriod = StringHelper.GetRandomIndicatorPeriod();
    private static String _randomIndicatorShortPeriod = StringHelper.GetRandomIndicatorFieldSetting(2, 50);
    private static String _randomIndicatorOffset = StringHelper.GetRandomIndicatorFieldSetting(1, 60);

    public static String getRandomInvestment() {
        return _randomInvestment;
    }

    public static String getRandomIndicatorPeriod() {
        return _randomIndicatorPeriod;
    }

    public static String getRandomIndicatorShortPeriod() {
        return _randomIndicatorShortPeriod;
    }

    public static String getRandomIndicatorOffset() {
        return _randomIndicatorOffset;
    }

}




