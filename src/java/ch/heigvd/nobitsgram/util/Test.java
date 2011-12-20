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
        //System.out.println("\n\n\nTag à rechercher:");
        //sc = new Scanner(System.in);
        //saisie = sc.nextLine();
        String access_token = "10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";
       // System.out.println("\n\t\tSAISI ==> "+saisie);
       // rt.setSearchUrl(saisie);
       // String url = "https://api.instagram.com/v1/tags/"+saisie+"/media/recent?access_token="+access_token;
        //String url1 = "http://maps.googleapis.com/maps/api/geocode/json?address="+saisie+"&sensor=true";
        String url2 =  "https://api.instagram.com/v1/users/14433553/"
                + "followed-by?access_token=14433553.5e2a174.f14871f9bb524036ad35633979cadc04";
        String s = rt.getSearcResult(url2);
       //  = MyParser.getListUrls(s);
       // System.out.println("MY LIST:\n"+MyParser.displayList(myList));
        
        System.out.println("******************** \n"+s+"\n*****************");

        
        
       List<String> myList = MyParser.parseResponse(s,"data","id",true);
       
       
       
       

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

      
      System.out.println(" =================================\n"+MyParser.displayList(myList));
      // System.out.println("****************************\tBOOLEAN ==> "+myList.isEmpty());

    }

}
