/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author arch
 */
@Service
public class TestCountryService implements CountryService{

    @Override
    public Map<String, String> getCountryMap() {
        Map<String, String> map = new HashMap<>();
        map.put("RU", "Russia");
        map.put("US", "USA");
        map.put("UK", "United Kindom");
        return map;
    }
    
}
