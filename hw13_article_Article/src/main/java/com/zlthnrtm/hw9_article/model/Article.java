/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author arch
 */
@Entity
@Table(name = "articles")
public class Article implements Serializable{    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Size(min = 1, max = 256)
    @Column(name = "slug", unique = true)
    private String slug;
    
    @Size(min = 0, max = 256)
    @Column(name = "title_ru")
    private String titleRu;
    
    @Size(min = 0, max = 256)
    @Column(name = "title_en")
    private String titleEn;
    
    @Column(name = "text_ru")
    private String textRu;
    
    @Column(name = "text_en")
    private String textEn;

    public Article() {}

    public Article(long id, String slug, String titleRu, String titleEn, String textRu, String textEn) {
        this.id = id;
        this.slug = slug;
        this.titleRu = titleRu;
        this.titleEn = titleEn;
        this.textRu = textRu;
        this.textEn = textEn;
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

    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTextRu() {
        return textRu;
    }

    public void setTextRu(String textRu) {
        this.textRu = textRu;
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.slug);
        hash = 59 * hash + Objects.hashCode(this.titleRu);
        hash = 59 * hash + Objects.hashCode(this.titleEn);
        hash = 59 * hash + Objects.hashCode(this.textRu);
        hash = 59 * hash + Objects.hashCode(this.textEn);
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
        final Article other = (Article) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.slug, other.slug)) {
            return false;
        }
        if (!Objects.equals(this.titleRu, other.titleRu)) {
            return false;
        }
        if (!Objects.equals(this.titleEn, other.titleEn)) {
            return false;
        }
        if (!Objects.equals(this.textRu, other.textRu)) {
            return false;
        }
        if (!Objects.equals(this.textEn, other.textEn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", slug=" + slug + ", titleRu=" + titleRu + ", titleEn=" + titleEn + ", textRu=" + textRu + ", textEn=" + textEn + '}';
    }

    

    
    
    
}
