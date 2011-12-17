/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.io.*;
import java.net.*;




/**
 * File: InterrogatorInstagram.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class is used to communicate with instagram. It's interrogate
 *              instagram server and receive a response, which can be parse.
 *
 */
public class InterrogatorInstagram {

    // The beginig of the research url
    private String urlBegin = "https://api.instagram.com/v1/";
    // The end of the url
    private String access_token = "10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";

    private String urlPart2 = "?access_token=";
    private String urlPart1 = "/media/recent";
    private String urlPart3 = "/users/self/media/liked?access_token=";
    private String nofilter = "nofilter";

    private String url ;

    private String oauthUrl = "https://api.instagram.com/oauth/access_token";

    private String client_Id = "5e2a174a39804619840925781251b646";
    private String client_secret ="26a951460081472fab2c0bb2f505a397";
    private String callbackUrl;
    private String grant_type = "authorization_code";
    private String code;



    public InterrogatorInstagram(){

    }

    public InterrogatorInstagram(String tagSearch){
        setSearchUrl(tagSearch);
    }


    /*
     * Complete the url with the search tag
     */
    public void setSearchUrl(String tagSearch){
       url = urlBegin+"tags/"+tagSearch+urlPart1+urlPart2+access_token;

    }


    /*
     * This method return the url
     */
    public String getUrl(){
        return url;
    }

    
   public void setLikeMediaUrl(String access_token){
       url = urlBegin+urlPart3+access_token;               
   }
    
    /*
     * This method is used to set url to get information about
     * that tag which is in parameter
     */
    public void setSearchInfoUrl(String tagSearch){
        url = urlBegin+nofilter+urlPart2+access_token;
    }

    /*
     * This method is used to add end point to a url
     */
    public void addEndPoint(String parameter, String value){
        url +="&"+parameter+"="+value;
    }


    /*
     * This method is used to set the code which was get during the logging of
     * the client
     */
    public void setCode(String code){
        this.code = code;
    }

    public void setCallbackUrl(String callbackUrl){
        this.callbackUrl = callbackUrl;
    }

    /*
     * This method is use to receive client information according to his code.
     * The request is a post request
     */
    public String getClientInformations(){

        String response = null;
        String parameters = "";
        OutputStreamWriter outWriter = null;
        URL myUrl;

        try {
            // We set the parameters of the request.
            parameters = URLEncoder.encode("client_id", "UTF-8")+
                            "="+URLEncoder.encode(client_Id, "UTF-8");

            parameters += "&"+URLEncoder.encode("client_secret", "UTF-8")+
                            "=" + URLEncoder.encode(client_secret, "UTF-8");

            parameters += "&"+URLEncoder.encode("grant_type", "UTF-8")+
                                "=" + URLEncoder.encode(grant_type, "UTF-8");

            parameters += "&"+URLEncoder.encode("redirect_uri", "UTF-8")+
                                "=" + URLEncoder.encode(callbackUrl, "UTF-8");

            parameters += "&"+URLEncoder.encode("code", "UTF-8")+
                                "=" + URLEncoder.encode(code, "UTF-8");
            // We create the connection to instagram
            myUrl = new URL(oauthUrl);

            // We open the connection
            URLConnection connect = myUrl.openConnection();

            // We use connect for output
            connect.setDoOutput(true);

            // We send the request;
            outWriter = new OutputStreamWriter(connect.getOutputStream());
            // We add parameters to the request
            outWriter.write(parameters);

            // We flush the stream
            outWriter.flush();

            // We get response for instagram
            response = getResponseOfInstagram(connect);

            // We close the stream
            outWriter.close();
        }

        catch (Exception exc) {
             System.out.println(exc.getStackTrace());
        }

        return response;
    }



    /*
     * This method is use to get the result of research of tag
     */
    public String getSearcResult(String url){
        String searchResult = null;
        URL myUrl;

        try{
            myUrl= new URL(url);
            URLConnection connect = myUrl.openConnection();
            searchResult = getResponseOfInstagram(connect);
        }
        catch(Exception exc){
              System.out.println(exc.getStackTrace());
        }
        return searchResult;
    }


    /*
     * This method communicate with the instagram server and return the
     * response in text format.
     *
     */
    public String getResponseOfInstagram(URLConnection connect){
        String response = null;

        try{
            BufferedReader reader = new BufferedReader(
                                new InputStreamReader(
                                connect.getInputStream()));
            String inputLine;
            response = "";
            while ((inputLine = reader.readLine()) != null){

                response +=inputLine;
            }
            reader.close();
        }

        catch(Exception excp){
            System.out.println(excp.getStackTrace());

        }
        return response;
    }


    /*
     * This method set the acces token of the client
     */
     public void setAccesToken(String access_token){
        if(access_token != null && access_token.trim() !=""){
                this.access_token = access_token;
        }

     }


     /*
      * This method get the access token of the client
      */
      public String getAccessToken(){
          return access_token;
      }
}
