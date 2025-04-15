package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class ChartTypePanel extends BaseElements {

    protected abstract MobileElement getChartTypePanel();

    protected abstract MobileElement getChartTypeMountain();

    protected abstract MobileElement getChartTypeLines();

    protected abstract MobileElement getChartTypeCandles();

    protected abstract MobileElement getChartTypeBars();

    protected abstract MobileElement getBlitzLabel();

    public abstract TradingPage selectChartTypeMountain();

    public abstract TradingPage selectChartTypeLines();

    public abstract TradingPage selectChartTypeCandles();

    public abstract TradingPage selectChartTypeBars();


    public ChartTypePanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public ChartTypePanel checkChartTypePanel() {
        getWait().withMessage("Chart type panel is not displayed").until(d ->
                isDisplayed(getChartTypePanel()));
        return this;
    }

    public boolean isChartTypeMountainExists() {
        return tryDisplayed(getChartTypeMountain());
    }

    public boolean isChartTypeLinesExists() {
        return tryDisplayed(getChartTypeLines());
    }

    public boolean isChartTypeCandlesExists() {
        return tryDisplayed(getChartTypeCandles());
    }

    public boolean isChartTypeBarsExists() {
        return tryDisplayed(getChartTypeBars());
    }

    public boolean isChartTypeMountainMissing() {
        return isElementMissing(getChartTypeMountain());
    }

    public boolean isChartTypeLinesMissing() {
        return isElementMissing(getChartTypeLines());
    }

    public boolean isChartTypeCandlesMissing() {
        return isElementMissing(getChartTypeCandles());
    }

    public boolean isChartTypeBarsMissing() {
        return isElementMissing(getChartTypeBars());
    }

    public String getBlitzLabelText() {
        return tryGetText(getBlitzLabel());
    }
}
