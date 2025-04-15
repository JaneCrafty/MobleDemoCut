package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

import java.time.Duration;

public abstract class TransactionDetailPanel extends BaseElements {

    public abstract MobileElement getTransactionDetailContentLayout();

    public abstract MobileElement getTransactionDetailTitle();

    public abstract MobileElement getTransactionIcon();

    public abstract MobileElement getPaymentSystem();

    public abstract MobileElement getPaymentSystemDescription();

    public abstract MobileElement getCurrentTransactionStatusIcon();

    public abstract MobileElement getCurrentTransactionStatus();

    public abstract MobileElement getCurrentTransactionStatusDescription();

    public abstract MobileElement getShowStatusesButton();

    public abstract MobileElement getStatusesInfoItem();

    public abstract MobileElement getFirstStatusIcon();

    public abstract MobileElement getFirstStatusTitle();

    public abstract MobileElement getFirstStatusDescription();

    public abstract MobileElement getSecondStatusIcon();

    public abstract MobileElement getSecondStatusTitle();

    public abstract MobileElement getSecondStatusDescription();

    public abstract MobileElement getSecondStatusInfo();

    public abstract MobileElement getThirdStatusTitle();

    public abstract MobileElement getThirdStatusInfo();

    public abstract MobileElement getFourthStatusIcon();

    public abstract MobileElement getFourthStatusTitle();

    public abstract MobileElement getCopyTransactionIDButton();

    public abstract MobileElement getContactSupportButton();

    public abstract MobileElement getTotalTransactionValue();

    public abstract TransactionSupportAlertPanel clickContactSupportButtonForUnfinishedTime();

    public abstract ChatPanel clickContactSupportButtonForFinishedTime();

    public abstract TradingPage clickBackButton();

    public TransactionDetailPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public TransactionDetailPanel checkTransactionDetailsPanel() {
        getWait().withMessage("Transaction details Panel is not displayed")
                .withTimeout(Duration.ofSeconds(10))
                .until(d ->
                isDisplayed(getTransactionDetailContentLayout()));
        return this;
    }

    public TransactionDetailPanel checkStatusesInfoItem() {
        getWait().withMessage("Statuses info item is not displayed").until(d ->
                isDisplayed(getStatusesInfoItem()));
        return this;
    }

    public Boolean isBackButtonExists() {
        return tryDisplayed(getBackButton());
    }

    public Boolean isTransactionIconExists() {
        return tryDisplayed(getTransactionIcon());
    }

    public Boolean isCurrentTransactionStatusIconExists() {
        return tryDisplayed(getCurrentTransactionStatusIcon());
    }

    public Boolean isFirstStatusIconExists() {
        return tryDisplayed(getFirstStatusIcon());
    }

    public Boolean isSecondStatusIconExists() {
        return tryDisplayed(getSecondStatusIcon());
    }

    public Boolean isFourthStatusIconExists() {
        swipeUntilFoundAndroidPanel(getFourthStatusIcon());
        return tryDisplayed(getFourthStatusIcon());
    }

    public Boolean isCopyTransactionIDButtonExists() {
        return tryDisplayed(getCopyTransactionIDButton());
    }

    public Boolean isContactSupportButtonExists() {
        return tryDisplayed(getContactSupportButton());
    }

    public String getCurrentTransactionStatusText() {
        return tryGetText(getCurrentTransactionStatus());
    }

    public String getCurrentTransactionStatusDescriptionText() {
        return tryGetText(getCurrentTransactionStatusDescription());
    }

    public String getTransactionDetailTitleText() {
        return tryGetText(getTransactionDetailTitle());
    }

    public String getPaymentSystemText() {
        return tryGetText(getPaymentSystem());
    }

    public String getPaymentSystemDescriptionText() {
        return tryGetText(getPaymentSystemDescription());
    }

    public String getFirstStatusTitleText() {
        return tryGetText(getFirstStatusTitle());
    }

    public String getFirstStatusDescriptionText() {
        return tryGetText(getFirstStatusDescription());
    }

    public String getSecondStatusTitleText() {
        return tryGetText(getSecondStatusTitle());
    }

    public String getSecondStatusDescriptionText() {
        return tryGetText(getSecondStatusDescription());
    }

    public String getSecondStatusInfoText() {
        return tryGetText(getSecondStatusInfo());
    }

    public String getThirdStatusTitleText() {
        return tryGetText(getThirdStatusTitle());
    }

    public String getThirdStatusInfoText() {
        return tryGetText(getThirdStatusInfo());
    }

    public String getFourthStatusTitleText() {
        swipeUntilFoundAndroidPanel(getFourthStatusTitle());
        return tryGetText(getFourthStatusTitle());
    }

    public String getTotalTransactionValueText() {
        swipeUntilFoundAndroidPanel(getTotalTransactionValue());
        return tryGetText(getTotalTransactionValue());
    }

    public TransactionDetailPanel clickShowStatusesButton() {
        tryClick(getShowStatusesButton());
        return this;
    }
}
