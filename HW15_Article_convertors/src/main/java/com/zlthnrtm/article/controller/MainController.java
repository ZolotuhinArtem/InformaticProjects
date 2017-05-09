/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.controller;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleLocalizated;
import com.zlthnrtm.article.model.Language;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestParam;
import com.zlthnrtm.article.service.ArticleService;
import com.zlthnrtm.article.service.LanguageService;
import com.zlthnrtm.article.service.exception.ArticleFindException;
import org.springframework.context.support.MessageSourceAccessor;

/**
 *
 * @author arch
 */
@Controller
@PropertySource("classpath:configuration/database.properties")
public class MainController {
    
    public static final int DEFAULT_PAGE = 1;
    
    public static final int DEFAULT_PAGE_SIZE = 3;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private LanguageService languageService;
    
    @Autowired
    private MessageSourceAccessor msa;
    
    @RequestMapping("/")
    public String mainPage(@RequestParam(name = "page",
            defaultValue = "1",
            required = false) String paramPage, ModelMap map){
        map.put("languages", languageService.getLanguages());
        Language lang = languageService.getByLocale(LocaleContextHolder.getLocale());
        try {
            
            
            int page = DEFAULT_PAGE;
            
            int itemsOnPage = DEFAULT_PAGE_SIZE;
            
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
            
            
            //List<Article> articles = articleService.getByPageLocalizated(page, itemsOnPage, lang);
            List<Article> articles = articleService.getByPage(page, itemsOnPage);
            
            map.put("page_count", articleService.getPageCount(itemsOnPage));
            map.put("page", page);
            
            map.put("articles", articles);
            return "main";
        } catch (ArticleFindException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            map.put("message", msa.getMessage("error.internal"));
            return "message";
        }
    }
    
}
