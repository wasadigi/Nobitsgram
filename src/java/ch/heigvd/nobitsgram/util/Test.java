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
        MyParser parser = new MyParser();
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
        System.out.println("\n\n\nTag à rechercher:");
        sc = new Scanner(System.in);
        saisie = sc.nextLine();

        System.out.println("\n\t\tSAISI ==> "+saisie);
        rt.setSearchUrl(saisie);
        String s = rt.getSearcResult(rt.getUrl());
        parser.getListUrls(s);


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


        System.out.println(" =================================\n"+s);

    }

}
