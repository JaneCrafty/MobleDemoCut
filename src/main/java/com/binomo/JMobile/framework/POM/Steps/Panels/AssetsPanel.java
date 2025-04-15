package com.example.JMobile.framework.POM.Steps.Panels;

import com.example.JMobile.framework.Enums.MsgFactory;
import com.example.JMobile.framework.Enums.Titles;
import com.example.JMobile.framework.POM.Steps.BaseElements;
import com.example.JMobile.framework.POM.Steps.Pages.TradingPage;
import com.example.JMobile.framework.driver.MobileDriver;
import io.appium.java_client.MobileElement;

public abstract class AssetsPanel extends BaseElements {

    protected abstract MobileElement getLevOneAssetElement();

    protected abstract MobileElement getAddToFavoritesLevOneAssetButton();

    protected abstract MobileElement getAssetsSelectorLayout();

    protected abstract MobileElement getAssetsMenuHeader();

    protected abstract MobileElement getBOStandardFTTAssetsItem();

    protected abstract MobileElement getBlitzAssetsItem();

    protected abstract MobileElement getCFDAssetsItem();

    protected abstract MobileElement getRecentAssetsItem();

    protected abstract MobileElement getFavouritesAssetsItem();

    protected abstract MobileElement getBecomeVipButton();

    protected abstract MobileElement getStatusItem();

    protected abstract MobileElement getFirstAssetIconElement();

    protected abstract MobileElement getFirstAssetNameElement();

    protected abstract MobileElement getFirstAssetRateTurboElement();

    protected abstract MobileElement getFirstAssetRateBinaryElement();

    protected abstract MobileElement getFirstAssetAddFavouriteElement();

    protected abstract MobileElement getProvocationPopUp();

    protected abstract MobileElement getProvocationPopUpIcon();

    protected abstract MobileElement getProvocationPopUpTextElement();

    protected abstract MobileElement getProvocationPopUpUpgradeButton();

    protected abstract MobileElement getBlitzBottomSheet();

    protected abstract MobileElement getBottomSheetHeader();

    protected abstract MobileElement getBottomSheetContent();

    protected abstract MobileElement getBottomSheetGreatButton();

    protected abstract MobileElement getWillBeAvailableElement();

    public abstract TradingPage selectZarOstAsset();

    public abstract TradingPage selectLevOneAsset();

    public abstract TradingPage selectBinaryZarOstAsset();

    public abstract TradingPage selectCFDEurUsdAsset();

    public abstract TradingPage selectEurUsdAsset();

    public abstract TradingPage selectEurGbpAsset();

    public abstract TradingPage selectAudUsdAsset();

    public abstract TradingPage selectAppleAsset();

    public abstract TradingPage selectNzdUsdAsset();

    public abstract TradingPage selectAudJpyAsset();

    public abstract StatusesPanel clickBecomeVipButton();

    public abstract StatusesPanel clickProvocationUpgradeButton();


    public AssetsPanel(MobileDriver mobileDriver) {
        super(mobileDriver);
    }


    public boolean isAssetsListOpen() {
        return tryDisplayed(getAssetsSelectorLayout());
    }

    public boolean isBOStandardFTTAssetsItemExists() {
        return tryDisplayed(getBOStandardFTTAssetsItem());
    }

    public boolean isBlitzAssetsItemExists() {
        return tryDisplayed(getBlitzAssetsItem());
    }

    public boolean isCFDAssetsItemExists() {
        return tryDisplayed(getCFDAssetsItem());
    }

    public boolean isRecentAssetsItemExists() {
        return tryDisplayed(getRecentAssetsItem());
    }

    public boolean isFavouritesAssetsItemExists() {
        return tryDisplayed(getFavouritesAssetsItem());
    }

    public boolean isBecomeVipButtonExists() {
        return tryDisplayed(getBecomeVipButton());
    }

    public boolean isStatusItemExists() {
        return tryDisplayed(getStatusItem());
    }

    public boolean isFirstAssetIconElementExists() {
        return tryDisplayed(getFirstAssetIconElement());
    }

