/**
 * Sample Skeleton for 'ViewPayments.fxml' Controller Class
 */

package Payments;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ViewPaymentsController {

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
    void HPayments(MouseEvent event)
    {
    	 playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("HourPay/HourView.fxml")); 
    		Scene scene = new Scene(root);
    		Stage stage=new Stage();
    		stage.setScene(scene);
    		stage.show();
    	   }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	} 
    }

    @FXML
    void MPayments(MouseEvent event)
    {
    	 playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("MonthlyPay/MonthView.fxml")); 
    		Scene scene = new Scene(root);
    		Stage stage=new Stage();
    		stage.setScene(scene);
    		stage.show();
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







