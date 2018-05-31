/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.PriorityQueue;

/**
 *
 * @author sekha
 */
public class MeetingRooms2 {

//  Definition for an interval.
    static public class Interval {

        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class TimeWrapper {
        int time;
        boolean type;

        public TimeWrapper(int t, boolean type) {
            this.time = t;
            this.type = type;
        }
        
        
    }
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        PriorityQueue<TimeWrapper> pq = new PriorityQueue<>( (TimeWrapper a,TimeWrapper b) -> {
            if(a.time == b.time){
                if(a.type){
                    return 1;
                }else{
                    return -1;
                }
            }
            
            return a.time - b.time;
        });
        for(int i=0;i<intervals.length;i++){
            pq.add(new TimeWrapper(intervals[i].start,true));
            pq.add(new TimeWrapper(intervals[i].end, false));
        }
        
        int currOccupiedRooms = 0;
        int maxRooms = 0;
        while(!pq.isEmpty()){
            if(pq.poll().type){
                currOccupiedRooms++;
                maxRooms = Math.max(currOccupiedRooms, maxRooms);
            }else{
                currOccupiedRooms--;
            }
        }
        
        return maxRooms;
    }

    public static void main(String[] args) {
        MeetingRooms2 mr = new MeetingRooms2();
        Interval [] input = new Interval[3];
//        input[0] = new Interval(0,30);
//        input[1] = new Interval(5,10);
//        input[2] = new Interval(15,20);
        
        input[0] = new Interval(2,11);
        input[1] = new Interval(6,16);
        input[2] = new Interval(11,16);
        
        System.out.println(mr.minMeetingRooms(input));
    }
}
