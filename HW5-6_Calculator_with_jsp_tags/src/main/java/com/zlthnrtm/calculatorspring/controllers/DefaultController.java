/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.calculatorspring.controllers;

import com.zlthnrtm.calculator.Calculator;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author arch
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    
    @Autowired
    private Calculator calculator;
    
    @RequestMapping("/calculate")
    public void calculate(
      @RequestParam(
        value        = "operation",
        required     = false,
        defaultValue = "add"
      ) String operation,
      @RequestParam(
        value        = "firstValue",
        required     = false,
        defaultValue = "0"
      ) String a,
      @RequestParam(
        value        = "secondValue",
        required     = false,
        defaultValue = "0"
      ) String b,
      Writer out
    ) {
        try {
            String result;
            String status = "OK";
            String message = "";
            double value;
            JSONObject jObj = new JSONObject();
            try {
                double x = Double.parseDouble(a);
                double y = Double.parseDouble(b);
                switch (operation) {
                    case "add":
                        value = calculator.add(x, y);
                        break;
                    case "sub":
                        value = calculator.sub(x, y);
                        break;
                    case "mult":
                        value = calculator.mult(x, y);
                        break;
                    case "div":
                        value = calculator.div(x, y);
                        break;
                    case "pow":
                        value = calculator.pow(x, y);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                result = Double.toString(value);
                jObj.put("result", result);
                
            } catch (NumberFormatException ex) {
                status = "ERROR";
                message = "Invalid Arguments!"; 
            } catch (ArithmeticException ex) {
                status = "ERROR";
                message = ex.getMessage();
            } catch (IllegalArgumentException ex){
                status = "ERROR";
                message = "Invalid Arguments!"; 
            }
            
            jObj.put("status", status);
            
            
            if (message.length() > 0) {
                jObj.put("message", message);
            }
            
            out.write(jObj.toJSONString());
        } catch (IOException ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
