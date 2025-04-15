package com.example.JMobile.framework.POM.PagesIOS.Pages;

import com.example.JMobile.framework.Enums.ExceptionMessages;
import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.PanelsIOS.*;
import com.example.JMobile.framework.POM.PagesIOS.PopUps.*;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.*;
import com.example.JMobile.framework.POM.Steps.PopUps.*;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TradingPageIOS extends TradingPage {

    @iOSXCUITFindBy(accessibility = "TradingView")
    private IOSElement _tradingPage;

    @iOSXCUITFindBy(accessibility = "AccountBalanceTitleLabel")
    private IOSElement _accountTypeValue;

    @iOSXCUITFindBy(accessibility = "AccountBalanceDescriptionLabel")
    private IOSElement _accountBalanceValue;

    @iOSXCUITFindBy(accessibility = "AccountsListView")
    private IOSElement _accountTypesPanel;

    @iOSXCUITFindBy(accessibility = "TournamentButton")
    private IOSElement _tournamentWidget;

    @iOSXCUITFindBy(accessibility = "TournamentPlaceLabel")
    private IOSElement _tournamentPlaceValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TournamentButton']/following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[2]")
    private IOSElement _timeToTournamentEndValue;

    @iOSXCUITFindBy(accessibility = "refresh icon")
    private IOSElement _refreshBalanceButton;

    @iOSXCUITFindBy(accessibility = "TopPanelLargePaymentButton")
    private IOSElement _rebuyButton;

    @iOSXCUITFindBy(accessibility = "TopPanelLargePaymentButton")
    private IOSElement _depositButton;

    @iOSXCUITFindBy(accessibility = "UserStatusButton")
    private IOSElement _userStatusButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Personal progress']")
    private IOSElement _userStatusPanel;

    @iOSXCUITFindBy(accessibility = "ChartView")
    private IOSElement _chartContainer;

    @iOSXCUITFindBy(accessibility = "ChartTypeSelector")
    private IOSElement _chartTypeButton;

    @iOSXCUITFindBy(accessibility = "ChartTypesListView")
    private IOSElement _chartTypesPanel;

    @iOSXCUITFindBy(accessibility = "TimeframeSelectorText")
    private IOSElement _chartTimeframeButton;

    @iOSXCUITFindBy(accessibility = "TimeframeListView")
    private IOSElement _chartTimeframesPanel;

    @iOSXCUITFindBy(accessibility = "IndicatorSelector")
    private IOSElement _indicatorsButton;

    @iOSXCUITFindBy(accessibility = "IndicatorsListView")
    private IOSElement _indicatorsPanel;

    @iOSXCUITFindBy(accessibility = "SelectedAssetIncomeView")
    private IOSElement _investmentIncomeContainer;

    @iOSXCUITFindBy(accessibility = "SelectedAssetInvestmentsLabel")
    private IOSElement _totalInvestmentValue;

    @iOSXCUITFindBy(accessibility = "SelectedAssetIncomeLabel")
    private IOSElement _expectedIncomeValue;

    @iOSXCUITFindBy(accessibility = "SelectedAssetTitleLabel")
    private IOSElement _assetTypeValue;

    @iOSXCUITFindBy(accessibility = "SelectedAssetDescriptionLabel")
    private IOSElement _assetNameValue;

    @iOSXCUITFindBy(accessibility = "AssetsMenuView")
    private IOSElement _assetsPanel;

    @iOSXCUITFindBy(accessibility = "ExiryDescriptionLabel")
    private IOSElement _expirationTimeValue;

    @iOSXCUITFindBy(accessibility = "ExpirationTimeSelectorList")
    private IOSElement _expirationTimePanel;

    @iOSXCUITFindBy(accessibility = "InvestmentDescriptionLabel")
    private IOSElement _investmentAmountValue;

    @iOSXCUITFindBy(accessibility = "InvestmentListView")
    private IOSElement _investmentsPanel;

    @iOSXCUITFindBy(accessibility = "StrikePriceButton")
    private IOSElement _strikePriceButton;

    @iOSXCUITFindBy(accessibility = "StrikePriceButton")
    private IOSElement _strikePricePanel;

    @iOSXCUITFindBy(accessibility = "EmailConfirmationModalIcon")
    private IOSElement _chooseAccountPopUp;

    @iOSXCUITFindBy(accessibility = "CFDTradingPanelCallButton")
    private IOSElement _trendDealUpButton;

    @iOSXCUITFindBy(accessibility = "CFDTradingPanelPutButton")
    private IOSElement _trendDealDownButton;

    @iOSXCUITFindBy(accessibility = "CFDTradingPanelComissionDescriptionLabel")
    private IOSElement _dealCommissionValue;

    @iOSXCUITFindBy(accessibility = "CFDTradingPanelOpenTradeButton")
    private IOSElement _createCfdDealButton;

    @iOSXCUITFindBy(accessibility = "CallButton")
    private IOSElement _createFttDealUpButton;

    @iOSXCUITFindBy(accessibility = "PutButton")
    private IOSElement _createFttDealDownButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='CallButton']/following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText")
    private IOSElement _freeTradesTimerItem;

    @iOSXCUITFindBy(accessibility = "MoreButton")
    private IOSElement _userMenuButton;

    @iOSXCUITFindBy(accessibility = "majorityOpinionImageView")
    private IOSElement _majorityOpinionItem;

    @iOSXCUITFindBy(accessibility = "PostSignUpModalCloseButton")
    private IOSElement _postSignUpModalView;

    @iOSXCUITFindBy(accessibility = "PostSignUpModalCloseButton")
    private IOSElement _postSignUpModalCloseButton;

    @iOSXCUITFindBy(accessibility = "The balance was successfully replenished")
    private IOSElement _successfulReplenishPopUp;

    @iOSXCUITFindBy(accessibility = "Deposit didn't work?")
    private IOSElement _paymentPopupHolderPaymentMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='UnavailableAssetAlertView']//XCUIElementTypeImage")
    private IOSElement _upgradeStatusPopupIcon;

    @iOSXCUITFindBy(accessibility = "UnavailableAssetAlertDescriptionLabel")
    private IOSElement _upgradeStatusPopupMessage;

    @iOSXCUITFindBy(accessibility = "UnavailableAssetAlertPaymentButton")
    private IOSElement _upgradeStatusPopupButton;

    @iOSXCUITFindBy(id = "docVerificationPopup")
    private IOSElement _docVerificationPopup;

    @iOSXCUITFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/docVerificationPopup']/android.widget.ImageView[@resource-id='com.example.broker.beta:id/icon']")
    private IOSElement _docVerificationPopupIcon;

    @iOSXCUITFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/docVerificationPopup']/android.widget.ImageView[@resource-id='com.example.broker.beta:id/message']")
    private IOSElement _docVerificationPopupMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please wait for current trade to close']")
    private IOSElement _freeTradesTimerPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please wait for current trade to close']")
    private IOSElement _freeTradesTimerPopupMessage;

    @iOSXCUITFindBy(id = "upgradeStatusContentLayout")
    private IOSElement _provocationPopUp;

    @iOSXCUITFindBy(id = "upgradeStatusMessage")
    private IOSElement _provocationPopUpMessage;

    @iOSXCUITFindBy(accessibility = "CardDismissView")
    private IOSElement _touchOutside;

    @iOSXCUITFindBy(id = "nextStatusProgressRoot")
    private IOSElement _nextStatusProgressPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='NoticeStackView']//XCUIElementTypeStaticText[@name='New bonus available']")
    private IOSElement _bonusPopUp;

    @iOSXCUITFindBy(accessibility = "New bonus available")
    private IOSElement _bonusPopUpTitle;

    @iOSXCUITFindBy(accessibility = "Not Now")
    private IOSElement _notSavingPswdPopUp;


    public TradingPageIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    @Override
    public void closeHallOfFame() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    @Override
    public NextStatusFullScreenPopUp nextStatusFullScreenPopUp() {
        return new NextStatusFullScreenPopUpIOS(mobileDriver);
    }


    public IOSElement getAccountTypeValue() { return _accountTypeValue; }

    public IOSElement getAccountBalanceValue() { return _accountBalanceValue; }

    public IOSElement getAccountTypesPanel() { return _accountTypesPanel; }

    public IOSElement getTournamentWidget() { return _tournamentWidget; }

    public IOSElement getTournamentPlaceValue() { return _tournamentPlaceValue; }

    public IOSElement getTimeToTournamentEndValue() { return _timeToTournamentEndValue; }

    public IOSElement getRefreshBalanceButton() { return _refreshBalanceButton; }

    public IOSElement getRebuyButton() { return _rebuyButton; }

    public IOSElement getDepositButton() { return _depositButton; }

    public IOSElement getUserStatusButton() { return _userStatusButton; }

    public IOSElement getUserStatusPanel() { return _userStatusPanel; }

    public IOSElement getChartContainer() { return _chartContainer; }

    public IOSElement getChartTypeButton() { return _chartTypeButton; }

    public IOSElement getChartTypesPanel() { return _chartTypesPanel; }

    public IOSElement getChartTimeframesPanel() { return _chartTimeframesPanel; }

    public IOSElement getChartTimeframeButton() { return _chartTimeframeButton; }

    public IOSElement getIndicatorsButton() { return _indicatorsButton; }

    public IOSElement getIndicatorsPanel() { return _indicatorsPanel; }

    public IOSElement getInvestmentIncomeContainer() { return _investmentIncomeContainer; }

    public IOSElement getTotalInvestmentValue() { return _totalInvestmentValue; }

    public IOSElement getExpectedIncomeValue() { return _expectedIncomeValue; }

    public IOSElement getAssetTypeValue() { return _assetTypeValue; }

    public IOSElement getAssetNameValue() { return _assetNameValue; }

    public IOSElement getExpirationTimeValue() { return _expirationTimeValue; }

    public IOSElement getExpirationTimePanel() { return _expirationTimePanel; }

    public IOSElement getInvestmentAmountValue() { return _investmentAmountValue; }

    public IOSElement getInvestmentsPanel() { return _investmentsPanel; }

    public IOSElement getStrikePriceButton() { return _strikePriceButton; }

    public IOSElement getTrendDealUpButton() { return _trendDealUpButton; }

    public IOSElement getTrendDealDownButton() { return _trendDealDownButton; }

    public IOSElement getDealCommissionValue() { return _dealCommissionValue; }

    public IOSElement getCreateCfdDealButton() { return _createCfdDealButton; }

    public IOSElement getCreateFttDealUpButton() { return _createFttDealUpButton; }

    public IOSElement getCreateFttDealDownButton() { return _createFttDealDownButton; }

    public IOSElement getFreeTradesTimerItem() { return _freeTradesTimerItem; }

    public IOSElement getMajorityOpinionItem() { return _majorityOpinionItem; }

    public IOSElement getPostSignUpModalView() { return _postSignUpModalView; }

    public IOSElement getPostSignUpModalCloseButton() { return _postSignUpModalCloseButton; }

    public IOSElement getUncompletedDepositPopUp() { return _successfulReplenishPopUp; }

    public IOSElement getPaymentPopupHolderPaymentMessage() { return _paymentPopupHolderPaymentMessage; }

    public IOSElement getUpgradeStatusPopupIcon() { return _upgradeStatusPopupIcon; }

    public IOSElement getUpgradeStatusPopupMessage() { return _upgradeStatusPopupMessage; }

    public IOSElement getUpgradeStatusPopupButton() { return _upgradeStatusPopupButton; }

    public IOSElement getDocVerificationPopup() { return _docVerificationPopup; }

    public IOSElement getDocVerificationPopupIcon() { return _docVerificationPopupIcon; }

    public IOSElement getDocVerificationPopupMessage() { return _docVerificationPopupMessage; }

    public IOSElement getFreeTradesTimerPopup() { return _freeTradesTimerPopup; }

    public IOSElement getFreeTradesTimerPopupMessage() { return _freeTradesTimerPopupMessage; }

    public IOSElement getProvocationPopUp() { return _provocationPopUp; }

    public IOSElement getProvocationPopUpMessage() { return _provocationPopUpMessage; }

    public IOSElement getTouchOutsideSpace() { return _touchOutside; }

    public IOSElement getNextStatusProgressPopUp() { return _nextStatusProgressPopUp; }

    public IOSElement getBonusPopUp() { return _bonusPopUp; }

    public IOSElement getBonusPopUpTitle() { return _bonusPopUpTitle; }

    public IOSElement getNotSavingPswdPopUp() { return _notSavingPswdPopUp; }

    @Step("Проверить открытие трейдрума")
    public TradingPageIOS checkTradingPage() {
        tryClickWithWait(getNotSavingPswdPopUp());
        getWait().withMessage("Trading page is not displayed").until(d ->
                isDisplayed(_tradingPage));
        return this;
    }

    @Step("Проверить открытие панели выбора счета")
    public BalancePanel checkBalancePanel() {
        getWait().withMessage("Balance spinner is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_accountTypesPanel));
        return new BalancePanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели персонального прогресса")
    public PersonalProgressPopUp checkStatusesPopUpPanel() {
        getWait().withMessage("Balance spinner is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_userStatusPanel));
        return new PersonalProgressPopUpIOS(mobileDriver);
    }

    @Step("Проверить открытие панели выбора типа графика")
    public ChartTypePanel checkChartTypesPanel() {
        getWait().withMessage("Chart types panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_chartTypesPanel));
        return new ChartTypePanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели выбора таймфрейма графика")
    public TimeframePanel checkChartTimeframesPanel() {
        getWait().withMessage("Chart timeframes panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_chartTimeframesPanel));
        return new TimeframePanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели индикаторов")
    public IndicatorsPanel checkIndicatorsPanel() {
        getWait().withMessage("Indicators panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_indicatorsPanel));
        return new IndicatorsPanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели выбора актива")
    public AssetsPanel checkAssetsPanel() {
        getWait().withMessage("Assets panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_assetsPanel));
        return new AssetsPanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели суммы инвестиции")
    public ExpirationTimePanel checkExpirationPanel() {
        getWait().withMessage("Investments panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_expirationTimePanel));
        return new ExpirationTimePanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели суммы инвестиции")
    public InvestmentsPanel checkInvestmentsPanel() {
        getWait().withMessage("Investments panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_investmentsPanel));
        return new InvestmentsPanelIOS(mobileDriver);
    }

    @Step("Проверить открытие панели выбора страйка")
    public StrikeDealsPanel checkStrikeDealPanel() {
        getWait().withMessage("Strike price panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_strikePricePanel));
        return new StrikeDealsPanelIOS(mobileDriver);
    }

    @Step("Проверить открытие попапа перехода на следующий статус")
    public NextStatusProgressPopUp checkNextStatusProgressPopUp() {
        getWait().withMessage("Next status progress popup is not displayed").until(d ->
                isDisplayed(_nextStatusProgressPopUp));
        return new NextStatusProgressPopUpIOS(mobileDriver);
    }


    public boolean isUserMenuButtonExists() {
        return tryDisplayed(_userMenuButton);
    }

    @Step("Нажать на виджет турнира")
    public TournamentCardContainerPanel clickTournamentWidget() {
        tryClick(_tournamentWidget);
        return new TournamentCardContainerPanelIOS(mobileDriver);
    }

    @Step("Нажать кнопку Deposit")
    public CashierDepositPage clickMakeDepositButton() {
        tryClick(_depositButton);
        return new CashierDepositPageIOS(mobileDriver);
    }

    @Override
    public CashierDepositPage clickMakeDepositNativeButton() {
        throw new NotImplementedException("native cashier is not implemented on ios");
    }

    @Step("Открыть пользовательское меню")
    public PanelUserMenu clickUserMenuButton() {
        tryClick(_userMenuButton);
        return new PanelUserMenuIOS(mobileDriver);
    }

    public TransactionHistoryPanel clickTradesTabButton() {
        PanelUserMenu panelUserMenu = clickUserMenuButton()
                .checkPanelUserMenu();
        return panelUserMenu.clickTransactionHistoryButton()
                .checkTransactionHistoryPanel();
    }

    public TradingPage clickTraderoomTabButton() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    public TournamentsListContainerPanel clickTournamentTabButton() {
        PanelUserMenu panelUserMenu = clickUserMenuButton();
        return panelUserMenu.clickTournamentsButton();
    }

    public AccountTab clickProfileTabButton() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    @Step("Нажать на попап")
    public UncompletedDepositPopUp clickUncompletedDepositPopup() {
        tryDisplayed(_paymentPopupHolderPaymentMessage);
        tryClickWithWait(_paymentPopupHolderPaymentMessage);
        return new UncompletedDepositPopUpIOS(mobileDriver);
    }

    @Step("Нажать на попап")
    public StatusesPanel clickUpgradeStatusPopupButtonByStatusesPage() {
        tryClickWithWait(_upgradeStatusPopupButton);
        return new StatusesPanelIOS(mobileDriver);
    }

    @Step("Нажать на попап")
    public CashierDepositPage clickUpgradeStatusPopupButtonByCashierPage() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    @Override
    public NativeCashierDepositPageAndroid clickUpgradeStatusPopupNativeButtonByCashierPage() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_IOS);
    }

    @Step("Нажать на попап")
    public VerificationPanel clickVerificationPopup() {
        tryClickWithWait(_docVerificationPopup);
        return new VerificationPanelIOS(mobileDriver);
    }

    @Step("Нажать на тост начисленного бонуса")
    public BonusInformationPanel clickBonusPopUp() {
        tryClick(_bonusPopUp);
        return new BonusInformationPanelIOS(mobileDriver);
    }

    public InsufficientFundsPopUp createDealNoBalance(Boolean isDealDirectionUp) {
        createDeal(isDealDirectionUp);
        return new InsufficientFundsPopUpiOS(mobileDriver);
    }
}
