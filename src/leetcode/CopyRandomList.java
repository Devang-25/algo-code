/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;

/**
 *
 * @author mns
 */
public class CopyRandomList {

    static class RandomListNode {

        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };

    private HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        return deepCopy(head);
    }
    
    private RandomListNode deepCopy(RandomListNode node){
        if(node == null){
            return null;
        }
        
        RandomListNode nodeCopy = map.get(node);
        if(nodeCopy == null){
            nodeCopy = new RandomListNode(node.label);
            map.put(node, nodeCopy);
            
            nodeCopy.next = deepCopy(node.next);
            nodeCopy.random = deepCopy(node.random);
        }
        return nodeCopy;
    }
}
