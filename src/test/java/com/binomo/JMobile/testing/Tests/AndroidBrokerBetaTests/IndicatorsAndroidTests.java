package com.example.JMobile.testing.Tests.AndroidBrokerBetaTests;

import com.example.JMobile.framework.DataProviders.TestData;
import com.example.JMobile.framework.DataProviders.UserData;
import com.example.JMobile.framework.Enums.Categories;
import com.example.JMobile.framework.Enums.MsgFactory;
import com.example.JMobile.framework.Enums.Tags;
import com.example.JMobile.framework.Enums.Titles;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsPanel;
import com.example.JMobile.framework.POM.Steps.Panels.IndicatorsSettingsPanel;
import com.example.JMobile.framework.annotations.*;
import com.example.JMobile.testing.Watcher;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class IndicatorsAndroidTests extends Watcher {

    @Test
    @AllureId("4010")
    @DisplayName("Добавление индикаторов")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA),
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_MARKETLY)
    })
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.ADD_INDICATOR)
    @Priority(Categories.Priority.HIGH)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckAddIndicators() {
        step("[Precondition] Пользователь в трейдруме, индикаторы выключены\n" +
                "Селектор индикаторов открыт");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseMovingAverage();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.MOVING_AVERAGE_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseAlligator();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ALLIGATOR_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseBollinger();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.BOLLINGER_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.choosePSar();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.SAR_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isPSarIndicatorInActiveExists()).withFailMessage("Parabolic SAR отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveExists()).withFailMessage("Bollinger отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveExists()).withFailMessage("Alligator отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveExists()).withFailMessage("Moving average отсутствует в списке активных индикаторов").isTrue();

        indicatorsPanel = indicatorsPanel.clickRemoveMovingAverageIndicator();
        indicatorsPanel = indicatorsPanel.clickRemovePSarIndicator();
        indicatorsPanel = indicatorsPanel.clickRemoveAlligatorIndicator();
        indicatorsPanel = indicatorsPanel.clickRemoveBollingerIndicator();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseFractals();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTALS_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseRSI();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.RELATIVE_STRENGTH_INDEX_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseMACD();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.MACD_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseCCI();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.CCI_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists()).withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveExists()).withFailMessage("RSI отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveExists()).withFailMessage("MACD отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();

        indicatorsPanel = indicatorsPanel.clickRemoveFractalsIndicator();
        indicatorsPanel = indicatorsPanel.clickRemoveRSIIndicator();
        indicatorsPanel = indicatorsPanel.clickRemoveMACDIndicator();
        indicatorsPanel = indicatorsPanel.clickRemoveCCIIndicator();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseFractalChaosBands();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTAL_CHAOS_BANDS_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseStochastic();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.STOCHASTIC_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseATR();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ATR_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveExists()).withFailMessage("Fractal Chaos Bands отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveExists()).withFailMessage("ATR отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
    }

    @Test
    @AllureId("4011")
    @DisplayName("Удаление индикаторов")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    })
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.ADD_INDICATOR)
    @Priority(Categories.Priority.HIGH)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckDeleteIndicators() {
        step("[Precondition] Пользователь в трейдруме\n" +
                "Все имеющиеся индикаторы включены\n" +
                "Открыт селектор индикаторов в наборе \"Active\"");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseMovingAverage();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseAlligator();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseBollinger();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.choosePSar();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isPSarIndicatorInActiveExists()).withFailMessage("Parabolic SAR отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveExists()).withFailMessage("Bollinger отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveExists()).withFailMessage("Alligator отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveExists()).withFailMessage("Moving average отсутствует в списке активных индикаторов").isTrue();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveMovingAverageIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveAlligatorIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveBollingerIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemovePSarIndicator();

        indicatorsSettingsPanel = indicatorsPanel.chooseFractals();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseRSI();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseMACD();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseCCI();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveExists()).withFailMessage("MACD отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveExists()).withFailMessage("RSI отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists()).withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveCCIIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveMACDIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveRSIIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveFractalsIndicator();

        indicatorsSettingsPanel = indicatorsPanel.chooseFractalChaosBands();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseStochastic();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseATR();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveExists()).withFailMessage("ATR отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveADX();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveATR();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveStochastic();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveFractalChaosBandsIndicator();

        step("Все индикаторы удалены с графика, набор активных индикаторов пуст, доступных - не изменился");
        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveMissing()).withFailMessage("Moving average присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveMissing()).withFailMessage("Alligator присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveMissing()).withFailMessage("Bollinger присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isPSarIndicatorInActiveMissing()).withFailMessage("Parabolic SAR присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveMissing()).withFailMessage("Fractals присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveMissing()).withFailMessage("Fractal Chaos Bands присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveMissing()).withFailMessage("RSI присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveMissing()).withFailMessage("MACD присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveMissing()).withFailMessage("CCI присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveMissing()).withFailMessage("Stochastic присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveMissing()).withFailMessage("ATR присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveMissing()).withFailMessage("ADX присутствует в списке активных индикаторов").isTrue();

        tradingPage.clickClosePanelButton();
        tradingPage.screenForIndicatorsVerification();
    }

    @Test
    @AllureId("4030")
    @DisplayName("Moving Average. Изменение настроек. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    })
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.CRITICAL)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckMovingAverageIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме, индикаторы выключены.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Moving Average находится в разделе Active.\n" +
                "валидные значения периода от 1 до 99\n" +
                "валидные значения офсет от 0 до 60");

        String randomIndicatorPeriod = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");
        String randomIndicatorOffset = TestData.getRandomIndicatorOffset().replaceAll("^0+", "");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        step("Тапнуть на индикатор Moving Average", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseMovingAverage();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.MOVING_AVERAGE_INDICATOR_TITLE));

        step("Ввести новое значение в поле Period с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setMovingAverageIndicatorPeriod(randomIndicatorPeriod);
        indicatorsSettingsPanel.setMovingAverageIndicatorOffset(randomIndicatorOffset);
        String indicatorPeriodNewValue = indicatorsSettingsPanel.getMovingAverageIndicatorPeriodText();
        String indicatorOffsetNewValue = indicatorsSettingsPanel.getMovingAverageIndicatorOffsetText();

        indicatorsSettingsPanel.swipeDown();
        step("Прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение.\n" +
                        "(для автотеста: у локатора элемента иконки аттрибут checked стал true)"));
        indicatorsSettingsPanel.chooseMovingAverageFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Moving Average, в который вносили изменения.\n" +
                "Проверить настройки Period и цвета.", () ->
                step("Значение Period совпадает со значением с шага 2.\n" +
                        "Выбранная иконка цвета совпадает с иконкой, выбранной на шаге 3.\n" +
                        "(для автотеста: выбранный на шаге 3 элемент сохранил аттрибут checked=true)"));
        indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveExists()).withFailMessage("Moving average отсутствует в списке активных индикаторов").isTrue();
        indicatorsPanel.clickEditMovingAverage();

        soft.assertThat(indicatorPeriodNewValue).as("Установленный period не соответствует ожиданию").isEqualTo(indicatorsSettingsPanel.getMovingAverageIndicatorPeriodText());
        soft.assertThat(indicatorOffsetNewValue).as("Установленный offset не соответствует ожиданию").isEqualTo(indicatorsSettingsPanel.getMovingAverageIndicatorOffsetText());
        soft.assertThat(indicatorsSettingsPanel.isMovingAverageFirstColorChosen()).withFailMessage("Установленный цвет не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("4032")
    @DisplayName("Alligator. Изменение настроек. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    })
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckAlligatorIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме, индикаторы выключены.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Alligator находится в разделе Active.");

        String randomIndicatorPeriod = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");

        System.out.println("randomIndicatorPeriod: " + randomIndicatorPeriod);
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        step("Тапнуть на индикатор Alligator", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseAlligator();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ALLIGATOR_INDICATOR_TITLE));

        step("В разделе Jaws ввести новые значения в поля Period и Offset с клавиатуры", () ->
                step("Новые значения введены"));
        indicatorsSettingsPanel.setAlligatorJawsPeriod(randomIndicatorPeriod);
        indicatorsSettingsPanel.setAlligatorJawsOffset(randomIndicatorPeriod);

        String indicatorJawsPeriodNewValue = indicatorsSettingsPanel.getAlligatorJawsPeriodText();
        String indicatorJawsOffsetNewValue = indicatorsSettingsPanel.getAlligatorJawsOffsetText();

        System.out.println("indicatorJawsPeriodNewValue: " + indicatorJawsPeriodNewValue);
        System.out.println("indicatorJawsOffsetNewValue: " + indicatorJawsOffsetNewValue);

        step("В разделе Jaws прокрутить ленту цветов индикатора и выбрать третью иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAlligatorJawsThirdColor();

        step("В разделе Lips ввести новые значения в поля Period и Offset с клавиатуры", () ->
                step("Новые значения введены"));
        indicatorsSettingsPanel.setAlligatorLipsPeriod(randomIndicatorPeriod);
        indicatorsSettingsPanel.setAlligatorLipsOffset(randomIndicatorPeriod);

        String indicatorLipsPeriodNewValue = indicatorsSettingsPanel.getAlligatorLipsPeriodText();
        String indicatorLipsOffsetNewValue = indicatorsSettingsPanel.getAlligatorLipsOffsetText();
        System.out.println("indicatorLipsPeriodNewValue: " + indicatorLipsPeriodNewValue);
        System.out.println("indicatorLipsOffsetNewValue: " + indicatorLipsOffsetNewValue);

        step("В разделе Lips прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAlligatorLipsSecondColor();

        step("В разделе Teeth ввести новые значения в поля Period и Offset с клавиатуры", () ->
                step("Новые значения введены"));
        indicatorsSettingsPanel.setAlligatorTeethPeriod(randomIndicatorPeriod);
        indicatorsSettingsPanel.setAlligatorTeethOffset(randomIndicatorPeriod);

        String indicatorTeethPeriodNewValue = indicatorsSettingsPanel.getAlligatorTeethPeriodText();
        String indicatorTeethOffsetNewValue = indicatorsSettingsPanel.getAlligatorTeethOffsetText();

        //todo: пофиксить баги с неверным скроллом (сейчас вместо скролла влево используется скролл справа)
        step("В разделе Teeth прокрутить ленту цветов индикатора и выбрать предпоследнюю иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.swipeDown();
        indicatorsSettingsPanel.chooseAlligatorTeethFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveExists()).withFailMessage("Alligator отсутствует в списке активных индикаторов").isTrue();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Alligator, в который вносили изменения.\n" +
                "Проверить настройки Period, Offset и цвета.", () ->
                step("Значения Period и Offset совпадают с внесенными значениями с шагах 2,4 и 6.\n" +
                        "Выбранные иконки цветов совпадает с иконками, выбранными на шагах 3, 5 и 7."));
        indicatorsPanel.clickEditAlligator();

        soft.assertThat(indicatorsSettingsPanel.getAlligatorJawsPeriodText()).as("Установленный Jaws period не соответствует ожиданию").isEqualTo(indicatorJawsPeriodNewValue);
        soft.assertThat(indicatorsSettingsPanel.getAlligatorJawsOffsetText()).as("Установленный Jaws offset не соответствует ожиданию").isEqualTo(indicatorJawsOffsetNewValue);
        soft.assertThat(indicatorsSettingsPanel.isAlligatorJawsThirdColorChosen()).withFailMessage("Установленный jaws color не соответствует ожиданию").isTrue();

        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.getAlligatorLipsPeriodText()).as("Установленный Lips period не соответствует ожиданию").isEqualTo(indicatorLipsPeriodNewValue);
        soft.assertThat(indicatorsSettingsPanel.getAlligatorLipsOffsetText()).as("Установленный Lips offset не соответствует ожиданию").isEqualTo(indicatorLipsOffsetNewValue);
        soft.assertThat(indicatorsSettingsPanel.isAlligatorLipsSecondColorChosen()).withFailMessage("Установленный lips color не соответствует ожиданию").isTrue();

        indicatorsSettingsPanel.swipeToBottom();
        soft.assertThat(indicatorsSettingsPanel.getAlligatorTeethPeriodText()).as("Установленный Teeth period не соответствует ожиданию").isEqualTo(indicatorTeethPeriodNewValue);
        soft.assertThat(indicatorsSettingsPanel.getAlligatorTeethOffsetText()).as("Установленный Teeth offset не соответствует ожиданию").isEqualTo(indicatorTeethOffsetNewValue);
        soft.assertThat(indicatorsSettingsPanel.isAlligatorTeethFirstColorChosen()).withFailMessage("Установленный teeth color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("4036")
    @DisplayName("Parabolic SAR. Изменение настроек. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckParabolicSARIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме, индикаторы выключены.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Parabolic SAR находится в разделе Active.");

        String minAF = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");
        String maxAF = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        step("Тапнуть на индикатор Parabolic SAR", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.choosePSar();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.SAR_INDICATOR_TITLE));

        step("Ввести новое значение в поле Minimum AF с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel = indicatorsSettingsPanel.setPSarMinAF(minAF);
        minAF = indicatorsSettingsPanel.getPSarMinAFText();

        step("Ввести новое значение в поле Maximum AF с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel = indicatorsSettingsPanel.setPSarMaxAF(maxAF);
        maxAF = indicatorsSettingsPanel.getPSarMaxAFText();

        step("Прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.choosePSarFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Parabolic SAR, в который вносили изменения.\n" +
                "Проверить настройки Minimum AF, Maximum AF и цвета.", () ->
                step("Значения Minimum AF и Maximum AF совпадают со значениями с шагов 2 и 3.\n" +
                        "Выбранная иконка цвета совпадает с иконкой, выбранной на шаге 4."));
        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isPSarIndicatorInActiveExists()).withFailMessage("Parabolic SAR отсутствует в списке активных индикаторов").isTrue();

        indicatorsSettingsPanel = indicatorsPanel.clickEditPSar();

        soft.assertThat(indicatorsSettingsPanel.getPSarMinAFText().replaceAll(".0", "")).as("Установленный Minimum AF не соответствует ожиданию").isEqualTo(minAF);
        soft.assertThat(indicatorsSettingsPanel.getPSarMaxAFText().replaceAll(".0", "")).as("Установленный Maximum AF не соответствует ожиданию").isEqualTo(maxAF);
        soft.assertThat(indicatorsSettingsPanel.isPSarFirstColorChosen()).withFailMessage("Установленный color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("23273")
    @DisplayName("Fractals Изменение настроек. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleFractalsIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор Fractals.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Fractals находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseFractals();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTALS_INDICATOR_TITLE));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists()).withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();

        step("Тапнуть на индикатор Fractals", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.clickEditFractals();

        step("Выбрать новое значение в поле Period ", () ->
                step("Новое значение выбрано"));
        indicatorsSettingsPanel.setFractalsPeriod();
        String periodValue = indicatorsSettingsPanel.getFractalsPeriodText();

        step("В разделе Period прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalsFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Fractals, в который вносили изменения.\n" +
                "Проверить настройки Period и цвета.", () ->
                step("Значение настроек индикатора изменилось в соответствии с изменением значения Period на шаге 2.\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шаге 3"));
        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists()).withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();

        indicatorsSettingsPanel = indicatorsPanel.clickEditFractals();

        soft.assertThat(indicatorsSettingsPanel.getFractalsPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(periodValue);
        soft.assertThat(indicatorsSettingsPanel.isFractalsFirstColorChosen()).withFailMessage("Установленный color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("23276")
    @DisplayName("Fractals Изменение настроек. Видимость отключена. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckInvisibleFractalsIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Индикатор Fractals включен.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Fractals находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (\"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseFractals();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTALS_INDICATOR_TITLE));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists()).withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();

        step("Тапнуть на иконку \"глаза\" у индикатора Fractals", () ->
                step("Иконка изменилась на \"глаз перечеркнутый\""));
        indicatorsPanel = indicatorsPanel.clickIndicatorVisibleButton();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        step("Тапнуть на индикатор Fractals в разделе Active", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.clickEditFractals();

        step("Выбрать новое значение в поле Period ", () ->
                step("Новое значение выбрано"));
        indicatorsSettingsPanel = indicatorsSettingsPanel.setFractalsPeriod();
        String periodValue = indicatorsSettingsPanel.getFractalsPeriodText();

        step("В разделе Period прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalsFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Fractals, в который вносили изменения.\n" +
                "Проверить настройки Period и цвета.", () ->
                step("Значение настроек индикатора изменилось в соответствии с изменением значения Period на шаге 4.\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шаге 5"));
        indicatorsPanel = tradingPage
                .clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalsIndicatorInActiveExists())
                .withFailMessage("Fractals отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton())
                .withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        indicatorsSettingsPanel = indicatorsPanel.clickEditFractals();

        soft.assertThat(indicatorsSettingsPanel.getFractalsPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(periodValue);
        soft.assertThat(indicatorsSettingsPanel.isFractalsFirstColorChosen()).withFailMessage("Установленный color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("23279")
    @DisplayName("Fractal chaos bands. Изменение настроек. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleFractalChaosBandsIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор Fractal chaos bands.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Fractal chaos bands находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseFractalChaosBands();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTAL_CHAOS_BANDS_INDICATOR_TITLE));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveExists()).withFailMessage("Fractal Chaos Bands отсутствует в списке активных индикаторов").isTrue();

        step("Тапнуть на индикатор Fractal chaos bands", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.clickEditFractalChaosBands();

        step("Выбрать новое значение в поле Period ", () ->
                step("Новое значение выбрано"));
        indicatorsSettingsPanel = indicatorsSettingsPanel.setFractalChaosBandsPeriod();
        String periodValue = indicatorsSettingsPanel.getFractalChaosBandsPeriodText();

        step("В разделе Channel color прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalChaosBandsChannelFirstColor();

        step("Тапнуть на переключатель Shading", () ->
                step("Переключатель сменил состояния на \"выключено\""));
        indicatorsSettingsPanel = indicatorsSettingsPanel.clickFractalChaosBandsShadingSwitch();

        step("В разделе Upper band's color прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalChaosBandsUpSecondColor();

        step("В разделе Lower band's color прокрутить ленту цветов индикатора и выбрать третью иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalChaosBandsDownThirdColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Fractal chaos bands, в который вносили изменения.\n" +
                "Проверить настройки Period и цветов.", () ->
                step("Значение настроек индикатора изменилось в соответствии с изменением значения Period на шаге 2.\n" +
                        "Переключатель Channel fill в положении \"выключено\"\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах  3, 5, 6"));
        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveExists()).withFailMessage("Fractal Chaos Bands отсутствует в списке активных индикаторов").isTrue();

        indicatorsSettingsPanel = indicatorsPanel.clickEditFractalChaosBands();

        soft.assertThat(indicatorsSettingsPanel.getFractalChaosBandsPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(periodValue);
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsChannelFirstColorChosen()).withFailMessage("Установленный Channel color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsShadingSwitchChosen()).withFailMessage("Shading установлен").isFalse();
        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsUpSecondColorChosen()).withFailMessage("Установленный Upper band's color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsDownThirdColorChosen()).withFailMessage("Установленный Lower band's color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("23280")
    @DisplayName("Fractal chaos bands. Изменение настроек. Видимость отключена. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckInvisibleFractalChaosBandsIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор Fractal chaos bands.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Fractal chaos bands находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseFractalChaosBands();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.FRACTAL_CHAOS_BANDS_INDICATOR_TITLE));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveExists()).withFailMessage("Fractal Chaos Bands отсутствует в списке активных индикаторов").isTrue();

        step("Тапнуть на иконку \"глаза\" у индикатора Fractal chaos bands", () ->
                step("Иконка изменилась на \"глаз перечеркнутый\""));
        indicatorsPanel = indicatorsPanel.clickIndicatorVisibleButton();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        step("Тапнуть на индикатор Fractal chaos bands", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.clickEditFractalChaosBands();

        step("Выбрать новое значение в поле Period ", () ->
                step("Новое значение выбрано"));
        indicatorsSettingsPanel = indicatorsSettingsPanel.setFractalChaosBandsPeriod();
        String periodValue = indicatorsSettingsPanel.getFractalChaosBandsPeriodText();

        step("В разделе Channel color прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalChaosBandsChannelFirstColor();

        step("Тапнуть на переключатель Shading", () ->
                step("Переключатель сменил состояния на \"выключено\""));
        indicatorsSettingsPanel = indicatorsSettingsPanel.clickFractalChaosBandsShadingSwitch();

        step("В разделе Upper band's color прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalChaosBandsUpSecondColor();

        step("В разделе Lower band's color прокрутить ленту цветов индикатора и выбрать третью иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel = indicatorsSettingsPanel.chooseFractalChaosBandsDownThirdColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Fractal chaos bands, в который вносили изменения.\n" +
                "Проверить настройки Period и цветов.", () ->
                step("Значение настроек индикатора изменилось в соответствии с изменением значения Period на шаге 4.\n" +
                        "Переключатель Channel fill в положении \"выключено\"\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах  4, 7, 8"));
        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isFractalChaosBandsIndicatorInActiveExists()).withFailMessage("Fractal Chaos Bands отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        indicatorsSettingsPanel = indicatorsPanel.clickEditFractalChaosBands();

        soft.assertThat(indicatorsSettingsPanel.getFractalChaosBandsPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(periodValue);
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsChannelFirstColorChosen()).withFailMessage("Установленный Channel color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsShadingSwitchChosen()).withFailMessage("Shading установлен").isFalse();
        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsUpSecondColorChosen()).withFailMessage("Установленный Upper band's color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isFractalChaosBandsDownThirdColorChosen()).withFailMessage("Установленный Lower band's color не соответствует ожиданию").isTrue();
    }

    @Disabled("мигающий тест")
    @Test
    @AllureId("4046")
    @DisplayName("CCI Изменение настроек. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.ANTON_RUMYANTSEV)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleCCIIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор CCI.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор CCI находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");

        String indicatorField = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");
        String indicatorPeriod = TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", "");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword());
        tradingPage.checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        step("Тапнуть на индикатор CCI", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseCCI();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.CCI_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();

        indicatorsPanel.clickEditCCI();

        step("Ввести новое значение в поле Lower line с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setCCIBottomLine(indicatorField);
        String bottomLineValue = indicatorsSettingsPanel.getCCIBottomLineText();

        step("В разделе Lower line прокрутить ленту цветов индикатора и выбрать третью иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseCCIBottomLineThirdColor();

        step("Ввести новое значение в поле Upper line с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setCCIUpperLine(indicatorField);
        String upperLineValue = indicatorsSettingsPanel.getCCIUpperLineText();

        step("В разделе Upper line прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseCCIUpperLineSecondColor();

        step("Ввести новое значение в поле Period с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setCCIPeriod(indicatorPeriod);
        String periodValue = indicatorsSettingsPanel.getCCIPeriodText();

        step("В разделе Period прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseCCIPeriodFirstColor();

        step("Тапнуть на переключатель Show zones", () ->
                step("Положение переключателя изменилось"));
        indicatorsSettingsPanel.clickShowZonesSwitch();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного CCI, в который вносили изменения.\n" +
                "Проверить настройки Lower line, Upper line, Period, Show zones и цвета.", () ->
                step("Значения Lower line, Upper line, Period, Show zones совпадают со значениями с шагов 2, 4, 6, 8.\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах 3, 5, 7."));
        indicatorsPanel.clickEditCCI();

        soft.assertThat(indicatorsSettingsPanel.getCCIPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(periodValue);
        soft.assertThat(indicatorsSettingsPanel.isCCIPeriodFirstColorChosen()).withFailMessage("Установленный period color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.getCCIUpperLineText()).as("Установленный upper line не соответствует ожиданию").isEqualTo(upperLineValue);
        soft.assertThat(indicatorsSettingsPanel.isCCIUpperLineSecondColorChosen()).withFailMessage("Установленный upper line color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.getCCIBottomLineText()).as("Установленный bottom line не соответствует ожиданию").isEqualTo(bottomLineValue);
        soft.assertThat(indicatorsSettingsPanel.isCCIBottomLineThirdColorChosen()).withFailMessage("Установленный bottom line color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isShowZonesSwitchChosen()).withFailMessage("Show zones установлен").isFalse();
    }

    @Test
    @AllureId("4047")
    @DisplayName("CCI Изменение настроек. Видимость отключена. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckInvisibleCCIIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Индикатор CCI включен.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор CCI находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (\"глаз\" обычный).");

        String indicatorPeriod = TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", "");
        String indicatorFields = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseCCI();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.CCI_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();

        step("Тапнуть на иконку \"глаза\" у индикатора CCI", () ->
                step("Иконка изменилась на \"глаз перечеркнутый\""));
        indicatorsPanel.clickIndicatorVisibleButton();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();


        step("Нажать на кнопку (x)", () ->
                step("Карточка настроек закрылась."));
        indicatorsPanel.clickCloseButton();


        step("Открыть селектор индикаторов.", () ->
                step("Селектор индикаторов открыт."));
        indicatorsPanel = tradingPage.clickIndicatorsButton().checkIndicatorsPanel();

        step("Тапнуть на индикатор CCI в разделе Active", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditCCI();

        step("Ввести новое значение в поле Lower line с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setCCIBottomLine(indicatorFields);
        String bottomLineValue = indicatorsSettingsPanel.getCCIBottomLineText();

        step("В разделе Lower line прокрутить ленту цветов индикатора и выбрать третью иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseCCIBottomLineThirdColor();

        step("Ввести новое значение в поле Top line с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setCCIUpperLine(indicatorFields);
        String upperLineValue = indicatorsSettingsPanel.getCCIUpperLineText();

        step("В разделе Top line прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseCCIUpperLineSecondColor();

        step("Ввести новое значение в поле Period с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setCCIPeriod(indicatorPeriod);
        String periodValue = indicatorsSettingsPanel.getCCIPeriodText();

        step("В разделе Period прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseCCIPeriodFirstColor();

        step("Тапнуть на переключатель Show zones", () ->
                step("Положение переключателя изменилось"));
        indicatorsSettingsPanel.clickShowZonesSwitch();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isCCIIndicatorInActiveExists()).withFailMessage("CCI отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного CCI, в который вносили изменения.\n" +
                "Проверить настройки Lower line, Upper line, Period, Show zones и цвета.", () ->
                step("Значения Lower line, Upper line, Period, Show zones совпадают со значениями с шагов 2, 4, 6, 8.\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах 3, 5, 7."));
        indicatorsPanel.clickEditCCI();

        soft.assertThat(indicatorsSettingsPanel.getCCIPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(periodValue);
        soft.assertThat(indicatorsSettingsPanel.isCCIPeriodFirstColorChosen()).withFailMessage("Установленный period color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.getCCIUpperLineText()).as("Установленный upper line не соответствует ожиданию").isEqualTo(upperLineValue);
        soft.assertThat(indicatorsSettingsPanel.isCCIUpperLineSecondColorChosen()).withFailMessage("Установленный upper line color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.getCCIBottomLineText()).as("Установленный bottom line не соответствует ожиданию").isEqualTo(bottomLineValue);
        soft.assertThat(indicatorsSettingsPanel.isCCIBottomLineThirdColorChosen()).withFailMessage("Установленный bottom line color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isShowZonesSwitchChosen()).withFailMessage("Show zones установлен").isFalse();
    }

    @Test
    @AllureId("4050")
    @DisplayName("Stochastic Изменение настроек. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleStochasticIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Индикатор Stochastic включен.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Stochastic находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (\"глаз\" обычный).");

        String indicatorPeriod = TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", "");
        String indicatorField = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseStochastic();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.STOCHASTIC_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор Stochastic", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditStochastic();

        step("Ввести новое значение в поле Period с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setStochasticPeriod(indicatorPeriod);
        String period = indicatorsSettingsPanel.getStochasticPeriodText();

        step("Ввести новое значение в поле Overbought с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setStochasticOverbought(indicatorField);
        String overbought = indicatorsSettingsPanel.getStochasticOverboughtText();

        step("Ввести новое значение в поле Oversold с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setStochasticOversold(indicatorField);
        String oversold = indicatorsSettingsPanel.getStochasticOversoldText();

        step("Тапнуть на переключатель Show zones", () ->
                step("Положение переключателя изменилось"));
        indicatorsSettingsPanel.clickShowZonesSwitch();

        step("В разделе Fast line прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseStochasticFastLineSecondColor();

        step("В разделе Slow line прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseStochasticSlowLineFirstColor();

        step("Тапнуть на переключатель Smooth", () ->
                step("Положение переключателя изменилось"));
        indicatorsSettingsPanel.clickSmoothSwitch();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного Stochastic, в который вносили изменения.\n" +
                "Проверить настройки Overbought, Oversold, Period, Show zones, Smooth и цвета.", () ->
                step("Значения Overbought, Oversold, Period, Show zones, Smooth совпадают со значениями с шагов 2, 3, 4, 5, 8.\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах 6, 7."));
        indicatorsPanel.clickEditStochastic();

        soft.assertThat(indicatorsSettingsPanel.getStochasticPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(period);
        soft.assertThat(indicatorsSettingsPanel.getStochasticOverboughtText()).as("Установленный overbought не соответствует ожиданию").isEqualTo(overbought);
        soft.assertThat(indicatorsSettingsPanel.getStochasticOversoldText()).as("Установленный oversold не соответствует ожиданию").isEqualTo(oversold);
        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.isShowZonesSwitchChosen()).withFailMessage("Show zones установлен").isFalse();
        soft.assertThat(indicatorsSettingsPanel.isStochasticFastLineSecondColorChosen()).withFailMessage("Установленный fast line color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isStochasticSlowLineFirstColorChosen()).withFailMessage("Установленный slow line color не соответствует ожиданию").isTrue();
        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.isSmoothSwitchChosen()).withFailMessage("Smooth установлен").isFalse();
    }

    @Test
    @AllureId("4052")
    @DisplayName("Stochastic Изменение настроек. Видимость отключена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckInvisibleStochasticIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Индикатор Stochastic включен.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор Stochastic находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (\"глаз\" обычный).");

        String indicatorPeriod = TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", "");
        String indicatorField = TestData.getRandomIndicatorPeriod().replaceAll("^0+", "");

        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseStochastic();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.STOCHASTIC_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();

        step("Тапнуть на иконку \"глаза\" у индикатора Stochastic", () ->
                step("Иконка изменилась на \"глаз перечеркнутый\""));
        indicatorsPanel.clickIndicatorVisibleButton();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        step("Закрыть карточку селектора индикаторов", () ->
                step("Карточка закрылась"));
        indicatorsPanel.clickCloseButton();

        step("Открыть селектор индикаторов.", () ->
                step("Селектор индикаторов открыт."));
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        step("Тапнуть на индикатор Stochastic в разделе Active", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditStochastic();

        step("Ввести новое значение в поле Period с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setStochasticPeriod(indicatorPeriod);
        String period = indicatorsSettingsPanel.getStochasticPeriodText();

        step("Ввести новое значение в поле Overbought с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setStochasticOverbought(indicatorField);
        String overbought = indicatorsSettingsPanel.getStochasticOverboughtText();

        step("Ввести новое значение в поле Oversold с клавиатуры", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setStochasticOversold(indicatorField);
        String oversold = indicatorsSettingsPanel.getStochasticOversoldText();

        step("Тапнуть на переключатель Show zones", () ->
                step("Положение переключателя изменилось"));
        indicatorsSettingsPanel.clickShowZonesSwitch();

        step("В разделе Fast line прокрутить ленту цветов индикатора и выбрать вторую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseStochasticFastLineSecondColor();

        step("В разделе Slow line прокрутить ленту цветов индикатора и выбрать первую иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseStochasticSlowLineFirstColor();

        step("Тапнуть на переключатель Smooth", () ->
                step("Положение переключателя изменилось"));
        indicatorsSettingsPanel.clickSmoothSwitch();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isStochasticIndicatorInActiveExists()).withFailMessage("Stochastic отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        step("Открыть настройки добавленного Stochastic, в который вносили изменения.\n" +
                "Проверить настройки Overbought, Oversold, Period, Show zones, Smooth и цвета.", () ->
                step("Значения Overbought, Oversold, Period, Show zones, Smooth совпадают со значениями с шагов 5, 6, 7, 8, 11.\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах 9, 10."));
        indicatorsPanel.clickEditStochastic();

        soft.assertThat(indicatorsSettingsPanel.getStochasticPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(period);
        soft.assertThat(indicatorsSettingsPanel.getStochasticOverboughtText()).as("Установленный overbought не соответствует ожиданию").isEqualTo(overbought);
        soft.assertThat(indicatorsSettingsPanel.getStochasticOversoldText()).as("Установленный oversold не соответствует ожиданию").isEqualTo(oversold);
        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.isShowZonesSwitchChosen()).withFailMessage("Show zones установлен").isFalse();
        soft.assertThat(indicatorsSettingsPanel.isStochasticFastLineSecondColorChosen()).withFailMessage("Установленный fast line color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isStochasticSlowLineFirstColorChosen()).withFailMessage("Установленный slow line color не соответствует ожиданию").isTrue();
        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.isSmoothSwitchChosen()).withFailMessage("Smooth установлен").isFalse();
    }

    @Test
    @AllureId("23673")
    @DisplayName("ADX. Изменение настроек Color и Period. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleADXIndicatorColorAndPeriod() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        step("Выбрать новое значение в поле MA Period ", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setADXMAPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));
        String maPeriod = indicatorsSettingsPanel.getADXMAPeriodText();

        step("Выбрать новое значение в поле Smoothing Period ", () ->
                step("Новое значение выбрано"));
        indicatorsSettingsPanel.setADXSmoothingPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));
        String smoothingPeriod = indicatorsSettingsPanel.getADXSmoothingPeriodText();

        step("В разделе Histogram color.Decline прокрутить ленту цветов индикатора и выбрать первую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxDeclineFirstColor();

        step("В разделе Histogram color. Growth прокрутить ленту цветов индикатора и выбрать вторую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxGrowthSecondColor();

        step("В разделе -DI color прокрутить ленту цветов индикатора и выбрать третью с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxMinusDIThirdColor();

        step("В разделе +DI color прокрутить ленту цветов индикатора и выбрать четвертую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxPlusDIFourthColor();

        step("В разделе ADX color прокрутить ленту цветов индикатора и выбрать первую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройки MA и Smoothing Period и всех цветов.", () ->
                step("Значение настроек индикатора изменилось в соответствии с изменением значения Period на шаге 2 и 3.\n" +
                        "\n" +
                        "Выбранные иконки цвета совпадают с иконками, выбранными на шагах  4, 5, 6, 7, 8"));
        indicatorsPanel.clickEditADX();

        soft.assertThat(indicatorsSettingsPanel.getADXMAPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(maPeriod);
        soft.assertThat(indicatorsSettingsPanel.getADXSmoothingPeriodText()).as("Установленный smoothing period не соответствует ожиданию").isEqualTo(smoothingPeriod);
        soft.assertThat(indicatorsSettingsPanel.isAdxDeclineFirstColorChosen()).withFailMessage("Установленный Decline color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxGrowthSecondColorChosen()).withFailMessage("Установленный Growth color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxMinusDIThirdColorChosen()).withFailMessage("Установленный -DI color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxPlusDIFourthColorChosen()).withFailMessage("Установленный +DI color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxFirstColorChosen()).withFailMessage("Установленный ADX color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("23674")
    @DisplayName("ADX. Изменение Show histogram. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleADXIndicatorShowHistogram() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        step("Проверить состояние настройки Show histogram", () ->
                step("Настройка выключена"));
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Show histogram включен").isFalse();

        step("Включить настройку Show histogram", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Show histogram отключена").isTrue();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройку Show histogram", () ->
                step("Настройка включена"));
        indicatorsPanel.clickEditADX();

        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Show histogram отключена").isTrue();

        step("Выключить настройку Show histogram", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Show histogram включена").isFalse();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройку Show histogram", () ->
                step("Настройка отключена"));
        indicatorsPanel.clickEditADX();

        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Show histogram включена").isFalse();
    }

    @Test
    @AllureId("23675")
    @DisplayName("ADX. Изменение Show ADX, DIs. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleADXIndicatorShowADXDIs() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        step("Проверить состояние настройки Show ADX, DIs", () ->
                step("Настройка включена"));
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Show ADX, DIs отключен").isTrue();

        step("Отключить настройку Show ADX, DIs", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Show ADX, DIs включен").isFalse();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройку Show ADX, DIs", () ->
                step("Настройка отключена"));
        indicatorsPanel.clickEditADX();

        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Show ADX, DIs включен").isFalse();

        step("Включить настройку Show ADX, DIs", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Show ADX, DIs отключен").isTrue();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройку Show ADX, DIs", () ->
                step("Настройка включена"));
        indicatorsPanel.clickEditADX();

        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Show ADX, DIs отключен").isTrue();
    }

    @Test
    @AllureId("23676")
    @DisplayName("ADX. Изменение Shading. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleADXIndicatorShading() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        assertThat(indicatorsPanel.getIndicatorsMenuHeaderText())
                .as("Заголовок панели индикаторов не соответствует ожиданию")
                .isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        step("Проверить состояние настройки Shading", () ->
                step("Настройка включена"));
        assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Shading отключен").isTrue();

        step("Отключить настройку Shading", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();
        assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Shading включен").isFalse();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройку Shading", () ->
                step("Настройка отключена"));
        indicatorsPanel.clickEditADX();

        assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Shading включен").isFalse();

        step("Включить настройку Shading", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();
        assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Shading отключен").isTrue();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Открыть настройки добавленного ADX, в который вносили изменения.\n" +
                "Проверить настройку Shading", () ->
                step("Настройка включена"));
        indicatorsPanel.clickEditADX();

        assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Shading отключен").isTrue();
    }

    @Test
    @AllureId("23677")
    @DisplayName("ADX. Восстановление Default настроек. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckADXIndicatorDefaultSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        // last time it was ok
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(
                        indicatorsSettingsPanel.getIndicatorSettingsHeaderText())
                .as("Название индикатора не соответствует ожиданию")
                .isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE)
                );
        indicatorsSettingsPanel.clickApplyButton();
        // it is broken

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        step("Сохранить (запомнить) значения всех настроек индикатора, которые были при открытии карточки", () ->
                step("Значения запомнены"));

        step("Выбрать новое значение в поле MA Period ", () ->
                step("Новое значение введено"));
        String defaultMAPeriod = indicatorsSettingsPanel.getADXMAPeriodText();
        indicatorsSettingsPanel.setADXMAPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));

        step("Выбрать новое значение в поле Smoothing Period ", () ->
                step("Новое значение выбрано"));
        String defaultSmoothingPeriod = indicatorsSettingsPanel.getADXSmoothingPeriodText();
        indicatorsSettingsPanel.setADXSmoothingPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));

        step("В разделе Histogram color.Decline прокрутить ленту цветов индикатора и выбрать первую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        soft.assertThat(indicatorsSettingsPanel.isAdxDeclineSecondColorChosen()).withFailMessage("Цвет настройки Histogram color. Decline не второй по умолчанию").isTrue();
        indicatorsSettingsPanel.chooseAdxDeclineFirstColor();

        step("В разделе Histogram color. Growth прокрутить ленту цветов индикатора и выбрать вторую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        soft.assertThat(indicatorsSettingsPanel.isAdxGrowthThirdColorChosen()).withFailMessage("Цвет настройки Histogram color. Growth не третий по умолчанию").isTrue();
        indicatorsSettingsPanel.chooseAdxGrowthSecondColor();

        step("В разделе -DI color прокрутить ленту цветов индикатора и выбрать третью с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        soft.assertThat(indicatorsSettingsPanel.isAdxMinusDISecondColorChosen()).withFailMessage("Цвет настройки -DI Color не второй по умолчанию").isTrue();
        indicatorsSettingsPanel.chooseAdxMinusDIThirdColor();

        step("В разделе +DI color прокрутить ленту цветов индикатора и выбрать четвертую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        soft.assertThat(indicatorsSettingsPanel.isAdxPlusDIThirdColorChosen()).withFailMessage("Цвет настройки +DI Color не третий по умолчанию").isTrue();
        indicatorsSettingsPanel.chooseAdxPlusDIFourthColor();

        step("В разделе ADX color прокрутить ленту цветов индикатора и выбрать первую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        soft.assertThat(indicatorsSettingsPanel.isAdxSixthColorChosen()).withFailMessage("Цвет настройки ADX Color не шестой по умолчанию").isTrue();
        indicatorsSettingsPanel.chooseAdxFirstColor();

        step("Включить настройку Show histogram", () ->
                step("Настройка включена"));
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Настройка Show histogram не отключена по умолчанию").isFalse();
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();

        step("Отключить настройку Show ADX, DIs", () ->
                step("Настройка отключена"));
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Настройка Show ADX, DIs не включена по умолчанию").isTrue();
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();

        step("Отключить настройку Shading", () ->
                step("Настройка отключена"));
        soft.assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Настройка Shading не включена по умолчанию").isTrue();
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();

        step("Нажать на кнопку Default", () ->
                step("Значение всех настроек индикатора изменилось на те значения, которые были при открытии карточки настроек"));
        indicatorsSettingsPanel.clickDefaultButton();
        indicatorsSettingsPanel.swipeToTopOfADXPanel();

        soft.assertThat(indicatorsSettingsPanel.getADXMAPeriodText()).as("MA Period не изменился на дефолтный").isEqualTo(defaultMAPeriod);
        soft.assertThat(indicatorsSettingsPanel.getADXSmoothingPeriodText()).as("Smoothing Period не изменился на дефолтный").isEqualTo(defaultSmoothingPeriod);
        soft.assertThat(indicatorsSettingsPanel.isAdxDeclineSecondColorChosen()).withFailMessage("Цвет настройки Histogram color. Decline не изменился на второй по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxGrowthThirdColorChosen()).withFailMessage("Цвет настройки Histogram color. Growth не изменился на третий по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxMinusDISecondColorChosen()).withFailMessage("Цвет настройки -DI Color не изменился на второй по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxPlusDIThirdColorChosen()).withFailMessage("Цвет настройки +DI Color не изменился на третий по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxSixthColorChosen()).withFailMessage("Цвет настройки ADX Color не изменился на шестой по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Настройка Show histogram не изменилась на отключенную по умолчанию").isFalse();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Настройка Show ADX, DIs не изменилась на включенную по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Настройка Shading не изменилась на включенную по умолчанию").isTrue();

        step("Снова изменить все настройки индикатора, повторив шаги 3 - 12", () ->
                step("Настройки изменены"));
        indicatorsSettingsPanel.swipeToTopOfADXPanel();
        indicatorsSettingsPanel.setADXMAPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));
        indicatorsSettingsPanel.setADXSmoothingPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));
        indicatorsSettingsPanel.chooseAdxDeclineFirstColor();
        indicatorsSettingsPanel.chooseAdxGrowthSecondColor();
        indicatorsSettingsPanel.chooseAdxMinusDIThirdColor();
        indicatorsSettingsPanel.chooseAdxPlusDIFourthColor();
        indicatorsSettingsPanel.chooseAdxFirstColor();
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Нажать на кнопку Default.\n" +
                "Проверить значения всех настроек", () ->
                step("Все настройки индикаторов вернулись к значениям шага 2"));
        indicatorsPanel.clickEditADX();
        indicatorsSettingsPanel.clickDefaultButton();

        soft.assertThat(indicatorsSettingsPanel.getADXMAPeriodText()).as("MA Period не изменился на дефолтный").isEqualTo(defaultMAPeriod);
        soft.assertThat(indicatorsSettingsPanel.getADXSmoothingPeriodText()).as("Smoothing Period не изменился на дефолтный").isEqualTo(defaultSmoothingPeriod);
        soft.assertThat(indicatorsSettingsPanel.isAdxDeclineSecondColorChosen()).withFailMessage("Цвет настройки Histogram color. Decline не изменился на второй по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxGrowthThirdColorChosen()).withFailMessage("Цвет настройки Histogram color. Growth не изменился на третий по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxMinusDISecondColorChosen()).withFailMessage("Цвет настройки -DI Color не изменился на второй по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxPlusDIThirdColorChosen()).withFailMessage("Цвет настройки +DI Color не изменился на третий по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxSixthColorChosen()).withFailMessage("Цвет настройки ADX color не изменился на шестой по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Настройка Show histogram не изменилась на отключенную по умолчанию").isFalse();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Настройка Show ADX, DIs не изменилась на включенную по умолчанию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Настройка Shading не изменилась на включенную по умолчанию").isTrue();
    }

    @Test
    @AllureId("23678")
    @DisplayName("ADX. Изменение настроек. Видимость отключена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckInvisibleADXIndicatorSettings() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        step("Открыть селектор индикаторов.", () ->
                step("Открыт селектор индикаторов."));
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на иконку \"глаза\" у индикатора ADX", () ->
                step("Иконка изменилась на \"глаз перечеркнутый\""));
        indicatorsPanel.clickIndicatorVisibleButton();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isFalse();

        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не изменилась на отключенную").isFalse();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        step("Выбрать новое значение в поле MA Period ", () ->
                step("Новое значение введено"));
        indicatorsSettingsPanel.setADXMAPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));
        String maPeriod = indicatorsSettingsPanel.getADXMAPeriodText();

        step("Выбрать новое значение в поле Smoothing Period ", () ->
                step("Новое значение выбрано"));
        indicatorsSettingsPanel.setADXSmoothingPeriod(TestData.getRandomIndicatorShortPeriod().replaceAll("^0+", ""));
        String smoothingPeriod = indicatorsSettingsPanel.getADXSmoothingPeriodText();

        step("В разделе Histogram color.Decline прокрутить ленту цветов индикатора и выбрать первую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxDeclineFirstColor();

        step("В разделе Histogram color. Growth прокрутить ленту цветов индикатора и выбрать вторую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxGrowthSecondColor();

        step("В разделе -DI color прокрутить ленту цветов индикатора и выбрать третью с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxMinusDIThirdColor();

        step("В разделе +DI color прокрутить ленту цветов индикатора и выбрать четвертую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxPlusDIFourthColor();

        step("В разделе ADX color прокрутить ленту цветов индикатора и выбрать первую с левого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAdxFirstColor();

        step("Включить настройку Show histogram", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();

        step("Отключить настройку Show ADX, DIs", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();

        step("Отключить настройку Shading", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не отключена").isFalse();

        step("Проверить значения всех настроек", () ->
                step("Все настройки индикаторов имеют значения, выставленные на шагах 4-13"));
        indicatorsPanel.clickEditADX();

        soft.assertThat(indicatorsSettingsPanel.getADXMAPeriodText()).as("Установленный period не соответствует ожиданию").isEqualTo(maPeriod);
        soft.assertThat(indicatorsSettingsPanel.getADXSmoothingPeriodText()).as("Установленный smoothing period не соответствует ожиданию").isEqualTo(smoothingPeriod);
        soft.assertThat(indicatorsSettingsPanel.isAdxDeclineFirstColorChosen()).withFailMessage("Установленный Decline color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxGrowthSecondColorChosen()).withFailMessage("Установленный Growth color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxMinusDIThirdColorChosen()).withFailMessage("Установленный -DI color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxPlusDIFourthColorChosen()).withFailMessage("Установленный +DI color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxFirstColorChosen()).withFailMessage("Установленный ADX color не соответствует ожиданию").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).withFailMessage("Show histogram не включен").isTrue();
        soft.assertThat(indicatorsSettingsPanel.isAdxShowADXDIsSwitchChosen()).withFailMessage("Show ADX, DIs не отключен").isFalse();
        soft.assertThat(indicatorsSettingsPanel.isAdxShadingSwitchChosen()).withFailMessage("Shading не включен").isFalse();
    }

    @Test
    @AllureId("23679")
    @DisplayName("ADX. Состояние кнопки Apply. Видимость включена. Проверка в карточке")
    @Owner(Categories.MobileTeam.OLGA_HLYNOVA)
    @SDET(Categories.MobileTeam.ALENA_KHAYDARSHINA)
    @AutomationStatus(Categories.AutomationStatus.AUTOMATED_ANDROID_BETA)
    @Story1(Categories.JMobileTree.example)
    @Story2(Categories.JMobileTree.CHART)
    @Story3(Categories.JMobileTree.INDICATORS)
    @Story4(Categories.JMobileTree.INDICATOR_SETTINGS)
    @Priority(Categories.Priority.LOW)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SMOKE)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.POSITIVE_TEST)
    @Tag(Tags.exampleBrokerBeta.AdditionalTags.SCREEN)
    @Tag(Tags.exampleBrokerBeta.exampleApp.TRADEROOM)
    public void CheckVisibleADXIndicatorApplyButton() {
        step("[Precondition] Пользователь в трейдруме.\n" +
                "Включен индикатор ADX.\n" +
                "Селектор индикаторов открыт.\n" +
                "Индикатор ADX находится в разделе Active.\n" +
                "Видимость индикатора - по-умолчанию, то есть НЕ отключена (иконка \"глаз\" обычный).");
        TradingPage tradingPage = getTradingPageWithSignUp(UserData.getEmailNewUser(), UserData.getStandardUserPassword())
                .checkTradingPage()
                .selectBinaryZarOstAsset();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        indicatorsPanel.swipeDown();
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseADX();
        soft.assertThat(indicatorsSettingsPanel.getIndicatorSettingsHeaderText()).as("Название индикатора не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.ADX_INDICATOR_TITLE));
        indicatorsSettingsPanel.clickApplyButton();

        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.isADXIndicatorInActiveExists()).withFailMessage("ADX отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.getStatusIndicatorVisibleButton()).withFailMessage("Видимость индикатора не соответствует ожиданию").isTrue();

        step("Тапнуть на индикатор  ADX", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsPanel.clickEditADX();

        indicatorsSettingsPanel.swipeToBottom();

        step("Проверить состояние настройки Show histogram", () ->
                step("Настройка выключена"));
        soft.assertThat(indicatorsSettingsPanel.isAdxShowHistogramSwitchChosen()).as("Show histogram не отключен").isFalse();

        step("Отключить настройку Show ADX, DIs", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();

        step("Отключить настройку Shading", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка задизейблена"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply активна").isFalse();

        step("Включить настройку Show histogram", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка активна"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply задизейблена").isTrue();

        step("Выключить настройку Show histogram", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShowHistogramSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка задизейблена"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply активна").isFalse();

        step("Включить настройку Show ADX, DIs", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка активна"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply задизейблена").isTrue();

        step("Отключить настройку Show ADX, DIs", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShowADXDIsSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка задизейблена"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply активна").isFalse();

        step("Включить настройку Shading", () ->
                step("Настройка включена"));
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка активна"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply задизейблена").isTrue();

        step("Отключить настройку Shading", () ->
                step("Настройка отключена"));
        indicatorsSettingsPanel.clickAdxShadingSwitchSwitch();

        step("Проверить кнопку Apply", () ->
                step("Кнопка задизейблена"));
        soft.assertThat(indicatorsSettingsPanel.isApplyButtonEnabled()).withFailMessage("Кнопка Apply активна").isFalse();
    }
}

