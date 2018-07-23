package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    List<int []> intersects = null;
    List<int []> calendar = null;
    public MyCalendarTwo() {
        intersects = new ArrayList<>();
        calendar = new ArrayList<>();
    }
    public boolean book(int start, int end) {
        for(int [] event : intersects){
            if( Math.max(event[0],start) < Math.min(event[1],end)){
                return false;
            }
        }

        for(int [] event : calendar){
            if( Math.max(event[0],start) < Math.min(event[1],end)){
                intersects.add(new int[]{Math.max(event[0],start), Math.min(event[1],end)});
            }
        }
        calendar.add(new int[]{start,end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo MyCalendar = new MyCalendarTwo();
        System.out.println(MyCalendar.book(10, 20)); // returns true
        System.out.println(MyCalendar.book(50, 60)); // returns true
        System.out.println(MyCalendar.book(10, 40)); // returns true
        System.out.println(MyCalendar.book(5, 15)); // returns false
        System.out.println(MyCalendar.book(5, 10)); // returns true
        System.out.println(MyCalendar.book(25, 55)); // returns true
    }
}
