/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;

/**
 *
 * @author mns
 */
class RandomListNode {

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};

public class DeepCopyRandomList {

    //Time limit exceeds....optimize tomorrow...now go to sleep
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head != null) {
            HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode curr = head;
            while (curr != null) {
                map.put(curr, new RandomListNode(curr.label));
                curr = curr.next;
            }

            curr = head;
            RandomListNode out = new RandomListNode(-1);
            RandomListNode result = out;

            while (curr != null) {
                RandomListNode currNew = map.get(curr);

                if (curr.random != null) {
                    currNew.random = map.get(curr.random);
                }
                if (curr.next != null) {
                    currNew.next = map.get(curr.next);
                }

                result.next = currNew;
                result = result.next;
                curr = curr.next;
            }

            return out.next;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        RandomListNode r5 = new RandomListNode(5);
        RandomListNode r6 = new RandomListNode(6);
        RandomListNode r7 = new RandomListNode(7);
        r1.next = r2;
        r1.random = r7;
        r2.next = r3;
        r2.random = r6;
        r3.next = r4;
        r3.random = r5;
        r4.next = r5;
        r4.random = r4;
        r5.next = r6;
        r5.random = r3;
        r6.next = r7;
        r6.random = r2;
        r7.next = null;
        r7.random = null;

        DeepCopyRandomList dcrl = new DeepCopyRandomList();
        RandomListNode rl = dcrl.copyRandomList(r1);
        
        while(rl !=null){
            if(rl.random == null)
                System.out.println(rl.label + " " + "NULL");
            else
                System.out.println(rl.label + " " + rl.random.label);
            rl = rl.next;
        }
    }
}
