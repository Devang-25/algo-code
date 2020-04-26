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
public class PrimeNumberBits {
    
     static boolean prime[] = null;
     
     static void generatePrimes() {
         for(int i=0;i<prime.length;i++){
             prime[i] = true;
         }
         
         prime[0]= false;
         prime[1]= false;
         prime[2] = true;
         for(int p=2; p*p < prime.length;p++){
             if(prime[p]){
                 for(int i=p*2;i<prime.length;i+=p){
                     prime[i] = false;
                 }
             }
         }
         
         
     }
     public int countPrimeSetBits(int L, int R) {
        
         if(prime == null){
             prime = new boolean[21];
             generatePrimes();
         }
         
         int cnt = 0;
         for(int i=L;i<=R;i++){
            int numOnes = numOnes(Integer.toBinaryString(i));
            if(prime[numOnes]){
                cnt++;
            }
        }
         
         return cnt;
    }
     
     private int numOnes (String str) {
         int cnt = 0;
         for(int i =0;i<str.length();i++){
             if(str.charAt(i) == '1'){
                 cnt++;
             }
         }
         
         return cnt;
     }
     
     public static void main(String[] args) {
        PrimeNumberBits p = new PrimeNumberBits();
         System.out.println(p.countPrimeSetBits(10, 15));
         System.out.println(p.countPrimeSetBits(6, 10));

    }
}
