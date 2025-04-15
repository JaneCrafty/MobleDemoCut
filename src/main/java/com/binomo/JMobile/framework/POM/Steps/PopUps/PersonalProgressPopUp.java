package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Panels.StatusesPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class PersonalProgressPopUp extends BaseElements {

    protected abstract MobileElement getPersonalProgressView();

    protected abstract MobileElement getPersonalProgressHeader();

    protected abstract MobileElement getCurrentStatusIcon();

    protected abstract MobileElement getYourStatusHeader();

    protected abstract MobileElement getCurrentStatusValue();

    protected abstract MobileElement getProgressBarToNextStatus();

    protected abstract MobileElement getAmountToNextStatus();

    protected abstract MobileElement getStatusBenefitsButton();

    protected abstract MobileElement getStatusAdvantagesItem();

    protected abstract MobileElement getStatusAdvantagesIcon();

    protected abstract MobileElement getStatusAdvantagesTitle();

    protected abstract MobileElement getStatusAdvantagesDescription();

    protected abstract MobileElement getUpgradeButton();

    protected abstract MobileElement getJoinButton();

    public abstract StatusesPanel clickStatusBenefitsButton();

    public abstract CashierDepositPage clickUpgradeStatusButton();
    public abstract NativeCashierDepositPageAndroid clickUpgradeStatusNativeButton();


    public PersonalProgressPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public PersonalProgressPopUp checkChartTypePanel() {
        getWait().withMessage("Personal progress view is not displayed").until(d ->
                isDisplayed(getPersonalProgressView()));
        return this;
    }

    public boolean isCurrentStatusIconExists() {
        return tryDisplayed(getCurrentStatusIcon());
    }

    public boolean isProgressBarToNextStatusExists() {
        return tryDisplayed(getProgressBarToNextStatus());
    }

    public boolean isStatusBenefitsButtonExists() {
        return tryDisplayed(getStatusBenefitsButton());
    }

    public boolean isStatusAdvantagesItemExists() {
        return tryDisplayed(getStatusAdvantagesItem());
    }

    public boolean isStatusAdvantagesIconExists() {
        return tryDisplayed(getStatusAdvantagesIcon());
    }

    public boolean isUpgradeButtonExists() {
        return tryDisplayed(getUpgradeButton());
    }

    public boolean isJoinButtonExists() {
        return tryDisplayed(getJoinButton());
    }

    public String getPersonalProgressHeaderText() {
        return tryGetText(getPersonalProgressHeader());
    }

    public String getYourStatusHeaderText() {
        return tryGetText(getYourStatusHeader());
    }

    public String getCurrentStatusValueText() {
        return tryGetText(getCurrentStatusValue());
    }

    public String getAmountToNextStatusText() {
        return tryGetText(getAmountToNextStatus());
    }

    public String getStatusAdvantagesTitleText() {
        return tryGetText(getStatusAdvantagesTitle());
    }

    public String getStatusAdvantagesDescriptionText() {
        return tryGetText(getStatusAdvantagesDescription());
    }

    public String getPrestigeClubUrl() {
        mobileDriver.SetContext(true);
        return mobileDriver.getDriver().getCurrentUrl();
    }

    public PersonalProgressPopUp clickJoinButton() {
        tryClick(getJoinButton());
        return this;
    }

}
