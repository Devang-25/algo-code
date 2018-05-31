/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mns
 */
public class SummaryRanges {
    
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
    
    TreeMap<Integer,Integer> map = null;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.isEmpty()){
            map.put(val, val);
        }
        if(!map.containsKey(val)){
            Map.Entry<Integer,Integer> floorEntry = map.floorEntry(val);
            Map.Entry<Integer,Integer> ceilEntry = map.ceilingEntry(val);
            
            int start = val;
            int end = val;
            
            if(floorEntry != null && ceilEntry!= null && floorEntry.getValue() == val-1 && ceilEntry.getKey() == val+1){
                start = floorEntry.getKey();
                end = ceilEntry.getValue();
                map.remove(floorEntry.getKey());
                map.remove(ceilEntry.getKey());
                
            }else if(floorEntry != null && floorEntry.getValue() == val-1){
                start = floorEntry.getKey();
                map.remove(floorEntry.getKey());
            }else if(ceilEntry != null && ceilEntry.getKey() == val+1){
                end = ceilEntry.getValue();
                map.remove(ceilEntry.getKey());
            }
            
            if(!contains(floorEntry,val) && !contains(ceilEntry,val)){
                map.put(start, end);
            }
            
        }
        
        //printIntervals();
    }
    
    public boolean contains(Map.Entry<Integer,Integer> entry, int val){
        if(entry != null){
            return val>= entry.getKey() && val<=entry.getValue();
        }
        return false;
    }
    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : this.map.entrySet()){
            list.add(new Interval(entry.getKey(),entry.getValue()));
        }
        
        return list;
    }
    
    public void printIntervals(){
        List<Interval> list = this.getIntervals();
        for(Interval i : list){
            System.out.print("[" +i.start + ","+ i.end + "]" + "  ,  ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(0);
        sr.addNum(1);
        sr.addNum(3);
        sr.addNum(7);
        sr.addNum(2);
        sr.addNum(6);
        sr.addNum(8);
        sr.addNum(5);
        sr.addNum(4);
        sr.addNum(4);
    }
}
