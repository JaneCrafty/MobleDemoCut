package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class StrikeDealsPanel extends BaseElements {

    public abstract MobileElement getStrikePanelLayout();

    public abstract MobileElement getStrike1();

    public abstract MobileElement getStrike2();

    public abstract MobileElement getStrike3();

    public abstract TradingPage clickCloseButton();

    public abstract TradingPage clickCloseStrikeDealPanel();


    public StrikeDealsPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isStrikePanelMissing() {
        return isElementMissing(getStrikePanelLayout());
    }

    public boolean isStrikeElementsDisplayed() {
        return tryDisplayed(getStrike1()) &&
                tryDisplayed(getStrike2()) &&
                tryDisplayed(getStrike3());
    }

}
