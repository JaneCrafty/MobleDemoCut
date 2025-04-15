package com.example.JMobile.framework.POM.PagesAndroid.PopUps;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.PopUps.NextStatusProgressPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class NextStatusProgressPopUpAndroid extends NextStatusProgressPopUp {

    @AndroidFindBy(id = "nextStatusProgressRoot")
    private AndroidElement _nextStatusProgressPopUp;

    @AndroidFindBy(id = "header")
    private AndroidElement _popUpHeader;

    @AndroidFindBy(id = "description")
    private AndroidElement _popUpDescription;

    @AndroidFindBy(id = "primaryButton")
    private AndroidElement _topUpButton;

    @AndroidFindBy(id = "secondaryButton")
    private AndroidElement _keepDemoAccButton;


    public NextStatusProgressPopUpAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getPopUpHeader() { return _popUpHeader; }

    public AndroidElement getPopUpDescription() { return _popUpDescription; }

    public AndroidElement getTopUpButton() { return _topUpButton; }

    public AndroidElement getKeepDemoAccButton() { return _keepDemoAccButton; }


    @Step("Нажать кнопку Top Up")
    public CashierDepositPage clickTopUpButton() {
        tryClick(_topUpButton);
        return new CashierDepositPageAndroid(mobileDriver);
    }

    @Step("Нажать кнопку Keep demo account")
    public TradingPage clickKeepDemoAccButton() {
        tryClick(_keepDemoAccButton);
        return new TradingPageAndroid(mobileDriver);
    }

    public TradingPage swipeForClosingPopUp() {
        swipeDownForClosingPanel(_nextStatusProgressPopUp);
        return new TradingPageAndroid(mobileDriver);
    }

    public TradingPage tapForClosingPopUp() {
        clickOutsidePanel();
        return new TradingPageAndroid(mobileDriver);
    }
}
