package com.example.JMobile.framework.POM.PagesAndroid.PanelsAndroid;

import com.example.JMobile.framework.Enums.Indicator;
import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsSettingsPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class IndicatorsSettingsPanelAndroid extends IndicatorsSettingsPanel {

    @AndroidFindBy(id = "headerTitle")
    private AndroidElement _indicatorSettingsHeader;

    @AndroidFindBy(id = "primaryButton")
    private AndroidElement _applyButton;

    @AndroidFindBy(id = "secondaryButton")
    private AndroidElement _defaultButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/socialTradingSettingsRoot']//android.widget.TextView[@text='Social Trading']")
    private AndroidElement _socialTradingSubtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Social Trading']/following-sibling::android.widget.TextView")
    private AndroidElement _socialTradingDescription;

    @AndroidFindBy(id = "image")
    private AndroidElement _socialTradingImage;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/socialTradingSettingsRoot']//android.widget.TextView[@text='How it works']")
    private AndroidElement _socialTradingHowItWorksSubtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How it works']/following-sibling::android.widget.TextView[1]")
    private AndroidElement _socialTradingHowItWorksDescriptionFirst;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='How it works']/following-sibling::android.widget.TextView[2]")
    private AndroidElement _socialTradingHowItWorksDescriptionSecond;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/socialTradingSettingsRoot']//android.widget.TextView[@text='Details']")
    private AndroidElement _socialTradingDetailsSubtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Details']/following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.example.broker.beta:id/detailsLabel1']")
    private AndroidElement _socialTradingDetailsDescriptionFirst;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Details']/following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.example.broker.beta:id/detailsLabel2']")
    private AndroidElement _socialTradingDetailsDescriptionSecond;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _movingAveragePeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingOffset']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _movingAverageOffsetField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/colorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _movingAverageFirstColor;
////
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/jawSetting']/android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _alligatorJawsPeriodField;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/jawSetting']/android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingOffset']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _alligatorJawsOffsetField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/jawColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _alligatorJawsThirdColor;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/lipsSetting']/android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _alligatorLipsPeriodField;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/lipsSetting']/android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingOffset']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _alligatorLipsOffsetField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/lipsColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _alligatorLipsSecondColor;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/teethSetting']/android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _alligatorTeethPeriodField;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/teethSetting']/android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingOffset']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _alligatorTeethOffsetField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/teethColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _alligatorTeethFirstColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _bollingerPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingDeviations']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _bollingerDeviationField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/upperLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _bollingerUpperLineFirstColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/middleLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _bollingerMiddleLineSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/lowerLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _bollingerLowerLineThirdColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingMinAF']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _psarMinAFField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingMaxAF']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _psarMaxAFField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/colorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _psarFirstColor;
////
    @AndroidFindBy(id = "field")
    private AndroidElement _fractalsPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/colorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _fractalsFirstColor;
////
    @AndroidFindBy(id = "field")
    private AndroidElement _fractalChaosBandsPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/channelColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _fractalChaosBandsChannelFirstColor;

    @AndroidFindBy(id = "channelFillSwitch")
    private AndroidElement _fractalChaosBandsShadingSwitch;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/upColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _fractalChaosBandsUpSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/downColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _fractalChaosBandsDownThirdColor;

    @AndroidFindBy(id = "picker")
    private AndroidElement _periodPicker;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.example.broker.beta:id/buttonPanel']//android.widget.Button[2]")
    private AndroidElement _periodPickerOkButton;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _rsiPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/overbought']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _rsiOverboughtField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/oversold']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _rsiOversoldField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/colorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _rsiFirstColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/fastPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _macdFastPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/slowPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _macdSlowPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/macdColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _macdSlowPeriodSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/signalPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _macdSignalPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/signalColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _macdSignalPeriodFirstColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _cciPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/colorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _cciPeriodFirstColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingUpperLine']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _cciUpperLineField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/upperLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _cciUpperLineSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingBottomLine']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _cciBottomLineField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/bottomLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _cciBottomLineThirdColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _stochasticPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingOverbought']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _stochasticOverboughtField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingOversold']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _stochasticOversoldField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/fastLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _stochasticFastLineSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/slowLineColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _stochasticSlowLineFirstColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/settingPeriod']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _atrPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/colorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _atrPeriodThirdColor;
