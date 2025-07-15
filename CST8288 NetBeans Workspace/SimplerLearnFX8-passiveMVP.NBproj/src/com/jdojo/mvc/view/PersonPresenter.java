// PersonPresenter.java
// adapted by kriger from "Learn JavaFX 8", Kishori Sharan, Apress Books

package com.jdojo.mvc.view;

import java.util.ArrayList;
import java.util.List;

import com.jdojo.mvc.model.Person;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonPresenter {
	private final Person model;
	private final PersonView view;
	private final SimpleStringProperty fNameInternal = new SimpleStringProperty();
	private final SimpleStringProperty lNameInternal= new SimpleStringProperty();
	
	public PersonPresenter(Person model, PersonView view) {
		this.model = model;
		this.view = view;
		bindToModel(); 
		attachViewEvents();
	}

	private void bindToModel() {
		fNameInternal.bindBidirectional(model.firstNameProperty());
		lNameInternal.bindBidirectional(model.lastNameProperty());
	}
	private void attachViewEvents() {
		// could use handlers instead, 
		// but TextField would need mult. for app to work correctly
		view.fNameFld.textProperty().bindBidirectional(fNameInternal);
		view.lNameFld.textProperty().bindBidirectional(lNameInternal);
		view.saveBtn.setOnAction(e -> saveData()); 
	}

	private void saveData() {
		boolean isSaved = model.save();	
	}
}//class

