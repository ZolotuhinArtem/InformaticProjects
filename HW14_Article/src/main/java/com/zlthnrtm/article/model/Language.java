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
public class Language {
    
    private String name;
    
    private String systemName;

    public Language() {
    }

    
    public Language(String name, String systemName) {
        this.name = name;
        this.systemName = systemName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.systemName);
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
        final Language other = (Language) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.systemName, other.systemName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Language{" + "name=" + name + ", systemName=" + systemName + '}';
    }
    
    
    
    
}
