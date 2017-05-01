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
    
    
    @Size(min = 1, max = 256)
    @Id
    @Column(name = "slug", unique = true, nullable = false)
    private String slug;
    
    @Column(name = "title_ru")
    private String titleRu;
    
    @Column(name = "title_en")
    private String titleEn;
    
    @Column(name = "text_ru")
    private String textRu;
    
    @Column(name = "text_en")
    private String textEn;

    public Article() {}

    public Article(String slug, String titleRu, String titleEn, String textRu, String textEn) {
        this.slug = slug;
        this.titleRu = titleRu;
        this.titleEn = titleEn;
        this.textRu = textRu;
        this.textEn = textEn;
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
        int hash = 3;
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
        return "Article{" + "slug=" + slug + ", titleRu=" + titleRu + ", titleEn=" + titleEn + ", textRu=" + textRu + ", textEn=" + textEn + '}';
    }

    
    
    
}
