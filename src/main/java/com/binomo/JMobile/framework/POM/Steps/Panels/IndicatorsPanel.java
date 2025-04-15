package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class IndicatorsPanel extends BaseElements {

    protected abstract MobileElement getIndicatorsMenuHeader();

    protected abstract MobileElement getIndicatorsPanelLayout();

    protected abstract MobileElement getActiveIndicatorsMenuItem();

    protected abstract MobileElement getAvailableIndicatorsMenuItem();

    protected abstract MobileElement getSocialTradingIndicatorAvailableItem();

    protected abstract MobileElement getSocialTradingIndicatorActiveItem();

    protected abstract MobileElement getMovingAverageIndicatorActiveItem();

    protected abstract MobileElement getAlligatorIndicatorActiveItem();

    protected abstract MobileElement getBollingerIndicatorActiveItem();

    protected abstract MobileElement getPSarIndicatorActiveItem();

    protected abstract MobileElement getFractalsIndicatorActiveItem();

    protected abstract MobileElement getFractalChaosBandsIndicatorActiveItem();

    protected abstract MobileElement getRSIIndicatorActiveItem();

    protected abstract MobileElement getMACDIndicatorActiveItem();

    protected abstract MobileElement getCCIIndicatorActiveItem();

    protected abstract MobileElement getStochasticIndicatorActiveItem();

    protected abstract MobileElement getATRIndicatorActiveItem();

    protected abstract MobileElement getADXIndicatorActiveItem();

    protected abstract MobileElement getRemoveSocialTradingIndicatorItem();

    protected abstract MobileElement getRemoveMovingAverageIndicatorItem();

    protected abstract MobileElement getRemoveAlligatorIndicatorItem();

    protected abstract MobileElement getRemoveBollingerIndicatorItem();

    protected abstract MobileElement getRemovePSarIndicatorItem();

    protected abstract MobileElement getRemoveFractalsIndicatorItem();

    protected abstract MobileElement getRemoveFractalChaosBandsIndicatorItem();

    protected abstract MobileElement getRemoveRSIIndicatorItem();

    protected abstract MobileElement getRemoveMACDIndicatorItem();

    protected abstract MobileElement getRemoveCCIIndicatorItem();

    protected abstract MobileElement getRemoveStochasticIndicatorItem();

    protected abstract MobileElement getRemoveATRIndicatorItem();

    protected abstract MobileElement getRemoveADXIndicatorItem();

    protected abstract MobileElement getEditAlligatorIndicatorActiveItem();

    protected abstract MobileElement getIndicatorVisibleButton();

    public abstract boolean getStatusIndicatorVisibleButton();

    public abstract TradingPage clickCloseButton();

    public abstract TradingPage swipeForClosingIndicatorsPanel();

    public abstract TradingPage tapForClosingIndicatorsPanel();

    public abstract IndicatorsSettingsPanel chooseSocialTrading();

    public abstract IndicatorsSettingsPanel chooseMovingAverage();

    public abstract IndicatorsSettingsPanel chooseAlligator();

    public abstract IndicatorsSettingsPanel chooseBollinger();

    public abstract IndicatorsSettingsPanel choosePSar();

    public abstract IndicatorsSettingsPanel chooseFractals();

    public abstract IndicatorsSettingsPanel chooseFractalChaosBands();

    public abstract IndicatorsSettingsPanel chooseRSI();

    public abstract IndicatorsSettingsPanel chooseMACD();

    public abstract IndicatorsSettingsPanel chooseCCI();

    public abstract IndicatorsSettingsPanel chooseStochastic();

    public abstract IndicatorsSettingsPanel chooseATR();

    public abstract IndicatorsSettingsPanel chooseADX();

    public abstract IndicatorsSettingsPanel clickEditMovingAverage();

    public abstract IndicatorsSettingsPanel clickEditAlligator();

    public abstract IndicatorsSettingsPanel clickEditBollinger();

    public abstract IndicatorsSettingsPanel clickEditPSar();

    public abstract IndicatorsSettingsPanel clickEditFractals();

    public abstract IndicatorsSettingsPanel clickEditFractalChaosBands();

    public abstract IndicatorsSettingsPanel clickEditRSI();

    public abstract IndicatorsSettingsPanel clickEditMACD();

    public abstract IndicatorsSettingsPanel clickEditCCI();

    public abstract IndicatorsSettingsPanel clickEditStochastic();

    public abstract IndicatorsSettingsPanel clickEditATR();

    public abstract IndicatorsSettingsPanel clickEditADX();


    public IndicatorsPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isIndicatorPanelDisplayed() {
        return tryDisplayed(getIndicatorsPanelLayout());
    }

    public boolean isSocialTradingIndicatorInAvailableMissing() {
        clickAvailableIndicatorsItem();
        return isElementMissing(getSocialTradingIndicatorAvailableItem());
    }

    public boolean isSocialTradingIndicatorInActiveExists() {
        return tryDisplayed(getSocialTradingIndicatorActiveItem());
    }

    public boolean isMovingAverageIndicatorInActiveExists() {
        return tryDisplayed(getMovingAverageIndicatorActiveItem());
    }

    public boolean isAlligatorIndicatorInActiveExists() {
        return tryDisplayed(getAlligatorIndicatorActiveItem());
    }

    public boolean isBollingerIndicatorInActiveExists() {
        return tryDisplayed(getBollingerIndicatorActiveItem());
    }

    public boolean isPSarIndicatorInActiveExists() {
        return tryDisplayed(getPSarIndicatorActiveItem());
    }

    public boolean isFractalsIndicatorInActiveExists() {
        return tryDisplayed(getFractalsIndicatorActiveItem());
    }

    public boolean isFractalChaosBandsIndicatorInActiveExists() {
        return tryDisplayed(getFractalChaosBandsIndicatorActiveItem());
    }

    public boolean isRSIIndicatorInActiveExists() {
        return tryDisplayed(getRSIIndicatorActiveItem());
    }

    public boolean isMACDIndicatorInActiveExists() {
        return tryDisplayed(getMACDIndicatorActiveItem());
    }

    public boolean isCCIIndicatorInActiveExists() {
        return tryDisplayed(getCCIIndicatorActiveItem());
    }

    public boolean isStochasticIndicatorInActiveExists() {
        return tryDisplayed(getStochasticIndicatorActiveItem());
    }

    public boolean isATRIndicatorInActiveExists() {
        return tryDisplayed(getATRIndicatorActiveItem());
    }

    public boolean isADXIndicatorInActiveExists() {
        return tryDisplayed(getADXIndicatorActiveItem());
    }

    public boolean isEditAlligatorIndicatorDisplayed() {
        return tryDisplayed(getEditAlligatorIndicatorActiveItem());
    }

    public boolean isMovingAverageIndicatorInActiveMissing() {
        return isElementMissing(getMovingAverageIndicatorActiveItem());
    }

    public boolean isAlligatorIndicatorInActiveMissing() {
        return isElementMissing(getAlligatorIndicatorActiveItem());
    }

    public boolean isBollingerIndicatorInActiveMissing() {
        return isElementMissing(getBollingerIndicatorActiveItem());
    }

    public boolean isPSarIndicatorInActiveMissing() {
        return isElementMissing(getPSarIndicatorActiveItem());
    }

    public boolean isFractalsIndicatorInActiveMissing() {
        return isElementMissing(getFractalsIndicatorActiveItem());
    }

    public boolean isFractalChaosBandsIndicatorInActiveMissing() {
        return isElementMissing(getFractalChaosBandsIndicatorActiveItem());
    }

    public boolean isRSIIndicatorInActiveMissing() {
        return isElementMissing(getRSIIndicatorActiveItem());
    }

    public boolean isMACDIndicatorInActiveMissing() {
        return isElementMissing(getMACDIndicatorActiveItem());
    }

    public boolean isCCIIndicatorInActiveMissing() {
        return isElementMissing(getCCIIndicatorActiveItem());
    }

    public boolean isStochasticIndicatorInActiveMissing() {
        return isElementMissing(getStochasticIndicatorActiveItem());
    }

    public boolean isATRIndicatorInActiveMissing() {
        return isElementMissing(getATRIndicatorActiveItem());
    }

    public boolean isADXIndicatorInActiveMissing() {
        return isElementMissing(getADXIndicatorActiveItem());
    }

    public boolean isEditAlligatorIndicatorMissing() {
        return isElementMissing(getEditAlligatorIndicatorActiveItem());
    }

    public String getIndicatorsMenuHeaderText() {
        return tryGetText(getIndicatorsMenuHeader());
    }

    public IndicatorsPanel clickActiveIndicatorsItem() {
        tryClickWithWait(getActiveIndicatorsMenuItem());
        return this;
    }

    public IndicatorsPanel clickAvailableIndicatorsItem() {
        tryClickWithWait(getAvailableIndicatorsMenuItem());
        return this;
    }

    public IndicatorsPanel clickRemoveSocialTradingIndicator() {
        tryClick(getRemoveSocialTradingIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveMovingAverageIndicator() {
        tryClick(getRemoveMovingAverageIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveAlligatorIndicator() {
        tryClick(getRemoveAlligatorIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveBollingerIndicator() {
        tryClick(getRemoveBollingerIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemovePSarIndicator() {
        tryClick(getRemovePSarIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveFractalsIndicator() {
        tryClick(getRemoveFractalsIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveFractalChaosBandsIndicator() {
        tryClick(getRemoveFractalChaosBandsIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveRSIIndicator() {
        tryClick(getRemoveRSIIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveMACDIndicator() {
        tryClick(getRemoveMACDIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveCCIIndicator() {
        tryClick(getRemoveCCIIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveStochastic() {
        tryClick(getRemoveStochasticIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveATR() {
        tryClick(getRemoveATRIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickRemoveADX() {
        tryClick(getRemoveADXIndicatorItem());
        return this;
    }

    public IndicatorsPanel clickIndicatorVisibleButton() {
        tryClick(getIndicatorVisibleButton());
        return this;
    }

    public void swipeDown() {
        customDownSwipe(500);
    }

    public abstract void clickEditFirstIndicator();
}
