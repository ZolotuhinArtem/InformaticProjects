/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kpfu.bookstore.service;

import java.util.List;
import ru.kpfu.bookstore.model.Language;

/**
 *
 * @author arch
 */
public interface LanguageService {
    
    public List<Language> getSupportLanguages();
    
}
