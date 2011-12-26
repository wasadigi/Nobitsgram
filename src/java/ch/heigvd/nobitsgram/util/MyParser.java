/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import ch.heigvd.nobitsgram.model.UserInstagram;
import java.io.IOException;
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

    
    
    public static List<UserInstagram> getUsersFromJson(String message,String path,
            String username, String pictureProfile,String id){
        List<UserInstagram> myList = new ArrayList<UserInstagram>();
        UserInstagram userInsta;         
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getJsonFactory();
            JsonParser parser;
            JsonNode nodeRoot;
            JsonNode nodeUsername;
            JsonNode nodePictProf;
            JsonNode nodeId;
            JSONObject js = new JSONObject(message);
            JSONArray myArray = js.getJSONArray(path);
            
            int size = myArray.length();            
            
            String tmp;
            // For each user in JSON, we create an instance of UserInstagram
            for(int i = 0; i<size; i++){
                tmp =myArray.getString(i);
                parser = factory.createJsonParser(tmp);
                nodeRoot = mapper.readTree(parser);
                userInsta = new UserInstagram();
                // we get the node of username
                nodeUsername = nodeRoot.findValue(username);
                // we set the value of the username to the instance of UserInstagram
                userInsta.setUsername(nodeUsername.toString().replace("\"",""));
                
                // we get the node of picture profile
                nodePictProf = nodeRoot.findValue(pictureProfile);
                // we set the value of picture profile to the instance of UserInstagram
                userInsta.setProfilePicture(nodePictProf.toString().replace("\"",""));
                
                // We get the node of Id
                nodeId = nodeRoot.findValue(id);
                // We set the value of the Id to the instance of UserInstagram
                userInsta.setId(nodeId.toString().replace("\"",""));
                
                myList.add(userInsta);
            }
        }
        catch(Exception excep){
            excep.printStackTrace();
        }
        
        return myList;
    }
    
    
    public static String parseResponse(String message, String path,boolean split){
        ObjectMapper mapper = new ObjectMapper();        
        String response = "";
        
        try{
            JsonNode root = mapper.readTree(message);
            JsonNode node = root.findValue(path);
            response = node.toString();
            
        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        if(split){
            return response.replace("\"", "");
        }
        else{
            return response;
        }
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
    
    public static String displayUser(List<UserInstagram> list){
        Iterator it = list.iterator();
        String s ="";
        int i = 0;
        UserInstagram user;
        while(it.hasNext()){
            user = (UserInstagram)it.next();
            s += "\n***************\n# element["+(i++)+"] \n"+user;
            s +="\n"+displayList(user.getListPicture());
        }
       
        return s;
    }
    
}
