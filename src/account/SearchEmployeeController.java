/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import employee.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import user.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SearchEmployeeController implements Initializable {

    @FXML    private TextField empId;
    @FXML    private TextField empFullName;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> idColumn;
    @FXML
    private TableColumn<User, String> fullNameColumn;
    @FXML
    private TableColumn<User, String> mobileColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TableColumn<User, String> dobColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //set up the columns in the table
        idColumn.setCellValueFactory(new PropertyValueFactory<User,String>("userId"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("fullname"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Mobile"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Email"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<User,String>("Dob"));
    }    

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
        String userId = empId.getText();
        String userName = empFullName.getText();
        
        
        ObservableList<User> people = FXCollections.observableArrayList();
        
        
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
                    
                   if(data.get(0).equals(userId) && data.get(3).equals(userName) && data.get(7).equals("Employee")){
                    String id = data.get(0);
                    String fullName = data.get(3);
                    String email = data.get(4);
                    String mobile = data.get(5);
                    LocalDate dob = LocalDate.of(1998, Month.AUGUST, 12);
                    
                    
                    User c = new User(id, fullName, email, mobile, dob);
                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
                    people.add(c);
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
//                if(data.get(0).equals(userId) && data.get(3).equals(userName)){
//                    String id = data.get(0);
//                    String fullName = data.get(3);
//                    String email = data.get(4);
//                    String mobile = data.get(5);
//                    LocalDate dob = LocalDate.of(1998, Month.AUGUST, 12);
//                    
//                    
//                    User c = new User(id, fullName, email, mobile, dob);
//                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
//                    people.add(c);
//                }
//                                      
//            }
//           
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(GenerateCustomerListController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
         
        
//        people.add(new Person("Ahsan", "Habib", LocalDate.of(1998, Month.AUGUST, 12)));
//        people.add(new Person("Lisa", "Rahman", LocalDate.of(2000, Month.JUNE, 30)));
//        people.add(new Person("Farid", "Uddin", LocalDate.of(2001, Month.APRIL, 17)));
        tableView.setItems(people); 
    }

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
