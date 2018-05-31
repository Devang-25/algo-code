/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vmware;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author mns
 */
public class MinRemove {

    static int reductionCost(int[] num) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int cost = 0;
        if (num.length <= 1) {
            return cost;
        }
        for (int i = 0; i < num.length; i++) {
            q.add(num[i]);
        }

        while (q.size() > 1) {
            int ele = q.poll();
            int sele = q.poll();

            cost += ele + sele;
            q.add(ele + sele);
        }
        
        return cost;
    }
}
