package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class TopTradersPanel extends BaseElements {

    public abstract MobileElement getTopTradersPanel();

    public abstract MobileElement getTopTradersPanelTitle();

    public abstract MobileElement getFirstParagraphOfDescription();

    public abstract MobileElement getSecondParagraphOfDescription();

    public abstract MobileElement getProfitSubtitle();

    public abstract MobileElement getFlagInUserInfo();

    public abstract MobileElement getNicknameInUserInfo();

    public abstract MobileElement getProfitInUserInfo();

    public abstract MobileElement getTopListTitle();

    public abstract MobileElement getTopListUpdateTime();

    public abstract MobileElement getPositionInTopList();

    public abstract MobileElement getFlagInTopList();

    public abstract MobileElement getNicknameInTopList();

    public abstract MobileElement getProfitInTopList();


    public TopTradersPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public TopTradersPanel checkTopTradersPanel() {
        getWait().withMessage("Top traders panel is not displayed").until(d ->
                isDisplayed(getTopTradersPanel()));
        return this;
    }

    public boolean isBackButtonExists() {
        return tryDisplayed(getBackButton());
    }

    public boolean isFlagInUserInfoExists() {
        return tryDisplayed(getFlagInUserInfo());
    }

    public boolean isFlagInTopListExists() {
        return tryDisplayed(getFlagInTopList());
    }

    public String getTopTradersPanelTitleText() {
        return tryGetText(getTopTradersPanelTitle());
    }

    public String getFirstParagraphOfDescriptionText() {
        return tryGetText(getFirstParagraphOfDescription());
    }

    public String getSecondParagraphOfDescriptionText() {
        return tryGetText(getSecondParagraphOfDescription());
    }

    public String getProfitSubtitleText() {
        return tryGetText(getProfitSubtitle());
    }

    public String getNicknameInUserInfoText() {
        return tryGetText(getNicknameInUserInfo());
    }

    public String getProfitInUserInfoText() {
        return tryGetText(getProfitInUserInfo());
    }

    public String getTopListTitleText() {
        return tryGetText(getTopListTitle());
    }

    public String getTopListUpdateTimeText() {
        return tryGetText(getTopListUpdateTime());
    }

    public String getPositionInTopListText() {
        return tryGetText(getPositionInTopList());
    }

    public String getNicknameInTopListText() {
        return tryGetText(getNicknameInTopList());
    }

    public String getProfitInTopListText() {
        return tryGetText(getProfitInTopList());
    }
}
