/**
 * Sample Skeleton for 'ViewLogin.fxml' Controller Class
 */

package ParkingLogin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class ViewLoginController
{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ScName"
    private TextField ScName; // Value injected by FXMLLoader

    @FXML // fx:id="lbl"
    private Label lbl; // Value injected by FXMLLoader

    @FXML // fx:id="PassCode"
    private PasswordField PassCode; // Value injected by FXMLLoader
    
    URL url;
   	AudioClip audio;
    void playSound()
    {
    	url=getClass().getResource("Gun.mp3");
		audio=new AudioClip(url.toString());
		audio.play();
    }

    @FXML
    void Roarr(MouseEvent event)
    {
    	if(ScName.getText().equals("Dream"))
    	{
    		if(PassCode.getText().equals("Gems"))
    		{
    			playSound();
    			try{
    				lbl.setText("");
             		Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("NewParking/ViewCar.fxml")); 
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
    		else
    		{
    			lbl.setText("Invalid PassCode....");
    		}
    	}

    	else
    	 {
    			lbl.setText("Invalid Screen Name...");
    	 }

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize()
    {
        
    }
}









