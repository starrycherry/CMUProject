package service;

import bean.UserPortalColumn;
import dao.UserDao;
import dao.UserPortalColumnDao;

public class UserPortalColumnService {
	
	private UserPortalColumnDao portalDao = new UserPortalColumnDao();
	private UserDao userDao = new UserDao();
	
	public boolean updateOrSaveWidgetsOrderInUserPortalColumn(String username, int columnNo, int pageNo, String newOrder) {
		int id = userDao.findIdByUsername(username);
		if(id <= 0) {
			return false;
		}
		UserPortalColumn userPortalColumn = portalDao.findUserPortalColumnByUserAndColumnNoAndPageNo(id, columnNo, pageNo);
		if(userPortalColumn == null) {
			return portalDao.save(new UserPortalColumn(userDao.findUserByUsername(username), columnNo, pageNo, newOrder));
		} else {
			userPortalColumn.setWidgets_order(newOrder);
			return portalDao.update(userPortalColumn);
		}
	}
	
	public String getLayoutOnColumnAndPage(String username, int columnNo, int pageNo) {
		int id = userDao.findIdByUsername(username);
		if(id <= 0) {
			return null;
		}
		UserPortalColumn userPortalColumn = portalDao.findUserPortalColumnByUserAndColumnNoAndPageNo(id, columnNo, pageNo);
		if(userPortalColumn == null) {
			return null;
		}
		return userPortalColumn.getWidgets_order();
	}
	
	public UserPortalColumn getUserPortalColumnByUsernameAndNo(String username, int columnNo, int pageNo) {
		int id = userDao.findIdByUsername(username);
		if(id <= 0) {
			return null;
		}
		UserPortalColumn userPortalColumn = portalDao.findUserPortalColumnByUserAndColumnNoAndPageNo(id, columnNo, pageNo);
		if(userPortalColumn == null) {
			return null;
		}
		return userPortalColumn;
	}
	
	public boolean updateUserPortalColumn(UserPortalColumn userPortalColumn) {
		return portalDao.update(userPortalColumn);
	}
}
