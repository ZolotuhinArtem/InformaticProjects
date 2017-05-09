/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.Language;
import com.zlthnrtm.article.service.exception.ArticleDeleteException;
import com.zlthnrtm.article.service.exception.ArticleFindException;
import com.zlthnrtm.article.service.exception.ArticleSaveException;
import java.util.List;

/**
 *
 * @author arch
 */

public interface ArticleService {
    
    ArticleForm generateEmptyForm();
    
    ArticleForm generateForm(Article article);
    
    Article save(Article article) throws ArticleSaveException;
    
    //Article save(ArticleForm article) throws ArticleSaveException;
    
    void delete(String slug) throws ArticleDeleteException;
    
    List<Article> getAll() throws ArticleFindException;
    
    List<Article> getAllLocalizated(Language lang) throws ArticleFindException;
    
    Article getBySlug(String slug) throws ArticleFindException;
    
    Article getById(Long id) throws ArticleFindException;
    
    List<Article> getByPage(int pageIndex, int pageSize) throws ArticleFindException;
    
    List<Article> getByPageLocalizated(int pageIndex, int pageSize, Language lang) throws ArticleFindException;
    
    Long getPageCount(int pageSize) throws ArticleFindException;
    
    Long getPageCountLocalizated(int pageSize, Language lang) throws ArticleFindException;
    
    
}
