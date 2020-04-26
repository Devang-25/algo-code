/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sekha
 */
public class SplitFibonacci {

    public List<Integer> splitIntoFibonacci(String S) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (S == null || S.trim().isEmpty()) {
            return result;
        }

        splitIntoFibonacciUtil(S, 0, result);
        return result;
    }

    private boolean splitIntoFibonacciUtil(String S, int index, ArrayList<Integer> result) {
        if (index >= S.length()) {
            if (result.size() > 2) {
                return true;
            }
        }

        for (int i = index; i < S.length(); i++) {
            String currString = S.substring(index, i + 1);
            int intVal = 0;
            
            /********* Checks if the current segment is greater than Integer.MAX_VALUE; */
            try {
                intVal = Integer.parseInt(currString);
            } catch (NumberFormatException ne) {
                return false;
            }

            /***** Checks if the current segment starts with 0 *******/
            if (currString.length() >= 2 && currString.startsWith("0")) {
                continue;
            }

            boolean found = false;
            if (result.size() >= 2) {
                int num0 = result.get(result.size() - 1);
                int num1 = result.get(result.size() - 2);
                
                /**** If the current value is greater than previous two values, then adding more digits
                 * will only make it bigger. So we terminate this recursion tree.
                 */
                if (intVal > num0 + num1) {
                    return false;
                } else if (intVal < num0 + num1) {
                    /** This occurs when we have the top 2 numbers 123,456 and the current value is 57.
                     * We don't add it the result just yet. 
                     */
                    continue;
                }
            }

            result.add(intVal);
            found = splitIntoFibonacciUtil(S, index + currString.length(), result);
             /** This helps in terminating early once a valid sequence is found 
              If the question is to find all possible sequences, then we might have 
              * to remove the following if condition**/
            if (found) {
                return true;
            }
            result.remove(result.get(result.size() - 1));   
        }
        return false;
    }

    

    public static void main(String[] args) {
        SplitFibonacci sf = new SplitFibonacci();
        sf.splitIntoFibonacci("123456579").stream().forEach(System.out::println);
        sf.splitIntoFibonacci("11235813").stream().forEach(System.out::println);
        sf.splitIntoFibonacci("0123").stream().forEach(System.out::println);
        sf.splitIntoFibonacci("1101111").stream().forEach(System.out::println);
        sf.splitIntoFibonacci("5511816597").stream().forEach(System.out::println);
        sf.splitIntoFibonacci("214748364721474836422147483641").stream().forEach(System.out::println);
    }
}
