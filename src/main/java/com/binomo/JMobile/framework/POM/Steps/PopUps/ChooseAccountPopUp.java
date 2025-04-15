package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class ChooseAccountPopUp extends BaseElements {

    protected abstract MobileElement getModalIcon();

    protected abstract MobileElement getModalTitle();

    protected abstract MobileElement getModalSubTitle();

    protected abstract MobileElement getRealAccButton();

    protected abstract MobileElement getDemoAccButton();

    public abstract TradingPage clickRealAccButton();

    public abstract TradingPage clickDemoAccButton();


    public ChooseAccountPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isModalIconExists() {
        return tryDisplayed(getModalIcon());
    }

    public boolean isRealAccButtonExists() {
        return tryDisplayed(getRealAccButton());
    }

    public boolean isDemoAccButtonExists() {
        return tryDisplayed(getDemoAccButton());
    }

    public String getModalTitleText() {
        return tryGetText(getModalTitle());
    }

    public String getModalSubTitleText() {
        return tryGetText(getModalSubTitle());
    }
}


