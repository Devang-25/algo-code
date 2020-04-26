package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by mns on 7/10/18.
 */
public class SmallestRange {
    class Element {
        int val,lid,pos;
        Element(int val, int lid, int pos){
            this.val = val;
            this.lid = lid;
            this.pos = pos;
        }
    }
    public int [] smallestRange(List<List<Integer>> nums){
        int maxInQueue = Integer.MIN_VALUE;
        int minLength;
        int [] result = new int[2];
        PriorityQueue<Element> pq = new PriorityQueue<>( (a,b) -> a.val-b.val);
        for(int i=0;i<nums.size();i++){
            int firstNum = nums.get(i).get(0);
            if(firstNum >= maxInQueue){
                maxInQueue = firstNum;
            }
            pq.add(new Element(firstNum,i,0));
        }

        minLength = Math.abs(pq.peek().val - maxInQueue);
        result[0] = pq.peek().val;
        result[1] = maxInQueue;

        while(true){
            Element min = pq.poll();
            if(min.pos == nums.get(min.lid).size()-1 || minLength == 0){
                break;
            }
            int nextNum = nums.get(min.lid).get(min.pos+1);
            pq.add(new Element(nextNum, min.lid,min.pos+1));
            maxInQueue = Math.max(maxInQueue,nextNum);

            if(minLength > Math.abs(pq.peek().val - maxInQueue)){
                minLength= Math.abs(pq.peek().val - maxInQueue);
                result[0] = pq.peek().val;
                result[1] = maxInQueue;
            }

        }

        return result;

    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(Arrays.asList(4,10,15,24,26));
        l.add(Arrays.asList(0,9,12,20));
        l.add(Arrays.asList(5,18,22,30));

        SmallestRange sr = new SmallestRange();
        Arrays.stream(sr.smallestRange(l)).forEach(System.out::println);
    }
}
