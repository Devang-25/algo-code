package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sekharan on 3/10/17.
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        HashSet<String> uniqCombinations = new HashSet<>();
        LinkedList<String> combQueue = new LinkedList<>();
        if(n >= 1) {
            combQueue.offer("()");
            uniqCombinations.add("()");

            String top = combQueue.peek();
            while (!combQueue.isEmpty() && top.length() < 2 * n) {
                for (int i = 0; i < top.length(); i++) {
                    StringBuilder sb = new StringBuilder(top);
                    sb.insert(i, "()");
                    if (!uniqCombinations.contains(sb.toString())) {
                        uniqCombinations.add(sb.toString());
                        combQueue.offer(sb.toString());
                    }
                }

                combQueue.poll();
                top = combQueue.peek();
            }
        }
        return (combQueue);
    }

    public List<String> generateParenthesisOptimized(int n) {
        HashSet<String> uniqCombinations = new HashSet<>();
        LinkedList<String> combQueue = new LinkedList<>();
        if(n >= 1) {
            combQueue.offer("()");

            String top = combQueue.peek();
            while (!combQueue.isEmpty() && top.length() < 2 * n) {
                uniqCombinations.clear();
                uniqCombinations.addAll(combQueue);

                for (int i = 0; i < top.length(); i++) {
                    StringBuilder sb = new StringBuilder(top);
                    sb.insert(i, "()");
                    if (!uniqCombinations.contains(sb.toString())) {
                        uniqCombinations.add(sb.toString());
                        combQueue.offer(sb.toString());
                    }
                }

                combQueue.poll();
                top = combQueue.peek();
            }
        }
        return (combQueue);
    }


    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        System.out.println(gp.generateParenthesis(5).toString());
        System.out.println(gp.generateParenthesisOptimized(5).toString());
    }
}
