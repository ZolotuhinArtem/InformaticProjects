package com.zlthrtm.shop.controllers;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    
    @RequestMapping("/")
    public String main(ModelMap map) {
        return "main";
    }
    
    @RequestMapping("/product_form")
    public String productForm(ModelMap map) {
        return "product_form";
    }
    
    @RequestMapping("/product_form/add")
    public String addOrder(@RequestParam ModelMap args,  ModelMap map) {
        
        return null;
    }
    
}
