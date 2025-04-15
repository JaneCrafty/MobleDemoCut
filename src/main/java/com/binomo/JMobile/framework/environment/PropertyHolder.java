package com.example.JMobile.framework.environment;

public class PropertyHolder {
    private static volatile PropertyValues instance;

    public static PropertyValues getPropertyValues() {
        if (instance == null) {
            synchronized (PropertyHolder.class) {
                if (instance == null) {
                    instance = new PropertyValues();
                    PropertyReader propertyReader = new PropertyReader(instance);
                    propertyReader.ReadPropertyValues();
                }
            }
        }
        return instance;
    }
}
