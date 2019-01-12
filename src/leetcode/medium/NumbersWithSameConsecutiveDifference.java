package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NumbersWithSameConsecutiveDifference {

    public int[] numsSameConsecDiff(int N, int K) {
        if(N == 1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }

        HashSet<Integer> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=9;i++){
            sb.append(i);
            util(N-1,K,sb,result);
            sb.setLength(0);
        }
        int [] res = new int[result.size()];
        int x = 0;
        for(Integer i : result){
            res[x++] = i;
        }

        return res;
    }

    private void util(int n, int k, StringBuilder sb, HashSet<Integer> res){
        if(n == 0){
            res.add(Integer.parseInt(sb.toString()));
            return;
        }

        if(sb.charAt(sb.length()-1) - k >='0'){
            sb.append((char)(sb.charAt(sb.length()-1) - k));
            util(n - 1,k, sb,res );
            sb.setLength(sb.length()-1);
        }
        if(sb.charAt(sb.length()-1) + k <='9' ) {
            sb.append((char)(sb.charAt(sb.length()-1) + k));
            util(n - 1,k, sb,res );
            sb.setLength(sb.length()-1);
        }


    }
    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifference n = new NumbersWithSameConsecutiveDifference();
        System.out.println(Arrays.toString(n.numsSameConsecDiff(3,7)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(2,1)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(5,1)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(5,0)));
        System.out.println(Arrays.toString(n.numsSameConsecDiff(9,1)));
    }
}
