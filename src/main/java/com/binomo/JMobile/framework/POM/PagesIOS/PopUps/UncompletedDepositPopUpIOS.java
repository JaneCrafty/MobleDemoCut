package com.example.JMobile.framework.POM.PagesIOS.PopUps;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.ChatPanel;
import com.example.JMobile.framework.POM.Steps.PopUps.UncompletedDepositPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class UncompletedDepositPopUpIOS extends UncompletedDepositPopUp {

    @iOSXCUITFindBy(accessibility = "popup_currency")
    private IOSElement _paymentStatusImageIcon;

    @iOSXCUITFindBy(accessibility = "TitleLabel")
    private IOSElement _paymentStatusHeader;

    @iOSXCUITFindBy(accessibility = "SubtitleLabel")
    private IOSElement _paymentStatusMessage;

    @iOSXCUITFindBy(accessibility = "SupportButton")
    private IOSElement _contactSupportButton;

    @iOSXCUITFindBy(accessibility = "CloseButton")
    private IOSElement _closePopupButton;


    public UncompletedDepositPopUpIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getPaymentStatusHeader() { return _paymentStatusHeader; }

    public IOSElement getPaymentStatusMessage() { return _paymentStatusMessage; }

    public IOSElement getContactSupportButton() { return _contactSupportButton; }

    public IOSElement getClosePopupButton() { return _closePopupButton; }


    public boolean isPaymentStatusImageIconExists() {
        return tryDisplayed(_paymentStatusImageIcon);
    }

    public TradingPage clickClosePopupButton() {
        tryClick(_closePopupButton);
        return new TradingPageIOS(mobileDriver);
    }

    public ChatPanel clickContactSupportButton() {
        tryClick(_contactSupportButton);
        return new ChatPanelIOS(mobileDriver);
    }
}
