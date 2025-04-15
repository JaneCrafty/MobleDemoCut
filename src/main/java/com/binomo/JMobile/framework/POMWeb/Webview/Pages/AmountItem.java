package com.example.JMobile.framework.POMWeb.Webview.Pages;

import com.example.JMobile.framework.POM.MobileElementActions;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmountItem extends MobileElementActions {

    @FindBy(css = "#scrollTo-amount")
    private MobileElement _scrollToAmount;

    @FindBy(css = "#scrollTo-amount input")
    private MobileElement _amountField;

    @FindBy(css = "#qa_cashier_withoutBonusRadioButton > vui-radio")
    private MobileElement _withoutBonusRadioButton;


    public AmountItem(MobileDriver mobileDriver, MobileElement parentElement) {
        super(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(parentElement), this);
        isExistWithWait(parentElement);
        // scroll amount input into view
        WebScrollToElement(_scrollToAmount);
        // scroll down a bit to avoid overlap with the navigation tabs
        WebScrollY(-150);
    }


    public AmountItem selectWithoutBonusRadioButton() {
        if (!isVueRadiobuttonChecked(_withoutBonusRadioButton)) {
            tryClick(_withoutBonusRadioButton);
        }
        return this;
    }

    public AmountItem setDepositAmount(int amount) {
        // get the input ready
        tryClick(_amountField);
        _amountField.clear();
        tryClick(_amountField);
        sendKeys(_amountField, "0");

        // enter the sum digit by digit
        String amountString = String.valueOf(amount);
        for (int i = 0; i < amountString.length(); i++) {
            String amountSubstring = amountString.substring(i, i + 1);
            sendKeys(_amountField, amountSubstring);
        }

        try {
            _driver.hideKeyboard();
        } catch (Exception ex) {
        }
        return this;
    }
}
