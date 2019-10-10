/**
 * Sample Skeleton for 'ViewForm2.fxml' Controller Class
 */

package Form2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Form1.customerbean;
import Form2.Cusbean;
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

public class ViewForm2Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="formTime"
    private TextField formTime; // Value injected by FXMLLoader

    @FXML // fx:id="tableview"
    private TableView<Cusbean> tableview; // Value injected by FXMLLoader
  
    ResultSet table;
    
    ObservableList<Cusbean> List;

    @FXML
    void doExcel(MouseEvent event) 
    {

    }
    
    void getAllRecordsFromTable(PreparedStatement pst)
    {
        List=FXCollections.observableArrayList();
        
        try {
             table= pst.executeQuery();
             
               while(table.next())
                {
            	   
        	      String nam = table.getString("cust_name");
        	      String gen = table.getString("gender");
        	      String phon = table.getString("phone");
        	      String adds =table.getString("address");
        	      String type =table.getString("v_type");
        	      String mname =table.getString("model_name");
        	      String mno =table.getString("model_no");
                  String doss =table.getString("dos");
                  String timee =table.getString("stime");
                  String ppath = table.getString("pathh");
            
                
                  
                  Cusbean obj = new Cusbean(nam,gen,phon,adds,type,mname,mno,doss,timee,ppath);
                  List.add(obj);  
        }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    @FXML
    void doFindDos(ActionEvent event)
    {
    	try {	
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from hoursentry where stime =?");
            String s1 = formTime.getText();
    	    pst.setString(1, s1);
            
            getAllRecordsFromTable(pst);
       } 
       catch (SQLException e) 
          {
           e.printStackTrace();
          }
    	tableview.setItems(List);
    }

    @FXML
    void doShowAll(ActionEvent event) 
    {
    	try {
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from hoursentry");
            
            getAllRecordsFromTable(pst);
       } 
       catch (SQLException e) 
    	{
          
           e.printStackTrace();
       }
        
       tableview.setItems(List);
    }
    
    String cust_name, gender;
	String phone, address ,v_type, model_name, model_no, dos,stime,pathh;
    
    
    void addColumns()
    {
    	 TableColumn<Cusbean, String> nams =new TableColumn<Cusbean, String>("C_Name");//Dikhava Title
    	 nams.setCellValueFactory(new PropertyValueFactory<>("cust_name"));//bean field name not table col. name
         
         TableColumn<Cusbean, String> gens=new TableColumn<Cusbean, String>("Gender");//Dikhava Title
         gens.setCellValueFactory(new PropertyValueFactory<>("gender"));
         
         TableColumn<Cusbean, String> phons =new TableColumn<Cusbean, String>("Phone");//Dikhava Title
         phons.setCellValueFactory(new PropertyValueFactory<>("phone"));
         
         TableColumn<Cusbean, String> addss=new TableColumn<Cusbean, String>("Address");//Dikhava Title
         addss.setCellValueFactory(new PropertyValueFactory<>("address"));
         
         TableColumn<Cusbean, String> types=new TableColumn<Cusbean, String>("V_Type");//Dikhava Title
         types.setCellValueFactory(new PropertyValueFactory<>("v_type"));
         
         TableColumn<Cusbean, String> mnames=new TableColumn<Cusbean, String>("Model_Name");//Dikhava Title
         mnames.setCellValueFactory(new PropertyValueFactory<>("model_name"));
         
         TableColumn<Cusbean, String> mnos =new TableColumn<Cusbean, String>("Model_No");//Dikhava Title
         mnos.setCellValueFactory(new PropertyValueFactory<>("model_no"));
         
         TableColumn<Cusbean, String> dosss =new TableColumn<Cusbean, String>("Dos");//Dikhava Title
         dosss.setCellValueFactory(new PropertyValueFactory<>("dos"));
         
         TableColumn<Cusbean, String> timee =new TableColumn<Cusbean, String>("S_Time");//Dikhava Title
         timee.setCellValueFactory(new PropertyValueFactory<>("stime"));
         
         TableColumn<Cusbean, String> ppaths =new TableColumn<Cusbean, String>("PicPath");//Dikhava Title
         ppaths.setCellValueFactory(new PropertyValueFactory<>("pathh"));
         
         tableview.getColumns().clear();
       tableview.getColumns().addAll(nams,gens,phons,addss,types,mnames,mnos,dosss,timee,ppaths); 
         
    }
    
    

    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
    	 con= My2DbConnection.doConnectCar();
    	 addColumns();

    }
}


/*@FXML
void doFindDos(ActionEvent event)
{
	try {	
        PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from hoursentry where stime =?");
        String s1 = formTime.getText();
	    pst.setString(1, s1);
        
        getAllRecordsFromTable(pst);
   } 
   catch (SQLException e) 
      {
       e.printStackTrace();
      }
	tableview.setItems(list);
} */


