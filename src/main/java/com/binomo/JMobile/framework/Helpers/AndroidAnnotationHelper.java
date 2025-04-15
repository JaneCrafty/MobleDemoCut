package com.example.JMobile.framework.Helpers;

import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Objects;

public class AndroidAnnotationHelper {

    public static synchronized void setUpAndroidIds(MobileDriver mobileDriver, Object page) {
        String appPackage = mobileDriver.getPropertyValues().appPackage;
        Field[] allFields = FieldUtils.getAllFields(page.getClass());
        for (Field field : allFields) {
            Annotation[] annotations = field.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof AndroidFindBy) {
                    AndroidFindBy androidFindByAnnotation = (AndroidFindBy) annotation;

                    if (!Objects.equals(androidFindByAnnotation.xpath(), "")) {
                        String oldValue = androidFindByAnnotation.xpath();
                        String newValue = oldValue.replace("com.example.broker.beta", appPackage);
                        AndroidAnnotationHelper.changeAnnotationValue(
                                annotation,
                                "xpath",
                                newValue
                        );
                    } else if (!androidFindByAnnotation.id().equals("")
                            && !androidFindByAnnotation.id().startsWith(appPackage)) {
                        AndroidAnnotationHelper.changeAnnotationValue(
                                annotation,
                                "id",
                                appPackage + ":id/" + androidFindByAnnotation.id()
                        );
                    }
                }
            }
        }
    }

    // the code is copied from the internet as-is :)
    @SuppressWarnings("unchecked")
    public static synchronized void changeAnnotationValue(Annotation annotation, String key, Object newValue) {
        Object handler = Proxy.getInvocationHandler(annotation);
        Field field;
        try {
            field = handler.getClass().getDeclaredField("memberValues");
        } catch (NoSuchFieldException | SecurityException e) {
            throw new IllegalStateException(e);
        }
        field.setAccessible(true);
        Map<String, Object> memberValues;
        try {
            memberValues = (Map<String, Object>) field.get(handler);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        Object oldValue = memberValues.get(key);
        if (oldValue == null || oldValue.getClass() != newValue.getClass()) {
            throw new IllegalArgumentException();
        }
        memberValues.put(key, newValue);
    }
}
