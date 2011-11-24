/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.util.ArrayList;

/**
 * Fichier:
 *
 * @author:  Eyram DOVI
 *
 * description:
 *
 * Remarque:
 *
 */

import java.util.*;

public class Parser {




    public Parser(){

    }

    public List<String> getUrl(String var){
        String url="";
        List<String> listUrl= new ArrayList<String>();
        String beginExpression = "\"url\":";
        String endExpression = ".jpg";
        String tmp = var;

        while(tmp.contains(beginExpression) && tmp.contains(endExpression)){
            int i = tmp.indexOf(beginExpression);
            i = tmp.indexOf("http://", i);
            int j = tmp.indexOf(endExpression, i);
            url = tmp.substring(i,j+endExpression.length());
            listUrl.add(url);
            tmp = tmp.substring(j+endExpression.length());
        }
        return listUrl;

    }

    public void displayList(List<String> list){
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            String s = it.next();
            if(s.contains("_6.jpg"))
                System.out.println(s);
        }
    }

}
