package com.example.JMobile.framework.POM.PagesIOS.PopUps;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.PopUps.NextStatusProgressPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

public class NextStatusProgressPopUpIOS extends NextStatusProgressPopUp {

    @iOSXCUITFindBy(id = "nextStatusProgressRoot")
    private IOSElement _nextStatusProgressPopUp;

    @iOSXCUITFindBy(id = "header")
    private IOSElement _popUpHeader;

    @iOSXCUITFindBy(id = "description")
    private IOSElement _popUpDescription;

    @iOSXCUITFindBy(id = "primaryButton")
    private IOSElement _topUpButton;

    @iOSXCUITFindBy(id = "secondaryButton")
    private IOSElement _keepDemoAccButton;

    @iOSXCUITFindBy(accessibility = "CardDismissView")
    private IOSElement _touchOutside;


    public NextStatusProgressPopUpIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getPopUpHeader() { return _popUpHeader; }

    public IOSElement getPopUpDescription() { return _popUpDescription; }

    public IOSElement getTopUpButton() { return _topUpButton; }

    public IOSElement getKeepDemoAccButton() { return _keepDemoAccButton; }


    @Step("Нажать кнопку Top Up")
    public CashierDepositPage clickTopUpButton() {
        tryClick(_topUpButton);
        return new CashierDepositPageIOS(mobileDriver);
    }

    @Step("Нажать кнопку Keep demo account")
    public TradingPage clickKeepDemoAccButton() {
        tryClick(_keepDemoAccButton);
        return new TradingPageIOS(mobileDriver);
    }

    public TradingPage swipeForClosingPopUp() {
        swipeDownForClosingPanel(_nextStatusProgressPopUp);
        return new TradingPageIOS(mobileDriver);
    }

    public TradingPage tapForClosingPopUp() {
        tryClick(_touchOutside);
        return new TradingPageIOS(mobileDriver);
    }
}
