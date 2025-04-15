package com.example.JMobile.testing;

import com.example.JMobile.framework.SlackSync.SlackMessage;
import com.example.JMobile.framework.environment.CustomAppender;
import com.example.JMobile.framework.environment.SystemVariables;
import io.qameta.allure.AllureId;
import org.apache.commons.io.FileDeleteStrategy;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class TestWatcherRules implements TestWatcher, ParameterResolver {

    protected String screenName;
    protected File tmpScrFile;
    private String testStatus;
    private String testName;
    private String allureCaseID = "";
    protected String newScrPath;

    protected static final File directoryScr = getScreenDir();
    protected static final File directoryTmp = new File(directoryScr.getPath() + "/tmp/");
    protected static final File directorySuccess = new File(directoryScr.getPath() + "/Success/");
    protected static final File directoryFailed = new File(directoryScr.getPath() + "/Failed/");

    private static final SlackMessage message = new SlackMessage();


    private static File getScreenDir() {
        File directory = null;

        try {
            String current = new File(".").getCanonicalPath();
            directory = new File(current + "/TestScreenshots/");
            logger.info("screen dir: " + directory);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return directory;
    }

    public static String getAllureCaseId(ExtensionContext context) {
        AllureId annotation = context.getElement().get().getAnnotation(AllureId.class);
        if (annotation == null) {
            logger.warn("AllureId is missing");
            return "0";
        }
        return annotation.value();
    }

    private String getTestName(ExtensionContext context) {
        return context.getTestMethod().get().getName();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testStatus = "Success";
        allureCaseID = getAllureCaseId(context);
        testName = getTestName(context);

        message.addSuccessResult(context.getDisplayName() + " (" + getTestName(context) + ", " +
                " AllureCaseID = " + getAllureCaseId(context) + ") \n");

        finished(context);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testStatus = "Failed";
        allureCaseID = getAllureCaseId(context);
        testName = getTestName(context);

        message.addFailedResult(context.getDisplayName() + " (" + getTestName(context) + ", " +
                " AllureCaseID = " + getAllureCaseId(context) + ") \n");

        finished(context);
    }

    protected void finished(ExtensionContext context) {
        replaceScreenshot(context);

        logger.info("Test #" + getAllureCaseId(context) + " : '" + context.getDisplayName() + "' has finished with status " + testStatus +
                "\n Link: " + SystemVariables.getAllureReportLink());

        CustomAppender.getEvents();
    }

    public void replaceScreenshot(ExtensionContext context) {

        String testName = getTestName(context);
        String testId = getAllureCaseId(context);
        screenName = testId + "_" + testName + "_" + LocalDateTime.now().plusHours(3) + ".png";
        setScreenPath();

        try {
            if (tmpScrFile == null) {
                logger.info("screenshot file doesn't  exist!");
                return;
            }
            File newPath = new File(directoryScr + "/" + testStatus + "/" + screenName);
            Files.move(Paths.get(tmpScrFile.getPath()), Paths.get(newPath.getPath()), StandardCopyOption.REPLACE_EXISTING);

            logger.info("tmpScrFile path " + tmpScrFile.getPath() + " isExist " + tmpScrFile.exists());
            logger.info("newPath  path  file://" + newPath.getPath());


            if (!(newPath.exists() && !newPath.isDirectory())) {
                logger.info("screenshot file doesn't  exist!");
                logger.info("impossible take screenshot");
            }

        } catch (IOException e) {
            logger.error("impossible take screenshot");
            e.printStackTrace();
        }

    }

    private void setScreenPath() {
        newScrPath = SystemVariables.getAutotestsJobUrl() + "/artifacts/file/TestScreenshots/" + testStatus + "/" + screenName + "   ";
    }

    protected static void clearScreensFolder() {
        if (SystemVariables.getAutotestsJobUrl().equals("")) {
            try {
                for (File file : directoryScr.listFiles()) {
                    FileDeleteStrategy.FORCE.delete(file);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().equals(ExtensionContext.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return extensionContext;
    }
}
