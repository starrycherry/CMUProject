package action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radio;

import dao.FormsSubmittedData;
import bean.FormsSubmitted;
 
public class FormsSubmittedController extends SelectorComposer<Component> {
    private static final long serialVersionUID = 1L;
 
    private Grid formsSubmittedList;

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        formsSubmittedList = (Grid) comp;
        formsSubmittedList.setModel(new ListModelList<FormsSubmitted>(FormsSubmittedData.getAllFormsSubmitted()));
    }
    
    @Listen("onCheck = #categorySelector")
    public void selectCategory(CheckEvent event) {
        String selectedCategory = ((Radio) event.getTarget()).getLabel();
        ListModel<FormsSubmitted> model = null;
        if (selectedCategory.equals("All")) { 
            model = new ListModelList<FormsSubmitted>(FormsSubmittedData.getAllFormsSubmitted());
        } else if (selectedCategory.equals("Complete")){
            model = new ListModelList<FormsSubmitted>(FormsSubmittedData.getFormsSubmittedByComplete());
        }        else if (selectedCategory.equals("Rejected")){
            model = new ListModelList<FormsSubmitted>(FormsSubmittedData.getFormsSubmittedByRejected());
        }  else if (selectedCategory.equals("In Process")){
            model = new ListModelList<FormsSubmitted>(FormsSubmittedData.getFormsSubmittedByProcess());
        } 
        formsSubmittedList.setModel(model);
    }
    

}
