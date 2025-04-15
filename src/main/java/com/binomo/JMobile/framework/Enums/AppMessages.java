package com.example.JMobile.framework.Enums;

public enum AppMessages implements Messages {
    RESET_PASSWORD("Temporary link to change password emailed to you",
            "Письмо с временной ссылкой для смены пароля выслано на ваш email"),
    RESET_PASSWORD_IOS("Link to change password emailed to you",
            "Письмо с временной ссылкой для смены пароля выслано на ваш email"),
    REGISTRATION_WARNING("Please accept agreement to sign up", ""),
    BLACK_THEME_REGISTRATION_AGREEMENT("By signing up, I confirm being an adult and accept the Client Agreement and Privacy Policy terms", ""),
    TEXT_FIELDS_INPUT_EMPTY("Required field", ""),
    TEXT_EMAIL_FIELD_INPUT_ERROR("Incorrect E-mail address", ""),
    TEXT_PASSWORD_FIELD_INPUT_ERROR("Entered password is incorrect", ""),
    WITHDRAWAL_REFILL_FIRST_WARNING("You can withdraw funds only to the card or wallet that was used to credit funds to your balance.",
            "Вы можете вывести средства только на карту или кошелек, которые использовали для зачисления средств на ваш баланс."),
    WITHDRAWAL_TRANSACTION_STATUS_PROCESSING_MESSAGE("Processing", "В обработке"),
    WITHDRAWAL_TRANSACTION_STATUS_CANCELLED_MESSAGE("Canceled", ""),
    REJECTED_WITHDRAWAL_STATUS("Rejected", ""),
    WITHDRAWAL_TRANSACTION_IS_VERIFIED_MESSAGE("Your withdrawal request is being verified. After that it will be sent to the payment provider. Verification will be completed within 4 hours", ""),
    UNREGISTERED_EMAIL_PASSWORD_RECOVERY("We've emailed you a link for changing the password.", ""),
    EMAIL_ALREADY_REGISTERED("This email cannot be used", ""),
    SHORT_PASSWORD("Must contain at least 3 symbols", ""),
    AUTO_SCALING("Auto-scaling", ""),
    CHAT_AGENT_MESSAGE("Greetings! Please ask anything and we will be happy to help.", ""),
    VERIFICATION_REQUIRED("Verification required", ""),
    VERIFICATION_COMPLETED("You're a verified example Beta trader!", ""),
    PENDING_TRANSACTION_STATUS_INDIAN_EXCHANGER("Please contact Indian Exchanger to complete the payment", ""),
    ONGOING_DEAL_ALERT_BEFORE_DELETING_ACCOUNT("Close all trades before deleting account", ""),
    FUNDS100_ALERT_MESSAGE_BEFORE_DELETING_ACCOUNT("There is $100.00 left in your account. If you delete the account now, you’ll lose access to the funds", ""),
    BEFORE_DELETING_ACCOUNT_REASON_MESSAGE("Please tell us why you decided to leave example Beta", ""),
    BEFORE_DELETING_ACCOUNT_MESSAGE("Type in your password to confirm deletion. After that, you’ll be logged out", ""),
    ACCOUNT_DELETED_MESSAGE("Account deleted", ""),
    CHANGES_SAVED_MESSAGE("Changes saved", ""),
    UNLOCK_ASSETS_TO_VIP("To unlock all assets, upgrade to VIP status", ""),
    STANDARD_UNLOCK_ASSET("Upgrade to Standard to trade this asset", ""),
    GOLD_UNLOCK_ASSET("Upgrade to Gold to trade this asset", ""),
    VIP_UNLOCK_ASSET("Upgrade to VIP to trade this asset", ""),

    WILL_BE_AVAILABLE_TITLE("Will be available at \\d{2}:\\d{2}", ""),
    CFD_AVAILABLE_ON_DEMO_TEXT("CFD trading is available only on a demo account", ""),
    CFD_UNAVAILABLE_STUB("CFD is unavailable", ""),
    REMOVE_OLD_ASSETS_DESCRIPTION("Please remove the old assets and then choose the new ones instead", ""),
    PAYWALL_DESCRIPTION_TEXT("\t• Personal manager support\n" +
            "\t• Scalp Pro: exclusive indicator\n" +
            "\t• Trading up to 3 assets at a time", ""),
    ;

    private final String _en;
    private final String _ru;


    AppMessages(String en, String ru) {
        _en = en;
        _ru = ru;
    }

    @Override
    public String getEN() {
        return _en;
    }

    @Override
    public String getRU() {
        return _ru;
    }
}

