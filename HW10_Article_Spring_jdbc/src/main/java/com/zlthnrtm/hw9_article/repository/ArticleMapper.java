/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.model.ArticleContract;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */

@Component(value = "articleMapper")
public class ArticleMapper implements RowMapper<Article>{

    @Override
    public Article mapRow(ResultSet rs, int i) throws SQLException {
        return ArticleContract.fromResultSet(rs);
    }
    
}
