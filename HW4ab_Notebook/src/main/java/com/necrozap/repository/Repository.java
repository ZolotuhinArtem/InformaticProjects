/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.repository;

/**
 *
 * @author artem
 */
public interface Repository {
    
    public void save(Object obj) throws RepositoryException;
    
    public Object[] load() throws RepositoryException;
    
    public void clear() throws RepositoryException;
}
