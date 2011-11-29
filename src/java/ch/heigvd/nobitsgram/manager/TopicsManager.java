/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.manager;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import java.util.List;
import javax.ejb.Stateless;
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
    * This method return the id of the topic which is in parameter
   */
    public int getId(Topic topic){
        int i = -1;
        List<Topic> topics = findAllTopic();;
        int size = topics.size();
        if(size < 1){
            return i;
        }

        i = 0;
        // If it's at least one topic in database, we search if the topic
        // is the same with one of it in database
        if(size > 0){

            while(i < size && !topic.getName().equals(topics.get(i).getName())){
                i++;
            }

            if(i == size){
                i = -1;
            }
            else{
                i = topics.get(i).getId().intValue();
            }
        }

        return i;
    }

}
