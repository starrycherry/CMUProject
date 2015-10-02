package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bean.Stream;
 
public class StreamData {
 
    private static List<Stream> Streams = new ArrayList<Stream>();
    static {
        Streams.add(new Stream(0, "<b>Document Due for: </b><a href='http://www.google.com' style='color:blue;text-decoration:underline;'>Andrew Smith - 12345678</a><br />Required by 06/01/2013: <a style='color:blue;text-decoration:underline;'>IRA Adoption Agreement - 1212</a>", "5 minutes ago", true, true, true));
        Streams.add(new Stream(1, "<b>Reports Center is Functioning Normally</b>", "1 hour ago", true, false, false));
        Streams.add(new Stream(2, "<b>ACATS Complete for Account: </b><a style='color:blue;text-decoration:underline;'>Sandy IRA - 10201020</a>", "1 day ago", false, true, false));
        Streams.add(new Stream(3, "<b>Reports Center is down</b>", "2 days ago", true, false, false));
        Streams.add(new Stream(4, "<b>Managers meeting on August 23, 2013</b>", "5 days ago", false, true, false));
        Streams.add(new Stream(5, "<b>Large Cash Deposit: </b><a style='color:blue;text-decoration:underline;'>Mary and John Adams Joint</a>", "5 days ago", false, true, false));
        Streams.add(new Stream(6, "<b>ACATS Complete for Account: </b><a style='color:blue;text-decoration:underline;'>Wonder - 10301025</a>", "6 days ago", true, true, false));
        Streams.add(new Stream(7, "<b>Blackboard will be maintain on next Friday</b>", "6 days ago", false, true, false));
        Streams.add(new Stream(8, "<b>Important Account has been created: </b><a style='color:blue;text-decoration:underline;'>Goldman - 10000010</a>", "1 week ago", true, false, false));
    }
 
    public static List<Stream> getAllStreams() {
        return new ArrayList<Stream>(Streams);
    }
    public static Stream[] getAllStreamsArray() {
        return Streams.toArray(new Stream[Streams.size()]);
    }
 
    public static List<Stream> getStreamsByFavorite() {
        List<Stream> someStreams = new ArrayList<Stream>();
        for (Iterator<Stream> i = Streams.iterator(); i.hasNext();) {
            Stream tmp = i.next();
            if (tmp.getFavorite().equals(true)){
            	someStreams.add(tmp);
            }
        }
        return someStreams;
    }
    
    public static List<Stream> getStreamsByAssign() {
        List<Stream> someStreams = new ArrayList<Stream>();
        for (Iterator<Stream> i = Streams.iterator(); i.hasNext();) {
            Stream tmp = i.next();
            if (tmp.getAssign().equals(true)){
            	someStreams.add(tmp);
            }
        }
        return someStreams;
    }
    
    public static List<Stream> getStreamsByHidden() {
        List<Stream> someStreams = new ArrayList<Stream>();
        for (Iterator<Stream> i = Streams.iterator(); i.hasNext();) {
            Stream tmp = i.next();
            if (tmp.getHidden().equals(true)){
            	someStreams.add(tmp);
            }
        }
        return someStreams;
    }
 
}
