package com.example.JMobile.framework.POM.PagesAndroid.Pages;

import com.example.JMobile.framework.Enums.*;
import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.PanelsAndroid.*;
import com.example.JMobile.framework.POM.PagesAndroid.PopUps.*;
import com.example.JMobile.framework.POM.PagesVip.TradingPageVip;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.*;
import com.example.JMobile.framework.POM.Steps.PopUps.*;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.example.JMobile.framework.Enums.AccountTypes.REAL;
import static com.example.JMobile.framework.Enums.AccountTypes.TOURNAMENT;
import static org.assertj.core.api.Assertions.assertThat;

public class TradingPageAndroid extends TradingPage implements TradingPageVip {

    @AndroidFindBy(id = "tradingPlatformContainer")
    private AndroidElement _tradingPage;

    @AndroidFindBy(id = "vipTraderoomRoot")
    private AndroidElement _tradingPageVip;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/accountRoot']//android.widget.TextView[@resource-id='com.example.broker.beta:id/labelText']")
    private AndroidElement _accountTypeValue;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/accountRoot']//android.widget.TextView[@resource-id='com.example.broker.beta:id/contentText']")
    private AndroidElement _accountBalanceValue;

    @AndroidFindBy(id = "accountsRoot")
    private AndroidElement _accountTypesPanel;

    @AndroidFindBy(id = "tournamentButton")
    private AndroidElement _tournamentWidget;

    @AndroidFindBy(id = "tournamentPositionLabel")
    private AndroidElement _tournamentPlaceValue;

    @AndroidFindBy(id = "tournamentTimer")
    private AndroidElement _timeToTournamentEndValue;

    @AndroidFindBy(id = "refreshBalanceView")
    private AndroidElement _refreshBalanceButton;

    @AndroidFindBy(id = "paymentButton")
    private AndroidElement _rebuyButton;

    @AndroidFindBy(id = "paymentButton")
    private AndroidElement _depositButton;

    @AndroidFindBy(id = "depositButton")
    private AndroidElement _depositVipButton;

    @AndroidFindBy(id = "currentStatusView")
    private AndroidElement _userStatusButton;

    @AndroidFindBy(xpath = "nextStatusProgressRoot")
    private AndroidElement _userStatusPanel;

    @AndroidFindBy(id = "chartContainerView")
    private AndroidElement _chartContainer;

    @AndroidFindBy(id = "chartTypeIcon")
    private AndroidElement _chartTypeButton;

    @AndroidFindBy(id = "typesRecycler")
    private AndroidElement _chartTypesPanel;

    @AndroidFindBy(id = "timeFrameLabel")
    private AndroidElement _chartTimeframeButton;

    @AndroidFindBy(id = "timeFrameRoot")
    private AndroidElement _chartTimeframesPanel;

    @AndroidFindBy(id = "indicatorsIcon")
    private AndroidElement _indicatorsButton;

    @AndroidFindBy(id = "indicatorsListRoot")
    private AndroidElement _indicatorsPanel;

