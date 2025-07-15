import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Button2 extends Application {
  @Override 
  public void start(Stage primaryStage) {
	Button b1 = new Button("Button1");
	Button b2 = new Button("Button2");
	
    HBox hb = new HBox();

    hb.getChildren().add(b1);  
    hb.getChildren().add(b2);
    
    Scene scene = new Scene(hb, 200, 50);
    primaryStage.setTitle("Buttons in HBox"); // Set the stage title
    primaryStage.setScene(scene); 
    primaryStage.show();
    
  }//start()
  
  /**
   * main() used by IDEs with limited support for JavaFX
   */
  public static void main(String[] args) {
    launch(args);
  }//main()
}//class