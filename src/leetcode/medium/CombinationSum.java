package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumUtil(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSumUtil(int[] candidates,
                                    int target, int index, List<Integer> curr, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }else if(target < 0){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            curr.add(candidates[i]);
            combinationSumUtil(candidates, target - candidates[i], i, curr, result);
            curr.remove(curr.size() - 1);

        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
//        List<List<Integer>> result = cs.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> result = cs.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
