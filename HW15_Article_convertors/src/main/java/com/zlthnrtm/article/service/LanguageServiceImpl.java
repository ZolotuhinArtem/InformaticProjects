/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.jpa_repository.LanguageRepository;
import com.zlthnrtm.article.model.Language;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arch
 */
@Service
public class LanguageServiceImpl implements LanguageService{

    @Autowired
    private LanguageRepository languageRepository;
    
    @Override
    public Set<Language> getLanguages() {
        
        Set<Language> langs = new HashSet<>();
       
        for(Language i: languageRepository.findAll()){
            langs.add(i);
        }
        
        return langs;
    }

    @Override
    public Language getBySystemName(String systemName) {
        return languageRepository.findBySystemName(systemName.toLowerCase());
    }

    @Override
    public Language getByName(String name) {
        return languageRepository.findByName(name.toLowerCase());
    }

    @Override
    public Language generateFromLocale(Locale locale) {
        Language lang = new Language();
        lang.setName(locale.getLanguage());
        lang.setSystemName(locale.getLanguage());
        return lang;
    }

    @Override
    public Language getByLocale(Locale locale) {
        return getBySystemName(locale.getLanguage().toLowerCase());
    }
    
}
