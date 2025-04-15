package com.example.JMobile.framework.POM.PagesIOS.Pages;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.Steps.Pages.SignInPage;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPageIOS extends SignInPage {

    @iOSXCUITFindBy(accessibility = "SignInScreenView")
    private IOSElement _signInPage;

    @iOSXCUITFindBy(accessibility = "Welcome back")
    private IOSElement _pageHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"EmailTextField\"]")
    private IOSElement _emailTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"PasswordTextField\"]")
    private IOSElement _passwordTextField;

    @iOSXCUITFindBy(accessibility = "ForgotPasswordButton")
    private IOSElement _forgotPasswordButton;

    @iOSXCUITFindBy(accessibility = "LoginButton")
    private IOSElement _signInButton;

    @iOSXCUITFindBy(accessibility = "RegisterButton")
    private IOSElement _registerButton;

    @iOSXCUITFindBy(id = "button_facebook_login")
    private IOSElement _FBsignInButton;


    public SignInPageIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getPageHeader() { return _pageHeader; }

    public IOSElement getEmailTextField() { return _emailTextField; }

    public IOSElement getPasswordTextField() { return _passwordTextField; }

    public IOSElement getForgotPasswordButton() { return _forgotPasswordButton; }

    public IOSElement getSignInButton() { return _signInButton; }

    public IOSElement getRegisterButton() { return _registerButton; }

    public IOSElement getFacebookAuthButton() { return _FBsignInButton; }


    public SignInPageIOS checkSignInPage() {
        getWaitWithTimeout(30).withMessage("SignIn page is Undisplayed").until(d ->
                isDisplayed(_signInPage));
        return new SignInPageIOS(mobileDriver);
    }

    public TradingPageIOS clickSignInButton() {
        getWaitWithTimeout(30).until(ExpectedConditions.elementToBeClickable(_signInButton));
        tryClick(_signInButton);
        return new TradingPageIOS(mobileDriver);
    }

    public PasswordRecoveryPage clickPasswordRecoveryButton() {
        tryClickWithWait(_forgotPasswordButton);
        return new PasswordRecoveryPageIOS(mobileDriver);
    }

    public SignUpPage clickRegisterButton() {
        tryClickWithWait(_registerButton);
        return new SignUpPageIOS(mobileDriver);
    }

    public WelcomePageIOS clickNavigateUpButton() {
        tryClickWithWait(getNavigateUpButton());
        return new WelcomePageIOS(mobileDriver);
    }

    public TradingPage login(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickSignInButton();
    }

}
