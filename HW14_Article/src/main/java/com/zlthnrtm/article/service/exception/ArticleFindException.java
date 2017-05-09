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
public class ArticleFindException extends Exception{

    public ArticleFindException() {
    }

    public ArticleFindException(String message) {
        super(message);
    }

    public ArticleFindException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleFindException(Throwable cause) {
        super(cause);
    }

    public ArticleFindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
