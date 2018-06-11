package leetcode.medium;

import java.util.Arrays;

public class T3SumClosest {
    public int threeSumClosest(int [] nums, int target){
        Arrays.sort(nums);
        if(nums.length < 3){
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        for(int i=0;i<nums.length - 2;i++){
            int j = i+1, k = nums.length-1;
            while( j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum) < minDiff){
                    minDiff = Math.abs(target-sum);
                    closestSum = sum;
                }

                if(minDiff == 0)
                    return closestSum;

                if(sum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        T3SumClosest tsc = new T3SumClosest();
        System.out.println(tsc.threeSumClosest(new int [] { -1,2,1,-4}, 1));
        System.out.println(tsc.threeSumClosest(new int [] { -1,0,1,-4}, 1));
        System.out.println(tsc.threeSumClosest(new int [] { -1,1,1,-4}, 1));
    }
}
