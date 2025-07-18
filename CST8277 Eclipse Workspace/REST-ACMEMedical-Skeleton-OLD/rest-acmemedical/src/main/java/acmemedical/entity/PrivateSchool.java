/********************************************************************************************************
 * File:  PrivateSchool.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * 
 */
package acmemedical.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//TODO PRSC01 - Add missing annotations, please see Week 9 slides page 15.  Value 1 is public and value 0 is private.
//TODO PRSC02 - Is a JSON annotation needed here?
@Entity
@DiscriminatorValue("0")
@Table(name = "privateschool")
public class PrivateSchool extends MedicalSchool implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public PrivateSchool() {
		super(false);

	}
}