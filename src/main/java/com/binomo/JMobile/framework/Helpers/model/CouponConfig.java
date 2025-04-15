package com.example.JMobile.framework.Helpers.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class CouponConfig
{
    protected static FileInputStream file;
    protected static Properties properties;

    static {
        try {
            file = new FileInputStream("src/main/resources/coupon.properties");
            properties = new Properties();
            properties.load(file);

        } catch (IOException ex) {
            logger.error("CouponConfig error. \n" + ex.getMessage());

        } finally {
            if (file != null) {
                try {
                    file.close();

                } catch (IOException ex) {
                    logger.error("CouponConfig error.\n" + ex.getMessage());
                }
            }
        }
    }

    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}
