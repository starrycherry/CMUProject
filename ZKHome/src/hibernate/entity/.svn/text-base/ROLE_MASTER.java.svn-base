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

// This table is for User Roles.


@Entity
@Table(name = "ROLE_MASTER")
public class ROLE_MASTER {

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int role_id;

	@Column(name = "role_name")
	private String role_name;

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
	
	public ROLE_MASTER(){
		
	}
	
	public ROLE_MASTER(String roleName, Date created, Date updated){
		this.role_name = roleName;
		this.created = DateHelper.getDateWithoutTime(created);
		this.updated = DateHelper.getDateWithoutTime(updated);
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	@PreUpdate
	protected void onUpdate() {
		updated = DateHelper.getDateWithoutTime(new Date());
	}
}
