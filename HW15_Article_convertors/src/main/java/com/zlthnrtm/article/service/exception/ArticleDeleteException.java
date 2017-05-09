/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.service.exception;

/**
 *
 * @author arch
 */
public class ArticleDeleteException extends Exception{

    public ArticleDeleteException() {
    }

    public ArticleDeleteException(String message) {
        super(message);
    }

    public ArticleDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleDeleteException(Throwable cause) {
        super(cause);
    }

    public ArticleDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
