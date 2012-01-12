/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.entity;

import ch.heigvd.nobitsgram.model.PositionWithDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Eyram
 */
@Entity
public class UserHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private List<Calendar> datesConnexion = new ArrayList<Calendar>();
    private List<Calendar> datesDeconnexion = new ArrayList<Calendar>();
    private List<String> searchList = new ArrayList<String>();       
    private List<PositionWithDate> positionsWithDate = new ArrayList<PositionWithDate>();
    
    
    private User user;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHistory)) {
            return false;
        }
        UserHistory other = (UserHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.heigvd.nobitsgram.entity.UserHistory[ id=" + id + " ]";
    }
    
}
