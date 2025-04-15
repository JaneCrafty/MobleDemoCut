package com.example.JMobile.framework.POM.PagesAndroid.PopUps;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.PagesAndroid.Pages.TradingPageAndroid;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.PopUps.RegistrationTournamentPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationTournamentPopUpAndroid extends RegistrationTournamentPopUp {

    @AndroidFindBy(id = "icon")
    private AndroidElement _tournamentImage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/tournamentRegistrationRoot']//android.widget.TextView[@resource-id='com.example.broker.beta:id/header']")
    private AndroidElement _tournamentModalHeader;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Tournament has just started!']")
    private AndroidElement _openTournamentImage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/tournamentParticipationRoot']//android.widget.TextView[@resource-id='com.example.broker.beta:id/header']")
    private AndroidElement _openTournamentModalHeader;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.example.broker.beta:id/tournamentParticipationRoot']//android.widget.TextView[@resource-id='com.example.broker.beta:id/description']")
    private AndroidElement _openTournamentModalDescription;

    @AndroidFindBy(id = "actionButton")
    private AndroidElement _openTournamentButton;


    public RegistrationTournamentPopUpAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getTournamentImage() { return _tournamentImage; }

    public AndroidElement getTournamentModalHeader() { return _tournamentModalHeader; }

    public AndroidElement getStartTournamentImage() { return _openTournamentImage; }

    public AndroidElement getStartTournamentModalHeader() { return _openTournamentModalHeader; }

    public AndroidElement getStartTournamentModalDescription() { return _openTournamentModalDescription; }

    public AndroidElement getOpenTournamentButton() { return _openTournamentButton; }


    public TradingPage clickStartTournamentButton() {
        getWaitWithTimeout(30).until(ExpectedConditions.elementToBeClickable(getOpenTournamentButton()));
        tryClick(getOpenTournamentButton());
        return new TradingPageAndroid(mobileDriver);
    }
}
