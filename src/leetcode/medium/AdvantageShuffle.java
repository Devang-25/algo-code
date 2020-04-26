package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class AdvantageShuffle {
    public int[] advantageCount2(int[] A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] result = new int[B.length];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i : A) {
            pq.add(i);
        }

        Stack<Integer> leftOut = new Stack<>();
        while (!pq.isEmpty()) {
            int top = pq.poll();
            int closest = 0, closestDist = Integer.MAX_VALUE;
            for (int i = 0; i < B.length; i++) {
                if (B[i] < top && top - B[i] < closestDist && result[i] == Integer.MIN_VALUE) {
                    closestDist = top - B[i];
                    closest = i;
                }
            }
            if (closestDist == Integer.MAX_VALUE) {
                leftOut.push(top);
            } else {
                result[closest] = top;
            }
        }

        for (int i = 0; i < B.length && !leftOut.isEmpty(); i++) {
            if (result[i] == Integer.MIN_VALUE) {
                result[i] = leftOut.pop();
            }
        }

        return result;
    }

    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Arrays.sort(A);
        for(int i=0;i<B.length;i++){
            pq.add(new int[]{B[i],i});
        }

        int [] result = new int[B.length];
        int high = A.length-1, low = 0;
        while(!pq.isEmpty()){
            int [] top = pq.poll();
            if(A[high] > top[0]){
                result[top[1]] = A[high--];
            }else{
                result[top[1]] = A[low++];
            }
        }

        return result;

    }


    public static void main(String[] args) {
        AdvantageShuffle as = new AdvantageShuffle();
        Arrays.stream(as.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})).forEach(System.out::println);
        Arrays.stream(as.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})).forEach(System.out::println);
        Arrays.stream(as.advantageCount(new int[]{2,0,4,1,2}, new int[]{1,3,0,0,2})).forEach(System.out::println);
    }
}
