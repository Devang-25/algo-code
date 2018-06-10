/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sekha
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
       
        if(S == null || S.length() == 0){
            return S;
        }
        
        String [] words = S.split(" ");
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','LoudAndRich','o','u'));
        for(int i=0;i<words.length;i++){
            if(vowels.contains(Character.toLowerCase(words[i].charAt(0)))){
                words[i] = words[i]+"ma";
            }else{
                words[i] = words[i].substring(1)+words[i].charAt(0)+"ma";
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<=i;j++){
                sb.append('a');
            }
            words[i] = words[i]+sb.toString();
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0;i<words.length;i++){
            res.append(words[i]);
            if(i != words.length-1){
                res.append(" ");
            }
        }
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        GoatLatin gl = new GoatLatin();
        System.out.println(gl.toGoatLatin("I speak Goat Latin"));
        System.out.println(gl.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
