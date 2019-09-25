package dao;

import model.DonationItem;

public class DonationItemDAO extends AbstractDAO<DonationItem, Long> {

	public DonationItemDAO() {
		super(DonationItem.class);
	}

}
