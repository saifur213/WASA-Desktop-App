/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import customers.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CustomerDetailsViewSceneController implements Initializable {

    private Customer selectedPerson;
    
    @FXML    private Label idLabel;
    @FXML    private Label nameLabel;
    @FXML    private Label emailLabel;
    @FXML    private Label mobileLabel;
    @FXML    private Label dobLabel;
    @FXML    private Label addressLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initData(Customer p){
        selectedPerson = p;
        idLabel.setText(selectedPerson.getUserId());
        nameLabel.setText(selectedPerson.getFullname());
        emailLabel.setText(selectedPerson.getEmail());
        mobileLabel.setText(selectedPerson.getMobile());
        dobLabel.setText(selectedPerson.getDob().toString());
        addressLabel.setText(selectedPerson.getAddress());
    }

    
}
