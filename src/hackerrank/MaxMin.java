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
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author sekha
 */
public class MaxMin {
    public static void main(String[] args) {
       InputReader ir = new InputReader(System.in);
       int N = ir.nextInt();
       int k = ir.nextInt();
       int[] list = new int[N];
       for(int i=0;i<N;i++){
           list[i] = ir.nextInt();
       }
       
       Arrays.sort(list);
       //System.out.println(Arrays.toString(arr));
       
       int unfairness = Integer.MAX_VALUE;
       for(int i=0;i+k-1<N;i++){
           if(list[i+k-1] - list[i] < unfairness){
               unfairness = list[i+k-1] - list[i]; 
           }
       }
       
        System.out.println(unfairness);
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
