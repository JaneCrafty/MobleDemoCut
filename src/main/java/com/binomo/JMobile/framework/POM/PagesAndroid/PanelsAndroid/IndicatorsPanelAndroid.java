package com.example.JMobile.framework.POM.PagesAndroid.PanelsAndroid;

import com.example.JMobile.framework.Enums.Indicator;
import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsPanel;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsSettingsPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static io.qameta.allure.Allure.step;

public class IndicatorsPanelAndroid extends IndicatorsPanel {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/headerTitle' and @text='Indicators']")
    private AndroidElement _indicatorsMenuHeader;

    @AndroidFindBy(id = "indicatorsListRoot")
    private AndroidElement _indicatorsPanelLayout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/tabMetaGroupName' and @text='Available']")
    private AndroidElement _availableIndicatorsMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/tabMetaGroupName' and @text='Active']")
    private AndroidElement _activeIndicatorsMenuItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Social Trading']")
    private AndroidElement _socialTradingIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Moving Average']")
    private AndroidElement _movingAverageIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Alligator']")
    private AndroidElement _alligatorIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Bollinger Bands']")
    private AndroidElement _bollingerIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Parabolic SAR']")
    private AndroidElement _pSarIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Fractals']")
    private AndroidElement _fractalsIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Fractal Chaos Bands']")
    private AndroidElement _fractalChaosBandsIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='RSI']")
    private AndroidElement _rsiIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='MACD']")
    private AndroidElement _macdIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='CCI']")
    private AndroidElement _cciIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='Stochastic']")
    private AndroidElement _stochasticIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='ATR']")
    private AndroidElement _atrIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/indicatorName' and @text='ADX']")
    private AndroidElement _adxIndicatorAvailableItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Social Trading']")
    private AndroidElement _socialTradingIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Moving Average']")
    private AndroidElement _movingAverageIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Alligator']")
    private AndroidElement _alligatorIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Bollinger Bands']")
    private AndroidElement _bollingerIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Parabolic SAR']")
    private AndroidElement _pSarIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Fractals']")
    private AndroidElement _fractalsIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Fractal Chaos Bands']")
    private AndroidElement _fractalChaosBandsIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='RSI']")
    private AndroidElement _rsiIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='MACD']")
    private AndroidElement _macdIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='CCI']")
    private AndroidElement _cciIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Stochastic']")
    private AndroidElement _stochasticIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='ATR']")
    private AndroidElement _atrIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/indicatorName']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='ADX']")
    private AndroidElement _adxIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Social Trading']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeSocialTradingIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Moving Average']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeMovingAverageIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Alligator']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeAlligatorIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Bollinger Bands']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeBollingerIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Parabolic SAR']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removePSarIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Fractals']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeFractalsIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Fractal Chaos Bands']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeFractalChaosBandsIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='RSI']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeRSIIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='MACD']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeMACDIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='CCI']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeCCIIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Stochastic']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeStochasticIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='ATR']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeATRIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='ADX']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/removeButton']")
    private AndroidElement _removeADXIndicatorItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Moving Average']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editMovingAverageIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Alligator']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editAlligatorIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Bollinger Bands']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editBollingerIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Parabolic SAR']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editPSarIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Fractals']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editFractalsIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Fractal Chaos Bands']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editFractalChaosBandsIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='RSI']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editRSIIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='MACD']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editMACDIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='CCI']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editCCIIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='Stochastic']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editStochasticIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='ATR']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editATRIndicatorActiveItem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText' and @text='ADX']/ancestor::*/android.widget.ImageButton[@resource-id='com.example.broker.beta:id/editButton']")
    private AndroidElement _editADXIndicatorActiveItem;

    @AndroidFindBy(id = "visibilityButton")
    private AndroidElement _indicatorVisibleButton;

    @AndroidFindBy(id = "indicatorName")
    private List<AndroidElement> _indicatorNames;


    public IndicatorsPanelAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    @AndroidFindBy(id = "editButton")
    private AndroidElement _editButton;

    @Override
    public void clickEditFirstIndicator() {
        tryClick(_editButton);
    }


    public AndroidElement getIndicatorsMenuHeader() { return _indicatorsMenuHeader; }

    public AndroidElement getIndicatorsPanelLayout() { return _indicatorsPanelLayout; }

    public AndroidElement getAvailableIndicatorsMenuItem() { return _availableIndicatorsMenuItem; }

    public AndroidElement getActiveIndicatorsMenuItem() { return _activeIndicatorsMenuItem; }

    public AndroidElement getSocialTradingIndicatorAvailableItem() { return _socialTradingIndicatorAvailableItem; }

    public AndroidElement getSocialTradingIndicatorActiveItem() { return _socialTradingIndicatorActiveItem; }

    public AndroidElement getMovingAverageIndicatorActiveItem() { return _movingAverageIndicatorActiveItem; }

    public AndroidElement getAlligatorIndicatorActiveItem() { return _alligatorIndicatorActiveItem; }

    public AndroidElement getBollingerIndicatorActiveItem() { return _bollingerIndicatorActiveItem; }

    public AndroidElement getPSarIndicatorActiveItem() { return _pSarIndicatorActiveItem; }

    public AndroidElement getFractalsIndicatorActiveItem() { return _fractalsIndicatorActiveItem; }

    public AndroidElement getFractalChaosBandsIndicatorActiveItem() { return _fractalChaosBandsIndicatorActiveItem; }

    public AndroidElement getRSIIndicatorActiveItem() { return _rsiIndicatorActiveItem; }

    public AndroidElement getMACDIndicatorActiveItem() { return _macdIndicatorActiveItem; }

    public AndroidElement getCCIIndicatorActiveItem() { return _cciIndicatorActiveItem; }

    public AndroidElement getStochasticIndicatorActiveItem() { return _stochasticIndicatorActiveItem; }

    public AndroidElement getATRIndicatorActiveItem() { return _atrIndicatorActiveItem; }

    public AndroidElement getADXIndicatorActiveItem() { return _adxIndicatorActiveItem; }

    public AndroidElement getRemoveSocialTradingIndicatorItem() { return _removeSocialTradingIndicatorItem; }

    public AndroidElement getRemoveMovingAverageIndicatorItem() { return _removeMovingAverageIndicatorItem; }

    public AndroidElement getRemoveAlligatorIndicatorItem() { return _removeAlligatorIndicatorItem; }

    public AndroidElement getRemoveBollingerIndicatorItem() { return _removeBollingerIndicatorItem; }

    public AndroidElement getRemovePSarIndicatorItem() { return _removePSarIndicatorItem; }

    public AndroidElement getRemoveFractalsIndicatorItem() { return _removeFractalsIndicatorItem; }

    public AndroidElement getRemoveFractalChaosBandsIndicatorItem() { return _removeFractalChaosBandsIndicatorItem; }

    public AndroidElement getRemoveRSIIndicatorItem() { return _removeRSIIndicatorItem; }

    public AndroidElement getRemoveMACDIndicatorItem() { return _removeMACDIndicatorItem; }

    public AndroidElement getRemoveCCIIndicatorItem() { return _removeCCIIndicatorItem; }

    public AndroidElement getRemoveStochasticIndicatorItem() { return _removeStochasticIndicatorItem; }

    public AndroidElement getRemoveATRIndicatorItem() { return _removeATRIndicatorItem; }

    public AndroidElement getRemoveADXIndicatorItem() { return _removeADXIndicatorItem; }

    public AndroidElement getEditAlligatorIndicatorActiveItem() { return _editAlligatorIndicatorActiveItem; }

    public AndroidElement getIndicatorVisibleButton() { return _indicatorVisibleButton; }


    public boolean getStatusIndicatorVisibleButton() {
        return isSelected(_indicatorVisibleButton);
    }

    public IndicatorsSettingsPanel chooseSocialTrading() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_socialTradingIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseMovingAverage() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_movingAverageIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseAlligator() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_alligatorIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseBollinger() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_bollingerIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel choosePSar() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_pSarIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseFractals() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_fractalsIndicatorAvailableItem);
        tryClick(_fractalsIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseFractalChaosBands() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_fractalChaosBandsIndicatorAvailableItem);
        tryClick(_fractalChaosBandsIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseRSI() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_rsiIndicatorAvailableItem);
        tryClick(_rsiIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseMACD() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_macdIndicatorAvailableItem);
        tryClick(_macdIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseCCI() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_cciIndicatorAvailableItem);
        tryClick(_cciIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseStochastic() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_stochasticIndicatorAvailableItem);
        tryClick(_stochasticIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseATR() {
        tryClick(_availableIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_atrIndicatorAvailableItem);
        tryClick(_atrIndicatorAvailableItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseADX() {
        step("Start choose adx", () -> mobileDriver.makeScreen());
        tryClick(_availableIndicatorsMenuItem);
        step("Before swipe", () -> mobileDriver.makeScreen());
        swipeUntilFoundAndroidPanel(_adxIndicatorAvailableItem);
        step("Before click", () -> mobileDriver.makeScreen());
        tryClick(_adxIndicatorAvailableItem);
        step("End choose adx", () -> mobileDriver.makeScreen());
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditMovingAverage() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editMovingAverageIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditAlligator() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editAlligatorIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditBollinger() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editBollingerIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditPSar() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editPSarIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditFractals() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_fractalsIndicatorActiveItem);
        tryClick(_editFractalsIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditFractalChaosBands() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_fractalChaosBandsIndicatorActiveItem);
        tryClick(_editFractalChaosBandsIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditRSI() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_rsiIndicatorActiveItem);
        tryClick(_editRSIIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditMACD() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_macdIndicatorActiveItem);
        tryClick(_editMACDIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditCCI() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_cciIndicatorActiveItem);
        tryClick(_editCCIIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditStochastic() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_stochasticIndicatorActiveItem);
        tryClick(_editStochasticIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditATR() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_atrIndicatorActiveItem);
        tryClick(_editATRIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditADX() {
        tryClick(_activeIndicatorsMenuItem);
        swipeUntilFoundAndroidPanel(_adxIndicatorActiveItem);
        tryClick(_editADXIndicatorActiveItem);
        return new IndicatorsSettingsPanelAndroid(mobileDriver);
    }

    public TradingPage clickCloseButton() {
        clickClosePanelButton();
        return new TradingPageAndroid(mobileDriver);
    }

    public TradingPage swipeForClosingIndicatorsPanel() {
        swipeDownForClosingPanel(_indicatorsPanelLayout);
        return new TradingPageAndroid(mobileDriver);
    }

    public TradingPage tapForClosingIndicatorsPanel() {
        clickOutsidePanel();
        return new TradingPageAndroid(mobileDriver);
    }

    public IndicatorsSettingsPanelAndroid chooseIndicatorByName(Indicator name) {
        tryClick(_availableIndicatorsMenuItem);
        for (int i = 0; i < 3; i++) {
            for (AndroidElement element : _indicatorNames) {
                if (element.getText().equals(name.getValue())) {
                    tryClick(element);
                    return new IndicatorsSettingsPanelAndroid(mobileDriver);
                }
            }
            customDownSwipe(500);
        }
        throw new RuntimeException("Indicator not found: " + name.getValue());
    }
}
