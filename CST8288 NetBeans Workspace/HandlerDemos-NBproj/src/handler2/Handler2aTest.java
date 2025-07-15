package handler2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Handler2aTest extends Application implements EventHandler<ActionEvent> {
	private Label label = new Label("Simple Label"); // need to make it visible to mult. methods

	@Override
	public void start(Stage primaryStage) {
		Button b1 = new Button("Button1");
		b1.setOnAction(this);

		BorderPane pane = new BorderPane();
		pane.setCenter(b1);
		pane.setBottom(label);

		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Handler Test - Method in class"); 
		primaryStage.setScene(scene);
		primaryStage.show();

	}// start()

	@Override
	public void handle(ActionEvent event) { //OK but what about mult. handlers
		label.setText("Button1 CLICKED");
	}// handle()

	/**
	 * main() used by IDEs with limited support for JavaFX
	 */
	public static void main(String[] args) {
		launch(args);
	}// main()
}// class