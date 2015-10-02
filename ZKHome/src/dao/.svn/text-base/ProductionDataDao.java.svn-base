package dao;

import hibernate.entity.FA_PRODUCTION_DETAILS_MASTER;
import hibernate.entity.PRODUCTION_CATEGORY_MASTER;
import hibernate.entity.RJ_USER_MASTER;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.DateHelper;
import bean.MyProductionEntity;
import bean.MyProductionSummaryEntity;

public class ProductionDataDao extends HibernateBaseDao {

	private RoleTestDao roleTestDao = new RoleTestDao();
	private AssetDataDao assetDataDao = new AssetDataDao();
	Session session = HibernateBaseDao.getSessionFactory().openSession();
	Random call = new Random();  
	
	
	public void saveObject(Object t) {
		this.save(t);
	}

	public void addFAProductionDetailsMaster(int amount, String reason, String categoryName, int fa_number){
		this.saveObject(new FA_PRODUCTION_DETAILS_MASTER(amount,reason, getProductionCategoryByName(categoryName),
				roleTestDao.getUserFromFANumber(fa_number), new Date(), new Date()));
	}

	public void addOLDFAProductionDetailsMaster(int amount, String reason, String categoryName, int fa_number, Date old){
		this.saveObject(new FA_PRODUCTION_DETAILS_MASTER(amount,reason, getProductionCategoryByName(categoryName),
				roleTestDao.getUserFromFANumber(fa_number), old, old));
	}

	//	public void addFAProductionMaster(int fa_number, String categoryName, int production_value){
	//		this.saveObject(new FA_PRODUCTION_MASTER(production_value, getProductionCategoryByName(categoryName),
	//				roleTestDao.getUserFromFANumber(fa_number), new Date(), new Date()));
	//	}
	//	
	//	public void addOLDFAProductionMaster(int fa_number, String categoryName, int production_value, Date oldDate){
	//		this.saveObject(new FA_PRODUCTION_MASTER(production_value, getProductionCategoryByName(categoryName),
	//				roleTestDao.getUserFromFANumber(fa_number), oldDate, oldDate));
	//	}

	private  List<MyProductionEntity> myProduction = new ArrayList<MyProductionEntity>();
	private  List<MyProductionSummaryEntity> myProductionSummary = new ArrayList<MyProductionSummaryEntity>();


	public PRODUCTION_CATEGORY_MASTER getProductionCategoryByName(String catName){
		Criteria criteria = session.createCriteria(PRODUCTION_CATEGORY_MASTER.class);
		if(catName != null){
			criteria.add(Restrictions.like("category_name", catName));
		}
		List<PRODUCTION_CATEGORY_MASTER> temp = criteria.list();
		return temp != null ? temp.get(0) : null;
	}

	public  List<MyProductionEntity> getSpecificCategoryMyProductionEntitys(String category_name, String time) {

		if (!myProduction.isEmpty())
			myProduction.clear();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
		int fa_number = 1;

		List<FA_PRODUCTION_DETAILS_MASTER> aaa = getProductionDetails(fa_number,category_name, time);
		for(FA_PRODUCTION_DETAILS_MASTER p : aaa){
			myProduction.add(new MyProductionEntity(p.getAmount(), p.getReason(), category_name, DATE_FORMAT.format(p.getCreated())));
		}

		return new ArrayList<MyProductionEntity>(myProduction);
	}
	public  MyProductionEntity[] getAllMyProductionEntitysArray() {
		return myProduction.toArray(new MyProductionEntity[myProduction.size()]);
	}

