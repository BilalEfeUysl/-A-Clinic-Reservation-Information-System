
package Reservation_System;

import java.io.Serializable;
import java.util.LinkedList;


public class Section implements Serializable{
    private final int id;
    private String name;
    private LinkedList<Doctor> doctors;

    public Section(int id, String name) {
        this.id = id;
        this.name = name;
        this.doctors = new LinkedList<>();
    }
    
    public void listDoctor(){
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public Doctor getDoctors(int diploma_id) {
        for (Doctor doctor : doctors) {
            if(doctor.getDiploma_id() == diploma_id){
                return doctor;
            }
        }
        return null;
    }
    
    public void addDoctor(Doctor doctor) throws DuplicateInfoException{
        for (Doctor existingDoctor : doctors) {
            if(existingDoctor.getDiploma_id() == doctor.getDiploma_id()){
                throw new DuplicateInfoException("Duplicate diploma ID: " + doctor.getDiploma_id());
            }
        }
        doctors.add(doctor);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
    
    
}
