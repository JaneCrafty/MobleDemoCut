package com.example.JMobile.framework.POM;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.Enums.SwipeDirection;
import com.example.JMobile.framework.Helpers.AndroidActivitiesHelper;
import com.example.JMobile.framework.driver.MobileDriver;
import com.example.JMobile.framework.environment.CustomAppender;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.appmanagement.ApplicationState.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MobileElementActions {

    public static Logger logger = LogManager.getLogger(CustomAppender.class);

    protected AppiumDriver _driver;
    private WebDriverWait _wait;
    protected MobileDriver mobileDriver;
    protected AndroidActivitiesHelper androidActivitiesHelper = new AndroidActivitiesHelper();

    public MobileElementActions(MobileDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        _driver = mobileDriver.getDriver();
        _wait = mobileDriver.getDriverWait();
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    public WebDriverWait getWait() {
        return (WebDriverWait) _wait.withMessage(() -> null);
    }

    protected WebDriverWait getWaitWithTimeout(int seconds) {
        return (WebDriverWait) getWait().withTimeout(Duration.ofSeconds(seconds));
    }

    public void setWait(WebDriverWait wait) {
        _wait = wait;
    }


    private void throwPrettyError(WebDriverException ex) {
        // create a nice error message if element not found
        String notFoundMessage = "An element could not be located on the page using the given search parameters";
        if (ex.getMessage().contains(notFoundMessage)) {
            throw getNotFoundError(ex);
        }
        throw ex;
    }

    private Error getNotFoundError(Throwable cause) {
        String locatorDetails = "";
        int startIndex = cause.getMessage().indexOf("{using");
        int endIndex = -1;
        if (startIndex != -1) {
            endIndex = cause.getMessage().indexOf("}", startIndex);
            if (endIndex != -1) {
                locatorDetails = cause.getMessage().substring(startIndex, endIndex + 1);
            }
        }

        Error error = new Error("Element not found: " + locatorDetails);
        error.setStackTrace(cause.getStackTrace());
        return error;
    }

    protected void tryClick(MobileElement element) {
        logger.info("Click to element " + element.toString());
        Stopwatch stopwatch = Stopwatch.createStarted();

        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS && mobileDriver.getDriver().getContext().contains("NATIVE")) {
            getWaitWithTimeout(30).until(d -> ExpectedConditions.elementToBeClickable(element));
            new TouchAction(mobileDriver.getDriver()).tap(ElementOption.element(element).withElement(element)).perform();
        } else {
            try {
                element.click();
            } catch (WebDriverException ex) {
                throwPrettyError(ex);
            }
        }
        stopwatch.stop();
        logger.info("time for clicking element (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    protected void tryClickWithWait(MobileElement element) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        mobileDriver.changeImplicitlyWait(5);

        boolean success = false;
        Instant timeout = Instant.now().plusSeconds(15);

        logger.info("Click to element " + element.toString());

        while (!success && timeout.compareTo(Instant.now()) > 0) {
            try {
                element.click();
                success = true;

            } catch (Exception ex) {
                logger.info("Retrying attempt to click to element");
                logger.info(ex.getMessage());
            }
        }

        mobileDriver.returnImplicitlyWait();

        if (!success)
            logger.warn("Out of retrying attempts to click on element");

        stopwatch.stop();
        logger.info("Time for clicking element (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    protected void tryClickInPanelIos(MobileElement element, boolean swipeNeeded) {
        if (swipeNeeded) {
            swipeDownUntilFoundInPanelIos(element);
        }
        new TouchAction(mobileDriver.getDriver()).tap(ElementOption.element(element).withElement(element)).perform();

    }

    protected void tryClickInPanelAndroid(MobileElement element, boolean swipeNeeded) {
        if (swipeNeeded) {
            swipeUntilFoundAndroidPanel(element);
        }
        tryClick(element);

    }

    protected void tryLongClick(MobileElement mobileElement, long duration) {
        logger.info("Click to element ");
        Stopwatch stopwatch = Stopwatch.createStarted();

        getWaitWithTimeout(30).until(d -> ExpectedConditions.elementToBeClickable(mobileElement));
        new TouchAction(mobileDriver.getDriver()).longPress(LongPressOptions.longPressOptions().
                withElement(ElementOption.element(mobileElement)).withDuration(Duration.ofSeconds(duration))).perform();

        stopwatch.stop();
        logger.info("time for clicking element (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }

    protected void tryClickOnWebElement(MobileElement element) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        mobileDriver.changeImplicitlyWait(5);

        boolean success = false;
        Instant timeout = Instant.now().plusSeconds(15);

        logger.info("Click to element " + element.toString());

        while (!success && timeout.compareTo(Instant.now()) > 0) {
            try {
                ((JavascriptExecutor) _driver).executeScript("arguments[0].click();", element);
                success = true;

            } catch (Exception ex) {
                logger.info("Retrying attempt to click to element");
                logger.info(ex.getMessage());
            }
        }

        mobileDriver.returnImplicitlyWait();

        if (!success)
            logger.warn("Out of retrying attempts to click on element");

        stopwatch.stop();
        logger.info("Time for clicking element (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    protected void clickOutsidePanel() {
        TouchAction action = new TouchAction(mobileDriver.getDriver());

        action
                .press((PointOption.point(200, 100)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .release()
                .perform();
    }

    protected void clickByCoordinates(int xOffsetPoint, int yOffsetPoint) {
        TouchAction action = new TouchAction(mobileDriver.getDriver());

        action
                .press((PointOption.point(xOffsetPoint, yOffsetPoint)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                .release()
                .perform();
    }

    protected boolean tryDisplayed(MobileElement element) {
        mobileDriver.changeImplicitlyWait(5);

        boolean isElementDisplayed = false;
        Instant timeout = Instant.now().plusSeconds(15);

        while (timeout.compareTo(Instant.now()) > 0 && !isElementDisplayed) {
            try {
                isElementDisplayed = element.isDisplayed();

            } catch (WebDriverException exception) {
                logger.info("Retrying attempt to check if element is displayed");
                logger.info(exception.getMessage());
            }
        }

        mobileDriver.returnImplicitlyWait();

        if (!isElementDisplayed)
            logger.info("Out of retrying attempts, still not found");

        return isElementDisplayed;
    }

    public boolean isDisplayed(MobileElement element, int seconds) {
        mobileDriver.changeImplicitlyWait(seconds);
        try {
            if (element.isDisplayed()) {
                return true;
            }
        } catch (WebDriverException ignored) {
        } finally {
            mobileDriver.returnImplicitlyWait();
        }
        return false;
    }

    protected boolean isDisplayed(MobileElement element) {
        return isDisplayed(element, 0);
    }

    protected boolean isExistWithWait(MobileElement element) {
        mobileDriver.changeImplicitlyWait(5);

        boolean isElementExists = false;
        Instant timeout = Instant.now().plusSeconds(15);

        while (timeout.compareTo(Instant.now()) > 0 && !isElementExists) {
            try {
                logger.info("Check if element exists");
                isElementExists = element.isEnabled();

            } catch (Exception e) {
                logger.info("Retrying attempt to check if element exists");
                String message = e.getMessage();
                int indexOfNextLine = message.indexOf("\n");
                if (indexOfNextLine == -1) {
                    logger.info(message);
                } else {
                    logger.info(message.substring(0, indexOfNextLine));
                }
            }
        }

        mobileDriver.returnImplicitlyWait();

        if (!isElementExists)
            logger.info("Out of retrying attempts, still non-existent");

        return isElementExists;

    }

    protected boolean isElementMissing(MobileElement element) {
        return !isDisplayed(element, 15);
    }

    protected boolean isEnabled(MobileElement element) {
        mobileDriver.changeImplicitlyWaitToNull();
        boolean elementEnabled;

        try {
            elementEnabled = element.isEnabled();
        } catch (Exception e) {
            logger.info(e.getMessage());
            elementEnabled = false;
        }

        mobileDriver.returnImplicitlyWait();
        return elementEnabled;
    }

    protected boolean isChecked(MobileElement element) {
        try {
            return element.getAttribute("checked").equals("true");
        } catch (WebDriverException ex) {
            throwPrettyError(ex);
        }
        return false;
    }

    protected boolean isVueRadiobuttonChecked(MobileElement element) {
        try {
            return element.getAttribute("class").contains("checked");
        } catch (WebDriverException ex) {
            throwPrettyError(ex);
        }
        return false;
    }

    protected boolean isSelected(MobileElement element) {
        try {
            return element.getAttribute("selected").equals("true");
        } catch (WebDriverException ex) {
            throwPrettyError(ex);
        }
        return false;
    }


    protected String tryGetText(MobileElement element) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        mobileDriver.changeImplicitlyWait(5);

        String textElement = "";
        Instant timeout = Instant.now().plusSeconds(20);

        while (textElement.equals("") && timeout.compareTo(Instant.now()) > 0) {
            try {
                textElement = element.getText();
            } catch (WebDriverException ex) {
                if (timeout.compareTo(Instant.now()) <= 0)
                    logger.warn("Attempt to get the text of the element failed");
            }
        }

        mobileDriver.returnImplicitlyWait();

        stopwatch.stop();
        logger.info("time for getting text of element (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        logger.info("element.getText() = " + textElement);

        return textElement;
    }

    // todo refactor
    protected void sendKeys(MobileElement element, String value) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            tryClickWithWait(element);
        }

        element.sendKeys(value);

        stopwatch.stop();
        logger.info("element.sendKeys(" + value + ") (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    // todo refactor
    protected void sendKeys(MobileElement element, String value, boolean checkResult) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        if (checkResult) {
            sendKeys(element, value);
        } else {
            element.sendKeys(value);
        }

        stopwatch.stop();
        logger.info("element.sendKeys(" + value + ") (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    // todo refactor
    protected void clearAndSendKeys(MobileElement element, String value) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Boolean result = tryGetText(element).equals(value);

        for (int i = 0; i < 10; i++) {
            if (!result) {
                clearKeys(element);
                element.sendKeys(value);
                try {
                    if (mobileDriver.getAndroidDriver().isKeyboardShown()) {
                        mobileDriver.getDriver().hideKeyboard();
                    }
                } catch (Exception ignored) {
                }

                result = tryGetText(element).equals(value);
                if (result.equals(true)) {
                    break;
                }
            }
        }
        stopwatch.stop();
        logger.info("time clearAndSendKeys (milliseconds) = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        Assertions.assertTrue(result);

    }

    public void WebScrollToElement(MobileElement element) {
        getWait().until(driver -> (JavascriptExecutor) mobileDriver.getDriver()).executeScript("arguments[0].scrollIntoView({block: \"center\"});", element);
    }

    public void WebScrollY(int y) {
        ((JavascriptExecutor) mobileDriver.getDriver()).executeScript("document.querySelector('.scroll').scrollBy(0, " + y + ")");
    }

    protected void SwipeScreen(SwipeDirection direction, Point elementCoordinates) {
        Dimension dimensions = mobileDriver.getDriver().manage().window().getSize();
        int screenWidth = dimensions.getWidth();
        int screenHeight = dimensions.getHeight();
        int top_y = (int) (screenHeight * 0.35);
        int bottom_y = (int) (screenHeight * 0.70);
        int left_x = (int) (screenWidth * 0.35);
        int right_x = (int) (screenWidth * 0.70);

        TouchAction action = new TouchAction(mobileDriver.getDriver());

        switch (direction) {
            case down:
                action
                        .press(PointOption.point(elementCoordinates.x, bottom_y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(elementCoordinates.x, top_y));
                break;
            case up:
                action
                        .press(PointOption.point(elementCoordinates.x, top_y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(elementCoordinates.x, bottom_y));
                break;
            case left:
                action
                        .press(PointOption.point(right_x, elementCoordinates.y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(left_x, elementCoordinates.y));
                break;
            case right:
                action
                        .press(PointOption.point(left_x, elementCoordinates.y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(right_x, elementCoordinates.y));
                break;
        }

        action
                .release()
                .perform();
    }

    protected void SwipeInPanelIos(SwipeDirection direction, Point elementCoordinaties) {
        Dimension dimensions = mobileDriver.getDriver().manage().window().getSize();
        int screenWidth = dimensions.getWidth();
        int screenHeight = dimensions.getHeight();
        int top_y = (int) (screenHeight * 0.30);
        int bottom_y = (int) (screenHeight * 0.80);
        int left_x = (int) (screenWidth * 0.30);
        int right_x = (int) (screenWidth * 0.80);

        TouchAction action = new TouchAction(mobileDriver.getDriver());

        switch (direction) {
            case down:
                action
                        .press(PointOption.point(elementCoordinaties.x, bottom_y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(elementCoordinaties.x, top_y));
                break;
            case up:
                action
                        .press(PointOption.point(219, top_y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(219, bottom_y));
                break;
            case left:
                action
                        .press(PointOption.point(right_x, elementCoordinaties.y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(left_x, elementCoordinaties.y));
                break;
            case right:
                action
                        .press(PointOption.point(left_x, elementCoordinaties.y))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                        .moveTo(PointOption.point(right_x, elementCoordinaties.y));
                break;
        }

        action
                .release()
                .perform();
    }

    protected void customDownSwipe(int point) {
        int x = mobileDriver.getDriver().manage().window().getSize().getWidth() / 2;
        int y = mobileDriver.getDriver().manage().window().getSize().getHeight() / 2;

        TouchAction action = new TouchAction(mobileDriver.getDriver());

        action
                .press((PointOption.point(x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, y - point))
                .release()
                .perform();
    }

    protected void swipeDownForClosingPanel(MobileElement element) {
        int x = element.getCenter().getX();
        int y = element.getLocation().getY();

        TouchAction action = new TouchAction(mobileDriver.getDriver());

        action
                .press((PointOption.point(x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, mobileDriver.getDriver().manage().window().getSize().getHeight()))
                .release()
                .perform();
    }

    protected void swipeDownUntilFoundInPanelIos(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isDisplayed(element, 1) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeInPanelIos(SwipeDirection.down, element.getCenter());

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void SwipeDownInPanelUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.down, new Point(900, 650));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();
    }

    protected void customUpSwipe(int point) {
        int x = mobileDriver.getDriver().manage().window().getSize().getWidth() / 2;
        int y = mobileDriver.getDriver().manage().window().getSize().getHeight() / 2;

        TouchAction action = new TouchAction(mobileDriver.getDriver());

        action
                .press((PointOption.point(x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(x, y + point))
                .release()
                .perform();
    }

    protected void swipeUpUntilFoundInPanelIos(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isDisplayed(element, 0) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeInPanelIos(SwipeDirection.up, element.getCenter());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void SwipeUpInPanelUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.up, new Point(900, 650));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();
    }

    protected void swipeUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.down, element.getCenter());

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void swipeUntilFoundAndroidPanel(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.down, new Point(500, 2300));

            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void leftSwipeUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.down, new Point(20, 0));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        stopwatch.stop();

    }

    protected void leftHorizontalSwipeInPanelUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.left, new Point(213, 685));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void leftHorizontalSwipeInElementUntilFound(MobileElement swipeElement, MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();
        tryDisplayed(swipeElement);

        int x = swipeElement.getCenter().getX();
        int y = swipeElement.getCenter().getY();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.left, new Point(x, y));
        }

        stopwatch.stop();
    }

    protected void leftHorizontalSwipeInElement(MobileElement swipeElement) {
        int x = swipeElement.getCenter().getX();
        int y = swipeElement.getCenter().getY();

        SwipeScreen(SwipeDirection.left, new Point(x, y));
    }

    protected void rightSwipeUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.down, new Point(1700, 1110));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void rightHorizontalSwipeInPanelIos(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isDisplayed(element, 0) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeInPanelIos(SwipeDirection.right, element.getCenter());

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();

    }

    protected void rightHorizontalSwipeInPanelUntilFound(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.right, new Point(213, 685));

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopwatch.stop();
    }

    protected void rightHorizontalSwipeInElementUntilFound(MobileElement swipeElement, MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();
        tryDisplayed(swipeElement);

        int x = swipeElement.getCenter().getX();
        int y = swipeElement.getCenter().getY();

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 30) {
            SwipeScreen(SwipeDirection.right, new Point(x, y));
        }

        stopwatch.stop();
    }

    protected void rightHorizontalSwipeInElement(MobileElement swipeElement) {
        int x = swipeElement.getCenter().getX();
        int y = swipeElement.getCenter().getY();

        SwipeScreen(SwipeDirection.right, new Point(x, y));
    }

    protected void clearKeys(MobileElement element) {
        element.clear();
    }

    protected void clickDoneKeyboardButton() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            new TouchAction(mobileDriver.getDriver())
                    .tap(ElementOption.element(mobileDriver.getDriver()
                            .findElement(By.id("Done"))))
                    .perform();
        } else {
            mobileDriver.getAndroidDriver()
                    .executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
        }
        stopwatch.stop();
        logger.info("time for clicking done keyboard = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    protected void ClickBackKeyboardButton() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        mobileDriver.getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));

        stopwatch.stop();
        logger.info("time for clicking done keyboard = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }

    protected void ClickHomeKeyboardButton() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        mobileDriver.getAndroidDriver().pressKey(new KeyEvent(AndroidKey.HOME));

        stopwatch.stop();
        logger.info("time for clicking HOME keyboard = " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

    }

    public ExpectedCondition<Boolean> absenceOf(MobileElement element) {
        return new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {
                return isAbsent(element);
            }

            @Override
            public String toString() {
                return "absence of " + element;
            }
        };
    }

    public boolean isAbsent(MobileElement element) {
        try {
            return !isEnabled(element);
        } catch (StaleElementReferenceException ignored) {
            // We can assume a stale element isn't displayed.
            return true;
        }
    }

    public void runAppInBackground() {
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            runAppInBackgroundIOS("com.example.example-iOS-Beta");
        } else {

            runAppInBackgroundAndroid(mobileDriver.getPropertyValues().appPackage);
        }
    }

    public void runAppInBackgroundIOS(String bundleId) {
        try {
            mobileDriver.getDriver().runAppInBackground(Duration.ofSeconds(1));
            assertThat(isAppStateEqual(bundleId, RUNNING_IN_FOREGROUND)).isTrue();
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    public void runAppInBackgroundAndroid(String bundleId) {
        try {
            ClickHomeKeyboardButton();
            assertThat(isAppStateEqual(bundleId, RUNNING_IN_BACKGROUND)).isTrue();

            Runtime runtime = Runtime.getRuntime();
            runtime.exec("adb -s " + mobileDriver.getEmulatorUdid() + " shell am start -W -n " + mobileDriver.getPropertyValues().appPackage + "/com.example.broker.modules.splash.SplashScreenActivity");
            assertThat(isAppStateEqual(bundleId, RUNNING_IN_FOREGROUND)).isTrue();
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    public void reopenApp() {
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            reopenAppIOS("com.example.example-iOS-Beta");
        } else {
            reopenAppAndroid(mobileDriver.getPropertyValues().appPackage);
        }
    }

    public void reopenAppIOS(String bundleId) {
        try {
            mobileDriver.getDriver().terminateApp(bundleId);
            assertThat(isAppStateEqual(bundleId, NOT_RUNNING)).isTrue();

            mobileDriver.getDriver().activateApp(bundleId);
            assertThat(isAppStateEqual(bundleId, RUNNING_IN_FOREGROUND)).isTrue();
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    public void reopenAppAndroid(String bundleId) {
        try {
            Thread.sleep(1000);
            mobileDriver.getDriver().terminateApp(bundleId);
            assertThat(isAppStateEqual(bundleId, NOT_RUNNING)).isTrue();

            Runtime runtime = Runtime.getRuntime();
            runtime.exec(
                    "adb -s " + mobileDriver.getEmulatorUdid() + " shell am start -W -n " + mobileDriver.getPropertyValues().appPackage + "/com.example.broker.modules.splash.SplashScreenActivity");
            assertThat(isAppStateEqual(bundleId, RUNNING_IN_FOREGROUND)).isTrue();
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
    }

    public boolean isAppStateEqual(String bundleId, ApplicationState state) {
        int count = 0;
        boolean success = false;

        while (!success && count < 5) {
            if (mobileDriver.getDriver().queryAppState(bundleId).equals(state)) {
                success = true;
            }
            count++;
        }
        return success;
    }

    public LocalTime deviceTime() {
        logger.info("time is: " + LocalTime.now());

        return LocalTime.now();
    }

    public void waitUntilElementWillBeRefreshed(WebElement elementToWait, String valueToWait) {
        mobileDriver.getDriverWait().withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.refreshed(
                ExpectedConditions.textToBePresentInElement(elementToWait, valueToWait)));
    }

    public void swipeToBottom() {
        int height = mobileDriver.getDriver().manage().window().getSize().getHeight();
        int scrollCount = (int) Math.ceil(height / 500.0);
        for (int i = 0; i < scrollCount; i++) {
            customDownSwipe(500);
        }
    }
}