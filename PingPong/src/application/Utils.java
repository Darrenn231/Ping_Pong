package application;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Utils {
	public static void changeScene(ActionEvent event, String fxml) {
		try {
			
			
			FXMLLoader loader = new FXMLLoader(Utils.class.getResource(fxml+".fxml"));
			Parent root = (Parent) loader.load();
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setTitle(fxml);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
