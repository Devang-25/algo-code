/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mns
 */
public class SubDomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0;i<cpdomains.length;i++){
            String [] splits1 = cpdomains[i].split(" ");
            String [] splits2 = splits1[1].split("\\.");
            String key = "";
            for(int j=splits2.length-1;j>=0;j--){
                if(key.isEmpty()){
                    key = splits2[j];
                }else{
                    key = splits2[j]+ "." + key;
                }
                
                Integer cnt = map.get(key);
                if(cnt == null){
                    map.put(key, Integer.parseInt(splits1[0]));
                }else{
                    map.put(key, cnt + Integer.parseInt(splits1[0]));
                }
            }
            
        }
        
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            list.add(entry.getValue() + " " + entry.getKey());
        }
        
        return list;
    }
    
}
