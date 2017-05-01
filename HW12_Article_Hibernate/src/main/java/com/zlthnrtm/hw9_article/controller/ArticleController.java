/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.controller;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.utils.ArticleCut;
import com.zlthnrtm.hw9_article.service.ArticleCutter;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.zlthnrtm.hw9_article.repository.ArticlesRepository;

/**
 *
 * @author arch
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    
    @Autowired
    private ArticlesRepository articleRepository;
    
    @Autowired
    private ArticleCutter articleCutter;
    
    @Autowired
    private MessageSourceAccessor msa;
    
    
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap map){
        map.put("article", new Article());
        return "article_form";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("article") Article article,
            BindingResult result,
            ModelMap map
    ){
        if (result.hasErrors()) {
            return "article_form";
        } else {
            articleRepository.save(article);
            redirectAttributes.addFlashAttribute("message", msa.getMessage("flash.added"));
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#addForm").build();
        }
    }
    
    @RequestMapping(value = "/show/{slug}")
    public String show(@PathVariable String slug, ModelMap map){
        Article article;
        
        article = articleRepository.findOne(slug);
        ArticleCut articleCut = articleCutter.cutByLocale(article, LocaleContextHolder.getLocale());
        if (articleCut == null) {
            map.put("errorPageMessage", msa.getMessage("error.unavailable_by_locale"));
            return "error";
        } else {
            map.put("article", articleCut);
            return "article_view";
        }
    }
    
}
