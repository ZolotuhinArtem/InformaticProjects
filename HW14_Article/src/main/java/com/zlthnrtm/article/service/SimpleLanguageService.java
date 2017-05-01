/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Language;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author arch
 */
@Service
public class SimpleLanguageService implements LanguageService{

    
    
    @Override
    public Set<Language> getLanguages() {
        Set<Language> langs = new HashSet<>();
        
        langs.add(new Language("Russian", "ru"));
        langs.add(new Language("English", "en"));
        
        return langs;
    }
    
}
