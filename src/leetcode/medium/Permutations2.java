package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mns on 7/10/18.
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] picked = new boolean[nums.length];
        permute(nums, picked, new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, boolean[] picked, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (picked[i] || (i > 0 && nums[i] == nums[i - 1] && !picked[i - 1])) {
                continue;
            }

            picked[i] = true;
            curr.add(nums[i]);
            permute(nums, picked, curr, result);
            picked[i] = false;
            curr.remove(curr.size() - 1);

        }
    }
}
