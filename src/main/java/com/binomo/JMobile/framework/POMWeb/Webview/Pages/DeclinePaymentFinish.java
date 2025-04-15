package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeclinePaymentFinish extends MobileElementActions {

    @FindBy(id = "qa_cashier_pagePaymentsDecline")
    private MobileElement _declinePaymentPage;

    @FindBy(id = "qa_cashier_declineMessage")
    private MobileElement _declineMessage;


    public DeclinePaymentFinish(MobileDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
        getWait().withMessage("Decline payment page did not show")
                .until(ExpectedConditions.visibilityOf(_declinePaymentPage));
    }


    public String getDeclineMessageText() {
        return tryGetText(_declineMessage);
    }
}
