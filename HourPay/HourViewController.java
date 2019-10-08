/**
 * Sample Skeleton for 'HourView.fxml' Controller Class
 */

package HourPay;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;


import MonthlyPay.My2DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HourViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="lblList"
    private ListView<String> lblList; // Value injected by FXMLLoader

    @FXML // fx:id="lblGH"
    private TextField lblGH; // Value injected by FXMLLoader

    @FXML // fx:id="lblGb"
    private TextField lblGb; // Value injected by FXMLLoader

    @FXML // fx:id="lblType"
    private TextField lblType; // Value injected by FXMLLoader

    @FXML // fx:id="lblcI"
    private TextField lblcI; // Value injected by FXMLLoader

    @FXML // fx:id="lblcO"
    private TextField lblcO; // Value injected by FXMLLoader

    @FXML // fx:id="DOS"
    private DatePicker DOS; // Value injected by FXMLLoader

    @FXML // fx:id="lbl"
    private Label lbl; // Value injected by FXMLLoader

    @FXML
    void DoSave(ActionEvent event)
    {
    	try 
		{
			String name = lblList.getSelectionModel().getSelectedItem();
			

		    LocalDate ldos=	DOS.getValue();
		    java.sql.Date swdob= java.sql.Date.valueOf(ldos);
		
		PreparedStatement pst=	con.prepareStatement("insert into HourPay values(?,?,?,?,?,?,?)");
		
		pst.setString(1, name);
		pst.setDate(2, swdob);
		pst.setString(3, lblcI.getText());
		pst.setString(4, lblcO.getText());
		pst.setString(5,lblGH.getText());
		pst.setString(6,lblType.getText());
		pst.setDouble(7, Double.parseDouble(lblGb.getText()));
		
		
		pst.executeUpdate();
		lbl.setText("Saved..");	
		} 
    																																																																																								
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		} 
    }

    double bill;
    @FXML
    void doGenerateBill(ActionEvent event) 
    {
    	String  cstname = lblList.getSelectionModel().getSelectedItem();
        
        try {
		
        	   PreparedStatement pst=	con.prepareStatement("select v_Type from hoursentry where cust_name = ?");
          	 
			pst.setString(1, cstname);
			  ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String type = rs.getString("v_Type");
				
				 
				 switch(type)
				 {
				 case "Bike" :
				 {
					 bill = HOURS*6;
					lblGb.setText(""+bill); 
				 }
				 break;
				 case "Car":
				 {
					 bill = HOURS*9;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 case "Truck":
				 {
					 bill = HOURS*12;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 case "Ship":
				 {
					 bill = HOURS*15;
					 lblGb.setText(""+bill);  
				 }
				 break;
				 case "Other":
				 {
					 bill = HOURS*4;
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

    java.sql.Date Sd;
    java.sql.Date Ed;
    float HOURS ;
    @FXML
    void doGetHours(ActionEvent event) 
    {
    	try
    	{
               String time1 = lblcI.getText();
               String time2 = lblcO.getText();

              SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
              java.util.Date date1 =  format.parse(time1);
              java.util.Date date2 =  format.parse(time2);
              long difference = date2.getTime() - date1.getTime(); 
              HOURS = ((((difference/10000)/3)/2)/60);
              lblGH.setText(""+HOURS);
    			
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    java.sql.Date dob;
    String cstname;
    
    @FXML 
    void onMouseClicked(MouseEvent event)
    {
    	 cstname = lblList.getSelectionModel().getSelectedItem();
     	
         if(event.getClickCount() == 2)
         	{
         		 try {
         			 PreparedStatement pst=	con.prepareStatement("select stime,dos,v_type from hoursentry where cust_name=?");
     				pst.setString(1, cstname);
     				ResultSet table=pst.executeQuery();
     				while(table.next())
     				{
     					dob=table.getDate("dos");
     					String ttyp = table.getString("v_Type");
     		     	//	Dos.getEditor().setText(dob.toString());
     					DOS.setPromptText(""+dob);
     					lblType.setText(""+ttyp);
     					
     					String ttime=table.getString("stime");
     					lblcI.setText(""+ttime);
     				} 
     				
     			} catch (SQLException e) {
     				// TODO Auto-generated catch block
     				e.printStackTrace();
     			}
     
     } 
    }
    
    void doFetch() throws Exception
    {
    
         PreparedStatement pst=	con.prepareStatement("select cust_name from hoursentry");
    	 ResultSet rs=pst.executeQuery();
    	
    	while(rs.next())
     	{
     		String names =rs.getString("cust_Name");
     		lblList.getItems().add(names);
     		
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
