package leetcode.medium;


import java.util.Iterator;
import java.util.TreeSet;

public class ExamRoom {
    private TreeSet<Integer> set;
    int maxCapacity;

    public ExamRoom(int N) {
        set = new TreeSet<>();
        this.maxCapacity = N;
    }

    public int seat() {
        if (set.size() == 0) {
            set.add(0);
            return 0;
        } else {
            Iterator<Integer> iter = set.iterator();
            int first = iter.next();
            int second;
            int maxDist = first, position = 0;
            while(iter.hasNext()){
                second = iter.next();
                if(maxDist < (second-first)/2){
                    maxDist = (second-first)/2;
                    position = first + maxDist;
                }
                first = second;
            }


            int last = set.last();
            if(maxCapacity-last-1 > maxDist){
                position = maxCapacity-last-1;
            }

            set.add(position);
            return position;
        }
    }

    public void leave(int p) {
        set.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom er = new ExamRoom(10);
//        System.out.println(er.seat());
//        System.out.println(er.seat());
//        System.out.println(er.seat());
//        System.out.println(er.seat());
//        er.leave(0);
//        er.leave(4);
//        System.out.println(er.seat());

        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());
        System.out.println(er.seat());




    }
}