////
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/periodField']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _adxMAPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/smoothingPeriodField']//android.widget.EditText[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _adxSmoothingPeriodField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/negativeBarColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _adxDeclineFirstColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/negativeBarColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _adxDeclineSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/positiveBarColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _adxGrowthSecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/positiveBarColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _adxGrowthThirdColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/minusDiColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _adxMinusDIThirdColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/minusDiColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][2]")
    private AndroidElement _adxMinusDISecondColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/plusDiColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][4]")
    private AndroidElement _adxPlusDIFourthColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/plusDiColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][3]")
    private AndroidElement _adxPlusDIThirdColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/adxColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][1]")
    private AndroidElement _adxFirstColor;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/adxColorPicker']//android.widget.RadioButton[@resource-id='com.example.broker.beta:id/colorPickerButton'][6]")
    private AndroidElement _adxSixthColor;

    @AndroidFindBy(id = "histogramSwitch")
    private AndroidElement _adxShowHistogramSwitch;

    @AndroidFindBy(id = "seriesSwitch")
    private AndroidElement _adxShowADXDIsSwitch;

    @AndroidFindBy(id = "shadingSwitch")
    private AndroidElement _adxShadingSwitch;

    @AndroidFindBy(id = "showZonesSwitch")
    private AndroidElement _showZonesSwitch;

    @AndroidFindBy(id = "isSmoothSwitch")
    private AndroidElement _smoothSwitch;


    public IndicatorsSettingsPanelAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getIndicatorSettingsHeader() { return _indicatorSettingsHeader; }

    public AndroidElement getApplyButton() { return _applyButton; }

    public AndroidElement getDefaultButton() { return _defaultButton; }

    public AndroidElement getSocialTradingSubtitle() { return _socialTradingSubtitle; }

    public AndroidElement getSocialTradingDescription() { return _socialTradingDescription; }

    public AndroidElement getSocialTradingImage() { return _socialTradingImage; }

    public AndroidElement getSocialTradingHowItWorksSubtitle() { return _socialTradingHowItWorksSubtitle; }

    public AndroidElement getSocialTradingHowItWorksDescriptionFirst() { return _socialTradingHowItWorksDescriptionFirst; }

    public AndroidElement getSocialTradingHowItWorksDescriptionSecond() { return _socialTradingHowItWorksDescriptionSecond; }

    public AndroidElement getSocialTradingDetailsSubtitle() { return _socialTradingDetailsSubtitle; }

    public AndroidElement getSocialTradingDetailsDescriptionFirst() { return _socialTradingDetailsDescriptionFirst; }

    public AndroidElement getSocialTradingDetailsDescriptionSecond() { return _socialTradingDetailsDescriptionSecond; }

    public AndroidElement getSocialTradingApplyButton() { return _applyButton; }

    public AndroidElement getMovingAveragePeriodField() { return _movingAveragePeriodField; }

    public AndroidElement getMovingAverageOffsetField() { return _movingAverageOffsetField; }

    public AndroidElement getMovingAverageFirstColor() { return _movingAverageFirstColor; }

    public AndroidElement getAlligatorJawsPeriodField() { return _alligatorJawsPeriodField; }

    public AndroidElement getAlligatorJawsOffsetField() { return _alligatorJawsOffsetField; }

    public AndroidElement getAlligatorJawsThirdColor() { return _alligatorJawsThirdColor; }

    public AndroidElement getAlligatorLipsPeriodField() { return _alligatorLipsPeriodField; }

    public AndroidElement getAlligatorLipsOffsetField() { return _alligatorLipsOffsetField; }

    public AndroidElement getAlligatorLipsSecondColor() { return _alligatorLipsSecondColor; }

    public AndroidElement getAlligatorTeethPeriodField() { return _alligatorTeethPeriodField; }

    public AndroidElement getAlligatorTeethOffsetField() { return _alligatorTeethOffsetField; }

    public AndroidElement getAlligatorTeethFirstColor() { return _alligatorTeethFirstColor; }

    public AndroidElement getBollingerPeriodField() { return _bollingerPeriodField; }

    public AndroidElement getBollingerDeviationField() { return _bollingerDeviationField; }

    public AndroidElement getBollingerUpperLineFirstColor() { return _bollingerUpperLineFirstColor; }

    public AndroidElement getBollingerMiddleLineSecondColor() { return _bollingerMiddleLineSecondColor; }

    public AndroidElement getBollingerLowerLineThirdColor() { return _bollingerLowerLineThirdColor; }

    public AndroidElement getPSarMinAFField() { return _psarMinAFField; }

    public AndroidElement getPSarMaxAFField() { return _psarMaxAFField; }

    public AndroidElement getPSarFirstColor() { return _psarFirstColor; }

    public AndroidElement getFractalsPeriodField() { return _fractalsPeriodField; }

    public AndroidElement getFractalsFirstColor() { return _fractalsFirstColor; }

    public AndroidElement getFractalChaosBandsPeriodField() { return _fractalChaosBandsPeriodField; }

    public AndroidElement getFractalChaosBandsChannelFirstColor() { return _fractalChaosBandsChannelFirstColor; }

    public AndroidElement getFractalChaosBandsShadingSwitch() { return _fractalChaosBandsShadingSwitch; }

    public AndroidElement getFractalChaosBandsUpSecondColor() { return _fractalChaosBandsUpSecondColor; }

    public AndroidElement getFractalChaosBandsDownThirdColor() { return _fractalChaosBandsDownThirdColor; }

    public AndroidElement getPeriodPicker() { return _periodPicker; }

    public AndroidElement getPeriodPickerOkButton() { return _periodPickerOkButton; }

    public AndroidElement getRSIPeriodField() { return _rsiPeriodField; }

    public AndroidElement getRSIOverboughtField() { return _rsiOverboughtField; }

    public AndroidElement getRSIOversoldField() { return _rsiOversoldField; }

    public AndroidElement getRSIFirstColor() { return _rsiFirstColor; }

    public AndroidElement getMACDFastPeriodField() { return _macdFastPeriodField; }

    public AndroidElement getMACDSlowPeriodField() { return _macdSlowPeriodField; }

    public AndroidElement getMACDSlowPeriodSecondColor() { return _macdSlowPeriodSecondColor; }

    public AndroidElement getMACDSignalPeriodField() { return _macdSignalPeriodField; }

    public AndroidElement getMACDSignalPeriodFirstColor() { return _macdSignalPeriodFirstColor; }

    public AndroidElement getCCIPeriodField() { return _cciPeriodField; }

    public AndroidElement getCCIPeriodFirstColor() { return _cciPeriodFirstColor; }

    public AndroidElement getCCIUpperLineField() { return _cciUpperLineField; }

    public AndroidElement getCCIUpperLineSecondColor() { return _cciUpperLineSecondColor; }

    public AndroidElement getCCIBottomLineField() { return _cciBottomLineField; }

    public AndroidElement getCCIBottomLineThirdColor() { return _cciBottomLineThirdColor; }

    public AndroidElement getStochasticPeriodField() { return _stochasticPeriodField; }

    public AndroidElement getStochasticOverboughtField() { return _stochasticOverboughtField; }

    public AndroidElement getStochasticOversoldField() { return _stochasticOversoldField; }

    public AndroidElement getStochasticFastLineSecondColor() { return _stochasticFastLineSecondColor; }

    public AndroidElement getStochasticSlowLineFirstColor() { return _stochasticSlowLineFirstColor; }

    public AndroidElement getATRPeriodField() { return _atrPeriodField; }

    public AndroidElement getATRPeriodThirdColor() { return _atrPeriodThirdColor; }

    public AndroidElement getADXMAPeriodField() { return _adxMAPeriodField; }

    public AndroidElement getADXSmoothingPeriodField() { return _adxSmoothingPeriodField; }

    public AndroidElement getAdxDeclineFirstColor() { return _adxDeclineFirstColor; }

    public AndroidElement getAdxDeclineSecondColor() { return _adxDeclineSecondColor; }

    public AndroidElement getAdxGrowthSecondColor() { return _adxGrowthSecondColor; }

    public AndroidElement getAdxGrowthThirdColor() { return _adxGrowthThirdColor; }

    public AndroidElement getAdxMinusDIThirdColor() { return _adxMinusDIThirdColor; }

    public AndroidElement getAdxMinusDISecondColor() { return _adxMinusDISecondColor; }

    public AndroidElement getAdxPlusDIFourthColor() { return _adxPlusDIFourthColor; }

    public AndroidElement getAdxPlusDIThirdColor() { return _adxPlusDIThirdColor; }

    public AndroidElement getAdxFirstColor() { return _adxFirstColor; }

    public AndroidElement getAdxSixthColor() { return _adxSixthColor; }

    public AndroidElement getAdxShowHistogramSwitch() { return _adxShowHistogramSwitch; }

    public AndroidElement getAdxShowADXDIsSwitch() { return _adxShowADXDIsSwitch; }

    public AndroidElement getAdxShadingSwitch() { return _adxShadingSwitch; }

    public AndroidElement getShowZonesSwitch() { return _showZonesSwitch; }

    public AndroidElement getSmoothSwitch() { return _smoothSwitch; }


    public boolean isMovingAverageFirstColorChosen() {
        rightHorizontalSwipeInElement(_movingAverageFirstColor);
        return isChecked(_movingAverageFirstColor);
    }

    public boolean isAlligatorJawsThirdColorChosen() {
        rightHorizontalSwipeInElement(_alligatorJawsThirdColor);
        return isChecked(_alligatorJawsThirdColor);
    }

    public boolean isAlligatorTeethFirstColorChosen() {
        rightHorizontalSwipeInElement(_alligatorTeethFirstColor);
        return isChecked(_alligatorTeethFirstColor);
    }

    public boolean isAlligatorLipsSecondColorChosen() {
        rightHorizontalSwipeInElement(_alligatorLipsSecondColor);
        return isChecked(_alligatorLipsSecondColor);
    }

    public boolean isBollingerUpperLineFirstColorChosen() {
        rightHorizontalSwipeInElement(_bollingerUpperLineFirstColor);
        return isChecked(_bollingerUpperLineFirstColor);
    }

    public boolean isBollingerMiddleLineSecondColorChosen() {
        rightHorizontalSwipeInElement(_bollingerMiddleLineSecondColor);
        return isChecked(_bollingerMiddleLineSecondColor);
    }

    public boolean isBollingerLowerLineThirdColorChosen() {
        rightHorizontalSwipeInElement(_bollingerLowerLineThirdColor);
        return isChecked(_bollingerLowerLineThirdColor);
    }

    public boolean isPSarFirstColorChosen() {
        rightHorizontalSwipeInElement(_psarFirstColor);
        return isChecked(_psarFirstColor);
    }

    public boolean isFractalsFirstColorChosen() {
        rightHorizontalSwipeInElement(_fractalsFirstColor);
        return isChecked(_fractalsFirstColor);
    }

    public boolean isFractalChaosBandsChannelFirstColorChosen() {
        rightHorizontalSwipeInElement(_fractalChaosBandsChannelFirstColor);
        return isChecked(_fractalChaosBandsChannelFirstColor);
    }

    public boolean isFractalChaosBandsUpSecondColorChosen() {
        rightHorizontalSwipeInElement(_fractalChaosBandsUpSecondColor);
        return isChecked(_fractalChaosBandsUpSecondColor);
    }

    public boolean isFractalChaosBandsDownThirdColorChosen() {
        rightHorizontalSwipeInElement(_fractalChaosBandsDownThirdColor);
        return isChecked(_fractalChaosBandsDownThirdColor);
    }

    public boolean isRSIFirstColorChosen() {
        rightHorizontalSwipeInElement(_rsiFirstColor);
        return isChecked(_rsiFirstColor);
    }

    public boolean isMACDSignalPeriodFirstColorChosen() {
        rightHorizontalSwipeInElement(_macdSignalPeriodFirstColor);
        return isChecked(_macdSignalPeriodFirstColor);
    }

    public boolean isMACDSlowPeriodSecondColorChosen() {
        rightHorizontalSwipeInElement(_macdSlowPeriodSecondColor);
        return isChecked(_macdSlowPeriodSecondColor);
    }

    public boolean isCCIPeriodFirstColorChosen() {
        leftHorizontalSwipeInElement(_cciPeriodFirstColor);
        return isChecked(_cciPeriodFirstColor);
    }

    public boolean isCCIUpperLineSecondColorChosen() {
        leftHorizontalSwipeInElement(_cciUpperLineSecondColor);
        return isChecked(_cciUpperLineSecondColor);
    }

    public boolean isCCIBottomLineThirdColorChosen() {
        leftHorizontalSwipeInElement(_cciBottomLineThirdColor);
        return isChecked(_cciBottomLineThirdColor);
    }

    public boolean isStochasticSlowLineFirstColorChosen() {
        rightHorizontalSwipeInElement(_stochasticSlowLineFirstColor);
        return isChecked(_stochasticSlowLineFirstColor);
    }

    public boolean isStochasticFastLineSecondColorChosen() {
        rightHorizontalSwipeInElement(_stochasticFastLineSecondColor);
        return isChecked(_stochasticFastLineSecondColor);
    }

    public boolean isATRPeriodThirdColorChosen() {
        rightHorizontalSwipeInElement(_atrPeriodThirdColor);
        return isChecked(_atrPeriodThirdColor);
    }

    public boolean isAdxDeclineFirstColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxDeclineFirstColor());
        return isChecked(getAdxDeclineFirstColor());
    }

    public boolean isAdxDeclineSecondColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxDeclineSecondColor());
        return isChecked(getAdxDeclineSecondColor());
    }

    public boolean isAdxGrowthSecondColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxGrowthSecondColor());
        return isChecked(getAdxGrowthSecondColor());
    }

    public boolean isAdxGrowthThirdColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxGrowthThirdColor());
        return isChecked(getAdxGrowthThirdColor());
    }

    public boolean isAdxMinusDIThirdColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxMinusDIThirdColor());
        return isChecked(getAdxMinusDIThirdColor());
    }

    public boolean isAdxMinusDISecondColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxMinusDISecondColor());
        return isChecked(getAdxMinusDISecondColor());
    }

    public boolean isAdxPlusDIFourthColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxPlusDIFourthColor());
        return isChecked(getAdxPlusDIFourthColor());
    }

    public boolean isAdxPlusDIThirdColorChosen() {
        customDownSwipe(200);
        rightHorizontalSwipeInElement(getAdxPlusDIThirdColor());
        return isChecked(getAdxPlusDIThirdColor());
    }

    public boolean isAdxFirstColorChosen() {
        customDownSwipe(400);
        rightHorizontalSwipeInElement(getAdxFirstColor());
        return isChecked(getAdxFirstColor());
    }

    public boolean isAdxSixthColorChosen() {
        customDownSwipe(400);
        rightHorizontalSwipeInElement(getAdxSixthColor());
        return isChecked(getAdxSixthColor());
    }

    public boolean isShowZonesSwitchChosen() {
        swipeUntilFoundAndroidPanel(getShowZonesSwitch());
        return isChecked(getShowZonesSwitch());
    }

    @Step("Click Apply button")
    public TradingPage clickApplyButton() {
        tryClick(_applyButton);
        mobileDriver.makeScreen();
        return new TradingPageAndroid(mobileDriver);
    }

    public TradingPage clickSocialTradingApplyButton() {
        swipeUntilFoundAndroidPanel(_applyButton);
        tryClick(_applyButton);
        return new TradingPageAndroid(mobileDriver);
    }

    public void checkSettingsPanelHeader(Indicator indicator) {
        assertThat(getIndicatorSettingsHeaderText())
                .withFailMessage("Expected header title " + indicator.getValue() +
                        " but found " + getIndicatorSettingsHeaderText())
                .isEqualToIgnoringCase(indicator.getValue());
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.example.broker.beta:id/fastLinePeriodField']//*[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _scalpProFastLineField;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.broker.beta:id/slowLinePeriodField']//*[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _scalpProSlowLineField;
    @AndroidFindBy(xpath = "//*[@resource-id='com.example.broker.beta:id/smoothnessField']//*[@resource-id='com.example.broker.beta:id/field']")
    private AndroidElement _scalpProSmoothnessField;

    public void changeFastLineTo(int num) {
        clearAndSendKeys(_scalpProFastLineField, Integer.toString(num));
    }
    public void changeSlowLineTo(int num) {
        clearAndSendKeys(_scalpProSlowLineField, Integer.toString(num));
    }
    public void changeSmoothnessTo(int num) {
        clearAndSendKeys(_scalpProSmoothnessField, Integer.toString(num));
    }
    public int getFastLine() {
        return Integer.parseInt(_scalpProFastLineField.getText());
    }
    public int getSlowLine() {
        return Integer.parseInt(_scalpProSlowLineField.getText());
    }
    public int getSmoothness() {
        return Integer.parseInt(_scalpProSmoothnessField.getText());
    }
}
