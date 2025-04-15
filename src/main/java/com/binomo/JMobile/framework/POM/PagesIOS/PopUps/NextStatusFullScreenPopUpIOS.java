package com.example.JMobile.framework.POM.PagesIOS.PopUps;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.PopUps.NextStatusFullScreenPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NextStatusFullScreenPopUpIOS extends NextStatusFullScreenPopUp {

    @iOSXCUITFindBy(id = "startTradingButton")
    private IOSElement _startTradingButton;


    public NextStatusFullScreenPopUpIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public TradingPage clickStartTradingButton() {
        getWaitWithTimeout(30)
                .withMessage("Кнопка Start Trading не появилась")
                .until(ExpectedConditions.elementToBeClickable(_startTradingButton));
        tryClick(_startTradingButton);
        return new TradingPageIOS(mobileDriver);
    }

}
