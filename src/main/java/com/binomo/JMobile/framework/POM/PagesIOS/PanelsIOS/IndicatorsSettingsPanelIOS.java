package com.example.JMobile.framework.POM.PagesIOS.PanelsIOS;

import com.example.JMobile.framework.Enums.ExceptionMessages;
import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsSettingsPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.support.PageFactory;

public class IndicatorsSettingsPanelIOS extends IndicatorsSettingsPanel {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Indicators']/following-sibling::XCUIElementTypeStaticText")
    private IOSElement _indicatorSettingsHeader;

    @iOSXCUITFindBy(accessibility = "IndicatorSettingsApplyButton")
    private IOSElement _applyButton;

    @iOSXCUITFindBy(accessibility = "IndicatorSettingsDefaultButton")
    private IOSElement _defaultButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Social Trading'])[2]")
    private IOSElement _socialTradingSubtitle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Social Trading'])[2]//following-sibling::XCUIElementTypeStaticText[1]")
    private IOSElement _socialTradingDescription;

    @iOSXCUITFindBy(accessibility = "icon_social_trading_introduce")
    private IOSElement _socialTradingImage;

    @iOSXCUITFindBy(accessibility = "How it works")
    private IOSElement _socialTradingHowItWorksSubtitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='How it works']/following-sibling::XCUIElementTypeStaticText[1]")
    private IOSElement _socialTradingHowItWorksDescriptionFirst;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='How it works']/following-sibling::XCUIElementTypeStaticText[2]")
    private IOSElement _socialTradingHowItWorksDescriptionSecond;

    @iOSXCUITFindBy(accessibility = "Details")
    private IOSElement _socialTradingDetailsSubtitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Details']/following-sibling::XCUIElementTypeStaticText[2]")
    private IOSElement _socialTradingDetailsDescriptionFirst;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Details']/following-sibling::XCUIElementTypeStaticText[4]")
    private IOSElement _socialTradingDetailsDescriptionSecond;

    @iOSXCUITFindBy(accessibility = "Apply")
    private IOSElement _socialTradingApplyButton;
////
    @iOSXCUITFindBy(accessibility = "TextField")
    private IOSElement _movingAveragePeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name='ColorSelectorList']/XCUIElementTypeCell[1]")
    private IOSElement _movingAverageFirstColor;
////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='JawSettingsCell']/XCUIElementTypeTextField[@name='TextField'][1]")
    private IOSElement _alligatorJawsPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='JawSettingsCell']/XCUIElementTypeTextField[@name='TextField'][2]")
    private IOSElement _alligatorJawsOffsetField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='JawSettingsCell']//XCUIElementTypeCell[3]")
    private IOSElement _alligatorJawsThirdColor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='TeethSettingsCell']/XCUIElementTypeTextField[@name='TextField'][1]")
    private IOSElement _alligatorTeethPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='TeethSettingsCell']/XCUIElementTypeTextField[@name='TextField'][2]")
    private IOSElement _alligatorTeethOffsetField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='TeethSettingsCell']//XCUIElementTypeCell[1]")
    private IOSElement _alligatorTeethFirstColor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='LipsSettingsCell']/XCUIElementTypeTextField[@name='TextField'][1]")
    private IOSElement _alligatorLipsPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='LipsSettingsCell']/XCUIElementTypeTextField[@name='TextField'][2]")
    private IOSElement _alligatorLipsOffsetField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='LipsSettingsCell']//XCUIElementTypeCell[2]")
    private IOSElement _alligatorLipsSecondColor;
////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='TextField'][2]")
    private IOSElement _bollingerDeviationField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='TextField'][1]")
    private IOSElement _bollingerPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='UpperLineColorSettingsCell']//XCUIElementTypeCell[1]")
    private IOSElement _bollingerUpperLineFirstColor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='MiddleLineColorSettingsCell']//XCUIElementTypeCell[2]")
    private IOSElement _bollingerMiddleLineSecondColor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='LowerLineColorSettingsCell']//XCUIElementTypeCell[3]")
    private IOSElement _bollingerLowerLineThirdColor;
