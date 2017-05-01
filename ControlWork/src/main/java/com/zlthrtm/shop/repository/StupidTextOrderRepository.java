/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthrtm.shop.repository;

import com.zlthrtm.shop.model.Order;
import com.zlthrtm.shop.repository.utils.OrderUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

/**
 *
 * @author arch
 */
@Component
public class StupidTextOrderRepository implements OrderRepository{

    // Sorry, i had no time
    public static File file = new File(StupidTextOrderRepository.class.getResource("/database").getPath());
    
    
    @Override
    public void add(Order order) {
        checkFile();
        ArrayList<Order> list = this.getAll();
        list.add(order);
        
        try(FileReader in = new FileReader(file); 
            FileWriter out = new FileWriter(file)) {
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(in);
            arr.add(OrderUtils.toJson(order));
            arr.writeJSONString(out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Order> getAll() {
        checkFile();
        try(FileReader in = new FileReader(file)) {
            JSONParser parser = new JSONParser();
            JSONArray arr = (JSONArray) parser.parse(in);
            ArrayList<Order> list = new ArrayList<>(arr.size());
            for (int i = 0; i < arr.size(); i++) {
                list.add(OrderUtils.fromJson((JSONObject)arr.get(i)));
            }
            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    private void checkFile(){
        if (!file.exists()) {
            try (FileWriter out = new FileWriter(file)){
                file.createNewFile();
                JSONArray arr = new JSONArray();
                arr.writeJSONString(out);
            } catch (IOException ex) {
                Logger.getLogger(StupidTextOrderRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
