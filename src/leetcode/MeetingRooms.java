/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author mns
 */
public class MeetingRooms {
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
    
    public boolean canAttendMeetings(Interval[] intervals) {
       if(intervals == null || intervals.length == 0){
           return true;
       }
       
       Arrays.sort(intervals,new Comparator<Interval> () {
           @Override
           public int compare(Interval o1, Interval o2) {
               return o1.start - o2.start;
           }
           
       });
       
       int min = intervals[0].end;
       for(int i=1;i<intervals.length;i++){
           if(intervals[i].start <= min){
               return false;
           }
           min = intervals[i].end;
       }
       
       return true;
       
    }
    
    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();
        System.out.println(mr.canAttendMeetings(new Interval [] {new Interval(0,30),
        new Interval(50,150), new Interval(150,150)}));
    }
}
