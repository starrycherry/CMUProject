package bean;

public class AssetInfoEntity {

	private String asset_val;
	private String c_name;
	private String account_type;
	private String account_sub_type;
	private String updated;
	
	public AssetInfoEntity(){
		
	}
	
	
	public AssetInfoEntity(String asset_val, String account_type, String account_sub_type, String c_name, String updated){
		this.asset_val = asset_val;
		this.account_sub_type = account_sub_type;
		this.c_name = c_name;
		this.account_type = account_type;
		this.updated = updated;
	}

	public String getAccount_sub_type() {
		return account_sub_type;
	}


	public void setAccount_sub_type(String account_sub_type) {
		this.account_sub_type = account_sub_type;
	}


	public String getAsset_val() {
		return asset_val;
	}

	public void setAsset_val(String asset_val) {
		this.asset_val = asset_val;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
}
