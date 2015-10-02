package view_model;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import dao.HoldingInfoData;


public class HoldingInfoViewModel {
    private String holdingInfo;
     
    public List<String> getInfoList() {
        return HoldingInfoData.getInfoList();
    }
     
    @Init
    public void init() {
        setHoldingInfo("Holding");
    }
 
    public String getHoldingInfo() {
        return holdingInfo;
    }
     
    public void setHoldingInfo(String holdingInfo) {
        this.holdingInfo = holdingInfo;
    }
}
