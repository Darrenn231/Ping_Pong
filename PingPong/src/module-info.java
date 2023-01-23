module PingPong {
	requires javafx.controls;
	requires java.desktop;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
