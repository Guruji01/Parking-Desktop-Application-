


/*/**
 * Sample Skeleton for 'ViewForm.fxml' Controller Class
 */

package Form3;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import HoursEntry.My2DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewFormController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tableview"
    private TableView<Custbean> tableview; // Value injected by FXMLLoader

    @FXML // fx:id="formTime1"
    private TextField formTime1; // Value injected by FXMLLoader
    
        ResultSet table;
    ObservableList<Custbean> List;

    @FXML
    void doExcel(MouseEvent event)
     {

    }

    @FXML
    void doFindDos(ActionEvent event)
     {
       try {	
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from hourpay where Check_In=?");

            String s1 = formTime1.getText();
    	    pst.setString(1, s1);
    	  
    	    pst.setString(1, s1);
            
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
        	      String doss = table.getString("Dos");
        	      String Cin = table.getString("Check_In");
        	      String Cout =table.getString("Check_Out");
        	      String hour =table.getString("Hours");
        	      String typee =table.getString("Type");
        	      String billl =table.getString("Bill");
              
        	      Custbean obj = new Custbean(nam,doss, Cin, Cout, hour, typee, billl);
            
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
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from hourpay");
            
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
    	 TableColumn<Custbean, String> nams =new TableColumn<Custbean, String>("C_Name");//Dikhava Title
    	 nams.setCellValueFactory(new PropertyValueFactory<>("Cust_Name"));//bean field name not table col. name
         
         TableColumn<Custbean, String> doss=new TableColumn<Custbean, String>("Dos");//Dikhava Title
         doss.setCellValueFactory(new PropertyValueFactory<>("Dos"));
         
         TableColumn<Custbean, String> Cinn =new TableColumn<Custbean, String>("Check_In");//Dikhava Title
         Cinn.setCellValueFactory(new PropertyValueFactory<>("Check_In"));
         
         TableColumn<Custbean, String> Coutt=new TableColumn<Custbean, String>("Check_Out");//Dikhava Title
         Coutt.setCellValueFactory(new PropertyValueFactory<>("Check_Out"));
         
         TableColumn<Custbean, String> hourss=new TableColumn<Custbean, String>("Hours");//Dikhava Title
         hourss.setCellValueFactory(new PropertyValueFactory<>("Hours"));
         
         TableColumn<Custbean, String> typee=new TableColumn<Custbean, String>("V_Type");//Dikhava Title
         typee.setCellValueFactory(new PropertyValueFactory<>("Type"));
         
         TableColumn<Custbean, String> bills =new TableColumn<Custbean, String>("Bill");//Dikhava Title
         bills.setCellValueFactory(new PropertyValueFactory<>("Bill"));
         
    
         
         tableview.getColumns().clear();
         tableview.getColumns().addAll(nams,doss,Cinn,Coutt,hourss,typee,bills); 
         
    }
    
       Connection con;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
      	con= My2DbConnection.doConnectCar();
   	    addColumns();    
    }
}

