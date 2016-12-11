package com.vatttghern.itea_app;

/**
 * Created by vattg on 10.12.2016.
 */

public class Profile {

    String name;
    String surname;
    String city;
    String email;
    String country;
    String notes;
    String phone;
    int logoId;

    public Profile(int logoId,String name, String surname, String email, String country, String city, String phone, String notes) {
        this.logoId = logoId;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.notes = notes;
    }
}
