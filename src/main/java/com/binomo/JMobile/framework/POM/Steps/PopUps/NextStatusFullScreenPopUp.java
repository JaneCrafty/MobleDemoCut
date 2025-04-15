package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;

public abstract class NextStatusFullScreenPopUp extends BaseElements {

    public abstract TradingPage clickStartTradingButton();


    public NextStatusFullScreenPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }

}
