package com.example.JMobile.framework.POM.Steps.Pages;

import com.example.JMobile.framework.Enums.AccountTypes;
import com.example.JMobile.framework.Enums.Currency;
import com.example.JMobile.framework.Helpers.CountHelper;
import com.example.JMobile.framework.Helpers.EnumHelper;
import com.example.JMobile.framework.Helpers.StringHelper;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Panels.*;
import com.example.JMobile.framework.POM.Steps.PopUps.*;
import com.example.JMobile.framework.driver.CustomWait;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

import static com.example.JMobile.framework.Enums.AccountTypes.*;

public abstract class TradingPage extends BaseElements {

    protected abstract MobileElement getAccountTypeValue();

    protected abstract MobileElement getAccountTypesPanel();

    public abstract MobileElement getAccountBalanceValue();

    protected abstract MobileElement getTournamentWidget();

    protected abstract MobileElement getTournamentPlaceValue();

    protected abstract MobileElement getTimeToTournamentEndValue();

    protected abstract MobileElement getRefreshBalanceButton();

    protected abstract MobileElement getRebuyButton();

    protected abstract MobileElement getDepositButton();

    protected abstract MobileElement getUserStatusButton();

    protected abstract MobileElement getUserStatusPanel();

    protected abstract MobileElement getChartContainer();

    protected abstract MobileElement getChartTypeButton();

    protected abstract MobileElement getChartTypesPanel();

    protected abstract MobileElement getChartTimeframeButton();

    protected abstract MobileElement getChartTimeframesPanel();

    protected abstract MobileElement getIndicatorsButton();

    protected abstract MobileElement getIndicatorsPanel();

    protected abstract MobileElement getInvestmentIncomeContainer();

    protected abstract MobileElement getTotalInvestmentValue();

    protected abstract MobileElement getExpectedIncomeValue();

    protected abstract MobileElement getAssetTypeValue();

    protected abstract MobileElement getAssetNameValue();

    protected abstract MobileElement getExpirationTimeValue();

    protected abstract MobileElement getExpirationTimePanel();

    protected abstract MobileElement getInvestmentAmountValue();

    protected abstract MobileElement getInvestmentsPanel();

    protected abstract MobileElement getStrikePriceButton();

    protected abstract MobileElement getTrendDealUpButton();

    protected abstract MobileElement getTrendDealDownButton();

    protected abstract MobileElement getDealCommissionValue();

    protected abstract MobileElement getCreateCfdDealButton();

    protected abstract MobileElement getCreateFttDealUpButton();

    protected abstract MobileElement getCreateFttDealDownButton();

    protected abstract MobileElement getFreeTradesTimerItem();

    protected abstract MobileElement getMajorityOpinionItem();

    protected abstract MobileElement getPostSignUpModalView();

    protected abstract MobileElement getPostSignUpModalCloseButton();

    protected abstract MobileElement getUncompletedDepositPopUp();

    protected abstract MobileElement getPaymentPopupHolderPaymentMessage();

    protected abstract MobileElement getUpgradeStatusPopupIcon();

    protected abstract MobileElement getUpgradeStatusPopupMessage();

    protected abstract MobileElement getUpgradeStatusPopupButton();

    protected abstract MobileElement getDocVerificationPopup();

    protected abstract MobileElement getDocVerificationPopupIcon();

    protected abstract MobileElement getDocVerificationPopupMessage();

    protected abstract MobileElement getFreeTradesTimerPopup();

    protected abstract MobileElement getFreeTradesTimerPopupMessage();

    protected abstract MobileElement getProvocationPopUp();

    protected abstract MobileElement getProvocationPopUpMessage();

    protected abstract MobileElement getTouchOutsideSpace();

    protected abstract MobileElement getBonusPopUp();

    protected abstract MobileElement getBonusPopUpTitle();

    protected abstract MobileElement getNextStatusProgressPopUp();

    public abstract TradingPage checkTradingPage();

    public abstract BalancePanel checkBalancePanel();

