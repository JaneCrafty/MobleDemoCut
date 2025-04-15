package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class ExpirationTimePanel extends BaseElements {

    protected abstract MobileElement get5sFromExpirationTimeItem();

    protected abstract MobileElement get3mFromExpirationTimeItem();

    protected abstract MobileElement get30mFromExpirationTimeItem();

    protected abstract MobileElement getBlitzLabel();

    public abstract TradingPage click1mFromExpirationTimePanel();

    public abstract TradingPage click2mFromExpirationTimePanel();

    public abstract TradingPage click3mFromExpirationTimePanel();

    public abstract TradingPage click4mFromExpirationTimePanel();

    public abstract TradingPage click5mFromExpirationTimePanel();

    public abstract TradingPage click15mFromExpirationTimePanel();

    public abstract TradingPage click30mFromExpirationTimePanel();

    public abstract TradingPage click45mFromExpirationTimePanel();

    public abstract TradingPage click60mFromExpirationTimePanel();


    public ExpirationTimePanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean is5sFromExpirationTimeItemExists() {
        return tryDisplayed(get5sFromExpirationTimeItem());
    }

    public String get3mFromExpirationTimeText() {
        return tryGetText(get3mFromExpirationTimeItem());
    }

    public String get30mFromExpirationTimeText() {
        return tryGetText(get30mFromExpirationTimeItem());
    }

    public String getBlitzLabelText() {
        return tryGetText(getBlitzLabel());
    }

}
