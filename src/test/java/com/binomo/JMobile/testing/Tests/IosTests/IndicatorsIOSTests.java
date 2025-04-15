package com.example.JMobile.testing.Tests.IosTests;

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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class IndicatorsIOSTests extends Watcher {

    @Test
    @AllureId("4030")
    @DisplayName("Moving Average. Изменение настроек. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_IOS_BETA),
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

        TradingPage tradingPage = getWelcomePage().signInToBinaryTradeRoom(UserData.getAutotestUser1Email(), UserData.getAutotestUser1Password());
        tradingPage.checkTradingPage();

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
        String indicatorPeriodNewValue = indicatorsSettingsPanel.getMovingAverageIndicatorPeriodText();

        step("Прокрутить ленту цветов индикатора и выбрать последнюю иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение.\n" +
                        "(для автотеста: у локатора элемента иконки аттрибут checked стал true)"));
        indicatorsSettingsPanel.chooseMovingAverageFirstColor();

        step("Нажать на кнопку Apply", () ->
                step("Карточка настроек закрылась."));
        indicatorsSettingsPanel.clickApplyButton();

        step("Снова открыть карточку настроек индикаторов.\n" +
                "Открыть настройки добавленного Moving Average, в который вносили изменения.\n" +
                "Проверить настройки Period и цвета.");
        tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel.clickActiveIndicatorsItem();

        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveExists()).withFailMessage("Moving average отсутствует в списке активных индикаторов").isTrue();

        indicatorsPanel.clickEditMovingAverage();

        step("Значение Period совпадает со значением с шага 2.\n" +
                "Выбранная иконка цвета совпадает с иконкой, выбранной на шаге 3.\n" +
                "(для автотеста: выбранный на шаге 3 элемент сохранил аттрибут checked=true)");
        soft.assertThat(indicatorPeriodNewValue).as("Установленный period не соответствует ожиданию").isEqualTo(indicatorsSettingsPanel.getMovingAverageIndicatorPeriodText());
        soft.assertThat(indicatorsSettingsPanel.isMovingAverageFirstColorChosen()).withFailMessage("Установленный цвет не соответствует ожиданию").isTrue();

    }

    @Test
    @AllureId("4032")
    @DisplayName("Alligator. Изменение настроек. Проверка в карточке")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_IOS_BETA),
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

        TradingPage tradingPage = getWelcomePage().signIn(UserData.getAutotestUser1Email(), UserData.getAutotestUser1Password());
        tradingPage.checkTradingPage();

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на индикатор Alligator", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseAlligator();

        step("В разделе Jaws ввести новые значения в поля Period и Offset с клавиатуры", () ->
                step("Новые значения введены"));
        indicatorsSettingsPanel.setAlligatorJawsOffset(randomIndicatorPeriod);
        indicatorsSettingsPanel.setAlligatorJawsPeriod(randomIndicatorPeriod);

        String indicatorJawsPeriodNewValue = indicatorsSettingsPanel.getAlligatorJawsPeriodText();
        String indicatorJawsOffsetNewValue = indicatorsSettingsPanel.getAlligatorJawsOffsetText();

        step("В разделе Jaws прокрутить ленту цветов индикатора и выбрать последнюю иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAlligatorJawsThirdColor();

        step("В разделе Teeth ввести новые значения в поля Period и Offset с клавиатуры", () ->
                step("Новые значения введены"));
        indicatorsSettingsPanel.setAlligatorTeethOffset(randomIndicatorPeriod);
        indicatorsSettingsPanel.setAlligatorTeethPeriod(randomIndicatorPeriod);

        String indicatorTeethPeriodNewValue = indicatorsSettingsPanel.getAlligatorTeethPeriodText();
        String indicatorTeethOffsetNewValue = indicatorsSettingsPanel.getAlligatorTeethOffsetText();

        step("В разделе Teeth прокрутить ленту цветов индикатора и выбрать предпоследнюю иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAlligatorTeethFirstColor();

        step("В разделе Lips ввести новые значения в поля Period и Offset с клавиатуры", () ->
                step("Новые значения введены"));
        indicatorsSettingsPanel.setAlligatorLipsOffset(randomIndicatorPeriod);
        indicatorsSettingsPanel.setAlligatorLipsPeriod(randomIndicatorPeriod);

        String indicatorLipsPeriodNewValue = indicatorsSettingsPanel.getAlligatorLipsPeriodText();
        String indicatorLipsOffsetNewValue = indicatorsSettingsPanel.getAlligatorLipsOffsetText();

        step("В разделе Lips прокрутить ленту цветов индикатора и выбрать третью от правого края иконку цвета в ленте тапом по иконке.", () ->
                step("Иконка цвета поменяла свое отображение."));
        indicatorsSettingsPanel.chooseAlligatorLipsSecondColor();

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
        soft.assertThat(indicatorsSettingsPanel.getAlligatorTeethPeriodText()).as("Установленный Teeth period не соответствует ожиданию").isEqualTo(indicatorTeethPeriodNewValue);
        soft.assertThat(indicatorsSettingsPanel.getAlligatorTeethOffsetText()).as("Установленный Teeth offset не соответствует ожиданию").isEqualTo(indicatorTeethOffsetNewValue);
        soft.assertThat(indicatorsSettingsPanel.isAlligatorTeethFirstColorChosen()).withFailMessage("Установленный teeth color не соответствует ожиданию").isTrue();

        indicatorsSettingsPanel.swipeDown();
        soft.assertThat(indicatorsSettingsPanel.getAlligatorLipsPeriodText()).as("Установленный Lips period не соответствует ожиданию").isEqualTo(indicatorLipsPeriodNewValue);
        soft.assertThat(indicatorsSettingsPanel.getAlligatorLipsOffsetText()).as("Установленный Lips offset не соответствует ожиданию").isEqualTo(indicatorLipsOffsetNewValue);
        soft.assertThat(indicatorsSettingsPanel.isAlligatorLipsSecondColorChosen()).withFailMessage("Установленный lips color не соответствует ожиданию").isTrue();
    }

    @Test
    @AllureId("4010")
    @DisplayName("Добавление индикаторов")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_IOS_BETA),
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

        TradingPage tradingPage = getWelcomePage().signIn(UserData.getAutotestUser1Email(), UserData.getAutotestUser1Password())
                .checkTradingPage();
