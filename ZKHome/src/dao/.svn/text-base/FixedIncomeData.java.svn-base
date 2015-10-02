package dao;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List; 
import bean.FixedIncome;
import bean.FixedIncomeFormat;


public class FixedIncomeData {    
	public List<FixedIncome> incomeList = new ArrayList<FixedIncome>(); 


	public FixedIncomeData() {        
		initData();    
	}   

	private void initData() {        
		if (!incomeList.isEmpty())            
			incomeList.clear(); 

		incomeList.add(new FixedIncome("Cherrie", "875290BQ0", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",93.35,10000, "07/17/2013","07/06/2023",0.000,"Monday's Aaa S&P-AAA Material Events"));
		incomeList.add(new FixedIncome("Cherrie", "898239AB1", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",98.21,1000, null,"08/23/2013",0.000,""));
		incomeList.add(new FixedIncome("Amber", "983421DC2", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",87.72,10000,null,"07/06/2024",0.000,""));
		incomeList.add(new FixedIncome("Scott", "990421DC2", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",77.82,1000,null,"12/16/2014",0.000,""));
		incomeList.add(new FixedIncome("Sam", "987321DC2", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",54.32,10000,"08/12/2013","09/23/2019",0.000,"Monday's Aaa S&P-AAA Material Events"));
		incomeList.add(new FixedIncome("Andy","827321QB2", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",90.76,10000,null,"08/27/2015",0.000,"Monday's Aaa S&P-AAA Material Events"));
		incomeList.add(new FixedIncome("Niall","89203NB1", "TAMPA FLORIDA WATER AND SEWER REVENUE ZERO PERCENT SERIAL DISCOUNT BDS - 875290BQ0",90.23,10000,null,"08/07/2016",0.000,"Monday's Aaa S&P-AAA Material Events"));
	}
	public List<FixedIncome> getAllIncomes() {        
		return incomeList;    
	}


	public List<FixedIncome> getIncomeList() {        
		return incomeList;    
	}     

	public List<FixedIncomeFormat> getFilterIncome(String incomeFilter) {        
		List<FixedIncome> someIncome = new ArrayList<FixedIncome>(); 
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate=new Date();



		if(incomeFilter.equals("maturity")){            
			for (Iterator<FixedIncome> i = incomeList.iterator(); i.hasNext();) {            
				FixedIncome tmp = i.next(); 

				long distance=100;
				try {
					distance = (sdf.parse(tmp.getMaturity()).getTime()-currentDate.getTime())/(24*60*60*1000);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(distance<=30){
					someIncome.add(tmp);
				} 
			}
		}

		if(incomeFilter.equals("callPending")){            
			for (Iterator<FixedIncome> i = incomeList.iterator(); i.hasNext();) {            
				FixedIncome tmp = i.next(); 

				long distance=100;
				String pendingCall=tmp.getPendingCall();
				if(pendingCall!=null){
					try {
						distance = (sdf.parse(tmp.getPendingCall()).getTime()-currentDate.getTime())/(24*60*60*1000);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(distance<=30){
						someIncome.add(tmp);
					} 
				}
			}
		}

		if(incomeFilter.equals("pending")){            
			for (Iterator<FixedIncome> i = incomeList.iterator(); i.hasNext();) {            
				FixedIncome tmp = i.next(); 

				if(tmp.getPendingCall()!=null){
					someIncome.add(tmp);
				} 
			}
		}

		DecimalFormat df=new DecimalFormat("#,##0.00");
		List<FixedIncomeFormat> currentIncome=new ArrayList<FixedIncomeFormat>();
		for (Iterator<FixedIncome> i = someIncome.iterator(); i.hasNext();) {            
			FixedIncome tmp = i.next(); 

			currentIncome.add(new FixedIncomeFormat(tmp.getClientName(),tmp.getCUSIP(),tmp.getDescription(),"$"+df.format(tmp.getMarketPrice()),df.format(tmp.getQuantity()),tmp.getPendingCall(),tmp.getMaturity(),df.format(tmp.getCoupon()),tmp.getRating()));
		} 
		return currentIncome;    
	}
}