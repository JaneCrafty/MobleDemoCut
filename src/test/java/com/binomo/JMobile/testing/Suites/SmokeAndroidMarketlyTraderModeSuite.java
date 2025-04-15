package com.example.JMobile.testing.Suites;

import com.example.JMobile.testing.Tests.AndroidMarketlyTests.TraiderModeTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TraiderModeTests.class
})
public class SmokeAndroidMarketlyTraderModeSuite {
}
