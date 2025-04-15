package com.example.JMobile.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;

public class CustomWait extends WebDriverWait {
    private final WebDriver driver;

    public CustomWait(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
        this.driver = driver;
    }

    public CustomWait(WebDriver driver, long timeOutInSeconds, long sleepInMillis) {
        super(driver, timeOutInSeconds, sleepInMillis);
        this.driver = driver;
    }

    public CustomWait(WebDriver driver, Clock clock, Sleeper sleeper, long timeOutInSeconds, long sleepTimeOut) {
        super(driver, clock, sleeper, timeOutInSeconds, sleepTimeOut);
        this.driver = driver;
    }

    @Override
    protected RuntimeException timeoutException(String message, Throwable lastException) {
        try {
            throw super.timeoutException(message, lastException);
        } catch (Exception e) {

            String newMessage = e.getMessage();
            int index = newMessage.indexOf("Build info");
            if (index != -1) {
                newMessage = e.getMessage().substring(0, index - 1);
            }
            throw new RuntimeException(newMessage);
        }
    }
}
