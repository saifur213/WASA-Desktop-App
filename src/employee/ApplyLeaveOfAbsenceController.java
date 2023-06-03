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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplyLeaveOfAbsenceController implements Initializable {

    @FXML    private TextField empID;
    @FXML    private TextField empName;
    @FXML    private TextField empMobile;
    @FXML    private TextField empEmail;
    @FXML    private TextArea reasonTextArea;
    @FXML
    private Label messageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void applyButtonOnClick(ActionEvent event) {
//        LeaveApplication la = new LeaveApplication(
//               empID.getText(),
//               empName.getText(),
//               empMobile.getText(),
//               empEmail.getText(),
//               reasonTextArea.getText()
//               
//               
//           );
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/leave-application.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
        LeaveApplication la = new LeaveApplication(
               empID.getText(),
               empName.getText(),
               empMobile.getText(),
               empEmail.getText(),
               reasonTextArea.getText()
               
               
           );
            oos.writeObject(la);
            messageLabel.setText("Application Submitted Successfully.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Application Submission Failed.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Application Submission Failed.");
            }
        } 

          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/leave-application.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(la.toString());
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
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
