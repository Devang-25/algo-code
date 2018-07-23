package leetcode.hard;

import java.util.TreeMap;

public class MyCalendarThree {

    TreeMap<Integer,Integer> map = null;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int maxOccupancy = 0;
        int total = 0;
        for (int x : map.values()){
            total += x;
            maxOccupancy = Math.max(maxOccupancy,total);
        }
        return maxOccupancy;
    }

    public static void main(String[] args) {
        MyCalendarThree mt = new MyCalendarThree();
        System.out.println(mt.book(10,20));
        System.out.println(mt.book(10,30));
    }
}
