/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.sawg;

import com.sun.istack.internal.NotNull;
import org.json.simple.JSONObject;

/**
 *
 * @author artem
 */
public class JsonSimpleUtils {
    public static String toGoodString(@NotNull JSONObject jsonObject){
        StringBuilder stringBuilder = new StringBuilder();
        for(Object i: jsonObject.keySet()) {
            stringBuilder.append(i.toString() + ": " + jsonObject.get(i) + "\n");
        }
        return stringBuilder.toString();
    }
}
