package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mns on 5/9/18.
 */
public class Intersection2Arrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int []{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while( i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;j++;
            }else if(nums1[i] > nums2[j] ){
                j++;
            }else{
                i++;
            }
        }

        int [] ret = new int [result.size()];
        for(int k = 0;k<ret.length;k++){
            ret[k] = result.get(k);
        }

        return ret;
    }


    public static void main(String[] args) {
        Intersection2Arrays2 i = new Intersection2Arrays2();
        Arrays.stream(i.intersect(new int[]{1, 2, 2, 1}, new int[]{1, 4, 2, 1, 2})).forEach(System.out::println);
    }
}
