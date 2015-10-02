package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import bean.UserPortalColumn;

public class UserPortalColumnDao extends HibernateBaseDao {

	@SuppressWarnings("deprecation")
	public UserPortalColumn findUserPortalColumnByUserAndColumnNoAndPageNo(
			int id, int columnNo, int pageNo) {
		Object[] params = new Object[]{id, columnNo, pageNo};	
		Type[] types = new Type[]{Hibernate.INTEGER, Hibernate.INTEGER, Hibernate.INTEGER};
		List<Object> result = this.findByHQLWithParam(
				"from UserPortalColumn u where u.user = ? and u.column_no = ? and u.page_no = ?", params, types);
		if(result == null || result.size() != 1) {
			return null;
		}
		return (UserPortalColumn) result.get(0);
	}

}
