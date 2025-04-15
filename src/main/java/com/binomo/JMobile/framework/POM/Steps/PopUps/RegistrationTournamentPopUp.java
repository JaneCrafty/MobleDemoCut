package com.example.JMobile.framework.POM.Steps.PopUps;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class RegistrationTournamentPopUp extends BaseElements {

    protected abstract MobileElement getTournamentImage();

    protected abstract MobileElement getTournamentModalHeader();

    protected abstract MobileElement getStartTournamentImage();

    protected abstract MobileElement getStartTournamentModalHeader();

    protected abstract MobileElement getStartTournamentModalDescription();

    protected abstract MobileElement getOpenTournamentButton();

    public abstract TradingPage clickStartTournamentButton();


    public RegistrationTournamentPopUp(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isTournamentImageExists() throws Exception {
        return tryDisplayed(getTournamentImage());
    }

    public boolean isStartTournamentImageExists() throws Exception {
        return tryDisplayed(getStartTournamentImage());
    }

    public boolean isOpenTournamentButtonExists() throws Exception {
        return tryDisplayed(getOpenTournamentButton());
    }

    public String getTournamentModalHeaderText() {
        return tryGetText(getTournamentModalHeader());
    }

    public String getStartTournamentModalHeaderText() {
        return tryGetText(getStartTournamentModalHeader());
    }

    public String getStartTournamentModalDescriptionText() {
        return tryGetText(getStartTournamentModalDescription());
    }

    public RegistrationTournamentPopUp clickOpenTournamentButton() {
        tryClick(getOpenTournamentButton());
        return this;
    }
}
