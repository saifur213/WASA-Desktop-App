
package admin;

import employee.Employee;
import employee.EventRegistration;
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


public class ViewFeedbackController implements Initializable {

    @FXML    private TableView<EventRegistration> tableView;
    @FXML    private TableColumn<EventRegistration, String> idColumn;
    @FXML    private TableColumn<EventRegistration, String> fullNameColumn;
    @FXML    private TableColumn<EventRegistration, String> emailColumn;
    @FXML    private TableColumn<EventRegistration, String> mobileColumn;
    @FXML    private TableColumn<EventRegistration, String> eventIdColumn;
    @FXML    private TableColumn<EventRegistration, String> feedbackColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        idColumn.setCellValueFactory(new PropertyValueFactory<EventRegistration,String>("id"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<EventRegistration,String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<EventRegistration,String>("email"));
        mobileColumn.setCellValueFactory(new PropertyValueFactory<EventRegistration,String>("mobile"));
        eventIdColumn.setCellValueFactory(new PropertyValueFactory<EventRegistration,String>("eventId"));
        feedbackColumn.setCellValueFactory(new PropertyValueFactory<EventRegistration,String>("feedback"));
        
        
        tableView.setItems(getFeedback()); 
    }    
    
    public ObservableList<EventRegistration> getFeedback(){
        ObservableList<EventRegistration> people = FXCollections.observableArrayList();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("file/Events-Feedback.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            EventRegistration er;
            try{
                //outputTextArea.setText("");
                while(true){
                    //System.out.println("Printing objects.");
                    er = (EventRegistration)ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    //emp.submitReport();
                    System.out.println(er.toString());
                    //outputTextArea.appendText(emp.toString());
                    List<String> data = Arrays.asList(er.toString().split(","));
                    
                    String id = data.get(0);
                    String fullName = data.get(1);
                    String mobile = data.get(2);
                    String email = data.get(3);
                    String eventId = data.get(4);
                    String eventName = data.get(5);
                    String eventFeedback = data.get(6);


                    EventRegistration e = new EventRegistration(id, fullName, mobile, email, eventId, eventName, eventFeedback);
                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
                    people.add(e);
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
//        File file = new File("file/Events-Feedback.txt");
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
//                
//                String id = data.get(0);
//                String fullName = data.get(1);
//                String mobile = data.get(2);
//                String email = data.get(3);
//                String eventId = data.get(4);
//                String eventName = data.get(5);
//                String eventFeedback = data.get(6);
//               
//                            
//                EventRegistration e = new EventRegistration(id, fullName, mobile, email, eventId, eventName, eventFeedback);
//                //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
//                people.add(e);
//                
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
