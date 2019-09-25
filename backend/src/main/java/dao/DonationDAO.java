package dao;

import model.Donation;

public class DonationDAO extends AbstractDAO<Donation, Long> {

	public DonationDAO() {
		super(Donation.class);
	}

}
