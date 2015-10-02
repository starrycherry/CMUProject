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

//This table maps the number of Clients, a FA/Manager would manage.


@Entity
@Table(name = "CLIENT_FA_MASTER")
public class CLIENT_FA_MASTER {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private int client_id;

	@Column(name = "client_fName")
	private String client_fName;

	@Column(name = "client_lName")
	private String client_lName;

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

	public CLIENT_FA_MASTER(String client_fName, String client_lName, RJ_USER_MASTER rj_user,
			Date created, Date updated){
		this.client_fName = client_fName;
		this.client_lName = client_lName;
		this.rj_user = rj_user;
		this.created = DateHelper.getDateWithoutTime(created);
		this.updated = DateHelper.getDateWithoutTime(updated);
	}

	public CLIENT_FA_MASTER(){

	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getClient_fName() {
		return client_fName;
	}

	public void setClient_fName(String client_fName) {
		this.client_fName = client_fName;
	}

	public String getClient_lName() {
		return client_lName;
	}

	public void setClient_lName(String client_lName) {
		this.client_lName = client_lName;
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

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
