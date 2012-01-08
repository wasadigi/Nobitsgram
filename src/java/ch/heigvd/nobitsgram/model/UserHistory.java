/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

/**
 *
 * @author Eyram
 */

import java.io.Serializable;
import java.util.*;
public class UserHistory implements Serializable{
    
    private List<Calendar> datesConnexion = new ArrayList<Calendar>();
    private List<Calendar> datesDeconnexion = new ArrayList<Calendar>();
    private List<String> searchList = new ArrayList<String>();
    private Calendar createDate;    
    private List<PositionWithDate> positionsWithDate = new ArrayList<PositionWithDate>();
    
    public Calendar getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Calendar createDate){
        this.createDate = createDate;
    }
    
    public List<Calendar> getDatesConnexion() {
        return datesConnexion;
    }

    public void addDateConnexion(Calendar date){
        datesConnexion.add(date);
    }
    
    public List<Calendar> getDatesDeconnexion() {
        return datesDeconnexion;
    }

    public void addDateDeconnexion(Calendar date){
        datesDeconnexion.add(date);
    }
    
    public List<PositionWithDate> getPositions() {
        return positionsWithDate;
    }
    
    public void addPosition(Position position){
        Calendar currentDate = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        if(!positionsWithDate.isEmpty()){
            int lastIndex = positionsWithDate.size()-1;
            PositionWithDate tmp = positionsWithDate.get(lastIndex);
            Calendar date = tmp.getDate();
            
            if(date.get(date.DATE) == currentDate.get(currentDate.DATE) && 
               date.get(date.MONTH) == currentDate.get(currentDate.MONTH) && 
               date.get(date.YEAR) == currentDate.get(currentDate.YEAR)){
                
               tmp.addPosition(position);
               positionsWithDate.set(lastIndex, tmp);
                
            }
            else{
                PositionWithDate pos = new PositionWithDate(position);
                positionsWithDate.add(pos);
            }
        }
        else{
            PositionWithDate pos = new PositionWithDate(position);
            positionsWithDate.add(pos);
        }        
    }

    public List<String> getSearchList() {
        return searchList;
    }
    
    public void addSearch(String search){
        searchList.add(search);
    }
    
            
    
}
