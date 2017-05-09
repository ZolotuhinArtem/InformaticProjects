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
    
    @Size(min = 1, max = 128)
    private String slug;
    
    @Size(min = 1, max = 128)
    private String title;
    
    @Size(min = 1)
    private String content;
    
    private Language language;
    
    private User user;

    public ArticleForm() {
    }

    public ArticleForm(Long id, String slug, String title, String content, Language language, User user) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.content = content;
        this.language = language;
        this.user = user;
    }

    public ArticleForm(String slug, String title, String content) {
        this.slug = slug;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.slug);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.content);
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
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticleForm{" + "id=" + id + ", slug=" + slug + ", title=" + title + ", content=" + content + ", language=" + language + ", user=" + user + '}';
    }

    
}
