package dao;

import model.User;

public class UserDAO extends AbstractDAO<User, Long> {

	public UserDAO() {
		super(User.class);
	}

}
