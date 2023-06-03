/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainpackage.LoginSceneController;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewProfileController implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label mobileLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label addressLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //profile("arman");
        idLabel.setText("2020874");
        nameLabel.setText("Arman Hossain");
        emailLabel.setText("arman@gmail.com");
        mobileLabel.setText("01873645");
        dobLabel.setText("2/2/2000");
        addressLabel.setText("Dhaka");
        
        
    }    
    
    public void profile(String u){
        //use BufferedReader OR Scanner
        File file = new File("file/users.txt");
        Scanner sc; String str=null;
        String s = "";
        
        try {
            sc = new Scanner(file);
            
            while(sc.hasNextLine()){
                
                str=sc.nextLine();
                             
                List<String> data = Arrays.asList(str.split(","));
                if(data.get(1).equals(u)  && data.get(7).equals("Customer")){
                    idLabel.setText(data.get(0));
                    nameLabel.setText(data.get(3));
                    emailLabel.setText(data.get(4));
                    mobileLabel.setText(data.get(5));
                    dobLabel.setText(data.get(8));
                    addressLabel.setText(data.get(6));
                }
            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }


    
}
