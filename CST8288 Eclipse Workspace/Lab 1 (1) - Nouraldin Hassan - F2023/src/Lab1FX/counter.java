/*		@(#)counter.java	Jan 17, 2022
 *
 */

package Lab1FX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class counter {
/*
 * This program is simply mimics word counter in MicrosoftWord  */


/*
 *	TODO: Inherit from Application class. The main JavaFX class must inherit from Application.
 */



public static void main(String[] args) {
	//TODO to start a JavaFX application we must call the static method
	//launch( args) in the main method. This method is from the Application Class.
}

//---------------------------------------------------------------------

private TextArea textInput;     // For the user's input text.

private Label lineCountLabel;  
private Label wordCountLabel;   
private Label charCountLabel;   
private Label digitCountLabel;
private ToolBar statusBar;

/**
 * The constructor creates components and lays out the window.
 */ 
public void createStatus(Stage stage) {

	textInput = new TextArea();
	textInput.setPrefRowCount(20);
	textInput.setPrefColumnCount(50);
	statusBar = new ToolBar();

	/*	TODO call the method createStatusBar
	 * 
	 *		TODO Create a new button  "process the text" .
	 *
	 *		TODO call setOnKeyPressed on this button and pass a lambda to it. In the lambda if the key pressed, invoke processInput method 
	 *
	 *		TODO set  button style   as "-fx-background-color: darkslateblue; -fx-text-fill: white;"
	 */



	/*when escape key is pressed close the application*/

	stage.addEventHandler( KeyEvent.KEY_RELEASED, ( KeyEvent event) -> {

		if ( !event.isConsumed() && KeyCode.ESCAPE == event.getCode()) {
			stage.hide();
		}
	});



	String style = "-fx-padding: 4px; -fx-font: bold 14pt serif; -fx-background-color: white";

	/* Create each of the labels, and set their properties. */

	lineCountLabel = new Label("  Number of lines:");
	lineCountLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 16pt serif;-fx-padding: 4px;-fx-background-color: white");
	lineCountLabel.setMaxWidth(1000);

	/*
	 * 	TODO Create wordCountLabel, and set their properties. 
	 * 
	 * 	TODO Create charCountLabel, and set their properties. 
	 * 
	 * 	TODO Create digitCountLabel, and set their properties. 
	 * 
	 */


	VBox root = new VBox( 6,new BorderPane(statusBar),textInput, new BorderPane(countButton),
			lineCountLabel, wordCountLabel, charCountLabel,digitCountLabel);

	root.setStyle("-fx-background-color: lightgrey; -fx-border-color: grey; -fx-border-width:5px");


	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.setTitle("MicrosoftWord/Word/Char/digit Counter");
	stage.setResizable(false);
	stage.show();

} 

private void createStatusBar() {
	/*
	 * 	TODO create a new label to show "Type your text here "
	 * 
	 * 	TODO set the style as "-fx-text-fill: black; -fx-font: bold  12pt serif;-fx-padding: 4px;"
	 * 
	 * 	TODO create a new Pane object\
	 * 
	 * 	TODO call the static method setHgrow from HBox and pass to it the pane object and Priority.ALWAYS.
	 * 
	 * 	TODO create a new label and set the text as "Press Esc to Exit".	
	 * 
	 * 	TODO use the statusBar object to store the 3 object we created here.
	 * 			to access the list of children in a ToolBar use the method getItems.
	 * 			getItems method will return a list. use addAll on it to add all the Nodes.
	 * 
	 */

}


public void processInput() {

	String text;

	int charCt, wordCt, lineCt, digitCt;  // Char, word, line and digits  counts.

	text = textInput.getText();

	charCt = text.length();

	/* Compute the wordCt by counting the number of characters
              in the text that lie at the beginning of a word.  The
              beginning of a word is a letter such that the preceding
              character is not a letter. If the letter is the first character in the
              text, then it is the beginning of a word.  If the letter
              is preceded by an apostrophe, and the apostrophe is
              preceded by a letter, than its not the first character
              in a word.
	 */

	wordCt = 0;
	for (int i = 0; i < charCt; i++) {
		boolean startOfWord;
		if ( Character.isLetter(text.charAt(i)) == false )
			startOfWord = false;
		else if (i == 0)
			startOfWord = true;
		else if ( Character.isLetter(text.charAt(i-1)) )
			startOfWord = false;
		else if ( text.charAt(i-1) == '\'' && i > 1 
				&& Character.isLetter(text.charAt(i-2)) )
			startOfWord = false;
		else
			startOfWord = true;
		if (startOfWord)
			wordCt++;
	}


	lineCt = 0;
	for (int i = 0; i < charCt; i++) {
		if (text.charAt(i) == '\n')
			lineCt++;
	}


	/*
	 * 	TODO count the number of digits occurs in the text.
	 */



	lineCountLabel.setText("  Number of lines:  " + lineCt);
	wordCountLabel.setText("  Number of words:  " + wordCt);
	charCountLabel.setText("  Number of chars:  " + charCt);
	digitCountLabel.setText("  Number of digits:  " + digitCt);

}

}
