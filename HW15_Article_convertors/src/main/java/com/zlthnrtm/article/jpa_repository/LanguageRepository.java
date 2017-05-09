/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.jpa_repository;

import com.zlthnrtm.article.model.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arch
 */
@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
    
    @Query("SELECT l FROM Language l WHERE l.systemName = ?1 OR LOWER(l.systemName) = LOWER(?1) OR UPPER(l.systemName) = UPPER(?1)")
    Language findBySystemName(String systemName);
    
    @Query("SELECT l FROM Language l WHERE l.name = ?1 OR LOWER(l.name) = LOWER(?1) OR UPPER(l.name) = UPPER(?1)")
    Language findByName(String name);
}
