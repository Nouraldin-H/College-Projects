package handler3;

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

public class Handler3dTest extends Application {
	private Label label = new Label("Simple Label"); // needs to visible to mult. methods
	@Override
	public void start(Stage primaryStage) {
		Button b1 = new Button("Button1");
		b1.setOnAction(event -> b1_actions());
		Button b2 = new Button("Button2");
		b2.setOnAction(event -> b2_actions());
	
		HBox hb = new HBox(10,b1,b2);
		hb.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(hb);
		pane.setBottom(label);

		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Handler Test -lambda with methods"); 
		primaryStage.setScene(scene);
		primaryStage.show();

	}// start()
	
	private void b1_actions() {
		label.setText("Button1 CLICKED");
		label.setTextFill(Color.BLACK);
	}

	private void b2_actions() {
		label.setText("Someone clicked Button2");
		label.setTextFill(Color.FIREBRICK);
	}

	/**
	 * main() used by IDEs with limited support for JavaFX
	 */
	public static void main(String[] args) {
		launch(args);
	}// main()
}// class