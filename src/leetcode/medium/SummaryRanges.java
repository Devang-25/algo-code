/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sekha
 */
public class SummaryRanges {

    public List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length > 0) {
            StringBuilder sb = new StringBuilder();
            String append = "";
            for (int i = 0; i < nums.length; i++) {
                if (sb.length() == 0) {
                    sb.append(nums[i]);
                } else {
                    if (nums[i] == nums[i - 1] + 1) {
                        append = "->" + nums[i];
                    } else {
                        sb.append(append);
                        append = "";
                        result.add(sb.toString());
                        sb.setLength(0);
                        sb.append(nums[i]);
                    }
                }
            }
            result.add(sb.append(append).toString());
        }
        return result;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length > 0) {
            int start = nums[0];
            int end = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1] + 1) {
                    end = nums[i - 1];
                    if (start == end) {
                        result.add(String.valueOf(start));
                    } else {
                        result.add(start + "->" + end);
                    }
                    start = nums[i];
                }
                end = nums[i];

            }

            if (start == end) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + end);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
//        sr.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}).stream().forEach(System.out::println);
//        sr.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).stream().forEach(System.out::println);
        sr.summaryRanges(new int[]{}).stream().forEach(System.out::println);
    }
}
