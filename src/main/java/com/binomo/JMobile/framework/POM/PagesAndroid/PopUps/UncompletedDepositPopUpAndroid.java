package com.example.JMobile.framework.POM.PagesAndroid.PopUps;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.ChatPanel;
import com.example.JMobile.framework.POM.Steps.PopUps.UncompletedDepositPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class UncompletedDepositPopUpAndroid extends UncompletedDepositPopUp {

    @AndroidFindBy(id = "payment_status_image")
    private AndroidElement _paymentStatusImageIcon;

    @AndroidFindBy(id = "payment_status_header")
    private AndroidElement _paymentStatusHeader;

    @AndroidFindBy(id = "payment_status_message")
    private AndroidElement _paymentStatusMessage;

    @AndroidFindBy(id = "contact_support")
    private AndroidElement _contactSupportButton;

    @AndroidFindBy(id = "close_btn")
    private AndroidElement _closePopupButton;


    public UncompletedDepositPopUpAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getPaymentStatusHeader() { return _paymentStatusHeader; }

    public AndroidElement getPaymentStatusMessage() { return _paymentStatusMessage; }

    public AndroidElement getContactSupportButton() { return _contactSupportButton; }

    public AndroidElement getClosePopupButton() { return _closePopupButton; }


    public boolean isPaymentStatusImageIconExists() {
        return tryDisplayed(_paymentStatusImageIcon);
    }

    public TradingPage clickClosePopupButton() {
        tryClick(_closePopupButton);
        return new TradingPageAndroid(mobileDriver);
    }

    public ChatPanel clickContactSupportButton() {
        tryClick(_contactSupportButton);
        return new ChatPanelAndroid(mobileDriver);
    }
}
