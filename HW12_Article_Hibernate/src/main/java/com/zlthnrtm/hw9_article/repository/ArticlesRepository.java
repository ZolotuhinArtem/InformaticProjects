package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author arch
 */
@Repository(value = "articlesRepository")
public interface ArticlesRepository extends PagingAndSortingRepository<Article, String>{}
