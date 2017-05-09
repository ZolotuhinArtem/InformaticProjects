/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.article.repository.exception;

/**
 *
 * @author arch
 */
public class WriteException extends Exception{

    public WriteException() {
    }

    public WriteException(String message) {
        super(message);
    }

    public WriteException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriteException(Throwable cause) {
        super(cause);
    }

    public WriteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
