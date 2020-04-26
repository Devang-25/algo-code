package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mns on 10/10/18.
 */
public class AddBoldTag {
    class Interval {
        int start, end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        Interval(){

        }

        public Interval (Interval i){
            this.start = i.start;
            this.end = i.end;
        }

        @Override
        public String toString() {
            return this.start + "->" + this.end;
        }
    }

    public String addBoldTag(String s, String[] dict) {
        ArrayList<Interval> intervals = new ArrayList<>();
        for (String st : dict) {
            int i = s.indexOf(st);;
            do {
                if (i >= 0) {
                    intervals.add(new Interval(i, i + st.length() - 1));
                }
                i = s.indexOf(st,i+1);
            }while(i >=0 && i < s.length());
        }

        Collections.sort(intervals, (Interval o1, Interval o2) -> {
            if (o1.start == o2.start) {
                return Integer.compare(o1.end, o2.end);
            }
            return Integer.compare(o1.start, o2.start);
        });

        ArrayList<Interval> merged = new ArrayList<>();
        if(intervals.size() > 0){
            Interval curr = new Interval(intervals.get(0));
            for(int i=1;i<intervals.size();i++){
                if(curr.end >= intervals.get(i).start-1){
                    curr.end = Math.max(curr.end, intervals.get(i).end);
                }else{
                    merged.add(curr);
                    curr = new Interval(intervals.get(i));
                }
            }
            merged.add(curr);

            StringBuilder sb = new StringBuilder(s);
            int offset = 0;
            for(Interval i : merged){
                sb.insert(i.start+offset,"<b>");
                offset+=3;
                sb.insert(i.end+offset+1,"</b>");
                offset+=4;
            }

            return sb.toString();
        }else{
            return s;
        }

    }

    public static void main(String[] args) {
        AddBoldTag abt = new AddBoldTag();
        System.out.println(abt.addBoldTag("aaaaaabbcc", new String[]{"aaa","aab","bc"}));
    }
}
