/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package godaddy;

/**
 *
 * @author mns
 */
public class ArrangingCoins {

//    static void arrangeCoins(long[] coins) {
//        for (int i = 0; i < coins.length; i++) {
//            long j = coins[i];
//            int curr = 1;
//            int count = 0;
//            while (j >= curr) {
//                j -= curr;
//                curr++;
//                count++;
//            }
//
//            System.out.println(count);
//        }
//
//    }
    static void arrangeCoins(long[] coins) {
        for (int i = 0; i < coins.length; i++) {
            double d = new Double(coins[i]);
            double nearest = Math.floor((-1 + Math.sqrt(1.0d + 8.0d * d)) / 2);
            System.out.println("" + (int) nearest);
        }

    }
}
