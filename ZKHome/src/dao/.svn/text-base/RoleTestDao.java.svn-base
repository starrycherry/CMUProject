package dao;

import hibernate.entity.MANAGER_FA_MAPPING;
import hibernate.entity.RJ_USER_MASTER;
import hibernate.entity.ROLE_MASTER;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.DateHelper;

public class RoleTestDao extends HibernateBaseDao {

	public void saveObject(Object t) {
		this.save(t);
	}
	public void addFAtoManager(int manager_number, int fa_number){
		this.saveObject( new MANAGER_FA_MAPPING(getUserFromFANumber(manager_number), getUserFromFANumber(fa_number),
				new Date(), new Date()));
	}

	public RJ_USER_MASTER getUserFromFANumber(int fa){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(RJ_USER_MASTER.class);
		List<RJ_USER_MASTER> temp = null;
		try{
			if(fa > 0){
				criteria.add(Restrictions.eq("fa_number", fa));
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

	public RJ_USER_MASTER getUserFromFANumberAndRole(ROLE_MASTER role, int fa ){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(RJ_USER_MASTER.class);
		List<RJ_USER_MASTER> temp = null;
		try{
			if(role!=null && fa > 0){
				criteria.add(Restrictions.eq("role_id", role));
				criteria.add(Restrictions.eq("fa_number", fa));
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

	public ROLE_MASTER getRoleFromRoleName(String roleName){
		Session session = HibernateBaseDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ROLE_MASTER.class);
		List<ROLE_MASTER> temp = null;
		try{
		if(roleName != null){
			criteria.add(Restrictions.like("role_name", roleName));
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

	public void addUsers(String fName, String lName, String roleName){
		this.saveObject( new RJ_USER_MASTER(fName, lName, getRoleFromRoleName(roleName), 
				new Date(), new Date()));
	}

	public void addRoles(){
		this.saveObject( new ROLE_MASTER("MANAGER", DateHelper.randomDate(2013), DateHelper.randomDate(2013)));
		this.saveObject( new ROLE_MASTER("FA", DateHelper.randomDate(2013), DateHelper.randomDate(2013)));
	}
}