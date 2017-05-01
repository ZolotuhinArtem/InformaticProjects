/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleLocalizated;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author arch
 */
public interface ArticleLocalizator {
    
    List<ArticleLocalizated> localize(List<Article> articles, Locale locale);
    
    ArticleLocalizated localize(Article article, Locale locale);
    
}
