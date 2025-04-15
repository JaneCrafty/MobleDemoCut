package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class ChatPanel extends BaseElements {

    public abstract MobileElement getChatPanel();

    public abstract MobileElement getMessageLayout();

    public abstract MobileElement getInputMessage();

    public abstract MobileElement getSendMessageButton();

    public abstract MobileElement getChatNavigateBackButton();

    public abstract MobileElement getUserId();

    public abstract PanelUserMenu clickNavigateUpButton();


    public ChatPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public ChatPanel checkChatPanel() {
        getWait().withMessage("Chat panel is not displayed").until(d ->
                isDisplayed(getChatPanel()));
        return this;
    }

    public ChatPanel checkMessageLayout() {
        getWait().withMessage("Message layout is not displayed").until(d ->
                isDisplayed(getMessageLayout()));
        return this;
    }

    public boolean isNavigateUpButtonExists() {
        return tryDisplayed(getChatNavigateBackButton());
    }

    public boolean isMessageFieldDisplayed() {
        return tryDisplayed(getInputMessage());
    }

    public boolean isSendMessageButtonDisplayed() {
        return tryDisplayed(getSendMessageButton());
    }

    public boolean isUserIDExists() {
        return tryDisplayed(getUserId());
    }

    public String getTextUserID() {
        return tryGetText(getUserId()).replaceAll("[^0-9]", "");
    }

    public String getInputMessageText() {
        return tryGetText(getInputMessage());
    }
}
