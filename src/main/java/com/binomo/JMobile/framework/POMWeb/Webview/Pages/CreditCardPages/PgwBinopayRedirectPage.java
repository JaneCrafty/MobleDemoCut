package com.example.JMobile.framework.POMWeb.Webview.Pages.CreditCardPages;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.TransactionDetailPanel;
import com.example.JMobile.framework.POMWeb.Webview.Pages.SuccessPaymentFinish;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class PgwBinopayRedirectPage extends MobileElementActions {

    @FindBy(id = "account")
    private MobileElement _cardNumberInput;

    @FindBy(css = "button[value='success']")
    private MobileElement _successButton;

    @FindBy(css = "button[value='processing']")
    private MobileElement _pendingButton;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "CloseButton")
    private MobileElement _goNavigateUpButton;


    public PgwBinopayRedirectPage(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public SuccessPaymentFinish successfulDeposit() {
        getWait().withMessage("PgwBinopayRedirectPage did not load")
                .until(ExpectedConditions.visibilityOf(_successButton));
        try {
            synchronized (getWait()) {
                getWait().wait(Duration.ofSeconds(5).toMillis());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tryClick(_successButton);
        return new SuccessPaymentFinish(mobileDriver);
    }

    public SuccessPaymentFinish pendingDeposit() {
        getWait().withMessage("PgwBinopayRedirectPage did not load")
                .until(ExpectedConditions.visibilityOf(_pendingButton));
        try {
            synchronized (getWait()) {
                getWait().wait(Duration.ofSeconds(5).toMillis());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tryClick(_pendingButton);
        return new SuccessPaymentFinish(mobileDriver);
    }

    public TradingPage clickBackToTraderoomButton() {
        mobileDriver.SetContext(true);
        getWait().until(ExpectedConditions.visibilityOf(_cardNumberInput));
        mobileDriver.SetContext(false);
        tryClick(_goNavigateUpButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new TradingPageIOS(mobileDriver);
        } else {
            return new TradingPageAndroid(mobileDriver);
        }
    }

    public TransactionDetailPanel getTransactionPanel() {
        mobileDriver.SetContext(false);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new TransactionDetailPanelIOS(mobileDriver);
        } else {
            return new TransactionDetailPanelAndroid(mobileDriver);
        }
    }
}
