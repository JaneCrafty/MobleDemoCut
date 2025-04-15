package com.example.JMobile.framework.POM.PagesAndroid.Pages;

import com.example.JMobile.framework.Enums.SwipeDirection;
import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesVip.SignInPageVip;
import com.example.JMobile.framework.POM.PagesVip.WelcomePageVip;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Pages.WelcomePage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WelcomePageAndroid extends WelcomePage implements WelcomePageVip {

    @AndroidFindBy(id = "welcomeStoriesRoot")
    private AndroidElement _welcomePage;

    @AndroidFindBy(id = "logoImage")
    private AndroidElement _welcomePageLogo;

    @AndroidFindBy(id = "storyRoot")
    private AndroidElement _welcomePageStories;

    @AndroidFindBy(id = "signUpButton")
    private AndroidElement _signUpButton;

    @AndroidFindBy(id = "logInButton")
    private AndroidElement _signInButton;

    @AndroidFindBy(id = "snackbar_text")
    private AndroidElement _successfulDeleteAccountPopUp;

    @AndroidFindBy(id = "trialButton")
    private AndroidElement _tryTrialButton;

    @AndroidFindBy(id = "image")
    private AndroidElement _storyImage;


    public WelcomePageAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getWelcomePageLogo() {
        return _welcomePageLogo;
    }

    public AndroidElement getWelcomePageStories() {
        return _welcomePageStories;
    }

    public AndroidElement getSignInButton() {
        return _signInButton;
    }

    public AndroidElement getSignUpButton() {
        return _signUpButton;
    }

    public AndroidElement getSuccessfulDeleteAccountPopUp() {
        return _successfulDeleteAccountPopUp;
    }


    @Override
    public void checkWelcomePageVip() {
        checkWelcomePage();
    }

    @AndroidFindBy(id = "title")
    private AndroidElement _storyTitle;

    @AndroidFindBy(id = "touchArea")
    private AndroidElement _storyTouchArea;

    @Override
    public void checkWelcomeStories(Set<String> stories) {
        getWait()
                .withTimeout(Duration.ofSeconds(30))
                .withMessage("Welcome stories are not displayed").until(d ->
                        isDisplayed(_welcomePageStories));

        Set<String> actualStories = new HashSet<>();
        String initialText = tryGetText(_storyTitle);
        actualStories.add(initialText);

        for (int i = 0; i < 30; i++) {
            String storyText = tryGetText(_storyTitle);
            actualStories.add(storyText);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        assertThat(actualStories)
                .withFailMessage("Welcome stories не совпадают с ожидаемыми, получили %d story: \"%s\", ожидали %d story: \"%s\"",
                        actualStories.size(), String.join("\n", actualStories),
                        stories.size(), String.join("\n", stories))
                .isEqualTo(stories);

    }

    @Step("Проверить появление welcome page")
    public WelcomePageAndroid checkWelcomePage() {
        getWait()
                .withTimeout(Duration.ofSeconds(30))
                .withMessage("Welcome page is not displayed").until(d ->
                        isDisplayed(_welcomePage));
        return this;
    }

    @Step("Нажать кнопку sign up")
    public SignUpPageAndroid clickSignUpButton() {
        tryClickWithWait(_signUpButton);
        return new SignUpPageAndroid(mobileDriver);
    }

    @Step("Нажать кнопку Log in")
    public SignInPageAndroid clickSignInButton() {
        if (isDisplayed(_tryTrialButton)) {
            tryClick(_storyImage);
        }
        tryClickWithWait(_signInButton);
        return new SignInPageAndroid(mobileDriver);
    }

    @Step("Зарегистрироваться и перейти на FTT актив")
    public TradingPage signUpToBinaryTradeRoom(String _email, String _password) {
        TradingPage tradingPage = signUp(_email, _password)
                .selectBinaryZarOstAsset();
        return new TradingPageAndroid(mobileDriver);
    }

    @Step("Зарегистрироваться и перейти на CFD актив")
    public TradingPage signUpToCFDTraderoom(String _emailNewUser, String _password) {
        TradingPage tradingPage = signUp(_emailNewUser, _password)
                .selectCFDEurUsdAsset();
        return new TradingPageAndroid(mobileDriver);
    }

    @Step("Авторизоваться и перейти на FTT актив")
    public TradingPage signInToBinaryTradeRoom(String _email, String _password) {
        TradingPage tradingPage = signIn(_email, _password)
                .selectBinaryZarOstAsset();
        return new TradingPageAndroid(mobileDriver);
    }

    // methods for vip app
    @Override
    public SignInPageVip clickLoginButtonVip() {
        tryClickWithWait(_signInButton);
        return new SignInPageAndroid(mobileDriver);
    }

    @Override
    public WelcomePageVip step(String stepName) {
        logger.info(stepName);
        Allure.step(stepName);
        return this;
    }

    @Override
    public SignInPageVip clickSignupButtonVip() {
        tryClick(_signUpButton);
        return new SignInPageAndroid(mobileDriver);
    }

    @Override
    public void checkWelcomeMessageAbsent() {
        int timeout = 20;
        logger.info("checking in loops that welcome message is absent for {} seconds", timeout);
        try {
            getWait()
                    .withTimeout(Duration.ofSeconds(timeout))
                    .withMessage("Welcome message не было показано").until(d ->
                            isDisplayed(_welcomeMessage));
        } catch (RuntimeException e) {
            if (!e.getMessage().contains("Welcome message не было показано")) {
                logger.info(e.getMessage());
                throw e;
            }
        }

    }


    @AndroidFindBy(id = "welcomeMessage")
    private AndroidElement _welcomeMessage;

    @Override
    public void checkWelcomeMessageText(String text) {
        getWait()
                .withTimeout(Duration.ofSeconds(20))
                .withMessage("Welcome message не было показано").until(d ->
                        isDisplayed(_welcomeMessage));
        String actualMessage = tryGetText(_welcomeMessage);
        assertThat(actualMessage)
                .withFailMessage("Welcome message не совпадает с ожидаемым, получили \"%s\", ожидали \"%s\"",
                        actualMessage, text)
                .isEqualTo(text);
    }
}
