/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class MergeIntervals {
	 public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	        ArrayList<Interval> list=new ArrayList<Interval>();
	        if(intervals==null){
	            return list;
	        }
	        if(intervals.size()<2){
	            return intervals;
	        }
	        Comparator<Interval> comp=new Comparator<Interval>(){
	            @Override
	            public int compare(Interval a,Interval b){
	                if(a.start==b.start){
	                    return a.end-b.end;
	                }
	                return a.start-b.start;
	            }
	        };
	        Collections.sort(intervals,comp);
	        list.add(intervals.get(0));
	        for(int i=1;i<intervals.size();i++){
	            if(list.get(list.size()-1).end>=intervals.get(i).start){
	                list.get(list.size()-1).end=Math.max(list.get(list.size()-1).end,intervals.get(i).end);
	            }else{
	                list.add(intervals.get(i));
	            }
	        }
	        return list;
	    }
    
    public static void main(String[] args){
    	MergeIntervals m=new MergeIntervals();
    	ArrayList<Interval> intervals=new ArrayList<Interval>();
    	intervals.add(new Interval(1,4));
    	intervals.add(new Interval(1,4));
    	m.merge(intervals);
    }
}
