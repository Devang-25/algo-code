package leetcode.easy;

import java.util.LinkedList;

/**
 * Created by mns on 8/20/18.
 */
public class MovingAverage {
    /** Initialize your data structure here. */
    private int currSum;
    private int size;
    LinkedList<Integer> ll= null;
    public MovingAverage(int size) {
        this.ll = new LinkedList<>();
        this.size = size;
        this.currSum = 0;
    }

    public double next(int val) {
        currSum += val;
        ll.addLast(val);
        if(this.ll.size() > this.size){
            currSum -= ll.removeFirst();
        }

        return ((double)currSum) / ll.size();

    }

    public static void main(String[] args) {
        MovingAverage mv = new MovingAverage(3);
        System.out.println(mv.next(1));
        System.out.println(mv.next(10));
        System.out.println(mv.next(3));
        System.out.println(mv.next(5));
    }
}
