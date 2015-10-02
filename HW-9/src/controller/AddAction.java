/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FavoriteDAO;
import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FileProperty;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.UserBean;

import formbeans.FavoriteForm;

public class AddAction extends Action {
	private FormBeanFactory<FavoriteForm> formBeanFactory = FormBeanFactory.getInstance(FavoriteForm.class);

	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;
	
	public AddAction(Model model) {
    	favoriteDAO = model.getFaoviteDAO();
    	userDAO  = model.getUserDAO();
	}

	public String getName() { return "add.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			UserBean user = (UserBean) request.getSession(false).getAttribute("user");
        	

			FavoriteForm form = formBeanFactory.create(request);
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() > 0) return "manage.jsp";
	        
	        FavoriteBean favoriteBean=new FavoriteBean();
	        favoriteBean.setClickCount(0);
	        favoriteBean.setComment(form.getComment());
	        favoriteBean.setUrl(form.getURL());
	        favoriteBean.setUserID(user.getUserID());
	        favoriteDAO.createAutoIncrement(favoriteBean);
	        
	        FavoriteBean[] favoriteList = favoriteDAO.getFavorite(user.getUserID());
	        request.setAttribute("favoriteList",favoriteList);
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("user",user);
	        
	        return "manage.jsp";

	 	} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
	 	} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "manage.jsp";
		}
    }
    
}
