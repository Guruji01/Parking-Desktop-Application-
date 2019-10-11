/**
 * Sample Skeleton for 'ViewLog.fxml' Controller Class
 */

package BillingLogs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ViewLogController {

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
    void dohourly(MouseEvent event)
    {
    	 playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("Form3/ViewForm.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();	 
			 
		/*	Scene scene1=(Scene)btnComboApp.getScene();
			   scene1.getWindow().hide();  */
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    @FXML
    void domonthly(MouseEvent event) 
    {
    	 playSound();
    	try{
    		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("Form4/ViewForm.fxml")); 
			Scene scene = new Scene(root);
			Stage stage=new Stage();
			stage.setScene(scene);
			stage.show();	 
			 
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
