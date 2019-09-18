package dao;

import model.Wishlist;

public class WishlistDAO extends AbstractDAO<Wishlist, Long> {

	public WishlistDAO() {
		super(Wishlist.class);
	}

}
