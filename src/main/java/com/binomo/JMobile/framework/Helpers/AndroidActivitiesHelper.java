package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.Enums.Activity;
import com.example.JMobile.framework.driver.MobileDriver;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class AndroidActivitiesHelper {

    public void WaitAndCheckActivity(Activity expectedActivity, MobileDriver mobileDriver) {
        final String[] currentActivity = {getCurrentActivityString(mobileDriver)};
        logger.info("Current activity is " + currentActivity[0] + ", we are waiting for activity '" + expectedActivity.get() + "'");
        try {
            mobileDriver.getDriverWait()
                    .withTimeout(Duration.ofSeconds(90))
                    .withMessage("Page is Undisplayed : " + expectedActivity.get() + ", another page is displayed instead: " + currentActivity[0])
                    .until(d -> {
                        currentActivity[0] = getCurrentActivityString(mobileDriver);
                        return currentActivity[0].compareTo(expectedActivity.get()) == 0;
                    });
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Expected condition failed: Page is Undisplayed")) {
                RuntimeException newException = new RuntimeException("Page is Undisplayed : " + expectedActivity.get() + ", another page is displayed instead: " + currentActivity[0]);
                newException.setStackTrace(e.getStackTrace());
                throw newException;
            }
            throw e;
        }
    }

    public void WaitOtherActivity(String currentActivity, MobileDriver mobileDriver) {
        logger.info("Current activity is " + getCurrentActivityString(mobileDriver) + ", we are waiting for not '" + currentActivity + " activity");
        Boolean result = mobileDriver.getDriverWait().withTimeout(Duration.ofSeconds(90)).withMessage("current activity is " + currentActivity).until(
                d -> getCurrentActivityString(mobileDriver).compareTo(
                        currentActivity) != 0);
        logger.info("Waiting result is " + result);
        logger.info("Current activity is " + getCurrentActivityString(mobileDriver));
    }

    public String getCurrentActivityString(MobileDriver mobileDriver) {
        return mobileDriver.getAndroidDriver().currentActivity();
    }
}
