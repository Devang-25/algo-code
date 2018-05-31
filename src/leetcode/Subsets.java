package leetcode;

import java.util.*;

/**
 * Created by mns on 12/24/17.
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(nums);
        util(result,stack,0,nums);

        return result;
    }

    private void util(List<List<Integer> > result, ArrayDeque<Integer> stack, int currentIndex, int [] nums ) {
        result.add(new ArrayList<>(stack));
        for (int i = currentIndex; i < nums.length; i++) {
            stack.push(nums[i]);
            util(result, stack, i + 1, nums);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        s.subsets(new int[] {1,2,3,4});
    }

}
