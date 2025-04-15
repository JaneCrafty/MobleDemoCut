package com.example.JMobile.testing.Suites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        ModeratorAuthorizationTests.class,
        RegistrationTests.class,
})
public class SmokeAndroidMarketlyModeratorModeSuite {
}
