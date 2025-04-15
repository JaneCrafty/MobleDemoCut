package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class TimeframePanel extends BaseElements {

    protected abstract MobileElement getTimeframe1s();

    protected abstract MobileElement getBlitzLabel();

    public abstract TradingPage select5sTimeframe();

    public abstract TradingPage select1sTimeframe();

    public abstract TradingPage select15sTimeframe();

    public abstract TradingPage select1mTimeframe();

    public abstract TradingPage select5mTimeframe();

    public abstract TradingPage select15mTimeframe();

    public abstract TradingPage select30mTimeframe();

    public abstract TradingPage select1hTimeframe();

    public abstract int getCountOfTimeframes();


    public TimeframePanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isTimeframe1sExists() {
        return tryDisplayed(getTimeframe1s());
    }

    public String getBlitzLabelText() {
        return tryGetText(getBlitzLabel());
    }
}
