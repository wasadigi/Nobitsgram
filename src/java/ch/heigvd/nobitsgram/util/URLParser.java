/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.util.ArrayList;

/**
 * File: URLParser.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class is used to parse an expression which contain url
 *
 *
 */

import java.util.*;

public class URLParser {




    public URLParser(){

    }

    /*
     * This method return a list of url. Those url are contained in the
     * parameter var
     * Instagram return 3 url for the same
     * image. Default, we choose the bigger image which have his url end by "_7"
     *
     */
    public List<String> getListUrls(String var){
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
     * This method is used to display the list of url
     */
    public void displayList(List<String> list){
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            String s = it.next();

                System.out.println(s);
        }
    }

}
