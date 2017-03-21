/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthrtm.shop.model;

import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */

public class Order {
    
    private String email;
    
    private String name;
    
    private String address;
    
    private double price;

    public Order() {
    }

    
    
    public Order(String email, String name, String address, double price) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
