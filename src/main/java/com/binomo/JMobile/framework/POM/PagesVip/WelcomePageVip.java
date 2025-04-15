package com.example.JMobile.framework.POM.PagesVip;

import java.util.Set;

public interface WelcomePageVip {
    SignInPageVip clickLoginButtonVip();

    WelcomePageVip step(String stepName);

    SignInPageVip clickSignupButtonVip();

    void checkWelcomeMessageAbsent();
    void checkWelcomeMessageText(String text);

    void checkWelcomePageVip();

    void checkWelcomeStories(Set<String> stories);
}
