/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.bookstore.model.UserForm;
import ru.kpfu.bookstore.service.CountryService;

/**
 *
 * @author arch
 */
@Controller
public class JFormController {
    
    
    @Autowired
    private CountryService countryService;
    
    @RequestMapping(value = "/jregistration", method = RequestMethod.GET)
    public String registration(ModelMap map){
        
        map.put("userForm", new UserForm());
        map.put("countryList", countryService.getCountryMap());
        map.put("valueMale", UserForm.VALUE_MALE);
        map.put("valueFemale", UserForm.VALUE_FEMALE);
        
        return "user_form";
    }
    
    @RequestMapping(value = "/jregistration", method = RequestMethod.POST)
    public String newUser(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("userForm") UserForm userForm,
            BindingResult result,
            ModelMap map){
        
        map.put("countryList", countryService.getCountryMap());
        map.put("valueMale", UserForm.VALUE_MALE);
        map.put("valueFemale", UserForm.VALUE_FEMALE);
        
        if (result.hasErrors()) {
            return "user_form";
        } else {
            redirectAttributes.addFlashAttribute("message", "Registration completed!");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("SFC#registration").build();
        }
    }
    
}
