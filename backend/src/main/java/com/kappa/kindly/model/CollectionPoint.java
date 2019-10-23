package com.kappa.kindly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
public class CollectionPoint implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	@NotBlank(message = "Name cannot be blank or null.")
	private String name;
	
	@Nullable
	private String observations;

	@ManyToOne
	@JoinColumn(name = "institution_id", foreignKey = @ForeignKey(name = "fk_collectionpoint_institution"))
	private Institution institution;

	@OneToOne
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_collectionpoint_address"))
	private Address address;
	
	public CollectionPoint() {

	}

	public CollectionPoint(String name, Institution institution, Address address) {
		this.name = name;
		this.institution = institution;
		this.address = address;
	}

	public CollectionPoint(String name, Institution institution, Address address, String observations) {
		this(
			name,
			institution,
			address
		);

		this.observations = observations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CollectionPoint [id=" + id + ", name=" + name + ", observations=" + observations + "]";
	}

}
