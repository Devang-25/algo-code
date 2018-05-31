/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author sekha
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        
        if(numRows <=1){
            return s;
        }
        
        StringBuilder [] sb = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        
        char [] sArray = s.toCharArray();
        int currentSbIndex = 0;
        boolean forward = true;
        for(int i=0;i<sArray.length;i++){
            sb[currentSbIndex].append(sArray[i]);
            
            if(currentSbIndex == numRows-1){
                forward = false;
            }else if(currentSbIndex == 0){
                forward = true;
            }
            
            if(forward){
                currentSbIndex++;
            }else{
                currentSbIndex--;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(int i=0;i<sb.length;i++){
            result.append(sb[i].toString());
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("PAYPALISHIRING", 3));
        System.out.println(zzc.convert("AB", 1));
    }
}
