/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.service;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.utils.ArticleCut;
import com.zlthnrtm.hw9_article.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */
@Component
public class SimpleArticleCutter implements ArticleCutter{

    @Override
    public List<ArticleCut> cutByLoclae(List<Article> articles, Locale locale) {
        List<ArticleCut> newArticles = new ArrayList<>();
        
        ArticleCut tempArticleCut;
        for(Article i: articles) {
            tempArticleCut = cutByLocale(i, locale);
            if (tempArticleCut != null) {
                newArticles.add(tempArticleCut);
            }
        }
        return newArticles;
    }

    @Override
    public ArticleCut cutByLocale(Article article, Locale locale) {
        if (article == null) {
            return null;
        }
        if (locale.getLanguage().equals(new Locale("ru").getLanguage())) {
            
            // ХОП ХОП КОСТЫЛИ
            if (StringUtils.killHtmlAndSpaces(article.getTextRu()).equals("")){
                return null;
            }

            if (StringUtils.killHtmlAndSpaces(article.getTitleRu()).equals("")){
                return null;
            }

            return new ArticleCut(article.getSlug(), article.getTitleRu(), article.getTextRu());

        }

        if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
            if (StringUtils.killHtmlAndSpaces(article.getTextEn()).equals("")){
                return null;
            }

            if (StringUtils.killHtmlAndSpaces(article.getTitleEn()).equals("")){
                return null;
            }


            return new ArticleCut(article.getSlug(), article.getTitleEn(), article.getTextEn());

        }
        return null;
    }
    
}
