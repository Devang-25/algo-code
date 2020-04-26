/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlesample;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author mns
 */
public class Question2 {

    private static class Solution {

        public int solution(String S) {

            //Splitting on new Line and line breaks
            String textStr[] = S.split("\\r\\n|\\n|\\r");
            Stack<String> stack = new Stack<String>();
            stack.push("/");
            
            int currLevel = 0;
            int totalLength = 0;
            for (int i = 0; i < textStr.length; i++) {
                //System.out.println(textStr[LoudAndRich]);
                int numSpaces = 0;
                for (int j = 0; j < textStr[i].length(); j++) {
                    if (textStr[i].charAt(j) == ' ') {
                        numSpaces++;
                    } else {
                        break;
                    }
                }
                if (numSpaces < currLevel) {
                    stack.pop();
                } else if (numSpaces > currLevel) {
                    if (isDir(textStr[i - 1])) {
                        stack.push(textStr[i - 1].trim()+"/");
                    }
                }
                
                currLevel = numSpaces;
                
                if (textStr[i].endsWith(".gif") || textStr[i].endsWith(".jpeg") || textStr[i].endsWith(".png")) {
                    ArrayList<String> allParents = new ArrayList<String>(stack);
                    int dirLength = 0;
                    for (String dir : allParents) {
                        dirLength = dirLength % 1000000007 + dir.length() % 1000000007;
                    }
                    dirLength = dirLength % 1000000007 + (textStr[i].trim().length()) % 1000000007;
                    totalLength += dirLength % 1000000007;
                }
            }
            
            return totalLength;
            
        }        
        
        public boolean isDir(String S) {
            if (S.indexOf(".") == -1) {
                return true;
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        
        Solution s = new Solution();
        s.solution("sdfsd/sdfdsf");
    }
}