//add compare of screenshots

        IndicatorsPanel indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        soft.assertThat(indicatorsPanel.getIndicatorsMenuHeaderText()).as("Заголовок панели индикаторов не соответствует ожиданию").isEqualTo(MsgFactory.getMessage(Titles.INDICATORS_CONTAINER_TITLE));

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        IndicatorsSettingsPanel indicatorsSettingsPanel = indicatorsPanel.chooseMovingAverage();

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseAlligator();

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseBollinger();

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseRSI();

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseMACD();

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Тапнуть на выбранный индикатор", () ->
                step("Контент в карточке меняется на настройки индикатора"));
        indicatorsSettingsPanel = indicatorsPanel.chooseATR();

        step("Нажать на кнопку Apply", () ->
                step("Карточка закрывается, индикатор появляется в наборе \"Active\" и на графике"));
        tradingPage = indicatorsSettingsPanel.clickApplyButton();
        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();

        step("Индикаторы отображаются на графике, добавлены в активный набор, доступный набор - не меняется");
        indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveExists()).withFailMessage("Alligator отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveExists()).withFailMessage("Moving average отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveExists()).withFailMessage("Bollinger отсутствует в списке активных индикаторов").isTrue();
        indicatorsPanel.swipeDown();
        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveExists()).withFailMessage("RSI отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveExists()).withFailMessage("MACD отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveExists()).withFailMessage("ATR отсутствует в списке активных индикаторов").isTrue();
    }

    @Test
    @AllureId("4011")
    @DisplayName("Удаление индикаторов")
    @Owner(Categories.MobileTeam.NADEZHDA_POROTKOVA)
    @SDET(Categories.MobileTeam.EVGENIYA_BASOVA)
    @AutomationStatuses({
            @AutomationStatus(Categories.AutomationStatus.AUTOMATED_IOS_BETA),
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

        TradingPage tradingPage = getWelcomePage().signIn(UserData.getAutotestUser1Email(), UserData.getAutotestUser1Password())
                .checkTradingPage();
//add compare of screenshots

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

        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveExists()).withFailMessage("Alligator отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveExists()).withFailMessage("Bollinger отсутствует в списке активных индикаторов").isTrue();
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

        step("Все индикаторы удалены с графика, набор активных индикаторов пуст, доступных - не изменился");
        soft.assertThat(indicatorsPanel.isMovingAverageIndicatorInActiveMissing()).withFailMessage("Moving average присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isAlligatorIndicatorInActiveMissing()).withFailMessage("Alligator присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isBollingerIndicatorInActiveMissing()).withFailMessage("Bollinger присутствует в списке активных индикаторов").isTrue();

        tradingPage.clickDashClosePanel();
        tradingPage.screenForIndicatorsVerification();

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
        indicatorsSettingsPanel = indicatorsPanel.chooseATR();
        tradingPage = indicatorsSettingsPanel.clickApplyButton();

        tradingPage.screenForIndicatorsVerification();

        indicatorsPanel = tradingPage.clickIndicatorsButton()
                .checkIndicatorsPanel();
        indicatorsPanel = indicatorsPanel.clickActiveIndicatorsItem();
        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveExists()).withFailMessage("RSI отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveExists()).withFailMessage("MACD отсутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveExists()).withFailMessage("ATR отсутствует в списке активных индикаторов").isTrue();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveRSIIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveMACDIndicator();

        step("Нажать на кнопку удаления индикатора", () ->
                step("Выбранный индикатор удалился из набора \"Active\" и с графика"));
        indicatorsPanel.clickRemoveATR();

        step("Все индикаторы удалены с графика, набор активных индикаторов пуст, доступных - не изменился");
        soft.assertThat(indicatorsPanel.isRSIIndicatorInActiveMissing()).withFailMessage("RSI average присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isMACDIndicatorInActiveMissing()).withFailMessage("MACD присутствует в списке активных индикаторов").isTrue();
        soft.assertThat(indicatorsPanel.isATRIndicatorInActiveMissing()).withFailMessage("ATR присутствует в списке активных индикаторов").isTrue();

        tradingPage.clickDashClosePanel();
        tradingPage.screenForIndicatorsVerification();
    }

}

