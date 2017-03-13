/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.database.tools;

/**
 *
 * @author artem
 */
public class DBException extends Exception {
    public DBException(String cant_find_DB_driver) {
        super(cant_find_DB_driver);
    }
    
}
