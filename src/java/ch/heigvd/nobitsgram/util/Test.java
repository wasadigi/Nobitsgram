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
        Parser parser = new Parser();

        System.out.println("Veuillez saisir votre texte:");
        Scanner sc = new Scanner(System.in);
        String saisie = sc.nextLine();

        List<String> list = parser.getUrl(saisie);
        parser.displayList(list);



    }

}
