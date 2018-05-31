/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mns
 */
public class MergeIntervals {
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
    
    public List<Interval> merge (List<Interval> intervals){
        
        LinkedList<Interval> result = new LinkedList<>();
        if(intervals == null || intervals.size() == 0){
            return result;
        }
        ArrayList<Interval> intervalsCopy = new ArrayList<>(intervals);
        Collections.sort(intervalsCopy, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        int currentIndex = 0;
        for(Interval i : intervalsCopy){
            Interval lastInterval = result.peekLast();
            if(lastInterval == null){
                result.addLast(i);
            }else{
                if( lastInterval.end >= i.start){
                    result.pollLast();
                    result.addLast(new Interval(lastInterval.start,Math.max(lastInterval.end, i.end)));
                }else{
                    result.addLast(i);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
//        List<Interval> result = mi.merge(Arrays.asList(new Interval(1,3), new Interval(2,6)
//        ,new Interval(8,10),new Interval(15,18)));
//        
        
//        List<Interval> result = mi.merge(Arrays.asList(new Interval(1,2), new Interval(2,3)
//        ,new Interval(3,4),new Interval(4,5)));
  

        List<Interval> result = mi.merge(Arrays.asList(new Interval(1,2), new Interval(4,5)
        ,new Interval(3,4),new Interval(10,11)));
        
        for(Interval i : result){
            System.out.println(i.start + "," + i.end);
        }
    }
}
