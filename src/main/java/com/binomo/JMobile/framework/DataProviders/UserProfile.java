package com.example.JMobile.framework.DataProviders;

import java.util.StringJoiner;

public enum UserProfile {
    FREE_USER("autotestUser1@gmail.com", "autotestUser1@gmail.com"),

    /**
     * Если исчезнет - создать,
     * внести депозит на 1000$,
     * добавить на авототест и ideal-dump.example.com
     * добавить в срм телефон +79210000000
     * добавить в срм имя "Autotest"
     */
    VIP_USER("autotestUserVip@gmail.com", "autotestUserVip1@gmail.com"),

    /**
     * Если исчезнет - создать,
     * внести депозит на 1000$,
     * добавить на авототест и ideal-dump.example.com
     * не добавлять имя и телефон
     */
    VIP_USER_NO_PHONE("autotestUserVipNoPhone@gmail.com", "autotestUserVip1@gmail.com"),

    VIP_USER_NO_DEALS("autotestUserVipNoDeals@gmail.com", "autotestUserVip1@gmail.com"),

    DONT_TOUCH_STANDART_USER("dontTouchAutotestStandardUser1@gmail.com", "dontTouchAutotestStandardUser1@gmail.com")
    ;

    private final String email;
    private final String password;

    UserProfile(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserProfile.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .toString();
    }
}
