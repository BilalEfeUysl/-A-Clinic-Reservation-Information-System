
package Reservation_System;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;


public class Schedule implements Serializable{
    private LinkedList<Rendezvous> sessions;
    private int maxPatientPerDay;
    
    public Schedule(int maxPatientPerDay){
        this.maxPatientPerDay = maxPatientPerDay;
        
        this.sessions = new LinkedList<>();
    }
    
    public boolean addRendezvous(Patient p, Date desired){
        int sameDayCount = 0;
        Calendar desiredCal = Calendar.getInstance();
        desiredCal.setTime(desired);
        
        for (Rendezvous session : sessions) {
            Calendar existingCal = Calendar.getInstance();
            existingCal.setTime(session.getDate());
            
            if(existingCal.get(Calendar.YEAR) == desiredCal.get(Calendar.YEAR) &&
               existingCal.get(Calendar.DAY_OF_YEAR) == desiredCal.get(Calendar.DAY_OF_YEAR)){
                sameDayCount++;
            }
        }
        
        if(sameDayCount >= maxPatientPerDay){
            return false;
        }
        
        Rendezvous newRendezvous = new Rendezvous(p, desired);
        sessions.add(newRendezvous);
        return true;
    }
}
