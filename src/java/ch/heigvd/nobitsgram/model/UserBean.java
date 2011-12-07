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

    // The firstname of the user
    String firstName;

    // The lastname of the user
    String lastName;

    // The country of the user
    String country;

    // The password of the user
    String password;

    // The password confirm of the user
    String passwordConfirm;

    // The email of the user
    String email;

    // User's ID
    Long id;

    String city;

    String zip;

    String street;

    String streetNumber;

    // The topic list of the user
    List <TopicBean> listTopic = new ArrayList<TopicBean>();

    String errors;


    public UserBean(){

    }

    public UserBean(String firstName, String lastName, String country,
                    String password,String passwordConfirm,String email,
                    String streetNumber, String street, String city,String zip){
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }


    public boolean isValidAddress(){

        if (city.trim().equals("") ) {
            return false;
        }

        if (street.trim().equals("") ) {
            return false;
        }

        if (streetNumber.trim().equals("") ) {
            return false;
        }

        if (zip.trim().equals("") ) {
            return false;
        }
        return true;
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

    public String getError(){
        return errors;
    }


    public void addTopic(TopicBean topic){
        listTopic.add(topic);
    }

    public List<TopicBean> getTopicList(){
        return listTopic;
    }

    public boolean isValid(){

        if (firstName.trim().equals("")) {
            errors="Please enter your first name";
            return false;
        }

        if (lastName.trim().equals("")) {
            errors="Please enter your last name";
            return false;
        }

        if (email.trim().equals("") || (email.indexOf('@') == -1)) {
            errors="Please enter a valid email address";

            return false;
        }



        if (password.trim().equals("") ) {
            errors="Please enter a valid password";

            return false;
        }
        if (passwordConfirm.trim().equals("") && !passwordConfirm.equals(password) ) {
            errors="Please enter a valid password";

            return false;
        }

        return true;
    }

}
