
package Reservation_System;

import java.util.Date;


public class Rendezvous {
    private Date dateTime;
    private Patient patient;

    public Rendezvous(Patient patient , Date dateTime) {
        this.dateTime = dateTime;
        this.patient = patient;
    }
    
    public Date getDate(){
        return this.dateTime;
    }
    
    
}
