package medium;

import java.util.HashMap;

/**
 * Created by mns on 8/10/18.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int presum = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                presum--;
            } else {
                presum++;
            }
            if (map.get(presum) != null) {
                max = Math.max(max, i - map.get(presum));
            }else{
                map.put(presum,i);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        System.out.println(ca.findMaxLength(new int[]{0,1,0}));
        System.out.println(ca.findMaxLength(new int[]{0,1,0,0,1,0,1,0,0,0}));
    }
}
