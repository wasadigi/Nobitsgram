/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

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
public class ResearchTag {

    private String uriBegin = "https://api.instagram.com/v1/tags/search?q=";
    private String acces_token = "&access_token=10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc";

    private String uri;

    public ResearchTag(){

    }

    public ResearchTag(String tagSearch){
        setUri(tagSearch);
    }


    public void setUri(String tagSearch){
       uri = uriBegin+tagSearch+acces_token;
    }

    public String getUri(){
        return uri;
    }

    public String getSearcResult(){
        String searchResult = null;
        

        return searchResult;
    }
}
