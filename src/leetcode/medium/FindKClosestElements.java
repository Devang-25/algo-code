package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x){
        if(arr == null || arr.length < k){
            return null;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length-1;
        int ind = 0;
        while(left < right){
            int mid = (left+right)/2;
            if(arr[mid] == x){
                right = mid;
                break;
            }else if(arr[mid] > x){
                right = mid-1;
            }else{
                left = mid-1;
            }
        }

        int l = right;
        int r = right+1;

        while(k>0){
            if(r >= arr.length || (l >=0 && x-arr[l] <= arr[r]-x )){
                l--;
            }else{
                r++;
            }
            k--;
        }
        List<Integer> list =new ArrayList<>();
        for(int i = l+1; i < r; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        FindKClosestElements k = new FindKClosestElements();
        System.out.println(k.findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }
}
