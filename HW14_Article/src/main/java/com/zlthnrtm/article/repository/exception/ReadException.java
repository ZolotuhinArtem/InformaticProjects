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
public class ReadException extends Exception{

    public ReadException() {
    }

    public ReadException(String message) {
        super(message);
    }

    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadException(Throwable cause) {
        super(cause);
    }

    public ReadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
