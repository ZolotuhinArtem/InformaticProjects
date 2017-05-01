/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.controller;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.model.ArticleCut;
import com.zlthnrtm.hw9_article.repository.ArticleRepository;
import com.zlthnrtm.hw9_article.repository.RepositoryReadException;
import com.zlthnrtm.hw9_article.service.ArticleCutter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

/**
 *
 * @author arch
 */
@Controller
public class MainController {
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private ArticleCutter articleCutter;
    
    @Autowired 
    private LocaleResolver localeResolver;
    
    @RequestMapping("/")
    public String mainPage(ModelMap map){
        try {
            List<Article> articles = articleRepository.getAll();
            List<ArticleCut> articleCuts = articleCutter.cutByLoclae(articles, LocaleContextHolder.getLocale());
            map.put("articles", articleCuts);
        } catch (RepositoryReadException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "main";
    }
    
}
