/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import admin.AddUserController;
import admin.Event;
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

/**
 * FXML Controller class
 *
 * @author User
 */
public class PayEmployeeSalaryController implements Initializable {

    @FXML    private TextField empId;
    @FXML    private TextField empName;
    @FXML    private TextField empName1;
    @FXML    private DatePicker datePicker;
    @FXML    private ComboBox<String> monthComboBox;
    @FXML    private ComboBox<String> yearComboBox;
    @FXML    private TextField amount;
    @FXML
    private Label messageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        monthComboBox.getItems().addAll("January","February","March","April","May","June","July","August","September","November","December");
        yearComboBox.getItems().addAll("2023","2022","2021","2020");
    }    

    @FXML
    private void payButtonOnCLick(ActionEvent event) {
//        EmployeeSalary es = new EmployeeSalary(
//               empId.getText(),
//               empName.getText(),
//               empName1.getText(),
//               datePicker.getValue().toString(),
//               monthComboBox.getValue(),
//               yearComboBox.getValue(),
//               Float.parseFloat(amount.getText())
//           );
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("file/employee-salary.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            EmployeeSalary es = new EmployeeSalary(
               empId.getText(),
               empName.getText(),
               empName1.getText(),
               datePicker.getValue().toString(),
               monthComboBox.getValue(),
               yearComboBox.getValue(),
               Float.parseFloat(amount.getText())
           );
            oos.writeObject(es);
            messageLabel.setText("Payment done Successfuly.");

        } catch (IOException ex) {
            Logger.getLogger(PayEmployeeSalaryController.class.getName()).log(Level.SEVERE, null, ex);
            messageLabel.setText("Payment falied");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(PayEmployeeSalaryController.class.getName()).log(Level.SEVERE, null, ex);
                messageLabel.setText("Payment falied");
            }
        }  

          
//        try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File f = new File("file/employee-salary.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(f.exists())
//                    fw = new FileWriter(f,true);
//                else 
//                    fw = new FileWriter(f);
//
//                fw.write(es.toString());
//                messageLabel.setText("Payment done Successfuly.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                messageLabel.setText("Payment falied.");
//            }
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
