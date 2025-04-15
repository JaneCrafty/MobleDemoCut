package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.TransactionDetailPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WithdrawalRequestScreen extends MobileElementActions {

    @FindBy(css = "#qa_cashier_withdrawalHeaderNotification")
    private MobileElement _withdrawalTitleMessage;

    @FindBy(css = "#qa_cashier_currentRefill")
    private MobileElement _payoutAmount;

    @FindBy(css = "#qa_goTransactionDetailsButton")
    private MobileElement _goToTransactionDetailsButton;

    @FindBy(id = "qa_withdrawalCancelButton")
    private MobileElement _cancelWithdrawalButton;

    @FindBy(css = "#qa_continueTradingButton")
    private MobileElement _continueTradingButton;

    @FindBy(id = "qa_cancelWithdrawalButton")
    private MobileElement _cancelWithdrawalConfirmationButton;


    public WithdrawalRequestScreen(MobileDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public boolean isWithdrawalTitleMessageDisplayed() {
        return tryDisplayed(_withdrawalTitleMessage);
    }

    public boolean isPayoutAmountDisplayed() {
        return tryDisplayed(_payoutAmount);
    }

    public boolean isGoToTransactionDetailsButtonDisplayed() {
        WebScrollToElement(_goToTransactionDetailsButton);
        return tryDisplayed(_goToTransactionDetailsButton);
    }

    public boolean isCancelWithdrawalButtonDisplayed() {
        WebScrollToElement(_cancelWithdrawalButton);
        return tryDisplayed(_cancelWithdrawalButton);
    }

    public boolean isContinueTradingButtonDisplayed() {
        WebScrollToElement(_continueTradingButton);
        return tryDisplayed(_continueTradingButton);
    }

    public String withdrawalTitleMessage() {
        mobileDriver.SetContext(true);
        getWait().until(ExpectedConditions.visibilityOf(_withdrawalTitleMessage));
        return tryGetText(_withdrawalTitleMessage);
    }

    public void clickCancelWithdrawalButton() {
        tryClickWithWait(_cancelWithdrawalButton);
    }

    public TradingPage clickContinueTradingButton() {
        getWait().until(ExpectedConditions.visibilityOf(_continueTradingButton));
        tryClick(_continueTradingButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            mobileDriver.SetContext(false);
            return new TradingPageIOS(mobileDriver);
        } else {
            mobileDriver.SetContext(false);
            return new TradingPageAndroid(mobileDriver);
        }
    }

    public TransactionDetailPanel clickCancelWithdrawalConfirmationButton() {
        tryClickWithWait(_cancelWithdrawalConfirmationButton);
        mobileDriver.SetContext(false);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new TransactionDetailPanelIOS(mobileDriver);
        } else {
            return new TransactionDetailPanelAndroid(mobileDriver);
        }
    }
}
