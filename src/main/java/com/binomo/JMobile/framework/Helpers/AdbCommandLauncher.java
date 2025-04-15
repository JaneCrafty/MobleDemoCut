package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.Enums.Activity;
import com.example.JMobile.framework.Enums.AndroidConfigFile;
import org.assertj.core.util.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class AdbCommandLauncher {

    public static void startSplashScreenActivity(String emulatorUdid, String appPackage) {
        launch(getSplashScreenActivityLaunchCommand(emulatorUdid, appPackage));
    }

    public static void performLogin(String emulatorUdid, String email, String password, String appPackage) {
        launch(getActivityLaunchCommandWithAction(emulatorUdid, email, password, "sign_in", appPackage));
    }

    public static void performSignUp(String emulatorUdid, String email, String password, String appPackage) {
        launch(getActivityLaunchCommandWithAction(emulatorUdid, email, password, "sign_up", appPackage));
    }

    private static String getActivityLaunchCommandWithAction(String emulatorUdid, String email, String password, String actionType, String appPackage) {
        return String.format(
                "%s --es %s '%s:%s'",
                getSplashScreenActivityLaunchCommand(emulatorUdid, appPackage), actionType, email, password
        );
    }

    private static String getSplashScreenActivityLaunchCommand(String emulatorUdid, String appPackage) {
        return String.format(
                "adb -s %s shell am start -n %s/%s", emulatorUdid, appPackage, Activity.SPLASH_SCREEN.get()
        );
    }


    public static void clearApp(String emulatorUdid, String appPackage) {
        launch(String.format("adb -s %s shell am force-stop %s", emulatorUdid, appPackage));
        launch(String.format("adb -s %s shell am force-stop com.android.chrome", emulatorUdid));
        launch(String.format("adb -s %s shell am force-stop com.google.android.webview", emulatorUdid));
        launch(String.format("adb -s %s shell pm clear %s", emulatorUdid, appPackage));

    }

    public static void pushConfigFile(String emulatorUdid, AndroidConfigFile config, String appPackage) {
        File conf = new File(config.getFilePath());
        if (!conf.exists()) {
            throw new RuntimeException("could not find config file: " + config.getFilePath());
        }

        String androidTempFile = "/sdcard/remote_config.json";
        launch("adb -s",
                emulatorUdid,
                "push",
                config.getFilePath(),
                androidTempFile
        );

            launch("adb -s",
                    emulatorUdid,
                    "shell",
                    "su root cp",
                    androidTempFile,
                    "/sdcard/Android/data/" + appPackage + "/files/remote_config.json"
            );
    }

    private static void launch(String... args) {
        String command = Strings.join(args).with(" ");
        logger.info("Launching command:\n\"" + command + "\"");
        int exitCode;
        Process process;
        try {
            process = new ProcessBuilder("/bin/bash", "-c", command).start();
            exitCode = process.waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        br.lines().forEach(logger::info);
        err.lines().forEach(logger::warn);
        try {
            br.close();
            err.close();
        } catch (IOException e) {
            logger.error(e);
        }

        if (exitCode != 0) {
            throw new RuntimeException("Adb command exited with error code: " + exitCode);
        }
    }
}
