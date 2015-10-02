package dao;

import hibernate.entity.FA_PRODUCTION_DETAILS_MASTER;
import hibernate.entity.PRODUCTION_CATEGORY_MASTER;
import hibernate.entity.RJ_USER_MASTER;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.CurrencyFormatter;
import util.DateHelper;
import bean.FAProductionEntity;
import bean.FAProductionSummaryEntity;

public class FAProductionDataDao extends HibernateBaseDao {

	private RoleTestDao roleTestDao = new RoleTestDao();
	Random call = new Random();  
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
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

	private  List<FAProductionEntity> myProduction = new ArrayList<FAProductionEntity>();
	private  List<FAProductionSummaryEntity> myProductionSummary = new ArrayList<FAProductionSummaryEntity>();


	public PRODUCTION_CATEGORY_MASTER getProductionCategoryByName(String catName){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		List<PRODUCTION_CATEGORY_MASTER> temp = null;
		try{
			Criteria criteria = session.createCriteria(PRODUCTION_CATEGORY_MASTER.class);
			if(catName != null){
				criteria.add(Restrictions.like("category_name", catName));
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

	public  List<FAProductionEntity> getSpecificCategoryMyProductionEntitys(String category_name, String time, int fa_number) {
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		try{
			if (!myProduction.isEmpty())
				myProduction.clear();
			
			callableStatement = session.connection().prepareCall("{call prodInfo(?, ?, ?)}");
			callableStatement.setString(1, time);
			callableStatement.setString(2, category_name);
			callableStatement.setString(3, String.valueOf(fa_number));
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			while(rs.next()){
				
				DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
				Date date= inputFormat.parse(rs.getString(1));
				
				myProduction.add(new FAProductionEntity(CurrencyFormatter.cashFormat(rs.getInt("amount")), rs.getString("reason"), 
						rs.getString("category"), DATE_FORMAT.format(date)));
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
		return new ArrayList<FAProductionEntity>(myProduction);
	}


	public  FAProductionEntity[] getAllMyProductionEntitysArray() {
		return myProduction.toArray(new FAProductionEntity[myProduction.size()]);
	}

	public List<FA_PRODUCTION_DETAILS_MASTER> getProductionDetails(int fa_number, String category_name, String time){

		if(time.equalsIgnoreCase("NAME")){
			return getProductionDetailsList(fa_number, category_name);
		}
		else if(time.equalsIgnoreCase("TODAY")){
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
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		MyProductionChartDataDAO d = new MyProductionChartDataDAO();
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoMonthDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));
		System.out.println("-----------------CHART DATA---------------");
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		try{
			for(PRODUCTION_CATEGORY_MASTER p : list){
				String s1 = p.getCategory_name();
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
	}

	public List<FAProductionSummaryEntity> getAllMyProductionSummaryEntitys(int fa_number) {
		CallableStatement callableStatement = null;
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		ResultSet rs = null;
		if (!myProductionSummary.isEmpty())
			myProductionSummary.clear();

		List<PRODUCTION_CATEGORY_MASTER> list = getAllCategory();
		//		generateGraph(fa_number, list);

		try{

			int sum_today = 0;
			int sum_yesterday = 0;
			int sum_mtd= 0;
			int sum_prev_month= 0;
			int sum_ytd= 0;
			int sum_prev_year= 0;


			for(PRODUCTION_CATEGORY_MASTER p : list){
				String catName = p.getCategory_name();
				callableStatement = session.connection().prepareCall("{call prodSummary(?, ?)}");
				callableStatement.setString(1, catName);
				callableStatement.setString(2, String.valueOf(fa_number));
				callableStatement.execute();

				rs = callableStatement.getResultSet();

				while(rs.next()){
					sum_today = sum_today +  rs.getInt(2);
					sum_yesterday = sum_yesterday +  rs.getInt(3);
					sum_mtd = sum_mtd +  rs.getInt(4);
					sum_prev_month = sum_prev_month +  rs.getInt(5);
					sum_ytd = sum_ytd +  rs.getInt(6);
					sum_prev_year = sum_prev_year +  rs.getInt(7);

					myProductionSummary.add(new FAProductionSummaryEntity(rs.getString(1),CurrencyFormatter.cashFormat(rs.getInt("today")),
							CurrencyFormatter.cashFormat(rs.getInt("yesterday")),CurrencyFormatter.cashFormat(rs.getInt("mtd")),
							CurrencyFormatter.cashFormat(rs.getInt("prev_month")),
							CurrencyFormatter.cashFormat(rs.getInt("thisyear")),CurrencyFormatter.cashFormat(rs.getInt("prevYear"))));
				}
			}
			myProductionSummary.add(new FAProductionSummaryEntity("Total", CurrencyFormatter.cashFormat(sum_today), CurrencyFormatter.cashFormat(sum_yesterday)
					, CurrencyFormatter.cashFormat(sum_mtd),CurrencyFormatter.cashFormat(sum_prev_month),CurrencyFormatter.cashFormat(sum_ytd)
					,CurrencyFormatter.cashFormat(sum_prev_year)));
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
		return new ArrayList<FAProductionSummaryEntity>(myProductionSummary);
	}

	public  FAProductionSummaryEntity[] getAllMyProductionEntitysSummaryArray() {
		return myProduction.toArray(new FAProductionSummaryEntity[myProductionSummary.size()]);
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
		int value = 0;
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		try{
			if(fa_number > 0){

				RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(fa_number);
				criteria.add(Restrictions.eq("rj_user", r));
				criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(category_name)));
				criteria.add(Restrictions.ge("updated", fromDate));
				criteria.add(Restrictions.le("updated", toDate));
			}
			List<FA_PRODUCTION_DETAILS_MASTER>  temp = criteria.list();


			for(FA_PRODUCTION_DETAILS_MASTER f : temp){
				value += f.getAmount();
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
		return value;
	}

	public  List<FA_PRODUCTION_DETAILS_MASTER> getProductionDetailsList(int fa_number, String category_name, Date fromDate, Date toDate){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		try{
			if(fa_number > 0){

				RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(fa_number);
				criteria.add(Restrictions.eq("rj_user", r));
				criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(category_name)));
				criteria.add(Restrictions.ge("updated", fromDate));
				criteria.add(Restrictions.le("updated", toDate));
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

	public  List<FA_PRODUCTION_DETAILS_MASTER> getProductionDetailsList(int fa_number, String category_name){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		try{
			if(fa_number > 0){

				RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(fa_number);
				criteria.add(Restrictions.eq("rj_user", r));
				criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(category_name)));
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

	

	public void addCategory(){
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Commissions", DateHelper.randomDate(2013), DateHelper.randomDate(2013)));
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Fees", DateHelper.randomDate(2013), DateHelper.randomDate(2013)));
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Trails", DateHelper.randomDate(2013), DateHelper.randomDate(2013)));
		this.saveObject( new PRODUCTION_CATEGORY_MASTER("Directs", DateHelper.randomDate(2013), DateHelper.randomDate(2013)));
	}

	public List<PRODUCTION_CATEGORY_MASTER> getAllCategory(){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		List<PRODUCTION_CATEGORY_MASTER> temp = null;
		try{
			temp = session.createCriteria(PRODUCTION_CATEGORY_MASTER.class).list();
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