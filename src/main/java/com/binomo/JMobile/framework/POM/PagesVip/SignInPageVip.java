package com.example.JMobile.framework.POM.PagesVip;

public interface SignInPageVip {
    SignInPageVip fillEmailVip(String email);
    SignInPageVip fillPasswordVip(String password);
    SignInPageVip step(String stepName);
    TradingPageVip clickLoginButtonVip();
}
