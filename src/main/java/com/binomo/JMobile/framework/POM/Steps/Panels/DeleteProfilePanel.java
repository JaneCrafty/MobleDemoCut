package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.Enums.AppMessages;
import com.example.JMobile.framework.Enums.MsgFactory;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.WelcomePage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public abstract class DeleteProfilePanel extends BaseElements {

    public abstract MobileElement getDeleteProfilePanel();

    public abstract MobileElement getAlertModalBeforeDelete();

    public abstract MobileElement getOngoingDealAlertOnDelete();

    public abstract MobileElement getBeforeYouLeaveTitle();

    public abstract MobileElement getInfoFundsTitle();

    public abstract MobileElement getWithdrawFundsButton();

    public abstract MobileElement getDeleteAnywayButton();

    public abstract MobileElement getDeleteProfileTitle();

    public abstract MobileElement getBeforeDeleteMessage();

    public abstract MobileElement getSelectReasonBeforeDeleteMessage();

    public abstract MobileElement getReasonField();

    public abstract MobileElement getPasswordField();

    public abstract MobileElement getHoldToDeleteButton();

    public abstract MobileElement getDeleteReasonCard();

    public abstract MobileElement getTextInputErrorHint();

    public abstract MobileElement getTextInputErrorIcon();

    public abstract MobileElement getDeleteReasonCardTitle();

    public abstract MobileElement getNotSpecifiedReason();

    public abstract MobileElement getCurrencyChangeReason();

    public abstract MobileElement getAffiliateLinkChangeReason();

    public abstract MobileElement getBrokerChangeReason();

    public abstract MobileElement getOtherReason();

    public abstract PanelUserMenu clickCloseDeleteAccountView();

    public abstract CashierWithdrawalPage clickWithdrawalButton();

    public abstract WelcomePage pressHoldDeleteButtonFor3secAccount();


    public DeleteProfilePanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public DeleteProfilePanel checkDeleteAccountPanel() {
        getWait().withMessage("Delete profile panel is not displayed").until(d ->
                isDisplayed(getDeleteProfilePanel()));
        return this;
    }

    public DeleteProfilePanel checkBeforeDeleteAlert() {
        getWait().withMessage("Alert is not displayed").until(d ->
                isDisplayed(getAlertModalBeforeDelete()));
        return this;
    }

    public boolean isOngoingDealAlertDisplayed() {
        return tryDisplayed(getOngoingDealAlertOnDelete()) &&
                tryGetText(getOngoingDealAlertOnDelete()).equals(MsgFactory.getMessage(AppMessages.ONGOING_DEAL_ALERT_BEFORE_DELETING_ACCOUNT));
    }

    public boolean isCloseButtonExists() {
        return isClosePanelButtonExists();
    }

    public boolean isBeforeYouLeaveTitleExists() {
        return tryDisplayed(getBeforeYouLeaveTitle());
    }

    public boolean isWithdrawalButtonExists() {
        return tryDisplayed(getWithdrawFundsButton());
    }

    public boolean isProceedAnywayButtonExists() {
        return tryDisplayed(getDeleteAnywayButton());
    }

    public boolean isDeleteProfileTitleExists() {
        return tryDisplayed(getDeleteProfileTitle());
    }

    public boolean isReasonFieldExists() {
        return tryDisplayed(getReasonField());
    }

    public boolean isPasswordFieldExists() {
        return tryDisplayed(getPasswordField());
    }

    public boolean isHoldToDeleteButtonExists() {
        return tryDisplayed(getHoldToDeleteButton());
    }

    public boolean isDeleteReasonCardDisplayed() {
        return tryDisplayed(getDeleteReasonCard());
    }

    public boolean isTextInputErrorIconExists() {
        return tryDisplayed(getTextInputErrorIcon());
    }

    public boolean isReasonCardTitleExists() {
        return tryDisplayed(getDeleteReasonCardTitle());
    }

    public boolean isNotSpecifiedReasonExists() {
        return tryDisplayed(getNotSpecifiedReason());
    }

    public boolean isCurrencyChangeReasonExists() {
        return tryDisplayed(getCurrencyChangeReason());
    }

    public boolean isAffiliateLinkChangeReasonExists() {
        return tryDisplayed(getAffiliateLinkChangeReason());
    }

    public boolean isBrokerChangeReasonExists() {
        return tryDisplayed(getBrokerChangeReason());
    }

    public boolean isOtherReasonExists() {
        return tryDisplayed(getOtherReason());
    }

    public boolean isDeleteReasonCardMissing() {
        return isElementMissing(getDeleteReasonCard());
    }

    public String getFundsAlertMessageText() {
        return tryGetText(getInfoFundsTitle());
    }

    public String getBeforeDeleteMessageText() {
        return tryGetText(getBeforeDeleteMessage());
    }

    public String getBeforeDeleteReasonMessageText() {
        return tryGetText(getSelectReasonBeforeDeleteMessage());
    }

    public String getPasswordRequiredMessageText() {
        return tryGetText(getTextInputErrorHint());
    }

    public String getIncorrectPasswordMessageText() {
        return tryGetText(getTextInputErrorHint());
    }

    public DeleteProfilePanel clickProceedAnywayButton() {
        tryClick(getDeleteAnywayButton());
        return this;
    }

    public DeleteProfilePanel clickReasonFieldButton() {
        tryClick(getReasonField());
        return this;
    }

    public DeleteProfilePanel clickOtherReasonButton() {
        tryClick(getOtherReason());
        return this;
    }

    public DeleteProfilePanel clickHoldToDeleteButton() {
        getWait()
                .withMessage("Кнопка удаления не кликабельна")
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(getHoldToDeleteButton()));
        tryClick(getHoldToDeleteButton());
        return this;
    }

    public DeleteProfilePanel pressHoldDeleteButtonFor5secAccountNotDeleted() {
        tryLongClick(getHoldToDeleteButton(), 5);
        return this;
    }

    public DeleteProfilePanel setPassword(String password) {
        getWait().until(ExpectedConditions.elementToBeClickable(getPasswordField()));
        sendKeys(getPasswordField(), password, false);
        return this;
    }
}
