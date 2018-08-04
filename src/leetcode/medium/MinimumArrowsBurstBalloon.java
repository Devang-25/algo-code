package leetcode.medium;

import java.util.PriorityQueue;

public class MinimumArrowsBurstBalloon {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }

        PriorityQueue<int []> pq = new PriorityQueue<>( (a,b) -> a[0]-b[0]);
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
        }

        int minArrows = 0;
        long left = Long.MIN_VALUE, right = Long.MIN_VALUE;

        while(!pq.isEmpty()){
            int [] top = pq.poll();
            if(top[0] > right){
                minArrows++;
                left = top[0];
                right = top[1];
            }else{
                left = Math.min(left,top[0]);
                right = Math.min(right,top[1]);
            }
        }

        return minArrows;

    }

    public static void main(String[] args) {
        MinimumArrowsBurstBalloon mab = new MinimumArrowsBurstBalloon();
        System.out.println(mab.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(mab.findMinArrowShots(new int[][]{{1,2},{2,3}}));
    }
}
