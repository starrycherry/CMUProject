package bean;

import java.text.SimpleDateFormat;
import java.util.Date;



public class RjNewsBean implements Comparable<RjNewsBean>{
	
	public int id;
	String imageUrl;
	String focus;
	public int recommend=0;
	public boolean archive=false;
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getFocus() {
		return focus;
	}
	public void setFocus(String focus) {
		this.focus = focus;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	String content;
	String title;
	public String url;
	public String subsType;
	public String getSubsType() {
		return subsType;
	}
	public void setSubsType(String subsType) {
		this.subsType = subsType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public RjNewsBean(String content, String title, int id,String url, String subsType, String imgUrl,String focus, int rec){
	this.id=id;
	this.content=content;
	this.title=title;
	this.url=url;
	this.subsType=subsType;
	this.imageUrl=imgUrl;
	this.focus=focus;
	this.recommend=rec;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int compareTo(RjNewsBean comp) {
		int ret=0;
		//in focus compare can be added if needed
		ret= (this.recommend-comp.recommend)*-1;
		
		return ret;
	}
	
}
