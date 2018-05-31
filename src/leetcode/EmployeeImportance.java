/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author mns
 */
public class EmployeeImportance {
    
    class Employee{
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
       
    }
    
    public int getImportance(List<Employee> employees, int id){
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for( Employee e : employees){
            if(!map.containsKey(e.id)){
                map.put(e.id, e);
            }
        }
        
        Queue<Integer> bfsq = new LinkedList<>();
        bfsq.add(id);
        int totalImportance = 0;
        
        while(!bfsq.isEmpty()){
            Employee curr = map.get(bfsq.poll());
            totalImportance += curr.importance;
            if(curr != null){
                for( Integer e : curr.subordinates){
                    bfsq.add(e);
                }
            }
        }
        
        return totalImportance;
    }
    
    public static void main(String[] args) {
        
    }
}
