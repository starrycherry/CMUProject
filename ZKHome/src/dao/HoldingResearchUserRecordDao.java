package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import bean.HoldingResearchUserRecord;


public class HoldingResearchUserRecordDao extends HibernateBaseDao{
	
	@SuppressWarnings("deprecation")
	public HoldingResearchUserRecord findUserRecordByUser(int id) {
		Object[] params = new Object[]{id};	
		Type[] types = new Type[]{Hibernate.INTEGER};
		List<Object> result = this.findByHQLWithParam("from HoldingResearchUserRecord u where u.user = ?", params, types);
		if(result == null || result.size() != 1) {
			return null;
		}
		return (HoldingResearchUserRecord) result.get(0);
	}
}
