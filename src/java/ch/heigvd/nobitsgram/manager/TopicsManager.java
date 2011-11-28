/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.manager;

import ch.heigvd.nobitsgram.entity.Topic;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Eyram
 */
@Stateless
//@LocalBean

public class TopicsManager {
    @PersistenceContext(unitName = "nobitsgramPU")
    private EntityManager em;
    private Class<Topic> topiClass;


    public TopicsManager(){
        if(em == null){
            try{
                em = Persistence.createEntityManagerFactory("nobitsgramPU").createEntityManager();
            }
            catch(Exception exc){
                exc.getStackTrace();
            }
        }
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

}
