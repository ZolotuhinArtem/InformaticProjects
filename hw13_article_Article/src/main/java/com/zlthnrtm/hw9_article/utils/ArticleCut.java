/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.utils;

import java.util.Objects;

/**
 *
 * @author arch
 */
public class ArticleCut {
    
    private String slug;
    
    private String title;
    
    private String text;

    public ArticleCut() {
    }

    public ArticleCut(String slug, String title, String text) {
        this.slug = slug;
        this.title = title;
        this.text = text;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.slug);
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.text);
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
        final ArticleCut other = (ArticleCut) obj;
        if (!Objects.equals(this.slug, other.slug)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticleCut{" + "slug=" + slug + ", title=" + title + ", text=" + text + '}';
    }
    
    
    
}
