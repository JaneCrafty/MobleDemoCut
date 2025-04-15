package com.example.broker.common.toggle

import com.example.broker.common.featureflags.FeatureFlag

open class BrokerBetaFeatureToggle : CommonFeatureToggle() {

    private val horizontalTraderoomFeatureFlag = FeatureFlag(
            title = "Traderoom orientation: horizontal",
            isEnabled = isHorizontalTraderoomInitiallyEnabled(),
    )
    private val verticalTraderoomFeatureFlag = FeatureFlag(
            title = "Traderoom orientation: vertical",
            isEnabled = isVerticalTraderoomInitiallyEnabled(),
    )
    private val hallOfFameFeatureFlag = FeatureFlag(
            title = "Hall of fame",
            isEnabled = isHallOfFameInitiallyEnabled(),
    )
    private val horizontalAuthorizationFeatureFlag = FeatureFlag(
            title = "Authorization orientation: horizontal",
            isEnabled = isHorizontalAuthorizationInitiallyEnabled(),
    )
    private val verticalAuthorizationFeatureFlag = FeatureFlag(
            title = "Authorization orientation: vertical",
            isEnabled = isVerticalAuthorizationInitiallyEnabled(),
    )
    private val educationForFreeStatusFeatureFlag = FeatureFlag(
            title = "Education for free status",
            isEnabled = isEducationForFreeStatusInitiallyEnabled(),
    )
    private val nativeCashierForDepositFeatureFlag = FeatureFlag(
            title = "Native cashier for deposit",
            isEnabled = isNativeCashierForDepositInitiallyEnabled(),
    )
    private val welcomeStoriesFeatureFlag = FeatureFlag(
            title = "Welcome stories",
            isEnabled = isWelcomeStoriesInitiallyEnabled(),
    )

    protected open fun isHorizontalTraderoomInitiallyEnabled(): Boolean = true
    protected open fun isVerticalTraderoomInitiallyEnabled(): Boolean = true
    protected open fun isHallOfFameInitiallyEnabled(): Boolean = false
    protected open fun isHorizontalAuthorizationInitiallyEnabled(): Boolean = false
    protected open fun isVerticalAuthorizationInitiallyEnabled(): Boolean = true
    protected open fun isEducationForFreeStatusInitiallyEnabled(): Boolean = false
    protected open fun isNativeCashierForDepositInitiallyEnabled(): Boolean = true
    protected open fun isWelcomeStoriesInitiallyEnabled(): Boolean = true

    override fun isTournamentsEnabledForFreeStatus(): Boolean = TOURNAMENTS_FOR_FREE_STATUS_FEATURE.isEnabled
    override fun isHorizontalTraderoomEnabled(): Boolean = horizontalTraderoomFeatureFlag.isEnabled
    override fun isVerticalTraderoomEnabled(): Boolean = verticalTraderoomFeatureFlag.isEnabled
    override fun isStandardEnabled(): Boolean = STANDARD.isEnabled
    override fun isBlitzEnabled(): Boolean = BLITZ.isEnabled
    override fun isCfdEnabled(): Boolean = CFD.isEnabled
    override fun isCfdCurrencyEnabled(): Boolean = CFD_CURRENCY_ASSETS.isEnabled
    override fun isCryptoAssetsEnabled(): Boolean = CRYPTO_ASSETS.isEnabled
    override fun isEducationEnabledForFreeStatus(): Boolean = educationForFreeStatusFeatureFlag.isEnabled
    override fun isChampionshipEnabledForFreeStatus(): Boolean = CHAMPIONSHIP_FOR_FREE_STATUS.isEnabled
    override fun isPromotionEnabledForFreeStatus(): Boolean = PROMOTION_FOR_FREE_STATUS.isEnabled
    override fun isTopTradersEnabled(): Boolean = TOP_TRADERS.isEnabled
    override fun isNativeCashierEnabled(): Boolean = nativeCashierForDepositFeatureFlag.isEnabled
    override fun isChampionshipEnabled(): Boolean = CHAMPIONSHIP_ENABLED.isEnabled
    override fun isWelcomeStoriesEnabled(): Boolean = welcomeStoriesFeatureFlag.isEnabled
    override fun isHorizontalAuthorizationEnabled(): Boolean = horizontalAuthorizationFeatureFlag.isEnabled
    override fun isVerticalAuthorizationEnabled(): Boolean = verticalAuthorizationFeatureFlag.isEnabled
    override fun isTrialAbTestEnabled(): Boolean = TRIAL_AB_TEST_ENABLED.isEnabled
    override fun isDealDetailEnabled(): Boolean = DEAL_DETAIL_HISTORY_ENABLED.isEnabled
    override fun isTradingSignalsEnabledForFreeStatus(): Boolean = TRADING_SIGNALS_FOR_FREE_STATUS.isEnabled
    override fun isHallOfFameEnabled(): Boolean = hallOfFameFeatureFlag.isEnabled
    override fun isRepeatDepositAbTestEnabled(): Boolean = REPEAT_DEPOSIT_AB_TEST_ENABLED.isEnabled

    companion object {

        private val TOURNAMENTS_FOR_FREE_STATUS_FEATURE = FeatureFlag(
                title = "Tournaments for free status",
                isEnabled = false,
        )
        private val STANDARD = FeatureFlag(
                title = "Standard trading mechanic",
                isEnabled = true,
        )
        private val BLITZ = FeatureFlag(
                title = "Blitz deals",
                isEnabled = true,
        )
        private val CFD = FeatureFlag(
                title = "CFD trading mechanic",
                isEnabled = true,
        )
        private val CFD_CURRENCY_ASSETS = FeatureFlag(
                title = "CFD Currency trading",
                isEnabled = true,
        )
        private val CRYPTO_ASSETS = FeatureFlag(
                title = "Crypto assets",
                isEnabled = true,
        )
        private val CHAMPIONSHIP_FOR_FREE_STATUS = FeatureFlag(
                title = "Championship for free status",
                isEnabled = false,
        )
        private val PROMOTION_FOR_FREE_STATUS = FeatureFlag(
                title = "Promotion for free status",
                isEnabled = false,
        )
        private val TOP_TRADERS = FeatureFlag(
                title = "Top-20 Traders",
                isEnabled = true,
        )
        private val CHAMPIONSHIP_ENABLED = FeatureFlag(
                title = "Championship",
                isEnabled = false,
        )
        private val TRIAL_AB_TEST_ENABLED = FeatureFlag(
                title = "Trial demo AB-test",
                isEnabled = false,
        )
        private val DEAL_DETAIL_HISTORY_ENABLED = FeatureFlag(
                title = "Deal detail history",
                isEnabled = false,
        )
        private val TRADING_SIGNALS_FOR_FREE_STATUS = FeatureFlag(
                title = "Trading signals for free status",
                isEnabled = false,
        )
        private val REPEAT_DEPOSIT_AB_TEST_ENABLED = FeatureFlag(
                title = "Repeat deposit AB-test",
                isEnabled = false,
        )
        private val CALENDAR_ENABLED = FeatureFlag(
                title = "Calendar",
                isEnabled = true,
        )
    }
}
