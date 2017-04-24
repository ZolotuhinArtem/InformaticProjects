package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
//import java.io.Serializable;
//import java.util.List;
//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arch
 */
@Repository(value = "articlesRepository")
public interface ArticlesRepository extends PagingAndSortingRepository<Article, String>{
    
//    @Autowired
//    private SessionFactory sessionFactory;
//    
//    private String tableName;
//
//    public ArticlesRepository() {
//    }
//
//    
//    
//    public ArticlesRepository(String tableName) {
//        this.tableName = tableName;
//    }
//    
//    public Article getOne(String slug) {
//        Session s = sessionFactory.openSession();
//        s.beginTransaction();
//        Criteria cr = s.createCriteria(Article.class);//"SELECT * FROM " + tableName + " WHERE slug=")
//        cr.add(Restrictions.eq("slug", slug));
//        cr.
//    }
//    
//    public List<Article> findAll(){
//        Session s = sessionFactory.openSession();
//        s.beginTransaction();
//        List<Article> articlesList = s.createQuery("From " + tableName).list();
//        s.getTransaction().commit();
//        s.close();
//        return articlesList;
//    }
    
}
