/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.Stack;

/**
 *
 * @author mns
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String res = "";
        String digit = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                digit+=c;
            }else if(Character.isAlphabetic(c)){
                if(numStack.isEmpty()){
                    res += c;
                }else{
                    strStack.push(strStack.pop()+c);
                }
            }else if(c == '['){
                numStack.push(Integer.parseInt(digit));
                digit = "";
                strStack.push("");

            }else if(c ==']'){
                Integer topNum = numStack.pop();
                String topStr = strStack.pop();

                StringBuilder repeat = new StringBuilder();
                for(int j=0;j<topNum;j++){
                    repeat.append(topStr);
                }

                if(numStack.isEmpty()){
                    res += repeat.toString();
                }else {
                    strStack.push(strStack.pop() + repeat.toString());
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("3[a]2[b4[F]c]"));
        System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("2[abc]3[cd]ef"));
        System.out.println(ds.decodeString("2[a2[b3[c]]]"));
        System.out.println(ds.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(ds.decodeString("3[a]2[bc]"));

    }
}
