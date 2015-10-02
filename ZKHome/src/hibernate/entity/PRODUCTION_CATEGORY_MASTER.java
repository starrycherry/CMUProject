package hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.DateHelper;

@Entity
@Table(name = "PRODUCTION_CATEGORY_MASTER")
public class PRODUCTION_CATEGORY_MASTER {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int category_id;

	@Column(name = "category_name")
	private String category_name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", nullable = false)
	private Date updated;

	@PrePersist
	protected void onCreate() {
		updated = created = DateHelper.getDateWithoutTime(new Date());
	}

	@PreUpdate
	protected void onUpdate() {
		updated = DateHelper.getDateWithoutTime(new Date());
	}

	public PRODUCTION_CATEGORY_MASTER(){

	}

	public PRODUCTION_CATEGORY_MASTER(String category_name, Date created, Date updated){
		this.created = DateHelper.getDateWithoutTime(created); 
		this.updated = DateHelper.getDateWithoutTime(updated);
		this.category_name = category_name;
	}



	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
