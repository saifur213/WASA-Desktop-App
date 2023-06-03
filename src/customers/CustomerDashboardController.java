
package customers;

import employee.EmployeeDashboardController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mainpackage.WasaMainClass;


public class CustomerDashboardController implements Initializable {

    @FXML    private Button viewProfileButton;
    @FXML    private Button updateProfileButton;
    @FXML    private Button payBillButton;
    @FXML    private Button makeComplainButton;
    @FXML    private Button applyForAtmButton;
    @FXML    private Button viewMonthlyBillButton;
    @FXML    private Button downloadMonthlyBillButton;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button dashboarButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void customerLogOut(ActionEvent event) throws IOException {
        WasaMainClass wmc = new WasaMainClass();
        wmc.logOutScene(event);
    }
    
    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void dashBoardButtonOnClick(MouseEvent event) throws IOException {
            Parent r = FXMLLoader.load(getClass().getResource("CustomerDashboard.fxml"));
            Scene loginScene = new Scene(r);
            Stage stg2 = (Stage)((Node)event.getSource()).getScene().getWindow();
            stg2.setScene(loginScene);
            stg2.show();
    }

    @FXML
    private void viewProfileButtonOnCLick(MouseEvent event) {
        
        loadUI("ViewProfile");
        ViewProfileController vp = new ViewProfileController();
        vp.profile("arman");
        
    }

    @FXML
    private void updateProfileButtonOnClick(MouseEvent event) {
        loadUI("UpdateProfile");
    }

    @FXML
    private void payBillButtonOnClick(MouseEvent event) {
        loadUI("PayBill");
    }

    @FXML
    private void makeComplainButtonOnClick(MouseEvent event) {
        loadUI("MakeComplain");
    }

    @FXML
    private void applyForAtmButtonOnClick(MouseEvent event) {
        loadUI("ApplyForATM");
    }

    @FXML
    private void viewMonthlyBilButtonOnClick(MouseEvent event) {
        loadUI("ViewMonthlyBill");
    }

    @FXML
    private void downloadMonthlyBillButtonOnClick(MouseEvent event) {
        loadUI("DownloadMonthlyBill");
    }

    
    
}
