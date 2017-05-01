/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.ArticleLocalizated;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author arch
 */

public interface ArticleService {
    
    ArticleForm generateEmptyForm();
    
    ArticleForm generateForm(Article article);
    
    Article save(Article article);
    
    Article save(ArticleForm article);
    
    void delete(String slug);
    
    List<Article> getAll();
    
    List<ArticleLocalizated> getAllLocalizated(Locale locale);
    
    Article getBySlug(String slug);
    
    ArticleLocalizated getBySlugLocalizated(String slug, Locale locale);
    
    Article getById(Long id);
    
    ArticleLocalizated getByIdLocalizated(Long id, Locale locale);
    
    List<Article> getByPage(int pageIndex, int pageSize);
    
    List<ArticleLocalizated> getByPageLocalizated(int pageIndex, int pageSize, Locale locale);
    
    Long getPageCount(int pageSize);
    
    Long getPageConutLocalizated(int pageSize, Locale locale);
    
    
}
