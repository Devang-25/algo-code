package easy;

import java.util.HashMap;

/**
 * Created by mns on 7/12/18.
 */
public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        int result = 0;
        for(Integer i : map.keySet()){
            if(k !=0 && map.containsKey(i-k) || (k==0 && map.get(i) > 1)){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KDiffPairs kd = new KDiffPairs();
        System.out.println(kd.findPairs(new int[]{1, 3, 1, 5, 4},0));
        System.out.println(kd.findPairs(new int[]{3, 1, 4, 1, 5},2));
        System.out.println(kd.findPairs(new int[]{1, 2, 3, 4, 5},1));
    }
}
