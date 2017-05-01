/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.model;

import java.util.Objects;

/**
 *
 * @author arch
 */
public class ArticleLocalizated {
    
    private String slug;
    
    private String head;
    
    private String body;
    
    private String language;

    public ArticleLocalizated() {
    }

    public ArticleLocalizated(String slug, String head, String body, String language) {
        this.slug = slug;
        this.head = head;
        this.body = body;
        this.language = language;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.slug);
        hash = 83 * hash + Objects.hashCode(this.head);
        hash = 83 * hash + Objects.hashCode(this.body);
        hash = 83 * hash + Objects.hashCode(this.language);
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
        final ArticleLocalizated other = (ArticleLocalizated) obj;
        if (!Objects.equals(this.slug, other.slug)) {
            return false;
        }
        if (!Objects.equals(this.head, other.head)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticleLocalizated{" + "slug=" + slug + ", head=" + head + ", body=" + body + ", language=" + language + '}';
    }
    
}
