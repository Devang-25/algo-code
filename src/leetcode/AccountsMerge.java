/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mns
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String,Integer> countMap = new HashMap<>();
        int accountIndex = 0;
        for(List<String> account : accounts){
            int emailIndex = 0;
            int originalGroup = accountIndex;
            int newGroup = originalGroup;
            
            for(String email : account){
                if(emailIndex != 0){
                    if(map.containsKey(email)){
                        newGroup = map.get(email);
                    }else{
                        map.put(email, originalGroup);
                    }
                }
                
                emailIndex++;

            }
            
            if(originalGroup != newGroup){
                int index=0;
                
                for(String email : account){
                    if(index != 0) {
                        map.put(email,newGroup);
                    }
                    index++;
                }
                
            }
            
            accountIndex++;
        }
        
        HashMap <Integer,ArrayList<String> > revMap = new HashMap<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            ArrayList<String> group = revMap.get(entry.getValue());
            if(group == null){
                group = new ArrayList<>();
                revMap.put(entry.getValue(), group);
            }
            group.add(entry.getKey());
        }
        
        ArrayList<List<String> > result = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<String> > entry : revMap.entrySet()){
            List<String> group = new LinkedList<>();
            group.add(accounts.get(entry.getKey()).get(0));
            Collections.sort(entry.getValue());
            group.addAll(entry.getValue());
            result.add(group);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        AccountsMerge am = new AccountsMerge();
        ArrayList<List<String> > accounts = new ArrayList<>();
        List<String> account1 = new LinkedList<>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        List<String> account2 = new LinkedList<>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        List<String> account3 = new LinkedList<>(Arrays.asList("Mary","mary@mail.com"));
        List<String> account4 = new LinkedList<>(Arrays.asList("John","johnnybravo@mail.com"));
        
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        
        am.accountsMerge(accounts);
        
    }
}

