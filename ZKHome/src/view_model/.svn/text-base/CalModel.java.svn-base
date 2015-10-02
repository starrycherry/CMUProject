package view_model;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import bean.RjCalBean;


public class CalModel {
	public static List<RjCalBean> data=new ArrayList<RjCalBean>();


	public CalModel() {
		init();	
		Collections.sort(data);

	}
	private void init(){
		if(data.size()==0){
			Date d=new Date(113,06,31,06,00,00);
			Date de=new Date(113,07,3,06,00,00);
			data.add(new RjCalBean(d,de, "Meeting with John Doe","","Client","1"));
			
			Date d1=new Date(113,07,01,14,00,00);
			Date de1=new Date(113,07,01,17,00,00);
			data.add(new RjCalBean(d1,de1, "Meeting with intern team","","Team","1"));
			
			Date d2=new Date(113,07,01,12,00,00);
			Date de2=new Date(113,07,01,14,00,00);
			data.add(new RjCalBean(d2,de2, "Meeting with John Smith","","Corporate","1"));
			
			Date d3=new Date(113,07,01,18,00,00);
			Date de3=new Date(113,07,10,22,00,00);
			data.add(new RjCalBean(d3,de3, "Opera Th","","Personal","1"));
			
			Date d4=new Date(113,07,02,12,00,00);
			Date de4=new Date(113,07,02,14,00,00);
			data.add(new RjCalBean(d4,de4, "Lunch meeting with branch colleagues","","Corporate","1"));
			
			Date d5=new Date(113,07,02,13,00,00);
			Date de5=new Date(113,07,02,18,00,00);
			data.add(new RjCalBean(d5,de5, "Lunch with daughter and her family","","Personal","1"));
			
			Date d6=new Date(113,07,04,19,00,00);
			Date de6=new Date(113,07,04,22,00,00);
			data.add(new RjCalBean(d6,de6, "Dinner with Jacksons","","Personal","1"));
			
			Date d7=new Date(113,07,05,13,00,00);
			Date de7=new Date(113,07,05,14,00,00);
			data.add(new RjCalBean(d7,de7, "Weekly meeting","","Corporate","1"));
			
			Date d8=new Date(113,07,05,15,00,00);
			Date de8=new Date(113,07,05,16,00,00);
			data.add(new RjCalBean(d8,de8, "Weekly meeting with team","","Team","1"));
			
			Date d9=new Date(113,07,05,19,00,00);
			Date de9=new Date(113,07,05,22,00,00);
			data.add(new RjCalBean(d9,de9, "Meeting with John Doe","","Client","1"));
			Date d10=new Date(113,07,23,11,00,00);
			Date de10=new Date(113,07,23,12,00,00);
			data.add(new RjCalBean(d10,de10, "Meeting with Cherrie","","Client","1"));
			Date d11=new Date(113,07,23,14,00,00);
			Date de11=new Date(113,07,23,15,00,00);
			data.add(new RjCalBean(d11,de11, "Meeting with Tami","","Client","1"));
			Date d12=new Date(113,07,23,15,00,00);
			Date de12=new Date(113,07,23,16,00,00);
			data.add(new RjCalBean(d12,de12, "Meeting with Patty","","Client","1"));
			Date d13=new Date(113,07,23,17,00,00);
			Date de13=new Date(113,07,23,18,00,00);
			data.add(new RjCalBean(d13,de13, "Meeting with Intern Team","","Team","1"));
		}
	}


	public List<RjCalBean> searchTest() {

		List<RjCalBean> dataR=new ArrayList<RjCalBean>();
		dataR=data;


		return dataR;

	}
	public List<RjCalBean> search(Date date, String kindFil,String fa) {
		String dateS1;
		List<RjCalBean> dataR=new ArrayList<RjCalBean>();

		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		dateS1=df.format(date);
		for(int i=0; i<data.size(); i++){
			if(data.get(i).dateS.equals(dateS1)&&data.get(i).finAdvID.equals(fa)){
				if(kindFil.charAt(0)=='1'&&data.get(i).kind.equals("Personal"))
					dataR.add(data.get(i));
				if(kindFil.charAt(1)=='1'&&data.get(i).kind.equals("Team"))
					dataR.add(data.get(i));
				if(kindFil.charAt(2)=='1'&&data.get(i).kind.equals("Client"))
					dataR.add(data.get(i));
				if(kindFil.charAt(3)=='1'&&data.get(i).kind.equals("Corporate"))
					dataR.add(data.get(i));
			}
		}

		return dataR;

	}


}
