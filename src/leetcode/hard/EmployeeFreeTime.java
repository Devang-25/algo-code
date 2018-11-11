package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if(schedule == null || schedule.size() == 0){
            return new ArrayList<Interval>();
        }

        List<Interval> result = new ArrayList<>();
        List<Interval> list = new ArrayList<>();
        for(List<Interval> l : schedule){
            for(Interval i : l){
                list.add(i);
            }
        }

        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval a, Interval b){
                if(a.start != b.start){
                    return Integer.compare(a.start,b.start);
                }else {
                    return Integer.compare(a.end,b.end);
                }
            }
        });

        int max = list.get(0).end;
        for(int i=1;i<list.size();i++){
            if(list.get(i).start > max){
                result.add(new Interval(max, list.get(i).start));
            }
            max = Math.max(max,list.get(i).end);
        }

        return result;
    }
}
