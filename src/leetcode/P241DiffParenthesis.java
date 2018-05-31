package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sekha
 */
public class P241DiffParenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        
        Set<Integer> out = new HashSet<>();
        if(input == null || input.length() == 0){
            return Arrays.asList(out.toArray(new Integer[]{}));
        }
        
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        
        int i=0,l=0;
        for(i=0;i<input.length();i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                operators.add(input.charAt(i));
                numbers.add(Integer.parseInt(input.substring(l, i)));
                l=(i+1);
            }
        }
        numbers.add(Integer.parseInt(input.substring(l,i)));
        return diffWaysToComputeUtil(numbers,operators,0,numbers.size()-1);
    }
    
    private ArrayList<Integer> diffWaysToComputeUtil(ArrayList<Integer> numbers , ArrayList<Character> operators , int l,int r){
        ArrayList<Integer> comb = new ArrayList<>();
        if(r == l){
            comb.add(numbers.get(l));
            return comb;
        }else if(r - l == 1){
            comb.add(operation(numbers.get(l), numbers.get(r), operators.get(l)));
            return comb;
        }
        
        for(int i=l;i<r;i++){
            ArrayList<Integer> left = diffWaysToComputeUtil(numbers,operators,l,i);
            ArrayList<Integer> right = diffWaysToComputeUtil(numbers,operators,i+1,r);
            
            for(Integer x : left){
                for(Integer y : right){
                    comb.add(operation(x,y,operators.get(i)));
                }
            }
        }
        
        return comb;
    }
    
    int operation(int l, int r , char op){
        switch(op){
            case '+' :
                return l+r;
            case '-':
                return l-r;
            case '*' :
                return l*r;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        P241DiffParenthesis p = new P241DiffParenthesis();
        System.out.println(p.diffWaysToCompute("2-1-1").toString());
        System.out.println(p.diffWaysToCompute("2*3-4*5").toString());
    }
}
