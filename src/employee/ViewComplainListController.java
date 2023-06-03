/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import customers.Complain;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import user.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewComplainListController implements Initializable {

    @FXML    private TableView<Complain> tableView;
    @FXML    private TableColumn<Complain, String> idColumn;
    @FXML    private TableColumn<Complain, String> fullNameColumn;
    @FXML    private TableColumn<Complain, String> emailColumn;
    @FXML    private TableColumn<Complain, String> complainColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Complain,String>("id"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<Complain,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Complain,String>("email"));
        complainColumn.setCellValueFactory(new PropertyValueFactory<Complain,String>("description"));
        
        
        tableView.setItems(getComplain());
        
        //Allow first and last name to be edittable
        tableView.setEditable(true);
        idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fullNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        //allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }    
    
    
     public ObservableList<Complain> getComplain(){
        ObservableList<Complain> complain = FXCollections.observableArrayList();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("file/complain.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Complain c;
            try{
                //outputTextArea.setText("");
                while(true){
                    //System.out.println("Printing objects.");
                    c = (Complain)ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    //emp.submitReport();
                    System.out.println(c.toString());
                    //outputTextArea.appendText(emp.toString());
                    List<String> data = Arrays.asList(c.toString().split(","));
                    
                   String id = data.get(0);
                System.out.println(id);
                String fullName = data.get(1);
                System.out.println(fullName);
                String email = data.get(2);
                System.out.println(email);
                String com = data.get(3);
                System.out.println(com);
                    
                Complain cl = new Complain(id, fullName, email, com);
                System.out.println(cl);
                //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
                complain.add(cl); 
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
//        File file = new File("file/complain.txt");
//        Scanner sc; String str=null;
//        
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
//                
//                String id = data.get(0);
//                System.out.println(id);
//                String fullName = data.get(1);
//                System.out.println(fullName);
//                String email = data.get(2);
//                System.out.println(email);
//                String com = data.get(3);
//                System.out.println(com);
//                    
//                Complain c = new Complain(id, fullName, email, com);
//                System.out.println(c);
//                //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
//                complain.add(c); 
//                
//            
//                                     
//            }
//           
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(GenerateCustomerListController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
         
        return complain;
    } 
    
}
