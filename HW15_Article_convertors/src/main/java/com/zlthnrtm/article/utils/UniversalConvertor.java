/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.utils;

import com.zlthnrtm.article.jpa_repository.LanguageRepository;
import com.zlthnrtm.article.jpa_repository.UserRepository;
import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.model.ArticleForm;
import com.zlthnrtm.article.model.Language;
import com.zlthnrtm.article.model.User;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

/**
 *
 * @author arch
 */
public class UniversalConvertor implements GenericConverter{

    
    @Autowired
    private LanguageRepository languageRepository;
    
    @Autowired
    private UserRepository userRepository;

    public UniversalConvertor() {
        super();
    }

    
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
      Set<ConvertiblePair> types = new HashSet<GenericConverter.ConvertiblePair>();
      types.add(new ConvertiblePair(String.class, Language.class));
      types.add(new ConvertiblePair(String.class, User.class));
      types.add(new ConvertiblePair(ArticleForm.class, Article.class));
      return types;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType){
        
        if (String.class.equals(sourceType.getType())) {
            if (!StringUtils.hasText((String) source) || ((String) source).equals("NONE")) {
                return null;
            }
            Long id = Long.parseLong((String) source);
            if (Language.class.equals(targetType.getType())) {
                return languageRepository.findOne(id);
            }
            if (User.class.equals(targetType.getType())) {
                return userRepository.findOne(id);
            }
            throw new IllegalArgumentException("I cant convert String to " + targetType.getType());
        }
        
        if (ArticleForm.class.equals(sourceType.getType())) {
            if (source == null) {
                throw new IllegalArgumentException("Source object is null!");
            }
            try {
                ArticleForm articleForm = (ArticleForm) source;
                Article article = new Article(articleForm.getId(), 
                        articleForm.getSlug(), 
                        articleForm.getTitle(), 
                        articleForm.getContent(), 
                        articleForm.getLanguage(), 
                        articleForm.getUser());
                return article;
            } catch (ClassCastException ex) {
                Logger.getLogger(UniversalConvertor.class.getName()).log(Level.SEVERE, ex.getMessage());
                throw new IllegalArgumentException("I cant cast source object to ArticleForm! Source object is " + source.getClass().getName());
            }
        }
        
        throw new IllegalArgumentException("I cant cast" + sourceType.getName() + " to " + targetType.getName());
    }
    
    
}
