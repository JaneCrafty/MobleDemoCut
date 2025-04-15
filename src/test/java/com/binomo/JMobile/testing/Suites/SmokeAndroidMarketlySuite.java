package com.example.JMobile.testing.Suites;

import com.example.JMobile.testing.Tests.AndroidMarketlyTests.TraiderModeTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ModeratorAuthorizationTests.class,
        RegistrationTests.class,
        TraiderModeTests.class
})
public class SmokeAndroidMarketlySuite {
}
