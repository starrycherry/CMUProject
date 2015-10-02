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


import databeans.FavoriteBean;
import databeans.UserBean;


public class FavoriteDAO extends GenericDAO<FavoriteBean> {
	public FavoriteDAO(ConnectionPool cp, String tableName) throws DAOException, RollbackException {
		super(FavoriteBean.class, tableName, cp);
		if(this.getCount()==0){
			createAutoIncrement(new FavoriteBean(1,"www.cmu.edu","cmu",0));
			createAutoIncrement(new FavoriteBean(1,"www.facebook.com","facebook",0));
			createAutoIncrement(new FavoriteBean(1,"www.google.com","google",0));
			createAutoIncrement(new FavoriteBean(1,"www.amazon.com","amazone",0));
		
			createAutoIncrement(new FavoriteBean(2,"www.cmu.edu","cmu",0));
			createAutoIncrement(new FavoriteBean(2,"www.facebook.com","facebook",0));
			createAutoIncrement(new FavoriteBean(2,"www.google.com","google",0));
			createAutoIncrement(new FavoriteBean(2,"www.amazon.com","amazone",0));
		
			createAutoIncrement(new FavoriteBean(3,"www.cmu.edu","cmu",0));
			createAutoIncrement(new FavoriteBean(3,"www.facebook.com","facebook",0));
			createAutoIncrement(new FavoriteBean(3,"www.google.com","google",0));
			createAutoIncrement(new FavoriteBean(3,"www.amazon.com","amazone",0));
		}
		
	}
	public FavoriteBean[] getFavorite(int userID) throws RollbackException {
		FavoriteBean[] list = match(MatchArg.equals("userID",userID));
		Arrays.sort(list);
		return list;
	}
	public void delete(int favoriteID, int userID) throws RollbackException {
		try {
			Transaction.begin();
    		FavoriteBean favorite = read(favoriteID);

    		if (favorite == null) {
				throw new RollbackException("favorite link does not exist: id="+favoriteID);
    		}

    		if (userID!=favorite.getUserID()) {
				throw new RollbackException("favorite link is not owned by this owner");
    		}

			delete(favoriteID);
			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
}
