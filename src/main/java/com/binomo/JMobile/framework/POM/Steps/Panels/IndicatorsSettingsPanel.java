package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;


public abstract class IndicatorsSettingsPanel extends BaseElements {

    protected abstract MobileElement getIndicatorSettingsHeader();

    protected abstract MobileElement getApplyButton();

    protected abstract MobileElement getDefaultButton();

    protected abstract MobileElement getShowZonesSwitch();

    protected abstract MobileElement getSocialTradingSubtitle();

    protected abstract MobileElement getSocialTradingDescription();

    protected abstract MobileElement getSocialTradingImage();

    protected abstract MobileElement getSocialTradingHowItWorksSubtitle();

    protected abstract MobileElement getSocialTradingHowItWorksDescriptionFirst();

    protected abstract MobileElement getSocialTradingHowItWorksDescriptionSecond();

    protected abstract MobileElement getSocialTradingDetailsSubtitle();

    protected abstract MobileElement getSocialTradingDetailsDescriptionFirst();

    protected abstract MobileElement getSocialTradingDetailsDescriptionSecond();

    protected abstract MobileElement getSocialTradingApplyButton();

    protected abstract MobileElement getMovingAveragePeriodField();

    protected abstract MobileElement getMovingAverageOffsetField();

    protected abstract MobileElement getMovingAverageFirstColor();

    protected abstract MobileElement getAlligatorJawsPeriodField();

    protected abstract MobileElement getAlligatorJawsOffsetField();

    protected abstract MobileElement getAlligatorJawsThirdColor();

    protected abstract MobileElement getAlligatorLipsPeriodField();

    protected abstract MobileElement getAlligatorLipsOffsetField();

    protected abstract MobileElement getAlligatorLipsSecondColor();

    protected abstract MobileElement getAlligatorTeethPeriodField();

    protected abstract MobileElement getAlligatorTeethOffsetField();

    protected abstract MobileElement getAlligatorTeethFirstColor();

    protected abstract MobileElement getBollingerPeriodField();

    protected abstract MobileElement getBollingerDeviationField();

    protected abstract MobileElement getBollingerUpperLineFirstColor();

    protected abstract MobileElement getBollingerMiddleLineSecondColor();

    protected abstract MobileElement getBollingerLowerLineThirdColor();

    protected abstract MobileElement getPSarMinAFField();

    protected abstract MobileElement getPSarMaxAFField();

    protected abstract MobileElement getPSarFirstColor();

    protected abstract MobileElement getFractalsPeriodField();

    protected abstract MobileElement getFractalsFirstColor();

    protected abstract MobileElement getFractalChaosBandsPeriodField();

    protected abstract MobileElement getFractalChaosBandsChannelFirstColor();

    protected abstract MobileElement getFractalChaosBandsShadingSwitch();

    protected abstract MobileElement getFractalChaosBandsUpSecondColor();

    protected abstract MobileElement getFractalChaosBandsDownThirdColor();

    protected abstract MobileElement getPeriodPicker();

    protected abstract MobileElement getPeriodPickerOkButton();

    protected abstract MobileElement getRSIPeriodField();

    protected abstract MobileElement getRSIOverboughtField();

    protected abstract MobileElement getRSIOversoldField();

    protected abstract MobileElement getRSIFirstColor();

    protected abstract MobileElement getMACDFastPeriodField();

    protected abstract MobileElement getMACDSlowPeriodField();

    protected abstract MobileElement getMACDSlowPeriodSecondColor();

    protected abstract MobileElement getMACDSignalPeriodField();

    protected abstract MobileElement getMACDSignalPeriodFirstColor();

    protected abstract MobileElement getCCIPeriodField();

    protected abstract MobileElement getCCIPeriodFirstColor();

    protected abstract MobileElement getCCIUpperLineField();

    protected abstract MobileElement getCCIUpperLineSecondColor();

    protected abstract MobileElement getCCIBottomLineField();

    protected abstract MobileElement getCCIBottomLineThirdColor();

    protected abstract MobileElement getStochasticPeriodField();

    protected abstract MobileElement getStochasticOverboughtField();

    protected abstract MobileElement getStochasticOversoldField();

    protected abstract MobileElement getStochasticFastLineSecondColor();

    protected abstract MobileElement getStochasticSlowLineFirstColor();

