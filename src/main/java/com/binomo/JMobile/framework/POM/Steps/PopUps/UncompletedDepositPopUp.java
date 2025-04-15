package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.ChatPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class UncompletedDepositPopUp extends BaseElements {

    public abstract MobileElement getPaymentStatusHeader();

    public abstract MobileElement getPaymentStatusMessage();

    public abstract MobileElement getContactSupportButton();

    public abstract MobileElement getClosePopupButton();

    public abstract boolean isPaymentStatusImageIconExists();

    public abstract TradingPage clickClosePopupButton();

    public abstract ChatPanel clickContactSupportButton();


    public UncompletedDepositPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isPaymentStatusHeaderExists() {
        return tryDisplayed(getPaymentStatusHeader());
    }

    public boolean isPaymentStatusMessageExists() {
        return tryDisplayed(getPaymentStatusMessage());
    }

    public boolean isContactSupportButtonExists() {
        return tryDisplayed(getContactSupportButton());
    }

    public boolean isClosePopupButtonExists() {
        return tryDisplayed(getClosePopupButton());
    }

    public String getPaymentStatusHeaderText() {
        return tryGetText(getPaymentStatusHeader());
    }

    public String getPaymentStatusMessageText() {
        return tryGetText(getPaymentStatusMessage());
    }
}
