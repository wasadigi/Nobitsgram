/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


/**
 * File: Topic.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class represent a Topic which we can considered like a Tag.
 *
 *
 */
@Entity
//@XmlRootElement
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Topic's name
    private String name;

    @ManyToMany(cascade= CascadeType.ALL)
    private List<User> users = new ArrayList<User>() ;

    public Topic (){

    }


    /*
     *
     * This constructor have one parameter which is the name of the topic
     *
     */
    public Topic(String name){
        this.name = name;
    }

    /*
     * This method return the ID of the topic
     */
    public Long getId() {
        return id;
    }

    /*
     * This method permit to set or to change the name of the topic
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void removeUser(User user){
        users.remove(user);
    }

  /**
    *
    * This method is used to get the name of a topic
    *
    */
    public String getName() {
        return name;
    }

   /**
    *
    * Using this method to set or to change the name of a topic
    *
    */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    

  /**
    *
    * This method is used to display the information about the topic. We can
    * add to information which will be display, the list of user.
    *
    */
    public String toString() {
        return "<Topic>\n<id>"+id+"</id>\n<name>"+name+"</name>\n</Topic>";
    }



    /*
     * This method is used to add an user to the user list.
     */
    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }


}
