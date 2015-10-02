package view_model;

import java.util.List;

import org.zkoss.bind.annotation.Init;

import dao.ExpertsData;


public class ExpertsViewModel {
    private String expertsView;
     
    public List<String> getInfoList() {
        return ExpertsData.getInfoList();
    }
     
    @Init
    public void init() {
        setExpertsView("Economic Commentary");
    }
 
    public String getExpertsView() {
        return expertsView;
    }
     
    public void setExpertsView(String expertsView) {
        this.expertsView = expertsView;
    }
}
