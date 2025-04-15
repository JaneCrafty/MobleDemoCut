package com.example.JMobile.framework.Enums;

public enum AndroidConfigFile {
    DEFAULT("remote_config"),
    NO_TOURNAMENT("remote_config_no_tournament"),
    STD_DISABLED("remote_config_std_disabled"),
    NATIVE_CASHIER("remote_config_native_cashier"),
    CUSTOM_HELPCENTER("remote_config_custom_helpcenter"),
    SIGN_UP_DEPOSIT_OFFER("remote_config_sign_up_deposit_offer"),
    VIP_DEFAULT("remote_config_vip"),
    VIP_REVIEWER("remote_config_vip_reviewer_true"),
    VIP_PAYMENT_RESTRICTED("remote_config_vip_payment_restricted"),
    VIP_FTT_RESTRICTED("remote_config_vip_ftt_restricted"),
    VIP_NATIVE_CASHIER("remote_config_vip_native_cashier"),
    ;

    private final String configDir = "AndroidMainConfig";
    private final String filename;

    AndroidConfigFile(String filename) {
        this.filename = filename;
    }

    public String getFilePath() {
        return configDir +
                "/" +
                filename +
                ".json";
    }
}
