/**
 * andrew ID: chenc2
 * name:Chen Chen
 */
package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

public class Model {
	private FavoriteDAO favoriteDAO;
	private UserDAO userDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriver");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver,jdbcURL);
			
			userDAO  = new UserDAO(pool, "chenc2_user");
			
			favoriteDAO = new FavoriteDAO(pool, "chenc2_favorite");
			
		} catch (DAOException e) {
			throw new ServletException(e);
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	
	public FavoriteDAO getFaoviteDAO()  { return favoriteDAO; }
	public UserDAO getUserDAO()  { return userDAO; }
}
