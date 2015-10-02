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

//This table is for RJ Users. It will store information about Managers and FAs.

@Entity
@Table(name = "RJ_USER_MASTER")
public class RJ_USER_MASTER {



	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fa_number")
	private int fa_number;

	@Column(name = "rj_user_fName")
	private String rj_user_fName;

	@Column(name = "rj_user_lName")
	private String rj_user_lName;

	@OneToOne
	@JoinColumn(name = "role_id")
	private ROLE_MASTER role;

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

	public RJ_USER_MASTER(){
		
	}

	public RJ_USER_MASTER(String rj_user_fName, String rj_user_lName, ROLE_MASTER role, 
			Date created, Date updated){
		this.rj_user_fName = rj_user_fName; 
		this.rj_user_lName = rj_user_lName; 
		this.role = role; 
		this.created = DateHelper.getDateWithoutTime(created); 
		this.updated = DateHelper.getDateWithoutTime(updated);
	}

	public int getFa_number() {
		return fa_number;
	}

	public void setFa_number(int fa_number) {
		this.fa_number = fa_number;
	}

	public String getRj_user_fName() {
		return rj_user_fName;
	}

	public void setRj_user_fName(String rj_user_fName) {
		this.rj_user_fName = rj_user_fName;
	}

	public String getRj_user_lName() {
		return rj_user_lName;
	}

	public void setRj_user_lName(String rj_user_lName) {
		this.rj_user_lName = rj_user_lName;
	}

	public ROLE_MASTER getRole() {
		return role;
	}

	public void setRole(ROLE_MASTER role) {
		this.role = role;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

}
