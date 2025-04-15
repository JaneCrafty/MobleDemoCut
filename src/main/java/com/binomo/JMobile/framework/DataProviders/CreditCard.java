package com.example.JMobile.framework.DataProviders;

public class CreditCard {
    private String _cardNumber;
    private String _expMonth;
    private String _expYear;
    private String _cvv;
    private String _holderName;

    public CreditCard(String _cardNumber, String _expMonth, String _expYear, String _cvv, String _holderName) {
        this._cardNumber = _cardNumber;
        this._expMonth = _expMonth;
        this._expYear = _expYear;
        this._cvv = _cvv;
        this._holderName = _holderName;
    }

    public String getCardNumber() {
        return _cardNumber;
    }

    public void setCardNumber(String _cardNumber) {
        this._cardNumber = _cardNumber;
    }

    public String getExpMonth() {
        return _expMonth;
    }

    public void setExpMonth(String _expMonth) {
        this._expMonth = _expMonth;
    }

    public String getExpYear() {
        return _expYear;
    }

    public void setExpYear(String _expYear) {
        this._expYear = _expYear;
    }

    public String getCvv() {
        return _cvv;
    }

    public void setCvv(String _cvv) {
        this._cvv = _cvv;
    }

    public String getHolderName() {
        return _holderName;
    }

    public void setHolderName(String _holderName) {
        this._holderName = _holderName;
    }


}
