package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.*;


public class GameController implements Initializable {
		
		boolean start = false;
		
	    @FXML
	    private Circle circle;

	    @FXML
	    private AnchorPane scene;

	    @FXML
	    private Rectangle plat_p2;
	    
	    @FXML
	    private Rectangle plat_p1;

	    @FXML
	    private Text txt1;

	    @FXML
	    private Text txt2;
	    
	    
	    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

	    	double changeX = 3;
	    	double changeY = 4;
	    	int scorep1 = 0;
	    	int scorep2 = 0;
	    	
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub 
				Bounds b = scene.getBoundsInLocal();
				scene.setOnMouseClicked(e -> start = true);
				scene.setOnMouseMoved(e -> plat_p1.setLayoutY(e.getY()));
				plat_p2.setLayoutY(circle.getLayoutY()*0.8);
				
				

				if(!start) {
					circle.setLayoutX(b.getMaxX()/2);
					circle.setLayoutY(b.getMaxY()/2);
					return;
				}
				circle.setLayoutX(circle.getLayoutX() + changeX);
	            circle.setLayoutY(circle.getLayoutY() + changeY);
	            
	           
	            boolean BottomBorder = circle.getLayoutY() >= (b.getMaxY() - circle.getRadius());
	            boolean TopBorder = circle.getLayoutY() <= (b.getMinY() + circle.getRadius());

	            
	            if (BottomBorder || TopBorder) {
	                changeY *= -1;
	            }
	            
	            if(circle.getBoundsInParent().intersects(plat_p1.getBoundsInParent()) || circle.getBoundsInParent().intersects(plat_p2.getBoundsInParent())) {
	            	changeX *= -1;

	            }
	            
	            if(circle.getLayoutX() > plat_p2.getLayoutX()+ circle.getRadius()) {
	            	scorep1 += 1;
	            	txt1.setText(Integer.toString(scorep1));
	            	start = false;
	            }
	            if(circle.getLayoutX() < plat_p1.getLayoutX() - circle.getRadius()) {
	            	scorep2 += 1;
	            	txt2.setText(Integer.toString(scorep2));
	            	start = false;
	            	
	            }
	            if(scorep1 == 5 || scorep2 == 5) {
	            	DataHelper.Query.ExecuteNonQuery("INSERT INTO history VALUES(?, ?);", new Object[] { scorep1, scorep2});
	            	scorep1 = 0;
	            	scorep2 = 0;
	            	txt1.setText(Integer.toString(scorep1));
	            	txt2.setText(Integer.toString(scorep2));
	            }
	        }
	    }));
	    
	    
	    
	    
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		// TODO Auto-generated method stub
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

}
