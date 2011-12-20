/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.util.ArrayList;

/**
 * File: MyParser.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class is used to parse any expression according to what
 *              we want to get
 *
 */

import java.util.*;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class MyParser {

    

    public static List<String> parseResponse(String message,String path,
            String value,boolean split){
        List<String> myList = new ArrayList<String>();
        String s = "";
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getJsonFactory();
            JsonParser parser;
            JsonNode nodeRoot;
            JsonNode node;
            JSONObject js = new JSONObject(message);
            JSONArray myArray = js.getJSONArray(path);
            
            int size = myArray.length();
            String tmp;
            for(int i = 0; i<size; i++){
                tmp =myArray.getString(i);
                parser = factory.createJsonParser(tmp);
                nodeRoot = mapper.readTree(parser);
                node = nodeRoot.findValue(value);
                // If split, we remove all caractere ""
                if(split){
                    myList.add(node.toString().replace("\"", ""));
                }
                else{
                    myList.add(node.toString());
                }
            }
                 
                 
                 
         
        }
        catch(Exception excep){
            excep.printStackTrace();
        }
        
        return myList;
    }

    
    
    public static String parseResponse(String message, String path){
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory fact = mapper.getJsonFactory();
        String response = "";
        
        try{
            JsonNode root = mapper.readTree(message);
            JsonNode node = root.findValue(path);
            response = node.toString();
            
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        return response.replace("\"", "");
    }
    
    
       
    
    
    public static List<String> setListTopic(String rawTopicName, String delimiter){
        StringTokenizer st = new StringTokenizer(rawTopicName,delimiter);
        List<String> listTopicName = new ArrayList<String>();
        String s;


        while(st.hasMoreTokens()){
            // All the topic the user give, will convert to upper case. This,
            // will permit further to remove all double topic.
            s = st.nextToken().trim().toUpperCase();
            // If s is empty, we don't add it to listTopicName
            if(!s.equals("")){
                listTopicName.add(s);
            }
        }

        return listTopicName;
    }

    
    
     /*
     * This method is used to remove all double element in a list of string
     */
    public static List<String> filterListTopic(List<String> myList){
        List<String> tmp = myList;
        
        int size = tmp.size();
        int i = 0;
        int j;
        while(i<size){
            j = tmp.lastIndexOf(tmp.get(i));

            if(i != j){
                tmp.remove(j);
                size = tmp.size();
            }
            else{
                i +=1;
            }
        }
        return tmp;
    }

    
    
    
    public static String displayList(List<String> list){
        Iterator it = list.iterator();
        String s ="";
        int i = 0;
       
        while(it.hasNext()){
            s += "\n # element["+(i++)+"] = "+it.next();       
        }
       

        return s;
    }
}
