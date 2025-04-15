package com.example.JMobile.framework.annotations;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

import static com.example.JMobile.framework.environment.AllureCustomFieldsMapping.PRIORITY_LABEL_NAME;


/**
 * Used by Allure Enterprise to link test cases with related test methods.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = PRIORITY_LABEL_NAME)
public @interface Priority {

    String value();

}
