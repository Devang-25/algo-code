/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class ReverseWords3 {
    public String reverseWords(String s) {
        String []  items = s.split(" ");
        String result = "";
        for(int i=0;i<items.length;i++){
            result += new StringBuilder(items[i]).reverse().toString() + " ";
        }
        
        return result.trim();
    }
    
    public static void main(String[] args) {
        ReverseWords3 r = new ReverseWords3();
        System.out.println(r.reverseWords("Let's take LeetCode contest"));
    }
   
}
