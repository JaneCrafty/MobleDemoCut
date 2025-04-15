package com.example.JMobile.framework.DataProviders;

public class CreditCardProvider {
    public static CreditCard getSuccessCard() {
        return new CreditCard(
                "5555555555554444",
                "12",
                "33",
                "123",
                "QA QA"
        );
    }

    public static CreditCard getFailureCard() {
        CreditCard card = getSuccessCard();
        card.setCardNumber("4111111111111111");
        return card;
    }

    public static CreditCard getXPateCard() {
        CreditCard card = getSuccessCard();
        card.setCardNumber("4444 3333 2222 1111");
        card.setCvv("123");
        return card;
    }

    public static CreditCard getEmulatedSuccessCard() {
        CreditCard card = getSuccessCard();
        card.setCardNumber("1111111111111111");
        return card;
    }
}
