package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mns on 5/24/18.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {

        if(n < 0){
            return new ArrayList<>();
        }else if(n==0){
            return Arrays.asList(0);
        }


        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('0');
        }
        grayCodeUtil(sb,set,result);
        return result;
    }

    public void grayCodeUtil(StringBuilder sb, HashSet<Integer> set, List<Integer> result){
        int currNum = Integer.parseInt(sb.toString(),2);
        if(result.size() == Math.pow(2,sb.length())){
            return;
        }

        if(!set.contains(currNum)){
            set.add(currNum);
            result.add(currNum);
            for(int i=sb.length()-1;i>=0;i--){
                sb.setCharAt(i,sb.charAt(i) == '0'?'1':'0');
                grayCodeUtil(sb,set,result);
                sb.setCharAt(i,sb.charAt(i) == '0'?'1':'0');
            }
        }
    }

    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        List<Integer> result = gc.grayCode(3);
        for(Integer i : result){
            System.out.println(i);
        }
    }
}
