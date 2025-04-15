package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;

public abstract class TransactionSupportAlertPanel extends BaseElements {

    public abstract TransactionSupportAlertPanel checkTransactionSupportAlertPanel();

    public abstract boolean isKeepWaitingButtonExists();

    public abstract boolean isAnotherQuestionButtonExists();

    public abstract String getTitleSupportAlertPanelText();

    public abstract String getDescriptionSupportAlertPanelText();

    public abstract HelpCenterPage clickLearnMoreLink();


    public TransactionSupportAlertPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }
}
