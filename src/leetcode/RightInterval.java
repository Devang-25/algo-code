/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author mns
 */
public class RightInterval {
    public static class Interval {
        int start;
        int end;
        
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e){
            start = s;
            end =e;
        }
        
    }
    
    
    public int[] findRightInterval(Interval [] intervals){
        if(intervals == null || intervals.length == 0){
            return new int[] {};
        }
        
        int [] result = new int[intervals.length];
        HashMap<Interval,Integer> originPositions =  new HashMap<>();
        HashMap<Interval,Integer> finalPositions =  new HashMap<>();
        
        for(int i=0;i<intervals.length;i++){
            originPositions.put(intervals[i], i);
        }
        
        Arrays.sort(intervals, (Interval o1, Interval o2) -> {
            return compare(o1,o2);
        });
        
        for(int i=0;i<intervals.length;i++){
            finalPositions.put(intervals[i], i);
        }
       
        for(int i=0;i<intervals.length;i++){
            System.out.println("(" + intervals[i].start+","+intervals[i].end+")");
        }
        
        for(Interval i : originPositions.keySet()){
            int pos = searchClosest(finalPositions.get(i), intervals);
            if(pos == -1){
                result[originPositions.get(i)] = -1;
            }else{
                result[originPositions.get(i)] = originPositions.get(intervals[pos]);
            }
        }
        
        return result;
        
    }
    
    private int searchClosest(int currIndex, Interval [] intervals){
        
        int rightIndex = -1;
        for(int i=currIndex+1;i<intervals.length;i++){
            if(intervals[i].start >= intervals[currIndex].end){
                rightIndex = i;
                break;
            }
        }
        return rightIndex;
        
    }
    
    private int compare(Interval o1 , Interval o2){
        int diff = o1.start-o2.start;
            if(diff == 0){
                diff = o1.end - o2.end;
                if(diff == 0){
                    return 1;
                }
                return diff;
            }
            return diff;
    }
    
    public int[] findRightInterval2(Interval [] intervals){
        if(intervals == null || intervals.length == 0){
            return new int[] {};
        }
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i].start, i);
        }
        
        int [] result = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            Integer nextRight = map.ceilingKey(intervals[i].end);
            if(nextRight == null){
                result[i] = -1;
            }else{
                result[i] = map.get(nextRight);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        RightInterval r = new RightInterval();
        
        Interval [] intervals = new Interval[] {
          new Interval(7,8),
          new Interval(6,7),
          new Interval(5,6),
          new Interval(2,3),
          new Interval(2,4),
          new Interval(3,4),
          new Interval(4,5),
        };
        
        System.out.println(Arrays.toString(r.findRightInterval2(intervals)));
        
    }
}
