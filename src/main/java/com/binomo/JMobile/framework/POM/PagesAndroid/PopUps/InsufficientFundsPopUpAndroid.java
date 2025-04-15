package com.example.JMobile.framework.POM.PagesAndroid.PopUps;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.Steps.PopUps.InsufficientFundsPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class InsufficientFundsPopUpAndroid extends InsufficientFundsPopUp {

    @AndroidFindBy(id = "notEnoughMoneyRoot")
    private AndroidElement _insufficientFundsPopUp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.example.broker.beta:id/notEnoughMoneyRoot\"]//android.widget.TextView[1]")
    private AndroidElement _notEnoughLabel;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/notEnoughMoneyRoot']//android.widget.TextView[2]")
    private AndroidElement _makeDepositLabel;

    @AndroidFindBy(id = "depositButton")
    private AndroidElement _addFundsBtn;


    public InsufficientFundsPopUpAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getInsufficientFundsPopUp() { return _insufficientFundsPopUp; }

    public AndroidElement getNotEnoughLabel() { return _notEnoughLabel; }

    public AndroidElement getAddFundsBtn() { return _addFundsBtn; }

    public AndroidElement getMakeDepositLabel() { return _makeDepositLabel; }


    public InsufficientFundsPopUp checkInsufficientFundsPopUpExist() {
        Assert.assertTrue(tryDisplayed(_insufficientFundsPopUp));
        return this;
    }

    public boolean isCloseButtonExists() {
        return isClosePanelButtonExists();
    }

    @Override
    public InsufficientFundsPopUp clickCloseButton() {
        clickClosePanelButton();
        return new InsufficientFundsPopUpAndroid(mobileDriver);
    }

    @Override
    public CashierDepositPage clickMakeDepositButton() {
        tryClick(_addFundsBtn);
        return new CashierDepositPageAndroid(mobileDriver);
    }

    @Override
    public NativeCashierDepositPageAndroid clickMakeDepositNativeButton() {
        tryClick(_addFundsBtn);
        return new NativeCashierDepositPageAndroid(mobileDriver);
    }
}
