/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class ChangePwdForm extends FormBean {
	private String confirmedPassword;
	private String newPassword;
	
	public String getConfirmedPassword() { return confirmedPassword; }
	public String getNewPassword()     { return newPassword;     }
	
	public void setConfirmedPassword(String s) { confirmedPassword = s.trim(); }
	public void setNewPassword(String s)     { newPassword     = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (newPassword == null || newPassword.length() == 0) {
			errors.add("New Password is required");
		}
		
		if (confirmedPassword == null || confirmedPassword.length() == 0) {
			errors.add("Confirmed Password is required");
		}
		
		if (errors.size() > 0) {
			return errors;
		}
		
		if (!newPassword.equals(confirmedPassword)) {
			errors.add("Passwords do not match");
		}

		return errors;
	}
	
}
