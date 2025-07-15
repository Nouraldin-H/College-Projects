// PersonApp.java
// adapted by kriger from "Learn JavaFX 8", Kishori Sharan, Apress Books
package com.jdojo.mvc;

import com.jdojo.mvc.model.Person;
import com.jdojo.mvc.view.PersonPresenter;
import com.jdojo.mvc.view.PersonView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Person model = new Person();		
		PersonView view = new PersonView();

		Scene scene = new Scene(view);

		PersonPresenter presenter = new PersonPresenter(model, view);
		
		stage.setScene(scene);
		stage.setTitle("Person Management");
		stage.show();
	}
}
