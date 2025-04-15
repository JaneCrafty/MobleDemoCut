package com.example.JMobile.framework.POM.Steps;


import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;


public class BaseElements extends MobileElementActions {

    @AndroidFindBy(id = "design_bottom_sheet")
    @iOSXCUITFindBy(accessibility = "AccountsListView")
    private MobileElement _accountTypesLayout;

    @AndroidFindBy(id = "closeButton")
    @iOSXCUITFindBy(accessibility = "CloseButton")
    private MobileElement _closeButton;

    @AndroidFindBy(id = "closeView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Close']")
    private MobileElement _closeViewButton;

    @AndroidFindBy(id = "menuClose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='icon menu back']") // IOS-2903
    private MobileElement _menuCloseButton;

    @AndroidFindBy(id = "backButton")
    @iOSXCUITFindBy(accessibility = "BackButton")
    private MobileElement _backButton;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    @iOSXCUITFindBy(accessibility = "BackButton")
    private MobileElement _goNavigateUpButton;

    @iOSXCUITFindBy(accessibility = "CardDismissView")
    private MobileElement _universalCloseIosPanel;

    @iOSXCUITFindBy(accessibility = "PullBarView")
    private MobileElement _dashClosePanel;

    @AndroidFindBy(id = "autoScalingSwitch")
    private MobileElement _autoScalingSwitch;


    public BaseElements(MobileDriver mobileDriver) {
        super(mobileDriver);
        if (mobileDriver.getPropertyValues().mobileOS != MobileOS.IOS) {
            AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        }
    }


    public MobileElement getBackButton() { return _backButton; }

    public MobileElement getCloseViewButton() { return _closeViewButton; }

    public MobileElement getNavigateUpButton() { return _goNavigateUpButton; }

    public MobileElement getCloseButton() { return _closeButton; }

    public MobileElement getUniversalCloseIosPanel() { return _universalCloseIosPanel; }

    public MobileElement getAutoScalingSwitch() { return _autoScalingSwitch; }


    private TradingPage getReturnTradingPage() {
        return mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS ? new TradingPageIOS(mobileDriver) : new TradingPageAndroid(mobileDriver);
    }

    public boolean isClosePanelButtonExists() {
        return tryDisplayed(_closeViewButton);
    }

    public TradingPage clickClosePanelButton() {
        tryClick(_closeViewButton);
        return getReturnTradingPage();
    }

    @Step("Закрыть пользовательское меню")
    public TradingPage clickMenuCloseButton() {
        tryClickWithWait(_menuCloseButton);
        return getReturnTradingPage();
    }

    @Step("Закрыть пользовательское меню")
    public TradingPage clickDashClosePanel() {
        tryClickWithWait(_dashClosePanel);
        return getReturnTradingPage();
    }

    @Step("click back to traderoom button from cashier page")
    public TradingPage clickBackButton() {
        tryClick(_backButton);
        return getReturnTradingPage();
    }

    public TradingPage swipeForClosingPanel() {
        swipeDownForClosingPanel(_accountTypesLayout);
        return getReturnTradingPage();
    }

}

