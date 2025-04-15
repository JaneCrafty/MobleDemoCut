package com.example.JMobile.framework.environment;

public class SystemVariables {
    private static final String autotestsJobUrl = System.getProperty("autotests_job_url", "");
    private static String gitlabUserEmail = System.getProperty("gitlab_user_email", "");
    private static String pipelineFront = System.getProperty("upstream_pipeline", "");
    private static String platform = System.getProperty("platform_name", "");
    private static String appBranch = System.getProperty("appBranch", "");
    private static String appName = System.getProperty("appName", "");
    private static String parentJobId = System.getProperty("parent_job_id", "");
    private static String versionNumber = System.getProperty("version_number", "");
    private static String codeNumber = System.getProperty("code_number", "");
    private static final String allureReportLink = "https://testops.example.com/project/2/launches";
    private static final String allureLaunchName = System.getProperty("allure_launch_name", "");
    private static Boolean cashierChanges = System.getProperty("cashierChanges", "").equals("true");

    public static String getAutotestsJobUrl() {
        return autotestsJobUrl;
    }

    public static String getGitlabUserEmail() {
        return gitlabUserEmail;
    }

    public static String getPipelineFront() {
        return pipelineFront;
    }

    public static String getPlatform() {
        return platform;
    }

    public static String getAppBranch() {
        return appBranch;
    }

    public static String getAppName() {
        if (appName.isEmpty())
            return "beta";
        return appName;
    }

    public static String getParentJobId() {
        return parentJobId;
    }

    public static String getVersionNumber() {
        return versionNumber;
    }

    public static String getCodeNumber() {
        return codeNumber;
    }

    public static String getAllureReportLink() {
        return allureReportLink;
    }

    public static String getAllureLaunchName() {
        return allureLaunchName;
    }

    public static Boolean getCashierChanges() {
        return cashierChanges;
    }
}
