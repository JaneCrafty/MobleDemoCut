package com.example.JMobile.testing.Tests.AndroidMarketlyTests;

import com.example.JMobile.framework.Enums.*;
import com.example.JMobile.framework.POM.Steps.Pages.*;
import com.example.JMobile.framework.POM.Steps.Panels.*;
import com.example.JMobile.framework.annotations.*;
import com.example.JMobile.testing.Watcher;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class TraiderModeTests extends Watcher {

    //    @Test
//    @AllureId("4010")
//    @DisplayName("Добавление индикаторов")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.INDICATORS)
//    @Story4(Categories.JMobileTree.ADD_INDICATOR)
//    @Priority(Categories.Priority.HIGH)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void CheckAddIndicators() {
//        step("[Precondition] Пользователь в трейдруме, индикаторы выключены\n" +
//                "Селектор индикаторов открыт");
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//
//        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseMovingAverage();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.MOVING_AVERAGE_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseAlligator();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ALLIGATOR_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseBollinger();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.BOLLINGER_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.choosePSar();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.SAR_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
//        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
//        soft.assertThat(indicatorsPanel.isPSarIndicatorInActiveExists()).withFailMessage("Parabolic SAR отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveExists()).withFailMessage("Bollinger отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveExists()).withFailMessage("Alligator отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveExists()).withFailMessage("Moving average отсутствует в списке активных индикаторов").isTrue();
//
//        indicatorsPanel = indicatorsPanel.clickRemoveMovingAverageIndicator();
//        indicatorsPanel = indicatorsPanel.clickRemovePSarIndicator();
//        indicatorsPanel = indicatorsPanel.clickRemoveAlligatorIndicator();
//        indicatorsPanel = indicatorsPanel.clickRemoveBollingerIndicator();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseFractals();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTALS_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseRSI();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.RELATIVE_STRENGTH_INDEX_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseMACD();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.MACD_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseCCI();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.CCI_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
//        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
//        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists()).withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveExists()).withFailMessage("RSI отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveExists()).withFailMessage("MACD отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();
//
//        indicatorsPanel = indicatorsPanel.clickRemoveFractalsIndicator();
//        indicatorsPanel = indicatorsPanel.clickRemoveRSIIndicator();
//        indicatorsPanel = indicatorsPanel.clickRemoveMACDIndicator();
//        indicatorsPanel = indicatorsPanel.clickRemoveCCIIndicator();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseFractalChaosBands();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTAL_CHAOS_BANDS_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseStochastic();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.STOCHASTIC_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseATR();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ATR_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Тапнуть на выбранный индикатор", () ->
//                step("Контент в карточке меняется на настройки индикатора"));
//        indicatorsSettingsPanel = indicatorsPanel.chooseADX();
//        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
//
//        step("Нажать на кнопку Apply", () ->
//                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
//        tradingPage = indicatorsSettingsPanel.clickApplyButton();
//        tradingPage.screenForIndicatorsVerification();
//
//        indicatorsPanel = tradingPage.clickIndicatorsButton()
//                .checkIndicatorsPanel();
//
//        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
//        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
//        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveExists()).withFailMessage("Fractal Chaos Bands отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveExists()).withFailMessage("ATR отсутствует в списке активных индикаторов").isTrue();
//        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
//    }
//
//    @Test
//    @AllureId("4078")
//    @DisplayName("Переключение таймфреймов подряд. Автомасштабирование включено")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.TIMEFRAME)
//    @Priority(Categories.Priority.CRITICAL)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void CheckTimeframeChange() {
//        // add comparison of screenshots?
//        step("[Precondition] Пользователь в трейдруме, таймфрейм по умолчанию: 1с");
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//        tradingPage.selectBinaryZarOstAsset();
//
//        step("Открыть настройки таймфреймов.\n" +
//                "Настройка \"автомасштабирование графика\" включена по умолчанию (только Андроид, на iOS настройка отсутствует).", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        TimeframePanel timeframePanel = tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 5с фрейм.", () ->
//                step("Карточка таймфрейма закрылась. \n" +
//                        "В плашке таймфрейма в трейдруме значение 5с.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select5sTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//        step("Открыть настройки таймфреймов.", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 15с фрейм.", () ->
//                step("Карточка таймфрейма закрылась.\n" +
//                        "В плашке таймфрейма в трейдруме значение 15с.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select15sTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//        step("Открыть настройки таймфреймов.", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 1м фрейм.", () ->
//                step("Карточка таймфрейма закрылась.\n" +
//                        "В плашке таймфрейма в трейдруме значение 1м.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select1mTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//        step("Открыть настройки таймфреймов.", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 5м фрейм.", () ->
//                step("Карточка таймфрейма закрылась.\n" +
//                        "В плашке таймфрейма в трейдруме значение 5м.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select5mTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//        step("Открыть настройки таймфреймов.", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 15м фрейм.", () ->
//                step("Карточка таймфрейма закрылась.\n" +
//                        "В плашке таймфрейма в трейдруме значение 15м.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select15mTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//        step("Открыть настройки таймфреймов.", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 30м фрейм.", () ->
//                step("Карточка таймфрейма закрылась.\n" +
//                        "В плашке таймфрейма в трейдруме значение 30м.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select30mTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//        step("Открыть настройки таймфреймов.", () ->
//                step("Открывается карточка настройки таймфреймов."));
//        tradingPage.clickChartTimeframeButton()
//                .checkChartTimeframesPanel();
//
//        step("Выбрать 1ч фрейм.", () ->
//                step("Карточка таймфрейма закрылась.\n" +
//                        "В плашке таймфрейма в трейдруме значение 1ч.\n" +
//                        "Приложен скрин для проверки, что поменялся масштаб графика."));
//        timeframePanel.select1hTimeframe();
//        tradingPage.screenForTimeframeVerification();
//
//    }
//
//    @Test
//    @AllureId("4145")
//    @DisplayName("Открытие сделки на повышение. Демо-счет.")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.DEMO_DEALS)
//    @Priority(Categories.Priority.LOW)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void OpenDealUpOnDemoAccount() throws Exception {
//        step("[Precondition] Авторизованный пользователь находится на бинарном активе.\n" +
//                "Выбран демо-счет.\n" +
//                "Баланс счета достаточен для создания минимальной сделки.");
//        int investment = Amounts.getAmount100();
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//        tradingPage.setCustomInvestment(investment);
//        tradingPage.choose3mFromExpirationTimePanel();
//
//        TradingPage.closingPreviousDeal(tradingPage::isOngoingDealMissing);
//        BigDecimal balanceBefore = CountHelper.AccountBalance(tradingPage.getAccountBalanceValueText());
//
//        if (balanceBefore.intValue() < investment) {
//            BalancePanel balancePanel = tradingPage.clickAccountBalanceValue()
//                    .checkBalancePanel()
//                    .clickRefillDemoBalanceButton();
//            TradingPage.closingPreviousDeal(tradingPage::isOngoingDealMissing);
//            balanceBefore = CountHelper.AccountBalance(balancePanel.getAccountBalance());
//            if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
//                balancePanel.clickCloseAccountsPanel();
//            }
//        }
//
//        step("Нажать на кнопку создания сделки на понижение.");
//        tradingPage.createDeal(true);
//
//        step("Проверить плашку \"Инвестиция / Доход\" на нижней панели трейдрума", () ->
//                step("На плашке отобразалась сумма инвестиции и сумма ожидаемого дохода на текущий момент."));
//        soft.assertThat(tradingPage.isOngoingDealExists()).withFailMessage("Инвестиционная панель не отобразилась").isTrue();
//
//        step("Проверить баланс демо-счета", () ->
//                step("С баланса демо-счета списалась сумма инвестиции"));
//        BigDecimal expectedResult = balanceBefore.subtract(BigDecimal.valueOf(investment));
//        soft.assertThat(EqualsHelper.prolongedEqualsBalance(expectedResult,
//                tradingPage::getAccountBalanceValueText)).withFailMessage("Баланс не изменился после открытия сделок. Ожидаемый результат: " + expectedResult).isTrue();
//
//        step("Открыть Trades таб.\n" +
//                "Проверить наличие:\n" +
//                "- раздела Активные сделки на экране\n" +
//                "- в разделе Активные сделки отображается созданная сделка ", () ->
//                step("Раздел активные сделки присутствует.\n" +
//                        "В разделе есть одна активная сделка, сумма инвестиции совпадает с открытой сделкой. \n" +
//                        "Направление сделки - понижение."));
//        TransactionHistoryPanel transactionHistoryPanel = tradingPage.clickTradesTabButton();
//
//        soft.assertThat(transactionHistoryPanel.isOpenTradesSectionExist()).withFailMessage("Раздел с открытыми сделками не отображается").isTrue();
//        soft.assertThat(transactionHistoryPanel.isOpenDealExist()).withFailMessage("Открытые сделки не отображаются").isTrue();
//        soft.assertThat(CountHelper.AccountBalance(transactionHistoryPanel.getAmountOfInvestmentText()).intValue()).as("Сумма открытых сделок не соответствует ожиданию").isEqualTo(investment);
//        soft.assertThat(CountHelper.AccountBalance(transactionHistoryPanel.getLastDealInvestmentText()).intValue()).as("Сумма последней открытой сделки не соответствует ожиданию").isEqualTo(investment);
//    }
//
//    @Test
//    @AllureId("10307")
//    @DisplayName("an/ Раздражалка в карточке активов на FTT. Переход в статусы по кнопке Upgrade")
//    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.GO_TO_STATUSES)
//    @Priority(Categories.Priority.MEDIUM)
//    @Platform(Categories.Platform.ANDROID)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    public void ClickUpgradeButtonOnFttProvocation() {
//        step("[Precondition] Авторизированный пользователь в трейдруме. Статус Free.\n" +
//                "Включена механика FTT");
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//        tradingPage.selectBinaryZarOstAsset();
//
//        step("Открыть селектор активов", () ->
//                step("Открылась карточка активов, внизу отображается раздражалка"));
//        AssetsPanel assetsPanel = tradingPage.clickAssetNameValueButton()
//                .checkAssetsPanel();
//        soft.assertThat(assetsPanel.isProvocationPopUpExists()).withFailMessage("Раздражалка не отображается").isTrue();
//
//        step("Нажать на кнопку Upgrade на раздражалке", () ->
//                step("Открылся экран Статусы"));
//        StatusesPanel statusesPanel = assetsPanel.clickProvocationUpgradeButton()
//                .checkStatusesPanel();
//    }
//
//    @Test
//    @AllureId("4398")
//    @DisplayName("Переход в кассу (Депозит) из трейд-рума")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.CASHIER_IN_OUT)
//    @Priority(Categories.Priority.LOW)
//    @ResponsibleTeam("Mobile")
//    @BusinessDomain("Cashier")
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.CASHIER)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void OpenDepositCashierPage() {
//        step("[Precondition] Авторизованный пользователь находится в трейд-руме");
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//
//        step("Нажать кнопку 'Пополнить счет'");
//        CashierDepositPage cashierDepositPage = tradingPage.clickMakeDepositButton();
//
//        step("Открылась страница кассы \"Депозит\"\n" +
//                "Присутствует заголовок \"Choose Payment Method\"\n" +
//                "Присутствует метод оплаты Visa/Master Card/Maestro\n" +
//                "С открытием кассы API отправляет параметр advertising_id.");
//        cashierDepositPage.checkCashierDepositPage();
//        cashierDepositPage.checkDepositCashierPageTitle();
//        soft.assertThat(cashierDepositPage.checkPaymentMethodMessageExists()).isTrue();
//        cashierDepositPage.checkVisaMcMaestroMethodExists();
//        assertThat(cashierDepositPage.getPaymentMethodMessageTitle()).isEqualTo(MsgFactory.getMessage(Titles.CHOOSE_PAYMENT_METHOD_TITLE));
//    }
//
//    @Test
//    @AllureId("18484")
//    @DisplayName("and/Клиентское соглашение")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.TERMS_CONDITIONS)
//    @Priority(Categories.Priority.CRITICAL)
//    @Platform(Categories.Platform.ANDROID)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    public void CheckClientAgreement() {
//        step("[Precondition] Пользователь авторизован в приложении");
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//
//        step("Открыть таб Account ", () ->
//                step("Открыт таб Account "));
//        AccountTab accountTab = tradingPage.clickProfileTabButton();
//        accountTab.checkAccountTab();
//
//        step("Открыть Клиентское соглашение", () ->
//                step("Открыто клиентское соглашение"));
//        StaticPages staticPages = accountTab.clickClientAgreementButton()
//                .checkStaticPage();
//
//        step("Проверить наличие элементов:\n" +
//                "  - заголовок Client Agreement\n" +
//                "  - текст клиентского соглашения\n" +
//                "  - кнопка Закрыть", () ->
//                step(" Все элементы отображаются"));
//        soft.assertThat(staticPages.getStaticPageTitleText()).withFailMessage("Заголовок Client Agreement не найден").isEqualTo(MsgFactory.getMessage(Titles.CLIENT_AGREEMENT));
//        soft.assertThat(staticPages.getStaticPageDescriptionText()).withFailMessage("Текст клиентского соглашения не найден").isNotBlank();
//        soft.assertThat(staticPages.isStaticPageCloseButtonExists()).withFailMessage("Кнопка Закрыть не найдена").isTrue();
//
//    }
//
//    @Test
//    @AllureId("4918")
//    @DisplayName("Трейдрум по дефолту - выбран CFD-актив. Элементы в трейдруме (кроме графика)")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.SWITCH_TO_CFD)
//    @Priority(Categories.Priority.MEDIUM)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void CheckDefaultCFDTraderoomElements() {
//        step("\b[Precondition\b] Органическая установка.\n" +
//                "После регистрации пользователь переходит в трейдрум.");
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//
//        step("Проверить наличие элементов на панелях.\n" +
//                "\n" +
//                "Панель тулбара:\n" +
//                "- селектор ассетов\n" +
//                "- заголовок селектора ассетов \"CFD\"\n" +
//                "- Demo-счет (некликабельный элемент)\n" +
//                "- кнопка обновления демо-счета\n" +
//                "\n" +
//                "Панель настроек графика:\n" +
//                "- кнопка смены типа графика\n" +
//                "- кнопка таймфрейма\n" +
//                "- кнопка индикаторов\n" +
//                "\n" +
//                "Панель конфигурации и кнопок:\n" +
//                "- кнопка выбора инвестиции\n" +
//                "- кнопки выбора направления сделки\n" +
//                "- предупреждение о комиссии (некликабельный элемент)\n" +
//                "- кнопка \"Открыть сделку\"", () ->
//                step("Трейдрум в режиме CFD-торговли.\n" +
//                        "Перечисленные элементы отображаются в трейдруме"));
//        soft.assertThat(tradingPage.isUserMenuButtonExists()).withFailMessage("Кнопка перехода в меню пользователя не найдена").isTrue();
//        soft.assertThat(tradingPage.isAssetNameValueExists()).withFailMessage("Селектор выбора ассетов не найден").isTrue();
//        soft.assertThat(tradingPage.getAssetTypeValueText()).as("Заголовок селектора выбора ассетов не CFD").isEqualTo("CFD");
//        soft.assertThat(tradingPage.isAccountBalanceValueExists()).withFailMessage("Селектор выбора типа не найден").isTrue();
//        soft.assertThat(tradingPage.isRefreshBalanceButtonExists()).withFailMessage("Кнопка обновления демо счета не найдена").isTrue();
//
//        soft.assertThat(tradingPage.isChartTypeButtonExists()).withFailMessage("Кнопка изменения типа графика не существует").isTrue();
//        soft.assertThat(tradingPage.isChartTimeframeButtonExists()).withFailMessage("Кнопка изменения таймфрейма не существует").isTrue();
//        soft.assertThat(tradingPage.isIndicatorsButtonExists()).withFailMessage("Кнопка индикаторов не существует").isTrue();
//
//        soft.assertThat(tradingPage.isInvestmentAmountValueExists()).withFailMessage("Кнопка выбора суммы инвестиции не найдена").isTrue();
//        soft.assertThat(tradingPage.isCFDDealUpButtonExists()).withFailMessage("Кнопка направления сделки с типом Call не существует").isTrue();
//        soft.assertThat(tradingPage.isCFDDealDownButtonExists()).withFailMessage("Кнопка направления сделки с типом Put не существует").isTrue();
//        soft.assertThat(tradingPage.isDealCommissionValueExists()).withFailMessage("Предупреждение о комиссии не существует").isTrue();
//        soft.assertThat(tradingPage.isCFDCreateDealButtonExists()).withFailMessage("Кнопка создания сделки не существует").isTrue();
//
//        step("Проверить отсутствие элементов в трейдруме:\n" +
//                "- нет кнопки Deposit\n" +
//                "- нет кнопки Статусы\n" +
//                "- нет плашки Страйк-цена\n" +
//                "- нет элемента \"мнение большинства\"", () ->
//                step("Перечисленные элементы НЕ отображаются в трейдруме"));
//        soft.assertThat(tradingPage.isMakeDepositButtonMissing()).withFailMessage("Кнопка перехода на страницу депозита кассы найдена").isTrue();
//        soft.assertThat(tradingPage.isUserStatusButtonMissing()).withFailMessage("Кнопка статуса существует").isTrue();
//        soft.assertThat(tradingPage.isStrikePriceButtonMissing()).withFailMessage("Кнопка Страйк-цены найдена").isTrue();
//        soft.assertThat(tradingPage.isMajorityOpinionItemMissing()).withFailMessage("Элемент Мнение большинства найдена").isTrue();
//        if (getMobileDriver().getPropertyValues().mobileOS == MobileOS.Android) //Chart disabled on IOS simulator
//            soft.assertThat(tradingPage.isChartExists()).withFailMessage("График не отображен").isTrue();
//    }
//
//    @Test
//    @Disabled("мигающий тест")
//    @AllureId("4932")
//    @DisplayName("Открытие сделки на понижение. Проверка в трейдруме")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.CFD_DEAL)
//    @Story4(Categories.JMobileTree.OPEN_DEALS)
//    @Priority(Categories.Priority.HIGH)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void OpenCFDDealDownTraderoomCheck() {
//        step("[Precondition] Авторизованный пользователь в трейдруме. Актив EUR/USD (CFD).\n" +
//                "Баланс счета достаточен для создания минимальной сделки.");
//
//        TradingPage tradingPage = getTradingPageWithLogin(UserData.getAutotestUser3Email(), UserData.getAutotestUser3Password());
//        tradingPage.checkTradingPage();
//
//        BigDecimal balanceBefore = CountHelper.AccountBalance(tradingPage.getAccountBalanceValueText());
//
//        if (balanceBefore.intValue() < 100) {
//            tradingPage.clickRefreshBalanceButton();
//            balanceBefore = CountHelper.AccountBalance(tradingPage.getAccountBalanceValueText());
//        }
//
//        tradingPage.selectCFDEurUsdAsset();
//
//        step("Выбрать инвестицию 10$");
//        tradingPage.selectInvestment10FromList();
//
//        String chosenInvestment = StringHelper.GetAmountFromAccountData(tradingPage.getInvestmentAmountValueText());
//
//        step("Нажать на кнопку создания сделки на повышение.\n" +
//                "Проверить баланс счета", () ->
//                step("С баланса счета списалась сумма инвестиции"));
//        tradingPage.createCFDDeal(false);
//
//        step("Проверить плашку \"Инвестиция / Доход\" на нижней панели трейдрума", () ->
//                step("На плашке отобразалась сумма инвестиции и сумма ожидаемого дохода на текущий момент."));
//        soft.assertThat(tradingPage.isOngoingDealExists()).withFailMessage("Инвестиционная панель не отобразилась").isTrue();
//
//        step("Открыть таб История сделок.\n" +
//                "Проверить наличие:\n" +
//                "- раздела Активные сделки на экране\n" +
//                "- в разделе Активные сделки отображается созданная сделка", () ->
//                step("Раздел активные сделки пристутствует.\n" +
//                        "В разделе есть одна активная сделка, сумма инвестиции совпадает с открытой сделкой.\n" +
//                        "Направление сделки - понижение."));
//        TransactionHistoryPanel transactionHistoryPanel = tradingPage.clickTradesTabButton();
//
//        soft.assertThat(transactionHistoryPanel.isOpenTradesSectionExist()).withFailMessage("Раздел с открытыми сделками не отображается").isTrue();
//        assertThat(transactionHistoryPanel.isOpenCfdDealExist()).withFailMessage("Открытая cfd сделка не отображается").isTrue();
//        soft.assertThat(CountHelper.AccountBalance(transactionHistoryPanel.getLastDealInvestmentText()).intValue()).isEqualTo(Integer.parseInt(chosenInvestment));
//        transactionHistoryPanel.closeLastOpenCfdDeal();
//
//    }
//
//    @Test
//    @Disabled("мигающий тест")
//    @AllureId("4933")
//    @DisplayName("Открытие сделки на понижение. Проверка в истории сделок")
//    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Story3(Categories.JMobileTree.CFD_DEAL)
//    @Story4(Categories.JMobileTree.OPEN_DEALS)
//    @Priority(Categories.Priority.HIGH)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
//    public void OpenCFDDealDownHistoryCheck() throws Exception {
//        step("[Precondition] Авторизованный пользователь находится на CFD-механике.\n" +
//                "Выбран актив EUR/USD (CFD).\n" +
//                "Баланс счета достаточен для создания минимальной сделки.");
//
//        TradingPage tradingPage = getTradingPageWithLogin(UserData.getAutotestUser4Email(), UserData.getAutotestUser4Password());
//        tradingPage.checkTradingPage();
//
//        BigDecimal balanceBefore = CountHelper.AccountBalance(tradingPage.getAccountBalanceValueText());
//
//        if (balanceBefore.intValue() < 100) {
//            tradingPage.clickRefreshBalanceButton();
//            balanceBefore = CountHelper.AccountBalance(tradingPage.getAccountBalanceValueText());
//        }
//        tradingPage.selectCFDEurUsdAsset();
//
//        step("Выбрать инвестицию 100$");
//        tradingPage.selectInvestment100FromList();
//
//        int chosenInvestment = Integer.parseInt(StringHelper.GetAmountFromAccountData(tradingPage.getInvestmentAmountValueText()));
//
//        step("Нажать на кнопку создания сделки на понижение.");
//        tradingPage.createCFDDeal(false);
//        soft.assertThat(tradingPage.isOngoingDealExists()).withFailMessage("Инвестиционная панель не отобразилась").isTrue();
//
//        BigDecimal expectedResult = balanceBefore.subtract(BigDecimal.valueOf(chosenInvestment + chosenInvestment * 0.0002));
//        soft.assertThat(EqualsHelper.prolongedEqualsBalance(expectedResult,
//                tradingPage::getAccountBalanceValueText)).withFailMessage("Сумма на балансе не соответствует ожидаемой сумме после открытия cfd сделки. Ожидаемый результат: " + expectedResult).isTrue();
//
//        step("Открыть таб История сделок.\n" +
//                "На табе CFD проверить наличие:\n" +
//                "- раздела Активные сделки на экране\n" +
//                "- в разделе Активные сделки отображается созданная сделка", () ->
//                step("Раздел активные сделки пристутствует.\n" +
//                        "В разделе есть одна активная сделка, сумма инвестиции совпадает с открытой сделкой.\n" +
//                        "Направление сделки - понижение."));
//        TransactionHistoryPanel transactionHistoryPanel = tradingPage.clickTradesTabButton();
//
//        soft.assertThat(transactionHistoryPanel.isOpenTradesSectionExist()).withFailMessage("Раздел с открытыми сделками не отображается").isTrue();
//        assertThat(transactionHistoryPanel.isOpenCfdDealExist()).withFailMessage("Открытая cfd сделка не отображается").isTrue();
//        soft.assertThat(CountHelper.AccountBalance(transactionHistoryPanel.getLastCfdDealInvestmentText()).intValue()).isEqualTo(chosenInvestment);
//
//        transactionHistoryPanel.closeLastOpenCfdDeal();
//    }
//
//
//
//
//    @Test
//    @AllureId("15435")
//    @DisplayName("an/ Чат. Открытие экрана из меню")
//    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Priority(Categories.Priority.LOW)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    public void OpenChatSection() {
//        step("[Precondition] Пользователь находится в трейдруме");
//
//        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getAutotestUser1Password());
//        tradingPage.checkTradingPage();
//
//        step("Нажать на таб Account", () ->
//                step("Пользователь находится в таб Account"));
//        AccountTab accountTab = tradingPage.clickProfileTabButton();
//
//        step("Нажать на Чат", () ->
//                step("Открылся раздел \"Чат\", который содержит\n" +
//                        "Кнопку <- Назад\n" +
//                        "ID пользователя\n" +
//                        "Поле для ввода\n" +
//                        "Кнопку отправить"));
//        ChatPanel chatPanel = accountTab.clickChatButton();
//        chatPanel.checkChatPanel();
//
//        soft.assertThat(chatPanel.isNavigateUpButtonExists()).withFailMessage("Кнопка <- Назад не найдена").isTrue();
//        soft.assertThat(chatPanel.isUserIDExists()).withFailMessage("ID пользователя не найден").isTrue();
//        soft.assertThat(chatPanel.isMessageFieldDisplayed()).withFailMessage("Поле для ввода не найдено").isTrue();
//        soft.assertThat(chatPanel.isSendMessageButtonDisplayed()).withFailMessage("Кнопку отправить не найдена").isTrue();
//
//    }
//
//    @Test
//    @Disabled("мигающий тест")
//    @AllureId("15506")
//    @DisplayName("and/ Механика FTT. Открыть таб Account")
//    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
//    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
//    @AutomationStatuses({
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
//            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
//    })
//    @Story1(Categories.JMobileTree.MARKETLY)
//    @Story2(Categories.JMobileTree.TRAIDER_MODE)
//    @Priority(Categories.Priority.LOW)
//    @Platform(Categories.Platform.ANDROID)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
//    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
//    public void OpenAccountTabOnFtt() {
//        step("[Precondition] Пользователь авторизован в приложении.\n" +
//                "Статус Standard.\n" +
//                "Открыта механика FTT.\n" +
//                "Пользователю доступна касса");
//        TradingPage tradingPage = getWelcomePage().signInToBinaryTradeRoom(UserData.getDoneVerificationUserEmail(), UserData.getDoneVerificationUserPassword());
//        tradingPage.checkTradingPage();
//
//        step("Открыть таб Account", () ->
//                step("Открыть таб Account"));
//        AccountTab accountTab = tradingPage.clickProfileTabButton();
//        accountTab.checkAccountTab();
//
//        step("Проверить наличие элементов: " +
//                "  - раздел Profile\n" +
//                "  - раздел Balance\n" +
//                "  - раздел Статусы\n" +
//                "  - раздел Bonuses\n" +
//                "  - раздел Verification\n" +
//                "  - раздел Whats New\n" +
//                "  - раздел Top traders\n" +
//                "  - заголовок Help\n" +
//                "  - Help Center\n" +
//                "  - Чат\n" +
//                "  - Контакты\n" +
//                "  - Заголовок Other\n" +
//                "  - Клиентское соглашение\n" +
//                "  - Log out\n" +
//                "  - текст Dont want to use the platform anymore?\n" +
//                "  - кнопка - ссылка Delete account", () ->
//                step(" Все элементы отображаются корректно "));
//        soft.assertThat(accountTab.isProfileMenuItemExists()).withFailMessage("Раздел Profile не найден").isTrue();
//        soft.assertThat(accountTab.isBalanceItemExists()).withFailMessage("Раздел Balance не найден").isTrue();
//        soft.assertThat(accountTab.isStatusItemExists()).withFailMessage("Раздел Statuses не найден").isTrue();
//        soft.assertThat(accountTab.isBonusesItemExists()).withFailMessage("Раздел Bonuses не найден").isTrue();
//        soft.assertThat(accountTab.isVerificationItemExists()).withFailMessage("Раздел Verification не найден").isTrue();
//        soft.assertThat(accountTab.isWhatsNewItemExists()).withFailMessage("Раздел Whats new не найден").isTrue();
//        soft.assertThat(accountTab.isTopTradersItemExists()).withFailMessage("Раздел Top traders не найден").isTrue();
//        soft.assertThat(accountTab.isHelpTitleItemExists()).withFailMessage("Раздел Help не найден").isTrue();
//        soft.assertThat(accountTab.isHelpCenterItemExists()).withFailMessage("Раздел HelpCenter не найден").isTrue();
//        soft.assertThat(accountTab.isChatItemExists()).withFailMessage("Раздел Чат не найден").isTrue();
//        soft.assertThat(accountTab.isOtherTitleItemExists()).withFailMessage("Раздел Other не найден").isTrue();
//        soft.assertThat(accountTab.isClientAgreementItemExists()).withFailMessage("Раздел Клиентское соглашение не найден").isTrue();
//        soft.assertThat(accountTab.isLogOutButtonExists()).withFailMessage("Кнопка Log out не найдена").isTrue();
//        soft.assertThat(accountTab.isUsePlatformTextExists()).withFailMessage("Текст Don't want to use the platform anymore ? не найден").isTrue();
//        soft.assertThat(accountTab.isDeleteAccountButtonExists()).withFailMessage("Кнопка Delete account не найдена").isTrue();
//    }
}