    protected abstract MobileElement getATRPeriodField();

    protected abstract MobileElement getATRPeriodThirdColor();

    protected abstract MobileElement getADXMAPeriodField();

    protected abstract MobileElement getADXSmoothingPeriodField();

    protected abstract MobileElement getAdxDeclineFirstColor();

    protected abstract MobileElement getAdxDeclineSecondColor();

    protected abstract MobileElement getAdxGrowthSecondColor();

    protected abstract MobileElement getAdxGrowthThirdColor();

    protected abstract MobileElement getAdxMinusDIThirdColor();

    protected abstract MobileElement getAdxMinusDISecondColor();

    protected abstract MobileElement getAdxPlusDIFourthColor();

    protected abstract MobileElement getAdxPlusDIThirdColor();

    protected abstract MobileElement getAdxFirstColor();

    protected abstract MobileElement getAdxSixthColor();

    protected abstract MobileElement getAdxShowHistogramSwitch();

    protected abstract MobileElement getAdxShowADXDIsSwitch();

    protected abstract MobileElement getAdxShadingSwitch();

    protected abstract MobileElement getSmoothSwitch();

    public abstract boolean isMovingAverageFirstColorChosen();

    public abstract boolean isAlligatorJawsThirdColorChosen();

    public abstract boolean isAlligatorTeethFirstColorChosen();

    public abstract boolean isAlligatorLipsSecondColorChosen();

    public abstract boolean isBollingerUpperLineFirstColorChosen();

    public abstract boolean isBollingerMiddleLineSecondColorChosen();

    public abstract boolean isBollingerLowerLineThirdColorChosen();

    public abstract boolean isPSarFirstColorChosen();

    public abstract boolean isFractalsFirstColorChosen();

    public abstract boolean isFractalChaosBandsChannelFirstColorChosen();

    public abstract boolean isFractalChaosBandsUpSecondColorChosen();

    public abstract boolean isFractalChaosBandsDownThirdColorChosen();

    public abstract boolean isRSIFirstColorChosen();

    public abstract boolean isMACDSignalPeriodFirstColorChosen();

    public abstract boolean isMACDSlowPeriodSecondColorChosen();

    public abstract boolean isCCIPeriodFirstColorChosen();

    public abstract boolean isCCIUpperLineSecondColorChosen();

    public abstract boolean isCCIBottomLineThirdColorChosen();

    public abstract boolean isStochasticSlowLineFirstColorChosen();

    public abstract boolean isStochasticFastLineSecondColorChosen();

    public abstract boolean isATRPeriodThirdColorChosen();

    public abstract boolean isAdxDeclineFirstColorChosen();

    public abstract boolean isAdxDeclineSecondColorChosen();

    public abstract boolean isAdxGrowthSecondColorChosen();

    public abstract boolean isAdxGrowthThirdColorChosen();

    public abstract boolean isAdxMinusDIThirdColorChosen();

    public abstract boolean isAdxMinusDISecondColorChosen();

    public abstract boolean isAdxPlusDIFourthColorChosen();

    public abstract boolean isAdxPlusDIThirdColorChosen();

    public abstract boolean isAdxFirstColorChosen();

    public abstract boolean isAdxSixthColorChosen();

    public abstract boolean isShowZonesSwitchChosen();

    public abstract TradingPage clickApplyButton();

    public abstract TradingPage clickSocialTradingApplyButton();


    public IndicatorsSettingsPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public String getIndicatorSettingsHeaderText() {
        return tryGetText(getIndicatorSettingsHeader());
    }

    public Boolean isApplyButtonEnabled() {
        return isEnabled(getApplyButton());
    }

    public IndicatorsSettingsPanel clickDefaultButton() {
        tryClick(getDefaultButton());
        return this;
    }

    public String getSocialTradingSubtitleText() {
        return tryGetText(getSocialTradingSubtitle());
    }

    public String getSocialTradingDescriptionText() {
        return tryGetText(getSocialTradingDescription());
    }

    public Boolean isSocialTradingImageExists() {
        return tryDisplayed(getSocialTradingImage());
    }

    public String getSocialTradingHowItWorksSubtitleText() {
        return tryGetText(getSocialTradingHowItWorksSubtitle());
    }

