
package customers;

import java.io.Serializable;


public class Complain implements Serializable{
    private String id,name,email,description;

    public Complain() {
    }

    public Complain(String id, String name, String email, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + description + "\n";
    }
    
    
}
