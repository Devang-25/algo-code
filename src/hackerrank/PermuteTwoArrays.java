/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author sekha
 * sum exactly equals k
 */
public class PermuteTwoArrays {

    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int q = ir.nextInt();

        HashMap<Integer, Integer> arr1 = new HashMap<>();
        HashMap<Integer, Integer> arr2 = new HashMap<>();

        for (int i = 0; i < q; i++) {
            int n = ir.nextInt();
            int k = ir.nextInt();
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                int x = ir.nextInt();
                Integer val = arr1.get(x);
                if (val == null) {
                    arr1.put(x, 1);
                } else {
                    arr1.put(x, val + 1);
                }
            }

            for (int j = 0; j < n; j++) {
                int x = ir.nextInt();
                Integer val = arr2.get(x);
                if (val == null) {
                    arr2.put(x, 1);
                } else {
                    arr2.put(x, val + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : arr1.entrySet()) {
                if (arr2.get(k - entry.getKey()) != null) {
                    if (arr2.get(k - entry.getKey()) == entry.getValue()) {
                        arr2.put(k-entry.getKey(),0);
                    } else {
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                } else {
                    System.out.println("NO");
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                System.out.println("YES");
            }
            
            arr1.clear();
            arr2.clear();

        }
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(CuttingBoards.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }
}
