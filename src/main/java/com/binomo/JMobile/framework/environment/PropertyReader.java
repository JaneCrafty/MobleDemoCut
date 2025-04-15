package com.example.JMobile.framework.environment;

import com.example.JMobile.framework.Enums.LocaleEnam;
import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.driver.MobileDriver;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class PropertyReader {

    private final PropertyValues propertyValues;

    private String propFileName = System.getProperty("configFile") + ".properties";

    public PropertyReader(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void ReadPropertyValues() {
        InputStream inputStream = null;
        PropertyValues _propertyValues = propertyValues;

        try {
            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            PropertyValues.locale = prop.getProperty("locale").toUpperCase().equals("RU") ? LocaleEnam.RU : LocaleEnam.EN;
            _propertyValues.app = prop.getProperty("app");
            _propertyValues.platformVersion = prop.getProperty("platformVersion");
            _propertyValues.deviceName = prop.getProperty("deviceName");
            _propertyValues.deviceName = prop.getProperty("deviceName");
            _propertyValues.serverIp = prop.getProperty("serverIp");
            _propertyValues.serverPort = prop.getProperty("serverPort");
            _propertyValues.isRealDevice = prop.getProperty("isRealDevice");
            _propertyValues.apkPath = prop.getProperty("apkPath");
            _propertyValues.appPackage = prop.getProperty("appPackage");
            _propertyValues.deviceCount = 1;

            String deviceCount = prop.getProperty("deviceCount");
            if (deviceCount != null) {
                _propertyValues.deviceCount = Integer.parseInt(prop.getProperty("deviceCount"));
            }

            switch (prop.getProperty("mobileOS").toUpperCase()) {
                case "IOS":
                    _propertyValues.mobileOS = MobileOS.IOS;
                    break;
                case "ANDROID":
                    _propertyValues.mobileOS = MobileOS.Android;
                    break;
                default:
                    throw new Exception("incorrect device type");
            }

        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
