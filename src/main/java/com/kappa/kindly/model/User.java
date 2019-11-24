package com.kappa.kindly.model;

import java.io.Serializable;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	@NotBlank(message = "First name cannot be blank or null.")
	private String firstName;

	@NotBlank(message = "Last name cannot be blank or null.")
	private String lastName;

	@NotBlank(message = "E-mail cannot be blank or null.")
	private String email;

	@NotBlank(message = "CPF cannot be blank or null.")
	private String CPF;

	@NotBlank(message = "Password cannot be blank or null.")
	private String password;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT-03:00")
	@CreationTimestamp
	private Timestamp createdOn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT-03:00")
	@UpdateTimestamp
	private Timestamp updatedOn;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_user_address"))
	private Address address;


	public User() {

	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String password) {
		this(email, password);

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String firstName, String lastName, String email, String password, Address address) {
		this(firstName, lastName, email, password);

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	/**
	 * TODO: define if roles will be used
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

		authorities.add(authority);
		
		return authorities;
	}

	@Override
	public String getUsername() {
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "User [CPF=" + CPF + ", address=" + address + ", createdOn=" + createdOn + ", email=" + email
				+ ", firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", password=" + password
				+ ", updatedOn=" + updatedOn + "]";
	}
}
