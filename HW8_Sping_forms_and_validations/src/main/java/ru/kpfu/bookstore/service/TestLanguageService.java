/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import ru.kpfu.bookstore.model.Language;

/**
 *
 * @author arch
 */
@Service
public class TestLanguageService implements LanguageService{

    @Override
    public List<Language> getSupportLanguages(){
        ArrayList<Language> list = new ArrayList<>(2);
        list.add(new Language("Русский", "ru"));
        list.add(new Language("English", "en"));
        return list;
    }
    
}
