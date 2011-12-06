/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.io.*;

import java.net.*;
import java.util.HashSet;




/**
 * File: InterrogatorInstagram.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class is used to communicate with instagram. It's interrogate
 *              instagram server and receive a response, which can be parse or
 *
 */
public class InterrogatorInstagram {

    // The beginig of the research url
    private String urlBegin = "https://api.instagram.com/v1/tags/";
    // The end of the url
    private String acces_token = "10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";

    private String urlPart = "/media/recent?access_token=";

    private String url ;

    private String oauthUrl = "https://api.instagram.com/oauth/access_token";

    private String client_Id = "";
    private String client_secret ="";
    private String callbackUrl = "";
    private String grant_type = "authorization_code";


    public InterrogatorInstagram(){

    }

    public InterrogatorInstagram(String tagSearch){
        setSearchUrl(tagSearch);
    }


    /*
     * Complete the url with the search tag
     */
    public void setSearchUrl(String tagSearch){
       url = urlBegin+tagSearch+urlPart+acces_token;
    }

    /*
     * This method form the url of the request to get access token
     */
    public void setOAuthUrl(String code){
        oauthUrl += "/?client_id="+client_Id+"&client_secret="+client_secret+
                    "&grant_type="+grant_type+"&redirect_uri="+callbackUrl+
                    "&code="+code;
    }

    /*
     * This method is use to receive client information according to his code.
     */
    public String getClientInformations(){
        URL myUrl;
        String response = null;
        try{
            myUrl = new URL(oauthUrl);
            response = getResponseOfInstagram(myUrl);
        }
        catch(MalformedURLException mexc){
            mexc.printStackTrace();
        }

        return "";
    }


    public String getUrl(){
        return url;
    }


    /*
     * This method is use to get the result of research of tag
     */
    public String getSearcResult(){
        String searchResult = null;
        URL myUrl;

        try{
            myUrl= new URL(url);
            searchResult = getResponseOfInstagram(myUrl);
        }
        catch(MalformedURLException mexc){
             mexc.printStackTrace();
        }
        return searchResult;
    }


    /*
     * This method communicate with the instagram server and return the
     * response in text format.
     *
     */
    public String getResponseOfInstagram(URL myUrl){
        String response ="";

        try{
            URLConnection connect = myUrl.openConnection();
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                connect.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null){
                //System.out.println(inputLine);
                response +=inputLine;
            }
            in.close();
        }

        catch(Exception excp){
            System.out.println(excp.getStackTrace());

        }
        return response;
    }


    /*
     * This method set the acces token of the client
     */
     public void setAccesToken(String acces_token){
        this.acces_token = acces_token;
     }


     /*
      * This method get the access token of the client
      */
      public String getAccessToken(){
          return acces_token;
      }
}
