
package employee;

import java.io.Serializable;


public class ResourceApplication implements Serializable{
    private String empId,name,mobile,email,resourceName,reason;
    private int quantity;  

    public ResourceApplication() {
    }
    
    
    public ResourceApplication(String empId, String name, String mobile, String email, String resourceName, String reason, int quantity) {
        this.empId = empId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.resourceName = resourceName;
        this.reason = reason;
        this.quantity = quantity;
    }

    public ResourceApplication(String empId, String name, String mobile, String email, String resourceName) {
        this.empId = empId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.resourceName = resourceName;
    }
    
    

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return empId + "," + name + "," + mobile + "," + email + "," + resourceName + "," + reason + "," + quantity+"\n";
    }
    
    
    
    
    
}
