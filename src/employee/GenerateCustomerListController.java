
package employee;

import customers.Customer;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainpackage.LoginSceneController;
import user.User;


public class GenerateCustomerListController implements Initializable {

    @FXML    private TableView<Customer> custTableView;
    @FXML    private TableColumn<Customer, String> idColumn;
    @FXML    private TableColumn<Customer, String> fullNameColumn;
    @FXML    private TableColumn<Customer, String> emailColumn;
    @FXML    private TableColumn<Customer, String> mobileColumn;
    @FXML    private TableColumn<Customer, LocalDate> dobColumn;
    @FXML    private TableColumn<Customer, String> addressColumn;
    @FXML
    private AnchorPane anchorPane;
    
     private double x,y;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("userId"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("fullname"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Email"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Mobile"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Customer,LocalDate>("Dob"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("Address"));
        
        
        custTableView.setItems(getCustomer()); 
        
        
        //Allow first and last name to be edittable
        custTableView.setEditable(true);
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fullNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        custTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }   
    
    public ObservableList<Customer> getCustomer(){
        ObservableList<Customer> people = FXCollections.observableArrayList();
        
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
                    
                    if(data.get(7).equals("Customer")){
                    String id = data.get(0);
                    //System.out.println(id);
                    String fullName = data.get(3);
                    //System.out.println(fullName);
                    String email = data.get(4);
                    String mobile = data.get(5);
                    LocalDate dob = LocalDate.of(1998, Month.AUGUST, 12);
                    String address = data.get(6);
                    
                    Customer e = new Customer(id, fullName, email, mobile, dob, address);
                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
                    people.add(e);
                }
                    //people.add(u.toString());
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
//                if(data.get(7).equals("Employee")){
//                    String id = data.get(0);
//                    System.out.println(id);
//                    String fullName = data.get(3);
//                    System.out.println(fullName);
//                    String email = data.get(4);
//                    String mobile = data.get(5);
//                    LocalDate dob = LocalDate.of(1998, Month.AUGUST, 12);
//                    String address = data.get(6);
//                    
//                    Employee e = new Employee(id, fullName, email, mobile, dob, address);
//                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
//                    people.add(e);
//                }
//                                      
//            }
//           
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(GenerateCustomerListController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
//         
//        
////        people.add(new Person("Ahsan", "Habib", LocalDate.of(1998, Month.AUGUST, 12)));
////        people.add(new Person("Lisa", "Rahman", LocalDate.of(2000, Month.JUNE, 30)));
////        people.add(new Person("Farid", "Uddin", LocalDate.of(2001, Month.APRIL, 17)));
          return people;
    } 
    


    @FXML
    private void viewDetailsCustomer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerDetailsViewScene.fxml"));
        Parent customerViewParent = loader.load();

        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene personViewScene = new Scene(customerViewParent);
        
        customerViewParent.setOnMousePressed(new EventHandler<MouseEvent> (){
            @Override
            public void handle(MouseEvent event){
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        
        customerViewParent.setOnMouseDragged(new EventHandler<MouseEvent> (){
            @Override
            public void handle(MouseEvent event){
                //stage.setX(event.getSceneX() - x);
                //stage.setY(event.getSceneY() - y);
                
            }
        });
        
        //access the controller
        CustomerDetailsViewSceneController controller = loader.getController();
        //controller = new PersonViewSceneController();
        controller.initData(custTableView.getSelectionModel().getSelectedItem());
                
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(personViewScene);
        window.show();
    }
    
}
