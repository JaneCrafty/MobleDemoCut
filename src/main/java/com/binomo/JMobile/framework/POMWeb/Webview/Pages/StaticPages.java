package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.Enums.Activity;
import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaticPages extends MobileElementActions {

    @FindBy(css = "#qa_StaticPage .title")
    private MobileElement _staticPageTitle;

    @FindBy(css = "#qa_StaticPage .markdown")
    private MobileElement _staticPageDescription;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close tab']")
    private AndroidElement _staticPageCloseButton;


    public StaticPages(MobileDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public StaticPages checkStaticPage() {
        androidActivitiesHelper.WaitAndCheckActivity(Activity.STATIC_PAGE, mobileDriver);
        return this;
    }

    public boolean isStaticPageCloseButtonExists() {
        mobileDriver.SetContext(false);
        return tryDisplayed(_staticPageCloseButton);
    }

    public String getStaticPageTitleText() {
        mobileDriver.SetContext(true);
        tryDisplayed(_staticPageTitle);
        logger.info(mobileDriver.getDriver().getCurrentUrl());
        return tryGetText(_staticPageTitle);
    }

    public String getStaticPageDescriptionText() {
        mobileDriver.SetContext(true);
        tryDisplayed(_staticPageDescription);
        return tryGetText(_staticPageDescription);
    }

    public SignUpPage clickBackKeyboardButton() {
        mobileDriver.SetContext(false);
        ClickBackKeyboardButton();
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new SignUpPageIOS(mobileDriver);
        } else {
            return new SignUpPageAndroid(mobileDriver);
        }
    }

    public SignUpPage clickCloseButton() {
        mobileDriver.SetContext(false);
        tryClick(_staticPageCloseButton);
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            return new SignUpPageIOS(mobileDriver);
        } else {
            return new SignUpPageAndroid(mobileDriver);
        }
    }
}
