package com.example.JMobile.framework.SlackSync;

import com.example.JMobile.framework.environment.SystemVariables;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class SlackMessage {
    private static final List<String> slackTCresultsSucceded = new ArrayList<>();
    private static final List<String> slackTCresultsFailed = new ArrayList<>();
    private final String allureDirectLink = generateAllureDirectLink();
    private String user = SystemVariables.getGitlabUserEmail();

    public SlackMessage() {

        logger.info("Developer Email: " + user);

        if (this.user.contains("@example.com")) {
            this.user = this.user.substring(0, this.user.indexOf("@")) + "@karuna.group";
        }
    }

    public String getUser() {
        return user;
    }

    public void addFailedResult(String name) {
        slackTCresultsFailed.add(name);
    }

    public void addSuccessResult(String name) {
        slackTCresultsSucceded.add(name);
    }

    public String succeededResultsToString() {
        if (slackTCresultsSucceded.size() > 0) {
            StringBuilder succeededResult = new StringBuilder();
            for (String slackTCResultSucceeded : slackTCresultsSucceded) {
                if (slackTCResultSucceeded.contains("[")) {
                    succeededResult.append(slackTCResultSucceeded, 0, slackTCResultSucceeded.indexOf("[")).append("\n");
                } else {
                    succeededResult.append(slackTCResultSucceeded).append("\n");
                }
            }
            return succeededResult.toString();
        } else {
            return null;
        }
    }

    public String failedResultToString() {
        if (slackTCresultsFailed.size() > 0) {
            StringBuilder failedResult = new StringBuilder();
            for (String slackTCResultFailed : slackTCresultsFailed) {
                if (slackTCResultFailed.contains("[")) {
                    failedResult.append(slackTCResultFailed, 0, slackTCResultFailed.indexOf("[")).append("\n");
                } else {
                    failedResult.append(slackTCResultFailed).append("\n");
                }
            }
            return failedResult.toString();
        } else {
            return null;
        }
    }

    private String generateAllureDirectLink() {
        if (SystemVariables.getAllureLaunchName() == null) {
            return SystemVariables.getAllureReportLink();
        }
        return SystemVariables.getAllureReportLink() + "?search=" + Base64.getEncoder().encodeToString(
                ("[{\"id\":\"name\",\"type\":\"string\",\"value\":\"" + SystemVariables.getAllureLaunchName() + "\"}]").getBytes()
        );
    }

    @Override
    public String toString() {
        return "*" + SystemVariables.getPlatform().toUpperCase() + " AUTOTESTS:*\n" +
                "    _triggered by: " + SystemVariables.getGitlabUserEmail() + "_\n\n" +

                "App info: \n" +
                "    App name: " + SystemVariables.getAppName() + " \n" +
                "    App branch name : " + SystemVariables.getAppBranch() + "\n" +
                "    Application version: " + SystemVariables.getVersionNumber() + "(" + SystemVariables.getCodeNumber() + ")" + "\n" +
                "    Build number: " + SystemVariables.getParentJobId() + "\n\n" +

                "Autotests results: \n" +
                "    allure credentials: developer / 6gchX1ms" + "\n" +
                "    <" + allureDirectLink + "|allure report link>" + "\n\n" +

                "Pipelines: \n" +
                (!SystemVariables.getPipelineFront().equals("") ? "    <" + SystemVariables.getPipelineFront() + "|frontend pipeline>" + "\n" : "") +
                "    <" + SystemVariables.getAutotestsJobUrl() + "|autotests job> " + "\n\n" +

                "Count of failed tests: *" + slackTCresultsFailed.size() + "*\n" +
                "Count of successful tests: *" + slackTCresultsSucceded.size() + "*\n";
    }
}
