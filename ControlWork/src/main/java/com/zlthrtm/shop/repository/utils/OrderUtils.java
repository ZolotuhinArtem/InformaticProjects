/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthrtm.shop.repository.utils;

import com.zlthrtm.shop.model.Order;
import org.json.simple.JSONObject;

/**
 *
 * @author arch
 */
public class OrderUtils {
    
    public static JSONObject toJson(Order order){
        JSONObject jobj = new JSONObject();
        jobj.put("email", order.getEmail());
        jobj.put("name", order.getName());
        jobj.put("address", order.getAddress());
        jobj.put("price", order.getPrice());
        return jobj;
    }
    
    public static Order fromJson(JSONObject jobj){
        return new Order((String) jobj.get("email"), (String) jobj.get("name"), (String) jobj.get("address"), (double) jobj.get("price"));
    }
    
}
