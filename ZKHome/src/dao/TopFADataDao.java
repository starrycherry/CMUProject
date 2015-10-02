package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.CurrencyFormatter;

import bean.Asset;
import bean.TopFA;

public class TopFADataDao extends HibernateBaseDao {
	Random call = new Random();  
	private  List<Asset> assets = new ArrayList<Asset>();

	public void saveObject(Object t) {
		this.save(t);
	}

	public  Asset[] getAllAssetsArray() {
		return assets.toArray(new Asset[assets.size()]);
	}

	// This Method only used in "Header and footer" Demo
	public  List<TopFA> getTOPFAByCategory(String category, int manager_id) {
		List<TopFA> someExamples = new ArrayList<TopFA>();
		String[] names = {"Sahil Thakkar", "Prateek Chawla"};
		String[] categories = {"Commissions","Trails","Fees","Directs"};
//		String[] assets = {"Commissions","Trails","Fees","Directs"};
		
		for(int i =0; i<5; i++){
			TopFA fa = new TopFA(true,names[call.nextInt(1)],categories[call.nextInt(3)] , CurrencyFormatter.cashFormat(340000), 
					CurrencyFormatter.cashFormat(call.nextInt(9999)), CurrencyFormatter.cashFormat(call.nextInt(9999)), 
					CurrencyFormatter.cashFormat(call.nextInt(9999)), CurrencyFormatter.cashFormat(call.nextInt(9999)), 
					CurrencyFormatter.cashFormat(call.nextInt(9999)), CurrencyFormatter.cashFormat(call.nextInt(9999))
					);
			someExamples.add(fa);
		}
		return someExamples;
	}




}