package handler1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Handler1Test extends Application {
  @Override 
  public void start(Stage primaryStage) {
	Button b1 = new Button("Button1");
	b1.setOnAction(new SeparateHandler());
	
    HBox hb = new HBox();
    hb.getChildren().add(b1);  
    
    Scene scene = new Scene(hb, 200, 50);
    primaryStage.setTitle("Handler Test - Separate Handler"); // Set the stage title
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