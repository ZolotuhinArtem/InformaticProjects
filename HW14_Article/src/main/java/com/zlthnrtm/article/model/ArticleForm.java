/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.model;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Size;

/**
 *
 * @author arch
 */
public class ArticleForm {
    
    private Long id;
    
    @Size(min = 1, max = 256)
    private String slug;
    
    private List<Text> texts;

    public ArticleForm() {
    }

    public ArticleForm(Long id, String slug, List<Text> texts) {
        this.id = id;
        this.slug = slug;
        this.texts = texts;
    }

    

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<Text> getTexts() {
        return texts;
    }

    public void setTexts(List<Text> texts) {
        this.texts = texts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.slug);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticleForm other = (ArticleForm) obj;
        if (!Objects.equals(this.slug, other.slug)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticleForm{" + "id=" + id + ", slug=" + slug + ", texts=" + texts + '}';
    }

    
    
    
    
}
