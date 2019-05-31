package com.bubbles.database;

public class Address {
    private int id;
    private String addresses;
    private String city,landmark,other;

    public Address(){

    }

    public Address(String addresses, String city, String landmark, String other) {
        this.addresses = addresses;
        this.city = city;
        this.landmark = landmark;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
