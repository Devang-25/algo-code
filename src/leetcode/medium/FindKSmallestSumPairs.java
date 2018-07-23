package leetcode.medium;

import java.util.*;

public class FindKSmallestSumPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int []> result = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0){
            return result;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (nums1[a[0]] + nums2[a[1]])));
        for(int i=0;i<nums1.length;i++){
            pq.add(new int[]{i,0});
        }

        while(!pq.isEmpty() && result.size() < k){
            int [] top = pq.poll();
            result.add(new int[]{nums1[top[0]],nums2[top[1]]});
            if(top[1] < nums2.length-1){
                pq.add(new int[]{top[0],top[1]+1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindKSmallestSumPairs fs = new FindKSmallestSumPairs();
        List<int[]> result = fs.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6},3);
        for(int [] i : result){
            System.out.println(Arrays.toString(i));
        }
    }
}
