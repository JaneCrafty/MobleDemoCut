package com.example.JMobile.framework.POM.Steps.Pages;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;


public abstract class SignInPage extends BaseElements {

    protected abstract MobileElement getPageHeader();

    protected abstract MobileElement getEmailTextField();

    protected abstract MobileElement getPasswordTextField();

    protected abstract MobileElement getForgotPasswordButton();

    protected abstract MobileElement getSignInButton();

    protected abstract MobileElement getRegisterButton();

    protected abstract MobileElement getFacebookAuthButton();

    public abstract SignInPage checkSignInPage();

    public abstract TradingPage clickSignInButton();

    public abstract PasswordRecoveryPage clickPasswordRecoveryButton();

    public abstract SignUpPage clickRegisterButton();

    public abstract WelcomePage clickNavigateUpButton();

    public abstract TradingPage login(String email, String password);


    public SignInPage(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isFacebookAuthExists() {
        return tryDisplayed(getFacebookAuthButton());
    }

    public boolean isBackButtonExists() {
        return tryDisplayed(getBackButton());
    }

    public boolean isEmailTextFieldExists() {
        return tryDisplayed(getEmailTextField());
    }

    public boolean isPasswordTextFieldExists() {
        return tryDisplayed(getPasswordTextField());
    }

    public boolean isForgotPasswordButtonExists() {
        return tryDisplayed(getForgotPasswordButton());
    }

    public boolean isSignInButtonExists() {
        return tryDisplayed(getSignInButton());
    }

    public boolean isSignUpButtonExists() {
        return tryDisplayed(getRegisterButton());
    }

    public String getPageHeaderText() {
        return tryGetText(getPageHeader());
    }

    public SignInPage setEmail(String email) {
        sendKeys(getEmailTextField(), email);
        return this;
    }

    public SignInPage setPassword(String password) {
        sendKeys(getPasswordTextField(), password);
        return this;
    }

}
