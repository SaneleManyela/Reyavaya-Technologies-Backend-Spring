package com.reyavaya.Reyavaya.Technologies.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "supplier")
    private Long supplier;

    @Column(name = "sold_qty")
    private int soldQty;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "sale_total")
    private double saleTotal;

    @Column(name = "sale_date")
    private String saleDate;

    public Sale(){

    }

    public Sale(Long productId, Long supplier, int soldQty, double sellingPrice, double saleTotal, String saleDate) {
        this.productId = productId;
        this.supplier = supplier;
        this.soldQty = soldQty;
        this.sellingPrice = sellingPrice;
        this.saleTotal = saleTotal;
        this.saleDate = saleDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplier() {
        return supplier;
    }

    public void setSupplier(Long supplier) {
        this.supplier = supplier;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }
}
