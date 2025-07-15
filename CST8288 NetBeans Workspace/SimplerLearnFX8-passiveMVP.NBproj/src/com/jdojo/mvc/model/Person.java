// Person.java
// adapted by kriger from "Learn JavaFX 8", Kishori Sharan, Apress Books
package com.jdojo.mvc.model;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {


	private final StringProperty firstName =
			 new SimpleStringProperty(this, "firstName", null);
	private final StringProperty lastName =
			 new SimpleStringProperty(this, "lastName", null);

	public Person() {
		this(null, null);
	}

	public Person(String firstName, String lastName) {
		this.firstName.set(firstName);
		this.lastName.set(lastName);
	}

	/* firstName Property */
	public final String getFirstName() {
		return firstName.get();
	}

	public final void setFirstName(String firstName) {
		firstNameProperty().set(firstName);
	}

	public final StringProperty firstNameProperty() {
		return firstName;
	}

	/* lastName Property */
	public final String getLastName() {
		return lastName.get();
	}

	public final void setLastName(String lastName) {
		lastNameProperty().set(lastName);
	}

	public final StringProperty lastNameProperty() {
		return lastName;
	}

	/* Domain specific business rules */
	public boolean save() {

		System.out.println("Saved " + this.toString()); //TODO add persistence
		return true;
	}

	@Override
	public String toString() {
		return "[" + 
		       "firstName=" + firstName.get() + 
		       ", lastName=" + lastName.get() +  "]";
	}//toString()
}//class


