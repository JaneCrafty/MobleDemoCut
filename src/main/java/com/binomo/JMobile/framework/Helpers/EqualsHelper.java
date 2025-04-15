package com.example.JMobile.framework.Helpers;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.Callable;

import static com.example.JMobile.framework.POM.MobileElementActions.logger;

public class EqualsHelper
{
    public static <T> boolean prolongedEqualsBalance(BigDecimal expected, Callable<T> actualValueProvider) throws Exception
    {
        boolean isResultEqual = false;
        Instant timeout = Instant.now().plusSeconds(20);

        while (timeout.compareTo(Instant.now()) > 0 && !isResultEqual)
        {
            logger.info("Attempt to compare account balance");
            String actualResult = String.valueOf(actualValueProvider.call());
            isResultEqual = CountHelper.AccountBalance(actualResult).equals(CountHelper.limitNumberOfDecimals(expected));
            Thread.sleep(300);
        }

        return isResultEqual;
    }

    public static <T> boolean prolongedEquals(T expected, Callable<T> actualValueProvider) throws Exception
    {
        boolean isResultEqual = false;
        Instant timeout = Instant.now().plusSeconds(15);

        while (timeout.compareTo(Instant.now()) > 0 && !isResultEqual)
        {
            logger.info("Attempt to compare values");
            isResultEqual = actualValueProvider.call().equals(expected);
            Thread.sleep(300);
        }

        return isResultEqual;
    }

    public static <T> BigDecimal getDifferentValue(List<BigDecimal> expected, Callable<T> actualValueProvider) throws Exception
    {
        boolean isResultNotContains = false;
        BigDecimal actualResult = null;
        Instant timeout = Instant.now().plusSeconds(10);

        while (timeout.compareTo(Instant.now()) > 0 && !isResultNotContains)
        {
            logger.info("Trying to get different values");
            actualResult = CountHelper.AccountBalance(String.valueOf(actualValueProvider.call()));
            isResultNotContains = !expected.contains(actualResult);
            Thread.sleep(300);
        }

        return actualResult;
    }

    public static <T> boolean prolongedContain(T expected, Callable<T> actualValueProvider) throws Exception
    {
        boolean isResultContain = false;
        Instant timeout = Instant.now().plusSeconds(30);

        while (timeout.compareTo(Instant.now()) > 0 && !isResultContain)
        {
            logger.info("Attempt to compare values");
            isResultContain = actualValueProvider.call().toString().contains(expected.toString());
            Thread.sleep(300);
        }

        return isResultContain;
    }
}

