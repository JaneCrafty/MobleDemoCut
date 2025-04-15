package com.example.JMobile.testing.Suites;

import com.example.JMobile.testing.Tests.CommonTests.*;
import com.example.JMobile.testing.Tests.IosTests.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AssetsCardIOSTests.class,
        AuthIOSTests.class,
        BonusesIOSTests.class,
        CashierIOSTests.class,
        CFDDealsIOSTests.class,
        CFDTradeRoomIOSTests.class,
        FTTDealsIOSTests.class,
        IndicatorsIOSTests.class,
        RegistrationIOSTests.class,
        SectorSwitchingIOSTests.class,
        StatusesIOSTests.class,
        SupportIOSTests.class,
        TradeRoomIOSTests.class,
        UserMenuIOSTests.class,
        UserTournamentCertificateIOSTests.class,
        AssetsCardCommonTests.class,
        BlitzDealsCommonTests.class,
        BonusesCommonTests.class,
        CashierChangesSmokeTests.class,
        CashierCommonTests.class,
        CFDTradeRoomCommonTests.class,
        DealsCommonTests.class,
        DealsSystemInteractionsCommonTests.class,
        IndicatorsCommonTests.class,
        OnboardingAndNewRegistrationCommonTests.class,
        PersonalProgressCommonTests.class,
        SocialTradingCommonTests.class,
        StatusesCommonTests.class,
        TradeRoomCommonTests.class
})

public class SmokeIosBOandCFDSuite {
}
