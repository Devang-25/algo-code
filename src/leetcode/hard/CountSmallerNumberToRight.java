package leetcode.hard;

import java.util.*;

public class CountSmallerNumberToRight {
    class Pair {
        int val; int ind;
        Pair(int val, int ind){
            this.val = val;
            this.ind = ind;
        }

        @Override
        public String toString() {
            return this.val+"";
        }
    }
    int [] cnt;
    public List<Integer> countSmaller(int[] nums) {
        cnt = new int [nums.length];
        Pair [] n = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            n[i] = new Pair(nums[i],i);
        }

        mergeSort(n,0,nums.length-1);
        System.out.println(Arrays.toString(n));
        List<Integer> result = new ArrayList<>();
        for(Integer i : cnt){
            result.add(i);
        }
        return result;
    }

    private void mergeSort(Pair[] nums, int left , int right){
        if(left >= right){
            return;
        }


        int mid = (left + right) /2;
        mergeSort(nums,left, mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left, mid, right);
    }

    private void merge(Pair[] nums,int left, int mid, int right){
        Pair [] temp = new Pair[right-left+1];
        int l = left;
        int r = mid+1;
        int i = 0;
        int smallNums = 0;
        while( l <= mid && r <= right){
            if(nums[r].val < nums[l].val){
                smallNums++;
                temp[i++] = nums[r++];
            }else{
                cnt[nums[l].ind]+=smallNums;
                temp[i++] = nums[l++];
            }
        }

        while(l <= mid){
            cnt[nums[l].ind]+=smallNums;
            temp[i++] = nums[l++];
        }
        while(r <= right){
            temp[i++] = nums[r++];
        }
        i = 0;
        for(int j=left; j <= right;j++){
            nums[j] = temp[i++];
        }
    }

    public static void main(String[] args) {
        CountSmallerNumberToRight cnr = new CountSmallerNumberToRight();
        cnr.countSmaller(new int[]{9,8,7,6,5,4,3,2,1}).stream().forEach(a -> System.out.print(a+","));
        cnr.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}).stream().forEach(a -> System.out.print(a+","));
    }

}
