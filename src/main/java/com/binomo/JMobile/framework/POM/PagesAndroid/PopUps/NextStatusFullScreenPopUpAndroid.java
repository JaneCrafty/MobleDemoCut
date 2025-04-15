package com.example.JMobile.framework.POM.PagesAndroid.PopUps;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.PopUps.NextStatusFullScreenPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NextStatusFullScreenPopUpAndroid extends NextStatusFullScreenPopUp {

    @AndroidFindBy(id = "com.example.broker.beta:id/modalNegativeButton")
    private AndroidElement _startTradingButton;


    public NextStatusFullScreenPopUpAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
    }


    public TradingPage clickStartTradingButton() {
        isDisplayed(_startTradingButton, 15);
        tryClick(_startTradingButton);
        return new TradingPageAndroid(mobileDriver);
    }

}
