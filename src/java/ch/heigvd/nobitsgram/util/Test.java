/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;


import java.util.*;

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
public class Test {
    public static void main(String[] args){
        
        Scanner sc;
        String saisie;
        /* System.out.println("Veuillez saisir votre texte:");
        Scanner sc = new Scanner(System.in);
        String saisie = sc.nextLine();
        */

        /*
        List<String> list = parser.getListUrls(saisie);
        parser.displayList(list);
         */
        InterrogatorInstagram rt = new InterrogatorInstagram();
        System.out.print("\n\n\nADDRESS: ");
        sc = new Scanner(System.in);
        saisie = sc.nextLine();
        String access_token = "10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";
       System.out.println("\n\t\tSAISI ==> "+saisie);
       // rt.setSearchUrl(saisie);
       // String url = "https://api.instagram.com/v1/tags/"+saisie+"/media/recent?access_token="+access_token;
        String url1 = "http://maps.googleapis.com/maps/api/geocode/json?address="+saisie+"&sensor=true";
        String url2 =  "https://api.instagram.com/v1/users/14433553/"
                + "followed-by?access_token=14433553.5e2a174.f14871f9bb524036ad35633979cadc04";
        
        String id = "14433553";
               
        String url3 = "https://api.instagram.com/v1/users/"
                +id+"/media/recent/?access_token="+access_token;
        
        String s = rt.getSearcResult(url1);
        String lat = MyParser.parseResponse(s, "lat", true);
        String lng = MyParser.parseResponse(s, "lng", true);
        
       
       // System.out.println("MY LIST:\n"+MyParser.displayList(myList));
        
        System.out.println("******************** AVANT PARSING \n"+s+"\n*****************");
        System.out.println("Latitude ===> "+lat);
        System.out.println("Longitude ===> "+lng);
         s = MyParser.parseResponse(s, "location", false);
        lat = MyParser.parseResponse(s, "lat", true);
        lng = MyParser.parseResponse(s, "lng", true);
        System.out.println("******************** APRES PARSING \n"+s+"\n*****************");
        System.out.println("Latitude Apres parsing location===> "+lat);
        System.out.println("Longitude Apres parsing location ===> "+lng);
        //List<UserInstagram> data = MyParser.getUsersFromJson(s,"data","username","profile_picture","id");
        
        //List<String> users = MyParser.parseResponse(s, "data", "full_name", true);
        //String  name = data.getUsername();
        //String  proPicture = data.getProfile_picture();  
        //List<String> myList = MyParser.parseResponse(s,"data","id",true);
       
       
       
       

       // System.out.println("REPONSE SERVEUR ==> "+s);
       //List<String> list1 = parser.getListUrls(s);
        //parser.displayList(list1);
        /*ResearchGeocode rs = new ResearchGeocode(saisie);
        String s = rs.getLatLng();
        MyParser pars = new MyParser();
        System.out.println("**********************************************\n"+s);
        System.out.println("/////////////////////////// =======> "+pars.getLatLong(s));
         *
         */
      // System.out.println("****************************\tProfile Picture ==> "+proPicture);
      // System.out.println("USERNAME USERNAME USERNAME ===========> "+ name);
       //System.out.println("\tPROFILE_PICTURE\tPROFILE_PICTURE =======> "+MyParser.displayUser(data));
      
     // System.out.println(" =================================\n"+MyParser.displayList(myList));
       

    }

}
