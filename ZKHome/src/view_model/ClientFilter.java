package view_model;

public class ClientFilter {
    private String name = "", type = "", research = "";
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name==null?"":name.trim();
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