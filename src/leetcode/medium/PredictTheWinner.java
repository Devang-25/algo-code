package leetcode.medium;


public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        return util(nums, 0, nums.length-1, true,0,0);
    }

    public boolean util(int [] nums, int l , int r , boolean turn, int p1Total, int p2Total){

        if(l > r){
            return p1Total >= p2Total;
        }

        boolean xWin = false;
        if(turn){
            xWin = util(nums,l+1,r,!turn,p1Total+nums[l],p2Total) || util(nums,l,r-1,!turn,p1Total+nums[r],p2Total);
        }else{
            xWin = util(nums,l+1,r,!turn,p1Total,p2Total+nums[l]) && util(nums,l,r-1,!turn,p1Total,p2Total+nums[r]);
        }

        return xWin;

    }

    public static void main(String[] args) {
        PredictTheWinner ptw = new PredictTheWinner();
        System.out.println(ptw.PredictTheWinner(new int[] {1,5,2}));
        System.out.println(ptw.PredictTheWinner(new int[] {1,5,233,7,3,4}));
        System.out.println(ptw.PredictTheWinner(new int[] {1,5,2}));
    }
}
