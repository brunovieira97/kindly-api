package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Donation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@Column(name = "DONATOR_ID")
	private User donator;

	@ManyToOne
	@Column(name = "INSTITUTION_ID")
	private Institution institution;

	private Date date;

	@OneToMany
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
