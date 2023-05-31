package com.reyavaya.Reyavaya.Technologies.model;

import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name = "supplier")
    private long supplier;
    @Column(name = "purchased_price")
    private double purchasedPrice;

    @Column(name="selling_price")
    private double sellingPrice;
    public Product(){
    }

    public Product(String name, String brand, long supplier, double purchasedPrice, double sellingPrice) {
        this.name = name;
        this.brand = brand;
        this.supplier = supplier;
        this.purchasedPrice = purchasedPrice;
        this.sellingPrice = sellingPrice;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getSupplier() {
        return supplier;
    }

    public void setSupplier(long supplier) {
        this.supplier = supplier;
    }

    public double getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(double purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
