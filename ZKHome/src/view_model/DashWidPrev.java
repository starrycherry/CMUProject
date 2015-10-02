package view_model;

import java.util.ArrayList;
import java.util.List;

import bean.DashWidPrevBean;
import bean.RjNewsBean;



public class DashWidPrev {
	List<DashWidPrevBean> data=new ArrayList<DashWidPrevBean>();
	
	public DashWidPrev(){
		data.add(new DashWidPrevBean("Calendar", "This is your calendar widget, it aggragated data from all your calanders and will enable you to see all the information from different calendars", "/images/desc/cal.jpg"));
		data.add(new DashWidPrevBean("Major World Indices", "This widget will give you information about the current prices of Major indices", "/images/desc/MajorWrldIndx.jpg"));
		data.add(new DashWidPrevBean("FixedIncome", "This widget gives you information about the fixed income invetments of your clients", "/images/desc/fixdinc.jpg"));
		data.add(new DashWidPrevBean("Forms", "This widget lets you view your frequently used forms and let you access all the forms in the system if needed", "/images/desc/frms.jpg"));
		data.add(new DashWidPrevBean("Holdings Research", "This is one stop widget to look at the details of your client's holdings and the current performance of the stocks", "/images/desc/HolRece.jpg"));
		data.add(new DashWidPrevBean("Cash Management", "This widget gives you information about your clients assets and helps you manage them so that you can allocate the assets efficiently", "/images/desc/casmg.jpg"));
		data.add(new DashWidPrevBean("Manager Production", "This widget helps you monitor your production", "/images/desc/mgrprod.jpg"));
		data.add(new DashWidPrevBean("Market News", "This widget gives yout he news about latest developments in the market that can affect different stocks and may be useful when dicussing with clients", "/images/desc/mktnuz.jpg"));
		data.add(new DashWidPrevBean("Practicing Report", "This widget displays the practice reports to help you manage your business", "/images/desc/practrep.jpg"));
		data.add(new DashWidPrevBean("Contact", "This is one widget to get contact information of all your clients and colleagues", "/images/desc/cont.jpg"));
		data.add(new DashWidPrevBean("Search", "A widget that lets you search information in the system including all Raymond James resources", "/images/desc/sech.jpg"));
		data.add(new DashWidPrevBean("FA Production", "Lets you look at the performance of Financial Advisors under you", "/images/desc/faprod.jpg"));
		data.add(new DashWidPrevBean("Alert", "Alerts based on preset conditions", "/images/desc/alrt.jpg"));
		data.add(new DashWidPrevBean("Discussion Board", "A widget to have discussions with your colleagues", "/images/not_found.jpg"));
		data.add(new DashWidPrevBean("RJ News", "This Widget shows the internally published news that you have subscribed to. You have an option to evaluate the news", "/images/desc/RJNuz.jpg"));
		
	}
	public DashWidPrevBean getData(String wid) {
		for(DashWidPrevBean comp: data){
			if (wid.equals(comp.widName)){
				return comp;
			}
		}
		return new DashWidPrevBean(null, null, "/images/not_found.jpg");
		
	}
}