    public abstract PersonalProgressPopUp checkStatusesPopUpPanel();

    public abstract ChartTypePanel checkChartTypesPanel();

    public abstract TimeframePanel checkChartTimeframesPanel();

    public abstract IndicatorsPanel checkIndicatorsPanel();

    public abstract AssetsPanel checkAssetsPanel();

    public abstract ExpirationTimePanel checkExpirationPanel();

    public abstract InvestmentsPanel checkInvestmentsPanel();

    public abstract StrikeDealsPanel checkStrikeDealPanel();

    public abstract NextStatusProgressPopUp checkNextStatusProgressPopUp();


    public abstract TournamentCardContainerPanel clickTournamentWidget();

    public abstract CashierDepositPage clickMakeDepositButton();

    public abstract CashierDepositPage clickMakeDepositNativeButton();

    public abstract TransactionHistoryPanel clickTradesTabButton();

    public abstract TradingPage clickTraderoomTabButton();

    public abstract TournamentsListContainerPanel clickTournamentTabButton();

    public abstract AccountTab clickProfileTabButton();

    public abstract PanelUserMenu clickUserMenuButton();

    public abstract UncompletedDepositPopUp clickUncompletedDepositPopup();

    public abstract StatusesPanel clickUpgradeStatusPopupButtonByStatusesPage();

    public abstract CashierDepositPage clickUpgradeStatusPopupButtonByCashierPage();

    public abstract NativeCashierDepositPageAndroid clickUpgradeStatusPopupNativeButtonByCashierPage();

    public abstract VerificationPanel clickVerificationPopup();

    public abstract BonusInformationPanel clickBonusPopUp();

    public abstract InsufficientFundsPopUp createDealNoBalance(Boolean isDealDirectionUp);

    public abstract boolean isUserMenuButtonExists();

    public abstract void closeHallOfFame();

