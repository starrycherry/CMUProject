package view_model;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import dao.ClientInfoData;


public class ClientInfoViewModel {
    private String clientInfo;
     
    public List<String> getInfoList() {
        return ClientInfoData.getInfoList();
    }
     
    @Init
    public void init() {
        setClientInfo("Profile");
    }
 
    public String getClientInfo() {
        return clientInfo;
    }
     
    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }
}
