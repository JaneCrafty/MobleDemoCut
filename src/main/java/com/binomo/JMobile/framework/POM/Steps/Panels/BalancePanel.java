package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.Enums.AccountTypes;
import com.example.JMobile.framework.Enums.Currency;
import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.Helpers.EnumHelper;
import com.example.JMobile.framework.Helpers.StringHelper;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public abstract class BalancePanel extends BaseElements {

    public abstract MobileElement getAccountTypeCarol();

    public abstract MobileElement getAccountBalanceList();

    public abstract MobileElement getAccountBalanceElement();

    public abstract MobileElement getAccountBalanceAmountCarol();

    public abstract MobileElement getAccountsHeader();

    public abstract MobileElement getDemoAccountBalanceElementFromDropdown();

    public abstract MobileElement getTournamentAccountBalanceFromDropdown();

    public abstract MobileElement getRealAccountBalanceElementFromDropdown();

    public abstract MobileElement getDemoAccountBalanceAmountElementFromDropdown();

    public abstract BalancePanel clickRefillDemoBalanceButton();

    public abstract boolean isOpenDepositPageButtonExists();

    public abstract boolean isBalanceRefreshButtonExists();

    public abstract CashierDepositPage clickOpenDepositPageButton();

    public abstract CashierDepositPage clickOpenDepositNativePageButton();

    public BalancePanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isBalancePanelDisplayed() { return tryDisplayed(getAccountBalanceList()); }

    public boolean isRealAccountBalanceElementExists() { return tryDisplayed(getRealAccountBalanceElementFromDropdown()); }

    public boolean isDemoAccountBalanceElementExists() { return tryDisplayed(getDemoAccountBalanceElementFromDropdown()); }

    public String getAccountBalance() {
        return tryGetText(getAccountBalanceAmountCarol());
    }

    public String getTypeAccountBalance() {
        return tryGetText(getAccountTypeCarol());
    }

    public String getDemoAccountBalanceAmount() {
        return tryGetText(getDemoAccountBalanceAmountElementFromDropdown());
    }

    public String getBalance(AccountTypes accountType) {
        String balance =
                accountType.equals(AccountTypes.DEMO) ?
                        tryGetText(getDemoAccountBalanceElementFromDropdown()) :
                        tryGetText(getRealAccountBalanceElementFromDropdown());
        return balance;
    }

    public String getAccountsHeaderText() {
        return tryGetText(getAccountsHeader());
    }

    public AccountTypes getCurrentAccountType() {
        String currentAcc;
        currentAcc = tryGetText(getAccountTypeCarol());
        String demoAcc = AccountTypes.getAccountType(AccountTypes.DEMO);
        AccountTypes accountType = currentAcc.equals(demoAcc) ? AccountTypes.DEMO : AccountTypes.REAL;
        return accountType;
    }

    public Currency getCurrentAccountCurrency() {
        String currentAcc = tryGetText(getAccountBalanceAmountCarol());
        String currentCurrency = StringHelper.getCurrency(currentAcc);
        Currency returnCurrency = EnumHelper.GetCurrency(currentCurrency);

        return returnCurrency;
    }

    public void openAccountsPanel() {
        tryClick(getAccountBalanceElement());
    }

    public void chooseAccountType(AccountTypes accountType) {
        if (accountType.equals(AccountTypes.DEMO)) {
            tryClickWithWait(getDemoAccountBalanceElementFromDropdown());
        } else if (accountType.equals(AccountTypes.REAL)) {
            tryClickWithWait(getRealAccountBalanceElementFromDropdown());
        } else {
            tryClickWithWait(getTournamentAccountBalanceFromDropdown());
        }
    }

    public void clickCloseAccountsPanel() {
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.Android) {
            tryClick(getAccountBalanceElement());
        }
        new TouchAction(mobileDriver.getDriver()).tap(ElementOption.point(1840, 100)).perform();
    }
}
