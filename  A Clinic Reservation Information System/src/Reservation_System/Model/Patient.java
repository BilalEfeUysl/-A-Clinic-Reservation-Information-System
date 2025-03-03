
package Reservation_System.Model;

import java.io.Serializable;

public class Patient extends Person implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
    public Patient(String name, Long national_id) {
        super(name, national_id);
    }
    
}
