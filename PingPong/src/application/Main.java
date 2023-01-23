package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("LoginRegister.fxml"));
		
		Scene scene = new Scene(root);
		stage.setTitle("Login/Register");
		stage.setScene(scene);
		stage.show();
		
	}
	

}