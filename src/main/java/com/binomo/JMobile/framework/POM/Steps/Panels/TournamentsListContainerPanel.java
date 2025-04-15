package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import com.google.common.base.Stopwatch;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class TournamentsListContainerPanel extends BaseElements {

    protected abstract MobileElement getAvailableTournamentsList();

    protected abstract MobileElement getParticipatingTournamentsList();

    public abstract TournamentsListContainerPanel checkTournamentsListContainerPanel();

    public abstract TournamentCardContainerPanel clickFirstAvailableTournament();

    public abstract TournamentCardContainerPanel clickThirtyMinuteTournament();

    public abstract TournamentCardContainerPanel clickPaidStartedTournament();

    public abstract TournamentCardContainerPanel clickPaidTournamentNotStarting();

    public abstract TournamentCardContainerPanel clickFirstParticipatingTournament();


    public TournamentsListContainerPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isAvailableTournamentsListExists() {
        return tryDisplayed(getAvailableTournamentsList());
    }

    public boolean isParticipatingTournamentsListExists() {
        SwipeDownInPanelUntilFound(getParticipatingTournamentsList());
        return tryDisplayed(getParticipatingTournamentsList());
    }

    protected void availableTournamentsListLeftHorizontalSwipe(MobileElement element) {

        Stopwatch stopwatch = Stopwatch.createStarted();
        int y = getAvailableTournamentsList().getCenter().getY();

        Dimension dimensions = mobileDriver.getDriver().manage().window().getSize();
        int screenWidth = dimensions.getWidth();
        int left_x = (int) (screenWidth * 0.15);
        int right_x = (int) (screenWidth * 0.90);

        TouchAction action = new TouchAction(mobileDriver.getDriver());

        while (!isEnabled(element) && stopwatch.elapsed(TimeUnit.SECONDS) < 90) {
            action
                    .press(PointOption.point(right_x, y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(left_x, y));
            action
                    .release()
                    .perform();
        }

        stopwatch.stop();
    }

}
