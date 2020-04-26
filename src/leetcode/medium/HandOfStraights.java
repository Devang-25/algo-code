package leetcode.medium;

import java.util.PriorityQueue;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || W == 0 || hand.length % W != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : hand) {
            pq.offer(i);
        }

        int[][] group = new int[hand.length / W][2];

        /** Initialize the table
         * the first column stores the last card added to the group
         * the second column stores the total number of cards in the group
         */
        for (int i = 0; i < group.length; i++) {
            group[i][0] = Integer.MIN_VALUE;
            group[i][1] = 0;
        }

        int start = 0;
        while (!pq.isEmpty()) {
            int top = pq.peek();
            for (int i = start; i < group.length; i++) {
                //The current group is full
                if (group[i][1] == W) {
                    start++;
                    break;
                } else if (group[i][0] == top) {
                    // If the current group is not full but this card is already present, then try to add it to next group.
                    if (i == group.length - 1) {
                        return false;
                    }
                    continue;
                } else if (group[i][1] == 0 || group[i][0] == top - 1) {
                    // If the group is empty or current card is 1+ last card in the group, then add it to the group.
                    group[i][0] = top;
                    group[i][1] += 1;
                    pq.poll();
                    break;
                } else {
                    // If the card is something other than desired.
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        HandOfStraights hs = new HandOfStraights();
//        System.out.println(hs.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
//        System.out.println(hs.isNStraightHand(new int[]{1,2,3,4,5},3));
        System.out.println(hs.isNStraightHand(new int[]{0, 1}, 2));

    }
}
