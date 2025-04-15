package com.example.JMobile.testing.Suites;

import com.example.JMobile.testing.Tests.AndroidBrokerBetaTests.*;
import com.example.JMobile.testing.Tests.CommonTests.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AssetsCardAndroidTests.class,
        AssetsCardShowProvocationAndroidTests.class,
        AssetsCardStatusesVipButtonAndroidTests.class,
        AuthAndroidTests.class,
        BonusesAndroidTests.class,
        CashierWithdrawalAndroidTests.class,
        CFDDealsAndroidTests.class,
        CFDTradeRoomAndroidTests.class,
        ChartTimeframeAndroidTests.class,
        ChartTypeAndroidTests.class,
        DealsAccountsAndroidTests.class,
        DeleteAccountAndroidTests.class,
        FTTDealsAndroidTests.class,
        IndicatorsAndroidTests.class,
        NotifyPopupAndroidTests.class,
        RegistrationAndroidTests.class,
        SectionSwitchingAndroidTests.class,
        SettingsAndroidTests.class,
        StatusesAndroidTests.class,
        SumSubAndroidTests.class,
        SupportAndroidTests.class,
        TopTradersAndroidTests.class,
        TournamentsAndroidTests.class,
        TradesHistoryAndroidTests.class,
        TransactionProcessingAndroidTests.class,
        UserMenuAndroidTests.class,
        UserTournamentCertificateAndroidTests.class,
        AssetsCardCommonTests.class,
        BlitzDealsCommonTests.class,
        BonusesCommonTests.class,
        CashierChangesSmokeTests.class,
        NativeCashierChangesSmokeTests.class,
        CashierCommonTests.class,
        NativeCashierTests.class,
        CFDTradeRoomCommonTests.class,
        DealsCommonTests.class,
        DealsSystemInteractionsCommonTests.class,
        IndicatorsCommonTests.class,
        OnboardingAndNewRegistrationCommonTests.class,
        PersonalProgressCommonTests.class,
        SocialTradingCommonTests.class,
        StatusesCommonTests.class,
        TradeRoomCommonTests.class,
})

public class SmokeAndroidBOandCFDSuite {
}
