/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class JewelsStones {
    
    public int numJewelsInStones(String J, String S) {
        
        char [] arr = J.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char c : arr){
            set.add(c);
        }
        
        int cnt = 0;
        for(int i=0;i<S.length();i++){
            if(set.contains(S.charAt(i))){
                cnt++;
            }
        }
        
        return cnt;
    }
}
