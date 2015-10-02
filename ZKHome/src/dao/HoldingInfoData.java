package dao;

import java.util.ArrayList;
import java.util.List;
 
public class HoldingInfoData {
     
    private static List<String> infoList = new ArrayList<String>();
     
    static{
    	infoList.add("Holding");
    	infoList.add("Research");
    	infoList.add("Clients");
    }
     
    public static final List<String> getInfoList() {
        return new ArrayList<String>(infoList);
    }
}
