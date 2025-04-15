package com.example.JMobile.framework.POM.PagesIOS.PopUps;

import com.example.JMobile.framework.Helpers.IosAnnotationHelper;
import com.example.JMobile.framework.POM.Steps.Panels.StatusesPanel;
import com.example.JMobile.framework.POM.Steps.PopUps.PersonalProgressPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.support.PageFactory;

public class PersonalProgressPopUpIOS extends PersonalProgressPopUp {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Personal progress']")
    private IOSElement _personalProgressView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Personal progress']")
    private IOSElement _personalProgressHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your status']/preceding-sibling::XCUIElementTypeImage")
    private IOSElement _currentStatusIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your status']")
    private IOSElement _yourStatusHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Your status']/following-sibling::XCUIElementTypeStaticText")
    private IOSElement _currentStatusValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@text, 'until') and contains(@text, 'status')]/preceding-sibling::XCUIElementTypeOther")
    private IOSElement _progressBarToNextStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@text, 'until') and contains(@text, 'status')]")
    private IOSElement _amountToNextStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Status benefits']")
    private IOSElement _statusBenefitsButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Personal progress']/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    private IOSElement _statusAdvantagesItem;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Upgrade']/preceding-sibling::XCUIElementTypeImage")
    private IOSElement _statusAdvantagesIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get access to private tournaments']")
    private IOSElement _statusAdvantagesTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Get access to private tournaments']/following-sibling::XCUIElementTypeStaticText")
    private IOSElement _statusAdvantagesDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Upgrade']")
    private IOSElement _upgradeButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Join']")
    private IOSElement _joinButton;

    @iOSXCUITFindBy(accessibility = "CardDismissView")
    private IOSElement _touchOutside;


    public PersonalProgressPopUpIOS(MobileDriver mobileDriver) {
        super(mobileDriver);
        IosAnnotationHelper.setUpIosIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public IOSElement getPersonalProgressView() { return _personalProgressView; }

    public IOSElement getPersonalProgressHeader() { return _personalProgressHeader; }

    public IOSElement getCurrentStatusIcon() { return _currentStatusIcon; }

    public IOSElement getYourStatusHeader() { return _yourStatusHeader; }

    public IOSElement getCurrentStatusValue() { return _currentStatusValue; }

    public IOSElement getProgressBarToNextStatus() { return _progressBarToNextStatus; }

    public IOSElement getAmountToNextStatus() { return _amountToNextStatus; }

    public IOSElement getStatusBenefitsButton() { return _statusBenefitsButton; }

    public IOSElement getStatusAdvantagesItem() { return _statusAdvantagesItem; }

    public IOSElement getStatusAdvantagesIcon() { return _statusAdvantagesIcon; }

    public IOSElement getStatusAdvantagesTitle() { return _statusAdvantagesTitle; }

    public IOSElement getStatusAdvantagesDescription() { return _statusAdvantagesDescription; }

    public IOSElement getUpgradeButton() { return _upgradeButton; }

    public IOSElement getJoinButton() { return _joinButton; }


    public StatusesPanel clickStatusBenefitsButton() {
        tryClick(_statusBenefitsButton);
        return new StatusesPanelIOS(mobileDriver);
    }

    public CashierDepositPage clickUpgradeStatusButton() {
        tryClick(_upgradeButton);
        return new CashierDepositPageIOS(mobileDriver);
    }

    @Override
    public NativeCashierDepositPageAndroid clickUpgradeStatusNativeButton() {
        throw new NotImplementedException("Not implemented for iOS");
    }
}
