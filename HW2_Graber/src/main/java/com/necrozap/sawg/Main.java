/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necrozap.sawg;

import com.sun.istack.internal.NotNull;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author artem
 */
public class Main {
    public static void main(String[] args) {
        
        
        try {
            URL url = new URL("https://www.citilink.ru/catalog/power_tools_and_garden_equipments/saws/chainsaws/?available=1&status=55395790&p=1");
            
            List<JSONObject> list = grab(url);
            
            for(JSONObject i: list) {
                System.out.println(JsonSimpleUtils.toGoodString(i));
            }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<JSONObject> grab(@NotNull URL url) {
        List<JSONObject> superList = new LinkedList<JSONObject>();
        try {
            
            HtmlCleaner cleaner = new HtmlCleaner();
            
            TagNode node = cleaner.clean(url.openConnection().getInputStream());
            
            String xPath = "//div[@class=\"page_listing\"]/section/ul/li[@class=\"next\"]/a/@href";
            
            Object[] nodes = node.evaluateXPath(xPath);
            
            superList.addAll( grabPage( url ) );
            
            for (int i = 0; i < nodes.length; i++) {
                superList.addAll( grab( new URL( nodes[i].toString() ) ) );
                break;
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPatherException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return superList;
    }
    
    public static List<JSONObject> grabPage(@NotNull URL url) {
        ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        try {
            HtmlCleaner cleaner = new HtmlCleaner();
            
            TagNode node = cleaner.clean(url.openConnection().getInputStream());
            
            String xPathExpressionData = "//div[@class=\"subcategory-product-item product_data__gtm-js  product_data__pageevents-js ddl_product\"]/@data-params";
            String xPathExpressionImage = "//div[@class=\"subcategory-product-item product_data__gtm-js  product_data__pageevents-js ddl_product\"]/div[@class=\"subcategory-product-item__body\"]/div[@class=\"image subcategory-product-item__image\"]/div[@class=\"wrap-img\"]/a/img/@src";
            
            Object[] nodesData = node.evaluateXPath(xPathExpressionData);
            Object[] nodesImg = node.evaluateXPath(xPathExpressionImage);
            
            String strData = null;
            String strImage = null;
            
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = null;
            
            for (int i = 0; i < nodesData.length; i++) {
                
                strData = (String) nodesData[i];
                strData = strData.replace("&quot;", "\"");
                strData = strData.replace("&quot;", "\"");
                jsonObject = (JSONObject) jsonParser.parse(strData);
                
                if (i < nodesImg.length) {
                    strImage = (String) nodesImg[i];
                    jsonObject.put("image", strImage);
                }
                
                list.add(jsonObject);
            }
        } catch (XPatherException | ParseException | IOException ex) {
            Logger.getLogger( Main.class.getName() ).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
