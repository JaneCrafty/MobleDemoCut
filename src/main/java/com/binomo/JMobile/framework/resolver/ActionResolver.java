package com.example.JMobile.framework.resolver;

import com.example.JMobile.framework.DataProviders.Amounts;
import com.example.JMobile.framework.DataProviders.UserData;
import com.example.JMobile.framework.DataProviders.UserProfile;
import com.example.JMobile.framework.Enums.AppMessages;
import com.example.JMobile.framework.Enums.Indicator;
import com.example.JMobile.framework.Enums.MsgFactory;
import com.example.JMobile.framework.Enums.Titles;
import com.example.JMobile.framework.Helpers.AndroidActivitiesHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.SignInPageAndroid;
import com.example.JMobile.framework.POM.PagesAndroid.PanelsAndroid.*;
import com.example.JMobile.framework.Helpers.CountHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.*;
import com.example.JMobile.framework.POM.PagesVip.TradingPageVip;
import com.example.JMobile.framework.POM.PagesVip.WelcomePageVip;
import com.example.JMobile.framework.POMWeb.Webview.Pages.ChooseAmountScreenCardMC;
import com.example.JMobile.framework.POMWeb.Webview.Pages.CreditCardPages.PgwBinopayRedirectPage;
import com.example.JMobile.framework.POMWeb.Webview.Pages.SuccessPaymentFinish;
import com.example.JMobile.framework.driver.MobileDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class ActionResolver {

    private final WelcomePageVip welcomePageVip;
    private final SignInPageAndroid signInPageAndroid;
    private final SignUpPageAndroid signUpPageAndroid;
    private final CashierDepositPageAndroid cashierDepositPageAndroid;
    private final VipBottomSheetPanelAndroid vipBottomSheet;
    private final ChartTypePanelAndroid chartTypePanelAndroid;
    private final MobileDriver mobileDriver;
    private TradingPageVip tradingPageVip;
    private final IndicatorsPanelAndroid indicatorsPanelAndroid;
    private final IndicatorsSettingsPanelAndroid indicatorsSettingsPanelAndroid;

    private final AssetsPanelAndroid assetsPanelAndroid;
    private final TransactionHistoryPanelAndroid transactionHistoryPanelAndroid;
    private final HelpCenterPageAndroid helpCenterPageAndroid;

    private final ChooseAmountScreenCardMC chooseAmountScreenCardMC;
    private final SuccessPaymentFinish successPaymentFinish;
    private final TradingPageAndroid tradingPage;

    public void step(final String name, final Allure.ThrowableRunnableVoid runnable) {
        Allure.step(name, () -> {
            resolve(name);
            runnable.run();
            return null;
        });
    }

    public void step(final String name) {
        Allure.step(name, Status.PASSED);
        resolve(name);
    }


    public ActionResolver(MobileDriver mobileDriver, WelcomePageVip welcomePageVip) {
        this.mobileDriver = mobileDriver;
        this.welcomePageVip = welcomePageVip;
        this.signInPageAndroid = new SignInPageAndroid(mobileDriver);
        this.signUpPageAndroid = new SignUpPageAndroid(mobileDriver);
        this.indicatorsSettingsPanelAndroid = new IndicatorsSettingsPanelAndroid(mobileDriver);
        this.indicatorsPanelAndroid = new IndicatorsPanelAndroid(mobileDriver);
        this.cashierDepositPageAndroid = new CashierDepositPageAndroid(mobileDriver);
        this.vipBottomSheet = new VipBottomSheetPanelAndroid(mobileDriver);
        this.chartTypePanelAndroid = new ChartTypePanelAndroid(mobileDriver);
        this.assetsPanelAndroid = new AssetsPanelAndroid(mobileDriver);
        this.chooseAmountScreenCardMC = new ChooseAmountScreenCardMC(mobileDriver);
        this.successPaymentFinish = new SuccessPaymentFinish(mobileDriver);
        this.transactionHistoryPanelAndroid = new TransactionHistoryPanelAndroid(mobileDriver);
        this.helpCenterPageAndroid = new HelpCenterPageAndroid(mobileDriver);
        this.tradingPage = new TradingPageAndroid(mobileDriver);
    }

    public void loginWith(String email, String password) {
        this.tradingPageVip = loginAndDontCheckTradingPage(email, password);
        this.tradingPageVip.checkTradingPageVip();
    }

    public TradingPageVip loginAndDontCheckTradingPage(String email, String password) {
        return this.welcomePageVip
                .step("Тап кнопка Log in ")
                .clickLoginButtonVip()
                .step("Заполнить поля Email и Password валидными данными")
                .fillEmailVip(email)
                .fillPasswordVip(password)
                .step("Тап кнопка Log in")
                .clickLoginButtonVip();
    }

    public void loginWith(UserProfile user) {
        loginWith(user.getEmail(), user.getPassword());
    }

    public void signup() {
        signupWith(UserData.getEmailNewUser(), UserData.getStandardUserPassword());
    }

    public void signupWith(UserProfile userProfile) {
        signupWith(userProfile.getEmail(), userProfile.getPassword());
    }

    public void signupWith(String email, String password) {
        this.tradingPageVip = this.welcomePageVip
                .step("Тап кнопка Sign up")
                .clickSignupButtonVip()
                .step("Заполнить поля Email и Password валидными данными")
                .fillEmailVip(email)
                .fillPasswordVip(password)
                .step("Тап кнопка Log in")
                .clickLoginButtonVip()
                .checkTradingPageVip();
    }

    public void resolve(String name) {
        switch (name) {
            case "Нажать на кнопку Log in":
                welcomePageVip.clickLoginButtonVip();
                break;
            case "Нажать на кнопку Sign up":
                welcomePageVip.clickSignupButtonVip();
                break;
            case "Открыт экран регистрации":
                signUpPageAndroid.checkSignUpPage();
                break;
            case "Открыт экран логина":
                signInPageAndroid.checkSignInPage();
                break;
            case "Открылись Welcome stories":
            case "После загрузки открыт экран с Welcome stories":
                welcomePageVip.checkWelcomePageVip();
                break;
            case "При загрузке на сплэш скрине отображается текст Hello, [имя пользователя]":
                welcomePageVip.checkWelcomeMessageText("Hello, " + "Autotest");
                break;
            case "При загрузке на сплеш скрине не отображается приветствие":
                welcomePageVip.checkWelcomeMessageAbsent();
                break;
            case "Переключиться на FTT ассет ZAR/OST":
            case "Перейти на FTT механику":
                tradingPageVip.selectFttZarOstAsset();
                if (tradingPageVip.checkHallOfFameIsPresent()) {
                    tradingPageVip.closeHallOfFame();
                }
                break;
            case "Переключиться на CFD ассет ZAR/OST":
                tradingPageVip.selectCFDZarOstAsset();
                break;
            case "Переключиться на 5ST ассет ZAR/OST":
                tradingPageVip.select5stZarOstAsset();
                if (tradingPageVip.checkHallOfFameIsPresent()) {
                    tradingPageVip.closeHallOfFame();
                }
                break;
            case "Открыть селектор ассетов":
            case "Нажать на кнопку + у таба ассета":
            case "В трейдруме нажать на кнопку + у таба ассетов":
                tradingPageVip.clickAssetsButton();
                break;
            case "Закрыть селектор ассетов":
                assetsPanelAndroid.clickClosePanelButton();
                break;
            case "Открыт селектор ассетов, вкладка FTT":
                assetsPanelAndroid.isAssetsListOpen();
                assetsPanelAndroid.clickFttTab();
                break;
            case "Открыт таб Сделки":
                transactionHistoryPanelAndroid.checkTransactionHistoryPanel();
            case "Открыт селектор ассетов, вкладка 5st":
                assetsPanelAndroid.isAssetsListOpen();
                assetsPanelAndroid.click5stTab();
                break;
            case "Открыт селектор ассетов, вкладка CFD:\n":
                assetsPanelAndroid.isAssetsListOpen();
                assetsPanelAndroid.clickCfdTab();
                break;
            case "Выбрать ассет отличный от выбранного":
                assetsPanelAndroid.selectEurUsdAsset();
                if (tradingPageVip.checkHallOfFameIsPresent()) {
                    tradingPageVip.closeHallOfFame();
                }
                break;
            case "Выбрать ассет отличный от выбранных":
            case "Выбрать FTT ассет":
                assetsPanelAndroid.selectLevOneAsset();
                if (tradingPageVip.checkHallOfFameIsPresent()) {
                    tradingPageVip.closeHallOfFame();
                }
                break;
            case "Выбрать CFD ассет":
                assetsPanelAndroid.selectCFDEurUsdAsset();
                break;
            case "Открылся боттомшит с заголовком Assets и с информацией о невозможности добавления более 3 табов":
            case "Открылся боттомшит с заголовком Assets":
                tradingPageVip.swipeLeftToAddAssetButton();
                tradingPageVip.clickAssetsButton();
                vipBottomSheet.checkVipBottomSheet();
                vipBottomSheet.checkTitleIsEqualTo("ASSETS");
                vipBottomSheet.checkTitleLabelIsEqualTo("You can use only 3 assets at a time");
                break;
            case "Проверить наличие элементов в боттомшите:\n" +
                    "иконка со знаком '+'\n" +
                    "текст You can use only 3 assets at a time.Please remove the old assets and then choose the new ones instead\n" +
                    "кнопка Закрыть(х)":
                vipBottomSheet.checkAssetTabsRestrictIconIsDisplayed();
                vipBottomSheet.checkRestrictionDescriptionLabelIsEqualTo(MsgFactory.getMessage(AppMessages.REMOVE_OLD_ASSETS_DESCRIPTION));
                vipBottomSheet.checkCloseButtonIsDisplayed();
                break;
            case "На график добавлено три таба с ассетами":
                tradingPageVip.selectCFDZarOstAsset();
                tradingPageVip.clickAssetsButton();
                assetsPanelAndroid.selectCFDEurUsdAsset();
                tradingPageVip.clickAssetsButton();
                assetsPanelAndroid.clickFttTab();
                assetsPanelAndroid.selectBinaryZarOstAsset();
                if (tradingPageVip.checkHallOfFameIsPresent()) {
                    tradingPageVip.closeHallOfFame();
                }
                break;
            case "Выбрать турнирный счет":
                tradingPageVip.chooseTournamentAccountVip();
                break;
            case "Выбрать реальный счет":
            case "Находясь на FTT ассете перейти на реальный счет":
                tradingPageVip.chooseRealAccountVip();
                break;
            case "Проверить наличие элементов:\n" +
                    "текст CFD trading is available only on a demo account\n" +
                    "иконка актива\n" +
                    "название актива\n" +
                    "внизу карточки отображается блок Will be available":
                assertThat(assetsPanelAndroid.getCfdAvailableOnDemoText())
                        .isEqualTo(MsgFactory.getMessage(AppMessages.CFD_AVAILABLE_ON_DEMO_TEXT));
                break;
            case "иконка актива":
                assetsPanelAndroid.isFirstAssetIconElementExists();
                break;
            case "Таб с CFD ассетом зачеркнут":
                assetsPanelAndroid.isCfdAssetTabLocked();
                break;
            case "название актива":
                assetsPanelAndroid.isFirstAssetNameElementExists();
                break;
            case "внизу карточки отображается блок Will be available":
                assetsPanelAndroid.isWillBeAvailableExists();
                break;
            case "Timeframe: 1sec":
                assertThat(tradingPageVip.getChartTimeframeVipText()).isEqualTo("1s");
                break;
            case "Timeframe: 5sec":
                assertThat(tradingPageVip.getChartTimeframeVipText()).isEqualTo("5s");
                break;
            case "Chart Type: Свечи":
                tradingPageVip.clickChartTypeVipButton();
                assertThat(chartTypePanelAndroid.getChartTypeCandles().isSelected())
                        .withFailMessage("Тип графика Свечи неактивен")
                        .isTrue();
                chartTypePanelAndroid.getChartTypeCandles().isSelected();
                break;
            case "Chart Type: Гора":
                tradingPageVip.clickChartTypeVipButton();
                assertThat(chartTypePanelAndroid.getChartTypeMountain().isSelected())
                        .withFailMessage("Тип графика Гора неактивен")
                        .isTrue();
                break;
            case "Открыть селектор индикаторов":
            case "Открыть селектор индикаторов на вкладке Available":
                tradingPageVip.clickIndicatorsButtonVip();
                break;
            case "Открыт селектор индикаторов":
            case "Открыт селектор индикаторов на вкладке Available":
                tradingPageVip.checkIndicatorsPanelVip();
                break;
            case "Отключить видимость индикатора кнопкой с иконкой глаза":
                indicatorsPanelAndroid.clickIndicatorVisibleButton();
                break;
            case "Закрыть селектор индикаторов":
                indicatorsPanelAndroid.clickCloseButton();
                break;
            case "Нажать на иконку индикатора Scalp Pro":
            case "Нажать на иконку индикатора Scalp pro":
            case "Открыть карточку настроек индикатора Scalp pro":
                indicatorsPanelAndroid.chooseIndicatorByName(Indicator.ScalpPro);
                break;
            case "Снова открыть карточку настроек индикатора Scalp pro":
                indicatorsPanelAndroid.clickEditFirstIndicator();
                break;
            case "Открыта карточка настроек индикатора Scalp pro":
            case "Открыта карточка настроек Scalp Pro":
            case "Карточка настроек индикатора Scalp pro открыта":
                indicatorsSettingsPanelAndroid.checkSettingsPanelHeader(Indicator.ScalpPro);
                break;
            case "Нажать на кнопку Apply":
            case "Тап кнопка Apply":
                indicatorsSettingsPanelAndroid.clickApplyButton();
                break;
            case "Карточка настроек индикатора Scalp pro закрыта":
            case "Карточка настроек индикатора Scalp pro не открылась":
                tradingPageVip.checkIndicatorsPanelVipIsAbsent();
                break;
            case "Пользователь в трейдруме":
                tradingPageVip.checkTradingPageVip();
                break;
            case "Открыть боттомшит Callback":
            case "Нажать на Callback в трейдруме":
            case "Снова нажать на иконку Callback в трейдруме":
                tradingPageVip.clickCallbackButton();
                break;
            case "Открыт боттомшит Callback с текстом \"The request is successfully sent\"":
                vipBottomSheet.checkVipBottomSheet();
                vipBottomSheet.checkSubtitleIsEqualTo("The request is successfully sent");
                break;
            case "Проверить наличие элементов на боттомшите:\n" +
                    "Заголовок: Callback\n" +
                    "Кнопка: Закрыть(х)\n" +
                    "Текст: \"The request is successfully sent\"\n" +
                    "Текст: Personal manager will call you soon!":
                vipBottomSheet.checkVipBottomSheet();
                vipBottomSheet.checkIconIsDisplayed();
                vipBottomSheet.checkTitleIsEqualTo("CALLBACK");
                vipBottomSheet.checkSubtitleIsEqualTo("The request is successfully sent");
                vipBottomSheet.checkDescriptionIsEqualTo("Personal manager will call you soon!");
                vipBottomSheet.checkCloseButtonIsDisplayed();
                break;
            case "Проверить наличие элементов списка ассетов, вкладка FTT:\n" +
                    "иконка актива\n" +
                    "название актива\n" +
                    "процент доходности Profit\n" +
                    "процент доходности For VIP\n" +
                    "кнопка добавления в избранное\n" +
                    "внизу карточки отображается блок Will be available":
                assetsPanelAndroid.isFirstAssetIconElementExists();
                assetsPanelAndroid.isFirstAssetNameElementExists();
                assetsPanelAndroid.isFirstAssetRateBinaryElementExists();
                assetsPanelAndroid.isFirstAssetRateTurboElementExists();
                assetsPanelAndroid.isFirstAssetAddFavouriteElementExists();
                assetsPanelAndroid.isWillBeAvailableExists();
                break;
            case "Пролистать список ассетов вниз до блока  Will be available":
                assetsPanelAndroid.isWillBeAvailableExists();
                break;
            case "Проверить наличие элементов в блоке Will be available, вкладка FTT:\n" +
                    "текст Will be available at[time], где[time]время включения доступности актива для торговли\n" +
                    "иконка актива\n" +
                    "наименование актива\n" +
                    "доходность Profite\n" +
                    "доходность for VIP\n" +
                    "иконка добавления в избранное\n" +
                    "Все элементы блока Will be available серого цвета":
                assetsPanelAndroid.checkWillBeAvailableTitle(MsgFactory.getMessage(AppMessages.WILL_BE_AVAILABLE_TITLE));
                break;
            case "Проверить наличие элементов в блоке Will be available, вкладка CFD:\n" +
                    "текст Will be available at[time], где[time]время включения доступности актива для торговли\n" +
                    "иконка актива\n" +
                    "наименование актива\n" +
                    "Все элементы блока Will be available серого цвета":
                assetsPanelAndroid.checkWillBeAvailableTitle(MsgFactory.getMessage(AppMessages.WILL_BE_AVAILABLE_TITLE));
                break;
            case "Тапнуть на актив в блоке Will be available\n":
                assetsPanelAndroid.clickOnWillBeAvailableFirstAsset();
                break;
            case "Ничего не произошло после тапа на актив в блоке Will be available":
                assetsPanelAndroid.checkAssetsPanelIsDisplayed();
                break;
            case "Проверить наличие элементов списка ассетов, вкладка 5st:\n" +
                    "иконка актива\n" +
                    "название актива\n" +
                    "процент доходности Profit\n" +
                    "процент доходности For VIP\n" +
                    "кнопка добавления в избранное\n":
                assetsPanelAndroid.isFirstAssetIconElementExists();
                assetsPanelAndroid.isFirstAssetNameElementExists();
                assetsPanelAndroid.isFirstAssetRateBinaryElementExists();
                assetsPanelAndroid.isFirstAssetRateTurboElementExists();
                assetsPanelAndroid.isFirstAssetAddFavouriteElementExists();
                break;
            case "Проверить наличие элементов, вкладка CFD:\n " +
                    "иконка актива\n" +
                    "название актива\n" +
                    "внизу карточки отображается блок Will be available":
                assetsPanelAndroid.isFirstAssetIconElementExists();
                assetsPanelAndroid.isFirstAssetNameElementExists();
                assetsPanelAndroid.isWillBeAvailableExists();
                break;
            case "На табе ассета отсутствует кнопка Закрыть(х)":
                assetsPanelAndroid.isCloseAssetButtonAbsent();
                break;
            case "Нажать на кнопку Change a phone number":
                vipBottomSheet.clickChangeNumberButton();
                break;
            case "Нажать на кнопку Request a Callback":
                vipBottomSheet.clickRequestCallbackButton();
                break;
            case "Под кнопкой появляется ошибка с текстом An error occurred. Please try once again":
                String actualMessage = vipBottomSheet.getErrorMessage();
                assertThat(actualMessage).isEqualTo("An error occurred. Please try once again");
                break;
            case "Нажать на кнопку Add number":
                vipBottomSheet.clickAddNumberButton();
                break;
            case "Произошел переход в профиль на веб версии":
            case "Произошел переход на веб платформу в браузере":
                AndroidActivitiesHelper activitiesHelper = new AndroidActivitiesHelper();
                mobileDriver.getDriverWait()
                        .withTimeout(Duration.ofSeconds(30))
                        .withMessage("Не произошел переход в хром")
                        .until(d -> activitiesHelper.getCurrentActivityString(mobileDriver)
                                .equals("org.chromium.chrome.browser.ChromeTabbedActivity"));
                break;
            case "Под графиком отображается индикатор Scalp pro":
                tradingPageVip.checkScalpProIndicatorIsPresent();
                break;
            case "Открылся пэйвол Take a step to get VIP privileges":
            case "Открылся пейвол Take a step to get VIP privileges":
                tradingPageVip.checkVipPaywallIsDisplayed();
                tradingPageVip.checkVipPaywallTitle("Take a step to get VIP privileges");
                break;
            case "Открыт пейволл. \n" +
                    "Проверить отображение элементов: \n" +
                    "Кнопка закрытие пейволла(х) \n" +
                    "Take a step to get VIP privileges \n" +
                    "Personal manager support \n" +
                    "Scalp Pro exclusive indicator \n" +
                    "Trading up to 3 assets at a time \n" +
                    "Кнопка: Deposit[S1000] * more. \n" +
                    "Кнопка:Already paid \n" +
                    "Кнопка: Go to main app \n" +
                    "*сумма которой не хватает пользователю до статуса вип":
                vipBottomSheet.checkCloseButtonIsDisplayed();
                tradingPageVip.checkVipPaywallTitle("Take a step to get VIP privileges");
                vipBottomSheet.checkVipPaywallDescriptionIsEqualTo(MsgFactory.getMessage(AppMessages.PAYWALL_DESCRIPTION_TEXT));
                vipBottomSheet.isDepositButtonExists();
                vipBottomSheet.isAlreadyPaidButtonExists();
                vipBottomSheet.isGoToMainAppButtonExists();
                break;
            case "Открылся пейвол Now you can start real trading in the basic app":
                tradingPageVip.checkVipPaywallSheetIsDisplayed();
                tradingPageVip.checkVipPaywallSheetTitle("Now you can start real trading in the basic app. What’s next?");
                break;
            case "Боттомшит Callback закрылся":
                vipBottomSheet.checkVipBottomSheetIsAbsent();
                break;
            case "В трейдруме появился тост с текстом \"The callback request is sent\"":
                assertThat(tradingPageVip.checkInfoPopupExists())
                        .withFailMessage("В трейдруме не появился тост с текстом \"The callback request is sent\"")
                        .isTrue();
                assertThat(tradingPageVip.getInfoPopupText())
                        .isEqualTo("The callback request is sent");
                break;
            case "В трейдруме пропал график, на его месте появилась заглушка CFD is unavailable":
                tradingPageVip.checkCfdUnavailablePlaceholderIsDisplayed();
                break;
            case "Нажать на кнопку Switch to demo account на заглушке":
                tradingPageVip.clickSwitchToDemoAccountButton();
                break;
            case "Открыт ботомшит":
            case "Боттомшит открыт":
                vipBottomSheet.checkVipBottomSheet();
                break;
            case "Нажать на кнопку Закрыть (х) на боттомшите":
                vipBottomSheet.clickClosePanelButton();
                break;
            case "Боттомшит закрылся, пользователь находится в трейдруме":
                vipBottomSheet.checkVipBottomSheetIsAbsent();
                tradingPageVip.checkTradingPageVip();
                break;
            case "Проверить наличие элементов на боттомшите:\n" +
                    "Заголовок: Callback\n" +
                    "Иконка: наушники\n" +
                    "Текст: \"Callback is at your service!\n" +
                    "Need to ask a question or get an advice? We will call your number (+номер телефона пользователя) as soon possible\"\n" +
                    "Кнопка: Request a Callback\n" +
                    "Кнопка: Change a phone number":
                vipBottomSheet.checkVipBottomSheet();
                vipBottomSheet.checkIconIsDisplayed();
                vipBottomSheet.checkTitleIsEqualTo("CALLBACK");
                vipBottomSheet.checkSubtitleIsEqualTo("Callback is at your service!");
                vipBottomSheet.checkDescriptionIsEqualTo("Need to ask a question or get an advice? We will call your number +79210000000 as soon as possible");
                vipBottomSheet.checkRequestCallbackButtonIsDisplayed();
                vipBottomSheet.checkChangeNumberButtonIsPresent();

                break;
            case "Проверить наполнение:\n" +
                    "Заголовок: Callback\n" +
                    "Иконка: наушники\n" +
                    "Текст: We dont have your number\n" +
                    "You can add phone number to your example VIP " +
                    "Beta profile via web browser. Once you add it, " +
                    "restart the app and request a callback from your manager\n" +
                    "Кнопка: add number":
                vipBottomSheet.checkVipBottomSheet();
                vipBottomSheet.checkIconIsDisplayed();
                vipBottomSheet.checkTitleIsEqualTo("CALLBACK");
                vipBottomSheet.checkSubtitleIsEqualTo("We don’t have your number");
                vipBottomSheet.checkDescriptionIsEqualTo("You can add phone number to your example VIP Beta profile via web browser. Once you add it, restart the app and request a callback from your manager");
                vipBottomSheet.checkAddButtonIsDisplayed();
                break;
            case "Открылся боттомшит с кнопкой Add number":
                vipBottomSheet.checkAddButtonIsDisplayed();
                break;
            case "Тап колесико Scalp Pro":
                tradingPageVip.clickScalpProSettings();
                break;
            case "Изменить настройки Fast line":
                indicatorsSettingsPanelAndroid.changeFastLineTo(15);
                break;
            case "Изменить настройки Slow line":
                indicatorsSettingsPanelAndroid.changeSlowLineTo(20);
                break;
            case "Изменить настройки Smoothness":
                indicatorsSettingsPanelAndroid.changeSmoothnessTo(25);
                break;
            case "Проверить отображение новых настроек в карточке":
                assertThat(indicatorsSettingsPanelAndroid.getFastLine())
                        .withFailMessage("Для Fast Line ожидали 15, получили " + indicatorsSettingsPanelAndroid.getFastLine())
                        .isEqualTo(15);
                assertThat(indicatorsSettingsPanelAndroid.getSlowLine())
                        .withFailMessage("Для Slow Line ожидали 20, получили " + indicatorsSettingsPanelAndroid.getSlowLine())
                        .isEqualTo(20);
                assertThat(indicatorsSettingsPanelAndroid.getSmoothness())
                        .withFailMessage("Для Smoothness ожидали 25, получили " + indicatorsSettingsPanelAndroid.getSmoothness())
                        .isEqualTo(25);
                break;
            case "Тап кнопка Deposit на пейволле":
                tradingPageVip.clickPaywallDepositButton();
                break;
            case "открыта касса":
                cashierDepositPageAndroid.checkCashierDepositPage();
                break;
            case "Отображается только 2 Welcome stories:" +
                    "Welcome to our VIP app!\n" +
                    "Several assets at a time - for VIP only\n":
                Set<String> stories = new HashSet<>();
                stories.add("Several assets at a time — for VIP only");
                stories.add("Welcome to our VIP app!");
                welcomePageVip.checkWelcomeStories(stories);
            case "Нажать кнопку Пополнить счет":
                tradingPageVip.clickVipDepositButton();
                break;
            case "Открылась страница кассы Депозит\n" +
                    "Присутствует заголовок Choose Payment Method\n" +
                    "Присутствует метод оплаты Visa/Master Card/Maestro\n" +
                    "С открытием кассы API отправляет параметр advertising_id.":
                cashierDepositPageAndroid.checkCashierDepositPage();
                cashierDepositPageAndroid.checkDepositCashierPageTitle();
                assertThat(cashierDepositPageAndroid.checkPaymentMethodMessageExists()).isTrue();
                cashierDepositPageAndroid.checkVisaMcMaestroMethodExists();
                cashierDepositPageAndroid.checkPaymentMethodMessageExists();
                assertThat(cashierDepositPageAndroid.getPaymentMethodMessageTitle()).isEqualTo(MsgFactory.getMessage(Titles.CHOOSE_PAYMENT_METHOD_TITLE));
                break;
            case "Выбрать метод оплаты Visa/Master Card/Maestro\n":
                cashierDepositPageAndroid.clickVisaMcMaestroMethod();
                break;
            case "Выполнить депозит на 100":
                cashierDepositPageAndroid.clickVisaMcMaestroMethod();
                assertThat(chooseAmountScreenCardMC.getChooseAmountMessageTitle()).isEqualTo(MsgFactory.getMessage(Titles.CHOOSE_AMOUNT_TITLE));
                chooseAmountScreenCardMC.getAmountItem().setDepositAmount(Amounts.getAmount100());
                chooseAmountScreenCardMC.getAmountItem().selectWithoutBonusRadioButton();

                PgwBinopayRedirectPage pgwBinopayRedirectPage = chooseAmountScreenCardMC.clickDepositButtonWithBinopay();
                pgwBinopayRedirectPage.successfulDeposit();
                break;
            case "Открыт экран информации о депозите\n" +
                    "На счет пользователя зачислено 100 USD\n" +
                    "В трейдруме появился поп-ап Баланс пополнен успешно":
                successPaymentFinish.clickStartTradingButton();
                tradingPageVip.checkTradingPageVip();
                break;
            case "Открыть таб Сделки":
                tradingPageVip.clickDealsTab();
                break;
            case "Нажать на ссылку Try this guide":
                transactionHistoryPanelAndroid.clickTryThisGuideLink();
                break;
                case "Произошел переход в Help Center, открылась статья Concluding trades":
                helpCenterPageAndroid.checkHelpCenterPage();
                helpCenterPageAndroid.isConcludingTradesArticleExists();
                break;
            case "Нажать на кнопку Закрыть (х)":
                helpCenterPageAndroid.clickCloseButton();
                break;
            case "Нажать на кнопку создания сделки на понижение.\n":
                tradingPage.createDeal(false);
                break;
            case "С баланса демо-счета списалась сумма инвестиции":
            case "С баланса реального счета списалась сумма инвестиции":
                BigDecimal balanceAfter = CountHelper.AccountBalance(tradingPage.getAccountBalanceValueText());
                assertThat(balanceAfter.intValue() < 1000).withFailMessage("Wrong test conditions. Demo balance is full").isTrue();
                break;
            case "Проверить плашку Инвестиция / Доход на нижней панели трейдрума":
                assertThat(tradingPage.isOngoingDealExists()).withFailMessage("Инвестиционная панель не отобразилась").isTrue();
                break;
            case "Выбран демо-счет\n":
                tradingPage.chooseDemoAccount();
                break;
            case "Проверить какие Welcome stories отображаются":
            case "Запустить приложение":
            case "Приложение запущено":
            case "Проверить настройки по дефолту":
                // empty on purpose, only for allure step
                break;
            case "Проверить наличие элементов:":
                // empty on purpose, only allure step
                break;
            default:
                throw new RuntimeException("Unknown action: " + name);
        }


    }
}
