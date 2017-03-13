/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.database.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author artem
 */
public class DataBaseConnector {
//    private final static String DRIVER = "org.postgresql.Driver";
//    private final static String CONNECTION_URI = "jdbc:postgresql://localhost/notebook";
//    private final static String LOGIN = "postgres";
//    private final static String PASSWORD = "123456";

    private String driver;
    private String connectionURI;
    private String login;
    private String password;

    public DataBaseConnector(String driver, String connectionURI, String login, String password) {
        this.driver = driver;
        this.connectionURI = connectionURI;
        this.login = login;
        this.password = password;
    }
    
    
    public Connection getConnection() throws DBException{
        Connection conn;
        try{
          Class.forName(driver);
          conn = DriverManager.getConnection(connectionURI, login, password);
        }
        catch(ClassNotFoundException ex){
          throw new DBException("Can't find DB driver.");
        } catch (SQLException ex) {
          throw new DBException("Can't connect to DB (" + ex.getErrorCode() + ": " + ex.getMessage() + ").");
        }
        return conn;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getConnectionURI() {
        return connectionURI;
    }

    public void setConnectionURI(String connectionURI) {
        this.connectionURI = connectionURI;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
