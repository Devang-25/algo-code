/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class Intersection2Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> intersect = new HashSet<>();
        HashSet<Integer> intersect2 = new HashSet<>();
        for (int num : nums1) {
            intersect.add(num);
        }

        for (int num : nums2) {
            if (intersect.contains(num)) {
                intersect2.add(num);
            }
        }

        return intersect2.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> intersect = new HashSet<>();
        for (int num : nums1) {
            intersect.add(num);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (intersect.contains(num)) {
                result.add(num);
                intersect.remove(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> result = new ArrayList<>();
        int n1 = 0, n2 = 0, index = 0;

        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] < nums2[n2]) {
                n1++;
            } else if (nums1[n1] > nums2[n2]) {
                n2++;
            } else {
                if (index > 0) {
                   if(result.get(index-1) != nums1[n1]){
                       result.add(nums1[n1]);
                       index++;
                   }
                } else {
                   result.add(nums1[n1]);
                   index++;
                }
                n1++;
                n2++;
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection4(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<>();
        int i=0,j=0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                while( i < nums1.length && nums1[i] == nums2[j]){
                    i++;
                }
                j++;

            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }

        int [] ret = new int[result.size()];
        for(int k=0;k<ret.length;k++){
            ret[k] = result.get(k);
        }

        return ret;
    }


}
