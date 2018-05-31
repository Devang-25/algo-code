/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlesample;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mns
 */
public class Question1 {

    private static class Solution {

        int solution(int X) {
            String xs = Integer.toString(X);
            //System.out.println(xs);
            ArrayList<Integer> allNums = new ArrayList<Integer>();
            for (int i = 0; i < xs.length() - 1; i++) {
                StringBuffer sb = new StringBuffer(xs);
                int j = i + 1;
                if (xs.charAt(i) > xs.charAt(j)) {
                    sb.deleteCharAt(j);
                } else {
                    sb.deleteCharAt(i);
                }
                allNums.add(Integer.parseInt(sb.toString()));

            }
            //System.out.println(allNums.toString());
            return Collections.min(allNums);
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(233614));
    }

}
