/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author arch
 */
public class RegExp {
    public static boolean test(String regexp, String testString){  
        if ((testString == null) || (regexp == null)) {
            return false;
        }
        Pattern p = Pattern.compile(regexp);  
        Matcher m = p.matcher(testString);  
        return m.matches();  
    } 
}
