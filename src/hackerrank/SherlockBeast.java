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
import java.util.StringTokenizer;

/**
 *
 * @author sekha
 */
public class SherlockBeast {

    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int t = ir.nextInt();

        while (t-- > 0) {
            StringBuilder sb = new StringBuilder();
            int n = ir.nextInt();
            
            int lhs = n;
            int rhs = 0;
            int flag = 1;
            while (lhs % 3 != 0 || rhs % 5 != 0) {
                lhs -= 1;
                rhs += 1;
                if (lhs < 0) {

                    flag = -1;
                    break;
                }
            }
            if (flag == -1) {
                System.out.println("-1");
            } else {
                for (int i = 0; i < lhs; i++) {
                    sb.append("5");
                }

                for (int i = 0; i < rhs; i++) {
                    sb.append("3");
                }
                System.out.println(sb.toString());
            }

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
