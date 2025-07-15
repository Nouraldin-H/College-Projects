import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Button1 extends Application {
  @Override 
  public void start(Stage primaryStage) {

	Button b1 = new Button("Button1");
//    Scene scene = new Scene(b1);
 
    // Button is the only Node in the Scene
    // So the Button will resize to fill the scene when scene is resized. Try:
     Scene scene = new Scene(new Button("Button1"), 2, 50); 

    primaryStage.setScene(scene); 					// Place the scene in the stage
    primaryStage.show(); 							// Display the stage
  }//start()
  
  /**
   * main() used by IDEs with limited support for JavaFX
   */
  public static void main(String[] args) {
    launch(args);
  }//main()
}//class