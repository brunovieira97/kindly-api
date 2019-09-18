package dao;

import model.WishlistItem;

public class WishlistItemDAO extends AbstractDAO<WishlistItem, Long> {

	public WishlistItemDAO() {
		super(WishlistItem.class);
	}

}
