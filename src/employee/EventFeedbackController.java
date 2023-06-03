/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import user.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EventFeedbackController implements Initializable {

    @FXML    private TextField empID;
    @FXML    private TextField empName;
    @FXML    private TextField empMobile;
    @FXML    private TextField empEmail;
    @FXML    private ComboBox<String> eventIdComboBox;
    @FXML    private ComboBox<String> EventNameComboBox;
    @FXML    private TextArea feedbackTextArea;
    @FXML
    private Label messageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventIdComboBox.getItems().addAll("E-100");
        EventNameComboBox.getItems().addAll("Yearly Meetup");
    }    

    @FXML
    private void feedbackButtonOnClick(ActionEvent event) {
        
//        EventRegistration e = new EventRegistration(
//               empID.getText(),
//               empName.getText(),
//               empMobile.getText(),
//               empEmail.getText(),
//                eventIdComboBox.getValue(),
//                EventNameComboBox.getValue(),
//                feedbackTextArea.getText()
//                
//           );
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/Events-Feedback.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
        EventRegistration er = new EventRegistration(
               empID.getText(),
               empName.getText(),
               empMobile.getText(),
               empEmail.getText(),
                eventIdComboBox.getValue(),
                EventNameComboBox.getValue(),
                feedbackTextArea.getText()
                
           );
            oos.writeObject(er);
            messageLabel.setText("Feedback Submitted Successfully.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Feedback Submission Failed.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Feedback Submission Failed.");
            }
        }   

          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/Events-Feedback.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(e.toString());
//                messageLabel.setText("Feedback Submitted Successfully.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("Feedback Submission Failed.");
//            }
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
