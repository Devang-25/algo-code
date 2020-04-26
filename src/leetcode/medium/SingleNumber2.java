package leetcode.medium;

import java.util.Arrays;

public class SingleNumber2 {
    public int [] singleNumber(int [] nums){
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }

        int setBit = xor & -xor;
        int [] result = new int [2];
        for(int i :  nums){
            if((i & setBit) == 0){
                result[0] ^= i;
            }else{
                result[1] ^= i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber2 s2 = new SingleNumber2();
        System.out.println(Arrays.toString(s2.singleNumber(new int[] {1,2,2,3,3,5})));
    }
}
