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
import util.MiscFormatterHelper;
import bean.ManagerProductionEntity;
import bean.ManagerProductionSummaryEntity;

public class ManagerProductionDataDao extends HibernateBaseDao {

	private RoleTestDao roleTestDao = new RoleTestDao();
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yyyy");
	Random call = new Random();  
	public void saveObject(Object t) {
		this.save(t);
	}

	private  List<ManagerProductionEntity> managerProduction = new ArrayList<ManagerProductionEntity>();
	private  List<ManagerProductionSummaryEntity> managerProductionSummary = new ArrayList<ManagerProductionSummaryEntity>();


	public PRODUCTION_CATEGORY_MASTER getProductionCategoryByName(String catName){
		List<PRODUCTION_CATEGORY_MASTER> temp = null;
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(PRODUCTION_CATEGORY_MASTER.class);
		try{
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
	
	public boolean compareBetweenDates(Date a, Date b, Date inQuestion){
		return a.compareTo(inQuestion) * inQuestion.compareTo(b) > 0;
	}

	public  List<ManagerProductionEntity> getFilteredMyProductionEntitys(String categories, String startTime, String endTime, int manager_id) {
		CallableStatement callableStatement = null, callableStatement1 = null;
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		ResultSet rs = null, rs1 = null;
		List<PRODUCTION_CATEGORY_MASTER> list = getAllCategory();
		Date startDate = new Date(startTime);
		Date endDate = new Date(endTime);
		
		try{

			if (!managerProduction.isEmpty())
				managerProduction.clear();

			String ss[] = categories.split("_");
			for(String s : ss){
				callableStatement = session.connection().prepareCall("{call ManagerProdInfo(?)}");
				callableStatement.setString(1, String.valueOf(manager_id));
				callableStatement.execute();

				rs = callableStatement.getResultSet();
				while(rs.next()){
					callableStatement1 = session.connection().prepareCall("{call prodInfo(?, ?, ?)}");
					callableStatement1.setString(1, "NAME");
					callableStatement1.setString(2, s);
					callableStatement1.setString(3, rs.getString("fa_number"));
					callableStatement1.execute();

					rs1 = callableStatement1.getResultSet();

					while(rs1.next()){

						DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
						Date date= inputFormat.parse(rs1.getString("date"));

						if(compareBetweenDates(startDate, endDate, date)){
						ManagerProductionEntity  m = new ManagerProductionEntity();
						m.setFa_name(rs.getString("fa_name"));
						m.setFa_number( MiscFormatterHelper.FAFormatter(rs.getInt("fa_number")));
						m.setDate(DATE_FORMAT.format(date));
						m.setAmount(CurrencyFormatter.cashFormat(rs1.getString("amount")));
						m.setCategory(rs1.getString("category"));
						m.setReason(rs1.getString("reason"));
						managerProduction.add(m);
						}
					}
				}
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
				if (callableStatement1 != null) callableStatement1.close();
				if (rs1 != null) rs1.close();
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return new ArrayList<ManagerProductionEntity>(managerProduction);
	}

	public  List<ManagerProductionEntity> getSpecificCategoryMyProductionEntitys(String category_name, String time, int manager_id) {
		CallableStatement callableStatement = null, callableStatement1 = null;
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		ResultSet rs = null, rs1 = null;
		List<PRODUCTION_CATEGORY_MASTER> list = getAllCategory();
		try{

			if (!managerProduction.isEmpty())
				managerProduction.clear();

			callableStatement = session.connection().prepareCall("{call ManagerProdInfo(?)}");
			callableStatement.setString(1, String.valueOf(manager_id));
			callableStatement.execute();

			rs = callableStatement.getResultSet();
			while(rs.next()){

				//					call prodInfo("YEST","Commissions",2)
				callableStatement1 = session.connection().prepareCall("{call prodInfo(?, ?, ?)}");
				callableStatement1.setString(1, time);
				callableStatement1.setString(2, category_name);
				callableStatement1.setString(3, rs.getString("fa_number"));
				callableStatement1.execute();

				rs1 = callableStatement1.getResultSet();

				while(rs1.next()){

					DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
					Date date= inputFormat.parse(rs1.getString("date"));


					ManagerProductionEntity  m = new ManagerProductionEntity();
					m.setFa_name(rs.getString("fa_name"));
					m.setFa_number( MiscFormatterHelper.FAFormatter(rs.getInt("fa_number")));
					m.setDate(DATE_FORMAT.format(date));
					m.setAmount(CurrencyFormatter.cashFormat(rs1.getString("amount")));
					m.setCategory(rs1.getString("category"));
					m.setReason(rs1.getString("reason"));
					managerProduction.add(m);
				}
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
				if (callableStatement1 != null) callableStatement1.close();
				if (rs1 != null) rs1.close();
				if (session != null) session.close();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return new ArrayList<ManagerProductionEntity>(managerProduction);
	}

	public  ManagerProductionEntity[] getAllMyProductionEntitysArray() {
		return managerProduction.toArray(new ManagerProductionEntity[managerProduction.size()]);
	}

	public void generateGraph(int i, List<PRODUCTION_CATEGORY_MASTER> list){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		MyProductionChartDataDAO d = new MyProductionChartDataDAO();
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		Date fromDate = DateHelper.getDateWithoutTime(DateHelper.getLastTwoMonthDate(new Date()));
		Date toDate = DateHelper.getDateWithoutTime(DateHelper.getLastMonthDate(new Date()));
		System.out.println("-----------------CHART DATA---------------");
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

	public List<ManagerProductionSummaryEntity> getAllMyProductionSummaryEntitys(int manager_id) {
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		if (!managerProductionSummary.isEmpty())
			managerProductionSummary.clear();

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

				callableStatement = session.connection().prepareCall("{call ManagerProdSummary(?, ?)}");
				callableStatement.setString(1, catName);
				callableStatement.setString(2, String.valueOf(manager_id));
				callableStatement.execute();

				rs = callableStatement.getResultSet();

				while(rs.next()){

					sum_today = sum_today +  rs.getInt(2);
					sum_yesterday = sum_yesterday +  rs.getInt(3);
					sum_mtd = sum_mtd +  rs.getInt(4);
					sum_prev_month = sum_prev_month +  rs.getInt(5);
					sum_ytd = sum_ytd +  rs.getInt(6);
					sum_prev_year = sum_prev_year +  rs.getInt(7);

					managerProductionSummary.add(new ManagerProductionSummaryEntity(rs.getString(1),CurrencyFormatter.cashFormat(rs.getInt(2)),
							CurrencyFormatter.cashFormat(rs.getInt(3)),CurrencyFormatter.cashFormat(rs.getInt(4)),
							CurrencyFormatter.cashFormat(rs.getInt(5)),CurrencyFormatter.cashFormat(rs.getInt(6)),CurrencyFormatter.cashFormat(rs.getInt(7))));
				}				
			}
			managerProductionSummary.add(new ManagerProductionSummaryEntity("Total", CurrencyFormatter.cashFormat(sum_today), CurrencyFormatter.cashFormat(sum_yesterday)
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
		return new ArrayList<ManagerProductionSummaryEntity>(managerProductionSummary);
	}

	public  ManagerProductionSummaryEntity[] getAllMyProductionEntitysSummaryArray() {
		return managerProduction.toArray(new ManagerProductionSummaryEntity[managerProductionSummary.size()]);
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
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(FA_PRODUCTION_DETAILS_MASTER.class);
		int value = 0;
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

	public  List<FA_PRODUCTION_DETAILS_MASTER> getProductionDetailsList
	(int fa_number, String category_name, Date fromDate, Date toDate){
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
		List<FA_PRODUCTION_DETAILS_MASTER> temp = null;
		try{
			if(fa_number > 0){

				RJ_USER_MASTER r = roleTestDao.getUserFromFANumber(fa_number);
				criteria.add(Restrictions.eq("rj_user", r));
				criteria.add(Restrictions.eq("category", this.getProductionCategoryByName(category_name)));
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
		return temp;
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