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

public class FavoriteForm extends FormBean {
	private String url;
	private String comment;
	
    public String getURL()  { return url; }
    public String getComment()  { return comment; }
    
    public void setUrl(String s) { url = trimAndConvert(sanitize(s),"<>\"");  }
	public void setComment(String s) {	comment = sanitize(s).trim();                  }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (url == null || url.length() == 0) errors.add("URL is required");

        if (errors.size() > 0) return errors;

        if (!url.matches("^[\\w\\W]+\\.[\\w\\W]+$")) errors.add("Invalid URL");
		
        return errors;
    }
    private String sanitize(String s) {
    	return s.replace("&", "&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");
    }

}
