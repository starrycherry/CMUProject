package dao;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import util.DateHelper;

public class PopulateDataDao {

	private RoleTestDao roleTestDao = new RoleTestDao();
	private AssetDataDao assetDataDao;
	private FAProductionDataDao productionDataDao = new FAProductionDataDao();
	Random call = new Random();  
	Calendar cal = Calendar.getInstance();  



	public void populateData(){
		roleTestDao = new RoleTestDao();
		assetDataDao = new AssetDataDao();

		productionDataDao.addCategory();
		roleTestDao.addRoles();
		assetDataDao.addAssets();
		populateUsers();		
		//		populateProdMaster();
		populateClients();
		populateClientAssetDetails();
		populateProductionDetailsMaster();
	}


	private void populateProductionDetailsMaster() {
		cal.add(Calendar.DATE, -1);
		for(int i = 1; i<= 3; i++){
			for(int j = 0; j< 100; j++){
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details : " + DateHelper.myMaxInt(20), "Commissions", i,DateHelper.randomDate(2013));
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Fees", i,DateHelper.randomDate(2013));
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Trails", i,DateHelper.randomDate(2013));
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Directs", i,DateHelper.randomDate(2013));
			}

			for(int j = 0; j< 150; j++){
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details : " + DateHelper.myMaxInt(20), "Commissions", i,DateHelper.randomDate());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Fees", i,DateHelper.randomDate());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Trails", i,DateHelper.randomDate());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Directs", i,DateHelper.randomDate());
			}
			
			for(int j = 0; j< 20; j++){
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details : " + DateHelper.myMaxInt(20), "Commissions", i,new Date());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Fees", i,new Date());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Trails", i,new Date());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Directs", i,new Date());
			}
			
			for(int j = 0; j< 20; j++){
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details : " + DateHelper.myMaxInt(20), "Commissions", i,cal.getTime());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Fees", i,cal.getTime());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Trails", i,cal.getTime());
				productionDataDao.addOLDFAProductionDetailsMaster(DateHelper.myMaxInt(200), "Transaction Details: " + DateHelper.myMaxInt(20), "Directs", i,cal.getTime());
			}
		}
	}

	//	public void populateProdMaster(){
	//		for(int j = 0; j< 20; j++){
	//			for(int i = 1; i <= 3; i++){
	//				productionDataDao.addOLDFAProductionMaster(i,"Commissions", DateHelper.myMaxInt(99),DateHelper.randomDate(2013));
	//				productionDataDao.addOLDFAProductionMaster(i,"Fees", DateHelper.myMaxInt(99),DateHelper.randomDate(2013));
	//				productionDataDao.addOLDFAProductionMaster(i,"Trails", DateHelper.myMaxInt(99),DateHelper.randomDate(2013));
	//				productionDataDao.addOLDFAProductionMaster(i,"Directs", DateHelper.myMaxInt(99),DateHelper.randomDate(2013));
	//			}
	//		}
	//
	//		for(int j = 0; j< 100; j++){
	//			for(int i = 1; i <= 3; i++){
	//				productionDataDao.addOLDFAProductionMaster(i,"Commissions", DateHelper.myMaxInt(99),DateHelper.randomDate());
	//				productionDataDao.addOLDFAProductionMaster(i,"Fees", DateHelper.myMaxInt(99),DateHelper.randomDate());
	//				productionDataDao.addOLDFAProductionMaster(i,"Trails", DateHelper.myMaxInt(99),DateHelper.randomDate());
	//				productionDataDao.addOLDFAProductionMaster(i,"Directs", DateHelper.myMaxInt(99),DateHelper.randomDate());
	//			}
	//		}
	//	}

	public void populateClientAssetDetails(){
		cal.add(Calendar.DATE, -1);
		for(int j = 0; j< 100; j++){
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Fee-Based", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Non Fee-Based", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Other", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "US Equities", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-US Equities", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Fixed Income", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Real Estate & Tangibles", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Alternative Investments", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-Classified", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Equities", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Fixed Income", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Mutual Funds", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Annuities", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Alternative Investments", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Other", DateHelper.myMaxInt(14),DateHelper.randomDate());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),DateHelper.randomDate());
		}
		for(int j = 0; j< 200; j++){
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Fee-Based", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Non Fee-Based", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Other", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "US Equities", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-US Equities", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Fixed Income", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Real Estate & Tangibles", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Alternative Investments", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-Classified", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Equities", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Fixed Income", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Mutual Funds", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Annuities", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Alternative Investments", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Other", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),DateHelper.randomDate(2013));
		}
		for(int j = 0; j< 20; j++){
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Fee-Based", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Non Fee-Based", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Other", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "US Equities", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-US Equities", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Fixed Income", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Real Estate & Tangibles", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Alternative Investments", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-Classified", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Equities", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Fixed Income", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Mutual Funds", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Annuities", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Alternative Investments", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Other", DateHelper.myMaxInt(14),new Date());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),new Date());
		}
		
		for(int j = 0; j< 20; j++){
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Fee-Based", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Non Fee-Based", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Account Type", "Other", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "US Equities", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-US Equities", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Fixed Income", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Real Estate & Tangibles", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Alternative Investments", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Non-Classified", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Asset Class", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Equities", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Fixed Income", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Mutual Funds", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Annuities", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Alternative Investments", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Other", DateHelper.myMaxInt(14),cal.getTime());
			assetDataDao.addOldClientAsset(DateHelper.myMaxInt(999),"Product Type", "Cash & Cash Alternatives", DateHelper.myMaxInt(14),cal.getTime());
		}
	}
	public void populateUsers(){
		roleTestDao.addUsers("Kimberly", "Tays", "Manager");  //Role 1
		roleTestDao.addUsers("Steve", "Black", "FA"); //Role 2
		roleTestDao.addUsers("Robert", "Richard", "FA"); //Role 3
		roleTestDao.addUsers("Sateesh", "Prabakaran", "Manager");   //Role 4

		roleTestDao.addFAtoManager(1,2);
		roleTestDao.addFAtoManager(1,3);
	}

	public void populateClients(){
		assetDataDao.addClient("Sahil", "Thakkar", 1);
		assetDataDao.addClient("Sajib", "M", 1);
		assetDataDao.addClient("Tingting", "He", 1);
		assetDataDao.addClient("Biao", "Z", 1);
		assetDataDao.addClient("Simon", "Liang", 1);

		assetDataDao.addClient("Prateek", "Chawla", 2);
		assetDataDao.addClient("Suyash", "L", 2);
		assetDataDao.addClient("Asim", "J", 2);
		assetDataDao.addClient("Vivek", "R", 2);

		assetDataDao.addClient("Cherry", "M", 3);
		assetDataDao.addClient("Friyana", "I", 3);
		assetDataDao.addClient("Daisy", "Z", 3);
		assetDataDao.addClient("Ying", "Lee", 3);
		assetDataDao.addClient("Aayush", "Jain", 3);
	}

	
}