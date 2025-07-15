// PersonView.java
// adapted by kriger from "Learn JavaFX 8", Kishori Sharan, Apress Books
package com.jdojo.mvc.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class PersonView extends GridPane {

	// Labels
	Label fNameLbl = new Label("First Name:");
	Label lNameLbl = new Label("Last Name:");

	// Fields
	TextField fNameFld = new TextField();
	TextField lNameFld = new TextField();
	
	// Buttons
	Button saveBtn = new Button("Save");

	public PersonView() {
		layoutForm();
	}

	private void layoutForm() {
		this.setHgap(5);
		this.setVgap(5);

		this.add(fNameLbl, 1, 2);
		this.add(lNameLbl, 1, 3);

		this.add(fNameFld, 2, 2);
		this.add(lNameFld, 2, 3);

		// Add buttons and make them the same width
		VBox buttonBox = new VBox(saveBtn);
		saveBtn.setMaxWidth(Double.MAX_VALUE);

		this.add(buttonBox, 3, 1, 1, 5);
	}//layoutform()

}//class
