package bean;

public class Stream {
	private int id;
	private String subject;
    private String time;   
    private Boolean favorite;
    private Boolean assign;
    private Boolean hidden;

    public Stream(int id, String subject, String time, Boolean favorite, Boolean assign, Boolean hidden) {
        this.id = id;
    	this.subject = subject;
        this.time = time;
        this.favorite = favorite;
        this.assign = assign;
        this.hidden = hidden;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getSubject() {
        return subject;
    }
 
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getTime() {
        return time;
    }
 
    public void setTime(String time) {
        this.time = time;
    }
 
    public Boolean getFavorite() {
        return favorite;
    }
    
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }
 
    public Boolean getAssign() {
        return assign;
    }
    
    public void setAssign(Boolean assign) {
    	this.assign = assign;
    }
    
    public Boolean getHidden() {
    	return hidden;
    }
    
    public void setHidden(Boolean hidden) {
    	this.hidden = hidden;
    }
	
}
