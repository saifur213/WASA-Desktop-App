
package admin;

import customers.Customer;
import employee.Employee;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.AppendableObjectOutputStream;
import user.User;


public class AddEmployeeController implements Initializable {

    @FXML
    private TextField empId;
    @FXML
    private TextField empName;
    @FXML
    private TextField empUsername;
    @FXML
    private TextField empPassword;
    @FXML    private TextField custEmaempEmail;
    @FXML
    private TextField empMobile;
    @FXML
    private TextField empAddress;
    @FXML
    private ComboBox<String> userTyoeComboBox;
    @FXML
    private DatePicker empJoiningDatePicker;
    @FXML
    private DatePicker empDobDatePicker;
    @FXML
    private Label messageLabel;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //userTyoeComboBox.getItems().add("Admin");
        userTyoeComboBox.getItems().addAll("Employee");
    }    

    @FXML
    public void addEmployeeButtonOnClick(ActionEvent event) {
        
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/users.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Employee e = new Employee(
               //empJoiningDatePicker.getValue(),
               empId.getText(),
               empUsername.getText(),
               empPassword.getText(),
               empName.getText(),
               custEmaempEmail.getText(),
               empMobile.getText(),
               empAddress.getText(),
               userTyoeComboBox.getValue(),
               empDobDatePicker.getValue()
               
           );
            
            oos.writeObject(e);
            messageLabel.setText("Employee Added Successfuly in bin file.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Employee Added Failed in text file.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Employee Added Failed in text file.");
            }
        }   

          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/users.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(e.toString());
//                messageLabel.setText("Employee Added Successfuly.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("Employee Added Failed.");
//            }
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }

    
}
