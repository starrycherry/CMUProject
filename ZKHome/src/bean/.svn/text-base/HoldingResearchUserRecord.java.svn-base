package bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="holding_research_user_record")
public class HoldingResearchUserRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	private User user;
	private boolean holdings;
	private boolean htype;
	private boolean hresearch;
	private boolean hclients;
	private boolean hdate;
	private boolean held_by_clients;
	private String filter_by_changes;
	private String hfilter_by_productions;
	private boolean name;
	private boolean ctype;
	private boolean cresearch;
	private boolean cclients;
	private boolean cdate;
	private String cfilter_byproductions;
	private boolean maxHBorder;
	private boolean maxHClientBox;
	private boolean maxHChangeBox;
	private boolean maxHProductionBox;
	private boolean maxCBorder;
	private boolean minHBorder;
	private boolean minHClientBox;
	private boolean minHChangeBox;
	private boolean minHProductionBox;
	private boolean minCBorder;
	
	public HoldingResearchUserRecord() {
		super();
	}

	
	public HoldingResearchUserRecord(User user, boolean holdings,
			boolean htype, boolean hresearch, boolean hclients, boolean hdate,
			boolean held_by_clients, String filter_by_changes,
			String hfilter_by_productions, boolean name, boolean ctype,
			boolean cresearch, boolean cclients, boolean cdate,
			String cfilter_byproductions, boolean maxHBorder,
			boolean maxHClientBox, boolean maxHChangeBox,
			boolean maxHProductionBox, boolean maxCBorder, boolean minHBorder,
			boolean minHClientBox, boolean minHChangeBox,
			boolean minHProductionBox, boolean minCBorder) {
		super();
		this.user = user;
		this.holdings = holdings;
		this.htype = htype;
		this.hresearch = hresearch;
		this.hclients = hclients;
		this.hdate = hdate;
		this.held_by_clients = held_by_clients;
		this.filter_by_changes = filter_by_changes;
		this.hfilter_by_productions = hfilter_by_productions;
		this.name = name;
		this.ctype = ctype;
		this.cresearch = cresearch;
		this.cclients = cclients;
		this.cdate = cdate;
		this.cfilter_byproductions = cfilter_byproductions;
		this.maxHBorder = maxHBorder;
		this.maxHClientBox = maxHClientBox;
		this.maxHChangeBox = maxHChangeBox;
		this.maxHProductionBox = maxHProductionBox;
		this.maxCBorder = maxCBorder;
		this.minHBorder = minHBorder;
		this.minHClientBox = minHClientBox;
		this.minHChangeBox = minHChangeBox;
		this.minHProductionBox = minHProductionBox;
		this.minCBorder = minCBorder;
	}

	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="holdings")
	public boolean isHoldings() {
		return holdings;
	}

	public void setHoldings(boolean holdings) {
		this.holdings = holdings;
	}

	@Column(name="htype")
	public boolean isHtype() {
		return htype;
	}

	public void setHtype(boolean htype) {
		this.htype = htype;
	}

	@Column(name="hresearch")
	public boolean isHresearch() {
		return hresearch;
	}

	public void setHresearch(boolean hresearch) {
		this.hresearch = hresearch;
	}

	@Column(name="hclients")
	public boolean isHclients() {
		return hclients;
	}

	public void setHclients(boolean hclients) {
		this.hclients = hclients;
	}

	@Column(name="hdate")
	public boolean isHdate() {
		return hdate;
	}

	public void setHdate(boolean hdate) {
		this.hdate = hdate;
	}

	@Column(name="held_by_clients")
	public boolean isHeld_by_clients() {
		return held_by_clients;
	}

	public void setHeld_by_clients(boolean held_by_clients) {
		this.held_by_clients = held_by_clients;
	}

	@Column(name="filter_by_changes")
	public String getFilter_by_changes() {
		return filter_by_changes;
	}

	public void setFilter_by_changes(String filter_by_changes) {
		this.filter_by_changes = filter_by_changes;
	}

	@Column(name="hfilter_by_productions")
	public String getHfilter_by_productions() {
		return hfilter_by_productions;
	}

	public void setHfilter_by_productions(String hfilter_by_productions) {
		this.hfilter_by_productions = hfilter_by_productions;
	}

	@Column(name="name")
	public boolean isName() {
		return name;
	}

	public void setName(boolean name) {
		this.name = name;
	}

	@Column(name="ctype")
	public boolean isCtype() {
		return ctype;
	}

	public void setCtype(boolean ctype) {
		this.ctype = ctype;
	}

	@Column(name="cresearch")
	public boolean isCresearch() {
		return cresearch;
	}

	public void setCresearch(boolean cresearch) {
		this.cresearch = cresearch;
	}

	@Column(name="cclients")
	public boolean isCclients() {
		return cclients;
	}

	public void setCclients(boolean cclients) {
		this.cclients = cclients;
	}

	@Column(name="cdate")
	public boolean isCdate() {
		return cdate;
	}

	public void setCdate(boolean cdate) {
		this.cdate = cdate;
	}

	@Column(name="cfilter_byproductions")
	public String getCfilter_byproductions() {
		return cfilter_byproductions;
	}

	public void setCfilter_byproductions(String cfilter_byproductions) {
		this.cfilter_byproductions = cfilter_byproductions;
	}

	@Column(name="max_hborder")
	public boolean isMaxHBorder() {
		return maxHBorder;
	}


	public void setMaxHBorder(boolean maxHBorder) {
		this.maxHBorder = maxHBorder;
	}

	@Column(name="max_hclientbox")
	public boolean isMaxHClientBox() {
		return maxHClientBox;
	}


	public void setMaxHClientBox(boolean maxHClientBox) {
		this.maxHClientBox = maxHClientBox;
	}

	@Column(name="max_hchangebox")
	public boolean isMaxHChangeBox() {
		return maxHChangeBox;
	}


	public void setMaxHChangeBox(boolean maxHChangeBox) {
		this.maxHChangeBox = maxHChangeBox;
	}

	@Column(name="max_hprodcutionbox")
	public boolean isMaxHProductionBox() {
		return maxHProductionBox;
	}


	public void setMaxHProductionBox(boolean maxHProductionBox) {
		this.maxHProductionBox = maxHProductionBox;
	}

	@Column(name="max_cborer")
	public boolean isMaxCBorder() {
		return maxCBorder;
	}


	public void setMaxCBorder(boolean maxCBorder) {
		this.maxCBorder = maxCBorder;
	}

	@Column(name="min_hborder")
	public boolean isMinHBorder() {
		return minHBorder;
	}


	public void setMinHBorder(boolean minHBorder) {
		this.minHBorder = minHBorder;
	}

	@Column(name="min_hclientbox")
	public boolean isMinHClientBox() {
		return minHClientBox;
	}


	public void setMinHClientBox(boolean minHClientBox) {
		this.minHClientBox = minHClientBox;
	}

	@Column(name="min_hchangebox")
	public boolean isMinHChangeBox() {
		return minHChangeBox;
	}


	public void setMinHChangeBox(boolean minHChangeBox) {
		this.minHChangeBox = minHChangeBox;
	}

	@Column(name="min_productionbox")
	public boolean isMinHProductionBox() {
		return minHProductionBox;
	}


	public void setMinHProductionBox(boolean minHProductionBox) {
		this.minHProductionBox = minHProductionBox;
	}

	@Column(name="min_cborder")
	public boolean isMinCBorder() {
		return minCBorder;
	}


	public void setMinCBorder(boolean minCBorder) {
		this.minCBorder = minCBorder;
	}

}
