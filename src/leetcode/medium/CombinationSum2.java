package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
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
            if( i > index && candidates[i] == candidates[i-1])
                continue;
            curr.add(candidates[i]);
            combinationSumUtil(candidates, target - candidates[i], i+1, curr, result);
            curr.remove(curr.size() - 1);

        }
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
//        List<List<Integer>> result = cs.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> result = cs.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
