package com.zlthnrtm.article.repository;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.Language;
import com.zlthnrtm.article.model.User;
import com.zlthnrtm.article.repository.exception.ReadException;
import com.zlthnrtm.article.repository.exception.WriteException;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
/**
 *
 * @author arch
 */
@NoRepositoryBean
public interface ArticlesRepository {
    
   Article findOne(String slug) throws ReadException;
   
   Article findOne(Long id) throws ReadException;
   
   List<Article> findByPage(int page, int itemsOnPage) throws ReadException;
   
   List<Article> findByPage(int page, int itemsOnPage, User user) throws ReadException;
   
   List<Article> findByPage(int page, int itemsOnPage, Language lang) throws ReadException;
   
   long pageCount(int itemsOnPage) throws ReadException;
   
   long pageCount(int itemsOnPage, User user) throws ReadException;
   
   long pageCount(int itemsOnPage, Language lang) throws ReadException;
   
   List<Article> findAll() throws ReadException;
   
   List<Article> findByLanguage(Language lang) throws ReadException;
   
   List<Article> findByUser(User user) throws ReadException;
   
   Article save(Article article) throws WriteException;
   
   void remove(String slug) throws WriteException;
   
   void remove(Long id) throws WriteException;
}
