package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;
/**
 *
 * @author arch
 */
@NoRepositoryBean
public interface ArticlesRepository {
    
   Article findOne(String slug);
   
   Article findOne(Long id);
   
   List<Article> findByPage(int page, int itemsOnPage);
   
   long pageCount(int itemsOnPage);
   
   List<Article> findAll();
   
   void save(Article article);
   
}
