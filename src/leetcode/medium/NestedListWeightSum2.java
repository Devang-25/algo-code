/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.medium;

import java.util.List;

/**
 *
 * @author sekha
 */
public class NestedListWeightSum2 {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list

        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer 

        public List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxheight = depthSumUtilHeight(nestedList);
        return depthSumInverseUtil(nestedList, maxheight);
        
    }

    public int depthSumInverseUtil(List<NestedInteger> nestedList, int currHeight){
        if(currHeight == 0){
            return 0;
        }
        int total = 0;
        for (NestedInteger integer : nestedList) {
            if(!integer.isInteger()){
                total += depthSumInverseUtil(integer.getList(),currHeight-1);
            }else{
                total += integer.getInteger()*currHeight;
            }
        }
        return total;
    }
    
    public int depthSumUtilHeight(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) {
            return 0;
        }

        int maxDepth = 0;
        for (NestedInteger integer : nestedList) {
            if(!integer.isInteger()){
                maxDepth = Math.max(depthSumUtilHeight(integer.getList()),maxDepth);
            }
        }

        return 1+maxDepth;
    }
}
