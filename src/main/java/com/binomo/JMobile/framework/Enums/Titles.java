package com.example.JMobile.framework.Enums;

public enum Titles {
    ACTIVE_DEALS_PANEL_TITLE("Open trades", "Открытые сделки"),
    CLOSED_DEALS_PANEL_TITLE("Closed trades", "Закрытые сделки"),
    TOURNAMENTS_PANEL_TITLE("Tournaments", "Турниры"),
    GIFTS_PANEL_TITLE("Gifts", "Подарки"),
    FAQ_PANEL_TITLE("Questions and answers", "Вопросы и ответы"),

    DEPOSIT_CASHIER_PAGE_TITLE("Deposits", "Внесение средств"),
    WITHDRAWAL_CASHIER_PAGE_TITLE("Withdraw funds", "Вывод средств"),
    VERIFICATION_PAGE_TITLE("Account verification", "Подтверждение аккаунта"),
    SUPPORT_PAGE_TITLE("Chat", "Чат"),
    TRANSACTIONS_HISTORY_PAGE("Transactions history", "История операций "),
    HELP_CENTER_CONCLUDING_TRADES_ARTICLE("How to open a trade?", ""),

    INSUFFICIENT_FUNDS_POPUP_TITLE("Not enough funds", "Недостаточно средств на счете"),
    INSUFFICIENT_FUNDS_POPUP_MESSAGE("Unfortunately, you've run out of funds. Make a deposit to continue trading", "Внесите депозит, чтобы продолжить торговлю."),

    INSUFFICIENT_FUNDS_IOS_POPUP_TITLE("Insufficient funds. Fund account to conclude trading.", "Недостаточно средств на счете"),
    INSUFFICIENT_FUNDS_IOS_POPUP_MESSAGE("Deposit", "Внесите депозит, чтобы продолжить торговлю."),

    WELCOME_BONUS_POPUP_HEADER("Welcome bonus", "Бонус"),
    WELCOME_BONUS_PAGE_TITLE("Special offer", "Специальное предложение"),
    SUCCESSFUL_REPLENISH_POPUP("Balance successfully replenished", ""),

    CHOOSE_PAYMENT_METHOD_TITLE("Choose deposit method", ""),
    VISA_MC_MAESTRO_TITLE("VISA / MASTERCARD / MAESTRO!!",""),
    REQUEST_WITHDRAWAL_TITLE("Request withdrawal", ""),
    CHOOSE_AMOUNT_TITLE("Choose amount", ""),
    WITHDRAWAL_REQUEST_SENT_TITLE("Your request is being verified", ""),

    BALANCE_CONTAINER_TITLE("Balance", ""),
    ASSETS_CONTAINER_TITLE("Asset", ""),
    BONUSES_CONTAINER_TITLE("Bonuses", ""),
    HELP_CONTAINER_TITLE("Help", ""),
    TOP_TRADERS_CONTAINER_TITLE("Top traders", ""),
    SUPPORT_CONTAINER_TITLE("Support", ""),
    SETTINGS_CONTAINER_TITLE("Settings", ""),
    TRADES_CONTAINER_TITLE("Trades", ""),
    TOURNAMENTS_CONTAINER_TITLE("Tournaments", ""),
    ACCOUNTS_CONTAINER_TITLE("Account types", ""),
    INDICATORS_CONTAINER_TITLE("Indicators", ""),
    SIMPLE_MOVING_AVERAGE_INDICATOR_TITLE("Simple moving average", ""),
    SOCIAL_TRADING_INDICATOR_TITLE("Social Trading", ""),
    MOVING_AVERAGE_INDICATOR_TITLE("Moving Average", ""),
    EXPONENTIAL_MOVING_AVERAGE_INDICATOR_TITLE("Exponential moving average", ""),
    ALLIGATOR_INDICATOR_TITLE("Alligator", ""),
    BOLLINGER_INDICATOR_TITLE("Bollinger Bands", ""),
    SAR_INDICATOR_TITLE("Parabolic SAR", ""),
    FRACTALS_INDICATOR_TITLE("Fractals", ""),
    FRACTAL_CHAOS_BANDS_INDICATOR_TITLE("Fractal Chaos Bands", ""),
    RELATIVE_STRENGTH_INDEX_TITLE("RSI", ""),
    MACD_INDICATOR_TITLE("MACD", ""),
    CCI_INDICATOR_TITLE("CCI", ""),
    STOCHASTIC_INDICATOR_TITLE("Stochastic", ""),
    ADX_INDICATOR_TITLE("ADX", ""),
    ATR_INDICATOR_TITLE("ATR", ""),
    DEPOSIT_DIDNT_WORK_POPUP("Deposit didn't work?", ""),
    UNCOMPLETED_PAYMENT_HEADER("Deposit didn't work?", ""),
    UNCOMPLETED_PAYMENT_MESSAGE("Need help making deposit? Please contact support", ""),

    CFD_TRADING_TOOL("CFD", ""),
    STANDARD_TRADING_TOOL("Standard", ""),
    CFD_IOS_TRADING_ASSET("EUR/USD", ""),
    ONE_LEV_ASSET_NAME("ONE/LEV", ""),
    ZAR_OST_ASSET_NAME("ZAR/OST", ""),
    EUR_GBP_ASSET_NAME("EUR/GBP", ""),
    GBP_JPY_ASSET_NAME("GBP/JPY", ""),
    APPLE_ASSET_NAME("Apple", ""),
    NZD_USD_ASSET_NAME("NZD/USD", ""),

    CLIENT_AGREEMENT("Client Agreement", ""),
    PRIVACY_POLICY("Privacy Policy", ""),
    SUMSUB_DOCS_VERIFICATION_TITLE("Verification", ""),
    DEMO_BALANCE_ORIGIN_AMOUNT_USD("$1,000.00", ""),
    DEMO_BALANCE_ORIGIN_AMOUNT_EUR("€1,000.00", ""),
    DEMO_BALANCE_ORIGIN_AMOUNT("1000.00", ""),
    SUMSUB_VERIFICATION_AMOUNT("$400.00", "");

    private final String _en;
    private final String _ru;

    Titles(String en, String ru) {
        _en = en;
        _ru = ru;
    }

    public String getEN() {
        return _en;
    }

    public String getRU() {
        return _ru;
    }
}

