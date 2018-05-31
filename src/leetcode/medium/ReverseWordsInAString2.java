/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

/**
 *
 * @author sekha
 */
public class ReverseWordsInAString2 {
    public void reverseWords(char[] str) {
        if(str == null || str.length == 0){
            return;
        }
        
        reverse(str,0,str.length-1);
        int left = 0, right=0;
        
        while(left < str.length && right < str.length){
            while(left < str.length && isSpace(str[left])){
                left++;
            }
            right = left;
            while(right < str.length && !isSpace(str[right])){
                right++;
            }
            reverse(str,left,right-1);
            left= right;
        }
        
        left = 0; right = 0;
        
        while(right < str.length && isSpace(str[right])){
            right++;
        }
        
        str[left] = str[right];
        right++;
        
        while(left < str.length && right < str.length){
            if(isSpace(str[left]) && isSpace(str[right])){
            }else{
                str[++left] = str[right];
            }
            right++;
        }
    }
    
    public boolean isSpace(char c){
        return c=='\t' || c=='\n' || c==' ';
    }
    public void reverse(char [] str, int s, int e){
       
        while(s < e){
            char temp = str[s];
            str[s] = str[e];
            str[e] = temp;
            s++;
            e--;
        }
    }
    
    public static void main(String[] args) {
        ReverseWordsInAString2 r = new ReverseWordsInAString2();
        char [] test ="".toCharArray();
        r.reverseWords(test);
        System.out.println(new String(test));
    }
}
