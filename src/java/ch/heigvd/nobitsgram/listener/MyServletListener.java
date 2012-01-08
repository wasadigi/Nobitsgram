/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.listener;


import ch.heigvd.nobitsgram.entity.User;
import ch.heigvd.nobitsgram.manager.UsersManager;
import ch.heigvd.nobitsgram.model.UserHistory;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import javax.ejb.EJB;

/**
 * Web application lifecycle listener.
 * @author Eyram
 */
@WebListener()
public class MyServletListener implements HttpSessionListener{
   @EJB
   private UsersManager usersManager;
   

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try{
        }
        catch(Exception except){
            
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        try{                    
          Calendar dateDeconnexion = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault()); 
          HttpSession session = se.getSession();          
          User user = (User)session.getAttribute("user");
          user.setIsConnect(false);
          UserHistory history = user.getHistory();
          history.addDateDeconnexion(dateDeconnexion);
          user.setHistory(history);
          user = usersManager.edit(user);
          session.removeAttribute("user");
        }
        catch(Exception excep){
           // excep.printStackTrace();
        }
    }

   
}
