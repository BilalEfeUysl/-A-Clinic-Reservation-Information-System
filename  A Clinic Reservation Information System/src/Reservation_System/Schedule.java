
package Reservation_System;

import java.io.Serializable;
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
        return true;
    }
}
