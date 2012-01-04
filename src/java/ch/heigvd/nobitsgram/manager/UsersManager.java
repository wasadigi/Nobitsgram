/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package ch.heigvd.nobitsgram.manager;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;
import javax.ejb.EJB;


/**
*
* @author Eyram
*/
@Stateless
public class UsersManager {

    @PersistenceContext(unitName = "nobitsgramPU")
    private EntityManager em;
    private Class<User> userClass = User.class;

    public UsersManager(){

    }


    public void create(User user){
        em.persist(user);
    }

    public void update(User user){
        em.refresh(user);
    }

    public User edit(User user){
        return em.merge(user);
    }

    public void remove(User user){
        em.remove(user);
    }

     public User findUser(int id) {
        return em.find(userClass, id);
    }

    public List<User> findAllUser(){
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(userClass));
        return em.createQuery(cq).getResultList();
    }


    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<User> rt = cq.from(userClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    
    /*
     * This method get user according to his parameter and its value
     */
    public List<User> getUser(String parameter, String value){

         Query q = em.createQuery("SELECT userSearch FROM User userSearch "
                 + "WHERE userSearch."+parameter+"='"+value+"'");
         List<User> user = q.getResultList();
         
         return user;
         
         
    }
    

    public boolean isAllReadyRecord(String username){
        boolean cond = false;
        try{
            List<User> myList = getUser("username",username);
            
            if(myList != null && !myList.isEmpty()){
                User tmp = myList.get(0);
                cond = true;
            }
            
        }
        catch(Exception exc){

        }
        return cond;
    }

    public boolean isPasswordOK(User user, String pwdVar){
        return user.isPassword(pwdVar);
    }


    /*
* This method permit to a User to add a topic in his topicList.
*
*/
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

     public Topic findTopic(int id) {
        return em.find(Topic.class,(long )id);
    }

    public List<Topic> findAllTopic(){
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Topic.class));
        return em.createQuery(cq).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public Query createQuery(String qlString) {
        return em.createQuery(qlString);
    }

    public boolean removeTopicOfUser(User user, Topic topic){
                       
        user.removeTopic(topic);        
        topic.removeUser(user);        
        user = em.merge(user);
        topic = em.merge(topic);        
        
        // We check if the users list is empty, and then we remove the topic
        if(topic.getUsers().isEmpty()){
           return true;
        }
        return false;
    }



    public EntityManager getEntityManager(){
        return em;
    }
    
    private List <User> users;
    private List <Topic> topics;
    private List<String> usernames = new ArrayList<String>();
    private List<String> topicsName = new ArrayList<String>();
    
    
    private List<String> access_tokens = new ArrayList<String>();
    private List<String> idsInsta = new ArrayList<String>();
    private List<String> usernInsta = new ArrayList<String>();

   
}

