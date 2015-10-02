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

public class RegisterForm extends FormBean{
	private String emailAdd;
	private String firstName;
	private String lastName;
	private String password;
    private String confirmedPassword;
    
    public String getEmailAdd()   { return emailAdd;}
    public String getFirstName()  { return firstName; }
    public String getLastName()  { return lastName; }
    public String getPassword()  { return password;}
    public String getConfirmedPassword()    { return confirmedPassword;   }
    
    public void setEmailAdd(String s) { emailAdd = trimAndConvert(s,"<>\"");  }
    public void setFirstName(String s) { firstName = trimAndConvert(s,"<>\"");  }
	public void setLastName(String s)  { lastName  = trimAndConvert(s,"<>\"");  }
	public void setPassword(String s)  { password  = s.trim();                  }
	public void setConfirmedPassword(String s)   { confirmedPassword = s.trim();        }
    
    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();
        
        if (emailAdd == null || emailAdd.length() == 0) errors.add("Email Address is required");
        if (firstName == null || firstName.length() == 0) errors.add("First Name is required");
        if (lastName == null || lastName.length() == 0) errors.add("Last Name is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (confirmedPassword == null||confirmedPassword.length() == 0) errors.add("ConfirmedPassword is required");
        
        if (errors.size() > 0) return errors;
        
        if (!emailAdd.matches("^[\\w\\W]+@[\\w\\W]+.[\\w\\W]+$")) errors.add("Invalid Email Address");
        if (!password.equals(confirmedPassword)) errors.add("The confirmed Password is different from the password");
		
        return errors;
    }

}
