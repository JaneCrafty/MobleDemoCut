package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public abstract class PanelUserMenu extends BaseElements {

    public abstract MobileElement getMenuDetailTitle();

    public abstract MobileElement getStatusButton();

    public abstract MobileElement getRateAppButton();

    public abstract MobileElement getUserSettingsIdPanel();

    public abstract MobileElement getDepositButton();

    public abstract MobileElement getNotificationsButton();

    public abstract MobileElement getUserEmailTextField();

    public abstract MobileElement getWhatsNewItem();

    public abstract MobileElement getSettingsMenuItem();

    public abstract MobileElement getSettingsList();

    public abstract MobileElement getProfileMenuItemButton();

    public abstract MobileElement getBalanceMenuItem();

    public abstract MobileElement getBalanceMenuItemCarol();

    public abstract MobileElement getBonusesMenuItem();

    public abstract MobileElement getSupportMenuItem();

    public abstract MobileElement getTradesMenuItem();

    public abstract MobileElement getTradesList();

    public abstract MobileElement getTournamentsMenuItem();

    public abstract TransactionHistoryPanel checkTransactionHistoryPanel();

    public abstract LogOutPanel clickLogOutButton();

    public abstract PanelUserMenu checkSupportContainer();

    public abstract CashierDepositPage clickDepositButton();

    public abstract TransactionHistoryPanel clickTransactionHistoryButton();

    public abstract CashierDepositPage clickDepositButtonFromTrades();
    public abstract CashierDepositPage clickDepositNativeButton();

    public abstract StatusesPanel clickStatusButton();

    public abstract TransactionsHistoryPanel clickBalanceButton();


    public PanelUserMenu(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public PanelUserMenu checkPanelUserMenu() {
        getWaitWithTimeout(10).withMessage("User Menu Panel is not displayed").until(d ->
                isDisplayed(getUserSettingsIdPanel()));
        return this;
    }

    public PanelUserMenu checkSettingsContainer() {
        getWait().withMessage("Settings container is not displayed").until(d ->
                isDisplayed(getSettingsList()));
        return this;
    }

    public PanelUserMenu checkTradesContainer() {
        getWait().withMessage("Trades container is not displayed").until(d ->
                isDisplayed(getTradesList()));
        return this;
    }

    public boolean isProfileMenuItemExist() {
        return tryDisplayed(getProfileMenuItemButton());
    }

    public boolean isStatusItemExist() {
        return tryDisplayed(getStatusButton());
    }

    public boolean isNotificationItemExist() {
        return tryDisplayed(getNotificationsButton());
    }

    public boolean isTradesMenuItemExists() {
        return tryDisplayed(getTradesMenuItem());
    }

    public boolean isSupportMenuItemExists() {
        return tryDisplayed(getSupportMenuItem());
    }

    public boolean isSettingsMenuItemExists() {
        return tryDisplayed(getSettingsMenuItem());
    }

    public boolean isRateAppItemExist() {
        return tryDisplayed(getRateAppButton());
    }

    public boolean isWhatsNewMenuItemMissing() {
        return isElementMissing(getWhatsNewItem());
    }

    public boolean isBonusesMenuItemMissing() {
        return isElementMissing(getBonusesMenuItem());
    }

    public boolean isBalanceMenuItemMissing() {
        return isElementMissing(getBalanceMenuItem());
    }

    public boolean isTournamentsMenuItemMissing() {
        return isElementMissing(getTournamentsMenuItem());
    }

    public boolean isDepositButtonMissing() {
        return isElementMissing(getDepositButton());
    }

    public String getMenuDetailTitleText() {
        return tryGetText(getMenuDetailTitle());
    }

    public String getUserEmail() {
        return tryGetText(getUserEmailTextField());
    }

    public PanelUserMenu clickSettingsButton() {
        tryClick(getSettingsMenuItem());
        return this;
    }

    @Step("Открыть раздел Bonuses")
    public BonusesPanel clickBonusesButton() {
        tryClick(getBonusesMenuItem());
        return new BonusesPanelIOS(mobileDriver);
    }

    @Step("Открыть раздел Tournament")
    public TournamentsListContainerPanel clickTournamentsButton() {
        tryClick(getTournamentsMenuItem());
        return new TournamentsListContainerPanelIOS(mobileDriver);
    }

    public SupportPanel clickSupportButton() {
        tryClick(getSupportMenuItem());
        return new SupportPanelIOS(mobileDriver);
    }

    public PanelUserMenu clickTradesButton() {
        tryClick(getTradesMenuItem());
        return this;
    }

    public PanelUserMenu clickProfileMenuItemButton() {
        tryClick(getProfileMenuItemButton());
        return this;
    }

}


