package com.example.JMobile.framework.Helpers;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    public static String GetRandomEmail(String domen) {
        return RandomStringUtils.randomAlphabetic(10) + System.currentTimeMillis() + "@" + domen;

    }

    public static String GetRandomName() {
        return RandomStringUtils.randomAlphabetic(10);

    }

    public static String GetRandomSurname() {
        return RandomStringUtils.randomAlphabetic(10);

    }

    public static String GetRandomPhoneNumber() {
        return "+79" + RandomStringUtils.randomNumeric(9);

    }

    public static String GetRandomDeviceId() {
        return RandomStringUtils.randomNumeric(13) + "-" + RandomStringUtils.randomNumeric(19);

    }

    public static String GetAmountFromAccountData(String accountData) {

        String amount = accountData.replaceAll("[^0-9\\.\\,]", "");
        amount = amount.replace(",", "");


        return amount;

    }

    public static String GetRandomInvestment() {
        return RandomStringUtils.randomNumeric(3);

    }

    public static String GetRandomIndicatorPeriod() {
        return RandomStringUtils.randomNumeric(2);

    }

    public static String GetRandomIndicatorFieldSetting(int min, int max) {
        int number = (int)(Math.random() * ((max - min) + 1)) + min;

        return String.valueOf(number);

    }

    public static String getCurrency(String accountData) {
        String regex = "\\p{Sc}";
        String currencySymbol = "";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(accountData);

        matcher.find();
        currencySymbol = matcher.group();

        return currencySymbol;
    }

    /**
     * Метод вытаскивает сумму из текстового поля и возвращает ее как int
     * Достает из строки первое число с точками и запятыми (если есть),
     * запятые убираются
     * точка и дробная часть отбрасывается
     * @return int
     */
    public static int getAmount(String text) {
        String result = "";
        Pattern sumWithCurrency = Pattern.compile("[\\p{Digit},.]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = sumWithCurrency.matcher(text);
        if (matcher.find()) {
            result += matcher.group().replaceAll(",", "");
        }

        if (result.contains(".")) result = result.split("\\.")[0];
        return Integer.parseInt(result);
    }

}
