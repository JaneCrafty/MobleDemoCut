package com.example.JMobile.testing;

import com.example.JMobile.framework.DataProviders.UserData;
import com.example.JMobile.framework.Enums.AndroidConfigFile;
import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.Helpers.AdbCommandLauncher;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.WelcomePageAndroid;
import com.example.JMobile.framework.POM.PagesIOS.Pages.WelcomePageIOS;
import com.example.JMobile.framework.POM.PagesVip.WelcomePageVip;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.Pages.WelcomePage;
import com.example.JMobile.framework.SlackSync.SlackChannels;
import com.example.JMobile.framework.SlackSync.SlackMessage;
import com.example.JMobile.framework.annotations.AndroidConfig;
import com.example.JMobile.framework.annotations.AnimationsNeeded;
import com.example.JMobile.framework.annotations.AppLanguage;
import com.example.JMobile.framework.driver.MobileDriver;
import com.example.JMobile.framework.environment.PropertyHolder;
import com.example.JMobile.framework.environment.PropertyReader;
import com.example.JMobile.framework.environment.PropertyValues;
import com.example.JMobile.framework.environment.SystemVariables;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;
import static com.example.JMobile.framework.SlackSync.SlackClient.sendMessageToChannel;
import static com.example.JMobile.framework.SlackSync.SlackClient.sendMessageToUser;
import static io.qameta.allure.Allure.addAttachment;

@ExtendWith(TestWatcherRules.class)
public class Watcher {
    private WelcomePage _welcomePage;
    private TradingPage _tradingPage;
    protected MobileDriver mobileDriver;
    private PropertyReader _propertyReader;
    public PropertyValues _propertyValues;

    private AndroidConfig androidConfigAnnotation;

    public MobileDriver getMobileDriver() {
        return mobileDriver;
    }

    private static final SlackMessage message = new SlackMessage();

    public SoftAssertions soft;
    private static final ConcurrentLinkedQueue<Integer> deviceNumberQueue = new ConcurrentLinkedQueue<>();

    private int currentDeviceNumber = 0;

    public static synchronized void fillDeviceQueue(int totalDevices) {
        if (!deviceNumberQueue.isEmpty()) {
            return;
        }
        for (int i = 0; i < totalDevices; i++) {
            deviceNumberQueue.add(i);
        }
    }

    @BeforeAll
    public static void BeforeAll() {
        //только для локальных запусков
        if (SystemVariables.getAppBranch().equals("")) {
            TestWatcherRules.clearScreensFolder();
        }

        if (!TestWatcherRules.directoryTmp.exists()) {
            TestWatcherRules.directoryTmp.mkdir();
        }
        if (!TestWatcherRules.directoryScr.exists()) {
            TestWatcherRules.directoryScr.mkdir();
        }
        if (!TestWatcherRules.directorySuccess.exists()) {
            TestWatcherRules.directorySuccess.mkdir();
        }
        if (!TestWatcherRules.directoryFailed.exists()) {
            TestWatcherRules.directoryFailed.mkdir();
        }
    }

