package leet.apr30day;

public class SingleNumber {
    public int singleNumber(int [] nums) {
        int xor = nums[0];
        for(int i=1;i<nums.length;i++) {
            xor ^= nums[i];
        }

        return xor;
    }

    public static void main(String [] args) {
        SingleNumber s = new SingleNumber();
        System.out.println(s.singleNumber(new int[] {4,1,2,1,2,3,4}));        
    }
}