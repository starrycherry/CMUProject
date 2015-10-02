package bean;

public class Report {
	private String name;
    private String date;   
    private String favorite;
    private String popular;

    public Report(String name, String date, String favorite, String popular) {
        this.date = date;
        this.name = name;
        this.favorite = favorite;
        this.popular = popular;
    }
 
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getFavorite() {
        return favorite;
    }
 
    public String getPopular() {
        return popular;
    }
 
 
}