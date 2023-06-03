/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import account.Bill;
import employee.Employee;
import employee.GenerateCustomerListController;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import user.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ViewMonthlyBillController implements Initializable {

    @FXML    private TableView<Bill> tableView;
    @FXML    private TableColumn<Bill, String> monthColumn;
    @FXML    private TableColumn<Bill, String> yearColumn;
    @FXML    private TableColumn<Bill, String> userNameColumn;
    
    @FXML    private TableColumn<Bill, String> amountColumn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //set up the columns in the table
        monthColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("month"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("year"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("username"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("amount"));
        
        
        
        tableView.setItems(getBill()); 
    }   
    
    
    public ObservableList<Bill> getBill(){
        ObservableList<Bill> people = FXCollections.observableArrayList();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("file/bill.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Bill b;
            try{
                //outputTextArea.setText("");
                while(true){
                    //System.out.println("Printing objects.");
                    b = (Bill)ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    //emp.submitReport();
                    System.out.println(b.toString());
                    //outputTextArea.appendText(emp.toString());
                    List<String> data = Arrays.asList(b.toString().split(","));
                    
                    
                    String month = data.get(5);
                    String year = data.get(6);
                    String username = data.get(2);
                    Float amount = Float.parseFloat(data.get(7));
                    
                    
                    Bill c = new Bill(username, month, year, amount);
                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
                    people.add(c);
                
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
//        File file = new File("file/pay-bill.txt");
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
//                if(data.get(1).equals("Arman")){
//                    String month = data.get(5);
//                    String year = data.get(6);
//                    String billStatus = "Paid";
//                    
//                    
//                    Bill c = new Bill(month, year, billStatus);
//                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
//                    people.add(c);
//                }
//                                      
//            }
//           
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(GenerateCustomerListController.class.getName()).log(Level.SEVERE, null, ex);
//        }  
         

        return people;
    } 
    
}
