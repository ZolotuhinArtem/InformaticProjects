/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.repository;

import com.necrozap.database.tools.DBException;
import com.necrozap.database.tools.DataBaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artem
 */
public class NotebookDataBaseRepository implements Repository{

    private DataBaseConnector connector;

    public NotebookDataBaseRepository(DataBaseConnector connector) {
        this.connector = connector;
    }
    
    @Override
    public void save(Object obj) throws RepositoryException {
        
        try(Connection conn = this.connector.getConnection()) {
            PreparedStatement st = conn.prepareStatement("INSERT INTO notes (note) values(?);"); 
            st.setString(1, obj.toString());
            st.execute();
        } catch (DBException | SQLException ex) {
            Logger.getLogger(NotebookDataBaseRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException("Save error!");
        }
            
    }

    @Override
    public Object[] load() throws RepositoryException {
        ArrayList<Object> array;
        array = new ArrayList<>();
        try(Connection conn = this.connector.getConnection()) {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM NOTES;");
            ResultSet result = st.executeQuery();
            while(result.next()){
                array.add(result.getString("note"));
            }
        } catch (DBException | SQLException ex) {
            Logger.getLogger(NotebookDataBaseRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException("Load error");
        }
        return array.toArray();
    }

    @Override
    public void clear() throws RepositoryException {
        try(Connection conn = this.connector.getConnection()) {
            PreparedStatement st = conn.prepareStatement("DELETE FROM NOTES;");
            st.execute();
        } catch (DBException | SQLException ex) {
            Logger.getLogger(NotebookDataBaseRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException("Clear error!");
        }
    }

    public DataBaseConnector getConnector() {
        return connector;
    }

    public void setConnector(DataBaseConnector connector) {
        this.connector = connector;
    }
    
}
