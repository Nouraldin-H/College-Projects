/********************************************************************************************************2*4*w*
 * File:  NewPhysicianView.java Course Materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.jsf;

import java.io.Serializable;

import databank.model.PhysicianPojo;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/**
 * This class represents the scope of adding a new physician to the DB.
 * 
 * TODO 09 - This class is a managed bean.  Use the name "newPhysician".<br>
 * TODO 10 - Like previous assignment where PhysicianPojo was view scoped, this class is?<br>
 * TODO 11 - Add the missing variables and their getters and setters.  Have in mind dates and version are internal
 * only.<br>
 * 
 */
@Named("newPhysician")
@ViewScoped
public class NewPhysicianView implements Serializable {
	/** explicit set serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String lastName;
	protected String firstName;

	protected String phoneNumber;
    protected String specialty;
    protected String email;
    protected String address;
    protected String dateOfBirth;
	
	@Inject
	@ManagedProperty("#{physicianController}")
	protected PhysicianController physicianController;

	public NewPhysicianView() {
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
	/**
	 * @return specialty
	 */
	public String getSpecialty() {
        return specialty;
    }

	/**
	 * @param specialty specialty to set
	 */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
	 * @return email
	 */
    public String getEmail() {
        return email;
    }

    /**
	 * @param email email to set
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
	 * @return address
	 */
    public String getAddress() {
        return address;
    }

    /**
	 * @param address address to set
	 */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
	 * @return dateOfBirth
	 */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
	 * @param dateOfBirth dateOfBirth to set
	 */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

	public void addPhysician() {
		if (allNotNullOrEmpty(firstName, lastName /* TODO 11 - Don't forget to add the other variables that are not nullable */)) {
			PhysicianPojo theNewPhysician = new PhysicianPojo();
			theNewPhysician.setFirstName(getFirstName());
			theNewPhysician.setLastName(getLastName());
			//TODO 12 - Call other setters
			theNewPhysician.setPhoneNumber(getPhoneNumber());
            theNewPhysician.setSpecialty(getSpecialty());
            theNewPhysician.setEmail(getEmail());
            theNewPhysician.setAddress(getAddress());
            theNewPhysician.setDateOfBirth(getDateOfBirth());
			physicianController.addNewPhysician(theNewPhysician);
			//Clean up
			physicianController.toggleAdding();
			setFirstName(null);
			setLastName(null);
			//TODO 13 - Set everything else to null
			setPhoneNumber(null);
            setSpecialty(null);
            setEmail(null);
            setAddress(null);
            setDateOfBirth(null);
		}
	}

	static boolean allNotNullOrEmpty(final Object... values) {
		if (values == null) {
			return false;
		}
		for (final Object val : values) {
			if (val == null) {
				return false;
			}
			if (val instanceof String) {
				String str = (String) val;
				if (str.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
}
