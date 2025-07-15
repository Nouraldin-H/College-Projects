package handler2;

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

public class Handler2cTest extends Application implements EventHandler<ActionEvent> {
	private Label label = new Label("Simple Label"); // need to make it visible to mult. methods
	private Button b1;
	private Button b2;
	@Override
	public void start(Stage primaryStage) {
		b1 = new Button("Button1");
		b1.setOnAction(this);
		b2 = new Button("Button2");
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
		if (event.getSource() == b1) {
			label.setText("Button1 CLICKED");
			label.setTextFill(Color.BLACK);
		} else if (event.getSource() == b2) {
			label.setText("Someone clicked Button2");
			label.setTextFill(Color.FIREBRICK);
		} else {
			System.err.println("unknown event");
		}
	}// handle()

	/**
	 * main() used by IDEs with limited support for JavaFX
	 */
	public static void main(String[] args) {
		launch(args);
	}// main()
}// class