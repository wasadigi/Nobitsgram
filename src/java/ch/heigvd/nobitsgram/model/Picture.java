/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

/**
 *
 * @author Eyram
 */
public class Picture {
    
    private String url;
    private String id;
    
    public Picture(){
        
    }
    
    public Picture(String url, String id){
        this.url = url;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String toString(){
        return "url = "+url+"\npicture_id = "+id+"\n";
    }
}
