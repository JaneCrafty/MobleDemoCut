package com.example.JMobile.framework.POM.PagesIOS.PanelsIOS;

import com.example.JMobile.framework.Enums.ExceptionMessages;
import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsPanel;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsSettingsPanel;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.support.PageFactory;

public class IndicatorsPanelIOS extends IndicatorsPanel {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Indicators']")
    private IOSElement _indicatorsMenuHeader;

    @iOSXCUITFindBy(accessibility = "IndicatorsListView")
    private IOSElement _indicatorsPanelLayout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TradingView']/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private IOSElement _closeButtonIndicatorPanel;

    @iOSXCUITFindBy(accessibility = "CardDismissView")
    private IOSElement _touchOutside;

    @iOSXCUITFindBy(accessibility = "AvaliableFilterCell")
    private IOSElement _availableIndicatorsMenuItem;

    @iOSXCUITFindBy(accessibility = "ActiveFilterCell")
    private IOSElement _activeIndicatorsMenuItem;

    @iOSXCUITFindBy(accessibility = "SocialTradingCell")
    private IOSElement _socialTradingIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "MovingAverageCell")
    private IOSElement _movingAverageIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "AlligatorCell")
    private IOSElement _alligatorIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "BollingerCell")
    private IOSElement _bollingerIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "RelativeStrengthIndexCell")
    private IOSElement _rsiIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "MovingAverageConvergenceDivergenceCell")
    private IOSElement _macdIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "AverageTrueRangeCell")
    private IOSElement _atrIndicatorAvailableItem;

    @iOSXCUITFindBy(accessibility = "SocialTradingCell")
    private IOSElement _socialTradingIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "MovingAverageCell")
    private IOSElement _movingAverageIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "AlligatorCell")
    private IOSElement _alligatorIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "BollingerCell")
    private IOSElement _bollingerIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "RelativeStrengthIndexCell")
    private IOSElement _rsiIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "MovingAverageConvergenceDivergenceCell")
    private IOSElement _macdIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "AverageTrueRangeCell")
    private IOSElement _atrIndicatorActiveItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='SocialTradingCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeSocialTradingIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='MovingAverageCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeMovingAverageIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='AlligatorCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeAlligatorIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='BollingerCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeBollingerIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='RelativeStrengthIndexCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeRSIIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='MovingAverageConvergenceDivergenceCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeMACDIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='AverageTrueRangeCell']/XCUIElementTypeButton[@name='IndicatorDeleteButton']")
    private IOSElement _removeATRIndicatorItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='MovingAverageCell']/XCUIElementTypeButton[@name='IndicatorEditButton']")
    private IOSElement _editMovingAverageIndicatorActiveItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='AlligatorCell']/XCUIElementTypeButton[@name='IndicatorEditButton']")
    private IOSElement _editAlligatorIndicatorActiveItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='BollingerCell']/XCUIElementTypeButton[@name='IndicatorEditButton']")
    private IOSElement _editBollingerIndicatorActiveItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='RelativeStrengthIndexCell']/XCUIElementTypeButton[@name='IndicatorEditButton']")
    private IOSElement _editRSIIndicatorActiveItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='MovingAverageConvergenceDivergenceCell']/XCUIElementTypeButton[@name='IndicatorEditButton']")
    private IOSElement _editMACDIndicatorActiveItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='AverageTrueRangeCell']/XCUIElementTypeButton[@name='IndicatorEditButton']")
    private IOSElement _editATRIndicatorActiveItem;

    @iOSXCUITFindBy(accessibility = "IndicatorVisibleButton")
    private IOSElement _indicatorVisibleButton;


    public IndicatorsPanelIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    @Override
    public void clickEditFirstIndicator() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }


    public IOSElement getIndicatorsMenuHeader() { return _indicatorsMenuHeader; }

    public IOSElement getIndicatorsPanelLayout() { return _indicatorsPanelLayout; }

    public IOSElement getAvailableIndicatorsMenuItem() { return _availableIndicatorsMenuItem; }

    public IOSElement getActiveIndicatorsMenuItem() { return _activeIndicatorsMenuItem; }

    public IOSElement getSocialTradingIndicatorAvailableItem() { return _socialTradingIndicatorAvailableItem; }

    public IOSElement getSocialTradingIndicatorActiveItem() { return _socialTradingIndicatorActiveItem; }

    public IOSElement getMovingAverageIndicatorActiveItem() { return _movingAverageIndicatorActiveItem; }

    public IOSElement getAlligatorIndicatorActiveItem() { return _alligatorIndicatorActiveItem; }

    public IOSElement getBollingerIndicatorActiveItem() { return _bollingerIndicatorActiveItem; }

    public IOSElement getPSarIndicatorActiveItem() { return null; }

    public IOSElement getFractalsIndicatorActiveItem() { return null; }

    public IOSElement getFractalChaosBandsIndicatorActiveItem() { return null; }

    public IOSElement getRSIIndicatorActiveItem() { return _rsiIndicatorActiveItem; }

    public IOSElement getMACDIndicatorActiveItem() { return _macdIndicatorActiveItem; }

    public IOSElement getCCIIndicatorActiveItem() { return null; }

    public IOSElement getStochasticIndicatorActiveItem() { return null; }

    public IOSElement getATRIndicatorActiveItem() { return _atrIndicatorActiveItem; }

    public IOSElement getADXIndicatorActiveItem() { return null; }

    public IOSElement getRemoveSocialTradingIndicatorItem() { return _removeSocialTradingIndicatorItem; }

    public IOSElement getRemoveMovingAverageIndicatorItem() { return _removeMovingAverageIndicatorItem; }

    public IOSElement getRemoveAlligatorIndicatorItem() { return _removeAlligatorIndicatorItem; }

    public IOSElement getRemoveBollingerIndicatorItem() { return _removeBollingerIndicatorItem; }

    public IOSElement getRemovePSarIndicatorItem() { return null; }

    public IOSElement getRemoveFractalsIndicatorItem() { return null; }

    public IOSElement getRemoveFractalChaosBandsIndicatorItem() { return null; }

    public IOSElement getRemoveRSIIndicatorItem() { return _removeRSIIndicatorItem; }

    public IOSElement getRemoveMACDIndicatorItem() { return _removeMACDIndicatorItem; }

    public IOSElement getRemoveCCIIndicatorItem() { return null; }

    public IOSElement getRemoveStochasticIndicatorItem() { return null; }

    public IOSElement getRemoveATRIndicatorItem() { return _removeATRIndicatorItem; }

    public IOSElement getRemoveADXIndicatorItem() { return null; }

    public IOSElement getEditAlligatorIndicatorActiveItem() { return _editAlligatorIndicatorActiveItem; }

    public IOSElement getIndicatorVisibleButton() { return _indicatorVisibleButton; }


    public boolean getStatusIndicatorVisibleButton() {
        String Status = getIndicatorVisibleButton().getAttribute("label");
        if (Status.equals("icon visible"))
            return true;
        else
            return false;
    }

    public IndicatorsSettingsPanel chooseSocialTrading() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_socialTradingIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseMovingAverage() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_movingAverageIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseAlligator() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_alligatorIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseBollinger() {
        tryClick(_availableIndicatorsMenuItem);
        tryClick(_bollingerIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel choosePSar() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel chooseFractals() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel chooseFractalChaosBands() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel chooseRSI() {
        tryClick(_availableIndicatorsMenuItem);
        swipeDownUntilFoundInPanelIos(_rsiIndicatorAvailableItem);
        tryClick(_rsiIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseMACD() {
        tryClick(_availableIndicatorsMenuItem);
        swipeDownUntilFoundInPanelIos(_macdIndicatorAvailableItem);
        tryClick(_macdIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseCCI() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel chooseStochastic() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel chooseATR() {
        tryClick(_availableIndicatorsMenuItem);
        swipeDownUntilFoundInPanelIos(_atrIndicatorAvailableItem);
        tryClick(_atrIndicatorAvailableItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel chooseADX() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel clickEditMovingAverage() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editMovingAverageIndicatorActiveItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditAlligator() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editAlligatorIndicatorActiveItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditBollinger() {
        tryClick(_activeIndicatorsMenuItem);
        tryClick(_editBollingerIndicatorActiveItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditPSar() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel clickEditFractals() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel clickEditFractalChaosBands() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel clickEditRSI() {
        tryClick(_activeIndicatorsMenuItem);
        swipeDownUntilFoundInPanelIos(_rsiIndicatorActiveItem);
        tryClick(_editRSIIndicatorActiveItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditMACD() {
        tryClick(_activeIndicatorsMenuItem);
        swipeDownUntilFoundInPanelIos(_macdIndicatorActiveItem);
        tryClick(_editMACDIndicatorActiveItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditCCI() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel clickEditStochastic() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public IndicatorsSettingsPanel clickEditATR() {
        tryClick(_activeIndicatorsMenuItem);
        swipeDownUntilFoundInPanelIos(_atrIndicatorActiveItem);
        tryClick(_editATRIndicatorActiveItem);
        return new IndicatorsSettingsPanelIOS(mobileDriver);
    }

    public IndicatorsSettingsPanel clickEditADX() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public TradingPage clickCloseButton() {
        tryClick(_closeButtonIndicatorPanel);
        return new TradingPageIOS(mobileDriver);
    }

    public TradingPage swipeForClosingIndicatorsPanel() {
        swipeDownForClosingPanel(_indicatorsMenuHeader);
        return new TradingPageIOS(mobileDriver);
    }

    public TradingPage tapForClosingIndicatorsPanel() {
        tryClick(_touchOutside);
        return new TradingPageIOS(mobileDriver);
    }

}
