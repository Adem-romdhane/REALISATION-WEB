package com.example.APIREST.stock;

import com.example.APIREST.product.Product;
import com.example.APIREST.store.Store;
import com.example.APIREST.user.User;

import javax.persistence.*;

@Entity
@Table
public class Stock {



    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantité;

    public Stock() {
    }

    public Stock(Store store, Product product, Integer quantité) {
        this.store = store;
        this.product = product;
        this.quantité = quantité;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantité() {
        return quantité;
    }

    public void setQuantité(Integer quantité) {
        this.quantité = quantité;
    }
}
