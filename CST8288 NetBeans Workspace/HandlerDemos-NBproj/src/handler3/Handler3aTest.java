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

public class Handler3aTest extends Application {
	private Label label = new Label("Simple Label"); // needs to visible to mult. methods
	@Override
	public void start(Stage primaryStage) {

		Button b1 = new Button("Button1");
		b1.setOnAction(new Handleb1());
		Button b2 = new Button("Button2");
		b2.setOnAction(new Handleb2());

		HBox hb = new HBox(10);			//set gap 
		hb.getChildren().addAll(b1,b2);
// 		or could replace the 2 lines above with:	
//		HBox hb = new HBox(10,b1,b2);
		
		hb.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(hb);
		pane.setBottom(label);

		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Handler Test -Named inner class"); 
		primaryStage.setScene(scene);
		primaryStage.show();

	}// start()
	
	private class Handleb1 implements EventHandler <ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			label.setText("Button1 CLICKED");
			label.setTextFill(Color.BLACK);
		}//handle()
	}//Handle-b1

	private class Handleb2 implements EventHandler <ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			label.setText("Someone clicked Button2");
			label.setTextFill(Color.FIREBRICK);
		}//handle()
	}//Handle-b2

	/**
	 * main() used by IDEs with limited support for JavaFX
	 */
	public static void main(String[] args) {
		launch(args);
	}// main()
}// class