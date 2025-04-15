package com.example.JMobile.framework.POM.PagesIOS.PopUps;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.Steps.PopUps.InsufficientFundsPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class InsufficientFundsPopUpiOS extends InsufficientFundsPopUp {

    @iOSXCUITFindBy(accessibility = "PopupView") //должно быть NoFoundsPopupView IOS-2876
    private IOSElement _insufficientFundsPopUp;

    @iOSXCUITFindBy(accessibility = "NoFoundsPopupLabel") //IOS-2876
    private IOSElement _notEnoughLabel;

    @iOSXCUITFindBy(accessibility = "NoFundsDepositButtonsTitleLabel")
    private IOSElement _makeDepositLabel;

    @iOSXCUITFindBy(accessibility = "NoFundsDepositButton")
    private IOSElement _addFundsBtn;


    public InsufficientFundsPopUpiOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    public IOSElement getInsufficientFundsPopUp() { return _insufficientFundsPopUp; }

    public IOSElement getNotEnoughLabel() { return _notEnoughLabel; }

    public IOSElement getAddFundsBtn() { return _addFundsBtn; }

    public IOSElement getMakeDepositLabel() { return _makeDepositLabel; }


    public InsufficientFundsPopUp checkInsufficientFundsPopUpExist() {
        Assert.assertFalse(isDisplayed(_insufficientFundsPopUp, 1));
        return this;
    }

    public boolean isCloseButtonExists() {
        return tryDisplayed(getCloseButton());
    }

    public InsufficientFundsPopUp clickCloseButton() {
        tryClick(getCloseButton());
        return new InsufficientFundsPopUpiOS(mobileDriver);
    }

    public CashierDepositPage clickMakeDepositButton() {
        tryClick(_addFundsBtn);
        return new CashierDepositPageIOS(mobileDriver);
    }

    @Override
    public NativeCashierDepositPageAndroid clickMakeDepositNativeButton() {
        throw new NotImplementedException("Not implemented for IOS");
    }
}
