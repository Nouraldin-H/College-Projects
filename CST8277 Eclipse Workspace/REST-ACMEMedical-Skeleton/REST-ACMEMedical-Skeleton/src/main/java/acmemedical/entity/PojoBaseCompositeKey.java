/********************************************************************************************************
 * File:  PojoBaseCompositeKey.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * 
 */
package acmemedical.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@SuppressWarnings("unused")

/**
 * Abstract class that is base of (class) hierarchy for all @Entity classes
 * @param <ID> - type of composite key used
 */
//TODO PC01 - Add annotation to define this class as superclass of all entities.  Please see Week 9 lecture slides.
@MappedSuperclass
//TODO PC02 - Add annotation to place all JPA annotations on fields.

//TODO PC03 - Add annotation for listener class.
@EntityListeners(PojoCompositeListener.class)
public abstract class PojoBaseCompositeKey<ID extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;

	// TODO PC04 - Add missing annotations.
	@Version
	@Column(name = "version", nullable = false)
	protected int version;

	// TODO PC05 - Add missing annotations (hint, is this column on DB?).
	@Column(name = "created", updatable = false)
	protected LocalDateTime created;

	// TODO PC06 - Add missing annotations (hint, is this column on DB?).
	 @Column(name = "updated")
	protected LocalDateTime updated;

	public abstract ID getId();

	public abstract void setId(ID id);

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
		
		if (obj instanceof PojoBaseCompositeKey otherPojoBaseComposite) {
			// See comment (above) in hashCode():  Compare using only member variables that are
			// truly part of an object's identity
			return Objects.equals(this.getId(), otherPojoBaseComposite.getId());
		}
		return false;
	}
}
