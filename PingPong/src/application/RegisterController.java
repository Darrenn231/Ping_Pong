package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterController implements Initializable{
	   @FXML
	    private TextField pass_text;

	   @FXML
	   private Button reg_button;

	   @FXML
	   private Label reg_label;
	   
	   @FXML
	   private TextField user_text;
	   
	   @FXML
	   void enterAction(ActionEvent event) {
		   String username = user_text.getText();
		   String password = pass_text.getText();
		   DataHelper.Query.ExecuteNonQuery("INSERT INTO usns VALUES(?, ?)", new Object[] { username, password });
		   Utils.changeScene(event, "LoginRegister");
	   }

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
