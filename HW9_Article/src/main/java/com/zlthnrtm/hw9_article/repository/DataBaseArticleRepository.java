/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.repository;

import com.zlthnrtm.hw9_article.model.Article;
import com.zlthnrtm.hw9_article.model.ArticleContract;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */
@Component
@PropertySource("classpath:configuration/database.properties")
public class DataBaseArticleRepository implements ArticleRepository{

    @Autowired
    private Environment env;
    
    private String driver;
    
    private String url;
    
    private String name;
    
    private String password;
    
    private Connection conn;
    
    private String tableName;
    
    @PostConstruct
    public void init() {
        this.driver = env.getProperty("driver");
        this.url = env.getProperty("url");
        this.name = env.getProperty("name");
        this.password = env.getProperty("password");
        this.tableName = env.getProperty("table.articles.name");
        try {
            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
    @Override
    public List<Article> getAll() throws RepositoryReadException {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + this.tableName + ";");
            ArrayList<Article> articles = new ArrayList<>();
            while(rs.next()) {
                articles.add(ArticleContract.fromResultSet(rs));
            }
            return articles;
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DataBaseArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryReadException(ex.getMessage());
        }
    }

    @Override
    public Article getBySlug(String slug) throws RepositoryReadException {
        if (slug == null) {
            return null;
        }
        if (slug.equals("")) {
            return null;
        }
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM " + this.tableName + " WHERE slug=?;");
            statement.setString(1, slug);
            ResultSet rs = statement.executeQuery();
            rs.next();
            Article article = ArticleContract.fromResultSet(rs);
            return article;
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBaseArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryReadException(ex.getMessage());
        }
    }

    @Override
    public void add(Article article) throws RepositoryWriteException {
        if (article != null) {
            try {
                String sql = "INSERT INTO " +
                    this.tableName +
                    " (slug, title_ru, title_en, text_ru, text_en) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, article.getSlug());
                statement.setString(2, article.getTitleRu());
                statement.setString(3, article.getTitleEn());
                statement.setString(4, article.getTextRu());
                statement.setString(5, article.getTextEn());
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
                throw new RepositoryWriteException(ex.getMessage());
            }
        }   
    }

    @Override
    public void update(String slug, Article article) throws RepositoryWriteException {
        if ((article != null) && (slug != null)) {
            try {
                String sql = "UPDATE " +
                        this.tableName +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_SLUG + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TITLE_EN + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TITLE_RU + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TEXT_EN + "=?," +
                        " SET " + ArticleContract.ArticleEntry.COLUMN_TEXT_RU + "=?," +
                        " WHERE slug=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, article.getSlug());
                statement.setString(2, article.getTitleEn());
                statement.setString(3, article.getTitleRu());
                statement.setString(4, article.getTextEn());
                statement.setString(5, article.getTextRu());
                statement.setString(6, slug);
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseArticleRepository.class.getName()).log(Level.SEVERE, null, ex);
                throw new RepositoryWriteException(ex.getMessage());
            }
        }
    }
    
}
