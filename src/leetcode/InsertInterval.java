/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author mns
 */
public class InsertInterval {
     public static class Interval {
        int start;
        int end;
        Interval(){
            start = 0;
            end = 0;
        }
        
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
     
   public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        if(intervals == null){
            return result;
        }
        
        if(newInterval == null){
            return intervals;
        }
        
        boolean inserted = false;
        for(Interval i : intervals){
            if(i.end < newInterval.start){
                result.add(i);
            }else{
                //Comes before it
                if(newInterval.end < i.start){
                    if(!inserted){
                        result.add(newInterval);
                        inserted = true;
                    }
                    result.add(i);
                }else{
                    newInterval.start = Math.min(newInterval.start, i.start);
                    newInterval.end = Math.max(newInterval.end, i.end);
                }
            }
        }
        
        if(!inserted){
            result.add(newInterval);
        }
        
        return result;
    }
   
    public static void main(String[] args) {
        
        InsertInterval ii = new InsertInterval();
//        List<Interval> result = ii.insert(Arrays.asList(new Interval(1,2), new Interval(3,5)
//        ,new Interval(6,7),new Interval(8,10), new Interval(12,16)), new Interval(4,9));
        
          List<Interval> result = ii.insert(Arrays.asList(new Interval(1,3), new Interval(4,6)
          ,new Interval(8,9),new Interval(11,13), new Interval(14,15)), new Interval(1,100));

        for(Interval i : result){
            System.out.println(i.start + "," + i.end);
        }
    }
    
}
