/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.HashSet;

/**
 *
 * @author sekha
 */
public class SplitArrayConsecutiveSubSequence {
    public boolean isPossible(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        
        int index = 0;
        int numSequences = 0;
        HashSet<Integer> set = new HashSet<>();
        while(index < nums.length && numSequences < 3){
            if(set.size() == 3 ){
                set.clear();
                numSequences++;
            }
            set.add(nums[index++]);
        }
        
        numSequences = set.size() >= 3? numSequences+1:numSequences;
        return numSequences >= 3;
    }
}
