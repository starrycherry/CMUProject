package dao;

import org.zkoss.zul.CategoryModel;
import org.zkoss.zul.SimpleCategoryModel;


// This file is used by Sahil for Production Summary Chart
public class MyProductionChartDataDAO {
	CategoryModel model = new SimpleCategoryModel();

	public CategoryModel getModel() {
		abc();
		return model;
	}

	public void setModel(CategoryModel m){
		this.model = m;
	}

	public void setMyModel(String cat, String mid, int i){
//		model.setValue(cat, mid, new Integer(i));
	}

	public void abc(){
		String[] category = { "Commisions", "Fees", "Trials", "Directs" };
		model.setValue(category[0], "05", new Integer(25));
		model.setValue(category[0], "10", new Integer(35));
		model.setValue(category[0], "15", new Integer(45));
		model.setValue(category[0], "20", new Integer(48));
		model.setValue(category[0], "25", new Integer(53));
		model.setValue(category[0], "30", new Integer(62));

		model.setValue(category[1], "05", new Integer(28));
		model.setValue(category[1], "10", new Integer(33));
		model.setValue(category[1], "15", new Integer(40));
		model.setValue(category[1], "20", new Integer(53));
		model.setValue(category[1], "25", new Integer(58));
		model.setValue(category[1], "30", new Integer(75));

		model.setValue(category[2], "05", new Integer(40));
		model.setValue(category[2], "10", new Integer(55));
		model.setValue(category[2], "15", new Integer(65));
		model.setValue(category[2], "20", new Integer(57));
		model.setValue(category[2], "25", new Integer(63));
		model.setValue(category[2], "30", new Integer(68));

		model.setValue(category[3], "05", new Integer(33));
		model.setValue(category[3], "10", new Integer(55));
		model.setValue(category[3], "15", new Integer(65));
		model.setValue(category[3], "20", new Integer(57));
		model.setValue(category[3], "25", new Integer(20));
		model.setValue(category[3], "30", new Integer(74));
	}
}