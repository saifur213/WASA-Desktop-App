/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import admin.AddUserController;
import customers.Customer;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import user.AppendableObjectOutputStream;
import user.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddCustomerController implements Initializable {

    @FXML    private TextField csutId;
    @FXML    private TextField custName;
    @FXML    private TextField custUsername;
    @FXML    private TextField custPassword;
    @FXML    private TextField custEmail;
    @FXML    private TextField custMobile;
    @FXML    private DatePicker custDobDatePicker;
    @FXML    private TextField custAddress;
    @FXML    private ComboBox<String> custUserTypeCOmboBox;
    @FXML
    private Label messageLabel;
    
    
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        custUserTypeCOmboBox.getItems().add("Admin");
        custUserTypeCOmboBox.getItems().addAll("Admin","Accounts","Employee","Customer"," Service","Maintenance","Manager","Security officer","HR manager","Worker Supervisor");
    }   
    
    

    @FXML
    private void addCustButton(ActionEvent event) {
//        Customer c = new Customer(
//               csutId.getText(),
//               custUsername.getText(),
//               custPassword.getText(),
//               custName.getText(),
//               custEmail.getText(),
//               custMobile.getText(),
//               custAddress.getText(),
//               custUserTypeCOmboBox.getValue(),
//               custDobDatePicker.getValue()
//               
//           );
        
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
            Customer c = new Customer(
               csutId.getText(),
               custUsername.getText(),
               custPassword.getText(),
               custName.getText(),
               custEmail.getText(),
               custMobile.getText(),
               custAddress.getText(),
               custUserTypeCOmboBox.getValue(),
               custDobDatePicker.getValue()
               
           );
            oos.writeObject(c);
            messageLabel.setText("Customer Added Successfuly in bin file.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Customer Added Failed in bin file.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Customer Added Failed in bin file.");
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
//                fw.write(c.toString());
//                messageLabel.setText("User Added Successfuly in text file.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("User Added Failed in text file.");
//            }
        
    }

    @FXML
    private void custCancelButton(ActionEvent event) {
    }

    
    
}
