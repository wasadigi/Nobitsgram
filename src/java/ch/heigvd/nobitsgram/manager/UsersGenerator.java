/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.manager;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import ch.heigvd.nobitsgram.entity.*;
import ch.heigvd.nobitsgram.model.UserHistory;
import ch.heigvd.nobitsgram.util.InterrogatorInstagram;
import ch.heigvd.nobitsgram.util.MyParser;
import com.sun.java.swing.plaf.nimbus.SliderPainter;
/**
 *
 * @author Eyram
 */
@Stateless
@EJB
public class UsersGenerator {
    @PersistenceContext(unitName = "nobitsgramPU")
    private EntityManager em;
    
    
   
   
    
    
    private List <User> users = new ArrayList<User>();
    private List <Topic> topics = new ArrayList<Topic>();
    private List<String> usernames = new ArrayList<String>();
    private List<String> topicsName = new ArrayList<String>();
    
    
    private List<String> access_tokens = new ArrayList<String>();
    private List<String> idsInsta = new ArrayList<String>();
    private List<String> usernInsta = new ArrayList<String>();
    private List<String> countryList = new ArrayList<String>();

    
     public void create(Topic topic){
        em.persist(topic);
    }
    
    
    public void create(User user){
        em.persist(user);
    }
    
    
    public void addTopicToUser(User user, Topic topic){

        if(!user.isTopicRecord(topic)){
            // If the topic is already in database, we add only user to userlist
            // of that topic

            
            user.addTopic(topic);
            topic.addUser(user);
            topic = em.merge(topic);
            user = em.merge(user);
        }
    }
    
    public void generate(){
        
        initUserInsta();
        initTopicName();
        initTopic();
        initUsername();
        initUser();
        insertUsersToTable();
    }
    
    
    public void initUserInsta(){
        access_tokens.add("10840565.f59def8.778aab0dc2d64a8ca9c27694ed9444bc");
        idsInsta.add("10840565");
        usernInsta.add("eyram");
        
        //*********************************************************************//
        access_tokens.add("14433553.5e2a174.f14871f9bb524036ad35633979cadc04");
        idsInsta.add("14433553");
        usernInsta.add("eyram2");
        
        //*********************************************************************//
        access_tokens.add("14304451.5e2a174.7da66847cd5d4510939432141cffb7cf");
        idsInsta.add("14304451");
        usernInsta.add("eyram_1");
    }
        
    
    public void initUsername(){
//        usernames.add("Mat jean");
//        usernames.add("tototo");
//        usernames.add("tititi");
//        usernames.add("toutou");
//        usernames.add("Jean-Marc");
//        usernames.add("Francis");
//        usernames.add("tonton");
//        usernames.add("maximes");
//        usernames.add("joujou");
//        usernames.add("dupond");
//        usernames.add("daltons");
//        usernames.add("jean-marie");
        usernames.add("Sylvain");
        usernames.add("maestro");
        usernames.add("tintin");                
        usernames.add("joujon");
        usernames.add("titon");
        usernames.add("tout");
        usernames.add("Jean");
        usernames.add("Franck");
        usernames.add("toun");
        usernames.add("max");
        //usernames.add("jour");
        //usernames.add("dupe");
        //usernames.add("dalt");
        //usernames.add("marie");
        //usernames.add("Sylvie");
        //usernames.add("master");
        usernames.add("Hadock");
        
    }
    
    
    public void initTopicName(){
        topicsName.add("Fox");
        topicsName.add("book");
        topicsName.add("mountain");
        topicsName.add("Foot");
        topicsName.add("moon");
        topicsName.add("IphoneFer");
        topicsName.add("watch");
        topicsName.add("ferrari Iphone");
        topicsName.add("ferrari");
        topicsName.add("flower");
        topicsName.add("Iphone");
    }
    
    public void initTopic(){
        
        Topic topic;
        
        for(String s: topicsName){
            topic = new Topic(s);
                           
            topics.add(topic);
            create(topic);

        }
    }
    
