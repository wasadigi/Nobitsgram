/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.nobitsgram.model;

/**
 *
 * @author Eyram
 */

import java.util.*;
public class PositionWithDate {
    private List<Position> positions = new ArrayList<Position>();
    
    private Calendar date;
    
    public PositionWithDate(Position position){
        date = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        positions.add(position);
    }
    
    public List<Position> getPositions(){
        return positions;
    }
    
    public void addPosition(Position position){
        positions.add(position);
    }
    
    public Calendar getDate(){
        return date;
    }
}
