/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeed;

import java.util.ArrayList;

/**
 *
 * @author mns
 */
public class EmmaSquares {

    static int[] getMinimumUniqueSum(String[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            String[] nums = arr[i].split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);

            double sq1 = Math.ceil(Math.sqrt(num1));
            double sq2 = Math.floor(Math.sqrt(num2));

            list.add((int) (sq2 -sq1) +1);
        }

        int[] out = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            out[i] = list.get(i);
        }
        return out;

    }
}
