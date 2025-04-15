package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class NextStatusProgressPopUp extends BaseElements {

    protected abstract MobileElement getPopUpHeader();

    protected abstract MobileElement getPopUpDescription();

    protected abstract MobileElement getTopUpButton();

    protected abstract MobileElement getKeepDemoAccButton();

    public abstract CashierDepositPage clickTopUpButton();

    public abstract TradingPage clickKeepDemoAccButton();

    public abstract TradingPage swipeForClosingPopUp();

    public abstract TradingPage tapForClosingPopUp();


    public NextStatusProgressPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isTopUpButtonExists() {
        return tryDisplayed(getTopUpButton());
    }

    public boolean isKeepDemoAccButtonExists() {
        return tryDisplayed(getKeepDemoAccButton());
    }

    public String getPopUpHeaderText() {
        return tryGetText(getPopUpHeader());
    }

    public String getPopUpDescriptionText() {
        return tryGetText(getPopUpDescription());
    }

}
