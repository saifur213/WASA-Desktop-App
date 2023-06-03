
package admin;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.User;


public class SystemAdmin extends User{

    public SystemAdmin() {
    }

    public SystemAdmin(String userId, String username, String password, String fullname, String email, String mobile, String address, String usertype, LocalDate dob) {
        super(userId, username, password, fullname, email, mobile, address, usertype, dob);
    }
    

    
    public void performLogin(ActionEvent event) throws IOException{
            Parent employeeDashBoardRoot = FXMLLoader.load(getClass().getResource("SystemAdminDashboard.fxml"));
            Scene employeeScene = new Scene(employeeDashBoardRoot);
            Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(employeeScene);
            stg2.show();
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
