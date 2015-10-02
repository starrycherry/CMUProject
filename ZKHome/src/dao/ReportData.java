package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Report;
 
public class ReportData {
 
    private static List<Report> reports = new ArrayList<Report>();
    static {
        reports.add(new Report("Account Activity - Non-Trade", "07/01/2013", "Y", "Y"));
        reports.add(new Report("Assets by Account Type", "07/03/2013", "Y", "N"));
        reports.add(new Report("Assets by Fund Family", "07/01/2013", "N", "Y"));
        reports.add(new Report("Client Segmentation - Accounts", "07/02/2013", "N", "N"));
        reports.add(new Report("Client Segmentation - Relationships", "07/01/2013", "Y", "N"));
        reports.add(new Report("FA Standing", "07/02/2013", "Y", "N"));
        reports.add(new Report("My favorite report", "07/09/2013", "N", "Y"));
    }
 
    public static List<Report> getAllReports() {
        return new ArrayList<Report>(reports);
    }
    public static Report[] getAllReportsArray() {
        return reports.toArray(new Report[reports.size()]);
    }
 
    public static List<Report> getReportsByFavorite() {
        List<Report> somereports = new ArrayList<Report>();
        for (Iterator<Report> i = reports.iterator(); i.hasNext();) {
            Report tmp = i.next();
            if (tmp.getFavorite().equals("Y")){
            	somereports.add(tmp);
            }
        }
        return somereports;
    }
    
    public static List<Report> getReportsByPopular() {
        List<Report> somereports = new ArrayList<Report>();
        for (Iterator<Report> i = reports.iterator(); i.hasNext();) {
            Report tmp = i.next();
            if (tmp.getPopular().equals("Y")){
            	somereports.add(tmp);
            }
        }
        return somereports;
    }
 
}