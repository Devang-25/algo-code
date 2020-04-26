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
public class IpToCidr {
    
    public List<String> ipToCIDR(String ip, int range) {
        String [] splits = ip.split("\\.");
        System.out.println(Arrays.toString(splits));
        int [] ipNums = new int [splits.length];
        for(int i=0;i<splits.length;i++){
            ipNums[i] = Integer.parseInt(splits[i]);
        }
        
        int ipsAssigned = 0;        
        while(ipsAssigned < range){
            int nextPower = (int)Math.pow(2, Math.floor(Math.log(ipNums[3])/Math.log(2)+1));
            ipsAssigned += nextPower - ipNums[3];
            ipNums[3] = nextPower;
            
            System.out.println(ipsAssigned);
            if(nextPower > 255){
                incrementIp(ipNums);
            }
            
        }
        return new ArrayList<>();
    }
    
    void incrementIp(int [] ipNums){
        int i=ipNums.length-1;
        while(ipNums[i] > 255){
                ipNums[i] = 0;
                ipNums[--i]++;
        }
    }
    
    public static void main(String[] args) {
        IpToCidr i = new IpToCidr();
        System.out.println(i.ipToCIDR("255.0.0.7", 2000));
    }
}
