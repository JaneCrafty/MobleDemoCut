package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.WelcomePage;
import com.example.JMobile.framework.driver.MobileDriver;

public abstract class LogOutPanel extends BaseElements {

    public abstract LogOutPanel checkLogOutPanel();

    public abstract WelcomePage clickAcceptLogOutButton();


    public LogOutPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }

}
