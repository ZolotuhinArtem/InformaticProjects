package com.zlthnrtm.article.repository;

import com.zlthnrtm.article.model.Article;
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
   
   Article save(Article article);
   
   void remove(String slug);
   
   void remove(Long id);
}
