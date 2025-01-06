
package Reservation_System.Model;

import java.io.Serializable;
import java.util.Date;


public class Rendezvous implements Serializable {
    private Date dateTime;
    private Patient patient;

    public Rendezvous(Patient patient , Date dateTime) {
        this.dateTime = dateTime;
        this.patient = patient;
    }
    
    public Date getDate(){
        return this.dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    
    
}
