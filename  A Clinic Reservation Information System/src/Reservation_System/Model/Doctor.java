
package Reservation_System.Model;

import java.io.Serializable;

public class Doctor extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
    private final int diploma_id;
    private Schedule schedule;
    
    public Doctor(String name,long national_id,int diploma_id,int maxPatientPerDay){
        super(name,national_id);
        this.diploma_id = diploma_id;
        this.schedule = new Schedule(maxPatientPerDay);
    }
    
    public Schedule getSchedule(){
        return schedule;
    }
    
    public int getDiploma_id() {
            return diploma_id;
    }
    
    @Override
    public String toString(){
        return "Doctor Name: " + getName() + ", National ID: " + getNational_id() + ", Diploma ID: " + this.diploma_id;
    }

    

}
