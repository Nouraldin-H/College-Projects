/********************************************************************************************************
 * File:  PojoBase.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * 
 */
package acmemedical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

/**
 * Abstract class that is base of (class) hierarchy for all @Entity classes
 */

//TODO PB01 - Add annotation to define this class as superclass of all entities.  Please see Week 9 lecture slides.
//TODO PB02 - Add annotation to place all JPA annotations on fields.
//TODO PB03 - Add annotation for listener class.
@MappedSuperclass  
@Access(AccessType.FIELD)  
@EntityListeners(PojoListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class PojoBase implements Serializable {
	private static final long serialVersionUID = 1L;

	// TODO PB04 - Add missing annotations.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id", nullable = false)
	protected int id;

	// TODO PB05 - Add missing annotations.
	@Version
	@Column(name = "version")
	protected int version;

	// TODO PB06 - Add missing annotations (hint, is this column on DB?).
	@Column(name = "created", nullable = false, updatable = false)
	protected LocalDateTime created;

	// TODO PB07 - Add missing annotations (hint, is this column on DB?).
	@Column(name = "updated", nullable = false)
	protected LocalDateTime updated;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;	
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}
	
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	/**
	 * Very important:  Use getter's for member variables because JPA sometimes needs to intercept those calls<br/>
	 * and go to the database to retrieve the value
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
		 */
		if (obj instanceof PojoBase otherPojoBase) {
			// See comment (above) in hashCode():  Compare using only member variables that are
			// truly part of an object's identity
			return Objects.equals(this.getId(), otherPojoBase.getId());
		}
		return false;
	}
}
