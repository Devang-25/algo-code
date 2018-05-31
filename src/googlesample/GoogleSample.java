/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlesample;

/**
 *
 * @author mns
 */
public class GoogleSample {
    
    private static class Solution {

        public void printArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }

        public int solution(int[] A) {
            if (A.length == 0) {
                return -1;
            }

            int totalSum = A[0];
            for (int i = 1; i < A.length; i++) {
                totalSum += A[i];
            }

            int leftSum = 0;
            int rightSum = totalSum;

            for (int i = 0; i < A.length; i++) {
                if (leftSum == rightSum - A[i]) {
                    return i;
                }
                leftSum += A[i];
                rightSum -= A[i];
            }

            return -1;

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
        Solution s = new Solution();
        System.out.println(s.solution(A));
    }

}
