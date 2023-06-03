
package employee;

import java.io.Serializable;


public class LeaveApplication implements Serializable{
    
    private String id,name,mobile,email,reason;

    public LeaveApplication() {
    }

    public LeaveApplication(String id, String name, String mobile, String email, String reason) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + mobile + "," + email + "," + reason+"\n";
    }
    
    
    
    
}
