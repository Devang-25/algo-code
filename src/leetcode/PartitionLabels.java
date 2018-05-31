/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sekha
 */
public class PartitionLabels {
    
    class Partition{
        int start;
        int end;
        
        public Partition(int s,int e){
            this.start = s;
            this.end = e;
        }
    }
   public List<Integer> partitionLabels(String S) {
        
       ArrayList<Partition> pList = new ArrayList<>();
       for(int i=0;i<S.length();i++){
            int index = S.lastIndexOf(Character.toString(S.charAt(i)));
            boolean flag = false;
           
            for(int j=0;j<pList.size() && !flag;j++){
                if(i <= pList.get(j).end){
                    
                    if(index > pList.get(j).end){
                        pList.get(j).end = index;
                    }
                    flag = true;
                }
            }
            
            if(!flag){
                pList.add(new Partition(i,index));
            }
        }
       
       ArrayList<Integer> result = new ArrayList<>();
       for(int i=0;i<pList.size();i++){
           Partition p = pList.get(i);
           result.add(p.end - p.start + 1);
       }
       
       return result;
    } 
   
    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
//        List<Integer> l = pl.partitionLabels("ababcbacadefegdehijhklij");
//        for(Integer i : l){
//            System.out.println(i);
//        }
        List<Integer> l = pl.partitionLabels("abcdefghijklmno");
        for(Integer i : l){
            System.out.println(i);
        }
    }
}
