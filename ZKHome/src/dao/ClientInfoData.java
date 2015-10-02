package dao;

import java.util.ArrayList;
import java.util.List;
 
public class ClientInfoData {
     
    private static List<String> clientList = new ArrayList<String>();
     
    static{
    	clientList.add("Profile");
    	clientList.add("Research");
    	clientList.add("Holdings");
    }
     
    public static final List<String> getInfoList() {
        return new ArrayList<String>(clientList);
    }
}
