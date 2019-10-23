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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Donative implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	@NotBlank(message = "Description cannot be blank or null.")
	private String description;

	@ManyToOne
	@JoinColumn(name = "donativetype_id", foreignKey = @ForeignKey(name = "fk_donative_donativetype"))
	private DonativeType type;

	public Donative() {

	}

	public Donative(String description, DonativeType type) {
		this.description = description;
		this.type = type;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DonativeType getType() {
		return type;
	}

	public void setType(DonativeType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Donative [description=" + description + ", id=" + id + "]";
	}

}
