package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.Enums.MsgFactory;
import com.example.JMobile.framework.Enums.Titles;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class InsufficientFundsPopUp extends BaseElements {

    public abstract MobileElement getInsufficientFundsPopUp();

    public abstract MobileElement getNotEnoughLabel();

    public abstract MobileElement getAddFundsBtn();

    public abstract MobileElement getMakeDepositLabel();

    public abstract InsufficientFundsPopUp checkInsufficientFundsPopUpExist();

    public abstract boolean isCloseButtonExists();

    public abstract InsufficientFundsPopUp clickCloseButton();

    public abstract CashierDepositPage clickMakeDepositButton();

    public abstract NativeCashierDepositPageAndroid clickMakeDepositNativeButton();


    public InsufficientFundsPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public InsufficientFundsPopUp checkInsufficientFundsPopUp() {
        getWait().withMessage("Insufficient Funds PopUp is not displayed").until(d ->
                isDisplayed(getInsufficientFundsPopUp()));
        return this;
    }

    public InsufficientFundsPopUp checkPopUpTitleText() {
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            // todo: починить после правки  IOS-2876
            //элменты NoFoundsPopupView и NoFoundsPopupLabel с  visible = false, джем пока переведут в true IOS-2876
            //boolean popUpTitleCompareIos = getPopUpTitle().equals(MsgFactory.getMessage(Titles.INSUFFICIENT_FUNDS_IOS_POPUP_TITLE));
            //Assert.assertTrue(popUpTitleCompareIos);
        } else {
            assertThat(getPopUpTitle()).isEqualTo(MsgFactory.getMessage(Titles.INSUFFICIENT_FUNDS_POPUP_TITLE));
        }
        return this;
    }

    public InsufficientFundsPopUp checkPopUpMessageTitleText() {
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.IOS) {
            assertThat(getPopUpMessage()).isEqualTo(MsgFactory.getMessage(Titles.INSUFFICIENT_FUNDS_IOS_POPUP_MESSAGE));
        } else {
            assertThat(getPopUpMessage()).isEqualTo(MsgFactory.getMessage(Titles.INSUFFICIENT_FUNDS_POPUP_MESSAGE));
        }
        return this;
    }

    public boolean isMakeDepositButtonExists() {
        return tryDisplayed(getAddFundsBtn());
    }

    public String getPopUpTitle() {
        return tryGetText(getNotEnoughLabel());
    }

    public String getPopUpMessage() {
        return tryGetText(getMakeDepositLabel());
    }
}


