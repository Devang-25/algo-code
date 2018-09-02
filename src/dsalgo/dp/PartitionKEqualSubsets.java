package dp;

/**
 * Created by mns on 8/10/18.
 */
public class PartitionKEqualSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean [] taken = new boolean[nums.length];
        int sum = 0;
        for(Integer i : nums){
            sum += i;
        }
        if( ((double)sum / k) - Math.floor(((double)sum)/k) != 0){
            return false;
        }

        return util(0,0,nums,taken,sum/k,k);

    }

    private boolean util(int index, int currSum, int [] nums, boolean [] taken, int sum, int k){
        if(k==1){
            return true;
        }
        if(currSum == sum){
            if(k <= 0){
                return false;
            }else{
                return util(0,0,nums,taken,sum,k-1);
            }
        }
        for(int i=index;i<nums.length;i++){
            if(!taken[i]){
                taken[i] = true;
                if(util(i+1,currSum+nums[i],nums,taken,sum,k)){
                    return true;
                }
                taken[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionKEqualSubsets pk = new PartitionKEqualSubsets();
        System.out.println(pk.canPartitionKSubsets(new int[]{1,2,3,4,5},3));
    }
}
