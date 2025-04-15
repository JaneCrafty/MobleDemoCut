package com.example.JMobile.framework.POM.PagesVip;

import com.example.JMobile.framework.POM.PagesAndroid.PanelsAndroid.IndicatorsPanelAndroid;

public interface TradingPageVip {
    TradingPageVip checkTradingPageVip();

    TradingPageVip step(String stepName);

    TradingPageVip clickIndicatorsButtonVip();

    IndicatorsPanelAndroid checkIndicatorsPanelVip();

    TradingPageVip checkIndicatorsPanelVipIsAbsent();

    TradingPageVip checkScalpProIndicatorIsPresent();

    void checkVipPaywallIsDisplayed();

    void checkVipPaywallTitle(String title);

    void clickScalpProSettings();

    void clickPaywallDepositButton();

    void clickCallbackButton();

    void chooseRealAccountVip();

    void checkVipPaywallSheetIsDisplayed();

    void checkVipBottomSheetIsDisplayed();

    void checkVipPaywallSheetTitle(String title);

    void selectFttZarOstAsset();

    void selectEurUsdAsset();

    void closeHallOfFame();

    boolean checkHallOfFameIsPresent();

    void chooseTournamentAccountVip();

    void selectCFDZarOstAsset();

    void select5stZarOstAsset();

    String getChartTimeframeVipText();

    void clickChartTypeVipButton();

    boolean checkInfoPopupExists();

    TradingPageVip checkCfdUnavailablePlaceholderIsDisplayed();

    void clickSwitchToDemoAccountButton();

    String getInfoPopupText();

    void clickAssetsButton();

    void clickDealsTab();

    void swipeLeftToAddAssetButton();

    void clickVipDepositButton();
}
