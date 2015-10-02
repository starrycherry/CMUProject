package dao;

import hibernate.entity.RJ_USER_MASTER;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import bean.User;

@SuppressWarnings("deprecation")
public class UserDao extends HibernateBaseDao {
	public User findUserByUsername(String username) {
		Object[] params = new Object[]{username};	
		Type[] types = new Type[]{Hibernate.STRING};
		List<Object> result = this.findByHQLWithParam("from User u where u.username = ?", params, types);
		if(result == null || result.size() != 1) {
			return null;
		}
		return (User) result.get(0);
	}

	public int findIdByUsername(String username) {
		User user = this.findUserByUsername(username);
		if(user == null) {
			return -1;
		}
		return user.getUser_id();
	}
	
	public String findNameById(int id) {
		Object[] params = new Object[]{id};	
		Type[] types = new Type[]{Hibernate.INTEGER};
		List<Object> result = this.findByHQLWithParam("from RJ_USER_MASTER user where user.fa_number = ?", params, types);
		if(result == null || result.size() != 1) {
			return null;
		}
		RJ_USER_MASTER user = (RJ_USER_MASTER) result.get(0);
		return user.getRj_user_fName() + " " + user.getRj_user_lName();
	}
}
