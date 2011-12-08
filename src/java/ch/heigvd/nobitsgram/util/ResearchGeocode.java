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
        System.out.println(url);
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
