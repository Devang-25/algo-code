package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }


        Arrays.sort(intervals,new CustomComparator());
        int end = intervals[0].end;
        int cnt = 1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start >= end){
                cnt++;
                end = intervals[i].end;
            }
        }

        return intervals.length-cnt;
    }
    class CustomComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
