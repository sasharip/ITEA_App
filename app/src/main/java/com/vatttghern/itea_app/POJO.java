package com.vatttghern.itea_app;

import android.os.Parcel;
import android.os.Parcelable;

public class POJO implements Parcelable {

    private String name;
    private String surname;
    private String email;
    private String country;
    private String city;
    private String notes;
    private Integer phone;

    /** No args constructor for use in serialization */
    public POJO() {}

    /**
     * @param phone
     * @param email
     * @param name
     * @param surname
     * @param notes
     * @param city
     * @param country
     */
    public POJO(
            String name,
            String surname,
            String email,
            String country,
            String city,
            String notes,
            Integer phone) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        this.city = city;
        this.notes = notes;
        this.phone = phone;
    }

    /** @return The name */
    public String getName() {
        return name;
    }

    /** @param name The name */
    public void setName(String name) {
        this.name = name;
    }

    public POJO withName(String name) {
        this.name = name;
        return this;
    }

    /** @return The surname */
    public String getSurname() {
        return surname;
    }

    /** @param surname The surname */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public POJO withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    /** @return The email */
    public String getEmail() {
        return email;
    }

    /** @param email The email */
    public void setEmail(String email) {
        this.email = email;
    }

    public POJO withEmail(String email) {
        this.email = email;
        return this;
    }

    /** @return The country */
    public String getCountry() {
        return country;
    }

    /** @param country The country */
    public void setCountry(String country) {
        this.country = country;
    }

    public POJO withCountry(String country) {
        this.country = country;
        return this;
    }

    /** @return The city */
    public String getCity() {
        return city;
    }

    /** @param city The city */
    public void setCity(String city) {
        this.city = city;
    }

    public POJO withCity(String city) {
        this.city = city;
        return this;
    }

    /** @return The notes */
    public String getNotes() {
        return notes;
    }

    /** @param notes The notes */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public POJO withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    /** @return The phone */
    public Integer getPhone() {
        return phone;
    }

    /** @param phone The phone */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public POJO withPhone(Integer phone) {
        this.phone = phone;
        return this;
    }

    protected POJO(Parcel in) {
        name = in.readString();
        surname = in.readString();
        email = in.readString();
        country = in.readString();
        city = in.readString();
        notes = in.readString();
        phone = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(email);
        dest.writeString(country);
        dest.writeString(city);
        dest.writeString(notes);
        if (phone == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(phone);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<POJO> CREATOR = new Parcelable.Creator<POJO>() {
        @Override
        public POJO createFromParcel(Parcel in) {
            return new POJO(in);
        }

        @Override
        public POJO[] newArray(int size) {
            return new POJO[size];
        }
    };
}