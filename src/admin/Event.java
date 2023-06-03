
package admin;

import java.time.LocalDate;


public class Event {
    private String eventId,eventName,description;
    private LocalDate eventDate;

    public Event() {
    }

    public Event(String eventId, String eventName, String description, LocalDate eventDate) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.eventDate = eventDate;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return eventId + "," + eventName + "," + description + "," + eventDate+"\n";
    }
    
    
}
