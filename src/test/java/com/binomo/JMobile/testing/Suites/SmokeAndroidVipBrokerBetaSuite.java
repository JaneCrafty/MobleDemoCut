package com.example.JMobile.testing.Suites;

import com.example.JMobile.testing.Tests.AndroidVipBrokerBetaTests.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        DealsVipTests.class,
        AuthVipTests.class,
        ScalpProVipTests.class,
        PaywallVipTests.class,
        CallbackVipTests.class,
        TabsVipTests.class,
        SplashScreenVipTests.class,
        WelcomeStoriesVipTests.class,
        AssetsListVipTests.class,
        AssetsListTabsVipTests.class,
})
public class SmokeAndroidVipBrokerBetaSuite {
}
