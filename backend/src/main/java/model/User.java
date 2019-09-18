package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName, lastName, email;
	private char[] password;
	private Timestamp createdOn, lastLogin;

	@Column(name = "ADDRESS_ID")
	private Address address;

	@ManyToMany(mappedBy = "administrator")
	private Institution administeredInstitution;

	public User() {

	}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Institution getAdministeredInstitution() {
		return administeredInstitution;
	}

	public void setAdministeredInstitution(Institution administeredInstitution) {
		this.administeredInstitution = administeredInstitution;
	}

	@Override
	public String toString() {
		return "User [createdOn=" + createdOn + ", email=" + email + ", firstName=" + firstName + ", id=" + id
				+ ", lastLogin=" + lastLogin + ", lastName=" + lastName + ", password=" + Arrays.toString(password)
				+ "]";
	}	
}
