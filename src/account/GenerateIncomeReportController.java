/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.DocumentProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.a;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;

/**
 * FXML Controller class
 *
 * @author User
 */
public class GenerateIncomeReportController implements Initializable {

    @FXML    private ComboBox<String> monthComboBox;
    @FXML    private ComboBox<String> yearComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        monthComboBox.getItems().addAll("January","February","March","April","May");
        yearComboBox.getItems().addAll("2020","2021","2022","2023");
    }    

    @FXML
    private void generateReportButtonOnClick(ActionEvent event) {
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
                
//                String paraText1 
//                        = "This is line 1 of the paragraph, and the line continue....\n"
//                        + "This is line 2 of the paragraph, and the line continue....\n"
//                        + "This is line 3 of the paragraph, and the line continue....\n"
//                        + "This is line 4 of the paragraph, and the line continue....\n";
//                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Income Report");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
//                Text title = new Text("Thinking in Java (4th Ed)").setFont(fontBold);
//                Text author = new Text("Bruce Eckel").setFont(font2);
//                author.setFontColor(Color.RED);
//                Paragraph bookInfo = new Paragraph().add(title).add(" -- by ").add(author);
                
                doc.add(pageTitle);
                doc.add(lineSpace);
//                doc.add(para1);
//                doc.add(lineSpace);
//                doc.add(bookInfo);
//                doc.add(lineSpace);
                
                //----------------------------------------------------
                
//                //adding a list
//                List progLangList = new List();
//                progLangList.add("C");
//                progLangList.add("C++");
//                progLangList.add("Java");
//                progLangList.add("Python");
//                progLangList.add("C#");          
//                doc.add(progLangList);
//                doc.add(lineSpace);
                
                //----------------------------------------------------
                //adding an image
//                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//                a.setContentText("Do you want to add an Image?");
//                Optional<ButtonType> result = a.showAndWait();
//                if(result.get() == ButtonType.OK){ 
//                    File imageFile = fc.showOpenDialog(null);
//                    String imagePath = imageFile.getAbsolutePath();
//                    ImageData data = ImageDataFactory.create(imagePath);
//                    Image image = new Image(data);  
//                    image.setAutoScale(true);
//                    
//                    doc.add(image);
//                    doc.add(lineSpace);
//                    a = new Alert(Alert.AlertType.INFORMATION);
//                    a.setContentText("The image is added successfully.");
//                    a.showAndWait();
//                }
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
                pdfTable.addCell(new Cell().setBackgroundColor(Color.YELLOW).add("Income"));
                
                //adding content row
                pdfTable.addCell(new Cell().add(yearComboBox.getValue()));
                pdfTable.addCell(new Cell().add(monthComboBox.getValue()));
                pdfTable.addCell(new Cell().add("50000"));
                
                //adding content row
                pdfTable.addCell(new Cell().add(yearComboBox.getValue()));
                pdfTable.addCell(new Cell().add(monthComboBox.getValue()));
                pdfTable.addCell(new Cell().add("80000"));
                
                //adding content row
                pdfTable.addCell(new Cell().add(yearComboBox.getValue()));
                pdfTable.addCell(new Cell().add(monthComboBox.getValue()));
                pdfTable.addCell(new Cell().add("45000"));

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

    @FXML
    private void cancelButtonOnClick(ActionEvent event) {
    }
    
}
