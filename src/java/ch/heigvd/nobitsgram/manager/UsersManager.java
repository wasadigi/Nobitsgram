/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.manager;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.*;

/**
 *
 * @author Eyram
 */
@Stateless
@LocalBean
public class UsersManager {
    @PersistenceContext(unitName = "nobitsgramPU")
    private EntityManager em;
    private Class<User> userClass;

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

        String query = "SELECT Id"+
                       "FROM Nobitsgram_user nUser"
                      +"WHERE nUser.username = "+username;
       Query q = em.createQuery(query);


       List<Integer> result = q.getResultList();
       int id = result.get(0);

       return findUser(id);

    }

    public boolean isPasswordOK(User user, String pwdVar){
        return user.isPassword(pwdVar);
    }


    public void addTopic(User user, Topic topic){
        user.addTopic(topic);
        topic.addUser(user);
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
