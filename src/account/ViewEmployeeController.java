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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import user.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewEmployeeController implements Initializable {

    @FXML
    private TableView<Employee> tableView;
    @FXML
    private TableColumn<Employee, String> idColumn;
    @FXML
    private TableColumn<Employee, String> fullNameColumn;
    @FXML
    private TableColumn<Employee, String> emailColumn;
    @FXML
    private TableColumn<Employee, String> mobileColumn;
    @FXML
    private TableColumn<Employee, String> dobColumn;
    @FXML
    private TableColumn<Employee, String> addressColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("userId"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("fullname"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("Email"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("Mobile"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("Dob"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("Address"));
        
        
        tableView.setItems(getEmployee()); 
    }    
    
    public ObservableList<Employee> getEmployee(){
        ObservableList<Employee> people = FXCollections.observableArrayList();
        
        
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
                    
                    if(data.get(7).equals("Employee")){
                    String id = data.get(0);
                    //System.out.println(id);
                    String fullName = data.get(3);
                    //System.out.println(fullName);
                    String email = data.get(4);
                    String mobile = data.get(5);
                    LocalDate dob = LocalDate.of(1998, Month.AUGUST, 12);
                    String address = data.get(6);
                    
                    Employee e = new Employee(id, fullName, email, mobile, dob, address);
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
    
}
