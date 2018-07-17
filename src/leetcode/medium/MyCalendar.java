package leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> floorEntry = map.floorEntry(start);
        Map.Entry<Integer,Integer> ceilingEntry = map.ceilingEntry(start);
        if((floorEntry != null && floorEntry.getValue() > start)
                || (ceilingEntry != null && ceilingEntry.getKey() < end)){
            return false;
        }
        map.put(start,end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar mc = new MyCalendar();
        System.out.println(mc.book(10,20));
        System.out.println(mc.book(15,25));
        System.out.println(mc.book(20,30));
    }
}
