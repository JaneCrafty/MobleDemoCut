package com.example.JMobile.framework.Helpers;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;


public class CountHelper {

    public static BigDecimal AccountBalance(String AccountBalance) {
        BigDecimal result = null;
        int count = 0;

        while (result == null && count < 3) {
            try {
                result = new BigDecimal(StringHelper.GetAmountFromAccountData(AccountBalance));

            } catch (Exception ex) {
                logger.info("Retrying attempt to get BigDecimal value");
                logger.info(ex.getMessage());
                count++;
            }
        }

        return result;
    }

    public static BigDecimal limitNumberOfDecimals(BigDecimal number)
    {
        Double result = Math.floor(number.doubleValue() * Math.pow(10, 2)) / Math.pow(10, 2);
        return new BigDecimal(new DecimalFormat("#0.00").format(result).replace(",", "."));
    }


}
