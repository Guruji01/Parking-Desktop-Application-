/**
 * Sample Skeleton for 'ViewForm.fxml' Controller Class
 */

package Form4;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import Form4.Carcustbean;
import HoursEntry.My2DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewFormController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tableview"
    private TableView<Carcustbean> tableview; // Value injected by FXMLLoader

    @FXML // fx:id="Dos"
    private DatePicker Dos; // Value injected by FXMLLoader
    
    ResultSet table;
    ObservableList<Carcustbean> List;

    @FXML
    void doExcel(MouseEvent event)
    {

    }

    @FXML
    void doFindDos(ActionEvent event)
    {
    	try {	
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from monthpay where DOS =?");
            LocalDate ldobe=Dos.getValue();
    	    java.sql.Date swdob=java.sql.Date.valueOf(ldobe);
    	    pst.setDate(1, swdob);
            
            getAllRecordsFromTable(pst);
       } 
       catch (SQLException e) 
          {
           e.printStackTrace();
          }
    	tableview.setItems(List);
    }
    
    void getAllRecordsFromTable(PreparedStatement pst)
    {
        List=FXCollections.observableArrayList();
        
        try {       
             table= pst.executeQuery();
             
               while(table.next())
                {
        	      String nam = table.getString("Cust_Name");
        	      String doss = table.getString("DOS");
        	      String doee = table.getString("DOE");
        	      String type =table.getString("Type");
        	      String  dayss =table.getString("Days");
        	      String billl =table.getString("Bill");
            
        	      Carcustbean obj = new Carcustbean(nam,doss, doee, type, dayss, billl);
            List.add(obj);       
        }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }


    @FXML
    void doShowAll(ActionEvent event)
    {
    	try {
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from monthpay");
            
            getAllRecordsFromTable(pst);
       } 
       catch (SQLException e) 
    	{
          
           e.printStackTrace();
       }
        
       tableview.setItems(List);
    }  
    
    void addColumns()
    {
    	 TableColumn<Carcustbean, String> nams =new TableColumn<Carcustbean, String>("C_Name");
    	 nams.setCellValueFactory(new PropertyValueFactory<>("Cust_Name"));
         
         TableColumn<Carcustbean, String> doss=new TableColumn<Carcustbean, String>("Dos");
         doss.setCellValueFactory(new PropertyValueFactory<>("DOS"));
         
         TableColumn<Carcustbean, String> doee =new TableColumn<Carcustbean, String>("Doe");
         doee.setCellValueFactory(new PropertyValueFactory<>("DOE"));
         
         TableColumn<Carcustbean, String> typee=new TableColumn<Carcustbean, String>("Type");
         typee.setCellValueFactory(new PropertyValueFactory<>("Type"));
         
         TableColumn<Carcustbean, String> dayss=new TableColumn<Carcustbean, String>("Days");
         dayss.setCellValueFactory(new PropertyValueFactory<>("Days"));
         
         TableColumn<Carcustbean, String> bill =new TableColumn<Carcustbean, String>("Bill");
         bill.setCellValueFactory(new PropertyValueFactory<>("Bill"));
         
         tableview.getColumns().clear();
         tableview.getColumns().addAll(nams,doss,doee,typee,dayss,bill); 
    }

    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {

   	 con= My2DbConnection.doConnectCar();
   	 addColumns();

    }
}
