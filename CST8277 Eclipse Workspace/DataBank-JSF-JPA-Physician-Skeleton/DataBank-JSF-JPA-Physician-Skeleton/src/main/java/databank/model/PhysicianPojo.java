/********************************************************************************************************2*4*w*
 * File:  PhysicianPojo.java Course Materials CST8277
 *
 * @author Teddy Yap
 * @author Shahriar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

/**
 * TODO 14.1 - Complete the @Entity with correct name.<br>
 * TODO 14.2 - Complete the two @NamedQueries.<br>
 * TODO 15 - Use the correct table name.<br>
 * TODO 16 - Fix the AccessType.<br>
 * TODO 17 - Make PhysicianPojoListener be the listener of this class.  Refer to:
 * https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/entity-listeners.html<br>
 * TODO 18.1 - Add the specialty field, add getter and setter, and update toString method to include the specialty field.<br>
 * TODO 18.2 - Add the remaining @Basic and @Column to all the fields.<br>
 * TODO 19 - Use @Version on the correct field.  This annotation helps keeping track of what version of entity we are
 * working with.<br>
 * TODO 20 - Dates (LocalDateTime) are to be mapped and 'editable' field is not to be mapped.
 */
@ViewScoped
@Entity(name = "Physician")
@Table(name = "physician", catalog = "databank"/*, schema = ""*/)
@Access(AccessType.FIELD) //FIELD?
@EntityListeners({PhysicianPojoListener.class}) // not sure if this is needed.
@NamedQuery(name = PhysicianPojo.PHYSICIAN_FIND_ALL, query = "SELECT p FROM Physician p")
@NamedQuery(name = PhysicianPojo.PHYSICIAN_FIND_ID, query = "SELECT p FROM Physician p WHERE p.id = :id")
public class PhysicianPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String PHYSICIAN_FIND_ALL = "Physician.findAll";
	public static final String PHYSICIAN_FIND_ID = "Physician.findById";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

	@Basic
    @Column(name = "last_name", nullable = false, length = 50)
	protected String lastName;
	
	@Basic
    @Column(name = "first_name", nullable = false, length = 50)
	protected String firstName;

	@Basic
    @Column(name = "email", nullable = false, length = 100)
	protected String email;

	@Basic
    @Column(name = "phone", length = 15)
	protected String phoneNumber;

	@Basic
    @Column(name = "specialty", length = 50)
	protected String specialty;
	
//	@Basic
//    @Column(name = "address"/*, length = 50*/)
//	protected String address;
	
//	@Basic
//    @Column(name = "date_of_birth"/*, length = 50*/)
//    protected String dateOfBirth;
	
	@Basic
    @Column(name = "created", updatable = false)
	protected LocalDateTime created;

	@Basic
    @Column(name = "updated")
	protected LocalDateTime updated;

	@Version // not sure if needed.
    @Column(name = "version")
	protected int version = 1;

	@Transient
	protected boolean editable;

	public PhysicianPojo() {
		super();
	}
	
	@Transient
	public boolean getEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	//@Id 
	//@Column(name = "id") // PHYSICIAN_ID?
	public int getId() {
		return id;
	}
	
	/**
	 * @param id new value for id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the value for lastName
	 */
	//@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName new value for lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the value for firstName
	 */
	//@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName new value for firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	//@Column(name = "phone")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//@Column(name = "specialty")
	public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
//    public String getAddress() {
//        return address;
//    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }

//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    //@Column(name = "created")
	public LocalDateTime getCreated() {
		return created;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	//@Column(name = "updated")
	public LocalDateTime getUpdated() {
		return updated;
	}
	
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	//@Version
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Very important:  Use getter's for member variables because JPA sometimes needs to intercept those calls<br/>
	 * and go to the database to retrieve the value.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		// Only include member variables that really contribute to an object's identity
		// i.e. if variables like version/updated/name/etc. change throughout an object's lifecycle,
		// they shouldn't be part of the hashCode calculation
		return prime * result + Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		/* Enhanced instanceof - yeah!
		 * As of JDK 14, no need for additional 'silly' cast:
		    if (animal instanceof Cat) {
		        Cat cat = (Cat) animal;
		        cat.meow();
                // Other class Cat operations ...
            }
         * Technically, 'otherPhysicianPojo' is a <i>pattern</i> that becomes an in-scope variable binding.
         * Note:  Need to watch out just-in-case there is already a 'otherPhysicianPojo' variable in-scope!
		 */
		if (obj instanceof PhysicianPojo otherPhysicianPojo) {
			// See comment (above) in hashCode():  compare using only member variables that are
			// truly part of an object's identity.
			return Objects.equals(this.getId(), otherPhysicianPojo.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Physician [id = ").append(getId());
		if (getLastName() != null) {
			builder.append(", ").append("lastName = ").append(getLastName());
		}
		if (getFirstName() != null) {
			builder.append(", ").append("firstName = ").append(getFirstName());
		}
		if (getPhoneNumber() != null) {
			builder.append(", ").append("phoneNumber = ").append(getPhoneNumber());
		}
		if (getEmail() != null) {
			builder.append(", ").append("email = ").append(getEmail());
		}
		if (getSpecialty() != null) {
            builder.append(", ").append("specialty = ").append(getSpecialty());
        }
		if (getCreated() != null) {
			builder.append(", ").append("created = ").append(getCreated());
		}
		if (getUpdated() != null) {
			builder.append(", ").append("updated = ").append(getUpdated());
		}
		builder.append("]");
		return builder.toString();
	}

}
