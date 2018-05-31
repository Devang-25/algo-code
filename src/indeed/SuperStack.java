/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author mns
 */
public class SuperStack {

    static class Elem {

        public Elem(int i) {
            this.val = i;
        }
        int val;
    }

    public static void main(String args[]) throws Exception {
        InputReader ir = new InputReader(System.in);
        int n = ir.nextInt();

        LinkedList<Elem> stack = new LinkedList<Elem>();
        for (int i = 0; i < n; i++) {
            String cmd = ir.next();
            if (cmd.contentEquals("push")) {
                int num = ir.nextInt();
                stack.addFirst(new Elem(num));
            } else if (cmd.contentEquals("pop")) {
                stack.removeFirst();
            } else if (cmd.contentEquals("inc")) {
                int num = ir.nextInt();
                int num2 = ir.nextInt();

                int min = Math.min(stack.size(), num);

                Iterator<Elem> revIter = stack.descendingIterator();
                int cnt = 0;
                while (revIter.hasNext() && cnt++ < min) {
                    revIter.next().val -= num2;
                }
            }

            if (stack.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(stack.getFirst().val);
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
