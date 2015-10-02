package view_model;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import bean.RjNewsBean;


public class RjNewsModel {
 List<RjNewsBean> data=new ArrayList<RjNewsBean>();
 List<RjNewsBean> dataFilt=new ArrayList<RjNewsBean>();

	public RjNewsModel(boolean[] fil) {
		init(fil);	
		

	}
	private void init(boolean[] fil){
		if(data.size()==0){
			
			data.add(new RjNewsBean("Google today announced the new google branded tablet Nexus 7. They also released stats of last year sales leading to....","Google releases past performance and new gadget",2,"news_small.zul", "Technology","http://www.blogcdn.com/www.engadget.com/media/2013/07/ledegoogle072013-liveblog-0376-1374682488.jpg", "In-focus", 112));
			data.add(new RjNewsBean("Video: Our ceo today spoke on CNBC about","RJ CEO on CNBC",1,"http:**www.youtube.com*embed*Vp4Se1zcUm4", "Internal", "http://img.youtube.com/vi/Vp4Se1zcUm4/default.jpg", "In-focus", 112));
			data.add(new RjNewsBean("President Obama plan in a speech today said that the government plans to increase the spending on infrastructure for public news and reduce...","President proposes corporate tax cuts and increase spending on infrastructure",3,"news_small.zul", "Infrastructure","http://media.nbcwashington.com/images/620*349/obama-speech-one.jpg", "In-focus",90));
			data.add(new RjNewsBean("Pittsburgh starts a new cool roof program (to reduce power consumption during summer months) that will include 10 cuty owned buildings right now that span around 50,000 sq feet","Cool roofs now it Pitt",4,"news_small.zul", "Power","http://greenupgrader.com/files/2010/02/cool_roof.jpg", "",77));
			data.add(new RjNewsBean("Starting this fall Ford will offer options to run the well known F-150 using liquid propane that may cause a shake int the market","Ford F-150 now can run on propane",5,"http:**www.foxnews.com", "Automobile","http://www.theautochannel.com/news/2007/12/26/074045.1-lg.jpg", "",5));
			
	}
		dataFilt=getData(fil);
	}
	public List<RjNewsBean> getData() {
        return data;
    }
	public List<RjNewsBean> getDataFilt() {
        return dataFilt;
    }
	public List<RjNewsBean> getData(boolean[] fil) {
        for(int i=0; i<data.size();i++){
        	if(fil[0]&&!data.get(i).archive&&data.get(i).subsType.equals("Technology")) dataFilt.add(data.get(i));
        	if(fil[1]&&!data.get(i).archive&&data.get(i).subsType.equals("Pharmaceuticals")) dataFilt.add(data.get(i));
        	if(fil[2]&&!data.get(i).archive&&data.get(i).subsType.equals("Infrastructure")) dataFilt.add(data.get(i));
        	if(fil[3]&&!data.get(i).archive&&data.get(i).subsType.equals("Power")) dataFilt.add(data.get(i));
        	if(fil[4]&&!data.get(i).archive&&data.get(i).subsType.equals("Automobile")) dataFilt.add(data.get(i));
        }
     //  System.out.println(fil[2]+" 2 "+data.size());
       Collections.sort(data);
		return data;
    }
	public RjNewsBean beanById(int id) {
        for(int i=0; i<data.size();i++){
        	if(data.get(i).id==id) return data.get(i);
        }
        return null;
	}
	public void incRecoById(int id) {
        for(int i=0; i<data.size();i++){
        	if(data.get(i).id==id) data.get(i).recommend=data.get(i).recommend+1;
        }
        
	}
	public void decRecoById(int id) {
        for(int i=0; i<data.size();i++){
        	if(data.get(i).id==id) data.get(i).recommend=data.get(i).recommend-1;
        }
        
	}
	public void refresh(){
		Collections.sort(dataFilt);

	}
}
