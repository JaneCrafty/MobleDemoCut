package com.example.JMobile.framework.POM.Steps.Pages;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;


public abstract class WelcomePage extends BaseElements {

    protected abstract MobileElement getWelcomePageLogo();

    protected abstract MobileElement getWelcomePageStories();

    protected abstract MobileElement getSignInButton();

    protected abstract MobileElement getSignUpButton();

    protected abstract MobileElement getSuccessfulDeleteAccountPopUp();

    public abstract WelcomePage checkWelcomePage();

    public abstract SignInPage clickSignInButton();

    public abstract SignUpPage clickSignUpButton();

    public abstract TradingPage signUpToCFDTraderoom(String _emailNewUser, String _password);

    public abstract TradingPage signUpToBinaryTradeRoom(String _email, String _password);

    public abstract TradingPage signInToBinaryTradeRoom(String _email, String _password);


    public WelcomePage(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isWelcomePageLogoExists() {
        return tryDisplayed(getWelcomePageLogo());
    }

    public boolean isWelcomePageStoriesExists() {
        return tryDisplayed(getWelcomePageStories());
    }

    public boolean isSignInButtonExists() {
        return tryDisplayed(getSignInButton());
    }

    public boolean isSignUpButtonExists() {
        return tryDisplayed(getSignUpButton());
    }


    public boolean isDisplayedSuccessfulDeleteAccountPopUp() {
        return tryDisplayed(getSuccessfulDeleteAccountPopUp());
    }

    public String getSuccessfulDeleteAccountPopUpMessageText() {
        return tryGetText(getSuccessfulDeleteAccountPopUp());
    }

    @Step("Зарегистрироваться")
    public TradingPage signUp(String _emailNewUser, String _password) {
        SignUpPage signUpPage = clickSignUpButton()
                .checkSignUpPage();
        return signUpPage.signUp(_emailNewUser, _password);
    }

    @Step("Авторизоваться")
    public TradingPage signIn(String _email, String _password) {
        SignInPage signInPage = clickSignInButton()
                .checkSignInPage();
        return signInPage.login(_email, _password);
    }
}
