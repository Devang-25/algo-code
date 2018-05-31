/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.List;

/**
 *
 * @author mns
 */
public class NestedWeightSum {
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
    
    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumUtil(nestedList,1);
    }
    
    public int depthSumUtil(List<NestedInteger> nestedList, int currDepth) {
        int total = 0;
        if(nestedList != null){
            for( NestedInteger integer : nestedList){
                if(integer.isInteger()){
                    total+= currDepth*integer.getInteger();
                }else{
                    total+= depthSumUtil(integer.getList(),currDepth+1);
                }
            }
            
            return total;
        }
        return 0;
    }
}
