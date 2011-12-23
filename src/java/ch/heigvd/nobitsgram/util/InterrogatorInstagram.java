/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;




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
                 
    private String url ;
    
    private String access_token;

    public InterrogatorInstagram(){

    }

    /*
     * This method set the url
     */
    public void setURL(String url){
        this.url = url;
    }


    /*
     * This method return the url
     */
    public String getUrl(){
        return url;
    }

  

   
    /*
     * This method is use to receive client information according to his code.
     * The request is a post request
     */
    public String getClientInformations(String url,List<String> parameters, 
                                        List<String> value){
        
        // If the both list hasn't the same size, then the request will not
        // be possible. In that case, we return null for the response
        if(parameters.size() != value.size()){
            return null;
        }
        
        String response = null;
        int i = 0;
        int size = value.size();
       
        String reqParameters = "";
        OutputStreamWriter outWriter = null;
        URL myUrl;
        
        try {
            
            // We set the parameters of the request. We scan both of the list
            // and we set the parameters of request according to the index of
            // both lists.
            while(i < size){
                if( i < 0){
                    reqParameters = URLEncoder.encode(parameters.get(i), "UTF-8")+
                                 "="+URLEncoder.encode(value.get(i), "UTF-8");
                }
                else{
                    reqParameters +="&"+URLEncoder.encode(parameters.get(i), "UTF-8")+
                                 "="+URLEncoder.encode(value.get(i), "UTF-8");
                }
                i += 1;
            }

            
            // We create the connection to instagram
            myUrl = new URL(url);

            // We open the connection
            URLConnection connect = myUrl.openConnection();

            // We use connect for output
            connect.setDoOutput(true);

            // We send the request;
            outWriter = new OutputStreamWriter(connect.getOutputStream());
            // We add parameters to the request
            outWriter.write(reqParameters);

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

                response +=inputLine+"\n";
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
