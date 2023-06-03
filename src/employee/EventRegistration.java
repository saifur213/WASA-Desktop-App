
package employee;

import java.io.Serializable;
import java.time.LocalDate;

public class EventRegistration implements Serializable{
    private String id,name,mobile,email,eventId,eventName,feedback;
    private LocalDate eventDate;

    public EventRegistration() {
    }

    public EventRegistration(String id, String name, String mobile, String email, String eventId, String eventName, LocalDate eventDate) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
    }
    public EventRegistration(String id, String name, String mobile, String email, String eventId, String eventName) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.eventId = eventId;
        this.eventName = eventName;
       
    }

    public EventRegistration(String id, String name, String mobile, String email, String eventId, String eventName, String feedback) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.eventId = eventId;
        this.eventName = eventName;
        this.feedback = feedback;
    }
    
    

    @Override
    public String toString() {
        return id + "," + name + "," + mobile + "," + email + "," + eventId + "," + eventName + "," + eventDate;
    }
    
    
}