    @BeforeEach
    public void BeforeEach(ExtensionContext context) {
        mobileDriver = new MobileDriver();
        logger.info("test # " + TestWatcherRules.getAllureCaseId(context) + " : '" + context.getDisplayName() + "' has started");
        androidConfigAnnotation = context.getElement().get().getAnnotation(AndroidConfig.class);

        soft = new SoftAssertions();

        _propertyValues = PropertyHolder.getPropertyValues();
        mobileDriver.setPropertyValues(_propertyValues);

        int totalDevices = mobileDriver.getPropertyValues().deviceCount;
        if (totalDevices > 1) {
            if (deviceNumberQueue.isEmpty()) {
                Watcher.fillDeviceQueue(totalDevices);
            }

            try {
                currentDeviceNumber = deviceNumberQueue.poll();
            } catch (NullPointerException e) {
                logger.error("Setting of parallel devices failed, falling back to default device. Exception is \n" + e);
            }
            logger.info("test " + TestWatcherRules.getAllureCaseId(context) + " :" + context.getTestMethod().get().getName() + " uses device #" + currentDeviceNumber);

            switch (currentDeviceNumber) {
                case 1:
                    mobileDriver.setEmulatorUdid("emulator-5556");
                    mobileDriver.setSystemPort("8302");
                    break;
                case 2:
                    mobileDriver.setEmulatorUdid("emulator-5558");
                    mobileDriver.setSystemPort("8303");
                    break;
                case 3:
                    mobileDriver.setEmulatorUdid("emulator-5560");
                    mobileDriver.setSystemPort("8304");
                    break;
                case 4:
                    mobileDriver.setEmulatorUdid("emulator-5562");
                    mobileDriver.setSystemPort("8305");
                    break;
                case 5:
                    mobileDriver.setEmulatorUdid("emulator-5564");
                    mobileDriver.setSystemPort("8306");
                    break;
                case 6:
                    mobileDriver.setEmulatorUdid("emulator-5566");
                    mobileDriver.setSystemPort("8307");
                    break;
                case 7:
                    mobileDriver.setEmulatorUdid("emulator-5568");
                    mobileDriver.setSystemPort("8308");
                    break;
                case 0:
                default:
                    mobileDriver.setEmulatorUdid("emulator-5554");
                    mobileDriver.setSystemPort("8301");
            }
        }

        try {
            AppLanguage appLanguage = context.getElement().get().getAnnotation((AppLanguage.class));
            boolean animationsNeeded = context.getElement().get().isAnnotationPresent((AnimationsNeeded.class));
            mobileDriver.SetUp(appLanguage == null ? "en-US" : appLanguage.value(), animationsNeeded);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Couldn't set up app language " + e);
        }

        switch (_propertyValues.mobileOS) {
            case IOS:
                _welcomePage = new WelcomePageIOS(mobileDriver);
                break;
            case Android:
                _welcomePage = new WelcomePageAndroid(mobileDriver);
                _tradingPage = new TradingPageAndroid(mobileDriver);
                mobileDriver.getDriver().closeApp();
                break;
            default:
                throw new RuntimeException("Test watcher failure: incorrect mobile OS type: " + _propertyValues.mobileOS);
        }
    }

    @AfterEach
    public void AfterEach() {
        deviceNumberQueue.add(currentDeviceNumber);
        currentDeviceNumber = 0;

        // если поставить true, в логи аллюра будет добавляться логкат
        boolean attachLogcatToAllure = false;
        if (attachLogcatToAllure) {
            mobileDriver.getDriver().manage().logs().getAvailableLogTypes();
            LogEntries logs = mobileDriver.getDriver().manage().logs().get("logcat");
            List<LogEntry> logsList = logs.getAll();

            // ограничение в 2000 последних строк чтобы не перегрузить аллюр
            if (logsList.size() > 2000) {
                logsList = logsList.subList(logsList.size() - 2000, logsList.size());
            }

            // добавляем в аллюр вложение с логкатом
            String attachment = logsList.stream().map(LogEntry::toString)
                    .collect(Collectors.joining("\n"));
            addAttachment("logcat", attachment);
        }

        logger.info("******************************************");


        if (mobileDriver != null && mobileDriver.getDriver() != null) {

            mobileDriver.makeScreen();

            if (mobileDriver.getPropertyValues().mobileOS.equals(MobileOS.Android)) {
                AdbCommandLauncher.clearApp(mobileDriver.getEmulatorUdid(), mobileDriver.getPropertyValues().appPackage);
            }

            mobileDriver.TearDown();
            mobileDriver = null;
        }

        soft.assertAll();
        _propertyReader = null;
        _propertyValues = null;
    }

