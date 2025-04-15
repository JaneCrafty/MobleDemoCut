package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.Enums.MobileOS;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class TransactionHistoryPanel extends BaseElements {

    public abstract MobileElement getOpenTradesSection();

    public abstract MobileElement getFttMechElement();

    public abstract MobileElement getLastOpenDeal();

    public abstract MobileElement getAmountOfInvestment();

    public abstract MobileElement getLastDealInvestment();

    public abstract MobileElement getCfdLastDealInvestment();

    public abstract MobileElement getCloseLastCfdDealButton();

    public abstract MobileElement getConfirmCloseLastCfdDealButton();

    public abstract MobileElement getTransactionsHistoryPanel();

    public abstract MobileElement getEmptyTransactionsHistoryPanel();

    public abstract MobileElement getOpenTradeId();

    public abstract MobileElement getHistoryLastTradeId();

    public abstract MobileElement getIconOpenTradeElement();

    public abstract MobileElement getDealTrendOpenTradeElement();

    public abstract MobileElement getNameOpenTradeElement();

    public abstract MobileElement getDealRateOpenTradeElement();

    public abstract MobileElement getSellButtonOpenTradeElement();

    public abstract MobileElement getDealAmountOpenTradeElement();

    public abstract MobileElement getDealIncomeOpenTradeElement();

    public abstract MobileElement getProgressBarOpenTradeElement();

    public abstract TransactionHistoryPanel checkSellButtonOpenTradeActive();

    public abstract TradingPage clickTraderoomTabButtonCarol();

    public abstract HelpCenterPage clickTryThisGuideLink();


    public TransactionHistoryPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public TransactionHistoryPanel checkTransactionHistoryPanel() {
        getWait().withMessage("Transaction history Panel is not displayed").until(d ->
                isDisplayed(getTransactionsHistoryPanel()));
        return this;
    }

    public TransactionHistoryPanel checkEmptyTransactionHistoryPanel() {
        getWait().withMessage("Transaction history Panel is not displayed").until(d ->
                isDisplayed(getEmptyTransactionsHistoryPanel()));
        return this;
    }

    public boolean isNameOpenTradeElementExists() {
        return tryDisplayed(getNameOpenTradeElement());
    }

    public boolean isOpenTradesSectionExist() {
        customUpSwipe(400);
        return tryDisplayed(getOpenTradesSection());
    }

    public boolean isIconOpenTradeElementExists() {
        return tryDisplayed(getIconOpenTradeElement());
    }

    public boolean isDealTrendOpenTradeElementExists() {
        return tryDisplayed(getDealTrendOpenTradeElement());
    }

    public boolean isDealRateOpenTradeElementExists() {
        return tryDisplayed(getDealRateOpenTradeElement());
    }

    public boolean isSellButtonOpenTradeElementExists() {
        return tryDisplayed(getSellButtonOpenTradeElement());
    }

    public boolean isDealAmountOpenTradeElementExists() {
        return tryDisplayed(getDealAmountOpenTradeElement());
    }

    public boolean isDealIncomeOpenTradeElementExists() {
        return tryDisplayed(getDealIncomeOpenTradeElement());
    }

    public boolean isProgressBarOpenTradeElementExists() {
        return tryDisplayed(getProgressBarOpenTradeElement());
    }

    public boolean isOpenCfdDealExist() {
        return tryDisplayed(getCfdLastDealInvestment());
    }

    public boolean isOpenTradeIdExists() {
        return isDisplayed(getOpenTradeId(), 1);
    }

    public boolean isOpenDealExist() {
        return tryDisplayed(getLastOpenDeal());
    }

    public boolean isOpenTradesSectionMissing() {
        return isElementMissing(getOpenTradesSection());
    }

    public boolean isFttMechanicsMissing() { return isElementMissing(getFttMechElement()); }

    public String getAmountOfInvestmentText() {
        return tryGetText(getAmountOfInvestment());
    }

    public String getLastDealInvestmentText() {
        customUpSwipe(300);
        return tryGetText(getLastDealInvestment());
    }

    public String getLastCfdDealInvestmentText() {
        customUpSwipe(300);
        return tryGetText(getCfdLastDealInvestment());
    }

    public String getHistoryLastTradeIdText() {
        customUpSwipe(300);
        return tryGetText(getHistoryLastTradeId());
    }

    public String getOpenTradeIdText() {
        return tryGetText(getOpenTradeId());
    }

    public TransactionHistoryPanel closeLastOpenCfdDeal() {
        if (isExistWithWait(getOpenTradesSection())) {
            tryClick(getCloseLastCfdDealButton());
            if (mobileDriver.getPropertyValues().mobileOS == MobileOS.Android) {
                tryClick(getConfirmCloseLastCfdDealButton());
// Change after resolve IOS-4934
            } else {
                MobileElement element = getConfirmCloseLastCfdDealButton();
                int x = element.getCoordinates().onPage().getX();
                int y = element.getCoordinates().onPage().getY();

                int width = element.getSize().getWidth();
                int height = element.getSize().getHeight();

                clickByCoordinates(x + width + 60, y + height / 2);
            }
        }
        return this;
    }

}
