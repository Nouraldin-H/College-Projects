package handler2;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Handler2bTest extends Application implements EventHandler<ActionEvent> {
	private Label label = new Label("Simple Label"); // need to make it visible to mult. methods

	@Override
	public void start(Stage primaryStage) {
		Button b1 = new Button("Button1");
		b1.setOnAction(this);
		Button b2 = new Button("Button2");
		b2.setOnAction(this);

		HBox hb = new HBox(10);			//set gap 
		hb.getChildren().addAll(b1,b2);
// 		or could replace the 2 lines above with:	
//		HBox hb = new HBox(10,b1,b2);
		
		hb.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(hb);
		pane.setBottom(label);

		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Handler Test - Method in class"); 
		primaryStage.setScene(scene);
		primaryStage.show();

	}// start()

	@Override
	public void handle(ActionEvent event) { //OK but what about complicated handlers
		String buttonText = ((Button)event.getSource()).getText();
		switch (buttonText) {
		case "Button1":	label.setText("Button1 CLICKED");
						label.setTextFill(Color.BLACK);
						break;
		case "Button2":	label.setText("Someone clicked Button2");
						label.setTextFill(Color.FIREBRICK);
						break;
		}
		// or could if/else with event.getSource() ==b1 or ==b2
		// but only if b1 & b2 is visible outside of start() method
	}// handle()

	/**
	 * main() used by IDEs with limited support for JavaFX
	 */
	public static void main(String[] args) {
		launch(args);
	}// main()
}// class