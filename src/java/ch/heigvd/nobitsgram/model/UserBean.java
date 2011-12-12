/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    String username;

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

    public UserBean(String firstName, String lastName,String username, String country,
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
        this.username = username;
    }

    /*
     * This method return boolean which tell us if one of the field of the address
     * was fill or not.
     */
    public boolean isAddress(String city, String street, String streetNumber, String zip){
        if(!city.trim().equals("") || !street.trim().equals("") ||
           !streetNumber.trim().equals("") || !zip.trim().equals("")){
            return true;
        }
        return false;

    }

    /*
     * This method tell us if the expression which is the parameter was a number
     * or not.
     */
    public boolean isNumber(String expression){
        boolean cond = false;
        try{
            int nber = Integer.parseInt(expression);
            cond = true;
        }
        catch(NumberFormatException exc){
            exc.printStackTrace();
        }
        return cond;

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

        if (email.trim().equals("") || !isValidEmail(email) ){
            errors="Please enter a valid email address";

            return false;
        }


        if (username.trim().equals("")) {
            errors="Please enter your username";
            return false;
        }
        else if(username.trim().length()<6){
            errors="Your username is too short, it must be at least 6 caracters";
        }

        isValidPassword(password, passwordConfirm);


        return true;
    }

    public boolean isValidPassword(String password, String passwordConfirm){
        if (password.trim().equals("") ) {
            errors="Please enter a valid password";
            return false;
        }

        else if (password.trim().length()<6){
            errors="Your password length must be at least 6 caracters!";
            return false;
        }

        if (passwordConfirm.trim().equals("") && !passwordConfirm.equals(password) ) {
            errors="Your password confirm is not the same of your password! Retry";
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email){
        String mask = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";

        Pattern pattern = Pattern.compile(mask);

        Matcher controler = pattern.matcher(email);
        return controler.matches();

    }

}
