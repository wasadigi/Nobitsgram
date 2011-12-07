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
import javax.persistence.PersistenceContextType;
import java.util.*;


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

    public void edit(User user){
        em.merge(user);
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

    public User getUser(String username){

         Query q = em.createQuery("SELECT s FROM User s WHERE s.username='"+username+"'");
         List<User> user = q.getResultList();
         return user.get(0);
    }


    public boolean isAllReadyRecord(String username){
        boolean cond = false;
        try{
            User tmp = getUser(username);
            cond = true;
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
            topic = em.merge(topic);
            user = em.merge(user);

            user.addTopic(topic);
            topic.addUser(user);
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



    public EntityManager getEntityManager(){
        return em;
    }

}

