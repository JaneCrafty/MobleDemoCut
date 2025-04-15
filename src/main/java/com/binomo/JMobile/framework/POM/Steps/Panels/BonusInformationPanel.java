package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class BonusInformationPanel extends BaseElements {

    protected abstract MobileElement getBonusInformationToolbarTitle();

    protected abstract MobileElement getBonusInformationToolbarBackButton();

    protected abstract MobileElement getClockImage();

    protected abstract MobileElement getActivateBeforeTime();

    protected abstract MobileElement getBonusAmountTitle();

    protected abstract MobileElement getBonusAmountValue();

    protected abstract MobileElement getBonusLeverageTitle();

    protected abstract MobileElement getBonusLeverageValue();

    protected abstract MobileElement getBonusDescription();

    public abstract BonusInformationPanel checkBonusesPanel();


    public BonusInformationPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isBackButtonExists() {
        return tryDisplayed(getBonusInformationToolbarBackButton());
    }

    public boolean isClockImageExists() {
        return tryDisplayed(getClockImage());
    }

    public String getBonusInformationToolbarTitleText() {
        return tryGetText(getBonusInformationToolbarTitle());
    }

    public String getActivateBeforeTimeText() {
        return tryGetText(getActivateBeforeTime());
    }

    public String getBonusAmountTitleText() {
        return tryGetText(getBonusAmountTitle());
    }

    public String getBonusAmountValueText() {
        return tryGetText(getBonusAmountValue());
    }

    public String getBonusLeverageTitleText() {
        return tryGetText(getBonusLeverageTitle());
    }

    public String getBonusLeverageValueText() {
        return tryGetText(getBonusLeverageValue());
    }

    public String getBonusDescriptionText() {
        return tryGetText(getBonusDescription());
    }
}
