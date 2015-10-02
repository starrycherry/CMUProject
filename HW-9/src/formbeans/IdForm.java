/**
 * andrew ID: chenc2
 * name:Chen Chen
 * date:5th Dec
 */
package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class IdForm extends FormBean {
	private String id;
	private String source;

	public String getId() { return id;    }
	public String getSource(){return source;}
	
	public int getIdAsInt() {
		// Be sure to first call getValidationErrors() to ensure
		// that NullPointer exception or NumberFormatException will not be thrown!
		return Integer.parseInt(id);
	}
	
	public void setId(String id) { this.id = id; }
	public void setSource(String source){this.source=source;}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if (id == null || id.length() == 0) {
			errors.add("Id is required");
			return errors;
		}
		if(source==null){
			errors.add("Unknown sources");
			return errors;
		}
		try {
			Integer.parseInt(id);
		} catch (NumberFormatException e) {
			errors.add("Id is not an integer");
		}
		
		return errors;
	}
}
