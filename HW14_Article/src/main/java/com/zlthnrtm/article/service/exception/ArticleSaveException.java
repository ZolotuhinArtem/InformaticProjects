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
public class ArticleSaveException extends Exception{

    public ArticleSaveException() {
    }

    public ArticleSaveException(String message) {
        super(message);
    }

    public ArticleSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArticleSaveException(Throwable cause) {
        super(cause);
    }

    public ArticleSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
