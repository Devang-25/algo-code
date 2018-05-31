package leetcode.hard;

import java.util.Arrays;

/**
 * Created by mns on 5/18/18.
 */
public class JumpGame2 {
    public int jumpN2(int[] nums) {
        int [] minJumps = new int[nums.length];
        Arrays.fill(minJumps,Integer.MAX_VALUE);

        minJumps[0] = 0;
        int maxReachable = 0;
        for(int i=0;i<nums.length;i++){
            maxReachable = Math.max(maxReachable,i+nums[i]);
            if(i > maxReachable){
                return -1;
            }

            for(int j=1;j<=nums[i] && i+j < nums.length;j++){
                minJumps[i+j] = Math.min(minJumps[i+j],1+minJumps[i]);
            }
        }
        return minJumps[nums.length-1];
    }

    public int jump(int[] nums) {

        int maxReachable = 0;
        int jumps = 0;
        for(int i=0;i<nums.length;i++){
            if(i > maxReachable){
                return -1;
            }
            if(maxReachable >= nums.length-1){
                return jumps;
            }

            if(i+nums[i] > maxReachable){
                jumps++;
                maxReachable = i+nums[i];
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();
        System.out.println(jg.jump(new int[]{2,3,1,1,4}));
        System.out.println(jg.jump(new int[]{4}));
        System.out.println(jg.jump(new int[]{3,2,1,0,1}));
    }
}
