package leetcode.medium;

/**
 * Created by mns on 5/18/18.
 */
public class JumpGame {
    public boolean canJump(int [] nums){
        if(nums == null || nums.length == 0){
            return false;
        }

        int maxReachable = 0;
        for(int i=0;i<nums.length;i++){

            if(i > maxReachable){
                return  false;
            }
            maxReachable = Math.max(maxReachable,i+nums[i]);
            if(maxReachable >= nums.length-1){
                return true;
            }
        }
        return false;
    }

    private boolean canJumpUtil(int [] nums, int index){
        if(index == nums.length-1){
            return true;
        }

        if(index >= nums.length || nums[index] == 0){
            return false;
        }

        boolean canReach = false;
        for(int i=1;i<=nums[index];i++){
            canReach = canReach || canJumpUtil(nums,index+i);
        }

        return canReach;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{2,3,1,1,4}));
        System.out.println(jg.canJump(new int[]{3,2,1,0,4}));
        System.out.println(jg.canJump(new int[]{0}));
    }
}
