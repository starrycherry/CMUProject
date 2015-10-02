/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.UserBean;

public class UserDAO extends GenericDAO<UserBean> {
	public UserDAO(ConnectionPool cp, String tableName) throws DAOException, RollbackException {
		super(UserBean.class, tableName, cp);
		if(this.getCount()==0){
			createAutoIncrement(new UserBean("A@microsoft.com","A","A","1"));
			createAutoIncrement(new UserBean("B@microsoft.com","B","B","1"));
			createAutoIncrement(new UserBean("C@microsoft.com","C","C","1"));
		}
		
	}
	
	
	public UserBean getUser(String emailAdd) throws RollbackException {
		UserBean[] users = match(MatchArg.equals("emailAdd",emailAdd));
		if(users.length!=0) return users[0];
		else return null;
	}
	
	public UserBean[] getUsers() throws RollbackException {
		UserBean[] users = match();
		Arrays.sort(users);  // We want them sorted by last and first names (as per User.compareTo());
		return users;
	}
	
	public void setPassword(int userID, String password) throws RollbackException {
        try {
        	Transaction.begin();
			UserBean dbUser = read(userID);
			
			if (dbUser == null) {
				throw new RollbackException("User no longer exists");
			}
			
			dbUser.setPassword(password);
			
			update(dbUser);
			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
}
