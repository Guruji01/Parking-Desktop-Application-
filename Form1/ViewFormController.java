/**
 * Sample Skeleton for 'ViewForm.fxml' Controller Class
 */

package Form1;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

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



public class ViewFormController 
{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="formDos"
    private DatePicker formDos; // Value injected by FXMLLoader

    @FXML // fx:id="tableview"
    private TableView<customerbean> tableview; // Value injected by FXMLLoader
    
    ResultSet table;
    ObservableList<customerbean> List;

    @FXML
    void doExcel(MouseEvent event)
    {
    	
    }

    @FXML
    void doFindDos(ActionEvent event) 
    {
       try {	
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from carcustentry where dos=?");
            LocalDate ldobe=formDos.getValue();
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
        	      String nam = table.getString("cust_Name");
        	      String gen = table.getString("gender");
        	      String phon = table.getString("phone");
        	      String adds =table.getString("address");
        	      String type =table.getString("v_Type");
        	      String mname =table.getString("model_Name");
        	      String mno =table.getString("model_No");
                  String doss =table.getString("dos");
                  String ppath = table.getString("pathh");
            
           
            customerbean obj = new customerbean(nam,gen, phon, adds, type, mname, mno, doss, ppath);
            
                        
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
            PreparedStatement  pst=(PreparedStatement) con.prepareStatement("select * from carcustentry");
            
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
    	 TableColumn<customerbean, String> nams =new TableColumn<customerbean, String>("C_Name");//Dikhava Title
    	 nams.setCellValueFactory(new PropertyValueFactory<>("cust_Name"));//bean field name not table col. name
         
         TableColumn<customerbean, String> gens=new TableColumn<customerbean, String>("Gender");//Dikhava Title
         gens.setCellValueFactory(new PropertyValueFactory<>("gender"));
         
         TableColumn<customerbean, String> phons =new TableColumn<customerbean, String>("Phone");//Dikhava Title
         phons.setCellValueFactory(new PropertyValueFactory<>("phone"));
         
         TableColumn<customerbean, String> addss=new TableColumn<customerbean, String>("Address");//Dikhava Title
         addss.setCellValueFactory(new PropertyValueFactory<>("address"));
         
         TableColumn<customerbean, String> types=new TableColumn<customerbean, String>("V_Type");//Dikhava Title
         types.setCellValueFactory(new PropertyValueFactory<>("v_Type"));
         
         TableColumn<customerbean, String> mnames=new TableColumn<customerbean, String>("Model_Name");//Dikhava Title
         mnames.setCellValueFactory(new PropertyValueFactory<>("model_Name"));
         
         TableColumn<customerbean, String> mnos =new TableColumn<customerbean, String>("Model_No");//Dikhava Title
         mnos.setCellValueFactory(new PropertyValueFactory<>("model_No"));
         
         TableColumn<customerbean, String> dosss =new TableColumn<customerbean, String>("Dos");//Dikhava Title
         dosss.setCellValueFactory(new PropertyValueFactory<>("dos"));
         
         TableColumn<customerbean, String> ppaths =new TableColumn<customerbean, String>("PicPath");//Dikhava Title
         ppaths.setCellValueFactory(new PropertyValueFactory<>("pathh"));
         
         tableview.getColumns().clear();
         tableview.getColumns().addAll(nams,gens,phons,addss,types,mnames,mnos,dosss,ppaths); 
         
    }
    
    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
     
    	 con= My2DbConnection.doConnectCar();
    	 addColumns();
    }
}