    public boolean isFirstAssetNameElementExists() {
        return tryDisplayed(getFirstAssetNameElement());
    }

    public boolean isFirstAssetRateTurboElementExists() {
        return tryDisplayed(getFirstAssetRateTurboElement());
    }

    public boolean isFirstAssetRateBinaryElementExists() {
        return tryDisplayed(getFirstAssetRateBinaryElement());
    }

    public boolean isFirstAssetAddFavouriteElementExists() {
        return tryDisplayed(getFirstAssetAddFavouriteElement());
    }

    public boolean isWillBeAvailableExists() {
        SwipeDownInPanelUntilFound(getWillBeAvailableElement());
        return tryDisplayed(getWillBeAvailableElement());
    }

    public boolean isProvocationPopUpExists() {
        return tryDisplayed(getProvocationPopUp());
    }

    public boolean isProvocationPopUpIconExists() {
        return tryDisplayed(getProvocationPopUpIcon());
    }

    public boolean isProvocationPopUpTextExists() {
        return tryDisplayed(getProvocationPopUpTextElement());
    }

    public boolean isProvocationPopUpUpgradeButtonExists() {
        return tryDisplayed(getProvocationPopUpUpgradeButton());
    }

    public boolean isProvocationPopUpCloseButtonExists() {
        return tryDisplayed(getCloseButton());
    }

    public boolean isBlitzBottomSheetExists() {
        return tryDisplayed(getBlitzBottomSheet());
    }

    public boolean isAssetsListMissing() {
        return isElementMissing(getAssetsSelectorLayout());
    }

    public boolean isProvocationPopUpMissing() {
        return isElementMissing(getProvocationPopUp());
    }

    public boolean isBecomeVipButtonMissing() {
        return isElementMissing(getBecomeVipButton());
    }

    public boolean isFirstAssetRateBinaryElementMissing() {
        return isElementMissing(getFirstAssetRateBinaryElement());
    }

    public boolean isFirstAssetRateTurboElementMissing() {
        return isElementMissing(getFirstAssetRateTurboElement());
    }

    public boolean isFirstAssetAddFavouriteElementMissing() {
        return isElementMissing(getFirstAssetAddFavouriteElement());
    }

    public boolean isOneLevAssetAddedToFavourites() {
        return getRecentAssetName().equals(MsgFactory.getMessage(Titles.ONE_LEV_ASSET_NAME));
    }

    public String getCurrentFirstAssetName() {
        return tryGetText(getFirstAssetNameElement());
    }

    public String getRecentAssetName() {
        return tryGetText(getFirstAssetNameElement());
    }

    public String getAssetsMenuHeaderText() {
        return tryGetText(getAssetsMenuHeader());
    }

    public String getProvocationPopUpText() {
        return tryGetText(getProvocationPopUpTextElement());
    }

    public String getBottomSheetHeaderText() {
        return tryGetText(getBottomSheetHeader());
    }

    public String getBottomSheetContentText() {
        return tryGetText(getBottomSheetContent());
    }

    public AssetsPanel clickCloseProvocationPopUpButton() {
        tryClick(getCloseButton());
        return this;
    }

    public void goToRecent() {
        tryClick(getRecentAssetsItem());
    }

    public void goToBOStandardFTT() {
        tryClick(getBOStandardFTTAssetsItem());
    }

    public AssetsPanel goToBlitz() {
        tryClick(getBlitzAssetsItem());
        return this;
    }

    public void goToCFD() {
        tryClick(getCFDAssetsItem());
    }

    public void addOneLevAssetToFavourites() {
        customDownSwipe(200);
        SwipeDownInPanelUntilFound(getLevOneAssetElement());
        tryClick(getAddToFavoritesLevOneAssetButton());
        SwipeUpInPanelUntilFound(getLevOneAssetElement());
        customUpSwipe(200);
    }

    public void swipeDownForHidingProvocation() {
        customDownSwipe(300);
    }

    public void swipeUpForRevealingProvocation() {
        customUpSwipe(300);
    }

}
