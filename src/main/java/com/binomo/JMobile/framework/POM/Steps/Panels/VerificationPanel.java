package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.Enums.MsgFactory;
import com.example.JMobile.framework.Enums.Titles;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;

public abstract class VerificationPanel extends BaseElements {

    public abstract MobileElement getVerificationPurposeLabel();

    public abstract MobileElement getDocumentsList();

    public abstract MobileElement getVerificationTitle();

    public abstract MobileElement getIdCardItem();

    public abstract MobileElement getVerificationIdCardStatusItem();

    public abstract MobileElement getVerificationIdCardStatusIconItem();

    public abstract MobileElement getVerificationPaymentMethodName();

    public abstract MobileElement getVerificationCardMaskedPan();

    public abstract VerificationPanel checkVerificationPanel();


    public VerificationPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public VerificationPanel checkVerificationPanelTitle() {
        if (mobileDriver.getPropertyValues().mobileOS == MobileOS.Android) {
            Assert.assertEquals(tryGetText(getVerificationTitle()), (MsgFactory.getMessage(Titles.SUMSUB_DOCS_VERIFICATION_TITLE)));
        }
        return this;
    }

    public boolean isVerificationPurposeLabelExists() {
        return tryDisplayed(getVerificationPurposeLabel());
    }

    public boolean isVerificationDocsListExists() {
        return tryDisplayed(getDocumentsList());
    }

    public boolean isBackButtonExists() {
        return tryDisplayed(getBackButton());
    }

    public boolean isIdCardExists() {
        return tryDisplayed(getIdCardItem());
    }

    public boolean isVerificationStatusExists() {
        return tryDisplayed(getVerificationIdCardStatusItem());
    }

    public boolean isVerificationStatusIconExists() {
        return tryDisplayed(getVerificationIdCardStatusIconItem());
    }

    public boolean isVerificationPaymentMethodNameExists() {
        return tryDisplayed(getVerificationPaymentMethodName());
    }

    public boolean isCardMaskedPanExists() {
        return tryDisplayed(getVerificationCardMaskedPan());
    }

    public String getMaskedPanText() {
        return tryGetText(getVerificationCardMaskedPan());
    }
}
