/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.repository;

import com.zlthnrtm.article.model.Article;
import com.zlthnrtm.article.repository.exception.ReadException;
import com.zlthnrtm.article.repository.exception.WriteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author arch
 */
@Transactional
@Repository
public class HibernateArticleRepository implements ArticlesRepository{

    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Article findOne(String slug) throws ReadException {
        try {
            CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
            CriteriaQuery<Article> criteria = criteriaBuilder.createQuery(Article.class);
            Root<Article> articleRoot = criteria.from(Article.class);
            criteria.select(articleRoot);
            criteria.where(criteriaBuilder.equal(articleRoot.get("slug"), slug));
            Article article = entityManager.createQuery(criteria).getSingleResult();
            return article;
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new ReadException(ex.getMessage());
            
        }
        
    }
    
     @Override
    public Article findOne(Long id) throws ReadException {
        try {
            CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
            CriteriaQuery<Article> criteria = criteriaBuilder.createQuery(Article.class);
            Root<Article> articleRoot = criteria.from(Article.class);
            criteria.select(articleRoot);
            criteria.where(criteriaBuilder.equal(articleRoot.get("id"), id));
            Article article = entityManager.createQuery(criteria).getSingleResult();
            return article; 
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new ReadException(ex.getMessage());
            
        }
    }

    @Override
    public List<Article> findByPage(int page, int itemsOnPage) throws ReadException {
        try {
            CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
            CriteriaQuery<Article> criteria = criteriaBuilder.createQuery(Article.class);
            Root<Article> articleRoot = criteria.from(Article.class);
            criteria.select(articleRoot);
            TypedQuery<Article> typedQuery = entityManager.createQuery(criteria);
            typedQuery.setFirstResult((page - 1) * itemsOnPage);
            typedQuery.setMaxResults(itemsOnPage);
            List<Article> articles = typedQuery.getResultList();
            return articles;
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new ReadException(ex.getMessage());
            
        }
    }

    @Override
    public long pageCount(int itemsOnPage) throws ReadException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
            Root<Article> rootArticle = criteria.from(Article.class);
            criteria.select(builder.count(rootArticle));
            Long entitiesCount = entityManager.createQuery(criteria).getSingleResult();
            return entitiesCount / itemsOnPage + ((entitiesCount % itemsOnPage == 0) ? 0 : 1);
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new ReadException(ex.getMessage());
        }
        
    }
    
    @Override
    public List<Article> findAll() throws ReadException {
        try {
            CriteriaBuilder builder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Article> criteria = builder.createQuery(Article.class);
            Root<Article> rootArticle = criteria.from(Article.class);
            criteria.select(rootArticle);
            List<Article> list = entityManager.createQuery(criteria).getResultList();
            return list;
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new ReadException(ex.getMessage());
            
        }
    }

    
    
    @Override
    public Article save(Article article) throws WriteException {
        try {
            if (article.getId() == null) {
                entityManager.persist(article);
            } else {
                entityManager.merge(article);
            }

            return article;
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new WriteException(ex.getMessage());
            
        }
    }

    @Override
    public void remove(String slug) throws WriteException {
        try {
            Article article = findOne(slug);
            if (article != null) {
                entityManager.remove(article);
            }
        } catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new WriteException(ex.getMessage());
            
        } catch (ReadException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new WriteException(ex.getMessage());
        }
        
    }

    @Override
    public void remove(Long id) throws WriteException {
        try {
            Article article = findOne(id);
            if (article != null) {
                entityManager.remove(article);
            }
        }  catch (PersistenceException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new WriteException(ex.getMessage());
            
        } catch (ReadException ex) {
            Logger.getLogger(HibernateArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new WriteException(ex.getMessage());
        }
    }

}
