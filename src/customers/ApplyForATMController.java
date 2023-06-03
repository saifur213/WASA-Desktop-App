/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import admin.AddUserController;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplyForATMController implements Initializable {

    @FXML    private TextField csutId;
    @FXML    private TextField custName;
    @FXML    private TextField custMobile;
    @FXML    private TextField custEmail;
    @FXML    private TextField durationInMonth;
    @FXML    private DatePicker datePicker;
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
//        ATM a = new ATM(
//               csutId.getText(),
//               custName.getText(),
//               custMobile.getText(),
//               custEmail.getText(),
//               datePicker.getValue(),
//               Integer.parseInt(durationInMonth.getText())
//               
//           );
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/atm-application.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
      ATM a = new ATM(
               csutId.getText(),
               custName.getText(),
               custMobile.getText(),
               custEmail.getText(),
               datePicker.getValue(),
               Integer.parseInt(durationInMonth.getText())
               
           );
            oos.writeObject(a);
            messageLabel.setText("Application Submitted Successfuly.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Application Submission falied.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Application Submission falied.");
            }
        }  

          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/atm-application.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(a.toString());
//                messageLabel.setText("Application Submitted Successfuly.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("Application Submission falied.");
//            }
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
