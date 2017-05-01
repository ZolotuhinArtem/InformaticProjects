/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
    @Column(name = "slug")
    private String slug;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="article", fetch = FetchType.LAZY)
    private Set<Text> texts;

    public Article() {
    }

    public Article(Long id, String slug, Set<Text> texts) {
        this.id = id;
        this.slug = slug;
        this.texts = texts;
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

    public Set<Text> getTexts() {
        return texts;
    }

    public void setTexts(Set<Text> texts) {
        this.texts = texts;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.slug);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

   

    
    
}


