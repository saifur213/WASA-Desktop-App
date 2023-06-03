
package employee;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.User;


public class Employee extends User implements Serializable{
    
    private LocalDate joiningDate;

    public Employee() {
    }
    
    

    public Employee(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Employee(LocalDate joiningDate, String userId, String username, String password, String fullname, String email, String mobile, String address, String usertype, LocalDate dob) {
        super(userId, username, password, fullname, email, mobile, address, usertype, dob);
        this.joiningDate = joiningDate;
    }

    public Employee(String userId, String fullname, String email, String mobile, LocalDate dob, String address) {
        super(userId, fullname, email, mobile, dob, address);
    }

    public Employee(String userId, String username, String password, String fullname, String email, String mobile, String address, String usertype, LocalDate dob) {
        super(userId, username, password, fullname, email, mobile, address, usertype, dob);
    }

    
    
    

    
    public void performLogin(ActionEvent event,String username) throws IOException{
            Parent employeeDashBoardRoot = FXMLLoader.load(getClass().getResource("EmployeeDashboard.fxml"));
            Scene employeeScene = new Scene(employeeDashBoardRoot);
                        
            Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(employeeScene);
            
            EmployeeDashboardController ec = new EmployeeDashboardController();
            ec.dashboard(username);
            
            stg2.show();
            
            
    }

   

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

 
    
}
