
package Reservation_System;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;



public class CRS {
    private HashMap<Long,Patient> patients;
    private LinkedList<Rendezvous> rendezvous;
    private HashMap<Integer,Hospital> hospitals;
    
    public boolean makeRandezvous(long patientID,int HospitalID,int sectionID,int diplomaID,Date desiredDate){
        return true;
    }
    
    public void saveTablesToDisk(String fullPath){
        
    }
    
    public void loadTablesToDisk(String fullPath){
        
    }
}
