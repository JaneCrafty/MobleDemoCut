package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class SupportPanel extends BaseElements {

    public abstract MobileElement getSupportPanel();

    public abstract MobileElement getChatItem();

    public abstract MobileElement getContactsItem();

    public abstract MobileElement getAgreementItem();

    public abstract ChatPanel clickChatItem();

    public abstract HelpCenterPage clickHelpCenterItem();


    public SupportPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public SupportPanel checkSupportPanel() {
        getWait().withMessage("Support panel is not displayed").until(d ->
                isDisplayed(getSupportPanel()));
        return this;
    }

    public boolean isChatItemExist() {
        return tryDisplayed(getChatItem());
    }

    public boolean isContactsItemExist() {
        return tryDisplayed(getContactsItem());
    }

    public boolean isAgreementItemExist() {
        return tryDisplayed(getAgreementItem());
    }

}
