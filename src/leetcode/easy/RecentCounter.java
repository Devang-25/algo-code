package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q = null;
    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping (int t){
        while(!q.isEmpty() && q.peek() < t - 3000){
            q.poll();
        }
        q.add(t);
        return q.size();
    }


}
