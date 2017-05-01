/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.service;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.utils.ArticleCut;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author arch
 */
public interface ArticleCutter {
    
    List<ArticleCut> cutByLoclae(List<Article> articles, Locale locale);
    
    ArticleCut cutByLocale(Article article, Locale locale);
    
}
