package leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;

public class PlusOne {

    public int [] plusOne(int [] digits){
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int [] res = new int[digits.length+1];
        res[0] =  1;
        return res;
    }

    public int[] plusOne2(int[] digits) {
        if(digits.length == 0){
            return  new int[]{};
        }

        LinkedList<Integer> ll = new LinkedList<>();
        int l = digits.length-1, carry = 1, index = 0;

        for(int i=0;i<digits.length;i++){
            carry += digits[l-i];
            ll.offerFirst(carry%10);
            carry/=10;
        }

        if(carry != 0){
            ll.offerFirst(carry);
        }
        int [] result = new int[ll.size()];
        for(Integer i : ll){
            result[index++] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        PlusOne pone = new PlusOne();
        //Arrays.stream(pone.plusOne(new int[]{9, 9, 9})).forEach(System.out::print);
        //Arrays.stream(pone.plusOne(new int[]{0})).forEach(System.out::print);
        Arrays.stream(pone.plusOne(new int[]{9,8,7,6,5,4})).forEach(System.out::print);
    }
}
