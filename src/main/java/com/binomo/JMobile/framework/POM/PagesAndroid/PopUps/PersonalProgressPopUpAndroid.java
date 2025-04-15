package com.example.JMobile.framework.POM.PagesAndroid.PopUps;

import com.example.JMobile.framework.Helpers.AndroidAnnotationHelper;
import com.example.JMobile.framework.POM.Steps.Panels.StatusesPanel;
import com.example.JMobile.framework.POM.Steps.PopUps.PersonalProgressPopUp;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PersonalProgressPopUpAndroid extends PersonalProgressPopUp {

    @AndroidFindBy(id = "nextStatusProgressRoot")
    private AndroidElement _personalProgressView;

    @AndroidFindBy(id = "headerTitle")
    private AndroidElement _personalProgressHeader;

    @AndroidFindBy(id = "statusIcon")
    private AndroidElement _currentStatusIcon;

    @AndroidFindBy(id = "labelText")
    private AndroidElement _yourStatusHeader;

    @AndroidFindBy(id = "contentText")
    private AndroidElement _currentStatusValue;

    @AndroidFindBy(id = "progressValue")
    private AndroidElement _progressBarToNextStatus;

    @AndroidFindBy(id = "progressText")
    private AndroidElement _amountToNextStatus;

    @AndroidFindBy(id = "advantagesButton")
    private AndroidElement _statusBenefitsButton;

    @AndroidFindBy(id = "statusAdvantages")
    private AndroidElement _statusAdvantagesItem;

    @AndroidFindBy(id = "icon")
    private AndroidElement _statusAdvantagesIcon;

    @AndroidFindBy(id = "title")
    private AndroidElement _statusAdvantagesTitle;

    @AndroidFindBy(id = "description")
    private AndroidElement _statusAdvantagesDescription;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.example.broker.beta:id/upgradeButton' and @text='Upgrade']")
    private AndroidElement _upgradeButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.example.broker.beta:id/upgradeButton' and @text='Join']")
    private AndroidElement _joinButton;

    @AndroidFindBy(id = "touch_outside")
    private AndroidElement _touchOutside;


    public PersonalProgressPopUpAndroid(MobileDriver mobileDriver) {
        super(mobileDriver);
        AndroidAnnotationHelper.setUpAndroidIds(mobileDriver, this);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }


    public AndroidElement getPersonalProgressView() { return _personalProgressView; }

    public AndroidElement getPersonalProgressHeader() { return _personalProgressHeader; }

    public AndroidElement getCurrentStatusIcon() { return _currentStatusIcon; }

    public AndroidElement getYourStatusHeader() { return _yourStatusHeader; }

    public AndroidElement getCurrentStatusValue() { return _currentStatusValue; }

    public AndroidElement getProgressBarToNextStatus() { return _progressBarToNextStatus; }

    public AndroidElement getAmountToNextStatus() { return _amountToNextStatus; }

    public AndroidElement getStatusBenefitsButton() { return _statusBenefitsButton; }

    public AndroidElement getStatusAdvantagesItem() { return _statusAdvantagesItem; }

    public AndroidElement getStatusAdvantagesIcon() { return _statusAdvantagesIcon; }

    public AndroidElement getStatusAdvantagesTitle() { return _statusAdvantagesTitle; }

    public AndroidElement getStatusAdvantagesDescription() { return _statusAdvantagesDescription; }

    public AndroidElement getUpgradeButton() { return _upgradeButton; }

    public AndroidElement getJoinButton() { return _joinButton; }


    public StatusesPanel clickStatusBenefitsButton() {
        tryClick(_statusBenefitsButton);
        return new StatusesPanelAndroid(mobileDriver);
    }

    public CashierDepositPage clickUpgradeStatusButton() {
        tryClick(_upgradeButton);
        return new CashierDepositPageAndroid(mobileDriver);
    }

    @Override
    public NativeCashierDepositPageAndroid clickUpgradeStatusNativeButton() {
        tryClick(_upgradeButton);
        return new NativeCashierDepositPageAndroid(mobileDriver);
    }
}
