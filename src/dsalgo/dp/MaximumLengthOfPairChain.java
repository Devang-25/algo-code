package dsalgo.dp;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    public int findLongestChain(int [][] pairs){
        int [] dp = new int[pairs.length];
        Arrays.sort(pairs, (i,j) -> i[0] - j[0]);
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1] < pairs[i][0] ){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    max = Math.max(dp[i],max);
                }
            }
        }

        return max;
    }

//    public int findLongestChain(int[][] pairs) {
//        Arrays.sort(pairs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        if(pairs.length == 0) {
//            return 0;
//        }
//        int[] lastPair = pairs[0];
//        int max = 1;
//        for(int[] pair : pairs) {
//            if(pair[0] > lastPair[1]) {
//                lastPair = pair;
//                max++;
//            }
//        }
//        return max;
//    }

    public static void main(String[] args) {
        MaximumLengthOfPairChain mlp = new MaximumLengthOfPairChain();
        System.out.println(mlp.findLongestChain(new int[][]{
                {1,2},
                {2,3},
                {3,4}
        }));
        System.out.println(mlp.findLongestChain(new int[][]{
                {1,2},
                {3,4},
                {5,6}
        }));
        System.out.println(mlp.findLongestChain(new int[][]{
                {3,4},
                {2,3},
                {1,2}
        }));
    }
}
