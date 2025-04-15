package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public abstract class BonusesPanel extends BaseElements {

    protected abstract MobileElement getNotAvailableBonuses();

    protected abstract MobileElement getAvailableBonusesItem();

    protected abstract MobileElement getBonusName();

    protected abstract MobileElement getBonusCountdownCounter();

    protected abstract MobileElement getBonusAmountValue();

    protected abstract MobileElement getBonusAmountDescription() ;

    protected abstract MobileElement getBonusButton();

    protected abstract MobileElement getBonusInfoButton();

    protected abstract MobileElement getActiveFreeDealsItem();

    protected abstract MobileElement getActiveBonusCouponItem();

    protected abstract MobileElement getActiveBonusName();

    protected abstract MobileElement getDealsCount();

    protected abstract MobileElement getBonusProfitValue();

    protected abstract MobileElement getBonusProfitLeverage();

    protected abstract MobileElement getBonusProgressBar();

    protected abstract MobileElement getBonusProgressValue();

    protected abstract MobileElement getProgressValue();

    public abstract BonusesPanel checkBonusesPanel();

    public abstract TradingPage clickTraderoomTabButton();

    public abstract CashierDepositPage clickGetDepositBonusButton();


    public BonusesPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isAvailableBonusesItemDisplayed() {
        return tryDisplayed(getAvailableBonusesItem());
    }

    public boolean isGetBonusButtonDisplayed() {
        return tryDisplayed(getBonusButton());
    }

    public boolean isBonusInfoButtonDisplayed() {
        return tryDisplayed(getBonusInfoButton());
    }

    public boolean isActiveFreeDealsItemDisplayed() {
        return tryDisplayed(getActiveFreeDealsItem());
    }

    public boolean isActiveBonusCouponItemDisplayed() {
        return tryDisplayed(getActiveBonusCouponItem());
    }

    public boolean isBonusProgressBarDisplayed() {
        return tryDisplayed(getBonusProgressBar());
    }

    public boolean isActiveFreeDealsItemMissing() {
        return isElementMissing(getActiveFreeDealsItem());
    }

    public String getNotAvailableBonusesText() {
        return tryGetText(getNotAvailableBonuses());
    }

    public String getBonusNameText() {
        return tryGetText(getBonusName());
    }

    public String getBonusCountdownCounterText() {
        return tryGetText(getBonusCountdownCounter());
    }

    public String getBonusAmountValueText() {
        return tryGetText(getBonusAmountValue());
    }

    public String getBonusAmountDescriptionText() {
        return tryGetText(getBonusAmountDescription());
    }

    public String getActiveBonusNameText() {
        return tryGetText(getActiveBonusName());
    }

    public String getDealsCountText() {
        return tryGetText(getDealsCount());
    }

    public String getBonusProfitValueText() {
        return tryGetText(getBonusProfitValue());
    }

    public String getBonusProfitLeverageText() {
        return tryGetText(getBonusProfitLeverage());
    }

    public String getBonusProgressValueText() {
        return tryGetText(getBonusProgressValue());
    }

    public String getProgressValueText() {
        return tryGetText(getProgressValue());
    }

    @Step("Нажать кнопку Get на доступном купоне")
    public BonusesPanel clickGetBonusButton() {
        tryClickWithWait(getBonusButton());
        return this;
    }
}
