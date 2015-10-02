package dao;

import hibernate.entity.ASSET_TYPE_MASTER;
import hibernate.entity.CLIENT_ASSET_DETAILS;
import hibernate.entity.CLIENT_FA_MASTER;
import hibernate.entity.RJ_USER_MASTER;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.CurrencyFormatter;
import util.MiscFormatterHelper;
import bean.Asset;
import bean.AssetInfoEntity;
import bean.ManagerAssetInfoEntity;

public class ManagerAssetDataDao extends HibernateBaseDao {
	private  List<ManagerAssetInfoEntity> myFAAssets = new ArrayList<ManagerAssetInfoEntity>();
	private RoleTestDao roleTestDao = new RoleTestDao();
	List<ASSET_TYPE_MASTER> allAssets = getAllAssets();
	Random call = new Random();  
	int manager_id = 2;
	private  List<Asset> assets = new ArrayList<Asset>();

	public void saveObject(Object t) {
		this.save(t);
	}

	public int getAssetSum(String assetType, int manager_id){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		int assetSumm = 0;
		try{

			callableStatement = session.connection().prepareCall("{call assetSum(?, ?)}");
			callableStatement.setString(1, assetType);
			callableStatement.setString(2, String.valueOf(manager_id));
			callableStatement.execute();

			rs = callableStatement.getResultSet();
			while(rs.next()){
				assetSumm = rs.getInt("assetValue");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (callableStatement != null) callableStatement.close();
				if (rs != null) rs.close();
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return assetSumm;
	}

	public Asset getAssetSubValue(int asset_id, int manager_id){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Asset a = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try{
			callableStatement = session.connection().prepareCall("{call assetSummary(?, ?)}");
			callableStatement.setString(1, String.valueOf(asset_id));
			callableStatement.setString(2, String.valueOf(manager_id));
			callableStatement.execute();

			rs = callableStatement.getResultSet();
			while(rs.next()){
				a = new Asset(rs.getString(1), rs.getString(2), CurrencyFormatter.cashFormat(rs.getInt(3)), 0);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (callableStatement != null) callableStatement.close();
				if (rs != null) rs.close();
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return a;
	}
	public  List<Asset> getAllAssetsSummary(int manager_id) {
		if (!assets.isEmpty())
			assets.clear();

		int total1 = 0, total2 = 0, total3 = 0;
		total1 = getAssetSum("Account Type", manager_id);
		total2 = getAssetSum("Asset Class", manager_id);
		total3 = getAssetSum("Product Type", manager_id);


		for(ASSET_TYPE_MASTER allassets : allAssets){
			Asset a;
			if(allassets.getAsset_type().equalsIgnoreCase("Account Type")){
				a = getAssetSubValue(allassets.getAsset_id(), manager_id);
				a.setPercent((100 * CurrencyFormatter.dblCash(a.getAssetValue()))/total1);
				assets.add(a);
			}
			else if(allassets.getAsset_type().equalsIgnoreCase("Asset Class")){
				a = getAssetSubValue(allassets.getAsset_id(), manager_id);
				a.setPercent((100 * CurrencyFormatter.dblCash(a.getAssetValue()))/total2);
				assets.add(a);
			} 
			else if(allassets.getAsset_type().equalsIgnoreCase("Product Type")){
				a = getAssetSubValue(allassets.getAsset_id(), manager_id);
				a.setPercent((100 * CurrencyFormatter.dblCash(a.getAssetValue()))/total3);
				assets.add(a);
			}	
		}
		return new ArrayList<Asset>(assets);
	}
	public  Asset[] getAllAssetsArray() {
		return assets.toArray(new Asset[assets.size()]);
	}

	// This Method only used in "Data Filter" Demo
	public  List<Asset> getFilterAssets(AssetFilter asset) {
		List<Asset> someAssets = new ArrayList<Asset>();
		String cat = asset.getCategory().toLowerCase();
		String nm = asset.getName().toLowerCase();

		for (Iterator<Asset> i = assets.iterator(); i.hasNext();) {
			Asset tmp = i.next();
			if (tmp.getType().toLowerCase().contains(cat) &&
					tmp.getSubType().toLowerCase().contains(nm)) {
				someAssets.add(tmp);
			}
		}
		return someAssets;
	}

	// This Method only used in "Header and footer" Demo
	public  List<Asset> getAssetsByCategory(String category, int manager_id) {
		getAllAssetsSummary(manager_id);
		List<Asset> someAssets = new ArrayList<Asset>();
		for (Iterator<Asset> i = assets.iterator(); i.hasNext();) {
			Asset tmp = i.next();
			if (tmp.getType().equalsIgnoreCase(category)){
				someAssets.add(tmp);
			}
		}
		return someAssets;
	}

	public void addClientAsset(int asset_value, String asset_type, String asset_sub_type, int client_id){
		this.saveObject(new CLIENT_ASSET_DETAILS(asset_value,new Date(), new Date(),
				this.getAssetMaster(asset_type, asset_sub_type),
				this.getClientFAMaster(client_id)
				));
	}

	public void addOldClientAsset(int asset_value, String asset_type, String asset_sub_type, int client_id, Date old){
		this.saveObject(new CLIENT_ASSET_DETAILS(asset_value, old, old,
				this.getAssetMaster(asset_type, asset_sub_type),
				this.getClientFAMaster(client_id)
				));
	}

	public ASSET_TYPE_MASTER getAssetMaster(String asset_type, String asset_sub_type){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ASSET_TYPE_MASTER.class);
		List<ASSET_TYPE_MASTER> temp = null;
		try{
			if(asset_type!=null && asset_sub_type!=null){
				criteria.add(Restrictions.like("asset_sub_type", asset_sub_type));
				criteria.add(Restrictions.like("asset_type", asset_type));
			}
			temp = criteria.list();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return temp != null ? temp.get(0) : null;
	}

	public CLIENT_FA_MASTER getClientFAMaster(int client_id){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(CLIENT_FA_MASTER.class);
		List<CLIENT_FA_MASTER> temp = null;
		try{
			if(client_id> 0){
				criteria.add(Restrictions.eq("client_id", client_id));
			}
			temp = criteria.list();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		return temp != null ? temp.get(0) : null;
	}


	public CLIENT_FA_MASTER getClientFAMasterFromName(String fName, String lName){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(CLIENT_FA_MASTER.class);
		List<CLIENT_FA_MASTER> temp = null;
		try{
			if(fName!=null && lName!=null){
				criteria.add(Restrictions.like("client_fName", fName));
				criteria.add(Restrictions.like("client_lName", lName));
			}
			temp = criteria.list();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return temp != null ? temp.get(0) : null;
	}


	public ASSET_TYPE_MASTER getAsset(int asset_id){
		for(ASSET_TYPE_MASTER a : allAssets){
			if(a.getAsset_id() == asset_id){
				return a;
			}
		}
		return null;
	}


	public List<CLIENT_FA_MASTER> getAllClientAssets(int manager_id){
		//		RJ_USER_MASTER user = roleTestDao.getUserFromFANumber(manager_id);
		List<CLIENT_FA_MASTER> allClients = getAllClientsForFA(manager_id);
		List<CLIENT_ASSET_DETAILS> allClientAssets;
		if(allClients.size() > 0){
			allClientAssets = new ArrayList<CLIENT_ASSET_DETAILS>();
		}
		else
			allClientAssets = null;

		for(CLIENT_FA_MASTER aa : allClients){
			allClientAssets.addAll(getClientAssets(aa.getClient_id()));
		}
		return allClients;
	}

	public List<CLIENT_ASSET_DETAILS> getSpecificClientAssetsForFA(int manager_id, int asset_id){
		//		RJ_USER_MASTER user = roleTestDao.getUserFromFANumber(manager_id);
		List<CLIENT_FA_MASTER> allClients = getAllClientsForFA(manager_id);
		List<CLIENT_ASSET_DETAILS> allClientAssets;
		if(allClients.size() > 0){
			allClientAssets = new ArrayList<CLIENT_ASSET_DETAILS>();
		}
		else
			allClientAssets = null;

		for(CLIENT_FA_MASTER aa : allClients){
			allClientAssets.addAll(getSpecificClientAssets(aa.getClient_id(), asset_id));
		}
		return allClientAssets;
	}

	public List<CLIENT_FA_MASTER> getAllClientsForFA(int fa){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		RJ_USER_MASTER user = roleTestDao.getUserFromFANumber(fa);
		Criteria criteria = session.createCriteria(CLIENT_FA_MASTER.class);
		try{
			if(fa > 0){
				criteria.add(Restrictions.eq("rj_user", user));
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return criteria.list();
	}

	public List<CLIENT_ASSET_DETAILS> getSpecificClientAssets(int client_id, int asset_id){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		CLIENT_FA_MASTER client = this.getClient(client_id);
		Criteria criteria = session.createCriteria(CLIENT_ASSET_DETAILS.class);
		try{

			if(client != null){
				criteria.add(Restrictions.eq("client", client));
				criteria.add(Restrictions.eq("asset", getAsset(asset_id)));
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return criteria.list();
	}

	public List<CLIENT_ASSET_DETAILS> getClientAssets(int client_id){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		CLIENT_FA_MASTER client = this.getClient(client_id);
		Criteria criteria = session.createCriteria(CLIENT_ASSET_DETAILS.class);
		try{
			if(client != null){
				criteria.add(Restrictions.eq("client", client));
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return criteria.list();
	}

	private CLIENT_FA_MASTER getClient(int client_id) {
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(CLIENT_FA_MASTER.class);
		List<CLIENT_FA_MASTER> temp = null;
		try{
			if(client_id > 0){
				criteria.add(Restrictions.eq("client_id", client_id));
			}
			temp = criteria.list();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return temp != null ? temp.get(0) : null;
	}

	public void addAssets(){
		this.saveObject( new ASSET_TYPE_MASTER("Account Type", "Fee-Based", new Date(), new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Account Type", "Non Fee-Based", new Date(), new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Account Type", "Other", new Date(), new Date()));

		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "US Equities",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "Non-US Equities",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "Fixed Income",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "Real Estate & Tangibles",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "Alternative Investments",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "Non-Classified",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Asset Class", "Cash & Cash Alternatives",new Date() , new Date()));

		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Equities",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Fixed Income",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Mutual Funds",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Annuities",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Alternative Investments",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Other",new Date() , new Date()));
		this.saveObject( new ASSET_TYPE_MASTER("Product Type", "Cash & Cash Alternatives",new Date() , new Date()));
	}

	public void addClient(String client_fName, String client_lName, int manager_id){
		this.saveObject( new CLIENT_FA_MASTER(client_fName, client_lName, roleTestDao.getUserFromFANumber(manager_id),
				new Date(), new Date()));
	}

	public List<ManagerAssetInfoEntity> getSpecificCategoryAssetInfoEntitys(
			String category, String type, int manager_id) {

		Session session = HibernateBaseDao.getSessionFactory().openSession();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		
		
		if (!myFAAssets.isEmpty())
			myFAAssets.clear();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
		
		
		try{

			callableStatement = session.connection().prepareCall("{call assetInfo(?, ?)}");
			callableStatement.setString(1, category);
			callableStatement.setString(2, String.valueOf(manager_id));
			callableStatement.execute();

			rs = callableStatement.getResultSet();
			while(rs.next()){
				
				DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
				Date date= inputFormat.parse(rs.getString("updated"));
				
				myFAAssets.add(new ManagerAssetInfoEntity(
						MiscFormatterHelper.FAFormatter(rs.getInt("fa_number")),
						rs.getString("fa_name"), 
						CurrencyFormatter.cashFormat(rs.getString("asset_val")),
						rs.getString("subType"),rs.getString("account_type"), 
						rs.getString("c_fName") + " " + rs.getString("c_lName"),
						DATE_FORMAT.format(date)));
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (callableStatement != null) callableStatement.close();
				if (rs != null) rs.close();
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
//		myFAAssets.add(new ManagerAssetInfoEntity("00001","Michael", CurrencyFormatter.cashFormat(call.nextInt(99)), "Fee Based", "", "Tingting H", DATE_FORMAT.format(randomDate(2013))));
//		myFAAssets.add(new ManagerAssetInfoEntity("00002","Tom", CurrencyFormatter.cashFormat(call.nextInt(99)), "Fee Based","", "Vivek Rao", DATE_FORMAT.format(randomDate(2013))));

		return new ArrayList<ManagerAssetInfoEntity>(myFAAssets);
	}

	public Date randomDate(int year){
		return new GregorianCalendar(year, call.nextInt(7),  call.nextInt(30)).getTime();
	}
	public  AssetInfoEntity[] getAllmyAssetsEntitysArray() {
		return myFAAssets.toArray(new AssetInfoEntity[myFAAssets.size()]);
	}

	public List<ASSET_TYPE_MASTER> getAllAssets(){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		List<ASSET_TYPE_MASTER> temp = null;
		try{
			temp = session.createCriteria(ASSET_TYPE_MASTER.class).list();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally{
			try{
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return temp;
	}
}