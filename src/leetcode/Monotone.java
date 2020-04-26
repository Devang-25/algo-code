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
public class Monotone {
    public int monotoneIncreasingDigits2(int N) {
        int i = N;
        while(i > 0){
            if(isMonotonic(i)){
                return i;
            }
            i--;
        }
        return 0;
    }
    
    private boolean isMonotonic(int i) {
        String s = Integer.toString(i);
        if(s.length() == 1){
            return true;
        }else{
            for(int j=1;j<s.length();j++){
                if(s.charAt(j) < s.charAt(j-1))
                    return false;
            }
            
            return true;
        }
    }
    
     public int monotoneIncreasingDigits(int N) {
         String numString = Integer.toString(N);
         int [] num = new int[numString.length()];
         for(int i=0;i<num.length;i++){
             num[i] = numString.charAt(i) - '0';
         }
         
         
         for(int i=num.length-1;i>0;i--){
             if(num[i] < num[i-1]){
                 num[i-1] = num[i-1] > 0 ? num[i-1]-1 : 9;
                 num[i] = 9;
                 for(int j=i+1;j<num.length;j++){
                     num[j] = 9;
                 }
             }
         }
         
         int result = 0;
         int pow = 0;
         
         for(int i=num.length-1;i>=0;i--){
             result += num[i]*Math.pow(10,pow++);
         }
         
         return result;
     }
     
    public static void main(String[] args) {
        Monotone m = new Monotone();
        System.out.println(m.monotoneIncreasingDigits(462198634));
         System.out.println(m.monotoneIncreasingDigits2(462198634));
         
          System.out.println(m.monotoneIncreasingDigits(999999998));
         System.out.println(m.monotoneIncreasingDigits2(999999998));
        
    }
}
