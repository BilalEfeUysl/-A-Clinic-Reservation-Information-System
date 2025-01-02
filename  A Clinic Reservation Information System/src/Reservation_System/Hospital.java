
package Reservation_System;

import java.io.Serializable;
import java.util.LinkedList;


public class Hospital implements Serializable{
    private final int id;
    private String name;
    private LinkedList<Section> sections;

    public Hospital(int id, String name) {
        this.id = id;
        this.name = name;
        
        this.sections = new LinkedList<>();
    }

    public Section getSections(int id) {
        for (Section section : sections) {
            if(section.getId() == id){
                return section;
            } 
        }
        
        return null;
    }
    
    public Section getSections(String name) {
        for (Section section : sections) {
            if(section.getName() == name){
                return section;
            } 
        }
        
        return null;
    }
    
    public void addSection(Section section){
        sections.add(section);
    }
    
}
