package com.example.JMobile.framework.annotations;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

import static com.example.JMobile.framework.environment.AllureCustomFieldsMapping.PLATFORM_LABEL_NAME;


/**
 * Used by Allure Enterprise to link test cases with related test methods.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = PLATFORM_LABEL_NAME)
@Repeatable(Platforms.class)
public @interface Platform {

    String value();

}
