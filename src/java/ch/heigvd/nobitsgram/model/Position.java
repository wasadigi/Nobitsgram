/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

import java.io.Serializable;

/**
 *
 * @author Eyram
 */


public class Position implements Serializable{
    
    private String lat;
    private String lng;
    
    public Position(String lat,String lng){
        this.lat = lat;
        this.lng = lng;
    }
            
    public Position(){}

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    
}
