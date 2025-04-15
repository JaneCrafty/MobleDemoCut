package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class InvestmentsPanel extends BaseElements {

    public abstract MobileElement getFirstInvestmentValueInList();

    public abstract MobileElement getCustomInvestment558();

    public abstract MobileElement getRemoveCustomInvestmentButton();

    public abstract MobileElement getInvestment1FromList();

    public abstract MobileElement getInvestment20FromList();

    public abstract TradingPage clickCustomInvestment558();

    public abstract TradingPage clickInvestment1FromList();

    public abstract TradingPage clickInvestment10FromList();

    public abstract TradingPage clickInvestment20FromList();

    public abstract TradingPage clickInvestment100FromList();

    public abstract TradingPage clickCloseInvestmentsPanel();

    public abstract TradingPage setCustomInvestmentValue(int investment);


    public InvestmentsPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isRemoveInvestmentFromListButtonExists() {
        return tryDisplayed(getRemoveCustomInvestmentButton());
    }

    public boolean isCustomInvestment558Missing() {
        return isElementMissing(getCustomInvestment558());
    }

    public String getFirstInvestmentButtonValueText() {
        return tryGetText(getFirstInvestmentValueInList());
    }

    public String getInvestment1FromListText() {
        return tryGetText(getInvestment1FromList());
    }

    public String getInvestment20FromListText() {
        return tryGetText(getInvestment20FromList());
    }

    public InvestmentsPanel removeCustomInvestment() {
        tryClick(getRemoveCustomInvestmentButton());
        return this;
    }
}
