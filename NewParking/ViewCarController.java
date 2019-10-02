/**
 * Sample Skeleton for 'ViewCar.fxml' Controller Class
 */

package NewParking;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ViewCarController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    URL url;
   	AudioClip audio;
    void playSound()
    {
    	url=getClass().getResource("Gun.mp3");
		audio=new AudioClip(url.toString());
		audio.play();
    }

    @FXML
    void BillList(MouseEvent event)
    {
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("BillingLogs/ViewLog.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    @FXML
    void RoutintList(MouseEvent event) 
    {
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("Form1/ViewForm.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void hourlList(MouseEvent event) 
    {
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("Form2/ViewForm2.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void Charges(MouseEvent event)
    {
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("ShowChargess/ViewCharges.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void Paymentsssss(MouseEvent event)
    { 
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("Payments/ViewPayments.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
    
    @FXML
    
    void Entryyy(MouseEvent event)
    {
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("CustEntry/View1.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    
    }
    

    
    @FXML
    void HoursCall(MouseEvent event)
    {
    	playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("HoursEntry/HoursView.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();
			//to hide the opened window
			 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}
