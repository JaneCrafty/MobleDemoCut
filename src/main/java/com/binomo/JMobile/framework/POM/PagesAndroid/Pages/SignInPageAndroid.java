package com.example.JMobile.framework.POM.PagesAndroid.Pages;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesVip.SignInPageVip;
import com.example.JMobile.framework.POM.PagesVip.TradingPageVip;
import com.example.JMobile.framework.POM.Steps.Pages.SignInPage;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class SignInPageAndroid extends SignInPage implements SignInPageVip {

    @AndroidFindBy(id = "signInRoot")
    private AndroidElement _signInPage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/signInContent']/android.widget.LinearLayout/android.widget.TextView[1]")
    private AndroidElement _pageHeader;

    @AndroidFindBy(id = "emailField")
    private AndroidElement _emailTextField;

    @AndroidFindBy(id = "passwordField")
    private AndroidElement _passwordTextField;

    @AndroidFindBy(id = "forgotPasswordButton")
    private AndroidElement _forgotPasswordButton;

    @AndroidFindBy(id = "signInButton")
    private AndroidElement _signInButton;

    @AndroidFindBy(id = "signUpButton")
    private AndroidElement _registerButton;

    @AndroidFindBy(id = "button_facebook_login")
    private AndroidElement _FBsignInButton;


    public SignInPageAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getPageHeader() {
        return _pageHeader;
    }

    public AndroidElement getEmailTextField() {
        return _emailTextField;
    }

    public AndroidElement getPasswordTextField() {
        return _passwordTextField;
    }

    public AndroidElement getForgotPasswordButton() {
        return _forgotPasswordButton;
    }

    public AndroidElement getSignInButton() {
        return _signInButton;
    }

    public AndroidElement getRegisterButton() {
        return _registerButton;
    }

    public AndroidElement getFacebookAuthButton() {
        return _FBsignInButton;
    }


    @Step("Проверить открытие панели авторизации")
    public SignInPageAndroid checkSignInPage() {
        getWait().withMessage("SignIn page is not displayed").until(d ->
                isDisplayed(_signInPage));
        return this;
    }

    @Step("Нажать кнопку Sign in")
    public TradingPage clickSignInButton() {
        tryClick(_signInButton);
        return new TradingPageAndroid(mobileDriver);
    }

    public PasswordRecoveryPage clickPasswordRecoveryButton() {
        tryClick(_forgotPasswordButton);
        return new PasswordRecoveryPageAndroid(mobileDriver);
    }

    public SignUpPage clickRegisterButton() {
        tryClick(_registerButton);
        return new SignUpPageAndroid(mobileDriver);
    }

    public WelcomePageAndroid clickNavigateUpButton() {
        clickBackButton();
        return new WelcomePageAndroid(mobileDriver);
    }

    @Step("Ввести данные для авторизации")
    public TradingPage login(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickSignInButton();
    }

    @AndroidFindBy(id = "emailField")
    public AndroidElement emailFieldVip;
    @AndroidFindBy(id = "passwordField")
    public AndroidElement passwordFieldVip;

    @Override
    public SignInPageVip fillEmailVip(String email) {
        sendKeys(emailFieldVip, email);
        return this;
    }

    @Override
    public SignInPageVip fillPasswordVip(String password) {
        sendKeys(passwordFieldVip, password);
        return this;
    }

    @Override
    public SignInPageVip step(String stepName) {
        logger.info(stepName);
        Allure.step(stepName);
        return this;
    }

    @Override
    public TradingPageVip clickLoginButtonVip() {
        checkSignInPage();
        clickSignInButton();
        return new TradingPageAndroid(mobileDriver);
    }
}
