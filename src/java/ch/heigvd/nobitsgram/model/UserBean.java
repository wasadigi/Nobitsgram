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
    String firstName;

    // The lastname of the user
    String lastName;

    // The country of the user
    String country;

    // The password of the user
    String password;

    // The email of the user
    String email;

    // User's ID
    Long id;

    // The topic list of the user
    List <TopicBean> listTopic = new ArrayList<TopicBean>();

    private Hashtable errors = new Hashtable();


    public UserBean(){

    }

    public UserBean(String firstName, String lastName, String country,
                     String username, String password, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
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

    public boolean isValid(){
        boolean valid = true;
        if (firstName.trim().equals("")) {
            errors.put("firstName","Please enter your first name");
            valid=false;
        }

        if (lastName.trim().equals("")) {
            errors.put("lastName","Please enter your last name");
            valid = false;
        }

        if (email.trim().equals("")){// || (email.indexOf('@') == -1)) {
            errors.put("email","Please enter a valid email address");

            valid = false;
        }
        if (username.trim().equals("")) {
            errors.put("username","Please enter a username");

            valid = false;
        }
        if (password.trim().equals("") ) {
            errors.put("password","Please enter a valid password");

            valid = false;
        }


        return valid;
    }

}
