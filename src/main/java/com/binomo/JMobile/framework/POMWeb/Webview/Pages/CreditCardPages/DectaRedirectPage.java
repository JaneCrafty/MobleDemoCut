package com.example.JMobile.framework.POMWeb.Webview.Pages.CreditCardPages;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DectaRedirectPage extends MobileElementActions {

    @FindBy(id = "pan-1")
    private MobileElement _cardNumberInput;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "CloseButton")
    private MobileElement _goNavigateUpButton;


    public DectaRedirectPage(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public TradingPage clickBackToTraderoomButton() {
        mobileDriver.SetContext(true);
        getWait().until(ExpectedConditions.visibilityOf(_cardNumberInput));
        mobileDriver.makeScreen();
        mobileDriver.SetContext(false);
        tryClickWithWait(_goNavigateUpButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new TradingPageIOS(mobileDriver);
        } else {
            return new TradingPageAndroid(mobileDriver);
        }
    }
}
