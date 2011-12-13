/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.net.*;
import java.io.*;

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
public class ResearchGeocode {
    String url = "http://maps.googleapis.com/maps/api/geocode/xml?address=";
    String sensor ="&sensor=true";

    public ResearchGeocode(String address){
        url = url+address+sensor;
    }


    public String getLatLng(){
        URL myUrl;
        String searchResult = null;

        try{
            myUrl = new URL(url);

            URLConnection yc = myUrl.openConnection();
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
            String inputLine;
            searchResult = "";
            while ((inputLine = in.readLine()) != null){
                searchResult +=inputLine;
            }
            in.close();

        }

        catch(Exception excp){
            System.out.println(excp.getStackTrace());

        }
        return searchResult;
    }

    /*
     * This method extract the status in the expression which is in the
     * parameter
     */
    public String getStatusOfReasearch(String response){

        String delimiter1 = "<status>";
        int i = response.indexOf(delimiter1)+delimiter1.length();
        String delimiter2 = "</status>";
        int j = response.indexOf(delimiter2);
        return response.substring(i,j);
    }

}
