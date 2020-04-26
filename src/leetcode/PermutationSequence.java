/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author mns
 */
public class PermutationSequence {

    private static long [] factorials= null;
    public String getPermutation(int n, int k) {
        if(factorials == null){
            generateFactorials();
        }
        StringBuilder permuteString = new StringBuilder();
        permute(permuteString, k, n);
        return permuteString.toString();
    }

    private void permute(StringBuilder sb , int k, int n){
        if(sb.length() == n){
            return;
        }else{
            int length = sb.length();
            long permutations = factorial(n-length-1);
            
            int currentNum = (k%permutations == 0 ? (int)(k/permutations): (int)(k/permutations)+1);
            int remaining = (int) (k- ((currentNum-1)*permutations));
            for(int i=1;i<=n;i++){
                if(sb.indexOf(Integer.toString(i)) ==-1 && currentNum >= 0){
                    
                    if(currentNum == 1){
                        sb.append(i);
                        break;
                    }else{
                        currentNum--;
                    }
                }
            }
            
            permute(sb,remaining,n);
        }
    }
    
    private static void generateFactorials(){
        factorials = new long[10];
        for(int i=0;i<factorials.length;i++){
            if(i==0 || i==1){
                factorials[i] = 1;
            }
            else{
                factorials[i] = i*factorials[i-1];
            }
        }
    }
    
    private long factorial(int k){
        return factorials[k];
    }
    
    
    

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(5,120));
    }
}
