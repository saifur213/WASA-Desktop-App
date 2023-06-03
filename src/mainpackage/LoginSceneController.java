/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import account.Account;
import admin.SystemAdmin;
import customers.Customer;
import employee.Employee;
import hrmanager.HrManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import maintenance.Maintenance;
import manager.Manager;
import securityofficer.SecurityOfficer;
import service.Service;
import user.User;
import workersupervisor.WorkerSupervisor;

/**
 *
 * @author User
 */
public class LoginSceneController implements Initializable {
    
 
    @FXML    private TextField userNameTextField;
    @FXML    private PasswordField passwordFieldTextField;
    @FXML    private Button signInButtonField;
    @FXML    private Hyperlink forgetPasswordHyperlink;
    @FXML    private ComboBox<String> userTypeComboBox;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().add("System Admin");
        userTypeComboBox.getItems().add("Accounts");
        userTypeComboBox.getItems().addAll("Employee","Customer","Service","Maintenance","Manager","Security officer","HR manager","Worker Supervisor");
    }

    private String readUserData(String value,int index) {
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("file/users.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User u;
            try{
                //outputTextArea.setText("");
                while(true){
                    //System.out.println("Printing objects.");
                    u = (User)ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    //emp.submitReport();
                    System.out.println(u.toString());
                    //outputTextArea.appendText(emp.toString());
                    List<String> data = Arrays.asList(u.toString().split(","));
                    if(value.equals(data.get(index))){
                    
                    return data.get(index);
                } 
                   
                    
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            //outputTextArea.appendText("All objects are loaded successfully...\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
//        //use BufferedReader OR Scanner
//        File file = new File("file/users.txt");
//        Scanner sc; String str=null;
//        String s = "";
//        
//        try {
//            sc = new Scanner(file);
//            
//            while(sc.hasNextLine()){
//                
//                str=sc.nextLine();
//                             
//                List<String> data = Arrays.asList(str.split(","));
//                
////                for(int i=0;i<data.size();i++){
////                    System.out.println(data.get(i));
////                    if(data.get(i)==value){
////                    //return data.get(index);
////                        System.out.println(data.get(i));
////                        return true;
////                    }
////                }
//                //System.out.println(data.get(index));
//                
//                if(value.equals(data.get(index))){
//                    
//                    return data.get(index);
//                }   
//
//
//
//
//            }
//           
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(LoginSceneController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
        return null;
    }
   
    @FXML
    private void login(ActionEvent event) throws IOException {
        WasaMainClass wmc = new WasaMainClass();
        User u = new User();
        Employee e = new Employee();
        Customer c = new Customer();
        SystemAdmin s = new SystemAdmin();
        Account a = new Account();
        Service ser = new Service();
        Maintenance m = new Maintenance();
        Manager man = new Manager();
        SecurityOfficer so = new SecurityOfficer();
        HrManager hr = new HrManager();
        WorkerSupervisor ws = new WorkerSupervisor();
        


        String username = readUserData(userNameTextField.getText().toString(),1);
        String password = readUserData(passwordFieldTextField.getText().toString(),2);
        String usertype = readUserData(userTypeComboBox.getValue().toString(),7);
 
         
   
        
        if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Employee")){
            e.performLogin(event,username); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Customer")){
            c.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("System Admin")){
            s.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Accounts")){
            a.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) &&  userTypeComboBox.getValue().toString().equals("Service")){
            ser.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Maintenance")){
            m.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Manager")){
            man.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Security officer")){
            so.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("HR manager")){
            hr.performLogin(event); 
        }
        else if(userNameTextField.getText().toString().equals(username) && passwordFieldTextField.getText().toString().equals(password) && userTypeComboBox.getValue().toString().equals("Worker Supervisor")){
            ws.performLogin(event); 
        }
        else{
            wmc.LoginWarning();
        }

    }

    
}
