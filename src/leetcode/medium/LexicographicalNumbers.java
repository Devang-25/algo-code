package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mns on 7/5/18.
 */
public class LexicographicalNumbers {
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> result = new ArrayList<>();
//        StringBuilder sb = new StringBuilder(n);
//        for (int i = 1; i <= 9; i++) {
//            sb.append(i);
//            lexUtil(sb, n, result);
//            sb.setLength(sb.length() - 1);
//
//        }
//        return result;
//    }
//
//    private void lexUtil(StringBuilder sb, int n, List<Integer> result) {
//        Integer val = Integer.parseInt(sb.toString());
//        if (val > n) {
//            return;
//        }
//
//        result.add(val);
//        for (int i = 0; i <= 9; i++) {
//            if (sb.length() < String.valueOf(n).length()) {
//                sb.append(i);
//                lexUtil(sb, n, result);
//                sb.setLength(sb.length() - 1);
//            }
//        }
//    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if(i <= n) {
                lexUtil(i, n, result);
            }
        }
        return result;
    }

    private void lexUtil(int curr, int n, List<Integer> result) {
        result.add(curr);
        for (int i = 0; i <= 9; i++) {
            if(curr*10+i <= n){
                lexUtil(curr*10+i,n,result);
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        LexicographicalNumbers l = new LexicographicalNumbers();
        l.lexicalOrder(123).stream().forEach(System.out::println);
    }
}
