package dao;

import model.Address;

public class AddressDAO extends AbstractDAO<Address, Long> {

	public AddressDAO() {
		super(Address.class);
	}

}
