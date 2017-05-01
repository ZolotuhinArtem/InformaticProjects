/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthrtm.shop.repository;

import com.zlthrtm.shop.model.Order;
import java.util.ArrayList;

/**
 *
 * @author arch
 */

public interface OrderRepository {
    
    void add(Order order);
    
    ArrayList<Order> getAll();
    
    
}
