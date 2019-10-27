package com.kappa.kindly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Donation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name = "donator_id", foreignKey = @ForeignKey(name = "fk_donation_donator"))
	private User donator;

	@ManyToOne
	@JoinColumn(name = "institution_id", foreignKey = @ForeignKey(name = "fk_donation_institution"))
	private Institution institution;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT-03:00")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Date cannot be null.")
	private Date date;

	@OneToMany(mappedBy = "donation", cascade = CascadeType.ALL)
	private Set<DonationItem> items;

	public Donation() {

	}

	public Donation(User donator, Institution institution) {
		this.donator = donator;
		this.institution = institution;
	}

	public Donation(User donator, Institution institution, Date date) {
		this(
			donator,
			institution
		);

		this.date = date;
	}

	public Donation(User donator, Institution institution, Date date, Set<DonationItem> items) {
		this(
			donator,
			institution,
			date
		);

		this.items = items;
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

	public User getDonator() {
		return donator;
	}

	public void setDonator(User donator) {
		this.donator = donator;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<DonationItem> getItems() {
		return items;
	}

	public void setItems(Set<DonationItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Donation [date=" + date + ", id=" + id + "]";
	}
}
