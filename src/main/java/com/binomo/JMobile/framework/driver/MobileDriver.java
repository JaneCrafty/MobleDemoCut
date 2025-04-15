package com.example.JMobile.framework.driver;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.environment.PropertyValues;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class MobileDriver {

    private final static AtomicInteger port = new AtomicInteger(8300);
    private static final int implicitlyWait = 30;
    private static final int explicitlyWait = 90;
    private AppiumDriver<MobileElement> _driver;
    private WebDriverWait _wait;
    private PropertyValues _propertyValues;
    private String baseUrl = System.getProperty("appBranchName", "");
    // launch selenium grid with params --host localhost --port 8200
    private final String gridURL = "http://localhost:8200";
    // appium one, for debug
    //  private String gridURL = "http://localhost:4723/wd/hub";
    private String emulatorUdid = "emulator-5554";
    private String systemPort = "8301";

    public void setEmulatorUdid(String udid) {
        this.emulatorUdid = udid;
    }

    public String getEmulatorUdid() {
        return emulatorUdid;
    }

    public void setSystemPort(String systemPort) {
        this.systemPort = systemPort;
    }

    public WebDriverWait getDriverWait() {
        // AQUA-2366
        return _wait;
    }

    public AppiumDriver getDriver() {
        return _driver;
    }

    public AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getDriver();
    }

    public PropertyValues getPropertyValues() {
        return _propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        _propertyValues = propertyValues;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreen() {
        return _driver.getScreenshotAs(OutputType.BYTES);
    }

    private void StartIOSDriver(String appLanguage) throws IOException {
        String chromedriverPath = new File("chromedriver").getCanonicalFile().getPath();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        boolean isRealDevice = Boolean.parseBoolean(_propertyValues.isRealDevice);

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("appium:xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("appium:xcodeOrgId", "39674J8G34");
        capabilities.setCapability("appium:newCommandTimeout", "30000");
        capabilities.setCapability("appium:deviceName", _propertyValues.deviceName);
        capabilities.setCapability("appium:autoAcceptAlerts", "true");
        capabilities.setCapability("appium:chromedriverExecutable", chromedriverPath);
        capabilities.setCapability("appium:waitForAppScript", "false");
        capabilities.setCapability("appium:waitForIdleTimeout", "0");
        capabilities.setCapability("appium:language", appLanguage.substring(0, 2));
        capabilities.setCapability("appium:locale", appLanguage.substring(3));

        if (isRealDevice) {
            capabilities.setCapability("app", _propertyValues.app + ".ipa");

            // for webdriver agent
//
//            try {
//                Process p = Runtime.getRuntime().exec("xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination id=2d3c84671f4f64a97c449ab27dc5a82d112f58f3  test");
//                logger.info(p.getOutputStream());
//
//            } catch (Exception e) {
//
//                logger.info(e.getMessage());
//            }

        } else {
            String apkPath = new File(".").getCanonicalFile().getPath() + _propertyValues.apkPath;

            capabilities.setCapability("app", apkPath);
            capabilities.setCapability("platformVersion", _propertyValues.platformVersion);
        }

        _driver = new IOSDriver(new URL("http://" +
                _propertyValues.serverIp + ":" +
                _propertyValues.serverPort), capabilities);

        _driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        _driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        _wait = new CustomWait(_driver, 90, 500);

        if (!_driver.isAppInstalled("com.example.example-iOS-Beta")) {
            logger.info("App not installed");
            System.exit(0);
        }
    }

    private void StartAndroidDriver(String appLanguage, boolean animationsNeeded) throws IOException {
        URL gridURL = new URL(this.gridURL);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        String systemPort = String.valueOf(port.updateAndGet(value -> value > 8399 ? 8300 : value + 1));
        logger.info("systemPort is " + systemPort);

        String apkPath = new File(".").getCanonicalFile().getPath() + _propertyValues.apkPath;
        String chromedriverPath = new File("chromedriver").getCanonicalFile().getPath();

        capabilities.setCapability("appium:disableWindowAnimation", !animationsNeeded);

        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:appPackage", _propertyValues.appPackage);
        capabilities.setCapability("appium:chromedriverExecutable", chromedriverPath);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:newCommandTimeout", "30000");
        capabilities.setCapability("appium:app", apkPath);
        capabilities.setCapability("appium:allowTestPackages", "true");
        capabilities.setCapability("appium:unicodeKeyboard", true);
        capabilities.setCapability("appium:resetKeyboard", true);
        capabilities.setCapability("appium:udid", emulatorUdid);
        capabilities.setCapability("appium:deviceName", emulatorUdid);
        capabilities.setCapability("appium:systemPort", this.systemPort);
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:webviewDevtoolsPort", Integer.parseInt(this.systemPort) + 1000);
        capabilities.setCapability("appium:chromedriverPort", Integer.parseInt(this.systemPort) + 2000);
        capabilities.setCapability("appium:language", appLanguage.substring(0, 2));
        capabilities.setCapability("appium:locale", appLanguage.substring(3));

        ArrayList<String> argsList = new ArrayList<>();
        argsList.add("--disable-notifications");
        argsList.add("--ignore-certificate-errors");

        Map<String, Object> options = new HashMap<>();
        options.put("w3c", false);
        options.put("args", argsList);

        capabilities.setCapability("appium:chromeOptions", options);

        capabilities.setCapability("appium:waitForIdleTimeout", 0L);

        _driver = new AndroidDriver<MobileElement>(gridURL, capabilities);
        _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        _wait = new CustomWait(_driver, explicitlyWait, 500);
    }

    public void disableAppPopup() {
        ((JavascriptExecutor) getDriver())
                .executeScript("localStorage.setItem('androidBannerWasShowed', 'true')");
    }

    @SuppressWarnings({"deprecated"})
    public void SetUp(String appLanguage, boolean animationsNeeded) throws Exception {
        switch (_propertyValues.mobileOS) {
            case IOS:
                StartIOSDriver(appLanguage);
                break;
            case Android:
                StartAndroidDriver(appLanguage, animationsNeeded);
                break;
            default:
                throw new Exception("incorrect device type");
        }
    }

    public void TearDown() {
        _driver.quit();
        _driver = null;
    }

    public String getContext() {
        return _driver.getContext();
    }

    /**
     * Sets context
     * While testing hybrid apps, gives opportunity to switch between
     * Native, webview and web automation
     * For mobile web automation does nothing
     */
    public void SetContext(boolean isWeb) {
        SetContext(isWeb, explicitlyWait);
    }

    public void SetContextChrometab(boolean isWeb) {
        if (this.getPropertyValues().mobileOS == MobileOS.Android) {
            SetContext(isWeb, "WEBVIEW_" + this.getPropertyValues().appPackage, explicitlyWait);
        } else {
            SetContext(isWeb, explicitlyWait);
        }
    }

    public void SetContext(boolean isWeb, int seconds) {
        SetContext(isWeb, "WEB", seconds);
    }

    public void SetContext(boolean isWeb, String webContext, int seconds) {
        String contextPartName;
        if (isWeb) {
            contextPartName = webContext;
        } else {
            contextPartName = "NATIVE";
        }
        String currentContext = _driver.getContext();
        if (currentContext.contains(contextPartName)) {
            return;
        }
        logger.info("current context = " + currentContext);
        logger.info("trying to switch to " + contextPartName);
        this._wait
                .withTimeout(Duration.ofSeconds(seconds))
                .withMessage("Timeout waiting for new context, avaliable contexts: [" + String.join(", ", _driver.getContextHandles()) + "]")
                .until(d -> {
                    Set<String> contexts = _driver.getContextHandles();
                    logger.info("all contexts = " + String.join(", ", contexts));

                    for (String context : contexts) {
                        logger.info(context);
                        logger.info(contextPartName);
                        logger.info(context.contains(contextPartName));
                        logger.info("---------");
                        if (context.contains(contextPartName)) {
                            _driver.context(context);
                            logger.info("switched to context = " + _driver.getContext());
                            return true;
                        }
                    }
                    return false;
                });
    }

    public void changeImplicitlyWaitToNull() {
        _driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void changeImplicitlyWait(int seconds) {
        _driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void returnImplicitlyWait() {
        _driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
    }
}