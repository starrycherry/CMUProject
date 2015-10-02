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

import model.Model;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.UserBean;
import formbeans.LoginForm;

public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);
	
	private UserDAO userDAO;

	public LoginAction(Model model) {
		userDAO = model.getUserDAO();
	}

	public String getName() { return "login.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        try {
	    	LoginForm form = formBeanFactory.create(request);
	        request.setAttribute("form",form);
	        request.setAttribute("userList", userDAO.getUsers());

	        // If no params were passed, return with no errors so that the form will be
	        // presented (we assume for the first time).
	        if (!form.isPresent()) {
	        	
	            return "login.jsp";
	        }

	        // Any validation errors?
	        errors.addAll(form.getValidationErrors());
	        if (errors.size() != 0) {
	            return "login.jsp";
	        }

	        // Look up the user
	        UserBean user = userDAO.getUser(form.getEmailAdd());
	        
	        if (user == null) {
	            errors.add("User Name not found");
	            return "login.jsp";
	        }
	
	        // Attach (this copy of) the user bean to the session
	        HttpSession session = request.getSession();
	        session.setAttribute("user",user);
	
	        // After successful login send to...
	        String redirectTo = (String) session.getAttribute("redirectTo");
	        if (redirectTo != null) return redirectTo;
	        
	        
	        // If redirectTo is null, redirect to the "manage" action
			String webapp = request.getContextPath();
			return webapp + "/manage.do";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
