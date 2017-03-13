/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.solidtraning.converter;

import com.necrozap.solidtraning.repositories.CurrencyRepository;

/**
 *
 * @author artem
 */
public class CurrencyConverter implements Converter{

    private CurrencyRepository currencyRepository;
    
    private CurrencyRepository.TypeCurrencty typeCurrencty;
    
    public CurrencyConverter(CurrencyRepository currencyRepository, CurrencyRepository.TypeCurrencty typeCurrencty) {
        this.currencyRepository = currencyRepository;
        this.typeCurrencty = typeCurrencty;
    }
    
    @Override
    public String convert(String... args) throws IllegalArgumentException {
       if (checkArgumentsOnErrors(args)) {
           throw new IllegalArgumentException(this.getClass().getName() + ": missing args\nMethod: convert");
       }
       double reqValue = Double.parseDouble(args[0]);
       double ratio = this.currencyRepository.get(typeCurrencty);
       double respValue = reqValue * ratio;
       return Double.toString(respValue);
    }
    
    private boolean checkArgumentsOnErrors(String... args) {
        if (args == null) {
            return true;
        }
        if (args[0] == null) {
            return true;
        }
        try {
            Double.parseDouble(args[0]);
        } catch (NumberFormatException ex){
            return true;
        }
        return false;
    }
    
}
