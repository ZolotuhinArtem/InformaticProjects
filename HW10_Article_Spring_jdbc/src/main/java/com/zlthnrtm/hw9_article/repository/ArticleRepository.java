/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
import java.util.List;

/**
 *
 * @author arch
 */

public interface ArticleRepository {
    
    List<Article> getAll() throws RepositoryReadException;
    
    Article getBySlug(String slug) throws RepositoryReadException;
    
    void add(Article article) throws RepositoryWriteException;
    
    void update(String slug, Article article) throws RepositoryWriteException;
    
    
    
}
