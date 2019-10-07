/**
 * Sample Skeleton for 'MonthView.fxml' Controller Class
 */

package MonthlyPay;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import CustEntry.my1DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MonthViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblList"
    private ListView<String> lblList; // Value injected by FXMLLoader

    @FXML // fx:id="Dos"
    private DatePicker Dos; // Value injected by FXMLLoader

    @FXML // fx:id="Doe"
    private DatePicker Doe; // Value injected by FXMLLoader

    @FXML // fx:id="lblGd"
    private TextField lblGd; // Value injected by FXMLLoader

    @FXML // fx:id="lblGb"
    private TextField lblGb; // Value injected by FXMLLoader

    @FXML // fx:id="lbl"
    private Label lbl; // Value injected by FXMLLoader
    

    @FXML // fx:id="lblType"
    private TextField lblType; // Value injected by FXMLLoader

    @FXML
    void DoSave(ActionEvent event) 
    {
    	try 
		{
			String name = lblList.getSelectionModel().getSelectedItem();
			
		    LocalDate ldos=	Dos.getValue();
		    java.sql.Date swdob= java.sql.Date.valueOf(ldos);
		    LocalDate ldoe=	Doe.getValue();
		    java.sql.Date swdoa= java.sql.Date.valueOf(ldoe);
		    
		    
		PreparedStatement pst=	con.prepareStatement("insert into MonthPay values(?,?,?,?,?,?)");
		
		pst.setString(1, name);
		pst.setDate(2, swdob);
		pst.setDate(3, swdoa);
		pst.setString(4,lblType.getText());
		pst.setInt(5, Integer.parseInt(lblGd.getText()));
		pst.setDouble(6, Double.parseDouble(lblGb.getText()));
		
		
		pst.executeUpdate();
		lbl.setText("Saved..");	
		} 
    																																																																																								
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		} 
    }    
    
    java.sql.Date Sd;
    java.sql.Date Ed;
  
    float totalb;
    int days;
    @FXML
    void doGetDays(ActionEvent event)
    {
    	try{
    		LocalDate Sd = Dos.getValue();
    		LocalDate Ed = Doe.getValue();
    		 days = (int)ChronoUnit.DAYS.between(Sd, Ed);
    		lblGd.setText(days+"");
    			
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    void doFetch() throws Exception
    {
    
         PreparedStatement pst=	con.prepareStatement("select cust_Name from carcustentry");
    	 ResultSet rs=pst.executeQuery();
    	
    	while(rs.next())
     	{
     		String names =rs.getString("cust_Name");
     		lblList.getItems().add(names);
     		
     	}
   }
    
    double bill;
    @FXML
    void doGenerateBill(ActionEvent event) throws SQLException 
    {
    	 String  cstname = lblList.getSelectionModel().getSelectedItem();
       
        try {
		
        	   PreparedStatement pst=	con.prepareStatement("select v_Type from carcustentry where cust_Name = ?");
          	 
			pst.setString(1, cstname);
			  ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String type = rs.getString("v_Type");
				
				 
				 switch(type)
				 {
				 case "Bike" :
				 {
					 bill = days*23.33;
					lblGb.setText(""+bill); 
				 }
				 break;
				 case "Car":
				 {
					 bill = days*40;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 case "Truck":
				 {
					 bill = days*66.66;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 case "Ship":
				 {
					 bill = days*83.33;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 case "Other":
				 {
					 bill = days*16;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 default:
				 {
					 lblGb.setText("00"); 
				 }
				 }
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    java.sql.Date dob;
    String cstname;

    @FXML
    void WhenClicked(MouseEvent event)
    {

    	 cstname = lblList.getSelectionModel().getSelectedItem();
    	
        if(event.getClickCount() == 2)
        	{
        		 try {
    				PreparedStatement pst=	con.prepareStatement("select dos,v_Type from carcustentry where cust_Name=?");
    				pst.setString(1, cstname);
    				ResultSet table=pst.executeQuery();
    				while(table.next())
    				{
    					dob=table.getDate("dos");
    					String ttyp = table.getString("v_Type");
    		     	//	Dos.getEditor().setText(dob.toString());
    					lbl.setText(""+dob);
    					lblType.setText(""+ttyp);
    				} 
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    
    } 
  } 
    

    Connection con;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws Exception
    {
    	con=My2DbConnection.doConnectCar();
    	doFetch();

    }
}
