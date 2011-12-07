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
 *
 * @author Eyram
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

    public void edit(Topic topic){
        em.merge(topic);
    }

    public void remove(Topic topic){

        em.remove(topic);
    }

    public List<Topic> findAllTopic(){
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(topiClass));
        return em.createQuery(cq).getResultList();
    }



    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Topic> rt = cq.from(topiClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public EntityManager getEntityManager(){
        return em;
    }

    public void addUser(User user, Topic topic){
        topic.addUser(user);
        user.addTopic(topic);
    }


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
         System.out.println("TOPIC TOPIC ====> "+top.isEmpty());

         // If the list of resul is empty, we return null
         if(top.isEmpty()){
             return null;
         }
         System.out.println("TOPIC VALUE VALUE TOPIC VALUE ====> "+top.get(0));
         return top.get(0);
    }

}