////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TitleLabel' and @label='Period']/preceding-sibling::XCUIElementTypeTextField")
    private IOSElement _rsiPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TitleLabel' and @label='Overbought']/preceding-sibling::XCUIElementTypeTextField")
    private IOSElement _rsiOverboughtField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TitleLabel' and @label='Oversold']/preceding-sibling::XCUIElementTypeTextField")
    private IOSElement _rsiOversoldField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name='ColorSelectorList']/XCUIElementTypeCell[1]")
    private IOSElement _rsiFirstColor;
////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TitleLabel' and @label='Fast period']/preceding-sibling::XCUIElementTypeTextField")
    private IOSElement _macdFastPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TitleLabel' and @label='Slow period']/preceding-sibling::XCUIElementTypeTextField")
    private IOSElement _macdSlowPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name='ColorSelectorList'][1]/XCUIElementTypeCell[2]")
    private IOSElement _macdSlowPeriodSecondColor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='TitleLabel' and @label='Signal period']/preceding-sibling::XCUIElementTypeTextField")
    private IOSElement _macdSignalPeriodField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView[@name='ColorSelectorList'])[2]/XCUIElementTypeCell[1]")
    private IOSElement _macdSignalPeriodFirstColor;
////
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='TextField'][1]")
    private IOSElement _atrPeriodField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name='ColorSelectorList']/XCUIElementTypeCell[3]")
    private IOSElement _atrPeriodThirdColor;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Show zones']/following-sibling::XCUIElementTypeSwitch")
    private IOSElement _showZonesSwitch;


    public IndicatorsSettingsPanelIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getIndicatorSettingsHeader() { return _indicatorSettingsHeader; }

    public IOSElement getApplyButton() { return _applyButton; }

    public IOSElement getDefaultButton() { return _defaultButton; }

    public IOSElement getSocialTradingSubtitle() { return _socialTradingSubtitle; }

    public IOSElement getSocialTradingDescription() { return _socialTradingDescription; }

    public IOSElement getSocialTradingImage() { return _socialTradingImage; }

    public IOSElement getSocialTradingHowItWorksSubtitle() { return _socialTradingHowItWorksSubtitle; }

    public IOSElement getSocialTradingHowItWorksDescriptionFirst() { return _socialTradingHowItWorksDescriptionFirst; }

    public IOSElement getSocialTradingHowItWorksDescriptionSecond() { return _socialTradingHowItWorksDescriptionSecond; }

    public IOSElement getSocialTradingDetailsSubtitle() { return _socialTradingDetailsSubtitle; }

    public IOSElement getSocialTradingDetailsDescriptionFirst() { return _socialTradingDetailsDescriptionFirst; }

    public IOSElement getSocialTradingDetailsDescriptionSecond() { return _socialTradingDetailsDescriptionSecond; }

    public IOSElement getSocialTradingApplyButton() { return _socialTradingApplyButton; }

    public IOSElement getMovingAveragePeriodField() { return _movingAveragePeriodField; }

    public IOSElement getMovingAverageOffsetField() { return null; }

    public IOSElement getMovingAverageFirstColor() { return _movingAverageFirstColor; }

    public IOSElement getAlligatorJawsPeriodField() { return _alligatorJawsPeriodField; }

    public IOSElement getAlligatorJawsOffsetField() { return _alligatorJawsOffsetField; }

    public IOSElement getAlligatorJawsThirdColor() { return _alligatorJawsThirdColor; }

    public IOSElement getAlligatorLipsPeriodField() { return _alligatorLipsPeriodField; }

    public IOSElement getAlligatorLipsOffsetField() { return _alligatorLipsOffsetField; }

    public IOSElement getAlligatorLipsSecondColor() { return _alligatorLipsSecondColor; }

    public IOSElement getAlligatorTeethPeriodField() { return _alligatorTeethPeriodField; }

    public IOSElement getAlligatorTeethOffsetField() { return _alligatorTeethOffsetField; }

    public IOSElement getAlligatorTeethFirstColor() { return _alligatorTeethFirstColor; }

    public IOSElement getBollingerPeriodField() { return _bollingerPeriodField; }

    public IOSElement getBollingerDeviationField() { return _bollingerDeviationField; }

    public IOSElement getBollingerUpperLineFirstColor() { return _bollingerUpperLineFirstColor; }

    public IOSElement getBollingerMiddleLineSecondColor() { return _bollingerMiddleLineSecondColor; }

    public IOSElement getBollingerLowerLineThirdColor() { return _bollingerLowerLineThirdColor; }

    public IOSElement getPSarMinAFField() { return null; }

    public IOSElement getPSarMaxAFField() { return null; }

    public IOSElement getPSarFirstColor() { return null; }

    public IOSElement getFractalsPeriodField() { return null; }

    public IOSElement getFractalsFirstColor() { return null; }

    public IOSElement getFractalChaosBandsPeriodField() { return null; }

    public IOSElement getFractalChaosBandsChannelFirstColor() { return null; }

    public IOSElement getFractalChaosBandsShadingSwitch() { return null; }

    public IOSElement getFractalChaosBandsUpSecondColor() { return null; }

    public IOSElement getFractalChaosBandsDownThirdColor() { return null; }

    public IOSElement getPeriodPicker() { return null; }

    public IOSElement getPeriodPickerOkButton() { return null; }

    public IOSElement getRSIPeriodField() { return _rsiPeriodField; }

    public IOSElement getRSIOverboughtField() { return _rsiOverboughtField; }

    public IOSElement getRSIOversoldField() { return _rsiOversoldField; }

    public IOSElement getRSIFirstColor() { return _rsiFirstColor; }

    public IOSElement getMACDFastPeriodField() { return _macdFastPeriodField; }

    public IOSElement getMACDSlowPeriodField() { return _macdSlowPeriodField; }

    public IOSElement getMACDSlowPeriodSecondColor() { return _macdSlowPeriodSecondColor; }

    public IOSElement getMACDSignalPeriodField() { return _macdSignalPeriodField; }

    public IOSElement getMACDSignalPeriodFirstColor() { return _macdSignalPeriodFirstColor; }

    public IOSElement getCCIPeriodField() { return null; }

    public IOSElement getCCIPeriodFirstColor() { return null; }

    public IOSElement getCCIUpperLineField() { return null; }

    public IOSElement getCCIUpperLineSecondColor() { return null; }

    public IOSElement getCCIBottomLineField() { return null; }

    public IOSElement getCCIBottomLineThirdColor() { return null; }

    public IOSElement getStochasticPeriodField() { return null; }

    public IOSElement getStochasticOverboughtField() { return null; }

    public IOSElement getStochasticOversoldField() { return null; }

    public IOSElement getStochasticFastLineSecondColor() { return null; }

    public IOSElement getStochasticSlowLineFirstColor() { return null; }

    public IOSElement getATRPeriodField() { return _atrPeriodField; }

    public IOSElement getATRPeriodThirdColor() { return _atrPeriodThirdColor; }

    public IOSElement getADXMAPeriodField() { return null; }

    public IOSElement getADXSmoothingPeriodField() { return null; }

    public IOSElement getAdxDeclineFirstColor() { return null; }

    public IOSElement getAdxDeclineSecondColor() { return null; }

    public IOSElement getAdxGrowthSecondColor() { return null; }

    public IOSElement getAdxGrowthThirdColor() { return null; }

    public IOSElement getAdxMinusDIThirdColor() { return null; }

    public IOSElement getAdxMinusDISecondColor() { return null; }

    public IOSElement getAdxPlusDIFourthColor() { return null; }

    public IOSElement getAdxPlusDIThirdColor() { return null; }

    public IOSElement getAdxFirstColor() { return null; }

    public IOSElement getAdxSixthColor() { return null; }

    public IOSElement getAdxShowHistogramSwitch() { return null; }

    public IOSElement getAdxShowADXDIsSwitch() { return null; }

    public IOSElement getAdxShadingSwitch() { return null; }

    public IOSElement getShowZonesSwitch() { return _showZonesSwitch; }

    public IOSElement getSmoothSwitch() { return null; }


    public boolean isMovingAverageFirstColorChosen() {
        rightHorizontalSwipeInElement(_movingAverageFirstColor);
        return _movingAverageFirstColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isAlligatorJawsThirdColorChosen() {
        rightHorizontalSwipeInElement(_alligatorJawsThirdColor);
        return _alligatorJawsThirdColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isAlligatorTeethFirstColorChosen() {
        rightHorizontalSwipeInElement(_alligatorTeethFirstColor);
        return _alligatorTeethFirstColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isAlligatorLipsSecondColorChosen() {
        rightHorizontalSwipeInElement(_alligatorLipsSecondColor);
        return _alligatorLipsSecondColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isBollingerUpperLineFirstColorChosen() {
        rightHorizontalSwipeInElement(_bollingerUpperLineFirstColor);
        return _bollingerUpperLineFirstColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isBollingerMiddleLineSecondColorChosen() {
        rightHorizontalSwipeInElement(_bollingerMiddleLineSecondColor);
        return _bollingerMiddleLineSecondColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isBollingerLowerLineThirdColorChosen() {
        rightHorizontalSwipeInElement(_bollingerLowerLineThirdColor);
        return _bollingerLowerLineThirdColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isPSarFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isFractalsFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isFractalChaosBandsChannelFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isFractalChaosBandsUpSecondColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isFractalChaosBandsDownThirdColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isRSIFirstColorChosen() {
        rightHorizontalSwipeInElement(_rsiFirstColor);
        return _rsiFirstColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isMACDSignalPeriodFirstColorChosen() {
        rightHorizontalSwipeInElement(_macdSignalPeriodFirstColor);
        logger.info(_macdSignalPeriodFirstColor.getAttribute("name"));
        return _macdSignalPeriodFirstColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isMACDSlowPeriodSecondColorChosen() {
        rightHorizontalSwipeInElement(_macdSlowPeriodSecondColor);
        return _macdSlowPeriodSecondColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isCCIPeriodFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isCCIUpperLineSecondColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isCCIBottomLineThirdColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isStochasticSlowLineFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isStochasticFastLineSecondColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isATRPeriodThirdColorChosen() {
        rightHorizontalSwipeInElement(_atrPeriodThirdColor);
        return _atrPeriodThirdColor.getAttribute("name").equals("SelectedColorCell");
    }

    public boolean isAdxDeclineFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxDeclineSecondColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxGrowthSecondColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxGrowthThirdColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxMinusDIThirdColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxMinusDISecondColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxPlusDIFourthColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxPlusDIThirdColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxFirstColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isAdxSixthColorChosen() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public boolean isShowZonesSwitchChosen() {
        swipeDownUntilFoundInPanelIos(getShowZonesSwitch());
        logger.info(getShowZonesSwitch().getAttribute("value"));
        return getShowZonesSwitch().getAttribute("value").equals(1);
    }

    public TradingPage clickApplyButton() {
        tryClick(_applyButton);
        return new TradingPageIOS(mobileDriver);
    }

    public TradingPage clickSocialTradingApplyButton() {
        swipeDownUntilFoundInPanelIos(_socialTradingApplyButton);
        tryClick(_socialTradingApplyButton);
        return new TradingPageIOS(mobileDriver);
    }
}