    public String getSocialTradingHowItWorksDescriptionText() {
        return tryGetText(getSocialTradingHowItWorksDescriptionFirst()) + tryGetText(getSocialTradingHowItWorksDescriptionSecond());
    }

    public String getSocialTradingDetailsSubtitleText() {
        return tryGetText(getSocialTradingDetailsSubtitle());
    }

    public String getSocialTradingDetailsDescriptionText() {
        return tryGetText(getSocialTradingDetailsDescriptionFirst()) + tryGetText(getSocialTradingDetailsDescriptionSecond());
    }

    public Boolean isSocialTradingApplyButtonExists() {
        return tryDisplayed(getSocialTradingApplyButton());
    }

    public IndicatorsSettingsPanel setMovingAverageIndicatorPeriod(String randomIndicatorPeriod) {
        tryClick(getMovingAveragePeriodField());
        clearAndSendKeys(getMovingAveragePeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setMovingAverageIndicatorOffset(String randomIndicatorOffset) {
        tryClick(getMovingAverageOffsetField());
        clearAndSendKeys(getMovingAverageOffsetField(), randomIndicatorOffset);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseMovingAverageFirstColor() {
        rightHorizontalSwipeInElement(getMovingAverageFirstColor());
        tryClick(getMovingAverageFirstColor());
        return this;
    }

    public String getMovingAverageIndicatorPeriodText() {
        return tryGetText(getMovingAveragePeriodField());
    }

    public String getMovingAverageIndicatorOffsetText() {
        return tryGetText(getMovingAverageOffsetField());
    }

    public IndicatorsSettingsPanel setAlligatorTeethPeriod(String randomIndicatorPeriod) {
        customDownSwipe(650);
        clearAndSendKeys(getAlligatorTeethPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setAlligatorTeethOffset(String randomIndicatorPeriod) {
        tryClick(getAlligatorTeethOffsetField());
        clearAndSendKeys(getAlligatorTeethOffsetField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseAlligatorTeethFirstColor() {
        rightHorizontalSwipeInElement(getAlligatorTeethFirstColor());
        tryClick(getAlligatorTeethFirstColor());
        return this;
    }

    public IndicatorsSettingsPanel setAlligatorLipsPeriod(String randomIndicatorPeriod) {
        customDownSwipe(650);
        tryClick(getAlligatorLipsPeriodField());
        clearAndSendKeys(getAlligatorLipsPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setAlligatorLipsOffset(String randomIndicatorPeriod) {
        tryClick(getAlligatorLipsOffsetField());
        clearAndSendKeys(getAlligatorLipsOffsetField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseAlligatorLipsSecondColor() {
        rightHorizontalSwipeInElement(getAlligatorLipsSecondColor());
        tryClick(getAlligatorLipsSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel setAlligatorJawsPeriod(String randomIndicatorPeriod) {
        tryClick(getAlligatorJawsPeriodField());
        clearAndSendKeys(getAlligatorJawsPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setAlligatorJawsOffset(String randomIndicatorPeriod) {
        tryClick(getAlligatorJawsOffsetField());
        clearAndSendKeys(getAlligatorJawsOffsetField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseAlligatorJawsThirdColor() {
        rightHorizontalSwipeInElement(getAlligatorJawsThirdColor());
        tryClick(getAlligatorJawsThirdColor());
        return this;
    }

    public String getAlligatorTeethPeriodText() {
        return tryGetText(getAlligatorTeethPeriodField());
    }

    public String getAlligatorTeethOffsetText() {
        return tryGetText(getAlligatorTeethOffsetField());
    }

    public String getAlligatorLipsPeriodText() {
        return tryGetText(getAlligatorLipsPeriodField());
    }

    public String getAlligatorLipsOffsetText() {
        return tryGetText(getAlligatorLipsOffsetField());
    }

    public String getAlligatorJawsPeriodText() {
        return tryGetText(getAlligatorJawsPeriodField());
    }

    public String getAlligatorJawsOffsetText() {
        return tryGetText(getAlligatorJawsOffsetField());
    }

    public IndicatorsSettingsPanel setBollingerPeriod(String randomIndicatorPeriod) {
        tryClick(getBollingerPeriodField());
        clearAndSendKeys(getBollingerPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setBollingerDeviation(String randomIndicatorPeriod) {
        tryClick(getBollingerDeviationField());
        clearAndSendKeys(getBollingerDeviationField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseBollingerUpperLineFirstColor() {
        swipeUntilFound(getBollingerUpperLineFirstColor());
        rightHorizontalSwipeInElement(getBollingerUpperLineFirstColor());
        tryClick(getBollingerUpperLineFirstColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseBollingerMiddleLineSecondColor() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getBollingerMiddleLineSecondColor());
        tryClick(getBollingerMiddleLineSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseBollingerLowerLineThirdColor() {
        customDownSwipe(300);
        rightHorizontalSwipeInElement(getBollingerLowerLineThirdColor());
        tryClick(getBollingerLowerLineThirdColor());
        return this;
    }

    public String getBollingerPeriodText() {
        return tryGetText(getBollingerPeriodField());
    }

    public String getBollingerDeviationText() {
        return tryGetText(getBollingerDeviationField());
    }

    public IndicatorsSettingsPanel setPSarMinAF(String randomIndicatorPeriod) {
        tryClick(getPSarMinAFField());
        clearAndSendKeys(getPSarMinAFField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setPSarMaxAF(String randomIndicatorPeriod) {
        tryClick(getPSarMaxAFField());
        clearAndSendKeys(getPSarMaxAFField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel choosePSarFirstColor() {
        rightHorizontalSwipeInElement(getPSarFirstColor());
        tryClick(getPSarFirstColor());
        return this;
    }

    public String getPSarMinAFText() {
        return tryGetText(getPSarMinAFField());
    }

    public String getPSarMaxAFText() {
        return tryGetText(getPSarMaxAFField());
    }

    public IndicatorsSettingsPanel setFractalsPeriod() {
        tryClick(getFractalsPeriodField());
        clickByCoordinates(getPeriodPicker().getCenter().x, getPeriodPicker().getCenter().y + 150);
        tryClick(getPeriodPickerOkButton());
        return this;
    }

    public IndicatorsSettingsPanel chooseFractalsFirstColor() {
        rightHorizontalSwipeInElement(getFractalsFirstColor());
        tryClick(getFractalsFirstColor());
        return this;
    }

    public String getFractalsPeriodText() {
        return tryGetText(getFractalsPeriodField());
    }

    public IndicatorsSettingsPanel setFractalChaosBandsPeriod() {
        tryClick(getFractalChaosBandsPeriodField());
        clickByCoordinates(getPeriodPicker().getCenter().x, getPeriodPicker().getCenter().y + 150);
        tryClick(getPeriodPickerOkButton());
        return this;
    }

    public IndicatorsSettingsPanel chooseFractalChaosBandsChannelFirstColor() {
        rightHorizontalSwipeInElement(getFractalChaosBandsChannelFirstColor());
        tryClick(getFractalChaosBandsChannelFirstColor());
        return this;
    }

    public IndicatorsSettingsPanel clickFractalChaosBandsShadingSwitch() {
        tryClick(getFractalChaosBandsShadingSwitch());
        return this;
    }

    public IndicatorsSettingsPanel chooseFractalChaosBandsUpSecondColor() {
        customDownSwipe(300);
        rightHorizontalSwipeInElement(getFractalChaosBandsUpSecondColor());
        tryClick(getFractalChaosBandsUpSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseFractalChaosBandsDownThirdColor() {
        customDownSwipe(300);
        rightHorizontalSwipeInElement(getFractalChaosBandsDownThirdColor());
        tryClick(getFractalChaosBandsDownThirdColor());
        return this;
    }

    public String getFractalChaosBandsPeriodText() {
        return tryGetText(getFractalChaosBandsPeriodField());
    }

    public boolean isFractalChaosBandsShadingSwitchChosen() {
        return isChecked(getFractalChaosBandsShadingSwitch());
    }

    public IndicatorsSettingsPanel setRSIPeriod(String randomIndicatorPeriod) {
        tryClick(getRSIPeriodField());
        clearAndSendKeys(getRSIPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setRSIOverbought(String randomIndicatorPeriod) {
        tryClick(getRSIOverboughtField());
        clearAndSendKeys(getRSIOverboughtField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setRSIOversold(String randomIndicatorPeriod) {
        tryClick(getRSIOversoldField());
        clearAndSendKeys(getRSIOversoldField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseRSIFirstColor() {
        customDownSwipe(500);
        rightHorizontalSwipeInElement(getRSIFirstColor());
        tryClick(getRSIFirstColor());
        return this;
    }

    public String getRSIPeriodText() {
        return tryGetText(getRSIPeriodField());
    }

    public String getRSIOverboughtText() {
        return tryGetText(getRSIOverboughtField());
    }

    public String getRSIOversoldText() {
        return tryGetText(getRSIOversoldField());
    }

    public IndicatorsSettingsPanel setMACDFastPeriod(String randomIndicatorPeriod) {
        tryClick(getMACDFastPeriodField());
        clearAndSendKeys(getMACDFastPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setMACDSlowPeriod(String randomIndicatorPeriod) {
        tryClick(getMACDSlowPeriodField());
        clearAndSendKeys(getMACDSlowPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseMACDSlowPeriodSecondColor() {
        rightHorizontalSwipeInElement(getMACDSlowPeriodSecondColor());
        tryClick(getMACDSlowPeriodSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel setMACDSignalPeriod(String randomIndicatorPeriod) {
        customDownSwipe(500);
        tryClick(getMACDSignalPeriodField());
        clearAndSendKeys(getMACDSignalPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseMACDSignalPeriodFirstColor() {
        rightHorizontalSwipeInElement(getMACDSignalPeriodFirstColor());
        tryClick(getMACDSignalPeriodFirstColor());
        return this;
    }

    public String getMACDFastPeriodText() {
        return tryGetText(getMACDFastPeriodField());
    }

    public String getMACDSlowPeriodText() {
        return tryGetText(getMACDSlowPeriodField());
    }

    public String getMACDSignalPeriodText() {
        customDownSwipe(500);
        return tryGetText(getMACDSignalPeriodField());
    }

    public IndicatorsSettingsPanel setCCIPeriod(String randomIndicatorPeriod) {
        tryClickInPanelAndroid(getCCIPeriodField(), true);
        clearAndSendKeys(getCCIPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseCCIPeriodFirstColor() {
        leftHorizontalSwipeInElement(getCCIPeriodFirstColor());
        tryClick(getCCIPeriodFirstColor());
        return this;
    }

    public IndicatorsSettingsPanel setCCIUpperLine(String randomIndicatorPeriod) {
        tryClick(getCCIUpperLineField());
        clearAndSendKeys(getCCIUpperLineField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseCCIUpperLineSecondColor() {
        leftHorizontalSwipeInElement(getCCIUpperLineSecondColor());
        tryClick(getCCIUpperLineSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel setCCIBottomLine(String randomIndicatorPeriod) {
        tryClickInPanelAndroid(getCCIBottomLineField(), true);
        clearAndSendKeys(getCCIBottomLineField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseCCIBottomLineThirdColor() {
        leftHorizontalSwipeInElement(getCCIBottomLineThirdColor());
        tryClick(getCCIBottomLineThirdColor());
        return this;
    }

    public String getCCIPeriodText() {
        swipeUntilFound(getCCIPeriodField());
        return tryGetText(getCCIPeriodField());
    }

    public String getCCIUpperLineText() {
        return tryGetText(getCCIUpperLineField());
    }

    public String getCCIBottomLineText() {
        swipeUntilFound(getCCIBottomLineField());
        return tryGetText(getCCIBottomLineField());
    }

    public IndicatorsSettingsPanel setStochasticPeriod(String randomIndicatorPeriod) {
        tryClick(getStochasticPeriodField());
        clearAndSendKeys(getStochasticPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setStochasticOverbought(String randomIndicatorPeriod) {
        tryClick(getStochasticOverboughtField());
        clearAndSendKeys(getStochasticOverboughtField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setStochasticOversold(String randomIndicatorPeriod) {
        tryClick(getStochasticOversoldField());
        clearAndSendKeys(getStochasticOversoldField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseStochasticFastLineSecondColor() {
        customDownSwipe(400);
        rightHorizontalSwipeInElement(getStochasticFastLineSecondColor());
        tryClick(getStochasticFastLineSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseStochasticSlowLineFirstColor() {
        customDownSwipe(400);
        rightHorizontalSwipeInElement(getStochasticSlowLineFirstColor());
        tryClick(getStochasticSlowLineFirstColor());
        return this;
    }

    public String getStochasticPeriodText() {
        return tryGetText(getStochasticPeriodField());
    }

    public String getStochasticOverboughtText() {
        return tryGetText(getStochasticOverboughtField());
    }

    public String getStochasticOversoldText() {
        return tryGetText(getStochasticOversoldField());
    }

    public IndicatorsSettingsPanel setATRPeriod(String randomIndicatorPeriod) {
        tryClick(getATRPeriodField());
        clearAndSendKeys(getATRPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseATRPeriodThirdColor() {
        rightHorizontalSwipeInElement(getATRPeriodThirdColor());
        tryClick(getATRPeriodThirdColor());
        return this;
    }

    public String getATRPeriodText() {
        return tryGetText(getATRPeriodField());
    }

    public IndicatorsSettingsPanel setADXMAPeriod(String randomIndicatorPeriod) {
        tryClick(getADXMAPeriodField());
        clearAndSendKeys(getADXMAPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel setADXSmoothingPeriod(String randomIndicatorPeriod) {
        tryClick(getADXSmoothingPeriodField());
        clearAndSendKeys(getADXSmoothingPeriodField(), randomIndicatorPeriod);
        clickDoneKeyboardButton();
        return this;
    }

    public IndicatorsSettingsPanel chooseAdxDeclineFirstColor() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxDeclineFirstColor());
        tryClick(getAdxDeclineFirstColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseAdxGrowthSecondColor() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxGrowthSecondColor());
        tryClick(getAdxGrowthSecondColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseAdxMinusDIThirdColor() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxMinusDIThirdColor());
        tryClick(getAdxMinusDIThirdColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseAdxPlusDIFourthColor() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxPlusDIFourthColor());
        tryClick(getAdxPlusDIFourthColor());
        return this;
    }

    public IndicatorsSettingsPanel chooseAdxFirstColor() {
        customDownSwipe(400);
        rightHorizontalSwipeInElement(getAdxFirstColor());
        tryClick(getAdxFirstColor());
        return this;
    }

    public IndicatorsSettingsPanel clickAdxShowHistogramSwitch() {
        customDownSwipe(400);
        tryClickInPanelAndroid(getAdxShowHistogramSwitch(), true);
        return this;
    }

    public IndicatorsSettingsPanel clickAdxShowADXDIsSwitch() {
        customDownSwipe(400);
        tryClickInPanelAndroid(getAdxShowADXDIsSwitch(), true);
        return this;
    }

    public IndicatorsSettingsPanel clickAdxShadingSwitchSwitch() {
        customDownSwipe(400);
        tryClickInPanelAndroid(getAdxShadingSwitch(), true);
        return this;
    }

    public String getADXMAPeriodText() {
        return tryGetText(getADXMAPeriodField());
    }

    public String getADXSmoothingPeriodText() {
        return tryGetText(getADXSmoothingPeriodField());
    }

    public boolean isAdxShowHistogramSwitchChosen() {
        customDownSwipe(400);
        swipeUntilFoundAndroidPanel(getAdxShowHistogramSwitch());
        return isChecked(getAdxShowHistogramSwitch());
    }

    public boolean isAdxShowADXDIsSwitchChosen() {
        customDownSwipe(400);
        swipeUntilFoundAndroidPanel(getAdxShowADXDIsSwitch());
        return isChecked(getAdxShowADXDIsSwitch());
    }

    public boolean isAdxShadingSwitchChosen() {
        customDownSwipe(400);
        swipeUntilFoundAndroidPanel(getAdxShadingSwitch());
        return isChecked(getAdxShadingSwitch());
    }

    public IndicatorsSettingsPanel clickShowZonesSwitch() {
        tryClickInPanelAndroid(getShowZonesSwitch(), true);
        return this;
    }

    public IndicatorsSettingsPanel clickSmoothSwitch() {
        customDownSwipe(400);
        tryClickInPanelAndroid(getSmoothSwitch(), true);
        return this;
    }

    public boolean isSmoothSwitchChosen() {
        customDownSwipe(400);
        swipeUntilFoundAndroidPanel(getSmoothSwitch());
        return isChecked(getSmoothSwitch());
    }

    public void swipeDown() {
        customDownSwipe(500);
    }

    public void swipeToTopOfADXPanel() {
        SwipeUpInPanelUntilFound(getADXMAPeriodField());
    }
}
