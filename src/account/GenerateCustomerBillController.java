/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import admin.AddUserController;
import employee.EventRegistration;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import user.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author User
 */
public class GenerateCustomerBillController implements Initializable {

    @FXML    private TextField custId;
    @FXML    private TextField custFullName;
    @FXML    private TextField custUserName;
    @FXML    private ComboBox<String> monthComboBox;
    @FXML    private DatePicker datePicker;
    @FXML    private ComboBox<String> YearComboBox;
    @FXML    private TextField billId;
    @FXML    private TextField amount;
    @FXML
    private Label messageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll("January","February","March","April","May","June","July","August","September","November","December");
        YearComboBox.getItems().addAll("2023","2022","2021","2020");
    }    

    @FXML
    private void generateBillButtonOnCLick(ActionEvent event) {
//        Bill b = new Bill(
//               custId.getText(),
//               custFullName.getText(),
//               custUserName.getText(),
//               datePicker.getValue().toString(),
//               billId.getText(),
//               monthComboBox.getValue(),
//               YearComboBox.getValue(),
//               Float.parseFloat(amount.getText())
//           );
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/bill.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-d");
        Bill b = new Bill(
               custId.getText(),
               custFullName.getText(),
               custUserName.getText(),
               datePicker.getValue().toString(),
               billId.getText(),
               monthComboBox.getValue(),
               YearComboBox.getValue(),
               Float.parseFloat(amount.getText())
           );
            oos.writeObject(b);
            messageLabel.setText("Bill generate Successfuly.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Bill generate falied.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Bill generate falied.");
            }
        }  

          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/bill.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(b.toString());
//                messageLabel.setText("Bill generate Successfuly.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("Bill generate falied.");
//            }
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
