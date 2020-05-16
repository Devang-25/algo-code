/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author mns
 */
public class ThreeSum {

  public static class Solution {

    public class CustomComparator implements Comparator<List<Integer>> {

      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.containsAll(o2) && o2.containsAll(o1)) {
          return 0;
        } else if (o1.containsAll(o2) && !o2.containsAll(o1)) {
          return 1;
        } else {
          return -1;
        }
      }

    }

    public List<List<Integer>> threeSum(int[] nums) {
      TreeSet<List<Integer>> output = new TreeSet<>(new CustomComparator());
      Arrays.sort(nums);

      for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          int sum = nums[i] + nums[j];
          int complement = Arrays.binarySearch(nums, -sum);
          if (!(complement < 0) && complement != i && complement != j) {

            int[] list = { nums[i], nums[j], nums[complement] };
            Arrays.sort(list);
            output.add(new ArrayList(Arrays.asList(list)));
          }
        }
      }

      ArrayList<List<Integer>> finalList = new ArrayList<>(output);
      return finalList;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] inp = { -1, 0, 1, 2, -1, -4 };
    s.threeSum(inp);
  }
}
