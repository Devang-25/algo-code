package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sekharan on 3/10/17.
 */
public class SearchRotated {

    public int search(int[] nums, int target) {
        int pos = -1;
        if (nums.length > 0) {

            int pivot = findPivot(nums);
            //System.out.println(pivot);
            if (target >= nums[pivot] && target <= nums[nums.length-1]) {
                pos = Arrays.binarySearch(nums, pivot, nums.length, target);
            } else {
                pos = Arrays.binarySearch(nums, 0, pivot, target);
            }
            return pos < 0 ? -1 : pos;
        }
        return pos;
    }

    public int findPivot(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        SearchRotated sr = new SearchRotated();
        System.out.println(sr.search(new int[]{5,1,3}, 1));
        System.out.println(sr.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(sr.search(new int[]{4,5,6,7,0,1,2}, 4));
        System.out.println(sr.search(new int[]{4,5,6,7,0,1,2}, 2));
        System.out.println(sr.search(new int[]{4,5,6,7,0,1,2}, 7));
    }
}
