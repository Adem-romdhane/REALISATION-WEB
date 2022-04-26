package com.example.APIREST.store;

import com.example.APIREST.stock.Stock;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Store {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String adresse;
    private String SIRET;
    private String imageLink;
    boolean active;

    @OneToMany(mappedBy = "store")
    Set<Stock> stocks;

    public Store() {
    }

    public Store(String name, String adresse, String SIRET, String imageLink, boolean active) {
        this.name = name;
        this.adresse = adresse;
        this.SIRET = SIRET;
        this.imageLink = imageLink;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}
