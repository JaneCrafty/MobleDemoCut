package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.POMWeb.Webview.Pages.CreditCardPages.DectaRedirectPage;
import com.example.JMobile.framework.POMWeb.Webview.Pages.CreditCardPages.PgwBinopayRedirectPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ChooseAmountScreenCardMC extends MobileElementActions {

    @FindBy(css = ".island [class*=button_btn]")
    private MobileElement _depositButton;

    @FindBy(xpath = "//*[@id='qa_cashier_amountItem']//h2")
    private MobileElement _chooseAmountScreenTitle;

    @FindBy(css = ".amount")
    private MobileElement _amountDiv;


    public ChooseAmountScreenCardMC(MobileDriver mobileDriver) {
        super(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AmountItem getAmountItem() {
        return new AmountItem(mobileDriver, _amountDiv);
    }

    public PgwBinopayRedirectPage clickDepositButtonWithBinopay() {
        tryDisplayed(_depositButton);
        tryClick(_depositButton);
        return new PgwBinopayRedirectPage(mobileDriver);
    }

    public DectaRedirectPage clickDepositButtonWithDecta() {
        tryDisplayed(_depositButton);
        tryClick(_depositButton);
        return new DectaRedirectPage(mobileDriver);
    }

    public String getChooseAmountMessageTitle() {
        mobileDriver.SetContext(true);
        getWait().until(ExpectedConditions.visibilityOf(_depositButton));
        getWait().until(ExpectedConditions.visibilityOf(_chooseAmountScreenTitle));
        return tryGetText(_chooseAmountScreenTitle);

    }
}
