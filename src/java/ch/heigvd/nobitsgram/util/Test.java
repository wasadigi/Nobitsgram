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
//        System.out.print("\n\n\nADDRESS: ");
//        sc = new Scanner(System.in);
//        saisie = sc.nextLine();
        String access_token = "10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";
      // System.out.println("\n\t\tSAISI ==> "+saisie);
       // rt.setSearchUrl(saisie);
       // String url = "https://api.instagram.com/v1/tags/"+saisie+"/media/recent?access_token="+access_token;
       // String url1 = "http://maps.googleapis.com/maps/api/geocode/json?address="+saisie+"&sensor=true";
        
        
        String id = "14433553";
               
        String url3 = "https://api.instagram.com/v1/users/"
                +id+"/media/recent/?access_token="+access_token;
        
        String url4 = "https://api.instagram.com/v1/locations/"+2862169+
                 "/media/recent/?access_token="+access_token;
        
       
        String lat = "48.858844";
        String lng = "2.294351";
        
       
       
        String url2 = "https://api.instagram.com/v1/locations/search?lat="
                    + lat+"&lng="+lng+"&access_token="+access_token;
        
        
        Calendar c = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        
        Date d = new Date();
        
        
       // System.out.println("CALENDAR ===> "+c.get(c.MONTH));
        
        //System.out.println(" ====> "+url3);
        
         String s = rt.getSearcResult(url3);
       // System.out.println("MY LIST:\n"+MyParser.displayList(myList));
       
        System.out.println("******************** AVANT \n"+s+"\n*****************");
        
        //List<UserInstagram> data = MyParser.getUsersFromJson(s,"data","username","profile_picture","id");
        
        List<String> idS = MyParser.getPictureIDs(s, "id");
        String s1 = MyParser.parseResponse(s,"id", false);
        String s2 = MyParser.parseResponse(s,"tags", false);
        //List<String> idS1 = MyParser.parseResponse(s1, "image", "id", false);
        //String  name = data.getUsername();
        //String  proPicture = data.getProfile_picture();  
       //List<String> myList = MyParser.parseResponse(s,"data","url",true);
       
       
       
       

       System.out.println("S1 ==> "+s1);
       System.out.println("S2 ==> "+s2);
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
      
      System.out.println(" =================================\n"+MyParser.displayList(idS));
       //System.out.println(" ==============LIST IDS1 ===================\n"+MyParser.displayList(idS1));

    }

}
