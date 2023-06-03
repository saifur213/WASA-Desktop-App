
package employee;

import admin.AddUserController;
import admin.Event;
import customers.Customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.AppendableObjectOutputStream;


public class EventRegistrationController implements Initializable {

    @FXML    private TextField empID;
    @FXML    private TextField empName;
    @FXML    private TextField empMobile;
    @FXML    private TextField empEmail;
    @FXML
    private ComboBox<String> eventIdComboBox;
    @FXML
    private ComboBox<String> EventNameComboBox;
    private ComboBox<String> EventDateCombobox;
    @FXML
    private Label messageLabel;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventIdComboBox.getItems().addAll("101","102","103");
        EventNameComboBox.getItems().addAll("Yearly-Meetup","Annual Picnic","Meet");
//        EventDateCombobox.getItems().addAll("1/1/2023","1/5/2023","1/6/2023");
    } 
    
    

    @FXML
    private void registerEventButtonOn(ActionEvent event) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
//        EventRegistration e = new EventRegistration(
//               empID.getText(),
//               empName.getText(),
//               empMobile.getText(),
//               empEmail.getText(),
//                eventIdComboBox.getValue(),
//                EventNameComboBox.getValue()
//                
//           );



            File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/Events-Registration.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
        EventRegistration e = new EventRegistration(
               empID.getText(),
               empName.getText(),
               empMobile.getText(),
               empEmail.getText(),
                eventIdComboBox.getValue(),
                EventNameComboBox.getValue()
                
           );
            oos.writeObject(e);
            messageLabel.setText("Registration Successfull.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Registration Failed.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Registration Failed.");
            }
        }   
//
//          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/Events-Registration.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(e.toString());
//                messageLabel.setText("Registration Successfull.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("Registration Failed.");
//            }
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
