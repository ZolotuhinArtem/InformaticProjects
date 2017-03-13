/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.solidtraning.converter;

/**
 *
 * @author artem
 */
public interface Converter {
    String convert(String... args) throws IllegalArgumentException;
}
