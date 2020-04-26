package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class T3Sum {

    /**** Time limit exceeded ****/
    public List<List<Integer>> threeSum2(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<String> strResult = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int thirdNum = -(nums[i] + nums[j]);
                Integer index = map.get(thirdNum);
                if (index != null && index > j) {
                    List<String> list = Arrays.asList(nums[i] + "", nums[j] + "", thirdNum + "");
                    Collections.sort(list);
                    strResult.add(String.join(",", list));
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (String s : strResult) {
            String[] numbers = s.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for (String num : numbers) {
                list.add(Integer.parseInt(num));
            }
            result.add(list);
        }
        return result;
    }
    /***************************/

    public List<List<Integer>> threeSum3(int[] nums) {

        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<String> strResult = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if( j > i+1 && nums[j] == nums [j-1])
                    continue;

                int thirdNum = -(nums[i] + nums[j]);
                Integer index = map.get(thirdNum);
                if (index != null && index > j) {
                    List<String> list = Arrays.asList(nums[i] + "", nums[j] + "", thirdNum + "");
                    Collections.sort(list);
                    strResult.add(String.join(",", list));
                }

            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (String s : strResult) {
            String[] numbers = s.split(",");
            ArrayList<Integer> list = new ArrayList<>();
            for (String num : numbers) {
                list.add(Integer.parseInt(num));
            }
            result.add(list);
        }
        return result;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
            for(int j = i+1, k = nums.length-1; j<k;) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;k--;
                    while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
                    while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
                }else if(nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        T3Sum t = new T3Sum();
        List<List<Integer>> result = t.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
