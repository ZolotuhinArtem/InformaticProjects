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
public class PostgresDataBaseConnector extends DataBaseConnector{
   
    private final static String DRIVER = "org.postgresql.Driver";
    
    public PostgresDataBaseConnector(String connectionURI, String login, String password) {
        super(DRIVER, connectionURI, login, password);
    }
   
    
    
}
