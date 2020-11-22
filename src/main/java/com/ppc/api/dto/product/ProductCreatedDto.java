package com.ppc.api.dto.product;


import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * This corresponding to the object from zg-map API send ( product definition corresponding to domain/Product.ts), adapted for WS essentials data required for real time display
 */

@Component
public class ProductCreatedDto {

    private String name;
    private String description;
    private double price;
    private String currency;
    private List<String> quantity;
    private int stock;
    private Date createdAt;

    public ProductCreatedDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<String> quantity) {
        this.quantity = quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
