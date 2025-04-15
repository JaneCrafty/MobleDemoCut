package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class TransactionsHistoryPanel extends BaseElements {

    public abstract MobileElement getTransactionsHistoryPanel();

    public abstract MobileElement getWalletIcon();

    public abstract MobileElement getWithdrawalButton();

    public abstract MobileElement getDepositButton();

    public abstract MobileElement getEmptyTransactions();

    public abstract MobileElement getBalanceContainerTitle();

    public abstract MobileElement getRealAccount();

    public abstract boolean isCalendarExists();

    public abstract CashierWithdrawalPage clickWithdrawalButton();

    public abstract CashierDepositPage clickDepositButton();

    public abstract NativeCashierDepositPageAndroid clickDepositNativeButton();

    public abstract TransactionDetailPanel clickDepositTransaction();

    public abstract TransactionDetailPanel clickWithdrawalTransaction();


    public TransactionsHistoryPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public TransactionsHistoryPanel checkTransactionsHistoryPanel() {
        getWait().withMessage("Transactions History Panel is not displayed").until(d ->
                isDisplayed(getTransactionsHistoryPanel()));
        return this;
    }

    public boolean isWalletIconExists() {
        return tryDisplayed(getWalletIcon());
    }

    public boolean isWithdrawalButtonExists() {
        return tryDisplayed(getWithdrawalButton());
    }

    public boolean isDepositButtonExists() {
        return tryDisplayed(getDepositButton());
    }

    public boolean isEmptyTransactionsExists() {
        return isExistWithWait(getEmptyTransactions());
    }

    public String getTitleText() {
        return tryGetText(getBalanceContainerTitle());
    }

    public String getRealAccountText() {
        return tryGetText(getRealAccount());
    }
}
