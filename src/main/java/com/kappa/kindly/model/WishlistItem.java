package com.kappa.kindly.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class WishlistItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "wishlist_id", foreignKey = @ForeignKey(name = "fk_wishlistitem_wishlist"))
	private Wishlist wishlist;

	@OneToOne
	@JoinColumn(name = "donative_id", foreignKey = @ForeignKey(name = "fk_wishlistitem_donative"))
	private Donative donative;

	@NotNull(message = "Quantity cannot be null.")
	private double quantity;

	@NotNull(message = "Priority cannot be null.")
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
