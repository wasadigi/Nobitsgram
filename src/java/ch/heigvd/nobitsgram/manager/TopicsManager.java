/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.manager;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * File : TopicsManager.java
 *
 * @author Eyram
 *
 * description: This class is used to managed entity Topic.
 */
@Stateless
public class TopicsManager {
    @PersistenceContext(unitName = "nobitsgramPU")
    private EntityManager em;
    private Class<Topic> topiClass = Topic.class;


    public TopicsManager(){

    }

    public void create(Topic topic){
        em.persist(topic);
    }

    public void update(Topic topic){
        em.refresh(topic);
    }

    public Topic edit(Topic topic){
       return em.merge(topic);
    }

    public void remove(Topic topic){
        topic = em.merge(topic);
        em.remove(topic);
    }

    /*
     * This method return all the topic which is in the database
     */
    public List<Topic> findAllTopic(){
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(topiClass));
        return em.createQuery(cq).getResultList();
    }


    /*
     * This method return the number of topic which is in the database
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Topic> rt = cq.from(topiClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }


    /*
     * This method return the entityManager of a topic
     */
    public EntityManager getEntityManager(){
        return em;
    }



    /*
     * This method is used to find a topic according to it id
     */
     public Topic findTopic(int id) {
        return em.find(topiClass,(long )id);
    }


   /*
    * This method return the topic which have the same name with the String
    * which is the parameter
   */
    public Topic getTopic(String topicName)throws EJBException{
         Query q = em.createQuery("SELECT top FROM Topic top WHERE top.name='"+topicName+"'");
         List<Topic> top = q.getResultList();

         // If the list of resul is empty, we return null
         if(top.isEmpty()){
             return null;
         }
         return top.get(0);
    }
    
    public void removeUserOfTopic(User user, Topic topic){
        
        topic.removeUser(user);
        user.removeTopic(topic);
        
        
    }
    
    public void setEntityManager(EntityManager em){
        this.em = em;
    }

}
