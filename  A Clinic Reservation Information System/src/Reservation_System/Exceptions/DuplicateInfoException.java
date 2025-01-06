
package Reservation_System.Exceptions;

import java.lang.RuntimeException;

public class DuplicateInfoException extends RuntimeException {
    public DuplicateInfoException(String message){
        super(message);
    }
}
