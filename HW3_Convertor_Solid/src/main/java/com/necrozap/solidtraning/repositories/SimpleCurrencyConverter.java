/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.solidtraning.repositories;

/**
 *
 * @author artem
 */
public class SimpleCurrencyConverter implements CurrencyRepository{

    @Override
    public double get(TypeCurrencty type) {
        if (type == TypeCurrencty.USDtoRUB) {
            return 60.0;
        }
        if (type == TypeCurrencty.RUBtoUSD) {
            return 1.0/60.0;
        }
        return 0;
    }
    
}
