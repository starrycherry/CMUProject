/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FavoriteDAO;
import model.Model;

import model.UserDAO;

import org.genericdao.RollbackException;

import databeans.FavoriteBean;
import databeans.UserBean;


public class ManageAction extends Action {

	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;

	public ManageAction(Model model) {
    	favoriteDAO = model.getFaoviteDAO();
    	userDAO  = model.getUserDAO();
	}

	public String getName() { return "manage.do"; }

	public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			UserBean user = (UserBean) request.getSession(false).getAttribute("user");
        	FavoriteBean[] favoriteList = favoriteDAO.getFavorite(user.getUserID());
	        request.setAttribute("favoriteList",favoriteList);
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("user",user);

	        return "manage.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
