package com.example.JMobile.testing.Suites;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


/**
 * Using some tests just to check that the proxy works (if it works, tests would fail)
 */
@Suite
@SelectClasses({
        ModeratorAuthorizationTests.class,
})
public class ProxyAndroidTestSuite {
}


