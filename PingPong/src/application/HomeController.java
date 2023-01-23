package application;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class HomeController implements Initializable{
	
    @FXML
    private Button exit_button;

    @FXML
    private Button history_button;

    @FXML
    private Button play_button;

    @FXML
    private Label welcome_label;
    
    @FXML
    void Play(ActionEvent event) {
    	Utils.changeScene(event, "Game");
    }
    @FXML
    void history(ActionEvent event) {
    	Utils.changeScene(event, "History");
    }
   
    @FXML
    void exit(ActionEvent event) {
    	Utils.changeScene(event, "LoginRegister");
    }
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
