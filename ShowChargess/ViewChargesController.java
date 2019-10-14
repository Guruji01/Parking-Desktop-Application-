/**
 * Sample Skeleton for 'ViewCharges.fxml' Controller Class
 */

package ShowChargess;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ViewChargesController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    
    URL url;
   	Media media;
   	MediaPlayer mediaplayer;
   	AudioClip audio;
   	
    void playSong()
    {
    	url=getClass().getResource("Galliyan.mp3");
		media=new Media(url.toString());
		mediaplayer=new MediaPlayer(media);
		mediaplayer.play();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() 
    {
     	playSong();
    	mediaplayer.setAutoPlay(true);
    }
}
