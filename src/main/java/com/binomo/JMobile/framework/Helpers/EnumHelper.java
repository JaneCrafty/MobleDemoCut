package com.example.JMobile.framework.Helpers;

        import com.example.JMobile.framework.Enums.Currency;
        import org.apache.commons.lang3.NotImplementedException;

public class EnumHelper {

    public static Currency GetCurrency(String currency) {
        Currency returnCurrency;
        switch (currency.toUpperCase()) {
            case "EUR":
                returnCurrency = Currency.EUR;
                break;

            case "€":
                returnCurrency = Currency.EUR;
                break;

            case "RUB":
                returnCurrency = Currency.RUB;
                break;

            case "\u20BD":
                returnCurrency = Currency.RUB;
                break;

            case "USD":
                returnCurrency = Currency.USD;
                break;

            case "$":
                returnCurrency = Currency.USD;
                break;

            case "₮":
                returnCurrency = Currency.TUGRICK;
                break;
            default:
                throw new NotImplementedException("check currency");

        }
        return returnCurrency;

    }

}
