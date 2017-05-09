/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.jpa_repository;

import com.zlthnrtm.article.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arch
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{}