	public List<FA_PRODUCTION_DETAILS_MASTER> getProductionDetails(int fa_number, String category_name, String time){

		if(time.equalsIgnoreCase("TODAY")){
			Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getYesterdayDate(new Date()));
			Date toDate = DateHelper.getDateWithoutTime(new Date());
			return getProductionDetailsList(fa_number, category_name, fromDate, toDate);
		}
		else if(time.equalsIgnoreCase("YEST")){
			Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getYesterdayTwoDate(new Date()));
			Date toDate = DateHelper.getDateWithoutTime(DateHelper.getYesterdayDate(new Date()));
			return getProductionDetailsList(fa_number, category_name, fromDate, toDate);
		}
		else if(time.equalsIgnoreCase("MTD")){
			Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));
			Date toDate = DateHelper.getDateWithoutTime(new Date());
			return getProductionDetailsList(fa_number, category_name, fromDate, toDate);
		}
		else if(time.equalsIgnoreCase("PREVM")){
			Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoMonthDate(new Date()));
			Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));
			return getProductionDetailsList(fa_number, category_name, fromDate, toDate);
		}
		else if(time.equalsIgnoreCase("YTD")){
			Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastYearDate(new Date()));
			Date toDate = DateHelper.getDateWithoutTime(new Date());
			return getProductionDetailsList(fa_number, category_name, fromDate, toDate);
		}
		else if(time.equalsIgnoreCase("PREVY")){
			Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoYearDate(new Date()));
			Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastYearDate(new Date()));
			return getProductionDetailsList(fa_number, category_name, fromDate, toDate);
		}
		return null;
	}

	public void generateGraph(int i, List<PRODUCTION_CATEGORY_MASTER> list){
		MyProductionChartDataDAO d = new MyProductionChartDataDAO();
		
//		Last Month
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoMonthDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));
		
		System.out.println("-----------------CHART DATA---------------");
		
		for(PRODUCTION_CATEGORY_MASTER p : list){
			String s1 = p.getCategory_name();
			Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
			if(i > 0){
				RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(i);
				criteria.add(Restrictions.eq("rj_user", r));
				criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(s1)));
				criteria.add(Restrictions.ge("updated", fromDate));
				criteria.add(Restrictions.le("updated", toDate));
			}
			List<FA_PRODUCTION_DETAILS_MASTER>  fa_details_master = criteria.list();
			for(FA_PRODUCTION_DETAILS_MASTER f : fa_details_master){
				d.setMyModel(s1, String.valueOf(f.getUpdated().getDate()),new Integer(f.getAmount()));
				System.out.println(s1 +", "+ String.valueOf(f.getUpdated().getDate())+", "+new Integer(f.getAmount()));
			}
		}
	}

	public List<MyProductionSummaryEntity> getAllMyProductionSummaryEntitys() {
		if (!myProductionSummary.isEmpty())
			myProductionSummary.clear();
		List<PRODUCTION_CATEGORY_MASTER> list = getAllCategory();
		int i = 1;  //FA NUMBER
		generateGraph(i, list);
		for(PRODUCTION_CATEGORY_MASTER p : list){
			String s1 = p.getCategory_name();
			int today = getProductionValueToday(i,s1);
			int yest = getProductionValueYesterday(i,s1);
			int mtd = getProductionValueMTD(i,s1);
			int prev_month = getProductionValuePREVMonth(i, s1);
			int ytd = getProductionValueYTD(i,s1);
			int prev_year = getProductionValuePREVYear(i,s1);

			myProductionSummary.add(new MyProductionSummaryEntity(s1,today,mtd,ytd,yest,prev_month,prev_year));
		}
		return new ArrayList<MyProductionSummaryEntity>(myProductionSummary);
	}

	public  MyProductionSummaryEntity[] getAllMyProductionEntitysSummaryArray() {
		return myProduction.toArray(new MyProductionSummaryEntity[myProductionSummary.size()]);
	}

	public int getProductionValueYTD(int fa_number, String category_name){
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastYearDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(new Date());

		return computeValue( fa_number,  category_name,  fromDate,  toDate);
	}
	public int getProductionValuePREVYear(int fa_number, String category_name){
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoYearDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastYearDate(new Date()));

		return computeValue( fa_number,  category_name,  fromDate,  toDate);
	}

	public int getProductionValueMTD(int fa_number, String category_name){
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(new Date());

		return computeValue( fa_number,  category_name,  fromDate,  toDate);
	}
	public int getProductionValuePREVMonth(int fa_number, String category_name){
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoMonthDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));

		return computeValue( fa_number,  category_name,  fromDate,  toDate);
	}

	public int getProductionValueToday(int fa_number, String category_name){
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getYesterdayDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(new Date());

		return computeValue( fa_number,  category_name,  fromDate,  toDate);
	}

	public int getProductionValueYesterday(int fa_number, String category_name){
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getYesterdayTwoDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(DateHelper.getYesterdayDate(new Date()));


		return computeValue( fa_number,  category_name,  fromDate,  toDate);
	}
	private int computeValue(int fa_number, String category_name, Date fromDate, Date toDate) {
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		if(fa_number > 0){

			RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(fa_number);
			criteria.add(Restrictions.eq("rj_user", r));
			criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(category_name)));
			criteria.add(Restrictions.ge("updated", fromDate));
			criteria.add(Restrictions.le("updated", toDate));
		}
		List<FA_PRODUCTION_DETAILS_MASTER>  temp = criteria.list();

		int value = 0;
		for(FA_PRODUCTION_DETAILS_MASTER f : temp){
			value += f.getAmount();
		}
		return value;
	}

	public  List<FA_PRODUCTION_DETAILS_MASTER> getProductionDetailsList(int fa_number, String category_name, Date fromDate, Date toDate){
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		if(fa_number > 0){

			RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(fa_number);
			criteria.add(Restrictions.eq("rj_user", r));
			criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(category_name)));
			criteria.add(Restrictions.ge("updated", fromDate));
			criteria.add(Restrictions.le("updated", toDate));
		}
		return criteria.list();
	}


	public void addCategory(){
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Commissions", new Date(), new Date()));
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Fees", new Date(), new Date()));
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Trails", new Date(), new Date()));
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Directs", new Date(), new Date()));
	}

	public List<PRODUCTION_CATEGORY_MASTER> getAllCategory(){
		return session.createCriteria(PRODUCTION_CATEGORY_MASTER.class).list();
	}
}