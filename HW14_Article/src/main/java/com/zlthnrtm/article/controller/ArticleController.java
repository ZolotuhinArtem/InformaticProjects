/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.controller;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.ArticleLocalizated;
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
import com.zlthnrtm.article.service.ArticleService;
import com.zlthnrtm.article.service.LanguageService;
import com.zlthnrtm.article.service.exception.ArticleDeleteException;
import com.zlthnrtm.article.service.exception.ArticleFindException;
import com.zlthnrtm.article.service.exception.ArticleSaveException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arch
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    
    
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private LanguageService languageService;
    
    @Autowired
    private MessageSourceAccessor msa;
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(ModelMap map){
        map.put("articleForm", articleService.generateEmptyForm());
        return "article_form";
    }
    
    @RequestMapping(value = "/edit/{slug}", method = RequestMethod.GET)
    public String edit(@PathVariable String slug, RedirectAttributes redirectAttributes, ModelMap map){
        
        try {
            map.put("articleForm", articleService.generateForm(articleService.getBySlug(slug)));
            return "article_form";
        } catch (ArticleFindException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
            redirectAttributes.addFlashAttribute("message", msa.getMessage("error.edit") + "\n" + ex.getMessage());
            return "article_form";
        }
        
    }
    
    @RequestMapping(value = "/edit/{slug}", method = RequestMethod.POST)
    public String editPost(@PathVariable String slug, 
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("articleForm") ArticleForm articleForm,
            BindingResult result,
            ModelMap map){
        return add(redirectAttributes, articleForm, result, map);
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(
            RedirectAttributes redirectAttributes,
            @Valid @ModelAttribute("articleForm") ArticleForm articleForm,
            BindingResult result,
            ModelMap map
    ){
        map.put("languages", languageService.getLanguages());
        if (result.hasErrors()) {
            return "article_form";
        } else {
            System.out.println("###################################" + articleForm.toString());
            try {
                articleService.save(articleForm);
                redirectAttributes.addFlashAttribute("message", msa.getMessage("flash.added"));
                return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#addForm").build();
            } catch (ArticleSaveException ex) {
                Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
                redirectAttributes.addFlashAttribute("message", msa.getMessage("error.add") + "\n" + ex.getMessage());
                return "article_form";
            }
            
        }
    }
    
    
    
    @RequestMapping(value = "/delete/{slug}")
    public String delete(@PathVariable String slug, ModelMap map){
        
        try {
            articleService.delete(slug);
            map.put("message", msa.getMessage("message.deleted"));
            return "message";
        } catch (ArticleDeleteException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
            map.put("message", msa.getMessage("error.delete"));
            return "message";
        }
    }
    
    @RequestMapping(value = "/show/{slug}")
    public String show(@PathVariable String slug, ModelMap map){
        try {
            ArticleLocalizated articleLocalizated;
            
            articleLocalizated = articleService.getBySlugLocalizated(slug, LocaleContextHolder.getLocale());
            
            if (articleLocalizated == null) {
                map.put("message", msa.getMessage("error.unavailable_by_locale"));
                return "message";
            } else {
                map.put("article", articleLocalizated);
                return "article_view";
            }
        } catch (ArticleFindException ex) {
            Logger.getLogger(ArticleController.class.getName()).log(Level.SEVERE, null, ex);
            map.put("message", msa.getMessage("error.not_found"));
            return "message";
        }
    }
    
}
