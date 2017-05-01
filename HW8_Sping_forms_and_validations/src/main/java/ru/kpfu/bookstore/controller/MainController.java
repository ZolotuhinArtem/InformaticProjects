/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.bookstore.service.LanguageService;

/**
 *
 * @author arch
 */
@Controller
public class MainController {
    
    @Autowired
    private LanguageService languageService;
    
    @RequestMapping("/")
    public String mainPage(ModelMap map) {
        map.put("languageList", languageService.getSupportLanguages());
        return "index";
    }
    
}
