/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author sekha
 */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs == null || strs.length == 0){
            return null;
        }
        
        
        List<List<String> > result = new ArrayList<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String enc = encode(strs[i]);
            ArrayList <String> val = map.get(enc);
            if(val == null){
                val = new ArrayList<>();
                map.put(enc, val);
            }
            val.add(strs[i]);
        }
        
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        
        return result;
    }
    
    private String encode2(String s) {
        char [] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    private String encode(String s) {
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(Character key : map.keySet()){
            sb.append(key).append(map.get(key));
        }
        return sb.toString();
    }
    
    private String encode3(String s) {
        int [] count = new int [26];
        Arrays.fill(count, 0);
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<count.length;i++){
            sb.append('a'+i).append(count[i]);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        GroupAnagram ga = new GroupAnagram();
        List<List<String> > res = ga.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        
        for(List<String> list : res){
            for(String s : list){
                System.out.println(s + ",");
            }
            System.out.println("");
        }
    }
}
