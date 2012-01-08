package ch.heigvd.nobitsgram.entity;

import ch.heigvd.nobitsgram.model.UserHistory;
import ch.heigvd.nobitsgram.util.MyParser;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Date;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
    
    private String streetNumber;
    
    private String street;
    
    private String zipCode;
    private String city;

    //email of the user
    private String email;

    // Access_token from instagram
    private String acces_token;

    private String id_Instagram;

    private String username_instagram;

    private Double latitude = null;

    private Double longitude = null;
    
    private boolean isConnect = false;
    
    private boolean isBlocked = false;
    
    private String profile_picture;

    // boolean which indicate if the map must be zoom out or not
    // Default the map is zoom out
    private boolean zoomOut = true;
    
    private long countConnection = 0;
    
    private int countMonthConnection = 0;
    
    private long countSearch = 0;
    
    private int countMonthSearch = 0;
    
    private UserHistory history;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar createDate;
    

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar lastDateConnection;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar lastDateSearch;

    public User(String username){
        this.username = username;
        
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isZoomOut() {
        return zoomOut;
    }

    public void setZoomOut(boolean zoomOut) {
        this.zoomOut = zoomOut;
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

    public boolean isConnect() {
        return isConnect;
    }

    public void setIsConnect(boolean isConnect) {
        try{
            this.isConnect = isConnect;
        }
        catch(NullPointerException npExc){
            
        }
    }

    public boolean isIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
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
        try{
            return latitude;
        }
        catch(NullPointerException npexc){
            return Double.NaN;
        }
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        try{
            return longitude;
        }
        catch(NullPointerException npexc){
            return Double.NaN;
        }
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

    public String getId_Instagram() {
        return id_Instagram;
    }

    public void setId_Instagram(String id_Instagram) {
        this.id_Instagram = id_Instagram;
    }

    public String getUsername_instagram() {
        return username_instagram;
    }

    public void setUsername_instagram(String username_instagram) {
        this.username_instagram = username_instagram;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getLastDateConnection() {
        return lastDateConnection;
    }

    public void setLastDateConnection(Calendar lastDateConnection) {
        this.lastDateConnection = lastDateConnection;
    }

    public Calendar getLastDateSearch() {
        return lastDateSearch;
    }

    public void setLastDateSearch(Calendar lastDateSearch) {
        this.lastDateSearch = lastDateSearch;
    }

   
    
    public long getCountConnection() {
        return countConnection;
    }

    public void setCountConnection(long countConnection) {
        this.countConnection = countConnection;
    }

    public int getCountMonthConnection() {
        return countMonthConnection;
    }

    public void setCountMonthConnection(int countMonthConnection) {
        this.countMonthConnection = countMonthConnection;
    }

    public int getCountMonthSearch() {
        return countMonthSearch;
    }

    public void setCountMonthSearch(int countMonthSearch) {
        this.countMonthSearch = countMonthSearch;
    }

    public long getCountSearch() {
        return countSearch;
    }

    public void setCountSearch(long countSearch) {
        this.countSearch = countSearch;
    }

    public UserHistory getHistory() {
        return history;
    }

    public void setHistory(UserHistory history) {
        this.history = history;
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

    
    public boolean equals(Object object){
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
                +lastname+" ;country="+country+" ;username="+username+ "topics:\n"+MyParser.displayList(getListString())+" ]";
    }

    public List<String> getListString(){
        int size = topics.size();
        List<String> list = new ArrayList<String>();
        for(int i=0; i<size;i++){
            list.add(topics.get(i).getName());
        }
        return list;
    }


    /*
    * This method return the user's topic list
    */
    public List<Topic> getTopicList(){
        return topics;
    }


    public void removeTopic(Topic topic){
        topics.remove(topic);
    }

    public void removeTopic(int index){
        topics.remove(index);
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