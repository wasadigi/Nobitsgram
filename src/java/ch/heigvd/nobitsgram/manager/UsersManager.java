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
import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.POST;

/**
 *
 * @author Eyram
 */
@Stateless
@LocalBean
//@EJB(name = "User", beanInterface=ch.heigvd.nobitsgram.entity.User.class)
public class UsersManager {
    //@PersistenceContext(unitName = "nobitsgramPU")
    //private EntityManager em;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("nobitsgramPU");
    private EntityManager em = emf.createEntityManager();
    private Class<User> userClass = User.class;
    private EntityTransaction tx = em.getTransaction();


    public void create(User user){
        
        tx.begin();
        em.persist(user);
        tx.commit();
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
        User user = null;
        String query = "SELECT nuser "+
                       "FROM User nuser "
                      +"WHERE nuser.username = '"+username+"'";

        Query q = em.createQuery(query);

        try{
            user = (User)q.getSingleResult();
        }

        catch(Exception exc){
           user = null;
        }
       return user;


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
