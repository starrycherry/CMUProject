package dao;

import org.zkoss.zul.PieModel;
import org.zkoss.zul.SimplePieModel;
 
public class PieChartAssetsData {
	PieModel model = new SimplePieModel();
 
    public PieModel getModel(){
        abc();
    	return model;
    }
    
    public void abc(){
        model.setValue("Fee Based", new Double(37.07));
        model.setValue("Non Fee Based", new Double(34.3));
        model.setValue("Other", new Double(28.4));
    }
    
    public void setMyModel(String s, Double d){
//        model.setValue(s, d);
    }
}