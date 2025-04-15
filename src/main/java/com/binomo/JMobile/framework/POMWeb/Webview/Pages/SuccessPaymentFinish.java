package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.PagesAndroid.PopUps.NextStatusFullScreenPopUpAndroid;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.PagesIOS.PopUps.NextStatusFullScreenPopUpIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.BonusesPanel;
import com.example.JMobile.framework.POM.Steps.Panels.TransactionDetailPanel;
import com.example.JMobile.framework.POM.Steps.PopUps.NextStatusFullScreenPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPaymentFinish extends MobileElementActions {

    @FindBy(id = "qa_cashier_goTransctionDetalies")
    private MobileElement _goTransactionDetailsButton;

    @FindBy(id = "qa_cashier_goTradingButton")
    private MobileElement _startTradingButton;

    @FindBy(id = "first-message-container")
    private MobileElement _preloaderAlert;


    public SuccessPaymentFinish(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public TradingPage clickStartTradingButton() {
        mobileDriver.SetContext(true);
        if (isDisplayed(_preloaderAlert, 0)) {
            getWaitWithTimeout(30).until(absenceOf(_preloaderAlert));
        }

        WebScrollToElement(_startTradingButton);
        tryClickWithWait(_startTradingButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            mobileDriver.SetContext(false);
            return new TradingPageIOS(mobileDriver);
        } else {
            mobileDriver.SetContext(false);
            return new TradingPageAndroid(mobileDriver);
        }
    }

    public TransactionDetailPanel clickGoToTransactionDetailsButton() {
        mobileDriver.SetContext(true);
        if (isDisplayed(_preloaderAlert, 0)) {
            getWaitWithTimeout(30).until(absenceOf(_preloaderAlert));
        }
        getWaitWithTimeout(30).until(ExpectedConditions.visibilityOf(_goTransactionDetailsButton));
        WebScrollToElement(_goTransactionDetailsButton);
        tryClick(_goTransactionDetailsButton);
        mobileDriver.SetContext(false);

        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new TransactionDetailPanelIOS(mobileDriver);
        } else {
            return new TransactionDetailPanelAndroid(mobileDriver);
        }
    }

    public NextStatusFullScreenPopUp clickStartTradingButtonToStatusPopUp() {
        mobileDriver.SetContext(true);
        getWaitWithTimeout(30).until(ExpectedConditions.visibilityOf(_startTradingButton));
        WebScrollToElement(_startTradingButton);
        tryClick(_startTradingButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            mobileDriver.SetContext(false);
            return new NextStatusFullScreenPopUpIOS(mobileDriver);
        } else {
            mobileDriver.SetContext(false);
            return new NextStatusFullScreenPopUpAndroid(mobileDriver);
        }
    }

    public BonusesPanel clickStartTradingButtonToBonusesPanel() {
        mobileDriver.SetContext(true);
        getWaitWithTimeout(30).until(ExpectedConditions.visibilityOf(_startTradingButton));
        WebScrollToElement(_startTradingButton);
        tryClick(_startTradingButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            mobileDriver.SetContext(false);
            return new BonusesPanelIOS(mobileDriver);
        } else {
            mobileDriver.SetContext(false);
            return new BonusesPanelAndroid(mobileDriver);
        }
    }
}
