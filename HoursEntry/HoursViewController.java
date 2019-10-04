/**
 * Sample Skeleton for 'HoursView.fxml' Controller Class
 */

package HoursEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import CustEntry.my1DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class HoursViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ModelName"
    private TextField ModelName; // Value injected by FXMLLoader

    @FXML // fx:id="ModelNo"
    private TextField ModelNo; // Value injected by FXMLLoader

    @FXML // fx:id="Dos"
    private DatePicker Dos; // Value injected by FXMLLoader

    @FXML // fx:id="idPathh"
    private ImageView idPathh; // Value injected by FXMLLoader

    @FXML // fx:id="custName"
    private ComboBox<String> custName; // Value injected by FXMLLoader

    @FXML // fx:id="Phone"
    private TextField Phone; // Value injected by FXMLLoader

    @FXML // fx:id="lbl"
    private Label lbl; // Value injected by FXMLLoader

    @FXML // fx:id="Gender"
    private TextField Gender; // Value injected by FXMLLoader

    @FXML // fx:id="Type"
    private TextField Type; // Value injected by FXMLLoader

    @FXML // fx:id="Stime"
    private TextField Stime; // Value injected by FXMLLoader

    @FXML // fx:id="Address"
    private TextArea Address; // Value injected by FXMLLoader
    
    PreparedStatement pst;  
    String ppath;

    @FXML
    void doBrowse(ActionEvent event) throws FileNotFoundException
    {
    	    FileChooser fc = new FileChooser();
        //	fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files","*.pdf"));
        	fc.getExtensionFilters().addAll(new ExtensionFilter("pc image","*.jpg"));
        	File sf = fc.showOpenDialog(null);
        	if(sf!=null)
        	{
        		Image img = new Image(new FileInputStream(sf));
        		idPathh.setImage(img);	
        	}
        	else
        	{
        		System.out.println("file not found");
        	}
        	 ppath = sf.getAbsolutePath();
        	 lbl.setText(sf.getAbsolutePath());
    }

    @FXML
    void doDelete(ActionEvent event) throws SQLException 
    {
    	 String name = custName.getSelectionModel().getSelectedItem();
 		
 		PreparedStatement pst=	con.prepareStatement("delete from hoursentry where cust_name=?");
 		pst.setString(1, name);
 		int count=pst.executeUpdate();
 		lbl.setText(count+" Records Deleted");
    }

    @FXML
    void doFetch(ActionEvent event)
    {
    	lbl.setText("");
   	 
    	try {
    		String name = custName.getSelectionModel().getSelectedItem();
    		
			PreparedStatement pst=con.prepareStatement("select * from hoursentry where cust_name=?");
			pst.setString(1, name);
			ResultSet table=pst.executeQuery();
		
		boolean jasus=false;
		while(table.next())
		{
			jasus=true;
			
			String name1=table.getString("gender");
			
			String per2=table.getString("phone");
			String per3=table.getString("address");
			String per4=table.getString("v_type");
			String per5=table.getString("model_name");
			String per6 = table.getString("model_no");
			String per7=table.getString("pathh");
			String per8 = table.getString("stime");
			
			java.sql.Date dob=table.getDate("dos");
			java.sql.Time ttime = table.getTime("stime");
			
			
			Gender.setText(name1);
			
			Phone.setText(per2+"");
			Address.setText(per3+"");
			Type.setText(per4+"");
			ModelName.setText(per5+"");
			ModelNo.setText(per6+"");
			
			Stime.setText(per8+"");
			
			Dos.getEditor().setText(dob.toString());		
		}
		
		if(jasus==false)
			lbl.setText("Invalid Name");
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    }

    private Labeled getTime() {
		// TODO Auto-generated method stub
		return null;
    }

    @FXML
    void doNew(ActionEvent event)
    {
    	Gender.clear();
    	Phone.clear();
    	Type.clear();
    	ModelName.clear();
    	ModelNo.clear();
    	lbl.setText("");
        Address.setText("");
    }

    @FXML
    void doSave(ActionEvent event)
    {
    	try 
		{
			String name = custName.getSelectionModel().getSelectedItem();	
		    LocalDate ldos=	Dos.getValue();
		    java.sql.Date swdob= java.sql.Date.valueOf(ldos);
		
		PreparedStatement pst=	con.prepareStatement("insert into hoursentry values(?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1, name);
		pst.setString(2, Gender.getText());
		pst.setString(3, Phone.getText());
		pst.setString(4,  Address.getText());
		pst.setString(5,  Type.getText());
		pst.setString(6,  ModelName.getText());
		pst.setString(7,  ModelNo.getText());
		pst.setDate(8, swdob);
		pst.setString(9, Stime.getText());
		pst.setString(10,  lbl.getText());
		
		pst.executeUpdate();
		lbl.setText("Saved..");	
		} 
    																																																																																								
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		} 
    }

    @FXML
    void doUpdate(ActionEvent event)
    {
    	try 
		{
    		String name = custName.getSelectionModel().getSelectedItem();
			String name1 = Gender.getText();
			String name2 = Phone.getText();  
			String name3 = Address.getText();
			String name4 = Type.getText();
			String name5 = ModelName.getText();
			String name6 = ModelNo.getText();
			String name9 = lbl.getText();  
			String name8  = Stime.getText();
			
				
		java.sql.Date swdob=null;
		String stwdob="";
		
		LocalDate lwdob=Dos.getValue();
		if(lwdob==null)
			{
				stwdob=Dos.getEditor().getText();
				lwdob=LocalDate.parse(stwdob);
			}
			swdob= java.sql.Date.valueOf(lwdob);
			
			//                                                 tableName	
		PreparedStatement pst=	con.prepareStatement("update hoursentry set gender=?, phone=?, address=?, v_type=?, model_name=?, model_no=?, dos=?, stime=?, pathh=?  where cust_name=?");
		pst.setString(10, name); 
		pst.setString(1, name1);
		pst.setString(2, name2);
		pst.setString(3, name3);
		pst.setString(4, name4);
		pst.setString(5, name5);
		pst.setString(6, name6);
		pst.setDate(7, swdob);
		pst.setString(8, name8);
		pst.setString(9, name9);
	
		
		
		pst.executeUpdate();//fire query in table
		lbl.setText("Update..");
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//in parameters
    }

    Connection con;
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize()
    {
    	con=my1DbConnection.doConnectCar();
    }
}
