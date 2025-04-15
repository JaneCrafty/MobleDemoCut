package com.example.JMobile.framework.POM.PagesIOS.Pages;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.Steps.Pages.SignInPage;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Pages.WelcomePage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomePageIOS extends WelcomePage {

    @iOSXCUITFindBy(accessibility = "WelcomeScreenView")
    private IOSElement _welcomePage;

    @iOSXCUITFindBy(id = "logo_activity_indicator")
    private IOSElement _welcomePageLogo;

    @iOSXCUITFindBy(id = "image_onboarding_demo")
    private IOSElement _welcomePageStories;

    @iOSXCUITFindBy(accessibility = "SignUpButton")
    private IOSElement _signUpButton;

    @iOSXCUITFindBy(accessibility = "LoginButton")
    private IOSElement _signInButton;

    @iOSXCUITFindBy(id = "snackbar_text")
    private IOSElement _successfulDeleteAccountPopUp;


    public WelcomePageIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getWelcomePageLogo() { return _welcomePageLogo; }

    public IOSElement getWelcomePageStories() { return _welcomePageStories; }

    public IOSElement getSignUpButton() { return _signUpButton; }

    public IOSElement getSignInButton() { return _signInButton; }

    public IOSElement getSuccessfulDeleteAccountPopUp() { return _successfulDeleteAccountPopUp; }


    @Step("Проверить появление welcome page")
    public WelcomePageIOS checkWelcomePage() {
        getWaitWithTimeout(30).withMessage("WelcomePage page is Undisplayed").until(d ->
                isDisplayed(_welcomePage));
        return this;
    }

    @Step("Нажать кнопку sign up")
    public SignUpPage clickSignUpButton() {
        getWait().withMessage("SignUp button is not clickable").until(d ->
                ExpectedConditions.elementToBeClickable(_signUpButton));
        tryClickWithWait(_signUpButton);
        return new SignUpPageIOS(mobileDriver);
    }

    @Step("Нажать кнопку Log in")
    public SignInPage clickSignInButton() {
        getWait().withMessage("LogIn button is not clickable").until(d ->
                ExpectedConditions.elementToBeClickable(_signInButton));
        tryClickWithWait(_signInButton);
        return new SignInPageIOS(mobileDriver);
    }

    @Step("Зарегистрироваться и перейти на FTT актив")
    public TradingPage signUpToBinaryTradeRoom(String _email, String _password) {
        TradingPage tradingPage = signUp(_email, _password);
        if (tradingPage.isPostSignUpModalViewExists()) {
            tradingPage.clickPostSignUpModalCloseButton();
        }

        tradingPage.selectBinaryZarOstAsset();
        tradingPage.waitClosingPopUp(3);

        return new TradingPageIOS(mobileDriver);
    }

    @Step("Зарегистрироваться и перейти на CFD актив")
    public TradingPage signUpToCFDTraderoom(String _emailNewUser, String _password) {
        TradingPage tradingPage = signUp(_emailNewUser, _password);
        if (tradingPage.isPostSignUpModalViewExists()) {
            tradingPage.clickPostSignUpModalCloseButton();
        }

        tradingPage.selectCFDEurUsdAsset();
        tradingPage.waitClosingPopUp(3);

        return new TradingPageIOS(mobileDriver);
    }

    @Step("Авторизоваться и перейти на FTT актив")
    public TradingPage signInToBinaryTradeRoom(String _email, String _password) {
        TradingPage tradingPage = signIn(_email, _password)
                .selectBinaryZarOstAsset();
        tradingPage.waitClosingPopUp(3);

        return new TradingPageIOS(mobileDriver);
    }

}
