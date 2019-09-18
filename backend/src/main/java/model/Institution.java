package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Institution implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name, phoneNumber;

	@Column(name = "ADDRRESS_ID")
	private Address address;
	
	@Column(name = "ADMINISTRATOR_ID")
	private User administrator;

	@OneToMany(mappedBy = "institution")
	private Set<Wishlist> wishlists;

	@OneToMany
	private Set<CollectionPoint> collectionPoints;

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

	public Set<CollectionPoint> getCollectionPoints() {
		return collectionPoints;
	}

	public void setCollectionPoints(Set<CollectionPoint> collectionPoints) {
		this.collectionPoints = collectionPoints;
	}

	@Override
	public String toString() {
		return "Institution [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
