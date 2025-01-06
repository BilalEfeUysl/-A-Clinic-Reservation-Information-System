
package Reservation_System.Model;

import Reservation_System.Exceptions.IDException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CRS {
    
    private static final long serialVersionUID = 1L;
    
    private HashMap<Long,Patient> patients;
    private LinkedList<Rendezvous> rendezvous;
    private HashMap<Integer,Hospital> hospitals;
    private boolean guiMode = false;
    
    public CRS() {
        patients = new HashMap<>();
        rendezvous = new LinkedList<>();
        hospitals = new HashMap<>();
    }
    public boolean isGuiMode(){
        return this.guiMode;
    } 
    public void setGuiMode(boolean guiMode){
        this.guiMode = guiMode;
    }
    public boolean makeRandezvous(long patientID,int hospitalID,int sectionID,int diplomaID,Date desiredDate){
        Patient patient = patients.get(patientID);
        Hospital hospital = hospitals.get(hospitalID);
        
        if(patient == null){
            if(!guiMode){
                throw new IDException("Patient with ID " + patientID+" not found.");
            }
            
            return false;
        }
        if(hospital == null){
            if(!guiMode){
                throw new IDException("Hospital with ID " + hospitalID + " not found.");
             }
            return false;
        }
        
        Section section = hospital.getSection(sectionID);
        
        if(section == null){
            if(!guiMode){
                throw new IDException("Section with ID " + sectionID + " not found.");
             }
            return false;
        }
        
        Doctor doctor = section.getDoctor(diplomaID);

        if (doctor == null) {
             if(!guiMode){
                 throw new IDException("Doctor with diploma ID " + diplomaID + " not found.");
             }
            return false;
        }
        Schedule schedule = doctor.getSchedule();
        if (schedule==null){
            schedule = new Schedule(15);
        }
        boolean isAdded = schedule.addRendezvous(patient,desiredDate);
        if (isAdded){
            rendezvous.add(new Rendezvous(patient,desiredDate));
            return true;
        }else{
            return false;
        }
    }
    
    public void saveTablesToDisk(String fullPath) throws IDException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            oos.writeObject(this);
            System.out.println("Veriler basariyla kaydedildi: " + fullPath);
        } catch(IOException e){
            throw new IDException("Veriler kaydedilirken bir hata olustu: " + e.getMessage());
        }
        
    }
    
    public void loadTablesToDisk(String fullPath) throws IDException{
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fullPath)) ){
            
            CRS loadedData = (CRS)ois.readObject();
            this.patients = loadedData.patients;
            this.hospitals = loadedData.hospitals;
            this.rendezvous = loadedData.rendezvous;
            
            System.out.println("Veriler başarıyla yüklendi: " + fullPath);
            
        } catch (IOException | ClassNotFoundException e ) {
            throw new IDException("Veriler yüklenirken bir hata oluştu: " + e.getMessage());
        }
    }
    
    public void addPatient(Patient patient){
        patients.put(patient.getNational_id(), patient);
    }
    public void addHospital(Hospital hospital){
        hospitals.put(hospital.getId(),hospital);
    }

    public HashMap<Long, Patient> getPatients() {
        return patients;
    }

    public HashMap<Integer, Hospital> getHospitals() {
        return hospitals;
    }

    public LinkedList<Rendezvous> getRendezvous() {
        return rendezvous;
    }
}
