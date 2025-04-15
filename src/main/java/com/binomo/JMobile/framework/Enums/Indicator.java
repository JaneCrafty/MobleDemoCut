package com.example.JMobile.framework.Enums;

public enum Indicator {
    ADX("ADX"),
    ATR("ATR"),
    BollingerBands("Bollinger Bands"),
    CCI("CCI"),
    EMA("EMA"),
    IchimokuCloud("Ichimoku Cloud"),
    MACD("MACD"),
    MA("MA"),
    ParabolicSAR("Parabolic SAR"),
    RSI("RSI"),
    SMA("SMA"),
    ScalpPro("Scalp Pro"),
    Stochastic("Stochastic"),
    VWAP("VWAP");

    private final String indicator;

    Indicator(String indicator) {
        this.indicator = indicator;
    }

    public String getValue() {
        return indicator;
    }
}
