package leetcode.hard;

import java.util.HashSet;

public class BurstBalloons {
    public int maxCoins2(int [] nums){
        HashSet<Integer> taken = new HashSet<>();
        return maxCoinsUtil(nums, taken);
    }

    private int maxCoinsUtil(int [] nums, HashSet<Integer> taken){
        if(taken.size() == nums.length){
            return 0;
        }

        int maxCoins = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(!taken.contains(i)){
                int l = i-1, r = i+1;
                while(l >=0 && taken.contains(l)) l--;
                while(r < nums.length && taken.contains(r)) r++;
                taken.add(i);
                maxCoins = Math.max(maxCoins, (l <0? 1 : nums[l])* nums[i] * (r>=nums.length?1: nums[r]) + maxCoinsUtil(nums,taken));
                taken.remove(i);
            }
        }

        return maxCoins;
    }

    public int maxCoins(int [] nums){

        int [] nums2 = new int[nums.length+2];
        int [][] mem = new int[nums.length+2][nums.length+2];
        int n = 1;
        for(int x : nums){
            nums2[n++] = x;
        }
        nums2[0] =nums2[nums2.length-1] = 1;
        return util(nums2, mem, 0, nums2.length-1);
    }

    private int util(int [] nums, int [][] mem , int left , int right){
        if(left > right){
            return 0;
        }
        if(mem [left][right] !=0){
            return mem[left][right];
        }

        int max = 0;
        for(int i=left+1;i<right;i++){
            max = Math.max(max, util(nums,mem, left, i) + (nums[left]*nums[i]*nums[right]) + util(nums,mem,i,right));
        }

        mem[left][right] = max;
        return max;
    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.maxCoins(new int[] {3,1,5,8}));
        System.out.println(bb.maxCoins(new int[] {1,2}));
    }
}
