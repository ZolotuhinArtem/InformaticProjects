/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.Text;
import com.zlthnrtm.article.model.ArticleLocalizated;
import com.zlthnrtm.article.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */
@Component
public class ArticleLocalizatorImpl implements ArticleLocalizator{

    @Override
    public List<ArticleLocalizated> localize(List<Article> articles, Locale locale) {
        List<ArticleLocalizated> newArticles = new ArrayList<>();
        
        ArticleLocalizated tempArticleLocalizated;
        for(Article i: articles) {
            tempArticleLocalizated = localize(i, locale);
            if (tempArticleLocalizated != null) {
                newArticles.add(tempArticleLocalizated);
            }
        }
        return newArticles;
    }

    @Override
    public ArticleLocalizated localize(Article article, Locale locale) {
        if (article == null) {
            return null;
        }
        
        String body = "";
        String head = "";
        String language = "";
        
        for(Text i: article.getTexts()) {
            if (locale.getLanguage().equals((new Locale(i.getLanguage())).getLanguage())) {
                body = i.getBody();
                head = i.getHead();
                language = i.getLanguage();
                break;
            }
        }
        if ((!StringUtils.killHtmlAndSpaces(body).equals("")) && (!StringUtils.killHtmlAndSpaces(head).equals(""))){
            return new ArticleLocalizated(article.getSlug(), head, body, language);
        }
        
        return null;
    }
    
}
