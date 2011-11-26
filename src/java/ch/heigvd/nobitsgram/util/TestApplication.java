/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.util;

import ch.heigvd.nobitsgram.entity.Topic;
import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.TopicsManager;
import ch.heigvd.nobitsgram.manager.UsersManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Fichier:
 *
 * @author:  Eyram DOVI
 *
 * description:
 *
 * Remarque:
 *
 */
public class TestApplication {

    public static void main(String [] args) {

        User user = new User();
        Topic topic = new Topic("Nuage");
        UsersManager usersManager = new UsersManager();
        TopicsManager topicsManager = new TopicsManager();

       try{
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("nobitsgramPU");
//            EntityManager em = emf.createEntityManager();
//            EntityTransaction tx = em.getTransaction();
            user.setCountry("Suisse");
            user.setFirstname("Jean");
            user.setLastname("Marc");
            user.setUsername("JeaMar");
            user.setPassword("1234");
            user.setEmail("maje@mail.com");
            user.setId(23L);
            topic.setId(15L);

           // usersManager.create(user);
           // topicsManager.create(topic);

  /*          tx.begin();
            em.persist(user);
            em.persist(topic);
            tx.commit();
            em.close();
            emf.close();
   * 
   */

       }
       catch(Exception e){
           System.out.println("ERROR ===> "+e.getStackTrace());
       }


    }




}
