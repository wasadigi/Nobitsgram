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
import java.util.Collection;

public class MyParser {


    /*
     * This method return a list of url. Those url are contained in the
     * parameter var
     * Instagram return 3 url for the same
     * image. Default, we choose the bigger image which have his url end by "_7"
     *
     */
    public static List<String> getListUrls(String var){
        String url="";

        // List of url which is return;
        List<String> listUrl= new ArrayList<String>();

        // Begining of the url
        String beginExpression = "\"url\":";

        // We want to extract url for image, then the extension is ".jpg"
        String endExpression = "_7.jpg";


        // Temporary variable is used to scan var
        String tmp = var;

        // Scan var until tmp don't contain any beginExpression or endExpression
        while(tmp.contains(beginExpression) && tmp.contains(endExpression)){

            int i = tmp.indexOf(beginExpression);

            // We wont to extract the url, and url begin with "http://"
            i = tmp.indexOf("http://", i);

            int j = tmp.indexOf(endExpression, i);
            url = tmp.substring(i,j+endExpression.length());

            listUrl.add(url);
            tmp = tmp.substring(j+endExpression.length());
        }
        return listUrl;

    }


    /*
     *
     *
     */
    public static String getLatLong(String response){
        String tmp = response;
        String latDel1 = "<lat>";
        String latDel2 = "</lat>";

        String latlong;

        String lngDel1 = "<lng>";
        String lngDel2 = "</lng>";

        int i = response.indexOf(latDel1);
        int j = response.indexOf(latDel2);

        latlong = response.substring(i+latDel1.length(), j);

        i = response.indexOf(lngDel1);
        j = response.indexOf(lngDel2);

        latlong =latlong+"#"+response.substring(i+lngDel1.length(), j);

        return latlong;
    }


    /*
     * This method is used to get the value of "parameter" in the expression
     * "information"
     */
    public static String getValue(String information, String parameter,String delimiter){
        String tmp = information.substring(information.indexOf(parameter)
                                           +parameter.length()+3);

        StringTokenizer st = new StringTokenizer(tmp,delimiter);
        return st.nextToken();

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
        System.out.println("**************************************");
        while(it.hasNext()){
            s += " # element["+(i++)+"] = "+it.next();
            System.out.println(s);
        }
        System.out.println("**************************************");

        return s;
    }

}
