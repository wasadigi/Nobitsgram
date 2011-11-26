/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.io.*;

import java.net.*;




/**
 * File: ResearchTag.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class is used to get information about a tag from instagram's
 *              database
 *
 *
 */
public class ResearchTag {

    // The beginig of the research url
    private String urlBegin = "https://api.instagram.com/v1/tags/";
    // The end of the url
    private String acces_token = "/media/recent?access_token=10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";

    private String url;

    public ResearchTag(){

    }

    public ResearchTag(String tagSearch){
        setUrl(tagSearch);
    }

    /*
     * Complete the url with the search tag
     */
    public void setUrl(String tagSearch){
       url = urlBegin+tagSearch+acces_token;
    }

    public String getUrl(){
        return url;
    }

    public String getSearcResult(){
        String searchResult = "";
        URL myUrl;


        try{
           System.out.println("URL ==> "+url);
            myUrl = new URL(url);

            URLConnection yc = myUrl.openConnection();
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null){
                //System.out.println(inputLine);
                searchResult +=inputLine;
            }
            in.close();

        }

        catch(Exception excp){
            System.out.println(excp.getStackTrace());

        }
        return searchResult;
    }
}
