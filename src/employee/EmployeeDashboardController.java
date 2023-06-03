
package employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpackage.LoginSceneController;
import mainpackage.WasaMainClass;

public class EmployeeDashboardController implements Initializable {

    @FXML    private BorderPane borderPane;
    @FXML    private Button addCustButton;
    @FXML    private Button customerListButton;
    @FXML    private Button complainButton;
    @FXML    private Button eventButton;
    @FXML    private Button eventfeedbackButton;
    @FXML    private Button leaveAbsenceButton;
    @FXML    private Button resourceApprovalButton;
    @FXML    private Button searchButton;
    @FXML    private Button dashboardButton;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label mobileLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label dobLabel;


  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dashboard("joy");
    }    

    @FXML
    private void employeeLogOut(ActionEvent event) throws IOException {
        WasaMainClass wmc = new WasaMainClass();
        wmc.logOutScene(event);
    }
    
    public void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void employeeDashboardButtonOnClick(MouseEvent event) throws IOException {
        //loadUI("EmployeeDashboard");
            Parent r = FXMLLoader.load(getClass().getResource("EmployeeDashboard.fxml"));
            Scene loginScene = new Scene(r);
            Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(loginScene);
            stg2.show();
        
    }
    
    public void dashboard(String u){
        //use BufferedReader OR Scanner
        File file = new File("file/users.txt");
        Scanner sc; String str=null;
        String s = "";
        
        try {
            sc = new Scanner(file);
            
            while(sc.hasNextLine()){
                
                str=sc.nextLine();
                             
                List<String> data = Arrays.asList(str.split(","));
                if(data.get(1).equals(u)  && data.get(7).equals("Employee")){
                    idLabel.setText(data.get(0));
                    nameLabel.setText(data.get(3));
                    userNameLabel.setText(data.get(1));
                    emailLabel.setText(data.get(4));
                    mobileLabel.setText(data.get(5));
                    addressLabel.setText(data.get(6));
                    dobLabel.setText(data.get(8));
                }
            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }

    @FXML
    private void addCustomerButtonOnClick(MouseEvent event) {
        loadUI("AddCustomer");
    }
    
    @FXML
    private void generateCutomerList(MouseEvent event) {
        loadUI("GenerateCustomerList");
    }


    @FXML
    private void viewComplaintList(MouseEvent event) {
        loadUI("ViewComplainList");
    }

    @FXML
    private void registerEventButton(MouseEvent event) {
        loadUI("EventRegistration");
    }

    @FXML
    private void giveFeedbackButtonOnClick(MouseEvent event) {
        loadUI("EventFeedback");
    }

    @FXML
    private void applyLeaveAbsenceButtonOnClick(MouseEvent event) {
        loadUI("ApplyLeaveOfAbsence");
    }

    @FXML
    private void requestForResourceApprovalButtonOnClick(MouseEvent event) {
        loadUI("ResourceApprovalRequest");
    }

    @FXML
    private void searchCustomerOnClick(MouseEvent event) {
        loadUI("SearchCustomer");
    }

    

    

    
    
}
