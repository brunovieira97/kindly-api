package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	private String firstName, lastName, email;
	
	private char[] password;

	@CreationTimestamp
	private Timestamp createdOn;

	@UpdateTimestamp
	private Timestamp updatedOn;

	@OneToOne(optional = true)
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_user_address"))
	private Address address;

	@OneToMany(mappedBy = "administrator")
	private List<Institution> administeredInstitutions;

	public User() {

	}

	public User(String firstName, String lastName, String email, char[] password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, char[] password, Address address) {
		this(
			firstName,
			lastName,
			email,
			password
		);

		this.address = address;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Institution> getAdministeredInstitutions() {
		return administeredInstitutions;
	}

	public void setAdministeredInstitution(List<Institution> administeredInstitutions) {
		this.administeredInstitutions = administeredInstitutions;
	}

	@Override
	public String toString() {
		return "User [address=" + address + ", administeredInstitutions=" + administeredInstitutions + ", createdOn="
				+ createdOn + ", email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName
				+ ", password=" + Arrays.toString(password) + ", updatedOn=" + updatedOn + "]";
	}
}