    @AndroidFindBy(id = "activeInvestmentRoot")
    private AndroidElement _investmentIncomeContainer;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.example.broker.beta:id/activeInvestmentRoot\"]" +
            "//android.widget.LinearLayout[@resource-id=\"com.example.broker.beta:id/amount\"]" +
            "//android.widget.TextView[@resource-id=\"com.example.broker.beta:id/valueLabel\"]")
    private AndroidElement _totalInvestmentValue;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.example.broker.beta:id/activeInvestmentRoot\"]" +
            "//android.widget.LinearLayout[@resource-id=\"com.example.broker.beta:id/income\"]" +
            "//android.widget.TextView[@resource-id=\"com.example.broker.beta:id/valueLabel\"]")
    private AndroidElement _expectedIncomeValue;

    @AndroidFindBy(id = "assetsLabel")
    private AndroidElement _assetTypeValue;

    @AndroidFindBy(id = "assetsName")
    private AndroidElement _assetNameValue;

    @AndroidFindBy(id = "assetsRoot")
    private AndroidElement _assetsPanel;

    @AndroidFindBy(id = "expirationValue")
    private AndroidElement _expirationTimeValue;

    @AndroidFindBy(id = "expirationRoot")
    private AndroidElement _expirationTimePanel;

    @AndroidFindBy(id = "investmentValue")
    private AndroidElement _investmentAmountValue;

    @AndroidFindBy(id = "investmentRoot")
    private AndroidElement _investmentsPanel;

    @AndroidFindBy(id = "strikeLabel")
    private AndroidElement _strikePriceButton;

    @AndroidFindBy(id = "strikesRecycler")
    private AndroidElement _strikePricePanel;

    @AndroidFindBy(id = "alertModalViewRoot")
    private AndroidElement _chooseAccountPopUp;

    @AndroidFindBy(id = "trendUpButton")
    private AndroidElement _trendDealUpButton;

    @AndroidFindBy(id = "trendDownButton")
    private AndroidElement _trendDealDownButton;

    @AndroidFindBy(id = "commission")
    private AndroidElement _dealCommissionValue;

    @AndroidFindBy(id = "createCfdDealButton")
    private AndroidElement _createCfdDealButton;

    @AndroidFindBy(id = "createDealUpLayout")
    private AndroidElement _createFttDealUpButton;

    @AndroidFindBy(id = "createDealDownLayout")
    private AndroidElement _createFttDealDownButton;

    @AndroidFindBy(id = "dealTimerRoot")
    private AndroidElement _freeTradesTimerItem;

    @AndroidFindBy(id = "tradesTab")
    private AndroidElement _tradesTabButton;

    @AndroidFindBy(id = "traderoomTab")
    private AndroidElement _traderoomTabButton;

    @AndroidFindBy(id = "tournamentsTab")
    private AndroidElement _tournamentTabButton;

    @AndroidFindBy(id = "profileTab")
    private AndroidElement _profileTabButton;

    @AndroidFindBy(id = "majorityOpinionRoot")
    private AndroidElement _majorityOpinionItem;

    @AndroidFindBy(id = "PostSignUpModalView")
    private AndroidElement _postSignUpModalView;

    @AndroidFindBy(id = "PostSignUpModalCloseButton")
    private AndroidElement _postSignUpModalCloseButton;

    @AndroidFindBy(id = "successPaymentPopupHolder")
    private AndroidElement _successfulReplenishPopUp;

    @AndroidFindBy(id = "payment_message")
    private AndroidElement _paymentPopupHolderPaymentMessage;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@resource-id='com.example.broker.beta:id/upgradeStatusRoot']//android.widget.ImageView[@resource-id='com.example.broker.beta:id/statusIcon']")
    private AndroidElement _upgradeStatusPopupIcon;

    @AndroidFindBy(id = "upgradeStatusMessage")
    private AndroidElement _upgradeStatusPopupMessage;

    //    @AndroidFindBy(id = "upgradeNowButton")
    @AndroidFindBy(id = "upgradeButton")
    private AndroidElement _upgradeStatusPopupButton;

    @AndroidFindBy(id = "docVerificationPopupRoot")
    private AndroidElement _docVerificationPopup;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/docVerificationPopupRoot']/android.widget.ImageView[@resource-id='com.example.broker.beta:id/icon']")
    private AndroidElement _docVerificationPopupIcon;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/docVerificationPopupRoot']/android.widget.TextView[@resource-id='com.example.broker.beta:id/message']")
    private AndroidElement _docVerificationPopupMessage;

    @AndroidFindBy(id = "riskFreeTradesTimerPopupRoot")
    private AndroidElement _freeTradesTimerPopup;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/popupsContainerLayout']//android.widget.TextView[@resource-id='com.example.broker.beta:id/message']")
    private AndroidElement _freeTradesTimerPopupMessage;

    @AndroidFindBy(id = "upgradeStatusRoot")
    private AndroidElement _provocationPopUp;

    @AndroidFindBy(id = "upgradeStatusMessage")
    private AndroidElement _provocationPopUpMessage;

    @AndroidFindBy(id = "secondaryButton")
    private AndroidElement _keepDemoAccount;

    @AndroidFindBy(id = "nextStatusProgressRoot")
    private AndroidElement _nextStatusProgressPopUp;

    @AndroidFindBy(id = "bonusPopupRoot")
    private AndroidElement _bonusPopUp;

    @AndroidFindBy(id = "popupHeader")
    private AndroidElement _bonusPopUpTitle;

    @AndroidFindBy(id = "infoPopupRoot")
    private AndroidElement _infoPopupRoot;

    @AndroidFindBy(id = "chartStubRoot")
    private AndroidElement _cfdUnavailable;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.vipbroker.beta:id/chartStubRoot']/android.widget.TextView[@resource-id='com.example.vipbroker.beta:id/header']")
    private AndroidElement _cfdUnavailableLabel;

    @AndroidFindBy(id = "switchToDemoButton")
    private AndroidElement _switchToDemoAccountButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.example.broker.beta:id/infoPopupRoot']//android.widget.TextView[@resource-id='com.example.broker.beta:id/text']")
    private AndroidElement _infoPopupText;

    @AndroidFindBy(id = "addAssetTabRoot")
    private AndroidElement _addAssetButton;

    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[@resource-id='com.example.vipbroker.beta:id/assetTabRoot'][1]")
    private AndroidElement _assetTabsRoot;


    public TradingPageAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    @AndroidFindBy(id = "touch_outside")
    private AndroidElement _touchOutside;

    @Override
    public void closeHallOfFame() {
        if (isExistWithWait(_touchOutside)) {
            tryClick(_touchOutside);
        }
    }

    @Override
    public boolean checkHallOfFameIsPresent() {
        return isExistWithWait(_touchOutside);
    }

    public boolean checkInfoPopupExists() {
        return isDisplayed(_infoPopupRoot, 30);
    }

    public TradingPageVip checkCfdUnavailablePlaceholderIsDisplayed() {
        getWait().withMessage("CFD unavailable stub is absent").until(d ->
                ExpectedConditions.visibilityOf(_cfdUnavailable));
        String cfdUnavailableText = tryGetText(_cfdUnavailableLabel);
        assertThat(cfdUnavailableText)
                .withFailMessage("Expected: " + MsgFactory.getMessage(AppMessages.CFD_UNAVAILABLE_STUB)
                        + " Actual: " + cfdUnavailableText)
                .isEqualTo(MsgFactory.getMessage(AppMessages.CFD_UNAVAILABLE_STUB));
        return this;
    }

    @Override
    public void clickSwitchToDemoAccountButton() {
        tryClick(_switchToDemoAccountButton);
    }

    public String getInfoPopupText() {
        return tryGetText(_infoPopupText);
    }

    @Override
    public NextStatusFullScreenPopUp nextStatusFullScreenPopUp() {
        return new NextStatusFullScreenPopUpAndroid(mobileDriver);
    }


    public AndroidElement getAccountTypeValue() {
        return _accountTypeValue;
    }

    public AndroidElement getAccountBalanceValue() {
        return _accountBalanceValue;
    }

    public AndroidElement getAccountTypesPanel() {
        return _accountTypesPanel;
    }

    public AndroidElement getTournamentWidget() {
        return _tournamentWidget;
    }

    public AndroidElement getTournamentPlaceValue() {
        return _tournamentPlaceValue;
    }

    public AndroidElement getTimeToTournamentEndValue() {
        return _timeToTournamentEndValue;
    }

    public AndroidElement getRefreshBalanceButton() {
        return _refreshBalanceButton;
    }

    public AndroidElement getRebuyButton() {
        return _rebuyButton;
    }

    public AndroidElement getDepositButton() {
        return _depositButton;
    }

    public AndroidElement getUserStatusButton() {
        return _userStatusButton;
    }

    public AndroidElement getUserStatusPanel() {
        return _userStatusPanel;
    }

    public AndroidElement getChartContainer() {
        return _chartContainer;
    }

    public AndroidElement getChartTypeButton() {
        return _chartTypeButton;
    }

    public AndroidElement getChartTypesPanel() {
        return _chartTypesPanel;
    }

    public AndroidElement getChartTimeframeButton() {
        return _chartTimeframeButton;
    }

    public AndroidElement getChartTimeframesPanel() {
        return _chartTimeframesPanel;
    }

    public AndroidElement getIndicatorsButton() {
        return _indicatorsButton;
    }

    public AndroidElement getIndicatorsPanel() {
        return _indicatorsPanel;
    }

    public AndroidElement getInvestmentIncomeContainer() {
        return _investmentIncomeContainer;
    }

    public AndroidElement getTotalInvestmentValue() {
        return _totalInvestmentValue;
    }

    public AndroidElement getExpectedIncomeValue() {
        return _expectedIncomeValue;
    }

    public AndroidElement getAssetTypeValue() {
        return _assetTypeValue;
    }

    public AndroidElement getAssetNameValue() {
        return _assetNameValue;
    }

    public AndroidElement getExpirationTimeValue() {
        return _expirationTimeValue;
    }

    public AndroidElement getExpirationTimePanel() {
        return _expirationTimePanel;
    }

    public AndroidElement getInvestmentAmountValue() {
        return _investmentAmountValue;
    }

    public AndroidElement getInvestmentsPanel() {
        return _investmentsPanel;
    }

    public AndroidElement getStrikePriceButton() {
        return _strikePriceButton;
    }

    public AndroidElement getTrendDealUpButton() {
        return _trendDealUpButton;
    }

    public AndroidElement getTrendDealDownButton() {
        return _trendDealDownButton;
    }

    public AndroidElement getDealCommissionValue() {
        return _dealCommissionValue;
    }

    public AndroidElement getCreateCfdDealButton() {
        return _createCfdDealButton;
    }

    public AndroidElement getCreateFttDealUpButton() {
        return _createFttDealUpButton;
    }

    public AndroidElement getCreateFttDealDownButton() {
        return _createFttDealDownButton;
    }

    public AndroidElement getFreeTradesTimerItem() {
        return _freeTradesTimerItem;
    }

    public AndroidElement getMajorityOpinionItem() {
        return _majorityOpinionItem;
    }

    public AndroidElement getPostSignUpModalView() {
        return _postSignUpModalView;
    }

    public AndroidElement getPostSignUpModalCloseButton() {
        return _postSignUpModalCloseButton;
    }

    public AndroidElement getUncompletedDepositPopUp() {
        return _successfulReplenishPopUp;
    }

    public AndroidElement getPaymentPopupHolderPaymentMessage() {
        return _paymentPopupHolderPaymentMessage;
    }

    public AndroidElement getUpgradeStatusPopupIcon() {
        return _upgradeStatusPopupIcon;
    }

    public AndroidElement getUpgradeStatusPopupMessage() {
        return _upgradeStatusPopupMessage;
    }

    public AndroidElement getUpgradeStatusPopupButton() {
        return _upgradeStatusPopupButton;
    }

    public AndroidElement getDocVerificationPopup() {
        return _docVerificationPopup;
    }

    public AndroidElement getDocVerificationPopupIcon() {
        return _docVerificationPopupIcon;
    }

    public AndroidElement getDocVerificationPopupMessage() {
        return _docVerificationPopupMessage;
    }

    public AndroidElement getFreeTradesTimerPopup() {
        return _freeTradesTimerPopup;
    }

    public AndroidElement getFreeTradesTimerPopupMessage() {
        return _freeTradesTimerPopupMessage;
    }

    public AndroidElement getProvocationPopUp() {
        return _provocationPopUp;
    }

    public AndroidElement getProvocationPopUpMessage() {
        return _provocationPopUpMessage;
    }

    public AndroidElement getTouchOutsideSpace() {
        return _keepDemoAccount;
    }

    public AndroidElement getNextStatusProgressPopUp() {
        return _nextStatusProgressPopUp;
    }

    public AndroidElement getBonusPopUp() {
        return _bonusPopUp;
    }

    public AndroidElement getBonusPopUpTitle() {
        return _bonusPopUpTitle;
    }

    public TradingPageVip checkTradingPageVip() {
        androidActivitiesHelper.WaitAndCheckActivity(Activity.TRADING_PAGE_VIP, mobileDriver);
        getWait().withMessage("Trading page is not displayed").until(d ->
                isDisplayed(_tradingPageVip));
        return this;
    }

    @Step("Проверить открытие трейдрума")
    public TradingPageAndroid checkTradingPage() {
        String currentActivity = androidActivitiesHelper.getCurrentActivityString(mobileDriver);
        if (!currentActivity.equals(Activity.TRADING_PAGE.get())) {
            androidActivitiesHelper.WaitAndCheckActivity(Activity.TRADING_PAGE, mobileDriver);
        }
        getWait().withMessage("Trading page is not displayed").until(d ->
                isDisplayed(_tradingPage));
        closeHallOfFame();
        return this;
    }


    @Step("Проверить открытие панели выбора счета")
    public BalancePanel checkBalancePanel() {
        getWait().withMessage("Balance spinner is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_accountTypesPanel));
        return new BalancePanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели персонального прогресса")
    public PersonalProgressPopUp checkStatusesPopUpPanel() {
        getWait().withMessage("Personal progress panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_userStatusPanel));
        return new PersonalProgressPopUpAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели выбора типа графика")
    public ChartTypePanel checkChartTypesPanel() {
        getWait().withMessage("Chart types panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_chartTypesPanel));
        return new ChartTypePanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели выбора таймфрейма графика")
    public TimeframePanel checkChartTimeframesPanel() {
        getWait().withMessage("Chart timeframes panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_chartTimeframesPanel));
        return new TimeframePanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели индикаторов")
    public IndicatorsPanel checkIndicatorsPanel() {
        getWait().withMessage("Indicators panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_indicatorsPanel));
        return new IndicatorsPanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели выбора актива")
    public AssetsPanel checkAssetsPanel() {
        getWait().withMessage("Assets panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_assetsPanel));
        return new AssetsPanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели времени экспирации")
    public ExpirationTimePanel checkExpirationPanel() {
        getWait().withMessage("Expiration panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_expirationTimePanel));
        return new ExpirationTimePanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели суммы инвестиции")
    public InvestmentsPanel checkInvestmentsPanel() {
        getWait().withMessage("Investments panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_investmentsPanel));
        return new InvestmentsPanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие панели выбора страйка")
    public StrikeDealsPanel checkStrikeDealPanel() {
        getWait().withMessage("Strike price panel is not displayed").until(d ->
                ExpectedConditions.visibilityOf(_strikePricePanel));
        return new StrikeDealsPanelAndroid(mobileDriver);
    }

    @Step("Проверить открытие попапа перехода на следующий статус")
    public NextStatusProgressPopUp checkNextStatusProgressPopUp() {
        getWait().withMessage("Next status progress popup is not displayed").until(d ->
                isDisplayed(_nextStatusProgressPopUp));
        return new NextStatusProgressPopUpAndroid(mobileDriver);
    }




    public boolean isUserMenuButtonExists() {
        return tryDisplayed(_profileTabButton);
    }

    @Step("Нажать на виджет турнира")
    public TournamentCardContainerPanel clickTournamentWidget() {
        tryClick(_tournamentWidget);
        return new TournamentCardContainerPanelAndroid(mobileDriver);
    }

    @Step("Нажать кнопку Deposit")
    public CashierDepositPage clickMakeDepositButton() {
        tryClick(_depositButton);
        return new CashierDepositPageAndroid(mobileDriver);
    }

    @Step("Нажать кнопку Deposit")
    public CashierDepositPage clickMakeDepositNativeButton() {
        tryClick(_depositButton);
        return new NativeCashierDepositPageAndroid(mobileDriver);
    }

    @Step("Открыть таб Profile")
    public PanelUserMenu clickUserMenuButton() {
        tryClick(_profileTabButton);
        return new PanelUserMenuAndroid(mobileDriver);
    }

    @Step("Открыть таб Trades")
    public TransactionHistoryPanel clickTradesTabButton() {
        tryClick(_tradesTabButton);
        return new TransactionHistoryPanelAndroid(mobileDriver);
    }

    @Step("Открыть таб Traderoom")
    public TradingPage clickTraderoomTabButton() {
        tryClick(_traderoomTabButton);
        return this;
    }

    @Step("Открыть таб Tournament")
    public TournamentsListContainerPanel clickTournamentTabButton() {
        tryClick(_tournamentTabButton);
        return new TournamentsListContainerPanelAndroid(mobileDriver);
    }

    @Step("Открыть таб Profile")
    public AccountTab clickProfileTabButton() {
        tryClick(_profileTabButton);
        return new AccountTabAndroid(mobileDriver);
    }

    @Step("Нажать на попап")
    public UncompletedDepositPopUp clickUncompletedDepositPopup() {
        tryClickWithWait(_successfulReplenishPopUp);
        return new UncompletedDepositPopUpAndroid(mobileDriver);
    }

    @Step("Нажать на попап")
    public StatusesPanel clickUpgradeStatusPopupButtonByStatusesPage() {
        throw new NotImplementedException(ExceptionMessages.NOT_IMPLEMENTED_ANDROID);
    }

    @Step("Нажать на попап")
    public CashierDepositPage clickUpgradeStatusPopupButtonByCashierPage() {
        tryClick(_upgradeStatusPopupButton);
        return new CashierDepositPageAndroid(mobileDriver);
    }

    @Override
    @Step("Нажать на попап")
    public NativeCashierDepositPageAndroid clickUpgradeStatusPopupNativeButtonByCashierPage() {
        tryClick(_upgradeStatusPopupButton);
        return new NativeCashierDepositPageAndroid(mobileDriver);
    }

    @Step("Нажать на попап")
    public VerificationPanel clickVerificationPopup() {
        tryClick(_docVerificationPopup);
        return new VerificationPanelAndroid(mobileDriver);
    }

    @Step("Нажать на тост начисленного бонуса")
    public BonusInformationPanel clickBonusPopUp() {
        tryClick(_bonusPopUp);
        return new BonusInformationPanelAndroid(mobileDriver);
    }

    public InsufficientFundsPopUp createDealNoBalance(Boolean isDealDirectionUp) {
        createDeal(isDealDirectionUp);
        return new InsufficientFundsPopUpAndroid(mobileDriver);
    }

    public TradingPageVip step(String stepName) {
        logger.info(stepName);
        Allure.step(stepName);
        return this;
    }

    @AndroidFindBy(id = "indicatorsButton")
    private AndroidElement _indicatorsButtonVip;

    @Override
    public TradingPageVip clickIndicatorsButtonVip() {
        getWait().withMessage("Кнопка идикаторов не активна")
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> isEnabled(_indicatorsButtonVip));
        tryClick(_indicatorsButtonVip);
        return this;
    }

    @Override
    public IndicatorsPanelAndroid checkIndicatorsPanelVip() {
        return (IndicatorsPanelAndroid) checkIndicatorsPanel();
    }

    @Override
    public TradingPageVip checkIndicatorsPanelVipIsAbsent() {
        getWait().withMessage("Indicators panel is still displayed").until(d ->
                ExpectedConditions.invisibilityOf(_indicatorsPanel));
        return this;
    }

    @AndroidFindBy(id = "indicatorNameLabel")
    private AndroidElement _indicatorNameLabel;

    @Override
    public TradingPageVip checkScalpProIndicatorIsPresent() {
        getWait().withMessage("Scalp Pro Indicator is absent").until(d ->
                ExpectedConditions.visibilityOf(_indicatorNameLabel));
        String indicatorText = tryGetText(_indicatorNameLabel);
        assertThat(indicatorText)
                .withFailMessage("Expected: " + Indicator.ScalpPro.getValue() + " Actual: " + indicatorText)
                .isEqualTo(Indicator.ScalpPro.getValue());
        return this;
    }

    @AndroidFindBy(id = "vipPaywallRoot")
    private AndroidElement _paywall;

    @AndroidFindBy(id = "title")
    private AndroidElement _paywallTitle;

    @Override
    public void checkVipPaywallIsDisplayed() {
        getWait()
                .withMessage("Пэйволл не появился")
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> isDisplayed(_paywall));
    }

    @Override
    public void checkVipPaywallTitle(String title) {
        getWait()
                .withMessage("Заголовок пэйволла не соответствует ожидаемому, ожидалось: "
                        + title + ", получено: " + tryGetText(_paywallTitle))
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> tryGetText(_paywallTitle).equals(title));
    }

    @AndroidFindBy(id = "indicatorSettings")
    private AndroidElement _indicatorSettings;

    @Override
    public void clickScalpProSettings() {
        tryClick(_indicatorSettings);
    }


    @AndroidFindBy(id = "depositButton")
    private AndroidElement _paywallDepositButton;

    @Override
    public void clickPaywallDepositButton() {
        tryClick(_paywallDepositButton);
    }

    @AndroidFindBy(id = "personalCallbackButton")
    private AndroidElement _callbackButton;

    @Override
    public void clickCallbackButton() {
        tryClick(_callbackButton);
    }

    @AndroidFindBy(id = "balanceName")
    private AndroidElement _accountTypeVip;

    @Override
    public void chooseRealAccountVip() {
        if (!tryGetText(_accountTypeVip).equals(AccountTypes.getAccountType(REAL))) {
            tryClick(_accountTypeVip);
            checkBalancePanel();
            BalancePanel balancePanel = new BalancePanelAndroid(mobileDriver);
            balancePanel.chooseAccountType(REAL);
        }
    }

    @Override
    public void chooseTournamentAccountVip() {
        if (!tryGetText(_accountTypeVip).equals(AccountTypes.getAccountType(TOURNAMENT))) {
            tryClick(_accountTypeVip);
            checkBalancePanel();
            BalancePanel balancePanel = new BalancePanelAndroid(mobileDriver);
            balancePanel.chooseAccountType(TOURNAMENT);
        }
    }

    @AndroidFindBy(id = "goToMainAppPaywallRoot")
    private AndroidElement _paywallSheetRoot;


    @Override
    public void checkVipPaywallSheetIsDisplayed() {
        getWait()
                .withMessage("Vip paywall sheet не появился")
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> isDisplayed(_paywallSheetRoot));
    }

    @AndroidFindBy(id = "design_bottom_sheet")
    private AndroidElement _bottomSheetRoot;

    @Override
    public void checkVipBottomSheetIsDisplayed() {
        getWait()
                .withMessage("Vip bottom sheet не появился")
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> isDisplayed(_bottomSheetRoot));
    }


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.example.broker.beta:id/goToMainAppPaywallRoot']//android.widget.TextView[1]")
    private AndroidElement _bottomSheetText;

    @Override
    public void checkVipPaywallSheetTitle(String title) {
        getWait()
                .withMessage("Заголовок пэйволла не соответствует ожидаемому, ожидалось: "
                        + title + ", получено: " + tryGetText(_bottomSheetText))
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> tryGetText(_bottomSheetText).equals(title));
    }

    @AndroidFindBy(id = "type")
    private AndroidElement _assetType;

    @AndroidFindBy(id = "name")
    private AndroidElement _assetName;

    @Override
    public void selectFttZarOstAsset() {
        if (!tryGetText(_assetType).equals("FTT") || !tryGetText(_assetName).equals("ZAR/OST")) {
            tryClick(_assetName);
            checkAssetsPanel()
                    .selectBinaryZarOstAsset();
        }
    }

    @Override
    public void selectCFDZarOstAsset() {
        if (!tryGetText(_assetType).equals("CFD") || !tryGetText(_assetName).equals("ZAR/OST")) {
            tryClick(_assetName);
            AssetsPanelAndroid assetsPanelAndroid = (AssetsPanelAndroid) checkAssetsPanel();
            assetsPanelAndroid.selectCFDZarOstAsset();
        }
    }

    @Override
    public void selectEurUsdAsset() {
        if (!getAssetTypeValueText().equals("FTT") || !getAssetNameValueText().equals("EUR/USD")) {
            AssetsPanel assetsPanel = clickAssetNameValueButton()
                    .checkAssetsPanel();
            assetsPanel.selectEurUsdAsset();
        }
    }

    @Override
    public void select5stZarOstAsset() {
        if (!tryGetText(_assetType).equals("5ST") || !tryGetText(_assetName).equals("ZAR/OST")) {
            tryClick(_assetName);
            AssetsPanelAndroid assetsPanelAndroid = (AssetsPanelAndroid) checkAssetsPanel();
            assetsPanelAndroid.select5STZarOstAsset();
        }
    }

    @AndroidFindBy(id = "timeFrameLabel")
    private AndroidElement _chartTimeframeVipButton;

    @Override
    public String getChartTimeframeVipText() {
        return tryGetText(_chartTimeframeVipButton);
    }

    @AndroidFindBy(id = "chartTypeButton")
    private AndroidElement _chartTypeVipButton;

    @Override
    public void clickChartTypeVipButton() {
        tryClick(_chartTypeVipButton);
    }

    @Override
    public void clickAssetsButton() { tryClick(_addAssetButton);}

    @Override
    public void clickDealsTab() { tryClick(_tradesTabButton);}

    @Override
    public void swipeLeftToAddAssetButton() {
        tryClick(_assetTabsRoot);
    }

    @Override
    public void clickVipDepositButton() {
        tryClick(_depositVipButton);
    }
}
