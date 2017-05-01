/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Language;
import java.util.Set;

/**
 *
 * @author arch
 */
public interface LanguageService {
    Set<Language> getLanguages();
}
