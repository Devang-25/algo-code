package dsalgo.dp;

/**
 * Created by mns on 5/16/18.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return false;
        }

        int []  sumSoFar = new int[nums.length];
        sumSoFar[0] = nums[0];
        for(int i=1;i<sumSoFar.length;i++){
            sumSoFar[i] = nums[i]+sumSoFar[i-1];
        }

        for(int i=0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(k==0){
                    if(sumSoFar[j] - sumSoFar[i] == 0){
                        return true;
                    }
                }
                else if((sumSoFar[j]-sumSoFar[i]) % k ==0){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum css = new ContinuousSubarraySum();
        System.out.println(css.checkSubarraySum(new int[]{23,2,6,4,7} , 6));
        System.out.println(css.checkSubarraySum(new int[]{23,-23,6,4,7} , 8));
    }

}
