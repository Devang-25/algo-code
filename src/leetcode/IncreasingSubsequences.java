/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sekha
 */
public class IncreasingSubsequences {

    class CArrayList extends ArrayList<Integer> {

        @Override
        public boolean equals(Object o) {
            CArrayList c = (CArrayList) o;
            return Arrays.equals(this.stream().mapToInt(i -> i).toArray(), c.stream().mapToInt(i -> i).toArray());
        }

    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        ArrayList< Set< CArrayList>> dp = new ArrayList<>();
        HashSet<List<Integer>> result = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            HashSet<CArrayList> set = new HashSet<>();
            CArrayList subset = new CArrayList();
            subset.add(nums[i]);
            set.add(subset);
            dp.add(set);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] >= nums[j]) {
                    Set<CArrayList> s1 = dp.get(i);
                    HashSet<CArrayList> subRes = new HashSet<>();
                    for (CArrayList list1 : s1) {
                        CArrayList a = new CArrayList();
                        a.add(nums[j]);
                        a.addAll(list1);
                        subRes.add(a);

                    }

                    dp.get(i).addAll(subRes);
                    result.addAll(subRes);
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        IncreasingSubsequences i = new IncreasingSubsequences();
        List<List<Integer>> result = i.findSubsequences(new int[]{1, 2, 3, 4});
//        List<List<Integer>> result = LoudAndRich.findSubsequences(new int[]{1,2,3,3});
//        List<List<Integer>> result = LoudAndRich.findSubsequences(new int[]{4, 6, 7, 7});

        for (List<Integer> l : result) {
            System.out.print("[");
            for (Integer num : l) {
                System.out.print(num + ",");
            }
            System.out.print("],\n");
        }
    }
}
