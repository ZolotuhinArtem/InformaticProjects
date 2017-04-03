/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.kpfu.bookstore.service.CountryService;
import ru.kpfu.bookstore.util.RegExp;

/**
 *
 * @author arch
 */
public class UserFormValidator implements Validator{

    private CountryService countryService;
    
    public UserFormValidator(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public boolean supports(Class<?> type) {
        return UserForm.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors e) {
        
        String regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
      "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
      "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
      "+(?:[a-zA-Z]){2,}\\.?)$";
        
        UserForm u = (UserForm) o;
        
        if (!RegExp.test(regexp, u.getEmail())){
          e.rejectValue("email", "", "Email is invalid");
        }
        
        if (u.getPassword() != null) {
            if ((u.getPassword().length()) < 8 || (u.getPassword().length() > 64)) {
                e.rejectValue("password", "", "Minimal length of password is 8 and maximal is 64");
            }
            
            if (u.getRepeatPassword() != null) {
                if (!u.getRepeatPassword().equals(u.getPassword())) {
                    e.rejectValue("repeatPassword", "", "Repeat password not equls with password");
                }
            } else {
                e.rejectValue("repeatPassword", "", "Repeat password is empty");
            }
        } else {
            e.rejectValue("password", "", "Password is empty");
        }
        
        if (u.getName() == null) {
            e.rejectValue("name", "", "Name is empty");
        } else {
            if (u.getName().length() <= 0) {
                e.rejectValue("name", "", "Name is empty");
            }
        }
        
        Map<String, String> map = this.countryService.getCountryMap();
        String test = map.get(u.getCountry());
        if (test == null) {
            e.rejectValue("country",  "", "Country is invalid");
        }
        
        if (u.getSex() == null) {
            e.rejectValue("sex",  "", "Sex is invalid");
        } else {
            if (!(u.getSex().equals(UserForm.VALUE_MALE) || u.getSex().equals(UserForm.VALUE_FEMALE))){
                e.rejectValue("sex",  "", "Sex is invalid");
            }
        }
        
    }
    
}
