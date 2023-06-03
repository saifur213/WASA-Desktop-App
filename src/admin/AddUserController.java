/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import user.User;
import user.AppendableObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddUserController implements Initializable {

    @FXML    private TextField userId;
    @FXML    private TextField userfullName;
    @FXML    private TextField userName;
    @FXML    private TextField userPassword;
    @FXML    private TextField userEmail1;
    @FXML    private TextField userMobile;
    @FXML    private TextField userAddress;
    @FXML    private ComboBox<String> userTypeComboBox;
    @FXML    private DatePicker userDob;
    
    private ArrayList<User> userArr;
    
    @FXML
    private Label textMessageLable;
    @FXML
    private Label binMessageLable1;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        userArr = new ArrayList<User>();
        
        userTypeComboBox.getItems().add("System Admin");
        userTypeComboBox.getItems().addAll("Accounts","Employee","Customer"," Service","Maintenance","Manager","Security officer","HR manager","Worker Supervisor");
    }    

    @FXML
    private void addUserButtonOnClick(ActionEvent event) {

         
//       User u = new User(
//               userId.getText(),
//               userName.getText(),
//               userPassword.getText(),
//               userfullName.getText(),
//               userEmail1.getText(),
//               userMobile.getText(),
//               userAddress.getText(),
//               userTypeComboBox.getValue(),
//               userDob.getValue()
//               
//           );
//        userArr.add(u);
        
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
            User u = new User(
               userId.getText(),
               userName.getText(),
               userPassword.getText(),
               userfullName.getText(),
               userEmail1.getText(),
               userMobile.getText(),
               userAddress.getText(),
               userTypeComboBox.getValue(),
               userDob.getValue()
               
           );
            oos.writeObject(u);
            textMessageLable.setText("User Added Successfuly in bin file.");

        } catch (IOException ex) {
            Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
            textMessageLable.setText("User Added Failed in text file.");
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(AddUserController.class.getName()).log(Level.SEVERE, null, ex);
                textMessageLable.setText("User Added Failed in text file.");
            }
        }   
        
//        try{
//                FileOutputStream fos = new FileOutputStream("file/users.bin", true);
//                DataOutputStream dos = new DataOutputStream(fos);
//                for(User s: userArr){
//                    dos.writeUTF(s.getUserId());
//                    dos.writeUTF(s.getUsername());
//                    dos.writeUTF(s.getPassword());
//                    dos.writeUTF(s.getFullname());
//                    dos.writeUTF(s.getEmail());
//                    dos.writeUTF(s.getMobile());
//                    dos.writeUTF(s.getAddress());
//                    dos.writeUTF(s.getUsertype());
//                    dos.writeUTF(s.getDob().toString());
//                    //dos.writeUTF((String)u.getDob());
//
//                    binMessageLable1.setText("User Added Successfuly in binary file.");
//                }
//                dos.close();
//            }
//            catch(Exception e){
//                //SHOW e.toString() IN AN ALERT
//                binMessageLable1.setText("User Added Failed in binary file.");
//            } 
        
//        try{
//                FileOutputStream fos = new FileOutputStream("file/users.bin",true);
//                ObjectOutputStream oos = new ObjectOutputStream(fos);
//                
//                oos.writeObject(u);
//                binMessageLable1.setText("User Added Successfuly in binary file.");
//                
//                
//                oos.close();
//            }
//            catch(Exception e){
//                //SHOW e.toString() IN AN ALERT
//                binMessageLable1.setText("User Added Failed in binary file.");
//            }

//            try {
//                //write code to dump studArr in Stud.txt
//                //use FileWriter
//                File fl = new File("file/users.txt");
//                FileWriter fw;
//                //FileWriter fw = new FileWriter(f);
//                if(fl.exists())
//                    fw = new FileWriter(fl,true);
//                else 
//                    fw = new FileWriter(fl);
//
//                fw.write(u.toString());
//                textMessageLable.setText("User Added Successfuly in text file.");
//                
//                fw.close();
//            } catch (IOException ex) {
//                
//                //SHOW ex.toString() IN AN ALERT
//                textMessageLable.setText("User Added Failed in text file.");
//            }


    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
