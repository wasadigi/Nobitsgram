/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

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
public class TopicBean {

    // The name of topic
    private String name;

    // The list of user who have this same topic
    private List<UserBean> listUser = new ArrayList<UserBean>();

    public TopicBean(){

    }

    public TopicBean(String name){
        this.name = name;
    }

    public List<UserBean> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserBean> listUser) {
        this.listUser = listUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

}
