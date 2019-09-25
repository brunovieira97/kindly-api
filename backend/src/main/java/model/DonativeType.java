package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class DonativeType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	private String description;

	@OneToMany(mappedBy = "type")
	private List<Donative> donatives;
	
	public DonativeType() {

	}

	public DonativeType(String description) {
		this.description = description;
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

	public List<Donative> getDonatives() {
		return donatives;
	}

	public void setDonatives(List<Donative> donatives) {
		this.donatives = donatives;
	}

	@Override
	public String toString() {
		return "DonativeType [description=" + description + ", id=" + id + "]";
	}

}
