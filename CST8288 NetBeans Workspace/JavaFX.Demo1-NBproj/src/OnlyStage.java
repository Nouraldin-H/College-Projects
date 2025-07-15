import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OnlyStage extends Application {
  @Override 
  public void start(Stage primaryStage) {		// simple, but not useful.
    primaryStage.show(); 						// Display the stage
  }//start()
  
  /**
   * main() used by IDEs with limited support for JavaFX
   */
  public static void main(String[] args) {
    launch(args);
  }//main()
}//class