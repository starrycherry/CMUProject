package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.Type;

import dao.HibernateBaseDao;

public class HibernateBaseDao {

	private final static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }
	
	public boolean save(Object obj){  
		Session session = null;  
		Transaction trans = null;  
		try {  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction();  
			session.save(obj);  
			trans.commit(); 
			return true;  
		} catch (Exception e){  
			if(trans != null)  
				trans.rollback();  
			e.printStackTrace();
		} finally {
			if(session != null)  
				session.close();
		}  
		return false;  
	}  
     

	public boolean delete(Object obj){  
		Session session = null;  
		Transaction trans = null;  
		try{  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction();  
			session.delete(obj);  
			trans.commit();  
			return true;  
		}catch(Exception e){  
			if(trans != null)  
				trans.rollback();  
			e.printStackTrace();  
		}finally{  
			if(session != null)  
				session.close();  
		}  
		return false;  
	}  
    
	
	public boolean update(Object obj){  
		Session session = null;  
		Transaction trans = null;  
		try {  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction();  
			session.update(obj);  
			trans.commit();  
			return true;  
		} catch (Exception e) {  
			if(trans != null)  
				trans.rollback();  
			e.printStackTrace(); 
		}finally{  
			if(session != null)  
				session.close();  
		}  
		return false;  
	}
    
	@SuppressWarnings("unchecked")
	public List<Object> findByHQLWithParam(String hql, Object[] params, Type[] types) {
		Session session = null;  
		Transaction trans = null; 
		List<Object> result = null;
		try {  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction();
			result = session.createQuery(hql).setParameters(params, types).list();
			trans.commit();  
		} catch (Exception e){   
			e.printStackTrace(); 
		} finally {  
			if(session != null)  
				session.close();  
		}  
		return result; 
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> findByHQL(String hql){  
		Session session = null;  
		Transaction trans = null; 
		List<Object> result = null;
		try {  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction(); 
			result = session.createQuery(hql).list();
			trans.commit();  
		} catch(Exception e) {  
			e.printStackTrace(); 
		} finally {  
			if(session != null)  
				session.close();  
		}  
		return result;  
	}
    
	
	@SuppressWarnings("rawtypes")  
	public Object get(Class clazz,Serializable id){  
		Session session = null;  
		Object obj = null;  
		try {  
			session = getSessionFactory().openSession();  
			obj = session.get(clazz,id);  
		} catch(Exception e) {  
			e.printStackTrace();  
		} finally {  
			if(session != null)  
				session.close();  
		}  
		return obj;  
	}
    
	
	public long count(String hql) {
		Session session = null; 
		Transaction trans = null;
		long count = -1;
		try{  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction(); 
			Query query = session.createQuery(hql);
			count = ((Long) query.iterate().next()).intValue();
			trans.commit();
		}catch(Exception e){  
			e.printStackTrace();  
		}finally{  
			if(session != null)  
				session.close();  
		}  
		return count;
	}
    

	@SuppressWarnings("unchecked")
	public List<Object> getPagination(String hql, int curpage, int pagerecord) {
		Session session = null; 
		Transaction trans = null;
		List<Object> list = null;
		try {  
			session = getSessionFactory().openSession();  
			trans = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setFirstResult((curpage - 1) * pagerecord);
			query.setMaxResults(pagerecord);
			list = query.list();
			trans.commit();
		} catch(Exception e) {  
			e.printStackTrace();  
		} finally {  
			if(session != null)  
				session.close();  
		}  
		return list;
	}
}
