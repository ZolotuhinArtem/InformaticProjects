/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.ArticleLocalizated;
import com.zlthnrtm.article.model.Language;
import com.zlthnrtm.article.model.Text;
import com.zlthnrtm.article.repository.ArticlesRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author arch
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    
    @Autowired
    private LanguageService languageService;
    
    @Autowired
    private ArticlesRepository articlesRepository;
    
    @Autowired
    private ArticleLocalizator articleLocalizator;

    @Override
    public ArticleForm generateEmptyForm() {
        Set<Language> languages = languageService.getLanguages();
        ArticleForm articleForm = new ArticleForm();
        List<Text> texts = new ArrayList<Text>();
        articleForm.setTexts(texts);
        Text tempText;
        for(Language i: languages) {
            tempText = new Text();
            tempText.setLanguage(i.getSystemName());
            texts.add(tempText);
        }
        return articleForm;
    }
    
    @Override
    public ArticleForm generateForm(Article article) {
        ArticleForm form = new ArticleForm();
        form.setSlug(article.getSlug());
        ArrayList<Text> list = new  ArrayList<>();
        form.setTexts(list);
        for(Text i: article.getTexts()) {
            list.add(i);
        }
        form.setId(article.getId());
        return form;
    }

    @Override
    public Article save(Article article) {
        return articlesRepository.save(article);
    }
    
    
    @Override
    public Article save(ArticleForm articleForm) {
        Article article = new Article();
        Set<Text> texts = new HashSet<>();
        article.setTexts(texts);
        for (Text i: articleForm.getTexts()) {
            texts.add(i);
            i.setArticle(article);
        }
        article.setId(articleForm.getId());
        article.setSlug(articleForm.getSlug());
        return save(article);
        
    }

    @Override
    public List<Article> getAll() {
        List<Article> list = new ArrayList<>();
        for(Article i: articlesRepository.findAll()){
            list.add(i);
        }
        return list;
    }

    @Override
    public Article getBySlug(String slug) {
        return articlesRepository.findOne(slug);
    }

    @Override
    public Article getById(Long id) {
        return articlesRepository.findOne(id);
    }
    
    /*
    * Be careful! The pages are numbered from the 1st number
    */
    @Override
    public List<Article> getByPage(int pageIndex, int pageSize) {
        List<Article> list = new ArrayList<>();
        for(Article i: articlesRepository.findByPage(pageIndex, pageSize)){
            list.add(i);
        }
        return list;
    }

    @Override
    public List<ArticleLocalizated> getAllLocalizated(Locale locale) {
        return articleLocalizator.localize(getAll(), locale);
    }

    @Override
    public ArticleLocalizated getBySlugLocalizated(String slug, Locale locale) {
        return articleLocalizator.localize(getBySlug(slug), locale);
    }

    @Override
    public ArticleLocalizated getByIdLocalizated(Long id, Locale locale) {
        return articleLocalizator.localize(getById(id), locale);
    }

    @Override
    public List<ArticleLocalizated> getByPageLocalizated(int pageIndex, int pageSize, Locale locale) {
        return articleLocalizator.localize(getByPage(pageIndex, pageSize), locale);
    }

    @Override
    public void delete(String slug) {
        articlesRepository.remove(slug);
    }

    @Override
    public Long getPageCount(int pageSize) {
        return articlesRepository.pageCount(pageSize);
    }

    @Override
    public Long getPageConutLocalizated(int pageSize, Locale locale) {
        if (getAllLocalizated(locale).size() % pageSize == 0) {
            return (long) getAllLocalizated(locale).size() / pageSize;
        } else {
            return (long) getAllLocalizated(locale).size() / pageSize + 1;
        }
    }

   
    
}
