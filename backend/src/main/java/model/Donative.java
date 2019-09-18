package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Donative implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String description;

	@ManyToOne
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
