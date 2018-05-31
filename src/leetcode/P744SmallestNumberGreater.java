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
public class P744SmallestNumberGreater {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        int mid = (left+right)/2;
        while(left <= right){
            mid = left + (right-left)/2;
            if(left == right){
                break;
            }
            if(letters[mid] > target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        if(letters[mid] > target){
            return letters[mid];
        }else{
            return letters[0];
        }
        
    }
    
    public static void main(String[] args) {
        P744SmallestNumberGreater p = new P744SmallestNumberGreater();
        System.out.println(p.nextGreatestLetter(new char[] {'a','b'},'z' ));
        System.out.println(p.nextGreatestLetter(new char[] {'c','f','j'},'a' ));
        System.out.println(p.nextGreatestLetter(new char[] {'c','f','j'},'c' ));
        System.out.println(p.nextGreatestLetter(new char[] {'c','f','j'},'d' ));
        System.out.println(p.nextGreatestLetter(new char[] {'c','f','j'},'g' ));
        System.out.println(p.nextGreatestLetter(new char[] {'c','f','j'},'j' ));
        System.out.println(p.nextGreatestLetter(new char[] {'c','f','j'},'k' ));
    }
}
