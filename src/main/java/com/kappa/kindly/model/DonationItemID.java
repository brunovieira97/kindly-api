package com.kappa.kindly.model;

import java.io.Serializable;

public class DonationItemID implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Donation donation;
	private Donative donative;

	public DonationItemID() {

	}

	public DonationItemID(Donation donation, Donative donative) {
		this.donation = donation;
		this.donative = donative;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donation == null) ? 0 : donation.hashCode());
		result = prime * result + ((donative == null) ? 0 : donative.hashCode());
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
		
		DonationItemID other = (DonationItemID) obj;
		
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
			
		return true;
	}
}