    public void initUser(){
        User user;
        
        int i = 0;
        int size = access_tokens.size();
        Random random = new Random();
        initCountryList();;
        int sizeCountry = countryList.size();
        int index;
        String lat;
        String lng;
       String country;
       InterrogatorInstagram inter = new InterrogatorInstagram();
       String location;
        
        for(String s: usernames){
            
           
            index = random.nextInt(sizeCountry);
            country = countryList.get(index);
            // We build the url of request to googleapis
            String url = "http://maps.googleapis.com/maps/api/geocode/json?address="
                         + country + "&sensor=true";

            // we get the response of request
            String result = inter.getSearcResult(url);      
            location = MyParser.parseResponse(result,"location",false);
            lat = MyParser.parseResponse(location, "lat",true);
            lng = MyParser.parseResponse(location, "lng",true);

            user = new User(s);
            user.setAcces_token(access_tokens.get(i%size));
            user.setId_Instagram(idsInsta.get(i%size));
            user.setUsername_instagram(usernInsta.get(i%size));
            user.setPassword("123456");
            user.setProfile_picture("http://images.instagram.com/profiles/anonymousUser.jpg");
            user.setEmail("mail@web.com");
            user.setCountry(country);
            
                // We set lat and lng to the user
                user.setLatitude(Double.parseDouble(lat));
                user.setLongitude(Double.parseDouble(lng));                      
            if(i%2 == 0){
              user.setIsBlocked(false);
            }
            else{
              user.setIsBlocked(true);
            }
            // We create a date with the current timezone et local of user
             Calendar date = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());

             // We set all the date 
             user.setCreateDate(date);
             user.setLastDateConnection(date);
             user.setLastDateSearch(date);
             user.setCountConnection(1);
             user.setCountMonthConnection(1);
             UserHistory history = new UserHistory();
             history.setCreateDate(date);
             user.setHistory(history);
             create(user);
             users.add(user);
             i++;
        }
    }
    
    public void initCountryList(){
        countryList.add("Afghanistan");                                         
        countryList.add("Albania");                    
        countryList.add("Algeria");                    
                    
        

        countryList.add("Angola");                     
        countryList.add("Anguilla");                   
        countryList.add("Antarctica");                 
        
        countryList.add("Argentina");                 
        countryList.add("Armenia");                   

        
        countryList.add("Australia");                 
        countryList.add("Austria");                   
        countryList.add("Azerbaijan");                
        countryList.add("Bahamas");                   
        countryList.add("Bahrain");                   

        countryList.add("Bangladesh");                
        
        countryList.add("Belarus");                   
        countryList.add("Belgium");                   
        
        countryList.add("Benin");                      

        
        countryList.add("Bolivia");                             
        countryList.add("Botswana");                    
        
        countryList.add("Bulgaria");    
        countryList.add("Brazil");               
        countryList.add("China");                     
        

        countryList.add("Fiji");                       
        countryList.add("Finland");                      
        countryList.add("France");                   
        
        
        countryList.add("Gabon");                      
        countryList.add("Gambia");                     

        countryList.add("Georgia");      
        countryList.add("Germany");      

        countryList.add("Ghana");
                                                  
        countryList.add("Spain");                                    

        countryList.add("Sudan");                    
        countryList.add("Suriname");                         
        countryList.add("Swaziland");
        countryList.add("Sweden");     
        countryList.add("Switzerland");

        countryList.add("Syria");
        countryList.add("Taiwan");                                         
        countryList.add("Tanzania");                  
        countryList.add("Thailand");                  
        countryList.add("Togo");                      


        countryList.add("USA");             
        countryList.add("Uruguay");                                
        countryList.add("Uzbekistan");                
        
        
    }
    
    
    public void insertUsersToTable(){
        
        int size = topics.size();        
        Random random = new Random();  
        int i;
        int j;
        int tmp;
        for(User user: users){
            i = random.nextInt(size);
            j = random.nextInt(size);
            
            if(i > j){
                tmp = i;
                i = j;
                j = tmp;
            }
            
            for(int k = i; k < j; k++){
                addTopicToUser(user,topics.get(k));
            }
        }
    }
    
    
}
