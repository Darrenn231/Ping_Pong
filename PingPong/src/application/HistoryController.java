package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoryController implements Initializable {

	
    @FXML
    private Button return_button;
 
    @FXML
    private TableColumn<Score, Integer> scoreP1;

    @FXML
    private TableColumn<Score, Integer> scoreP2;

    @FXML
    private TableView<Score> table_his;
    
    ObservableList<Score> listScore;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;


	@FXML
	void returnHome(ActionEvent event) throws IOException {
		Utils.changeScene(event, "Home");
	}
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		// TODO Auto-generated method stub
		scoreP1.setCellValueFactory(new PropertyValueFactory<Score, Integer>("ScoreP1"));
		scoreP2.setCellValueFactory(new PropertyValueFactory<Score, Integer>("ScoreP2"));
		
		listScore = sqlConnect.getData();
		table_his.setItems(listScore);
	}
	
	
	
	
}
