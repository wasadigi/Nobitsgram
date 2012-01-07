/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

import java.util.*;

/**
 *
 * @author Eyram
 */
public class UserInstagram {
    
    private String username;    
    private String profilePicture;
    private String id;
    private List<Picture> pictures = new ArrayList<Picture>();
   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }  

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public boolean equals(Object object){
        if (!(object instanceof UserInstagram)) {
            return false;
        }
        UserInstagram other = (UserInstagram) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;        
    }
    
    public void setListPictures(List<Picture> newList){
        pictures = newList;
    }
    
    public List<Picture> getListPicture(){
        return pictures;
    }
    
    public String toString(){
        return "username = "+username+"\nprofile picture="+profilePicture+
                "\nid="+id;
    }
}
