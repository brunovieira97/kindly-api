package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WishlistItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@Column(name = "WISHLIST_ID")
	private Wishlist wishlist;

	@OneToOne
	@Column(name = "DONATIVE_ID")
	private Donative donative;

	private double quantity;
	private int priority;

	public WishlistItem() {

	}

	public WishlistItem(Wishlist wishlist, Donative donative, double quantity, int priority) {
		this.wishlist = wishlist;
		this.donative = donative;
		this.quantity = quantity;
		this.priority = priority;
	}

	public WishlistItem(Wishlist wishlist, Donative donative, double quantity) {
		this(
			wishlist,
			donative,
			quantity,
			1
		);
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

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "WishlistItem [id=" + id + ", priority=" + priority + ", quantity=" + quantity + "]";
	}

}
