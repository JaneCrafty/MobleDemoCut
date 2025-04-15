package com.example.JMobile.framework.POM.PagesIOS.PopUps;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.PagesIOS.Pages.TradingPageIOS;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.POM.Steps.PopUps.RegistrationTournamentPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationTournamentPopUpIOS extends RegistrationTournamentPopUp {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Close']/following-sibling::XCUIElementTypeOther//XCUIElementTypeImage")
    private IOSElement _tournamentImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment required']")
    private IOSElement _tournamentModalHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Open']")
    private IOSElement _openTournamentButton;


    public RegistrationTournamentPopUpIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getTournamentImage() { return _tournamentImage; }

    public IOSElement getTournamentModalHeader() { return _tournamentModalHeader; }

    public AndroidElement getStartTournamentImage() { return null; }

    public AndroidElement getStartTournamentModalHeader() { return null; }

    public AndroidElement getStartTournamentModalDescription() { return null; }

    public IOSElement getOpenTournamentButton() { return _openTournamentButton; }


    public TradingPage clickStartTournamentButton() {
        tryClick(getOpenTournamentButton());
        return new TradingPageIOS(mobileDriver);
    }
}
