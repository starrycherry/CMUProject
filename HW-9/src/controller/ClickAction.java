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
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.UserBean;

import formbeans.FavoriteForm;
import formbeans.IdForm;


public class ClickAction extends Action {
	private FormBeanFactory<IdForm> formBeanFactory = FormBeanFactory.getInstance(IdForm.class);

	private FavoriteDAO favoriteDAO;
	private UserDAO  userDAO;
	
    public ClickAction(Model model) {
    	favoriteDAO = model.getFaoviteDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "click.do"; }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

	    	IdForm form = formBeanFactory.create(request);
	    	
	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "error.jsp";
	        }
        
    		int favoriteID = form.getIdAsInt();
    		FavoriteBean favorite = favoriteDAO.read(favoriteID);
    		if (favorite == null) {
    			errors.add("No picture with id="+favoriteID);
    			return "error.jsp";
    		}
    		
    		favorite.setClickCount(favorite.getClickCount()+1);
    		favoriteDAO.update(favorite);
    		
    		FavoriteBean[] favoriteList = favoriteDAO.getFavorite(favorite.getUserID());
	        request.setAttribute("favoriteList",favoriteList);
	        
	        UserBean user = (UserBean) request.getSession(false).getAttribute("user");
	        if(user==null){
    			return "list.jsp";
    		}
	        if(form.getSource().endsWith("l")){
	        	return "list.jsp";
	        }
	        HttpSession session = request.getSession();
	        session.setAttribute("user",user);

            return "manage.jsp";
    	} catch (RollbackException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	} catch (FormBeanException e) {
    		errors.add(e.getMessage());
    		return "error.jsp";
    	}
    }
}
