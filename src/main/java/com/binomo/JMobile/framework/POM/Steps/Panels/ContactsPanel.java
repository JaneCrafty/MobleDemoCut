package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class ContactsPanel extends BaseElements {

    public abstract ContactsPanel checkContactsPanel();

    public abstract MobileElement getPhoneNumberElement();

    public abstract MobileElement getEmailElement();


    public ContactsPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isPhoneNumberExists() {
        return tryDisplayed(getPhoneNumberElement());
    }

    public boolean isBackButtonExists() {
        return tryDisplayed(getBackButton());
    }

    public boolean isEmailExists() {
        return tryDisplayed(getEmailElement());
    }
}
