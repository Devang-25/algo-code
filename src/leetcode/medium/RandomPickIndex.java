package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
    Random rand = new Random();
    HashMap<Integer,List<Integer>> hmap;
    public RandomPickIndex(int[] nums) {
        hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list= hmap.get(nums[i]);
            if(list == null){
                list = new ArrayList<>();
                hmap.put(nums[i],list);
            }
            list.add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list= hmap.get(target);
        int i=rand.nextInt(list.size());
        return list.get(i);
    }
}
