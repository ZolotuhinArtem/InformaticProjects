/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.model.ArticleContract;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */
@Component
@PropertySource("classpath:configuration/database.properties")
public class JdbcArticleRepository implements ArticleRepository{

    @Autowired
    private Environment env;
    
    @Autowired
    @Qualifier("articleMapper")
    private RowMapper<Article> articleRowMapper;
    
    private String tableName;
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("dataSource")
    public void jdbcTemplate(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @PostConstruct
    public void init() {
        this.tableName = env.getProperty("table.articles.name");
    }

    
    
    @Override
    public List<Article> getAll() throws RepositoryReadException {
        List<Article> list = jdbcTemplate.query("SELECT * FROM " + this.tableName + ";", articleRowMapper);
        return list;
    }

    @Override
    public Article getBySlug(String slug) throws RepositoryReadException {
        if (slug == null) {
            return null;
        }
        if (slug.equals("")) {
            return null;
        }
        String sql = "SELECT * FROM " + this.tableName + " WHERE slug=?;";
        return jdbcTemplate.queryForObject(sql , new Object[] {slug}, articleRowMapper);
    }

    @Override
    public void add(Article article) throws RepositoryWriteException {
        if (article != null) {
            String sql = "INSERT INTO " +
                    this.tableName +
                    " (slug, title_ru, title_en, text_ru, text_en) VALUES (?, ?, ?, ?, ?);";
            jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, article.getSlug());
                    ps.setString(2, article.getTitleRu());
                    ps.setString(3, article.getTitleEn());
                    ps.setString(4, article.getTextRu());
                    ps.setString(5, article.getTextEn());
                }
            });
        } else {
            throw new RepositoryWriteException("article is null");
        }
    }

    @Override
    public void update(String slug, Article article) throws RepositoryWriteException {
        if ((article != null) && (slug != null)) {
            String sql = "UPDATE " +
                        this.tableName +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_SLUG + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TITLE_EN + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TITLE_RU + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TEXT_EN + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TEXT_RU + "=?," +
                        " WHERE slug=?;";
            jdbcTemplate.update(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setString(1, article.getSlug());
                    ps.setString(2, article.getTitleEn());
                    ps.setString(3, article.getTitleRu());
                    ps.setString(4, article.getTextEn());
                    ps.setString(5, article.getTextRu());
                    ps.setString(6, slug);
                }
            });
        } else {
            throw new RepositoryWriteException("article or slug are null");
        }
    }
    
}
