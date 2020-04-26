/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author mns
 */
public class ValidParenthesis {

    static class Solution {

        public boolean isValid(String s) {

            if (s.isEmpty() || s.length() == 0) {
                return true;
            }

            HashMap<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');

            Stack<Character> stack = new Stack<Character>();

            int index = 0;
            while (index < s.length()) {

                char ch = s.charAt(index);
                if (map.keySet().contains(ch)) {
                    stack.push(ch);
                } else {
                    Character top = null;
                    try {
                        top = stack.peek();
                    } catch (EmptyStackException ex) {

                    } finally {
                        if (top == null) {
                            return false;
                        } else if (map.get(top) == ch) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }

                index++;
            }

            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }

        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("["));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("({(){{}}})"));
        System.out.println(s.isValid("({(){{}}}){"));
    }
}
