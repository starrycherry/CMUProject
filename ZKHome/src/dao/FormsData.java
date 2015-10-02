package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Forms;
 
public class FormsData {
 
    private static List<Forms> forms = new ArrayList<Forms>();
    static {
        forms.add(new Forms("1212", "Account Information and Client Agreement", "Y"));
        forms.add(new Forms("1000", "IRA/ SEP Distribution Request", "Y"));
        forms.add(new Forms("1460", "Ambassador Non-Discretionary Contract", "N"));
        forms.add(new Forms("1454", "Book Entry (DRS/DRY) Transfer Request Form", "N"));
        forms.add(new Forms("1407", "Client Account Transfer Instruction (In-Kind) Form", "Y"));
    }
 
    public static List<Forms> getAllForms() {
        return new ArrayList<Forms>(forms);
    }
    public static Forms[] getAllFormsArray() {
        return forms.toArray(new Forms[forms.size()]);
    }
 
    public static List<Forms> getFormsByFavorite() {
        List<Forms> someforms = new ArrayList<Forms>();
        for (Iterator<Forms> i = forms.iterator(); i.hasNext();) {
            Forms tmp = i.next();
            if (tmp.getFavorite().equals("Y")){
            	someforms.add(tmp);
            }
        }
        return someforms;
    }
   
 
}