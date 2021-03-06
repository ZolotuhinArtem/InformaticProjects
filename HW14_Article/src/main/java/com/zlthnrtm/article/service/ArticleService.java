/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.ArticleLocalizated;
import com.zlthnrtm.article.service.exception.ArticleDeleteException;
import com.zlthnrtm.article.service.exception.ArticleFindException;
import com.zlthnrtm.article.service.exception.ArticleSaveException;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author arch
 */

public interface ArticleService {
    
    ArticleForm generateEmptyForm();
    
    ArticleForm generateForm(Article article);
    
    Article save(Article article) throws ArticleSaveException;
    
    Article save(ArticleForm article) throws ArticleSaveException;
    
    void delete(String slug) throws ArticleDeleteException;
    
    List<Article> getAll() throws ArticleFindException;
    
    List<ArticleLocalizated> getAllLocalizated(Locale locale) throws ArticleFindException;
    
    Article getBySlug(String slug) throws ArticleFindException;
    
    ArticleLocalizated getBySlugLocalizated(String slug, Locale locale) throws ArticleFindException;
    
    Article getById(Long id) throws ArticleFindException;
    
    ArticleLocalizated getByIdLocalizated(Long id, Locale locale) throws ArticleFindException;
    
    List<Article> getByPage(int pageIndex, int pageSize) throws ArticleFindException;
    
    List<ArticleLocalizated> getByPageLocalizated(int pageIndex, int pageSize, Locale locale) throws ArticleFindException;
    
    Long getPageCount(int pageSize) throws ArticleFindException;
    
    Long getPageConutLocalizated(int pageSize, Locale locale) throws ArticleFindException;
    
    
}
