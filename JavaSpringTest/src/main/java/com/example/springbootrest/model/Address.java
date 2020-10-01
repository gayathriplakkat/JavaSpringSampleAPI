package com.example.springbootrest.model;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    private long id;
    private String addrLineOne;
    private String addrLineTwo;
    private String city;

    public Address() {
    }

    public Address(long id, String addrLineOne, String addrLineTwo, String city) {
        this.id = id;
        this.addrLineOne = addrLineOne;
        this.addrLineTwo = addrLineTwo;
        this.city = city;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "addrLineOne",nullable = false, length = 5)
    public String getAddrLineOne() {
        return addrLineOne;
    }

    public void setAddrLineOne(String addrLineOne) {
        this.addrLineOne = addrLineOne;
    }

    @Column(name = "addrLineTwo")
    public String getAddrLineTwo() {
        return addrLineTwo;
    }

    public void setAddrLineTwo(String addrLineTwo) {
        this.addrLineTwo = addrLineTwo;
    }

    @Column(name = "city",nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addrLineOne='" + addrLineOne + '\'' +
                ", addrLineTwo='" + addrLineTwo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
