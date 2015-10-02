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

//This table stores all the client asset information

@Entity
@Table(name = "CLIENT_ASSET_DETAILS")
public class CLIENT_ASSET_DETAILS {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_asset_id")
	private int client_asset_id;

	@OneToOne
	@JoinColumn(name = "client_id")
	private CLIENT_FA_MASTER client;

	@OneToOne
	@JoinColumn(name = "asset_id")
	private ASSET_TYPE_MASTER asset;

	@Column(name = "asset_value")
	private int asset_value;

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

	public CLIENT_ASSET_DETAILS(){

	}

	public CLIENT_ASSET_DETAILS(int asset_value, Date created, Date upated, 
			ASSET_TYPE_MASTER asset, CLIENT_FA_MASTER client){
		this.asset = asset;
		this.client = client;
		this.asset_value = asset_value;
		this.created = DateHelper.getDateWithoutTime(created);
		this.updated = DateHelper.getDateWithoutTime(upated);
	}

	public CLIENT_FA_MASTER getClient() {
		return client;
	}

	public void setClient(CLIENT_FA_MASTER client) {
		this.client = client;
	}

	public int getClient_asset_id() {
		return client_asset_id;
	}

	public void setClient_asset_id(int client_asset_id) {
		this.client_asset_id = client_asset_id;
	}

	public ASSET_TYPE_MASTER getAsset() {
		return asset;
	}

	public void setAsset(ASSET_TYPE_MASTER asset) {
		this.asset = asset;
	}

	public int getAsset_value() {
		return asset_value;
	}

	public void setAsset_value(int asset_value) {
		this.asset_value = asset_value;
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
