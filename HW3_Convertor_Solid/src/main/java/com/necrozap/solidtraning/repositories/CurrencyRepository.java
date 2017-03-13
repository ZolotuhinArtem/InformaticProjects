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
public interface CurrencyRepository {

    enum TypeCurrencty{
        USDtoRUB, RUBtoUSD
    }
    public double get(TypeCurrencty type);
    
}
