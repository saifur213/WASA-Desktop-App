/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers;

import account.Bill;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import user.User;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DownloadMonthlyBillController implements Initializable {

    @FXML    private ComboBox<String> monthComboBox;
    @FXML    private ComboBox<String> yearComboBox;
    @FXML
    private TableView<Bill> tableVIew;
    @FXML
    private TableColumn<Bill, String> monthColumn;
    @FXML
    private TableColumn<Bill, String> yearColumn;
    @FXML
    private TableColumn<Bill, String> userNameColumn;
    @FXML
    private TableColumn<Bill, String> amountCOlumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //set up the columns in the table
        monthColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("month"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("year"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("username"));
        amountCOlumn.setCellValueFactory(new PropertyValueFactory<Bill,String>("amount"));
        
        monthComboBox.getItems().addAll("January","February","March","April","May");
        yearComboBox.getItems().addAll("2020","2021","2022","2023");
    }    

    @FXML
    private void showBillButtonOnClick(ActionEvent event) {
        
        String month = monthComboBox.getValue();
        String year = yearComboBox.getValue();
        
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
                    
                   if(data.get(5).equals(month) && data.get(6).equals(year)){
                    String m = data.get(5);
                    String y = data.get(6);
                    String u = data.get(2);
                    Float a = Float.parseFloat(data.get(7));
                    
                    
                    
                    Bill bl = new Bill(u, m, y, a);
                    //Customer c1 = new Customer(2020255, "Joy", "joydhd", "02833", LocalDate.of(1998, Month.AUGUST, 12),"Shaka");
                    people.add(b);
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
        

        tableVIew.setItems(people); 
        
    }

    @FXML
    private void downloadBillButtonOnClick(ActionEvent event) {
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               
                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                

                
                Text titleText = new Text("Montly Bill");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

                
                doc.add(pageTitle);
                doc.add(lineSpace);

                //----------------------------------------------------
                
                //adding table in pdf
                float colWidthArr[] = {70f, 200f, 100f};
                Table pdfTable = new Table(colWidthArr); 
                
                //adding header row
                Cell cell_00 = new Cell(); 
                cell_00.add("Year");
                cell_00.setBackgroundColor(Color.YELLOW);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Month"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("User Name"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Amount"));
                
                //adding content row
                pdfTable.addCell(new Cell().add(yearComboBox.getValue()));
                pdfTable.addCell(new Cell().add(monthComboBox.getValue()));
                pdfTable.addCell(new Cell().add("arman"));
                pdfTable.addCell(new Cell().add("500"));
                
      

                doc.add(pdfTable);
                
                doc.close();
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            //System.out.println("Something went wrong...");
            //System.out.println(e);
        }
    }
    
}
