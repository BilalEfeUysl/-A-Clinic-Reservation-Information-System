
package Reservation_System.Model;

import java.io.Serializable;


public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String name;
    private final long national_id;
    
    public Person(String name,Long national_id){
        this.name = name;
        this.national_id = national_id;
    }

    public String getName() {
        return name;
    }

    public long getNational_id() {
        return national_id;
    }
    
    @Override
    public String toString(){
        return "Name: " + this.name + " , National ID: " + String.valueOf(this.national_id); 
    }
}
