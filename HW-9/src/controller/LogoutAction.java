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

import org.genericdao.RollbackException;

import model.Model;
import model.UserDAO;


public class LogoutAction extends Action {
	private UserDAO userDAO;

	public LogoutAction(Model model) { userDAO = model.getUserDAO();}

	public String getName() { return "logout.do"; }

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        HttpSession session = request.getSession(false);
        session.setAttribute("user",null);
        try {
			request.setAttribute("userList", userDAO.getUsers());
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			errors.add(e.getMessage());
        	return "error.jsp";
		}

		request.setAttribute("message","You are now logged out");
        return "success.jsp";
    }
}
