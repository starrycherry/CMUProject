package service;

import bean.User;
import dao.UserDao;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	public User checkLogin(String username, String password) {
		User user = userDao.findUserByUsername(username);
		if(user == null) {
			return null;
		}
		if(!user.getPassword().equals(password)) {
			return null;
		}
		return user;
	}
	
	public User getUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}
	
	public String getFullNameById(int id) {
		return userDao.findNameById(id);
	}
}
