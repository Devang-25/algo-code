///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package hackerrank;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
///**
// *
// * @author mns
// */
//public class CuttingBoards {
//
//    public static void main(String[] args) {
//        InputReader reader = new InputReader(System.in);
//        int t = reader.nextInt();
//
//        for (int LoudAndRich = 0; LoudAndRich < t; LoudAndRich++) {
//            int m = reader.nextInt();
//            int n = reader.nextInt();
//
//            Integer[] marray = new Integer[m - 1];
//            Integer[] narray = new Integer[n - 1];
//
//            for (int j = 0; j < m - 1; j++) {
//                marray[j] = reader.nextInt();
//            }
//
//            for (int j = 0; j < n - 1; j++) {
//                narray[j] = reader.nextInt();
//            }
//
//            Arrays.sort(marray, (Integer o1, Integer o2) -> {
//                return o2 - o1;
//            });
//
//            Arrays.sort(narray, (Integer o1, Integer o2) -> {
//                return o2 - o1;
//            });
//
//            //System.out.println(Arrays.toString(marray));
//            int verCuts = 1, horCuts = 1;
//            int mi = 0;
//            int ni = 0;
//            int totalCost = 0;
//            while (mi < m - 1 && ni < n - 1) {
//                if (marray[mi] >= narray[ni]) {
//                    totalCost += (marray[mi] * verCuts)%1000000007;
//                    horCuts++;
//                    mi++;
//                } else {
//                    totalCost += (narray[ni] * horCuts)%1000000007;
//                    verCuts++;
//                    ni++;
//                }
//            }
//
//            if (mi == m - 1) {
//
//                for (int k = ni; k < n - 1; k++) {
//                    totalCost += (narray[ni] * horCuts)%1000000007;
//                    verCuts++;
//                }
//            }
//
//            if (ni == n - 1) {
//
//                for (int k = mi; k < m - 1; k++) {
//                    totalCost += (marray[mi] * verCuts)%1000000007;
//                    horCuts++;
//                }
//            }
//            System.out.println(totalCost%1000000007);
//        }
//    }
//
//    static class InputReader {
//
//        public BufferedReader reader;
//        public StringTokenizer tokenizer;
//
//        public InputReader(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//            tokenizer = null;
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        public float nextFloat() {
//            return Float.parseFloat(next());
//        }
//
//        public String nextLine() {
//            try {
//                return reader.readLine();
//            } catch (IOException ex) {
//                //Logger.getLogger(CuttingBoards.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return null;
//        }
//    }
//
//}

import java.io.*;
import java.util.*;

public class CuttingBoards{
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] input = br.readLine().split(" ");
            final int M = Integer.parseInt(input[0]) - 1;
            final int N = Integer.parseInt(input[1]) - 1;
            final int[] Ys = strToArr(M, br.readLine());
            final int[] Xs = strToArr(N, br.readLine());
            
            //SOLVE
            Arrays.sort(Xs);
            Arrays.sort(Ys);
            
            int vSegs = 1;
            int hSegs = 1;
            int y = M - 1;
            int x = N - 1;
            long cost = 0L;
            
            while (x >= 0 && y >= 0){
                if (Xs[x] > Ys[y]){
                    ++vSegs;
                    cost = (cost + ((long)Xs[x--])*hSegs)%MOD;
                } else {
                    ++hSegs;
                    cost = (cost + ((long)Ys[y--])*vSegs)%MOD;
                }
                
            }
            while (x >= 0){
                cost = (cost + ((long)Xs[x--])*hSegs)%MOD;
            }
            while (y >= 0){
                cost = (cost + ((long)Ys[y--])*vSegs)%MOD;
            }
            
            //OUTPUT
            sb.append(cost + "\n");
        }
        System.out.print(sb);
    }
    private static int[] strToArr(int n, String line){
        int[] arr = new int[n];
        String[] Vs = line.split(" ");
        while (n-- > 0){
            arr[n] = Integer.parseInt(Vs[n]);
        }
        return arr;
    }
}
