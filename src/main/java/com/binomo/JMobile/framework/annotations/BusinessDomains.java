package com.example.JMobile.framework.annotations;

import java.lang.annotation.*;

@Inherited
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BusinessDomains {

    BusinessDomain[] value();

}
