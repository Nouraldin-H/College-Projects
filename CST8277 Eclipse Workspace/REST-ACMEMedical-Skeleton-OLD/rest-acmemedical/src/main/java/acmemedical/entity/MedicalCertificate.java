/********************************************************************************************************
 * File:  MedicalCertificate.java Course Materials CST 8277
 *
 * @author Teddy Yap
 * 
 */
package acmemedical.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("unused")

/**
 * The persistent class for the medical_certificate database table.
 */
//TODO MC01 - Add the missing annotations.
//TODO MC02 - Do we need a mapped super class?  If so, which one?
@Entity
@Table(name = "medical_certificate")
//@NamedQuery(
//	    name = "Physician.findAllWithCertificates",
//	    query = "SELECT p FROM Physician p LEFT JOIN FETCH p.medicalCertificates"
//	)

@NamedQuery(
	    name = "MedicalCertificate.findById",
	    query = "SELECT mc FROM MedicalCertificate mc WHERE mc.id = :id"
	)
@AttributeOverride(name = "id", column = @Column(name = "certificate_id"))
public class MedicalCertificate extends PojoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 public static final String ID_CARD_QUERY_NAME = "MedicalCertificate.findById";
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "certificate_id", nullable = false)
	    private int id;
	 @Override
	 public int getId() {
		    return id;
		}
	 @Override
		public void setId(int id) {
		    this.id = id;
		}
	 
	// TODO MC03 - Add annotations for 1:1 mapping.  What should be the cascade and fetch types?
	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "training_id", unique = true)
	private MedicalTraining medicalTraining;

	// TODO MC04 - Add annotations for M:1 mapping.  What should be the cascade and fetch types?
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "physician_id", nullable = false)
//	@JsonIgnore
	private Physician owner;

	// TODO MC05 - Add annotations.
	@Column(name = "signed", nullable = false)
	private byte signed;

	public MedicalCertificate() {
		super();
	}
	
	public MedicalCertificate(MedicalTraining medicalTraining, Physician owner, byte signed) {
		this();
		this.medicalTraining = medicalTraining;
		this.owner = owner;
		this.signed = signed;
	}
	


	public MedicalTraining getMedicalTraining() {
		return medicalTraining;
	}

	public void setMedicalTraining(MedicalTraining medicalTraining) {
		this.medicalTraining = medicalTraining;
	}
	
	
   

	public Physician getOwner() {
		return owner;
	}

	public void setOwner(Physician owner) {
		this.owner = owner;
	}

	public byte getSigned() {
		return signed;
	}

	public void setSigned(byte signed) {
		this.signed = signed;
	}

	public void setSigned(boolean signed) {
		this.signed = (byte) (signed ? 0b0001 : 0b0000);
	}
	
	//Inherited hashCode/equals is sufficient for this entity class

}