package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper){
        List<String> res = new ArrayList<>();
        long low = (long)lower;
        long high = (long)lower;

        for(int i=0;i<=nums.length;i++){
            low = i==0?low:(long)nums[i-1]+1;
            high = i==nums.length?(long)upper:(long)nums[i]-1;

            if(low==high) res.add(low+"");
            if(low<high) res.add(low+"->"+high);
        }
        return res;
    }

    public static void main(String[] args) {
        MissingRanges mr = new MissingRanges();
        mr.findMissingRanges(new int[]{0,1,3,50,75},0,99).stream().forEach(System.out::println);
    }
}
