package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Wishlist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "INSTITUTION_ID")
	private Institution institution;

	@OneToMany(mappedBy = "wishlist")
	private List<WishlistItem> items;

	private Date beginDate, endDate;

	public Wishlist() {

	}

	public Wishlist(Institution institution, Date beginDate, Date endDate) {
		this.institution = institution;
		this.beginDate = beginDate;
		this.endDate = endDate;
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

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<WishlistItem> getItems() {
		return items;
	}

	public void setItems(List<WishlistItem> items) {
		this.items = items;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Wishlist [beginDate=" + beginDate + ", endDate=" + endDate + ", id=" + id + "]";
	}

}
