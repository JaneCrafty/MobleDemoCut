package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class StatusesPanel extends BaseElements {

    protected abstract MobileElement getStatusesPanel();

    protected abstract MobileElement getStatusIconElement();

    protected abstract MobileElement getAmountToNextStatusElement();

    protected abstract MobileElement getUpgradeButton();

    protected abstract MobileElement getProgressBar();

    protected abstract MobileElement getInfoStatusesTable();

    protected abstract MobileElement getPrizesRowElement();

    protected abstract MobileElement getHappyHourRowElement();

    protected abstract MobileElement getTournamentsRowElement();

    protected abstract MobileElement getTitleDescriptionTerm();

    protected abstract MobileElement getDescriptionTerm();

    protected abstract MobileElement getTouchOutsideSpace();

    protected abstract MobileElement getDescriptionPopup();

    public abstract CashierDepositPage clickUpgradeButton();
    public abstract NativeCashierDepositPageAndroid clickUpgradeNativeButton();

    public abstract StatusesPanel clickProfitabilityRow();

    public abstract StatusesPanel clickWithdrawalsRow();

    public abstract StatusesPanel clickInsuranceRow();

    public abstract StatusesPanel clickPrizesRow();

    public abstract StatusesPanel clickCashbackRow();

    public abstract StatusesPanel clickRiskFreeRow();

    public abstract StatusesPanel clickDepositBonusRow();

    public abstract StatusesPanel clickPersonalManagerRow();

    public abstract StatusesPanel clickAssetRow();

    public abstract StatusesPanel clickHappyHourRow();

    public abstract StatusesPanel clickTournamentsRow();

    public abstract StatusesPanel tapForClosingRiskFreeDescriptionTerm();


    public StatusesPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public StatusesPanel checkStatusesPanel() {
        getWait().withMessage("Statuses Panel is not displayed").until(d ->
                isDisplayed(getStatusesPanel()));
        return this;
    }

    public boolean isStatusIconElementExists() {
        return tryDisplayed(getStatusIconElement());
    }

    public boolean isAmountToNextStatusElementExists() {
        return tryDisplayed(getAmountToNextStatusElement());
    }

    public boolean isUpgradesButtonExists() {
        return tryDisplayed(getUpgradeButton());
    }

    public boolean isProgressBarExists() {
        return tryDisplayed(getProgressBar());
    }

    public boolean isInfoStatusesTableExists() {
        return tryDisplayed(getInfoStatusesTable());
    }

    public boolean isPrizesRowAbsent() {
        SwipeDownInPanelUntilFound(getPrizesRowElement());
        return isElementMissing(getPrizesRowElement());
    }

    public boolean isTournamentsRowMissing() {
        swipeDownUntilFoundInPanelIos(getHappyHourRowElement());
        return isElementMissing(getTournamentsRowElement());
    }

    public boolean isDescriptionPopupClosed() {
        return isElementMissing(getDescriptionPopup());
    }

    public String getTextTitleDescriptionTerm() {
        return tryGetText(getTitleDescriptionTerm());
    }

    public String getTextDescriptionTerm() {
        return tryGetText(getDescriptionTerm());
    }

    public StatusesPanel tapForClosingDescriptionTerm() {
        tryClick(getTouchOutsideSpace());
        return this;
    }
}
