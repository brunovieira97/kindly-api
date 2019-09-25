package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Institution implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	private String name, phoneNumber;

	@OneToOne(optional = true)
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_institution_address"))
	private Address address;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "administrator_id", foreignKey = @ForeignKey(name = "fk_institution_administrator"))
	private User administrator;

	@OneToMany(mappedBy = "institution")
	private Set<Wishlist> wishlists;

	@OneToMany(mappedBy = "institution")
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
