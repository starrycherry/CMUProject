package action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radio;

import dao.ReportData;
import bean.Report;
 
public class PracticeReportController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
 
    private Grid reportList;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        reportList = (Grid) comp;
        reportList.setModel(new ListModelList<Report>(ReportData.getAllReports()));
    }
    
    @Listen("onCheck = #categorySelector")
    public void selectCategory(CheckEvent event) {
        String selectedCategory = ((Radio) event.getTarget()).getLabel();
        ListModel<Report> model = null;
        if (selectedCategory.equals("All")) { 
            model = new ListModelList<Report>(ReportData.getAllReports());
        } else if (selectedCategory.equals("My Favorites")){
            model = new ListModelList<Report>(ReportData.getReportsByFavorite());
        } else if (selectedCategory.equals("Most Popular")){
            model = new ListModelList<Report>(ReportData.getReportsByPopular());
        } 
        reportList.setModel(model);
    }
    

}
