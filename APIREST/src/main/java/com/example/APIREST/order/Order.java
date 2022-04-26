package com.example.APIREST.order;



import com.example.APIREST.user.User;

import javax.persistence.*;
import javax.persistence.Entity ;
import java.time.LocalDate;


@Entity
@Table(name = "order_")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;


    private String Address;
    private boolean valid;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

    private String street;
    private String extra;
    private String zip;
    private String city;
    private String country;

    boolean canceled;
    LocalDate cancelDate;

    public Order() {
    }

    public Order(LocalDate date, String address, boolean valid, User user, String street, String extra, String zip, String city, String country, boolean canceled, LocalDate cancelDate) {
        this.date = date;

        Address = address;
        this.valid = valid;
        this.user = user;
        this.street = street;
        this.extra = extra;
        this.zip = zip;
        this.city = city;
        this.country = country;
        this.canceled = canceled;
        this.cancelDate = cancelDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

  /*  public String getProducts() {
        return products;
    }*/

    /*public void setProducts(String products) {
        this.products = products;
    }*/

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

  /*  public Long getId_user() {
        return id_user;
    }*/

    /*public void setId_user(Long id_user) {
        this.id_user = id_user;
    }*/

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public LocalDate getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(LocalDate cancelDate) {
        this.cancelDate = cancelDate;
    }
}
