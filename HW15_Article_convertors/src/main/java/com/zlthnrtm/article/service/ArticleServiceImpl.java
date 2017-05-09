/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.Language;
import com.zlthnrtm.article.repository.ArticlesRepository;
import com.zlthnrtm.article.repository.exception.ReadException;
import com.zlthnrtm.article.repository.exception.WriteException;
import com.zlthnrtm.article.service.exception.ArticleDeleteException;
import com.zlthnrtm.article.service.exception.ArticleFindException;
import com.zlthnrtm.article.service.exception.ArticleSaveException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arch
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    
    
    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public ArticleForm generateEmptyForm() {
        ArticleForm articleForm = new ArticleForm();
        return articleForm;
    }
    
    @Override
    public ArticleForm generateForm(Article article) {
        if (article == null) {
            throw new IllegalArgumentException("article is null");
        }
        ArticleForm form = new ArticleForm(article.getId(), article.getSlug(), article.getTitle(), article.getContent(), article.getLanguage(), article.getUser());
        
        return form;
    }

    @Override
    public Article save(Article article) throws ArticleSaveException {
        try {
            return articlesRepository.save(article);
        } catch (WriteException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleSaveException("Can not save article = " + ((article == null) ? "null" : article.toString()));
        }
        
    }
    
    
//    @Override
//    public Article save(ArticleForm articleForm)  throws ArticleSaveException{
//        Article article = new Article();
//        Set<Text> texts = new HashSet<>();
//        article.setTexts(texts);
//        for (Text i: articleForm.getTexts()) {
//            texts.add(i);
//            i.setArticle(article);
//        }
//        article.setId(articleForm.getId());
//        article.setSlug(articleForm.getSlug());
//        return save(article);
//        
//    }

    @Override
    public List<Article> getAll() throws ArticleFindException {
        try {
            List<Article> list = new ArrayList<>();
            for(Article i: articlesRepository.findAll()){
                list.add(i);
            }
            return list;
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException("Can not get articles!");
        }
    }

    @Override
    public Article getBySlug(String slug) throws ArticleFindException {
        try {
            return articlesRepository.findOne(slug);
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException("Can not find article with slug = " + slug);
        }
    }

    @Override
    public Article getById(Long id) throws ArticleFindException {
        try {
            return articlesRepository.findOne(id);
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException("Can not find article with id = " + id);
        }
        
    }
    
    /*
    * Be careful! The pages are numbered from the 1st number
    */
    @Override
    public List<Article> getByPage(int pageIndex, int pageSize) {
        try {
            List<Article> list = new ArrayList<>();
            for(Article i: articlesRepository.findByPage(pageIndex, pageSize)){
                list.add(i);
            }
            return list;
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Article> getAllLocalizated(Language lang)  throws ArticleFindException{
        try {
            return articlesRepository.findByLanguage(lang);
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException(ex.getMessage());
        }
    }


    @Override
    public List<Article> getByPageLocalizated(int pageIndex, int pageSize, Language lang) throws ArticleFindException {
        try {
            return articlesRepository.findByPage(pageIndex, pageSize, lang);
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException(ex.getMessage());
        }
    }

    @Override
    public void delete(String slug) throws ArticleDeleteException {
        try {
            articlesRepository.remove(slug);
        } catch (WriteException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleDeleteException("Can not delete article with slug = " + slug);
        }
    }

    @Override
    public Long getPageCount(int pageSize) throws ArticleFindException {
        try {
            return articlesRepository.pageCount(pageSize);
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException("Error! Can not get page count!");
        }
    }

    @Override
    public Long getPageCountLocalizated(int pageSize,  Language lang) throws ArticleFindException {
        try {
            return articlesRepository.pageCount(pageSize);
        } catch (ReadException ex) {
            Logger.getLogger(ArticleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ArticleFindException("Error! Can not get page count!");
        }
    }

   
    
}
