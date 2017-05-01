/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.utils;

/**
 *
 * @author arch
 */
public class StringUtils {
    
    public static String killHtmlAndSpaces(String str){
        if (str == null) {
            return "";
        }
        
        if (str.length() <= 0) {
            return str;
        }
                
        return str.replace("<p>", "")
                .replace("</p>", "")
                .replace("<br>", "")
                .replace("<h1>", "")
                .replace("<h2>", "")
                .replace("<h3>", "")
                .replace("<h4>", "")
                .replace("<h5>", "")
                .replace("<h6>", "")
                .replace("</h1>", "")
                .replace("</h2>", "")
                .replace("</h3>", "")
                .replace("</h4>", "")
                .replace("</h5>", "")
                .replace("</h6>", "")
                .replace("\t", "")
                .replace("\n", "")
                .replace(" ", "");
                
    }
    
}
