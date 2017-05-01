/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.controller;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.utils.ArticleCut;
import com.zlthnrtm.hw9_article.service.ArticleCutter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zlthnrtm.hw9_article.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author arch
 */
@Controller
@PropertySource("classpath:configuration/database.properties")
public class MainController {
    
    public static final int DEFAULT_PAGE = 1;
    
    public static final int DEFAULT_ITEMS_ON_PAGE = 3;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private ArticlesRepository articleRepository;
    
    @Autowired
    private ArticleCutter articleCutter;
   
    
    @RequestMapping("/")
    public String mainPage(@RequestParam(name = "page",
            defaultValue = "1",
            required = false) String paramPage, ModelMap map){
        
        
        int page = DEFAULT_PAGE;
        
        int itemsOnPage = DEFAULT_ITEMS_ON_PAGE;
        
        try {
            String strItemsOnPage = env.getProperty("looks.items_on_page");
            itemsOnPage = Integer.parseInt(strItemsOnPage);
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            page = Integer.parseInt(paramPage);
        } catch (NullPointerException | ClassCastException | NumberFormatException ex ){
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Article> articles = articleRepository.findByPage(page, itemsOnPage);
        
        List<ArticleCut> articleCuts = articleCutter.cutByLoclae(articles, LocaleContextHolder.getLocale());
        
        map.put("page_count", articleRepository.pageCount(itemsOnPage));
        map.put("page", page + 1);
        
        map.put("articles", articleCuts);
        return "main";
    }
    
}
