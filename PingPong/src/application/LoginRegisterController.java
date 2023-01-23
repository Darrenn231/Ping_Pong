package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginRegisterController implements Initializable {
	 	@FXML
	    private PasswordField password_text;

	    @FXML
	    private Button login_button;

	    @FXML
	    private Button register_button;

	    @FXML 
	    private TextField username_text;
	    @FXML
	    void handleAction(ActionEvent event) {
	    	String username  = username_text.getText();
	    	String password = password_text.getText();
	    	String checkuser = DataHelper.Query.ReturnAsString("SELECT username FROM usns WHERE username = ? AND pass = ?;", new Object[] { username, password});
	    	
	    	if(checkuser.equals(username)) {
	    		Utils.changeScene(event, "Home");
	    	}
	
	    }
	    

	    @FXML
	    void register(ActionEvent event) {
	    	Utils.changeScene(event, "Register");
	    }


		@Override
		public void initialize(URL url, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			
		}
		
}
