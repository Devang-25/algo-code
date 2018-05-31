/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author mns
 */
public class CloneGraph {

    // Definition for undirected graph.
    static class UndirectedGraphNode {

        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

        @Override
        public int hashCode() {
            return (""+this.label).hashCode();
        }

        
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof UndirectedGraphNode){
                return this.label == ((UndirectedGraphNode)obj).label;
            }
            
            return false;
        }
        
        
    };
    
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }

}
