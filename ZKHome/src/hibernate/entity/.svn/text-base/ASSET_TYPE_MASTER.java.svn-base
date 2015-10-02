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
@Table(name = "ASSET_TYPE_MASTER")
public class ASSET_TYPE_MASTER {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_id")
	private int asset_id;

	@Column(name = "asset_type")
	private String asset_type;

	@Column(name = "asset_sub_type")
	private String asset_sub_type;

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

	
	public ASSET_TYPE_MASTER(){

	}

	public ASSET_TYPE_MASTER(String asset_type, String asset_sub_type,
			Date created, Date updated){
		this.created = DateHelper.getDateWithoutTime(created); 
		this.updated = DateHelper.getDateWithoutTime(updated);
		this.asset_type = asset_type;
		this.asset_sub_type = asset_sub_type;
	}
	
	
	public int getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}

	public String getAsset_type() {
		return asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}

	public String getAsset_sub_type() {
		return asset_sub_type;
	}

	public void setAsset_sub_type(String asset_sub_type) {
		this.asset_sub_type = asset_sub_type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getUpdated() {
		return updated;
	}

}
