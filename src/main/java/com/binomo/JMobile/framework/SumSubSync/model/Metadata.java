package com.example.JMobile.framework.SumSubSync.model;

public class Metadata {
    private DocType idDocType;
    private String country;
    private String firstName;
    private String lastName;
    private String number;
    private String dob;

    public Metadata() {
    }

    public Metadata(DocType idDocType, String country) {
        this.idDocType = idDocType;
        this.country = country;
    }

    public Metadata(DocType idDocType, String country, String firstName, String lastName, String number, String dob) {
        this.idDocType = idDocType;
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.dob = dob;
    }

    public DocType getIdDocType() { return idDocType; }

    public String getCountry() { return country; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getNumber() { return number; }

    public String getDob() { return dob; }
}
