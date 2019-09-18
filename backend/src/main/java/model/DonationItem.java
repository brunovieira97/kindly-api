package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonationItem implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * TODO: Create new class to serve as composite Primary Key
	 */
	
	@Id
	private Donation donation;

	@Id
	private Donative donative;

	private double quantity;

	public DonationItem() {

	}

	public DonationItem(Donation donation, Donative donative) {
		this.donation = donation;
		this.donative = donative;
	}

	public DonationItem(Donation donation, Donative donative, double quantity) {
		this(
			donation,
			donative
		);

		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Donative getDonative() {
		return donative;
	}

	public void setDonative(Donative donative) {
		this.donative = donative;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "DonationItem [donation=" + donation + ", donative=" + donative + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donation == null) ? 0 : donation.hashCode());
		result = prime * result + ((donative == null) ? 0 : donative.hashCode());
		long temp;
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonationItem other = (DonationItem) obj;
		if (donation == null) {
			if (other.donation != null)
				return false;
		} else if (!donation.equals(other.donation))
			return false;
		if (donative == null) {
			if (other.donative != null)
				return false;
		} else if (!donative.equals(other.donative))
			return false;
		if (Double.doubleToLongBits(quantity) != Double.doubleToLongBits(other.quantity))
			return false;
		return true;
	}

}
