package com.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "StudentAddress")
public class StudentAddress {

    public static final String findStudentQuery = "from Student";
    private long addressId;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public StudentAddress(){
    }

    public StudentAddress(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "STATE")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "ZIPCODE")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
