/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mns
 */
public class ContainsDuplicate {

    public static class Solution {

        public boolean containsNearbyDuplicateNaive(int[] nums, int k) {
            HashMap<Integer, ArrayList<Integer>> numMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (numMap.get(nums[i]) == null) {
                    ArrayList<Integer> newList = new ArrayList<Integer>();
                    newList.add(i);
                    numMap.put(nums[i], newList);
                } else {
                    numMap.get(nums[i]).add(i);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                ArrayList<Integer> values = numMap.get(nums[i]);
                if (values.size() == 1) {
                    continue;
                } else if (values.size() > 1) {
                    for (int j = 0; j < values.size(); j++) {
                        if (values.get(j) != i && Math.abs(i - values.get(j)) <= k) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int pre = map.get(nums[i]);
                    if (i - pre <= k) {
                        return true;
                    }
                }

                map.put(nums[i], i);
            }

            return false;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 2, 8, 2, 2}, 1));

    }
}
