/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

import java.util.*;

/**
 * File: UserBean
 *
 * @author:  Eyram DOVI
 *
 * description: This class represente a user.
 *
 */
public class UserBean {

    // The username of the user
    String username;

    // The firstname of the user
    String firstname;

    // The lastname of the user
    String lastname;

    // The country of the user
    String country;

    // The password of the user
    String password;

    // User's ID
    Long id;

    // The topic list of the user
    List <TopicBean> listTopic = new ArrayList<TopicBean>();


    public UserBean(){

    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addTopic(TopicBean topic){
        listTopic.add(topic);
    }

    public List<TopicBean> getTopicList(){
        return listTopic;
    }

}