    public TradingPage(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    @Step("Нажать на значение баланса пользователя")
    public TradingPage clickAccountBalanceValue() {
        tryClickWithWait(getAccountBalanceValue());
        return this;
    }

    @Step("Нажать на кнопку обновления баланса")
    public TradingPage clickRefreshBalanceButton() {
        tryClickWithWait(getRefreshBalanceButton());
        return this;
    }

    @Step("Нажать на иконку статуса пользователя")
    public TradingPage clickUserStatusButton() {
        tryClickWithWait(getUserStatusButton());
        return this;
    }

    @Step("Нажать на иконку выбора типа графика")
    public TradingPage clickChartTypeButton() {
        tryClick(getChartTypeButton());
        return this;
    }

    @Step("Нажать на иконку выбора таймфрейма графика")
    public TradingPage clickChartTimeframeButton() {
        tryClick(getChartTimeframeButton());
        return this;
    }

    @Step("Нажать на иконку индикаторов")
    public TradingPage clickIndicatorsButton() {
        getWait().withMessage("Кнопка идикаторов не активна")
                .withTimeout(Duration.ofSeconds(10))
                .until(d -> isEnabled(getIndicatorsButton()));
        tryClick(getIndicatorsButton());
        return this;
    }

    @Step("Нажать на наименование текущего актива")
    public TradingPage clickAssetNameValueButton() {
        tryClick(getAssetNameValue());
        return this;
    }

    @Step("Нажать на значение времени экспирации")
    public TradingPage clickExpirationTimeValueButton() {
        tryClick(getExpirationTimeValue());
        return this;
    }

    @Step("Нажать на значение суммы инвестиции")
    public TradingPage clickInvestmentAmountValueButton() {
        tryClick(getInvestmentAmountValue());
        return this;
    }

    @Step("Нажать на значение страйка")
    public TradingPage clickStrikePriceButton() {
        tryClick(getStrikePriceButton());
        return this;
    }

    @Step("Нажать на попап")
    public TradingPage clickPostSignUpModalCloseButton() {
        tryClick(getPostSignUpModalCloseButton());
        return this;
    }

    public boolean isTournamentWidgetExists() {
        return isExistWithWait(getTournamentWidget());
    }

    public boolean isTournamentPlaceValueExists() {
        return isExistWithWait(getTournamentPlaceValue());
    }

    public boolean isTimeToTournamentEndValueExists() {
        return isExistWithWait(getTimeToTournamentEndValue());
    }

    public boolean isOngoingDealExists() {
        return isExistWithWait(getInvestmentIncomeContainer());
    }

    public boolean isOngoingDealExists(int seconds) {
        return isDisplayed(getInvestmentIncomeContainer(), seconds);
    }

    public boolean isAccountBalanceValueExists() {
        return isExistWithWait(getAccountBalanceValue());
    }

    public boolean isRefreshBalanceButtonExists() {
        return isExistWithWait(getRefreshBalanceButton());
    }

    public boolean isRebuyButtonExists() {
        return tryDisplayed(getRebuyButton());
    }

    public boolean isUserStatusButtonExists() {
        return isExistWithWait(getUserStatusButton());
    }

    public boolean isMakeDepositButtonExists() {
        return isExistWithWait(getDepositButton());
    }

    public boolean isChartExists() {
        return isExistWithWait(getChartContainer());
    }

    public boolean isChartTypeButtonExists() {
        return isExistWithWait(getChartTypeButton());
    }

    public boolean isChartTimeframeButtonExists() {
        return isExistWithWait(getChartTimeframeButton());
    }

    public boolean isIndicatorsButtonExists() {
        return isExistWithWait(getIndicatorsButton());
    }

    public boolean isAssetNameValueExists() {
        return isExistWithWait(getAssetNameValue());
    }

    public boolean isInvestmentAmountValueExists() {
        return isExistWithWait(getInvestmentAmountValue());
    }

    public boolean isExpirationTimeButtonExists() {
        return isExistWithWait(getExpirationTimeValue());
    }

    public boolean isStrikePriceButtonExists() {
        return isExistWithWait(getStrikePriceButton());
    }

    public boolean isCFDDealUpButtonExists() {
        return isExistWithWait(getTrendDealUpButton());
    }

    public boolean isCFDDealDownButtonExists() {
        return isExistWithWait(getTrendDealDownButton());
    }

    public boolean isDealCommissionValueExists() {
        return isExistWithWait(getDealCommissionValue());
    }

    public boolean isCFDCreateDealButtonExists() {
        return isExistWithWait(getCreateCfdDealButton());
    }

    public boolean isCreateDealUpButtonExists() {
        return isExistWithWait(getCreateFttDealUpButton());
    }

    public boolean isCreateDealDownButtonExists() {
        return isExistWithWait(getCreateFttDealDownButton());
    }

    public boolean isFreeTradesTimerItemExists() {
        return tryDisplayed(getFreeTradesTimerItem());
    }

    public boolean isPostSignUpModalViewExists() {
        return isExistWithWait(getPostSignUpModalView());
    }

    public boolean isUpgradeStatusPopupIconExists() {
        return isExistWithWait(getUpgradeStatusPopupIcon());
    }

    public boolean isUpgradeStatusPopupButtonExists() {
        return isExistWithWait(getUpgradeStatusPopupButton());
    }

    public boolean isDocVerificationPopupExists() {
        return isExistWithWait(getDocVerificationPopup());
    }

    public boolean isDocVerificationPopupIconExists() {
        return isExistWithWait(getDocVerificationPopupIcon());
    }

    public boolean isFreeTradesTimerPopupExists() {
        return isExistWithWait(getFreeTradesTimerPopup());
    }

    public boolean isProvocationPopUpExists() {
        return isExistWithWait(getProvocationPopUp());
    }

    public boolean isBonusPopUpExists() {
        return isExistWithWait(getBonusPopUp());
    }

    public boolean isMakeDepositButtonMissing() {
        return isElementMissing(getDepositButton());
    }

    public boolean isAccountTypesPanelMissing() {
        return isElementMissing(getAccountTypesPanel());
    }

    public boolean isUserStatusButtonMissing() {
        return isElementMissing(getUserStatusButton());
    }

    public boolean isExpirationTimePanelMissing() {
        return isElementMissing(getExpirationTimePanel());
    }

    public boolean isStrikePriceButtonMissing() {
        return isElementMissing(getStrikePriceButton());
    }

    public boolean isOngoingDealMissing() {
        return isElementMissing(getInvestmentIncomeContainer());
    }

    public boolean isInvestmentPanelMissing() {
        return isElementMissing(getInvestmentsPanel());
    }

    public boolean isMajorityOpinionItemMissing() {
        return isElementMissing(getMajorityOpinionItem());
    }

    public boolean isDocVerificationPopupMissing() {
        return isElementMissing(getDocVerificationPopup());
    }

    public boolean isUncompletedDepositPopupMissing() {
        return isElementMissing(getUncompletedDepositPopUp());
    }

    public boolean isNextStatusProgressPopupMissing() {
        return isElementMissing(getNextStatusProgressPopUp());
    }

    public boolean isInvestmentButtonClickable() {
        return isEnabled(getInvestmentAmountValue());
    }

    public boolean isExpirationTimeButtonClickable() {
        return isEnabled(getExpirationTimeValue());
    }

    public boolean isCreateDealUpButtonClickable() {
        return isEnabled(getCreateFttDealUpButton());
    }

    public boolean isCreateDealDownButtonClickable() {
        return isEnabled(getCreateFttDealDownButton());
    }

    public boolean isStrikePriceButtonClickable() {
        return isEnabled(getStrikePriceButton());
    }

    public LocalTime getCurrentDeviceTime() {
        return deviceTime();
    }

    public String getAccountTypeValueText() {
        return tryGetText(getAccountTypeValue());
    }

    public String getAccountBalanceValueText() {
        return tryGetText(getAccountBalanceValue());
    }

    public String getChartTimeframeText() {
        return tryGetText(getChartTimeframeButton());
    }

    public String getTotalInvestmentValueText() {
        return tryGetText(getTotalInvestmentValue());
    }

    public String geExpectedIncomeValueText() {
        return tryGetText(getExpectedIncomeValue());
    }

    public String getAssetTypeValueText() {
        return tryGetText(getAssetTypeValue());
    }

    public String getAssetNameValueText() {
        return tryGetText(getAssetNameValue());
    }

    public String getExpirationTimeValueText() {
        return tryGetText(getExpirationTimeValue());
    }

    public String getInvestmentAmountValueText() {
        return tryGetText(getInvestmentAmountValue());
    }

    public String getPaymentPopupHolderPaymentMessageText() {
        return tryGetText(getPaymentPopupHolderPaymentMessage());
    }

    public String getUpgradeStatusPopupMessageText() {
        return tryGetText(getUpgradeStatusPopupMessage());
    }

    public String getDocVerificationPopupMessageText() {
        return tryGetText(getDocVerificationPopupMessage());
    }

    public String getFreeTradesTimerPopupMessageText() {
        return tryGetText(getFreeTradesTimerPopupMessage());
    }

    public String getProvocationPopUpMessageText() {
        return tryGetText(getProvocationPopUpMessage());
    }

    public String getBonusPopUpTitleText() {
        return tryGetText(getBonusPopUpTitle());
    }

    @Step("Сменить ассет на FTT ZAR/OST")
    public TradingPage selectBinaryZarOstAsset() {
        if (!getAssetTypeValueText().equals("FTT") || !getAssetNameValueText().equals("ZAR/OST")) {
            AssetsPanel assetsPanel = clickAssetNameValueButton()
                    .checkAssetsPanel();
            assetsPanel.selectBinaryZarOstAsset();
        }
        closeHallOfFame();
        return this;
    }

    @Step("Сменить ассет на FTT EUR/USD")
    public TradingPage selectBinaryEurUsdAsset() {
        if (!getAssetTypeValueText().equals("FTT") || !getAssetNameValueText().equals("EUR/USD")) {
            AssetsPanel assetsPanel = clickAssetNameValueButton()
                    .checkAssetsPanel();
            assetsPanel.selectEurUsdAsset();
        }
        closeHallOfFame();
        return this;
    }

    @Step("Выбрать реальный счет")
    public TradingPage chooseRealAccount() {
        if (!getAccountTypeValueText().equals(AccountTypes.getAccountType(REAL))) {
            BalancePanel balancePanel = clickAccountBalanceValue()
                    .checkBalancePanel();
            balancePanel.chooseAccountType(REAL);
        }
        return this;
    }

    @Step("Выбрать демо счет")
    public TradingPage chooseDemoAccount() {
        if (!getAccountTypeValueText().equals(AccountTypes.getAccountType(DEMO))) {
            BalancePanel balancePanel = clickAccountBalanceValue()
                    .checkBalancePanel();
            balancePanel.chooseAccountType(DEMO);
        }
        return this;
    }

    @Step("Выбрать турнирный счет")
    public TradingPage chooseTournamentAccount() {
        if (!getAccountTypeValueText().equals(AccountTypes.getAccountType(TOURNAMENT))) {
            BalancePanel balancePanel = clickAccountBalanceValue()
                    .checkBalancePanel();
            balancePanel.chooseAccountType(TOURNAMENT);
        }
        return this;
    }

    @Step("Сменить ассет на CFD EUR/USD")
    public TradingPage selectCFDEurUsdAsset() {
        if (!getAssetTypeValueText().equals("CFD") || !getAssetNameValueText().equals("EUR/USD")) {
            AssetsPanel assetsPanel = clickAssetNameValueButton()
                    .checkAssetsPanel();
            assetsPanel.selectCFDEurUsdAsset();
        }
        return this;
    }

    @Step("Установить инвестицию равную 1")
    public TradingPage selectInvestment1FromList() {
        InvestmentsPanel investmentsPanel = clickInvestmentAmountValueButton()
                .checkInvestmentsPanel();
        investmentsPanel.clickInvestment1FromList();
        return this;
    }

    @Step("Установить инвестицию равную 10")
    public TradingPage selectInvestment10FromList() {
        InvestmentsPanel investmentsPanel = clickInvestmentAmountValueButton()
                .checkInvestmentsPanel();
        investmentsPanel.clickInvestment10FromList();
        return this;
    }

    @Step("Установить инвестицию равную 100")
    public TradingPage selectInvestment100FromList() {
        InvestmentsPanel investmentsPanel = clickInvestmentAmountValueButton()
                .checkInvestmentsPanel();
        investmentsPanel.clickInvestment100FromList();
        return this;
    }

    @Step("Установить инвестицию")
    public TradingPage setCustomInvestment(int investment) {
        BigDecimal currentValue = CountHelper.AccountBalance(getInvestmentAmountValueText());
        BigDecimal requiredValue = BigDecimal.valueOf(investment);

        if (!currentValue.equals(requiredValue)) {
            InvestmentsPanel investmentsPanel = clickInvestmentAmountValueButton()
                    .checkInvestmentsPanel();
            investmentsPanel.setCustomInvestmentValue(investment);
        }
        return this;
    }

    public TradingPage choose2mFromExpirationTimePanel() {
        ExpirationTimePanel expirationTimePanel = clickExpirationTimeValueButton()
                .checkExpirationPanel();
        return expirationTimePanel.click2mFromExpirationTimePanel();
    }

    public TradingPage choose3mFromExpirationTimePanel() {
        ExpirationTimePanel expirationTimePanel = clickExpirationTimeValueButton()
                .checkExpirationPanel();
        return expirationTimePanel.click3mFromExpirationTimePanel();
    }

    public TradingPage choose4mFromExpirationTimePanel() {
        ExpirationTimePanel expirationTimePanel = clickExpirationTimeValueButton()
                .checkExpirationPanel();
        return expirationTimePanel.click4mFromExpirationTimePanel();
    }

    public TradingPage choose5mFromExpirationTimePanel() {
        ExpirationTimePanel expirationTimePanel = clickExpirationTimeValueButton()
                .checkExpirationPanel();
        return expirationTimePanel.click5mFromExpirationTimePanel();
    }

    public TradingPage choose15mFromExpirationTimePanel() {
        ExpirationTimePanel expirationTimePanel = clickExpirationTimeValueButton()
                .checkExpirationPanel();
        return expirationTimePanel.click15mFromExpirationTimePanel();
    }

    @Step("Открыть CFD сделку")
    public TradingPage createCFDDeal(Boolean isDealDirectionUp) {
        if (isDealDirectionUp) {
            tryClickWithWait(getTrendDealUpButton());
        } else {
            tryClickWithWait(getTrendDealDownButton());
        }
        tryClick(getCreateCfdDealButton());
        return this;
    }

    @Step("Открыть FTT сделку")
    public TradingPage createDeal(Boolean isDealDirectionUp) {
        if (isDealDirectionUp) {
            tryClickWithWait(getCreateFttDealUpButton());
        } else {
            tryClickWithWait(getCreateFttDealDownButton());
        }
        return this;
    }

    public static <Boolean> void closingPreviousDeal(Callable<Boolean> unclosedDeal) throws Exception {
        int retry = 2;

        while (unclosedDeal.call().equals(false) && retry > 0) {
            logger.info("Waiting for previous deals to close");

            retry--;
            int currentSeconds = Integer.parseInt(DateTimeFormatter.ofPattern("ss").format(LocalDateTime.now()));

            logger.info("Current seconds = " + currentSeconds);

            Thread.sleep((62 - currentSeconds) * 1000L);
        }

        if (unclosedDeal.call().equals(false))
            logger.warn("Previous deals not closed");
    }

    @Step("Дождаться закрытия сделки")
    public TradingPage waitClosingDeal(int seconds) {
        setWait(new CustomWait(_driver, seconds, 500));
        getWait().withMessage("Deals label is displayed").until(d ->
                isAbsent(getInvestmentIncomeContainer()));
        return this;
    }

    public TradingPage waitClosingPopUp(int seconds) {
        if (isDisplayed(getCloseViewButton(), seconds)) {
            clickClosePanelButton();
        }
        return this;
    }

    public TradingPage waitClosingBottomSheet(int seconds) {
        if (isDisplayed(getTouchOutsideSpace(), seconds)) {
            tryClickWithWait(getTouchOutsideSpace());
        }
        return this;
    }

    public void screenForChartTypeVerification() {
        getWait().until(absenceOf(getChartTypesPanel()));
        mobileDriver.makeScreen();
    }

    public void screenForTimeframeVerification() {
        getWait().until(absenceOf(getChartTimeframesPanel()));
        mobileDriver.makeScreen();
    }

    public void screenForIndicatorsVerification() {
        getWait().until(absenceOf(getIndicatorsPanel()));
        mobileDriver.makeScreen();
    }

    public TradingPage screenForVerification() {
        getWait().until(ExpectedConditions.visibilityOf(getCreateFttDealUpButton()));
        mobileDriver.makeScreen();
        return this;
    }

    public AccountTypes getCurrentAccountType() {
        String accountType = getAccountTypeValueText();
        String demoAccountTypeValue = AccountTypes.getAccountType(DEMO);
        return accountType.equals(demoAccountTypeValue) ? DEMO : REAL;
    }

    public Currency getCurrentAccountCurrency() {
        String currentAcc = getAccountBalanceValueText();
        String currentCurrency = StringHelper.getCurrency(currentAcc);
        return EnumHelper.GetCurrency(currentCurrency);
    }

    public abstract NextStatusFullScreenPopUp nextStatusFullScreenPopUp();
}