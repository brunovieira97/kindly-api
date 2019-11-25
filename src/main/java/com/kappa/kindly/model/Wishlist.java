package com.kappa.kindly.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

@Entity
public class Wishlist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(updatable = false, nullable = false)
	private long id;

	private String name;

	@Lob
	@Nullable
	private String description;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "institution_id", foreignKey = @ForeignKey(name = "fk_wishlist_institution"))
	private Institution institution;

	@JsonManagedReference
	@OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
	private List<WishlistItem> items;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Begin/End date cannot be null.")
	private Date beginDate, endDate;

	public Wishlist() {

	}

	public Wishlist(Institution institution, String name, Date beginDate, Date endDate) {
		this.institution = institution;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Wishlist [beginDate=" + beginDate + ", description=" + description + ", endDate=" + endDate + ", id="
				+ id + ", institution=" + institution + ", items=" + items + ", name=" + name + "]";
	}
}
