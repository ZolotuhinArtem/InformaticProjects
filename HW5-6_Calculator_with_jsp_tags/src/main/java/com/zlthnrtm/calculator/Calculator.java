/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.calculator;

import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */
@Component
public class Calculator {
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public double mult(double a, double b){
        return a * b;
    }
    
    public double sub(double a, double b) {
        return a - b;
    }
    
    public double div(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Devide by zero");
        }
        
        return a / b;
    }
    
    public double pow(double a, int n) {
        
        if ((a == 1) || (n == 0)) {
            return 1;
        }
        
        if (n < 0) {
            return Math.pow(a, (double) n);
        }
        
        double result = 1.0;
        
        for(int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
    }
    
    public double pow(double a, double n) {
        return Math.pow(a, n);
    }
    
    
    
}
