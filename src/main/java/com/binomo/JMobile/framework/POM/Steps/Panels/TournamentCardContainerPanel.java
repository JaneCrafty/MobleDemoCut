package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.PopUps.RegistrationTournamentPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class TournamentCardContainerPanel extends BaseElements {

    protected abstract MobileElement getTournamentImage();

    protected abstract MobileElement getTournamentName();

    protected abstract MobileElement getTournamentTimeToEnd();

    protected abstract MobileElement getParticipationFeeExist();

    protected abstract MobileElement getGoalElement();

    protected abstract MobileElement getBalanceValueInLeaderboard();

    protected abstract MobileElement getTournamentPrizeValueInLeaderboard();

    protected abstract MobileElement getUpcomingTournaments();

    protected abstract MobileElement getUserPlaceValue();

    protected abstract MobileElement getRebuyCostValue();

    protected abstract MobileElement getRebuyCostLabel();

    protected abstract MobileElement getBalanceValue();

    protected abstract MobileElement getBalanceLabel();

    protected abstract MobileElement getPrizeValue();

    protected abstract MobileElement getPrizeLabel();

    protected abstract MobileElement getLeaderBoardLabel();

    protected abstract MobileElement getLeaderBoardContainer();

    protected abstract MobileElement getTournamentPrizesLabel();

    protected abstract MobileElement getTournamentConditionsDescription();

    protected abstract MobileElement getTournamentConditions();

    protected abstract MobileElement getSignUpTournamentButton();

    protected abstract MobileElement getOpenTournamentButton();

    public abstract TournamentCardContainerPanel checkTournamentCardContainerPanel();

    public abstract RegistrationTournamentPopUp clickSignUpTournamentButton();

    public abstract TournamentsListContainerPanel clickBackToTournamentListButton();


    public TournamentCardContainerPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isTournamentImageExist() {
        return tryDisplayed(getTournamentImage());
    }

    public boolean isTournamentNameExist() {
        return tryDisplayed(getTournamentName());
    }

    public boolean isTournamentTimeToEndExist() {
        return tryDisplayed(getTournamentTimeToEnd());
    }

    public boolean isParticipationFeeExist() {
        return tryDisplayed(getParticipationFeeExist());
    }

    public boolean isGoalElementExist() {
        SwipeDownInPanelUntilFound(getGoalElement());
        return tryDisplayed(getGoalElement());
    }

    public boolean isBalanceValueInLeaderboardExist() {
        SwipeDownInPanelUntilFound(getBalanceValueInLeaderboard());
        return tryDisplayed(getBalanceValueInLeaderboard());
    }

    public boolean isTournamentPrizeValueInLeaderboardExist() {
        SwipeDownInPanelUntilFound(getTournamentPrizeValueInLeaderboard());
        return tryDisplayed(getTournamentPrizeValueInLeaderboard());
    }

    public boolean isUpcomingTournamentsExist() {
        SwipeDownInPanelUntilFound(getUpcomingTournaments());
        return tryDisplayed(getUpcomingTournaments());
    }

    public boolean isUserPlaceValueExist() {
        SwipeDownInPanelUntilFound(getUserPlaceValue());
        return tryDisplayed(getUserPlaceValue());
    }

    public boolean isRebuyCostExist() {
        SwipeDownInPanelUntilFound(getRebuyCostValue());
        return tryDisplayed(getRebuyCostValue()) && tryDisplayed(getRebuyCostLabel());
    }

    public boolean isBalanceValueHighlightedExist() {
        return tryDisplayed(getBalanceValue()) && tryDisplayed(getBalanceLabel());
    }

    public boolean isPrizeValueHighlightedExist() {
        return tryDisplayed(getPrizeValue()) && tryDisplayed(getPrizeLabel());
    }

    public boolean isLeaderBoardExist() {
        SwipeDownInPanelUntilFound(getLeaderBoardLabel());
        return tryDisplayed(getLeaderBoardLabel()) && tryDisplayed(getLeaderBoardContainer());
    }

    public boolean isTournamentPrizesExist() {
        SwipeDownInPanelUntilFound(getTournamentPrizesLabel());
        return tryDisplayed(getTournamentPrizesLabel());
    }

    public boolean isTournamentConditionsDescriptionExist() {
        SwipeDownInPanelUntilFound(getTournamentConditions());
        return tryDisplayed(getTournamentConditionsDescription()) && tryDisplayed(getTournamentConditions());
    }

    public boolean isSignUpTournamentButtonExist() {
        return tryDisplayed(getSignUpTournamentButton());
    }

    public boolean isOpenTournamentButton() {
        return tryDisplayed(getOpenTournamentButton());
    }

    public boolean isBackButtonExists() {
        return tryDisplayed(getBackButton());
    }

    public String getSignUpTournamentButtonText() {
        return tryGetText(getSignUpTournamentButton());
    }

}
