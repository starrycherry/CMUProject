package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.FormsSubmitted;
 
public class FormsSubmittedData {
 
    private static List<FormsSubmitted> formsSubmitted = new ArrayList<FormsSubmitted>();
    static {
        formsSubmitted.add(new FormsSubmitted("1212", "Account Information and Client Agreement", "Y", "N", "N", "11121212", "07/01/2013"));
        formsSubmitted.add(new FormsSubmitted("1000", "IRA/ SEP Distribution Request", "Y","N","N","23123232","07/20/2013"));
        formsSubmitted.add(new FormsSubmitted("1460", "Ambassador Non-Discretionary Contract", "N","Y","N","23456545","07/23/2013"));
        formsSubmitted.add(new FormsSubmitted("1454", "Book Entry (DRS/DRY) Transfer Request Form", "N","Y","N","12121212","07/31/2013"));
        formsSubmitted.add(new FormsSubmitted("1407", "Client Account Transfer Instruction (In-Kind) Form","N","N", "Y","34343434","08/01/2013"));
    }
 
    public static List<FormsSubmitted> getAllFormsSubmitted() {
        return new ArrayList<FormsSubmitted>(formsSubmitted);
    }
    public static FormsSubmitted[] getAllFormsSubmittedArray() {
        return formsSubmitted.toArray(new FormsSubmitted[formsSubmitted.size()]);
    }
 
    public static List<FormsSubmitted> getFormsSubmittedByComplete() {
        List<FormsSubmitted> someformsSubmitted = new ArrayList<FormsSubmitted>();
        for (Iterator<FormsSubmitted> i = formsSubmitted.iterator(); i.hasNext();) {
            FormsSubmitted tmp = i.next();
            if (tmp.getComplete().equals("Y")){
            	someformsSubmitted.add(tmp);
            }
        }
        return someformsSubmitted;
    }
    
    public static List<FormsSubmitted> getFormsSubmittedByProcess() {
        List<FormsSubmitted> someformsSubmitted = new ArrayList<FormsSubmitted>();
        for (Iterator<FormsSubmitted> i = formsSubmitted.iterator(); i.hasNext();) {
            FormsSubmitted tmp = i.next();
            if (tmp.getProcess().equals("Y")){
            	someformsSubmitted.add(tmp);
            }
        }
        return someformsSubmitted;
    }
    
    public static List<FormsSubmitted> getFormsSubmittedByRejected() {
        List<FormsSubmitted> someformsSubmitted = new ArrayList<FormsSubmitted>();
        for (Iterator<FormsSubmitted> i = formsSubmitted.iterator(); i.hasNext();) {
            FormsSubmitted tmp = i.next();
            if (tmp.getRejected().equals("Y")){
            	someformsSubmitted.add(tmp);
            }
        }
        return someformsSubmitted;
    }
   
 
}