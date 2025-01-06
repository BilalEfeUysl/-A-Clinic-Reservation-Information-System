
package Reservation_System;


public class Doctor extends Person {
    private final int diploma_id;

    public Doctor(String name,long national_id,int diploma_id){
        super(name,national_id);
        this.diploma_id = diploma_id;
    }
    
    public Schedule getSchedule(){
        return null;
    }
    
    public int getDiploma_id() {
            return diploma_id;
    }
    
    @Override
    public String toString(){
        return "Doctor Name: " + getName() + ", National ID: " + getNational_id() + ", Diploma ID: " + this.diploma_id;
    }

    

}
