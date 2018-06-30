package leetcode.medium;


import java.util.Arrays;
import java.util.HashMap;

public class CombinationSum4 {
    private HashMap<Integer,Integer> dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new HashMap<>();
        dp.put(0,1);
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp.get(target) != null) {
            return dp.get(target);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp.put(target,res);
        return res;
    }


    public static void main(String[] args) {
        CombinationSum4 c = new CombinationSum4();
//        List<List<Integer>> result = c.combine(3, 7);
        System.out.println(c.combinationSum4(new int[]{1, 2, 3}, 32));
    }
}
