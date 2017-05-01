/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.hw9_article.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arch
 */
public class ArticleContract {
    
    public static Article fromResultSet(ResultSet rs) throws SQLException{
        Article tempArticle = new Article();
        tempArticle.setSlug(rs.getString(ArticleEntry.COLUMN_SLUG));
        if (tempArticle.getSlug() == null) {
            throw new SQLException("Invalid slug");
        } else {
            if (tempArticle.getSlug().equals("")) {
                throw new SQLException("Invalid slug");
            }
        }
        tempArticle.setTitleEn(rs.getString(ArticleEntry.COLUMN_TITLE_EN));
        tempArticle.setTitleRu(rs.getString(ArticleEntry.COLUMN_TITLE_RU));
        tempArticle.setTextEn(rs.getString(ArticleEntry.COLUMN_TEXT_EN));
        tempArticle.setTextRu(rs.getString(ArticleEntry.COLUMN_TEXT_RU));
        return tempArticle;
    }
    
    public static class ArticleEntry{
        public static final String COLUMN_SLUG = "slug";
        public static final String COLUMN_TITLE_RU = "title_ru";
        public static final String COLUMN_TITLE_EN = "title_en";
        public static final String COLUMN_TEXT_RU = "text_ru";
        public static final String COLUMN_TEXT_EN = "text_en";
    }
}
