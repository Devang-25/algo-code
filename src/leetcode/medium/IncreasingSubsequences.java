package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        findSubsequencesUtil(nums, 0, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void findSubsequencesUtil(int[] nums, int index, List<Integer> curr, Set<List<Integer>> result) {

        if (curr.size() >= 2) {
            result.add(new ArrayList<>(curr));
        }

        for (int i = index; i < nums.length; i++) {
            if (curr.size() == 0 || curr.get(curr.size() - 1) <= nums[i]) {
                curr.add(nums[i]);
                findSubsequencesUtil(nums, i+ 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        IncreasingSubsequences is = new IncreasingSubsequences();
        List<List<Integer>> result = is.findSubsequences(new int[]{4, 6, 7, 7});
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
