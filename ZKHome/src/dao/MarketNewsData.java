package dao;


import java.util.ArrayList;
import java.util.List;
import bean.MarketNews;


public class MarketNewsData {
 List<MarketNews> data=new ArrayList<MarketNews>();


	public MarketNewsData() {
		init();	
		
	}
	private void init(){
			data.add(new MarketNews("European Union and Chinese negotiators reached an agreement to curb EU imports of solar panels from China in exchange for exempting the shipments from punitive tariffs.","China-EU Solar Panel Deal Avoids Tariffs With Import Cuts","/images/marketNews1.png",1));
			data.add(new MarketNews("Two of the largest advertising companies in the world, the Omnicom Group and the Publicis Groupe, are expected to announce their merger on Sunday, people with knowledge of the talks said, a move that would create a new industry leader positioned to ... ","Two Ad Companies Are Said to Merge, Supplanting Industry Leader","/images/marketNews2.png",2));
			data.add(new MarketNews("Consumer Sentiment Shows Improvement in July The July revision of the Thomson Reuters/University of Michigan Consumer Sentiment Index came in at 85.1, which is well above the estimates and above the preliminary report as well","Consumer Sentiment Shows Improvement in July","/images/markertNews3.png",3));
			data.add(new MarketNews("Stocks erased their earlier losses to eke out small gains Friday, with the Dow squeezing out its fifth-consecutive weekly rally, as investors digested the latest batch of mixed earnings reports and ahead of a busy economic calendar next week.","Dow recovers from 150-point drop to log 5-week win streak","/images/marketNews4.png",4));
			data.add(new MarketNews("President Barack Obama said his nominee for Federal Reserve chairman will be someone who embraces the central bank's dual mandate to promote price stability and maximum employment, and he has narrowed his choice ¡°to some extraordinarily qualified ...","Obama Says He Has Narrowed Down Decision on Next Fed Chairman","/images/markertNews5.png",5));
			data.add(new MarketNews("Two recurring misconceptions often repeated in the last several weeks: The domestic auto industry and Detroit are synonymous, and rich city pension benefits have pushed the Detroit budget into ruin.","Detroit: Myths and truths about bankruptcy","/images/markertNews6.png",6));
	}
	public List<MarketNews> getData() {
        return data;
    }
 


}
