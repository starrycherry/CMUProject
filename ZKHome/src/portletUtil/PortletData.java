package portletUtil;

import java.util.HashMap;
import java.util.Map;

import portletUtil.PortletInfo.PortletType;

public class PortletData {
	/**
	 * portletInfos contains <Title String, PortletInfo> in it
	 */
	public static final Map<String, PortletInfo> PORTLET_INFOS = new HashMap<String, PortletInfo>();
	static {
		// Initialize Portlet info objects
		PORTLET_INFOS.put("Calendar", 
				new PortletInfo("Calendar", 
				"/calendar/Min/calendarMin.zul",
				"/calendar/Max/calendar.zul", 
				PortletType.IFRAME, "yes", "340px"));

		PORTLET_INFOS.put("Contact", 
				new PortletInfo("Contact", 
				"/contact/min/home.zul",
				"/contact/max/home.zul", 
				PortletType.IFRAME, "yes", "340px"));

		PORTLET_INFOS.put("Cash Management", 
				new PortletInfo("Cash Management", 
				"/cashManagement/min/cashmanagement.zul",
				"/cashManagement/max/cashmanagement.zul", 
				PortletType.IFRAME, "yes", "340px"));

		PORTLET_INFOS.put("FA Production", 
				new PortletInfo("FA Production",
				"/MyProduction/Min/FAProductionHome.zul",
				"/MyProduction/Max/FAProductionHome.zul", 
				PortletType.IFRAME, "yes", "340px"));
	
		PORTLET_INFOS.put("Manager Production", 
				new PortletInfo("Manager Production",
				"/MyProduction/Min/ManagerProductionHome.zul",
				"/MyProduction/Max/ManagerProductionHome.zul", 
				PortletType.IFRAME, "yes", "340px"));
	
		PORTLET_INFOS.put("Practice Report", 
				new PortletInfo("Practice Report",
				"/practicingReport/Min/pacticingreport.zul",
				"/practicingReport/Max/pacticingreport.zul",
				PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Alert", 
				new PortletInfo("Alert",
				"/alert/Min/alertsMin.zul",
				"/alert/Max/alerts.zul",
				PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Search", 
				new PortletInfo("Search",
				"/search/Min/searchMin.zul",
				"/search/Max/search.zul",
				PortletType.IFRAME, "no", "340px"));
		
		PORTLET_INFOS.put("FixedIncome", 
				new PortletInfo("FixedIncome",
				"/fixedIncome/Min/fixedIncome_small.zul",
				"/fixedIncome/Max/fixedIncome.zul",
				PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("RJ News", 
				new PortletInfo("RJ News",
				"/rjNews/Min/rjNewsMin.zul",
				"/rjNews/Max/rjNewsMax.zul",
				PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Market News", 
				new PortletInfo("Market News",
				"/marketNews/Min/marketnews_small.zul",
				"/marketNews/Max/marketnews.zul",
				PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Holdings Research", 
				new PortletInfo("Holdings Research",
				"/holdingResearch/Min/home.zul",
				"/holdingResearch/Max/home.zul",
				PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Major World Indices", 
				new PortletInfo("Major World Indices",
                "http://www.thefinancials.com/syndicated/Free/EXh_Index_Majors5.html",
                "http://www.thefinancials.com/syndicated/Free/EX_Index_Majors.html", PortletType.IFRAME, "no", "230px"));
		
		PORTLET_INFOS.put("Forms", 
				new PortletInfo("Forms",
                "/forms/Min/forms.zul",
                "/forms/Max/forms.zul", PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Notes", 
				new PortletInfo("Notes",
                "http://scrumblr.ca/rj",
                "http://scrumblr.ca/rj", PortletType.IFRAME, "no", "340px"));
		
		PORTLET_INFOS.put("Discussion Board", 
				new PortletInfo("Discussion Board",
                "http://www.twiddla.com/1269644",
                "http://www.twiddla.com/1269644", PortletType.IFRAME, "no", "550px"));
		
		PORTLET_INFOS.put("Twitter", 
				new PortletInfo("Twitter",
                "/twitter/Min/financialList.zul",
                "/twitter/Max/financialList.zul", PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Live Stock", 
				new PortletInfo("Live Stock",
                "/LiveStock/index.zul",
                "/LiveStock/index.zul", PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Currency Converter", 
				new PortletInfo("Currency Converter",
                "/currencyConverter/currency.zul",
                "/currencyConverter/currency.zul", PortletType.IFRAME, "yes", "340px"));
		
		PORTLET_INFOS.put("Calculator", 
				new PortletInfo("Calculator",
                "/calculator/Min/calculator.zul",
                "/calculator/Max/calculator.zul", PortletType.IFRAME, "no", "340px"));
	}
	
}
