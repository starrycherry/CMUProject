package bean;

import java.text.SimpleDateFormat;
import java.util.Date;



public class RjCalBean implements Comparable<RjCalBean>{
//	long uniq;
	public String dateS;
	String timeS;
	String timeEndS;
	public String finAdvID;
	String comments;
	String title;
	public String kind;
	public RjCalBean(Date date1, Date date2,String k, String l, String m, String fa){
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df1=new SimpleDateFormat("HH:mm");//Z is for time zone "HHmmZ" Issue is the date reset in case of time zone change
		this.dateS=df.format(date1);
		this.timeS=df1.format(date1);
		this.timeEndS=df1.format(date2);
		this.comments=k;
		this.title=l;
		this.kind=m;
		this.finAdvID=fa;
	}
	public String getDateS() {
		return dateS;
	}
	public void setDateS(String dateS) {
		this.dateS = dateS;
	}
	public String getTimeS() {
		return timeS;
	}
	public void setTimeS(String timeS) {
		this.timeS = timeS;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int compareTo(RjCalBean comp) {
		int ret=0;
		ret= this.dateS.compareTo(comp.dateS);
		if(ret==0){
			ret=this.timeS.compareTo(comp.timeS);
		}
		return ret;
	}
	public String getTimeEndS() {
		return timeEndS;
	}
	public void setTimeEndS(String timeEndS) {
		this.timeEndS = timeEndS;
	}
}
