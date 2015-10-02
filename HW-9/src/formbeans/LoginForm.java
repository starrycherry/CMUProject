/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package formbeans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
		private String emailAdd;
		private String password;
		
	    public void setEmailAdd(String s) { emailAdd = trimAndConvert(s,"<>\"");  }
		public void setPassword(String s) {	password = s.trim();                  }
		
	    public String getEmailAdd()  { return emailAdd; }
	    public String getPassword()  { return password; }

	    public List<String> getValidationErrors() {
	        List<String> errors = new ArrayList<String>();

	        if (emailAdd == null || emailAdd.length() == 0) errors.add("Email Address is required");
	        if (password == null || password.length() == 0) errors.add("Password is required");

	        if (errors.size() > 0) return errors;
	        if (!emailAdd.matches("^[\\w\\W]+@[\\w\\W]+.[\\w\\W]+$")) errors.add("Invalid Email Address");
			
	        return errors;
	    }

}
