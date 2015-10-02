package hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import util.DateHelper;

@Entity
@Table(name = "FA_PRODUCTION_DETAILS_MASTER")
public class FA_PRODUCTION_DETAILS_MASTER {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "production_id")
	private int production_id;

	@Column(name = "amount")
	private int amount;

	@Column(name = "reason")
	private String reason;

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@OneToOne
	@JoinColumn(name = "category_id")
	private PRODUCTION_CATEGORY_MASTER category;

	@OneToOne
	@JoinColumn(name = "fa_number")
	private RJ_USER_MASTER rj_user;

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
	
	public FA_PRODUCTION_DETAILS_MASTER(){
		
	}
	
	public FA_PRODUCTION_DETAILS_MASTER(int amount, String reason, PRODUCTION_CATEGORY_MASTER category, 
			RJ_USER_MASTER user, Date created, Date updated){
		this.amount = amount;
		this.reason = reason;
		this.category = category;
		this.rj_user = user;
		this.created = DateHelper.getDateWithoutTime(created);
		this.updated = DateHelper.getDateWithoutTime(updated);
	}

	public int getProduction_id() {
		return production_id;
	}

	public void setProduction_id(int production_id) {
		this.production_id = production_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public PRODUCTION_CATEGORY_MASTER getCategory() {
		return category;
	}

	public void setCategory(PRODUCTION_CATEGORY_MASTER category) {
		this.category = category;
	}

	public RJ_USER_MASTER getRj_user() {
		return rj_user;
	}

	public void setRj_user(RJ_USER_MASTER rj_user) {
		this.rj_user = rj_user;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

}
