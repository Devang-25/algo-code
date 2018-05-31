/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

/**
 *
 * @author sekha
 */
public class NumLinesToWriteString {
     public int[] numberOfLines(int[] widths, String S) {
      
        int used = 0;
        int currLine = 1;
        for(int i=0 ;i<S.length();i++){
            if(widths[S.charAt(i)-'a'] > 100-used){
                used = widths[S.charAt(i)-'a'];
                currLine++;
            }else{
                used += widths[S.charAt(i)-'a'];
            }
        }
        return new int[] {currLine,used};
     }
     
     public static void main(String[] args) {
        NumLinesToWriteString n = new NumLinesToWriteString();
         int [] result = n.numberOfLines(new int [] {
         10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},"abcdefghijklmnopqrstuvwxyz");
         System.out.println(result[0] +" "+result[1]);
    }
}
