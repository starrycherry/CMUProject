package view_model;

public class HoldingFilter {
    private String equities = "", type = "", research = "";
 
    public String getEquities() {
        return equities;
    }
 
    public void setEquities(String equities) {
        this.equities = equities==null?"":equities.trim();
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type==null?"":type.trim();
    }
 
    public String getResearch() {
        return research;
    }
 
    public void setResearch(String research) {
        this.research = research==null?"":research.trim();
    }
}