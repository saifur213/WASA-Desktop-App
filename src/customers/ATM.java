
package customers;

import java.io.Serializable;
import java.time.LocalDate;


public class ATM implements Serializable{
    private String id,name,mobile,email;
    private LocalDate date;
    private int duration;

    public ATM() {
    }

    public ATM(String id, String name, String mobile, String email, LocalDate date, int duration) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.date = date;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + mobile + "," + email + "," + date + "," + duration + "\n";
    }

    

    
    
}
