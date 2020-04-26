/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlesample;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mns
 */
public class CutSticks {

    static int[] cutSticks(int[] lengths) {

        if (lengths.length > 1) {
            ArrayList<Integer> result = new ArrayList<>();
            Arrays.sort(lengths);
            System.out.println(Arrays.toString(lengths));
            int startIndex = 0;
            while (lengths[startIndex] == 0) {
                startIndex++;
            }
            int sumReduced = 0;
            while (startIndex < lengths.length) {

                if (lengths[startIndex] - sumReduced == 0) {
                    startIndex++;
                } else {
                    sumReduced += (lengths[startIndex] - sumReduced);
                    result.add(lengths.length - startIndex);
                    System.out.println(lengths.length - startIndex);
                    startIndex++;
                }
            }

            int[] res = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }

            return res;
        } else if (lengths.length == 1) {
            return new int[]{1};
        } else {
            return new int[]{};
        }
    }

    public static void fx(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }

        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        fx(new int[]{0, 1, 0, 3, 12});
    }
}
