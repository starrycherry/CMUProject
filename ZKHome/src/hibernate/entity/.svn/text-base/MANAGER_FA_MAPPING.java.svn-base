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

// This table maps the number of FAs, a manager would manage.


@Entity
@Table(name = "MANAGER_FA_MAPPING")
public class MANAGER_FA_MAPPING{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fa_manager_id")
	private int fa_manager_id;

	@OneToOne
	@JoinColumn(name = "manager_id")
	private RJ_USER_MASTER rj_user_manager;

	public int getFa_manager_id() {
		return fa_manager_id;
	}

	public void setFa_manager_id(int fa_manager_id) {
		this.fa_manager_id = fa_manager_id;
	}

	@OneToOne
	@JoinColumn(name = "fa_number")
	private RJ_USER_MASTER rj_user_fa;

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

	public MANAGER_FA_MAPPING(){

	}

	public MANAGER_FA_MAPPING(RJ_USER_MASTER manager, RJ_USER_MASTER fa, Date created, Date updated){
		this.rj_user_manager = manager;
		this.rj_user_fa = fa;
		this.created = DateHelper.getDateWithoutTime(created);
		this.updated = DateHelper.getDateWithoutTime(updated);
	}

	public RJ_USER_MASTER getRj_user_manager() {
		return rj_user_manager;
	}

	public void setRj_user_manager(RJ_USER_MASTER rj_user_manager) {
		this.rj_user_manager = rj_user_manager;
	}

	public RJ_USER_MASTER getRj_user_fa() {
		return rj_user_fa;
	}

	public void setRj_user_fa(RJ_USER_MASTER rj_user_fa) {
		this.rj_user_fa = rj_user_fa;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

}
