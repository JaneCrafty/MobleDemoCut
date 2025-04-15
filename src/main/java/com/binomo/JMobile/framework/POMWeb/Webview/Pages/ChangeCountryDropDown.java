package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.Enums.Countries;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeCountryDropDown extends MobileElementActions {

    @FindBy(xpath = "//way-input-text")
    private MobileElement _countrySelectorElement;

    @FindBy(xpath = "//way-input-search//input")
    private MobileElement _countrySelectorInput;

    @FindBy(xpath = "//vui-option[@selected]")
    private MobileElement _countrySelectorOption;


    public ChangeCountryDropDown(MobileDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    public void changeCountry(Countries country) {
        tryClick(_countrySelectorElement);
        sendKeys(_countrySelectorInput, country.getName());
        tryClick(_countrySelectorOption);
    }
}
