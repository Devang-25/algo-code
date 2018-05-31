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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author sekha
 */
public class PermuteTwoArraysCorrect {
    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int q = ir.nextInt();

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        for (int i = 0; i < q; i++) {
            int n = ir.nextInt();
            int k = ir.nextInt();
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                int x = ir.nextInt();
                arr1.add(x);
            }

            for (int j = 0; j < n; j++) {
                int x = ir.nextInt();
                arr2.add(x);
            }

            Collections.sort(arr1,new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
           
            Collections.sort(arr2,new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            
            
            
            for(int j=0;j<n;j++){
                if(arr1.get(j) + arr2.get(j) < k){
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
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
