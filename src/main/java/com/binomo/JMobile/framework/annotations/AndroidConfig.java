package com.example.JMobile.framework.annotations;


import com.example.JMobile.framework.Enums.AndroidConfigFile;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AndroidConfig {
    AndroidConfigFile value();
}
