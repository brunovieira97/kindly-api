package com.kappa.kindly.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
public class Institution implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;
	
	@NotBlank(message = "Name cannot be blank or null.")
	private String name;
	
	@NotBlank(message = "Phone number cannot be blank or null.")
	private String phoneNumber;

	@Lob
	@Nullable
	private String description;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_institution_address"))
	private Address address;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "administrator_id", foreignKey = @ForeignKey(name = "fk_institution_administrator"))
	private User administrator;

	@JsonManagedReference
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private Set<Wishlist> wishlists;

	public Institution() {

	}

	public Institution(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getAdministrator() {
		return administrator;
	}

	public void setAdministrator(User administrator) {
		this.administrator = administrator;
	}

	public Set<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(Set<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Institution [address=" + address + ", administrator=" + administrator + ", description=" + description
				+ ", id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", wishlists=" + wishlists + "]";
	}
	
}
