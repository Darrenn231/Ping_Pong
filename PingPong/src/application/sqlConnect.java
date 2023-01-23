package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class sqlConnect {
	Connection con = null;
	
	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userpingpong?useSSL=false&autoReconnect=true&user=pingponguser&password=password");
			return con;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
	
	public static ObservableList<Score> getData(){
		Connection con = ConnectDb();
		ObservableList<Score> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM history");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Score(Integer.parseInt(rs.getString("ScoreP1")), Integer.parseInt(rs.getString("ScoreP2"))));
			}
		}
		catch(Exception e) {
			
		}
		return list;
	}
}
