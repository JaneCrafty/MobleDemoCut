package com.example.JMobile.framework.JiraSync;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    protected static FileInputStream file;
    protected static Properties properties;

    public Config() {
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    static {
        try {
            file = new FileInputStream("src/main/resources/jiraSync.properties");
            properties = new Properties();
            properties.load(file);
        } catch (FileNotFoundException var11) {
            var11.printStackTrace();
        } catch (IOException var12) {
            var12.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException var10) {
                    var10.printStackTrace();
                }
            }

        }

    }
}
