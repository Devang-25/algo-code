/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mns
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutationList = new ArrayList<>();
        Arrays.sort(nums);
        permuteUtil(nums, new ArrayList<>(), permutationList);
        return permutationList;
    }

    private void permuteUtil(int[] nums, ArrayList<Integer> currList, List<List<Integer>> permutationList) {
        if (currList.size() == nums.length) {
            permutationList.add(new ArrayList<>(currList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(!currList.contains(nums[i])){
                    currList.add(nums[i]);
                    permuteUtil(nums,currList, permutationList);
                    currList.remove(currList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        List<List<Integer>> permutationList = (p.permute(new int[]{3, 2, 1,4}));
        for (List<Integer> list : permutationList) {
            System.out.println("");
            for (Integer i : list) {
                System.out.print(String.format("%d,", i));
            }
        }
    }
}
