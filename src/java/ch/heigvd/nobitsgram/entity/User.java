package ch.heigvd.nobitsgram.entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import sun.misc.BASE64Encoder;


/**
 * File: User.java
 *
 * @author:  Eyram DOVI
 *
 * description: This class represent a user's table. An user have for attribut
 *              a first name,last name, an username, a password and his country.
 *              Un utilisateur doit avoir un nom, un prénom, un identifiant
 *              (username), un mot de passe et son pays de résidence
 *
 * Remarque:
 *
 */
@javax.persistence.Entity
@XmlRootElement
@Table(name="nobitsgram_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    // firstname of the user
    private String firstname;

    // lastname of the user
    private String lastname;

    // username of the user
    private String username;

    // password of the user
    private String password;

    // Country of the user
    private String country;

    //email of the user
    private String email;

    // Access_token from instagram
    private String acces_token;

    private long id_Instagram;

    private String username_instagram;

    private Double latitude = null;

    private Double longitude = null;



    public User(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(){

    }

    @ManyToMany(mappedBy="users")
    // List of the user's topic
    private List<Topic> topics = new ArrayList<Topic>();

    /**
    *
    * This method return user's ID
    *
    */
    public Long getId() {
        return id;
    }


    /**
    *
    * This method is us to modifie user's ID
    *
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    *
    * This method return the user's country
    *
    */
    public String getCountry() {
        return country;
    }

    /**
    *
    * This method permit to modifie the user's country
    *
    */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
    *
    * This method return the first name of the user
    *
    */
    public String getFirstname() {
        return firstname;
    }


    /**
    *
    * This method permit to change the firstname of the user
    *
    */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
    *
    * This method permit to get the Lastname of the user
    *
    */
    public String getLastname() {
        return lastname;
    }

    /**
    *
    * This method permit to change the last name of the user
    *
    */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
    *
    * This method permit to get the email of the user
    *
    */
    public String getEmail() {
        return email;
    }

    /**
    *
    * Using this method, change the email of the user
    *
    */
    public void setEmail(String email) {
        this.email = email;
    }



    /**
    *
    * This method is use to know if the password which is an argument
    * is the same with the user's password.
    *
    */
    public boolean isPassword(String passVar) {
        boolean cond = false;

        try{
            cond = password.equals(hashPassword(passVar));
        }
        catch(NoSuchAlgorithmException excep){
            excep.getStackTrace();
        }

        return cond;
    }


    /**
    *
    * This method permit to set a password or to change it. Password is
    * a paraphrase which is hidden. That is what we hash it.
    *
    */
    public void setPassword(String pwd) {


        try{
            password = hashPassword(pwd);
        }
        catch(NoSuchAlgorithmException excep){
            excep.getStackTrace();
        }

    }

    public String getPassword(){
        return password;
    }

    /**
    *
    * This method return the username of the user
    *
    */
    public String getUsername() {
        return username;
    }


    /**
    *
    * This method is used to set or to change user's username
    *
    */
    public void setUsername(String username) {
        this.username = username;
    }



    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAcces_token() {
        return acces_token;
    }

    public void setAcces_token(String acces_token) {
        this.acces_token = acces_token;
    }

    public long getId_Instagram() {
        return id_Instagram;
    }

    public void setId_Instagram(long id_Instagram) {
        this.id_Instagram = id_Instagram;
    }

    public String getUsername_instagram() {
        return username_instagram;
    }

    public void setUsername_instagram(String username_instagram) {
        this.username_instagram = username_instagram;
    }




    /**
    *
    * This method is used to add a or more topics to the topic list of the user
    *
    */
    public void addTopic(Topic topic){

        topics.add(topic);

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    /**
    *
    * This method display the informations about a user
    *
    */
    public String toString() {
        return "User: [ id=" + id +  " ; first name ="+firstname+"; lastname="
                +lastname+" ;country="+country+" ;username="+username+" ]";
    }



    /*
    * This method return the user's topic list
    */
    public List<Topic> getTopicList(){
        return topics;
    }

    /*
     *
     * This method hash a password which was given by parameter
     * The hash is sha-256.
     *
     */
    public String hashPassword(String pwd)throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(pwd.getBytes());
        byte raw[] = md.digest();

       String hash = (new BASE64Encoder()).encode(raw);

      return hash;

    }

    /*
     * This method is used to know if a certain topic was already record
     * in the topic list of the user
     */
    public boolean isTopicRecord(Topic topic){
        Iterator<Topic> it = topics.iterator();
        Long tId;
        while(it.hasNext()){
            tId = it.next().getId();
            if(tId == topic.getId()){
                return true;
            }
        }
        return false;

    }

    public void setListTopic(List<Topic> topics){
        this.topics = topics;
    }

}