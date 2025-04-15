package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class UserProfilePanel extends BaseElements {

    public abstract MobileElement getNameTextField();

    public abstract MobileElement getSurnameTextField();

    public abstract MobileElement getPhoneTextField();

    public abstract MobileElement getEmailTextField();

    public abstract MobileElement getSavePopup();

    public abstract MobileElement getBirthdayTextField();

    public abstract MobileElement getDataPickerOkButton();

    public abstract UserProfilePanel checkUserProfilePanel();

    public abstract AccountTab clickSaveProfileContentToAccountTabButton();

    public abstract AccountTab clickBackKeyboardButtonToAccountTab();


    public UserProfilePanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isSaveChangesPopupExists() {
        return tryDisplayed(getSavePopup());
    }

    public Boolean isUsernameFieldEnabled() {
        return isEnabled(getNameTextField());
    }

    public Boolean isEmailFieldEnabled() {
        return isEnabled(getEmailTextField());
    }

    public Boolean isSurnameFieldEnabled() {
        return isEnabled(getSurnameTextField());
    }

    public Boolean isBirthdayFieldEnabled() {
        return isEnabled(getBirthdayTextField());
    }

    public String getUsernameText() {
        return tryGetText(getNameTextField());
    }

    public String getEmailText() {
        return tryGetText(getEmailTextField());
    }

    public String getSurnameText() {
        return tryGetText(getSurnameTextField());
    }

    public String getPhoneText() {
        return tryGetText(getPhoneTextField());
    }

    public String getSaveChangesPopupText() {
        return tryGetText(getSavePopup());
    }

    public String getSavedDateText() {
        return tryGetText(getBirthdayTextField());
    }

    public UserProfilePanel clearAndSetUserName(String name) {
        clearAndSendKeys(getNameTextField(), name);
        return this;
    }

    public UserProfilePanel clearAndSetSurname(String surname) {
        clearAndSendKeys(getSurnameTextField(), surname);
        return this;
    }

    public UserProfilePanel clearAndSetEmail(String email) {
        clearAndSendKeys(getEmailTextField(), email);
        return this;
    }

    public UserProfilePanel clickBirthdayField() {
        tryClick(getBirthdayTextField());
        return this;
    }

    public UserProfilePanel clickDataPickerOkButton() {
        tryClick(getDataPickerOkButton());
        return this;
    }
}