    public static void AfterAll() {
        try {
            SendFinishSlackNotification();
        } catch (IOException e) {
            logger.error("slack error = " + e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean isConfigNeeded() {

        return mobileDriver.getPropertyValues().appPackage.equals("com.example.broker.beta") ||
                mobileDriver.getPropertyValues().appPackage.equals("com.example.vipbroker.beta");
    }

    private void setUpAndroidConfig() {
        AdbCommandLauncher.pushConfigFile(
                mobileDriver.getEmulatorUdid(),
                androidConfigAnnotation != null ? androidConfigAnnotation.value() : AndroidConfigFile.DEFAULT,
                mobileDriver.getPropertyValues().appPackage
        );
    }

    private boolean isAndroid() {
        return mobileDriver.getPropertyValues().mobileOS.equals(MobileOS.Android);
    }

    @Step("Get Welcome page")
    public WelcomePage getWelcomePage() {
        if (isAndroid()) {
            if (isConfigNeeded()) {
                setUpAndroidConfig();
            }
            AdbCommandLauncher.startSplashScreenActivity(mobileDriver.getEmulatorUdid(), mobileDriver.getPropertyValues().appPackage);
        }
        return _welcomePage;
    }

    @Step("Get Trading page by default user with email: autotestUser1@gmail.com and password: autotestUser1@gmail.com")
    public TradingPage getTradingPageWithLoginDefaultUser1() {
        if (isAndroid()) {
            if (isConfigNeeded()) {
                setUpAndroidConfig();
            }
            AdbCommandLauncher.performLogin(mobileDriver.getEmulatorUdid(), UserData.getAutotestUser1Email(), UserData.getAutotestUser1Password(), mobileDriver.getPropertyValues().appPackage);
        }
        return _tradingPage;
    }

    @Step("Get Trading page")
    public TradingPage getTradingPageWithLogin(String email, String password) {
        if (isAndroid()) {
            if (isConfigNeeded()) {
                setUpAndroidConfig();
            }
            AdbCommandLauncher.performLogin(mobileDriver.getEmulatorUdid(), email, password, mobileDriver.getPropertyValues().appPackage);
        }
        return _tradingPage;
    }

    public WelcomePageVip getWelcomePageVip() {
        if (isAndroid()) {
            if (isConfigNeeded()) {
                setUpAndroidConfig();
            }
        }
        AdbCommandLauncher.startSplashScreenActivity(mobileDriver.getEmulatorUdid(), mobileDriver.getPropertyValues().appPackage);
        return new WelcomePageAndroid(mobileDriver);
    }

    @Step("Get Trading page by new user")
    public TradingPage getTradingPageWithSignUp(String email, String password) {
        logger.info("Sign up with user: " + email + " / " + password);
        if (isAndroid()) {
            if (isConfigNeeded()) {
                setUpAndroidConfig();
            }
            AdbCommandLauncher.performSignUp(mobileDriver.getEmulatorUdid(), email, password, mobileDriver.getPropertyValues().appPackage);
        }
        return _tradingPage;
    }

    // Rules for sending the notification
    private static void SendFinishSlackNotification() throws IOException {
        if (SystemVariables.getAppBranch().toLowerCase().startsWith("rc")) {
            sendMessageToChannel(message, SlackChannels.getNativeTestsSlackChannel());
        }

        if (SystemVariables.getAppBranch().equalsIgnoreCase("develop") ||
                SystemVariables.getAppBranch().equalsIgnoreCase("master")) {
            sendMessageToChannel(message, SlackChannels.getNativeTestsSlackChannel());
        }

        if (SystemVariables.getCashierChanges().equals(true)) {
            sendMessageToChannel(message, SlackChannels.getNativeTestsSlackChannel());
            sendMessageToChannel(message, SlackChannels.getFrontendTestsSlackChannel());
        }

        if (message.getUser().equals("anton.rumyantsev@karuna.group")) {
            sendMessageToUser(message);
        }
    }

}
